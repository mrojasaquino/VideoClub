package mx.ihsa.videoclub.element;

import org.zkoss.zul.Comboitem;

/**
 *
 * @author mrojas
 */
public class ComboItem extends Comboitem {
    
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ComboItem(String label, Object value) {
        super(label);
        setValue(value);
    }
}
