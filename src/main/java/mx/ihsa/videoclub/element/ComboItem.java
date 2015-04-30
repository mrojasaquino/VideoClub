package mx.ihsa.videoclub.element;

import org.zkoss.zul.Comboitem;

/**
 *
 * @author mrojas
 */
public class ComboItem extends Comboitem {
    
    public ComboItem(String label, Object value) {
        super(label);
        setValue(value);
    }
}
