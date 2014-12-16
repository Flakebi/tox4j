package im.tox.tox4j.v2.exceptions;

public class ToxSendMessageException extends Exception {

    public static enum Code {
        NULL,
        FRIEND_NOT_FOUND,
        SENDQ,
        TOO_LONG,
        EMPTY,
    }

    public final Code code;

    public ToxSendMessageException(Code code, String message) {
        super(message);
        this.code = code;
    }

}
