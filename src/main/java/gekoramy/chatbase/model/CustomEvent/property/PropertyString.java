package gekoramy.chatbase.model.CustomEvent.property;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author Luca Mosetti
 * @since 02/2018
 */
@XmlRootElement
public class PropertyString extends AbsProperty {

    /**
     * <required>
     */
    private String string_value;

    public PropertyString(String property_name, String string_value) {
        this.property_name = property_name;
        this.string_value = string_value;
    }

    public String getString_value() {
        return string_value;
    }

    public void setString_value(String string_value) {
        this.string_value = string_value;
    }
}
