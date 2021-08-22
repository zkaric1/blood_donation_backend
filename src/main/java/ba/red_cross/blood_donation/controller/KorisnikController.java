package ba.red_cross.blood_donation.controller;
import ba.red_cross.blood_donation.DTO.KorisnikPatchDTO;
import ba.red_cross.blood_donation.DTO.RegisterRequest;
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

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;


@Api( tags = "Korisnici")
@RestController
public class KorisnikController {

    @Autowired
    private KorisnikService korisnikService;

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

    @GetMapping("/korisnici/krvna_grupa/{krvnaGrupa}")
    @ApiOperation(value = "Dobavljanje svih korisnika sa odgovarajućom krvnom grupom!")
    List<Korisnik> getKorisniciByKrvnaGrupa(@PathVariable String krvnaGrupa) throws Exception {
        return korisnikService.getKorisniciByKrvnaGrupa(krvnaGrupa);
    }

    @GetMapping("/korisnici/{ime}/{prezime}")
    @ApiOperation(value = "Dobavljanje korisnika određenog imena i prezimena!")
    List<Korisnik> getKorisniciImePrezime(@PathVariable String ime, @PathVariable String prezime) throws Exception {
        return korisnikService.getKorisnikByImePrezime(ime, prezime);
    }

    @GetMapping("/korisnici/zadnjiRegistrovani")
    @ApiOperation(value = "Dobavljanje zadnjih pet registrovanih korisnika!")
    List<Korisnik> getNewestKorisnici() throws Exception {
        return korisnikService.getNewestKorisnici();
    }

    // POST
    @ApiOperation(value = "Unos novog korisnika!")
    @PostMapping("/register")
    @ResponseStatus(HttpStatus.CREATED)
    ResponseEntity<Object> dodajKorisnikaIKontakt( @RequestBody RegisterRequest noviKorisnik) throws Exception { //radel validacije?
        JSONObject message = new JSONObject();
        try {
            Korisnik dbKorisnik = korisnikService.dodajKontakt(noviKorisnik);
            return new ResponseEntity<>(
                    dbKorisnik,
                    HttpStatus.OK
            );
        }
        catch(Exception e) {
            message.put("Poruka: ", e.getMessage());
            return new ResponseEntity<>(
                    message,
                    HttpStatus.BAD_REQUEST
            );
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

    // PATCH
    @PatchMapping("/korisnici/{id}")
    @ApiOperation(value = "Ažuriranje samo određenih podataka korisnika!")
    public ResponseEntity<JSONObject> partialUpdateUser(@RequestBody KorisnikPatchDTO user, @PathVariable("id") Long id)  {
        JSONObject message = new JSONObject();
        try {
            korisnikService.partialUpdateUser(user, id);
            message.put("Poruka: ", "Uspjesno azuriran korisnikom sa id " + id);
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
}
