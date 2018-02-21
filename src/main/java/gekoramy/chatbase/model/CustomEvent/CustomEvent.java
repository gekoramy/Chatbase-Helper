package gekoramy.chatbase.model.CustomEvent;

import gekoramy.chatbase.model.CustomEvent.property.AbsProperty;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

/**
 * @author Luca Mosetti
 * @since 02/2018
 */
@XmlRootElement
public class CustomEvent {

    /**
     * <required> the Chatbase ID of the bot
     */
    private String api_key;

    /**
     * <required> the ID of the end-user
     */
    private String user_id;

    /**
     * <required> The type of activity this event is capturing.
     * Events are primarily grouped and analyzed by this field,
     * so events that have the same meaning or purpose should have the same intent set.
     */
    private String intent;

    /**
     * <optional> The timestamp at which this event occurred on your system, measured in milliseconds since the epoch.
     * If this field is not set, Chatbase will generate this value based on when the event was received.
     * Must be within previous 30 days.
     */
    private int timestamp_millis;

    /**
     * <optional> The platform where this interaction took place, if applicable.
     * It may be useful to report the platform that your other interactions with this user take place.
     */
    private String platform;

    /**
     * <optional> The version of code your agent is running when reporting this event.
     */
    private String version;

    /**
     * <required> A list of properties to attach to this event.
     * Events can be filtered and grouped by these properties, so you may wish to attach interesting metadata here.
     */
    private List<AbsProperty> properties;

    CustomEvent(String api_key, String user_id, String intent, int timestamp_millis, String platform, String version, List<AbsProperty> properties) {
        this.api_key = api_key;
        this.user_id = user_id;
        this.intent = intent;
        this.timestamp_millis = timestamp_millis;
        this.platform = platform;
        this.version = version;
        this.properties = properties;
    }

    public String getApi_key() {
        return api_key;
    }

    public void setApi_key(String api_key) {
        this.api_key = api_key;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getIntent() {
        return intent;
    }

    public void setIntent(String intent) {
        this.intent = intent;
    }

    public int getTimestamp_millis() {
        return timestamp_millis;
    }

    public void setTimestamp_millis(int timestamp_millis) {
        this.timestamp_millis = timestamp_millis;
    }

    public String getPlatform() {
        return platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public List<AbsProperty> getProperties() {
        return properties;
    }

    public void setProperties(List<AbsProperty> properties) {
        this.properties = properties;
    }
}
