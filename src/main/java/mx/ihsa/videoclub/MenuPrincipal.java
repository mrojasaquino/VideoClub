package mx.ihsa.videoclub;

import java.util.ArrayList;
import java.util.List;

import mx.ihsa.videoclub.data.FilmDao;
import mx.ihsa.videoclub.util.LabelValueBean;

import org.matica.zkdata.ChartAxis;
import org.matica.zkdata.ChartData;
import org.matica.zkdata.MaPoint;
import org.matica.zkflot.MaChart;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zul.Borderlayout;
import org.zkoss.zul.Center;
import org.zkoss.zul.East;
import org.zkoss.zul.Label;
import org.zkoss.zul.North;
import org.zkoss.zul.South;
import org.zkoss.zul.Toolbar;
import org.zkoss.zul.Toolbarbutton;
import org.zkoss.zul.Vbox;
import org.zkoss.zul.West;
import org.zkoss.zul.Window;

/**
 *
 * @author mrojas
 */
public class MenuPrincipal extends Window {
    
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	private Borderlayout mainLayout;
    private North cabecera;
    private South pie;
    private Center cuerpo;
    private East der;
    private West izq;
    
    private MainArea mainArea;
    
    public MenuPrincipal() {
        init();
    }
    
    private void init() {
        setWidth("100%");
        setHeight("100%");
        
        mainLayout = new Borderlayout();
        
        cabecera = new North();
        cabecera.setClass("cabecera");
        cabecera.setHeight("40px");
        
        Label titulo = new Label("VideoIHSA, Su mejor opción en diversión.");
        cabecera.appendChild(titulo);
        buildCuerpo();
        
        pie = new South();
        der = new East();
        
        buildIzq();
        
        mainLayout.appendChild(cabecera);
        mainLayout.appendChild(cuerpo);
        mainLayout.appendChild(pie);
        mainLayout.appendChild(izq);
        mainLayout.appendChild(der);
        
        appendChild(mainLayout);
    }
    
    
    private void buildCuerpo() {
        cuerpo = new Center();
        
        mainArea = new MainArea();
        
        cuerpo.appendChild(mainArea);
    }
    
    private void buildIzq() {
        izq = new West();
        izq.setWidth("80px");
        izq.setSplittable(true);
        
        Toolbar toolBar = new Toolbar("vertical");
        Toolbarbutton button = new Toolbarbutton("Categorias");
        button.setClass("toolbar-button");
        toolBar.appendChild(button);
        button.addEventListener(Events.ON_CLICK, new EventListener<Event>() {
            @Override
            public void onEvent(Event event) throws Exception {
                openWindow(new VentanaCategory());
            }
        });
        
        button = new Toolbarbutton("Películas");
        button.setClass("toolbar-button");
        toolBar.appendChild(button);
        button.addEventListener(Events.ON_CLICK, new EventListener<Event>() {
            @Override
            public void onEvent(Event event) throws Exception {
                openWindow(new VentanaFilm());
            }
        });
        
        
        button = new Toolbarbutton("Editar Categoría");
        button.setClass("toolbar-button");
        toolBar.appendChild(button);
        button.addEventListener(Events.ON_CLICK, new EventListener<Event>() {
            @Override
            public void onEvent(Event event) throws Exception {
                openWindow(new Categories());
            }
        });
        
        button = new Toolbarbutton("Editar Película");
        button.setClass("toolbar-button");
        toolBar.appendChild(button);
        button.addEventListener(Events.ON_CLICK, new EventListener<Event>() {
            @Override
            public void onEvent(Event event) throws Exception {
                openWindow(new Films());
            }
        });
        
        
        izq.appendChild(toolBar);
    }
    
    
    private void openWindow(Window ventana) {
        ventana.setPage(this.getPage());
        ventana.setPosition("center");
        ventana.doModal();
    }
}
