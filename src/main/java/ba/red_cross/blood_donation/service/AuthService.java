package ba.red_cross.blood_donation.service;

import ba.red_cross.blood_donation.model.dto.LoginRequest;
import ba.red_cross.blood_donation.model.dto.LoginResponse;
import ba.red_cross.blood_donation.model.dto.ValidationRequest;
import ba.red_cross.blood_donation.model.dto.ValidationResponse;
import ba.red_cross.blood_donation.security.CustomUserDetails;
import ba.red_cross.blood_donation.security.JwtUtil;
import ba.red_cross.blood_donation.security.UserDetailsService;
import io.jsonwebtoken.JwtException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    private final AuthenticationManager authenticationManager;
    private final UserDetailsService userDetailsService;

    private final String SECRET_KEY = "SECRET";

    @Autowired
    public AuthService(AuthenticationManager authenticationManager,
                                 UserDetailsService userDetailsService) {
        this.authenticationManager = authenticationManager;
        this.userDetailsService = userDetailsService;
    }


    public LoginResponse login(LoginRequest loginRequest) throws Exception {
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword())
            );
        }
        catch (BadCredentialsException e) {
            throw new Exception("Incorrect username or password", e);
        }
        catch (Exception e) {
            throw e;
        }

        final CustomUserDetails userDetails = userDetailsService.loadUserByUsername(loginRequest.getUsername());

        return new LoginResponse(JwtUtil.generateToken(userDetails, SECRET_KEY));
    }

    public ValidationResponse validate(ValidationRequest validationRequest) {

        try {
            String username = JwtUtil.extractUsername(validationRequest.getToken(), SECRET_KEY);
            final CustomUserDetails userDetails = userDetailsService.loadUserByUsername(username);

            return new ValidationResponse(JwtUtil.validateToken(validationRequest.getToken(), userDetails, SECRET_KEY),
                    userDetails.getUsername(),
                    userDetails.getPassword(),
                    userDetails.getAuthorities().stream().findFirst().get().getAuthority());
        }
        catch (JwtException e) {
            return new ValidationResponse(false);
        }

    }
}
