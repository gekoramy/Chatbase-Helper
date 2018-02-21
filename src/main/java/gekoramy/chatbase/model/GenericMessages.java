package gekoramy.chatbase.model;

import gekoramy.chatbase.model.GenericMessage.GenericMessageAgent;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

/**
 * @author Luca Mosetti
 * @since 02/2018
 */
@XmlRootElement
public class GenericMessages {

    private List<GenericMessageAgent> messages;

    public GenericMessages(List<GenericMessageAgent> messages) {
        this.messages = messages;
    }

    public List<GenericMessageAgent> getMessages() {
        return messages;
    }

    public GenericMessages setMessages(List<GenericMessageAgent> messages) {
        this.messages = messages;
        return this;
    }
}
