package mx.ihsa.videoclub.element;

import org.zkoss.zul.Toolbarbutton;

/**
 * Botón para una barra de navegación.
 * @author mrojas
 */
public class ToolbarButton extends Toolbarbutton {
    
    private static final long serialVersionUID = 1L;
	
	private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public ToolbarButton() {
        super();
        setWidth("32px");
        setHeight("32px");
        setStyle("text-align : center; vertical-align: middle;");
    }
    
}
