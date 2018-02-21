package gekoramy.chatbase.model.GenericMessage;

/**
 * @author Luca Mosetti
 * @since 02/2018
 */
public class GenericMessageAgent {

    /**
     * <required> the Chatbase ID of the bot
     */
    private String api_key;

    /**
     * <required> valid values "user" or "agent" (aka your bot) message
     */
    private String type;

    /**
     * <required> the ID of the end-user
     */
    private String user_id;

    /**
     * <required> milliseconds since the UNIX epoch, used to sequence messages.
     * (must be within previous 48 hours)
     */
    private long time_stamp;

    /**
     * <required> valid values "Facebook", "SMS", "Web", "Android", "iOS", "Actions",
     * "Alexa", "Cortana", "Kik", "Skype", "Twitter", "Viber", "Telegram", "Slack",
     * "WhatsApp", "WeChat", "Line", "Kakao" or a custom name like "Workplace" or "OurPlatform"
     */
    private String platform;

    /**
     * <optional> the raw message body regardless of type
     * for example a typed-in or a tapped button or tapped image
     */
    private String message;

    /**
     * <optional> set for user and bot messages;
     * used to track versions of your code or to track A/B tests
     */
    private String version;

    /**
     * <optional> set for user and bot messages;
     * used to define your own custom sessions for Session Flow report and daily session metrics
     */
    private String custom_session_id;

    GenericMessageAgent(String api_key, String type, String user_id, long time_stamp, String platform, String message, String version, String custom_session_id) {
        this.api_key = api_key;
        this.type = type;
        this.user_id = user_id;
        this.time_stamp = time_stamp;
        this.platform = platform;
        this.message = message;
        this.version = version;
        this.custom_session_id = custom_session_id;
    }

    public String getApi_key() {
        return api_key;
    }

    public GenericMessageAgent setApi_key(String api_key) {
        this.api_key = api_key;
        return this;
    }

    public String getType() {
        return type;
    }

    public GenericMessageAgent setType(String type) {
        this.type = type;
        return this;
    }

    public String getUser_id() {
        return user_id;
    }

    public GenericMessageAgent setUser_id(String user_id) {
        this.user_id = user_id;
        return this;
    }

    public long getTime_stamp() {
        return time_stamp;
    }

    public GenericMessageAgent setTime_stamp(long time_stamp) {
        this.time_stamp = time_stamp;
        return this;
    }

    public String getPlatform() {
        return platform;
    }

    public GenericMessageAgent setPlatform(String platform) {
        this.platform = platform;
        return this;
    }

    public String getMessage() {
        return message;
    }

    public GenericMessageAgent setMessage(String message) {
        this.message = message;
        return this;
    }

    public String getVersion() {
        return version;
    }

    public GenericMessageAgent setVersion(String version) {
        this.version = version;
        return this;
    }

    public String getCustom_session_id() {
        return custom_session_id;
    }

    public GenericMessageAgent setCustom_session_id(String custom_session_id) {
        this.custom_session_id = custom_session_id;
        return this;
    }
}
