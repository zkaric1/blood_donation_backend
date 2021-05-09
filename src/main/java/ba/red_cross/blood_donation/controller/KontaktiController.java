package ba.red_cross.blood_donation.controller;


import ba.red_cross.blood_donation.model.TKontaktiEntity;
import ba.red_cross.blood_donation.service.KontaktiService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@Api( tags = "Kontakti")
@RestController
public class KontaktiController {

    private KontaktiService kontaktiService;

    @Autowired
    public KontaktiController(KontaktiService kontaktiService) {
        this.kontaktiService = kontaktiService;
    }


}
