package gekoramy.chatbase.model.GenericMessage;

/**
 * @author Luca Mosetti
 * @since 02/2018
 */
public enum Type {
    USER("user"), AGENT("agent");

    private final String type;

    Type(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }
}
