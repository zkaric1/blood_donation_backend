package ba.red_cross.blood_donation.exception;

public class GeneralException {

    private String message;
    private String cause;

    public GeneralException() {}

    public GeneralException(String cause, String message) {
        this.cause = cause;
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getCause() {
        return cause;
    }

    public void setCause(String cause) {
        this.cause = cause;
    }
}

