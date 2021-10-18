package ba.red_cross.blood_donation.controller;

import ba.red_cross.blood_donation.security.CustomUserDetails;
import ba.red_cross.blood_donation.service.KorisnikNotifikacijaService;
import ba.red_cross.blood_donation.utils.CheckAuth;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import net.minidev.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@Api("KorisnikNotifikacije")
@RestController
public class KorisnikNotifikacijaController {

    private CheckAuth checkAuth = new CheckAuth();

    @Autowired
    KorisnikNotifikacijaService korisnikNotifikacijaService;

    @DeleteMapping("/korisnici/{id}/notifikacije")
    @ApiOperation(value = "Brisanje svih notifikacija za korisnika!")
    @Transactional
    public ResponseEntity<Object> obrisiNotifikacijeZaKorisnika(@PathVariable Long id) {
        if(!checkAuth.isAuthorized(SecurityContextHolder.getContext().getAuthentication(), id)) {
            Exception exception =  new Exception("Unauthorized");
            return new ResponseEntity<>(
                    exception,
                    HttpStatus.UNAUTHORIZED
            );
        }
        JSONObject message = new JSONObject();
        try {
            korisnikNotifikacijaService.obrisiNotifikacijeZaKorisnika(id);
            message.put("message","Uspjesno obrisane notifikacije za usera sa id "+id);
        }
        catch (Exception ex) {
           // GeneralException exception = new GeneralException("NOT_FOUND", ex.getMessage());
            return new ResponseEntity<>(
                    ex,
                    HttpStatus.BAD_REQUEST
            );
        }

        return new ResponseEntity<>(
                message,
                HttpStatus.OK
        );
    }

    @DeleteMapping("/korisnici/{korisnikId}/notifikacije/{notifikacijaId}")
    @ApiOperation(value = "Brisanje notifikacije za odredjenog korisnika!")
    @Transactional
    public ResponseEntity<Object> obrisiNotifikacijeZaKorisnika(@PathVariable Long korisnikId, @PathVariable Long notifikacijaId ) {
        JSONObject message = new JSONObject();
        try {
            korisnikNotifikacijaService.obrisiNotifikacijuZaKorisnika(korisnikId, notifikacijaId);
            message.put("message","Uspjesno obrisana notifikacija " +notifikacijaId+" za usera sa id " + korisnikId);
        }
        catch (Exception ex) {
            return new ResponseEntity<>(
                    ex,
                    HttpStatus.BAD_REQUEST
            );
        }

        return new ResponseEntity<>(
                message,
                HttpStatus.OK
        );
    }
}
