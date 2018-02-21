package gekoramy.chatbase;

import gekoramy.chatbase.model.BatchEventRequest;
import gekoramy.chatbase.model.CustomEvent.CustomEvent;

import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * @author Luca Mosetti
 * @since 02/2018
 */
class CustomEventsSender {
    private static final String CHATBASE_CE_URL = "https://api.chatbase.com/apis/v1/events/insert_batch";

    private final ChatbaseHandler chatbaseHandler;
    private final Queue<CustomEvent> mCERequested;
    private final AtomicBoolean mCEPostRequested = new AtomicBoolean(false);

    CustomEventsSender(ChatbaseHandler chatbaseHandler) {
        this.chatbaseHandler = chatbaseHandler;
        this.mCERequested = new ConcurrentLinkedQueue<>();

        Executors
                .newSingleThreadScheduledExecutor()
                .scheduleAtFixedRate(new CEPostRunnable(), 30, 30, TimeUnit.SECONDS);
    }

    void postCMRequest(CustomEvent customEvent) {
        mCERequested.add(customEvent);
        mCEPostRequested.set(true);
    }

    private final class CEPostRunnable implements Runnable {
        @Override
        public void run() {
            try {
                if (!mCEPostRequested.getAndSet(false))
                    return;

                List<CustomEvent> customEvents = new ArrayList<>(mCERequested);
                if (customEvents.size() > 100)
                    customEvents = customEvents.subList(0, 100);
                Entity payload = Entity.json(new BatchEventRequest(null, customEvents));

                Response response = ClientBuilder
                        .newClient()
                        .target(CHATBASE_CE_URL)
                        .request(MediaType.APPLICATION_JSON_TYPE)
                        .post(payload);

                if (response.getStatus() == 200)
                    chatbaseHandler.onSucceed(payload);
                else
                    chatbaseHandler.onFailure(response);

                if (response.getStatus() != 500)
                    mCERequested.removeAll(customEvents);
            } catch (Throwable e) {
                chatbaseHandler.onException(e);
            }
        }
    }
}
