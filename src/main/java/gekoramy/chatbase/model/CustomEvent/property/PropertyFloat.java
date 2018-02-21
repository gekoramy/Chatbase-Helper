package gekoramy.chatbase.model.CustomEvent.property;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author Luca Mosetti
 * @since 02/2018
 */
@XmlRootElement
public class PropertyFloat extends AbsProperty {

    /**
     * <required>
     */
    private float float_value;

    public PropertyFloat(String property_name, float float_value) {
        this.property_name = property_name;
        this.float_value = float_value;
    }

    public float getFloat_value() {
        return float_value;
    }

    public void setFloat_value(float float_value) {
        this.float_value = float_value;
    }
}
