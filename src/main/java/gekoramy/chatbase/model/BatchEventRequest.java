package gekoramy.chatbase.model;

import gekoramy.chatbase.model.CustomEvent.CustomEvent;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

/**
 * @author Luca Mosetti
 * @since 02/2018
 */
@XmlRootElement
public class BatchEventRequest {

    /**
     * <optional> The api_key of your bot, if all events are from a single bot.
     * Setting this value will ignore any api_key values set in the individual Event objects
     * (and you may leave that field unset). If your batch includes events from multiple bots,
     * leave this field blank and set the api_key field in each individual Event.
     */
    private String api_key;

    /**
     * Chatbase can also accept lists of up to 100 events at a time
     */
    private List<CustomEvent> events;

    public BatchEventRequest(String api_key, List<CustomEvent> events) {
        this.api_key = api_key;
        this.events = events;
    }

    public String getApi_key() {
        return api_key;
    }

    public BatchEventRequest setApi_key(String api_key) {
        this.api_key = api_key;
        return this;
    }

    public List<CustomEvent> getEvents() {
        return events;
    }

    public BatchEventRequest setEvents(List<CustomEvent> events) {
        this.events = events;
        return this;
    }
}
