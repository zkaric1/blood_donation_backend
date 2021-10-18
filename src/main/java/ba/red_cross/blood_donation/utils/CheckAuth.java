package ba.red_cross.blood_donation.utils;

import ba.red_cross.blood_donation.security.CustomUserDetails;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.ArrayList;
import java.util.List;

public class CheckAuth {

    public Boolean isAuthorized(Authentication authentication, Long id) {
        CustomUserDetails userDetails = null;
        try {
             userDetails = (CustomUserDetails) authentication.getPrincipal();
        }catch (Exception e) {
            return false;
        }

        List<GrantedAuthority> listAuthorities = new ArrayList<>();
        listAuthorities.addAll(authentication.getAuthorities());
        if(listAuthorities.contains("administrator")) {
            return true;
        }
        if(userDetails.getUserId() != id) {
            return false;
        }
        return true;
    }
}
