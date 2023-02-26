package ba.red_cross.blood_donation.controller;
import ba.red_cross.blood_donation.DTO.*;
import ba.red_cross.blood_donation.exception.GeneralException;
import ba.red_cross.blood_donation.model.Korisnik;
import ba.red_cross.blood_donation.service.KorisnikService;
import ba.red_cross.blood_donation.utils.CheckAuth;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import net.minidev.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;


@Api( tags = "Korisnici")
@RestController
public class KorisnikController {

    private  CheckAuth checkAuth = new CheckAuth();

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
        if(!checkAuth.isAuthorized(SecurityContextHolder.getContext().getAuthentication(), id)) {
            Exception exception =  new Exception("Unauthorized");
            return new ResponseEntity<>(
                    exception,
                    HttpStatus.UNAUTHORIZED
            );
        }

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
            throw new Exception (e.getMessage());
        }
    }

    @ApiOperation(value = "Dodavanje novog darivanja krvi korisniku, bez akcije darivanja!")
    @PostMapping("/korisnik/dodajDarivanje/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    ResponseEntity<Object> dodajDarivanjeKrvi(@PathVariable Long id) throws Exception {
        if(!checkAuth.isAuthorized(SecurityContextHolder.getContext().getAuthentication(), id)) {
            Exception exception =  new Exception("Unauthorized");
            return new ResponseEntity<>(
                    exception,
                    HttpStatus.UNAUTHORIZED
            );
        }
        JSONObject message = new JSONObject();
        try {
            korisnikService.dodajDarivanjeKrvi(id);
            return new ResponseEntity<>(
                    "Uspješno dodano darivanje krvi korisniku!",
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
    ResponseEntity<Object> obrisiKorisnikaById(@PathVariable Long id) throws Exception {
        try {
            korisnikService.deleteById(id);
        } catch (Exception ex) {
            GeneralException exception = new GeneralException("NOT_FOUND", ex.getMessage());
            return new ResponseEntity<>(
                    exception,
                    HttpStatus.BAD_REQUEST
            );
        }

        return new ResponseEntity<>(
                "Uspjesno obrisan korisnik sa id " + id,
                HttpStatus.OK
        );
    }

    // PATCH
    @PatchMapping("/korisnici/{id}")
    @ApiOperation(value = "Ažuriranje samo određenih podataka korisnika!")
    public ResponseEntity<Object> partialUpdateUser(@RequestBody KorisnikPatchDTO user, @PathVariable("id") Long id)  {
        if (!checkAuth.isAuthorized(SecurityContextHolder.getContext().getAuthentication(), id)) {
            Exception exception =  new Exception("Unauthorized");
            return new ResponseEntity<>(
                    exception,
                    HttpStatus.UNAUTHORIZED
            );
        }
        try {
            korisnikService.partialUpdateUser(user, id);
            return new ResponseEntity<>(
                    "Uspjesno azuriran korisnikom sa id " + id,
                    HttpStatus.OK
            );
        } catch (Exception e) {
            GeneralException exception = new GeneralException("NOT_FOUND", e.getMessage());
            return new ResponseEntity<>(
                    exception,
                    HttpStatus.BAD_REQUEST
            );
        }
    }

    @PutMapping("/korisnici/{id}")
    @ApiOperation(value = "Promjena korisnickih podataka")
    public ResponseEntity<Object> promijeniKorisnickeInfromacije(@PathVariable("id") Long id, @RequestBody EditKorisnik editKorisnik) {
        if(!checkAuth.isAuthorized(SecurityContextHolder.getContext().getAuthentication(), id)) {
            Exception exception =  new Exception("Unauthorized");
            return new ResponseEntity<>(
                    exception,
                    HttpStatus.UNAUTHORIZED
            );
        }
        try {
            korisnikService.promijeniKorisnickeInfromacije(id, editKorisnik);
            return new ResponseEntity<>(
                    "Uspjesno azurirane informacije",
                    HttpStatus.OK
            );
        } catch (Exception e) {
            GeneralException exception = new GeneralException("NOT_FOUND", e.getMessage());
            return new ResponseEntity<>(
                    exception,
                    HttpStatus.BAD_REQUEST
            );
        }
    }

    @PutMapping("/korisnici/{id}/notifikacije")
    @ApiOperation(value = "Promjena slanjeNotifikacija atributa")
    public  ResponseEntity<Object> promijeniSlanjeNotifikacija(@PathVariable("id") Long id, @RequestParam boolean sendNotifications) throws Exception {
        if(!checkAuth.isAuthorized(SecurityContextHolder.getContext().getAuthentication(), id)) {
            Exception exception =  new Exception("Unauthorized");
            return new ResponseEntity<>(
                    exception,
                    HttpStatus.UNAUTHORIZED
            );
        }
        try {
            korisnikService.promijeniSlanjeNotifikacija(id, sendNotifications);
            return new ResponseEntity<>(
                    "Uspjesno azurirane informacije",
                    HttpStatus.OK
            );
        } catch (Exception e) {
            GeneralException exception = new GeneralException("NOT_FOUND", e.getMessage());
            return new ResponseEntity<>(
                    exception,
                    HttpStatus.BAD_REQUEST
            );
        }
    }

    @PutMapping("/korisnici/{id}/sifra")
    @ApiOperation(value = "Mijenjanje sifre za korisnika!")
    public ResponseEntity<Object> promijeniSifru(@RequestBody ChangePasswordDTO data, @PathVariable("id") Long id) {
        if(!checkAuth.isAuthorized(SecurityContextHolder.getContext().getAuthentication(), id)) {
            Exception exception =  new Exception("Unauthorized");
            return new ResponseEntity<>(
                    exception,
                    HttpStatus.UNAUTHORIZED
            );
        }
        JSONObject message = new JSONObject();
        try {
            korisnikService.promijeniSifru(id, data.getOldPassword(), data.getNewPassword());
            message.put("message", "Uspjesno ažurirana lozinka");
            return new ResponseEntity<>(
                    message,
                    HttpStatus.OK
            );
        } catch (Exception e) {
            GeneralException exception = new GeneralException("NOT_FOUND", e.getMessage());
            return new ResponseEntity<>(
                    exception,
                    HttpStatus.BAD_REQUEST
            );
        }
    }

    @PatchMapping("/korisnici/dodajKrvnuGrupu/{id}")
    @ApiOperation(value = "Dodavanje krvne grupe nakon prvog darivanja")
    public ResponseEntity<Object> dodajKrvnuGrupu(@RequestBody KrvnaGrupaDTO krvnaGrupa, @PathVariable("id") Long id) throws Exception {
        try {
            korisnikService.dodajKrvnuGrupu(krvnaGrupa, id);
            return new ResponseEntity<>(
                    "Uspjesno azurirana krvna grupa korisniku",
                    HttpStatus.OK
            );
        } catch (Exception e) {
            GeneralException exception = new GeneralException("NOT_FOUND", e.getMessage());
            return new ResponseEntity<>(
                    exception,
                    HttpStatus.BAD_REQUEST
            );
        }
    }
}
