package gekoramy.chatbase;

import gekoramy.chatbase.model.CustomEvent.CustomEvent;
import gekoramy.chatbase.model.GenericMessage.GenericMessageAgent;

/**
 * @author Luca Mosetti
 * @since 02/2018
 */
public class ChatbaseSender {
    private final CustomEventsSender CESender;
    private final GenericMessagesSender GMSender;

    public ChatbaseSender(ChatbaseHandler chatbaseHandler) {
        GMSender = new GenericMessagesSender(chatbaseHandler);
        CESender = new CustomEventsSender(chatbaseHandler);
    }

    public void postGMRequest(GenericMessageAgent genericMessageAgent) { GMSender.postGMRequest(genericMessageAgent); }

    public void postCERequest(CustomEvent customEvent) { CESender.postCMRequest(customEvent); }
}
