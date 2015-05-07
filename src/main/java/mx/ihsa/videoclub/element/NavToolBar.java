package mx.ihsa.videoclub.element;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zul.Toolbar;

/**
 * Barra de navegación. La convención utilizada es que el suscriptor implementa
 * la interfaz {@link ToolbarListener} y se invocan los métodos definidos en dicha
 * interfaz en el susciptor por medio de reflexión en base al nombre del botón.
 * Para ello cada botón tiene un nombre que inicia con "btn" y el nombre de la
 * acción con el que estaría relacionado dicho botón, por lo que en el suscriptor
 * que reciba los eventos existirá un método que inica con "on" y el nombre del
 * botón:
 * 
 * <ul>
 *   <li>El botón se llama <code>btnFirst</code></li>
 *   <li>El método a invocar en el susciptor será <code>onFirst</code></li>
 * </ul>
 * @author mrojas
 */
public class NavToolBar extends Toolbar implements EventListener<Event> {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private final List<ToolbarListener> listeners = new ArrayList<>();
    private final static Logger LOGGER = Logger.getLogger(NavToolBar.class.getName());
    
    private ToolbarButton btnFirst;
    private ToolbarButton btnPrevious;
    private ToolbarButton btnNext;
    private ToolbarButton btnLast;
    
    
    
    public NavToolBar() {
        super();
        init();
    }
    
    
    private void init() {
        
        btnFirst = buildButton("First", "|<", "Inicio");
        btnPrevious = buildButton("Previous", "<", "Anterior");
        btnNext = buildButton("Next", ">", "Siguiente");
        btnLast = buildButton("Last", ">|", "Last");
        
        for (Object obj : this.getChildren()) {
            if (obj instanceof ToolbarButton) {
                ((ToolbarButton)obj).addEventListener(Events.ON_CLICK, this);
                ((ToolbarButton)obj).setDisabled(true);
            }
        }
        
        setWidth("100%");
    }
    
    @Override
    public void onEvent(Event event) throws Exception {
        String eventName = event.getName();
        
        if(eventName.equals(Events.ON_CLICK)) {
            if(event.getTarget() instanceof ToolbarButton) {
            	doOnClick(event);
            }
        }
    }

    private void doOnClick(Event event) {
        ToolbarButton cComponent = (ToolbarButton) event.getTarget();

        if (!cComponent.isDisabled()) {

            String compName = cComponent.getName();
            String methodName = "on" + compName.substring(3);
            Iterator<ToolbarListener> listenerIter = listeners.iterator();

            while (listenerIter.hasNext()) {
                try {
                    
                    ToolbarListener tListener = listenerIter.next();
                    
                    Method method = 
                            tListener.getClass().getMethod(methodName, (Class[]) null);
                    method.invoke(tListener, (Object[]) null);
                    
                } catch (SecurityException | NoSuchMethodException 
                        | IllegalArgumentException | IllegalAccessException 
                        | InvocationTargetException e) {
                    LOGGER.log(Level.SEVERE, null, e);
                }
            }
        }
    }
    
    public void addListener(ToolbarListener toolbarListener) {
        listeners.add(toolbarListener);
    }

    public void removeListener(ToolbarListener toolbarListener) {
        listeners.remove(toolbarListener);
    }
    
    
    private ToolbarButton buildButton(String name, String glyph, String tooltip) {
        ToolbarButton btn = new ToolbarButton();
        btn.setLabel(glyph);
        btn.setName("btn"+name);
        btn.setTooltiptext(tooltip);
        appendChild(btn);
        return btn;
    }
    
    
    public void enableNavigation(boolean enabled){
        btnFirst.setDisabled(!enabled);
        btnPrevious.setDisabled(!enabled);
        btnNext.setDisabled(!enabled);
        btnLast.setDisabled(!enabled);
    }
    
    public void enableFirstNavigation(boolean enabled) {
        btnFirst.setDisabled(!enabled);
        btnPrevious.setDisabled(!enabled);
    }

    public void enableLastNavigation(boolean enabled){
        btnLast.setDisabled(!enabled);
        btnNext.setDisabled(!enabled);
    }
}
