package ba.red_cross.blood_donation.controller;


import ba.red_cross.blood_donation.model.dto.DTOKorisnici;
import ba.red_cross.blood_donation.model.TKontaktiEntity;
import ba.red_cross.blood_donation.model.TKorisniciEntity;
import ba.red_cross.blood_donation.service.KontaktiService;
import ba.red_cross.blood_donation.service.KorisniciService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Api( tags = "Korisnici")
@RestController
public class KorisniciController {

    @Autowired
    private KontaktiService kontaktiService;

    @Autowired
    private KorisniciService korisniciService;

 /*   @Autowired
    KorisniciController(KorisniciService korisniciService) {
        this.korisniciService = korisniciService;
    } */

    @ApiOperation(value = "This method is used to create new users.")
    @PostMapping("/register")
    @ResponseStatus(HttpStatus.CREATED)
    // @Valid
    DTOKorisnici dodajKorisnikaIKontakt( @RequestBody DTOKorisnici noviKorisnik) throws Exception {
        try {
            TKontaktiEntity dbKontakt = kontaktiService.dodajKontakt(noviKorisnik.getKontakt());
            //noviKorisnik.getKorisnik().setKontaktId(dbKontakt.getKontaktId());
            TKorisniciEntity dbKorisnik = korisniciService.dodajKontakt(noviKorisnik.getKorisnik());
            return new DTOKorisnici(dbKontakt, dbKorisnik);
        }catch(Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @GetMapping("/korisnici")
    List<TKorisniciEntity> listaKorisnika() throws Exception {
        return korisniciService.sviKorisnici();
    }
}
