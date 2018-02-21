package gekoramy.chatbase.model.CustomEvent.property;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author Luca Mosetti
 * @since 02/2018
 */
@XmlRootElement
public abstract class AbsProperty {

    /**
     * <required> The name of the property.
     */
    String property_name;

    public String getProperty_name() {
        return property_name;
    }

    public void setProperty_name(String property_name) {
        this.property_name = property_name;
    }

}
