package gekoramy.chatbase;

import javax.ws.rs.client.Entity;
import javax.ws.rs.core.Response;

/**
 * @author Luca Mosetti
 * @since 02/2018
 */
public interface ChatbaseHandler {

    void onSucceed(Entity response);

    void onFailure(Response response);

    void onException(Throwable e);
}
