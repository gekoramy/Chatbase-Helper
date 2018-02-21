package gekoramy.chatbase;

import gekoramy.chatbase.model.GenericMessage.GenericMessageAgent;
import gekoramy.chatbase.model.GenericMessages;

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
class GenericMessagesSender {
    private static final String CHATBASE_GM_URL = "https://chatbase.com/api/messages";

    private final ChatbaseHandler chatbaseHandler;
    private final Queue<GenericMessageAgent> mGMRequested;
    private final AtomicBoolean mGMPostRequested = new AtomicBoolean(false);

    GenericMessagesSender(ChatbaseHandler chatbaseHandler) {
        this.chatbaseHandler = chatbaseHandler;
        this.mGMRequested = new ConcurrentLinkedQueue<>();

        Executors
                .newSingleThreadScheduledExecutor()
                .scheduleAtFixedRate(new GMPostRunnable(), 30, 30, TimeUnit.SECONDS);
    }

    void postGMRequest(GenericMessageAgent messageAgent) {
        mGMRequested.add(messageAgent);
        mGMPostRequested.set(true);
    }

    private final class GMPostRunnable implements Runnable {
        @Override
        public void run() {
            try {
                if (!mGMPostRequested.getAndSet(false))
                    return;

                List<GenericMessageAgent> updates = new ArrayList<>(mGMRequested);
                if (updates.size() > 100)
                    updates = updates.subList(0, 100);
                Entity payload = Entity.json(new GenericMessages(updates));

                Response response = ClientBuilder
                        .newClient()
                        .target(CHATBASE_GM_URL)
                        .request(MediaType.APPLICATION_JSON_TYPE)
                        .post(payload);

                if (response.getStatus() == 200)
                    chatbaseHandler.onSucceed(payload);
                else
                    chatbaseHandler.onFailure(response);

                if (response.getStatus() != 500)
                    mGMRequested.removeAll(updates);
            } catch (Throwable e) {
                chatbaseHandler.onException(e);
            }
        }
    }
}
