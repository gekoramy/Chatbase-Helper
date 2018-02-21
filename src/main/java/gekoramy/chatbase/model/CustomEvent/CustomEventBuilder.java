package gekoramy.chatbase.model.CustomEvent;

import gekoramy.chatbase.model.CustomEvent.property.AbsProperty;

import java.util.List;

/**
 * @author Luca Mosetti
 * @since 02/2018
 */
public class CustomEventBuilder {
    private String api_key;
    private String user_id;
    private String intent;
    private int timestamp_millis;
    private String platform;
    private String version;
    private List<AbsProperty> properties;

    public CustomEventBuilder setApi_key(String api_key) {
        this.api_key = api_key;
        return this;
    }

    public CustomEventBuilder setUser_id(String user_id) {
        this.user_id = user_id;
        return this;
    }

    public CustomEventBuilder setIntent(String intent) {
        this.intent = intent;
        return this;
    }

    public CustomEventBuilder setTimestamp_millis(int timestamp_millis) {
        this.timestamp_millis = timestamp_millis;
        return this;
    }

    public CustomEventBuilder setPlatform(String platform) {
        this.platform = platform;
        return this;
    }

    public CustomEventBuilder setVersion(String version) {
        this.version = version;
        return this;
    }

    public CustomEventBuilder setProperties(List<AbsProperty> properties) {
        this.properties = properties;
        return this;
    }

    public CustomEvent build() {
        return new CustomEvent(api_key, user_id, intent, timestamp_millis, platform, version, properties);
    }
}