package ba.red_cross.blood_donation.model.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ValidationRequest {

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    private String token;
}
