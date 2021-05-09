package ba.red_cross.blood_donation.model.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ValidationResponse {

    public boolean isValid() {
        return valid;
    }

    public void setValid(boolean valid) {
        this.valid = valid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAuthorities() {
        return authorities;
    }

    public void setAuthorities(String authorities) {
        this.authorities = authorities;
    }

    private boolean valid;

    private String username;

    private String password;

    private String authorities;

    public ValidationResponse(boolean valid) {
        this.valid = valid;
    }

    public ValidationResponse(boolean valid, String username, String password, String authorities) {
        this.valid = valid;
        this.username = username;
        this.password = password;
        this.authorities = authorities;
    }
}
