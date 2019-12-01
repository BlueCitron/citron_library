package me.bluecitron.library.core.item.exception;

public class UnAvailableStatusException extends RuntimeException {

    public UnAvailableStatusException() {
        super();
    }

    public UnAvailableStatusException(String message) {
        super(message);
    }

    public UnAvailableStatusException(String message, Throwable cause) {
        super(message, cause);
    }

    public UnAvailableStatusException(Throwable cause) {
        super(cause);
    }

    protected UnAvailableStatusException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
