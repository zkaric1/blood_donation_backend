package ba.red_cross.blood_donation.DTO;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoginResponse {

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    private String token;

    public LoginResponse(String token) {
        this.token = token;
    }
}
