package gekoramy.chatbase.model.GenericMessage;

/**
 * @author Luca Mosetti
 * @since 02/2018
 */
public class GenericMessageAgentBuilder {
    private String api_key;
    private String type = Type.AGENT.getType();
    private String user_id;
    private long time_stamp;
    private String platform;
    private String message;
    private String version;
    private String custom_session_id;

    public GenericMessageAgentBuilder setApi_key(String api_key) {
        this.api_key = api_key;
        return this;
    }

    public GenericMessageAgentBuilder setUser_id(String user_id) {
        this.user_id = user_id;
        return this;
    }

    public GenericMessageAgentBuilder setTime_stamp(long time_stamp) {
        this.time_stamp = time_stamp;
        return this;
    }

    public GenericMessageAgentBuilder setPlatform(String platform) {
        this.platform = platform;
        return this;
    }

    public GenericMessageAgentBuilder setMessage(String message) {
        this.message = message;
        return this;
    }

    public GenericMessageAgentBuilder setVersion(String version) {
        this.version = version;
        return this;
    }

    public GenericMessageAgentBuilder setCustom_session_id(String custom_session_id) {
        this.custom_session_id = custom_session_id;
        return this;
    }

    public GenericMessageAgent build() {
        return new GenericMessageAgent(api_key, type, user_id, time_stamp, platform, message, version, custom_session_id);
    }
}
