package gekoramy.chatbase.model.GenericMessage;

/**
 * @author Luca Mosetti
 * @since 02/2018
 */
public enum Platform {
    TELEGRAM("Telegram");

    private final String platform;

    Platform(String platform) {
        this.platform = platform;
    }

    public String getPlatform() {
        return platform;
    }
}
