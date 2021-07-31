package ba.red_cross.blood_donation.controller;
import ba.red_cross.blood_donation.exception.GeneralException;
import ba.red_cross.blood_donation.model.Korisnik;
import ba.red_cross.blood_donation.DTO.DTOKorisnici;
/*
import ba.red_cross.blood_donation.model.TKontaktiEntity;
import ba.red_cross.blood_donation.model.TKorisniciEntity;
import ba.red_cross.blood_donation.service.KontaktiService;
 */
import ba.red_cross.blood_donation.service.KorisnikService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import net.minidev.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;


@Api( tags = "Korisnici")
@RestController
public class KorisnikController {

    /*
    @Autowired
    private KontaktiService kontaktiService;
*/
    @Autowired
    private KorisnikService korisnikService;

 /*   @Autowired
    KorisniciController(KorisniciService korisniciService) {
        this.korisniciService = korisniciService;
    } */

    // GET
    @GetMapping("/korisnici")
    @ApiOperation(value = "Dobavljanje svih korisnika!")
    List<Korisnik> listaKorisnika() throws Exception {
        return korisnikService.sviKorisnici();
    }

    @GetMapping("/korisnici/{id}")
    @ApiOperation(value = "Dobavljanje korisnika na osnovu ID!")
    public ResponseEntity<Object> getKorisnikById(@PathVariable Long id) {
        Korisnik result = new Korisnik();

        try {
            result = korisnikService.getKorisnikById(id);
        }
        catch (Exception ex) {
            GeneralException exception = new GeneralException("NOT_FOUND", ex.getMessage());
            return new ResponseEntity<>(
                    exception,
                    HttpStatus.BAD_REQUEST
            );
        }

        return new ResponseEntity<>(
                result,
                HttpStatus.OK
        );
    }

    // POST
    @ApiOperation(value = "Unos novog korisnika!")
    @PostMapping("/register")
    @ResponseStatus(HttpStatus.CREATED)
    DTOKorisnici dodajKorisnikaIKontakt( @RequestBody DTOKorisnici noviKorisnik) throws Exception {
        try {
            // TKontaktiEntity dbKontakt = kontaktiService.dodajKontakt(noviKorisnik.getKontakt());
            //noviKorisnik.getKorisnik().setKontaktId(dbKontakt.getKontaktId());
            Korisnik dbKorisnik = korisnikService.dodajKontakt(noviKorisnik.getKorisnik());
            return new DTOKorisnici(dbKorisnik);
        }
        catch(Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    // PUT
    @PutMapping("/korisnici")
    @ApiOperation(value = "Ažuriranje korisnika sa određenim ID!")
    ResponseEntity<JSONObject> editKorisnika(@RequestBody DTOKorisnici noviKorisnik) throws Exception {
        JSONObject message = new JSONObject();
        try {
            korisnikService.editKorisnika(noviKorisnik.getKorisnik());
            message.put("Poruka: ", "Uspjesno azuriran korisnikom sa id " + noviKorisnik.getKorisnik().getID());
            return new ResponseEntity<>(
                    message,
                    HttpStatus.OK
            );
        } catch (Exception e) {
            message.put("Poruka: ", e.getMessage());
            return new ResponseEntity<>(
                    message,
                    HttpStatus.BAD_REQUEST
            );
        }
    }

    //DELETE
    @DeleteMapping("/korisnici/obrisi_sve")
    @ApiOperation(value = "Brisanje svih korisnika!")
    HashMap<String, String> obrisiSveKorisnike() throws Exception {
        return korisnikService.deleteAll();
    }

    @DeleteMapping("/korisnici/{id}")
    @ApiOperation(value = "Brisanje korisnika sa određenim ID!")
    HashMap<String, String> obrisiKorisnikaById(@PathVariable Long id) throws Exception {
        return korisnikService.deleteById(id);
    }
}
