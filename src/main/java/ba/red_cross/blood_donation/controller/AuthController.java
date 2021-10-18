package ba.red_cross.blood_donation.controller;

import ba.red_cross.blood_donation.DTO.LoginRequest;
import ba.red_cross.blood_donation.DTO.LoginResponse;
import ba.red_cross.blood_donation.model.Korisnik;
import ba.red_cross.blood_donation.model.dto.ValidationRequest;
import ba.red_cross.blood_donation.model.dto.ValidationResponse;
import ba.red_cross.blood_donation.repository.KorisnikRepository;
import ba.red_cross.blood_donation.security.CustomUserDetails;
import ba.red_cross.blood_donation.service.AuthService;
import io.swagger.annotations.Api;
import org.jfree.util.Log;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "Auth")
@RestController
public class AuthController {

    private final AuthService authenticationService;
    @Autowired
    KorisnikRepository korisnikRepository;

    @Autowired
    public AuthController(AuthService authenticationService) {
        this.authenticationService = authenticationService;
    }

    @PostMapping("/login")
    public ResponseEntity<Object> login(@RequestBody LoginRequest loginRequest) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

        try {
            Korisnik userWithUserName = korisnikRepository.findByEmailAdresa(loginRequest.getEmail());
            boolean isPasswordMatch = false;
            if (userWithUserName != null) {
                isPasswordMatch = passwordEncoder.matches(loginRequest.getPassword(), userWithUserName.getLozinka());
            }

            if (!isPasswordMatch) {
                throw new Exception("Pogrešna lozinka ili korisničko ime!");
            }

            return new ResponseEntity<>(authenticationService.login(loginRequest), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<Object>(e, new HttpHeaders(),HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/token-refresh")
    public ResponseEntity<LoginResponse> refresh(@RequestBody LoginResponse authenticationDto) {
        try {
            return new ResponseEntity<>(authenticationService.refresh(authenticationDto), HttpStatus.OK);
        }
        catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
    }

    @PostMapping("/validate-token")
    public ResponseEntity<ValidationResponse> validate(@RequestBody ValidationRequest validationRequest) {
        try {
            return new ResponseEntity<>(authenticationService.validate(validationRequest), HttpStatus.OK);
        } catch (Exception ex) {
            LoggerFactory.getLogger(AuthController.class).error("Failed to validate token");
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
    }
}

