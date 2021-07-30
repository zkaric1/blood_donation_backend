package ba.red_cross.blood_donation.exception;

public class GeneralException {

    private String EXCEPTION_MESSAGE;
    private String CAUSE;

    public GeneralException(){}
    public GeneralException(String CAUSE, String EXCEPTION_MESSAGE) {
        this.CAUSE = CAUSE;
        this.EXCEPTION_MESSAGE = EXCEPTION_MESSAGE;
    }

    public String getEXCEPTION_MESSAGE() {
        return EXCEPTION_MESSAGE;
    }

    public void setEXCEPTION_MESSAGE(String EXCEPTION_MESSAGE) {
        this.EXCEPTION_MESSAGE = EXCEPTION_MESSAGE;
    }

    public String getCAUSE() {
        return CAUSE;
    }

    public void setCAUSE(String CAUSE) {
        this.CAUSE = CAUSE;
    }
}

