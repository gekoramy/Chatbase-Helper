package gekoramy.chatbase.model.CustomEvent.property;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author Luca Mosetti
 * @since 02/2018
 */
@XmlRootElement
public class PropertyBoolean extends AbsProperty {

    /**
     * <required>
     */
    private boolean bool_value;

    public PropertyBoolean(String property_name, boolean bool_value) {
        this.property_name = property_name;
        this.bool_value = bool_value;
    }

    public boolean isBool_value() {
        return bool_value;
    }

    public void setBool_value(boolean bool_value) {
        this.bool_value = bool_value;
    }
}
