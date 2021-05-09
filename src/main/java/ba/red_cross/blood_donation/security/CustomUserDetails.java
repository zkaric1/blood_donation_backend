package ba.red_cross.blood_donation.security;

import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.Collection;

@Getter
@Setter
public class CustomUserDetails extends User {
    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    private Integer userId;

    public CustomUserDetails(String username, String password, Collection<? extends GrantedAuthority> authorities, Integer userId) {
        super(username, password, authorities);
        this.userId = userId;
    }
}
