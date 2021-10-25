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
        boolean exists = false;

        try {
             userDetails = (CustomUserDetails) authentication.getPrincipal();
        }catch (Exception e) {
            return false;
        }

        List<GrantedAuthority> listAuthorities = new ArrayList<>();
        listAuthorities.addAll(authentication.getAuthorities());
        for (int i = 0; i<listAuthorities.size(); i++) {
            if (listAuthorities.get(i).getAuthority().equals("administrator")); exists = true;
        }
        System.out.print(exists);
        if(exists) {
            return true;
        }
        else if(userDetails.getUserId() != id) {
            return false;
        }
        return true;
    }
}
