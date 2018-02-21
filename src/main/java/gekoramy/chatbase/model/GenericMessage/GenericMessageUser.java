package gekoramy.chatbase.model.GenericMessage;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author Luca Mosetti
 * @since 02/2018
 */
@XmlRootElement
public class GenericMessageUser extends GenericMessageAgent {

    /**
     * <optional> set for user messages only;
     * if not set usage metrics will not be shown per intent;
     * do not set if it is a generic catch all intent,
     * like default fallback, so that clusters of similar messages can be reported
     */
    private String intent;

    /**
     * <optional> set for user messages only;
     * indicates that the bot was not able to handle the message because it was
     * not understood (e.g. no intent for "Start over"), or it was understood (e.g.
     * has intent for "Order drink") but not supported; if not set then these high
     * churn issues are not shown across reports; set for generic catch all intents,
     * like default fallback
     */
    private boolean not_handled;

    GenericMessageUser(String api_key, String type, String user_id, long time_stamp, String platform, String message, String intent, boolean not_handled, String version, String custom_session_id) {
        super(api_key, type, user_id, time_stamp, platform, message, version, custom_session_id);
        this.intent = intent;
        this.not_handled = not_handled;
    }

    public String getIntent() {
        return intent;
    }

    public void setIntent(String intent) {
        this.intent = intent;
    }

    public boolean isNot_handled() {
        return not_handled;
    }

    public void setNot_handled(boolean not_handled) {
        this.not_handled = not_handled;
    }
}
