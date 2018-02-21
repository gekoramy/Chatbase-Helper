package gekoramy.chatbase.model.CustomEvent.property;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author Luca Mosetti
 * @since 02/2018
 */
@XmlRootElement
public class PropertyInteger extends AbsProperty {

    /**
     * <required>
     */
    private int integer_value;

    public PropertyInteger(String property_name, int integer_value) {
        this.property_name = property_name;
        this.integer_value = integer_value;
    }

    public int getInteger_value() {
        return integer_value;
    }

    public void setInteger_value(int integer_value) {
        this.integer_value = integer_value;
    }
}
