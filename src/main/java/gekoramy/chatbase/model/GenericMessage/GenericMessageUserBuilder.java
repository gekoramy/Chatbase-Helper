package gekoramy.chatbase.model.GenericMessage;

import javax.validation.constraints.NotNull;

/**
 * @author Luca Mosetti
 * @since 02/2018
 */
public class GenericMessageUserBuilder {
    private String api_key = null;
    private String type = Type.USER.getType();
    private String user_id = null;
    private Long time_stamp = null;
    private String platform = null;
    private String message = null;
    private String intent = null;
    private Boolean not_handled = null;
    private String version = null;
    private String custom_session_id = null;

    public GenericMessageUserBuilder setApi_key(@NotNull String api_key) {
        this.api_key = api_key;
        return this;
    }

    public GenericMessageUserBuilder setUser_id(@NotNull String user_id) {
        this.user_id = user_id;
        return this;
    }

    public GenericMessageUserBuilder setTime_stamp(long time_stamp) {
        this.time_stamp = time_stamp;
        return this;
    }

    public GenericMessageUserBuilder setPlatform(@NotNull String platform) {
        this.platform = platform;
        return this;
    }

    public GenericMessageUserBuilder setMessage(String message) {
        this.message = message;
        return this;
    }

    public GenericMessageUserBuilder setIntent(String intent) {
        this.intent = intent;
        return this;
    }

    public GenericMessageUserBuilder setNot_handled(boolean not_handled) {
        this.not_handled = not_handled;
        return this;
    }

    public GenericMessageUserBuilder setVersion(String version) {
        this.version = version;
        return this;
    }

    public GenericMessageUserBuilder setCustom_session_id(String custom_session_id) {
        this.custom_session_id = custom_session_id;
        return this;
    }

    public GenericMessageUser build() {
        return new GenericMessageUser(api_key, type, user_id, time_stamp, platform, message, intent, not_handled, version, custom_session_id);
    }
}