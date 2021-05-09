package ba.red_cross.blood_donation.controller;

import ba.red_cross.blood_donation.model.dto.LoginRequest;
import ba.red_cross.blood_donation.model.dto.LoginResponse;
import ba.red_cross.blood_donation.model.dto.ValidationRequest;
import ba.red_cross.blood_donation.model.dto.ValidationResponse;
import ba.red_cross.blood_donation.service.AuthService;
import io.swagger.annotations.Api;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Api( tags = "Auth")
@RestController
public class AuthController {

    private final AuthService authenticationService;

    @Autowired
    public AuthController(AuthService authenticationService) {
        this.authenticationService = authenticationService;
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@RequestBody LoginRequest loginRequest) {

        try {
            return new ResponseEntity<>(authenticationService.login(loginRequest), HttpStatus.CREATED);
        }
        catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
    }

    @PostMapping("/validate-token")
    public ResponseEntity<ValidationResponse> validate(@RequestBody ValidationRequest validationRequest) {
        try {
            return new ResponseEntity<>(authenticationService.validate(validationRequest), HttpStatus.OK);
        }
        catch (Exception ex) {
            LoggerFactory.getLogger(AuthController.class).error("Failed to validate token");
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}

