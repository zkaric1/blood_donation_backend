package ba.red_cross.blood_donation.controller;

import ba.red_cross.blood_donation.exception.GeneralException;
import ba.red_cross.blood_donation.exception.NotifikacijaException;
import ba.red_cross.blood_donation.model.Notifikacija;
import ba.red_cross.blood_donation.security.CustomUserDetails;
import ba.red_cross.blood_donation.service.NotifikacijaService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import net.minidev.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Api( tags = "Notifikacije")
@RestController
@Transactional
public class NotifikacijaController {

    @Autowired
    private NotifikacijaService notifikacijaService;

    // GET metode
    @GetMapping("/notifikacije/lista")
    @ApiOperation(value = "Dobavljanje svih notifikacija!")
    ResponseEntity<Object> getNotifikacije() {

        List<Notifikacija> result = new ArrayList<>();
        try {
             result = notifikacijaService.getNotifikacije();
        } catch (Exception ex) {
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

    @GetMapping("/notifikacije/{id}")
    @ApiOperation(value = "Dobavljanje notifikacije na osnovu ID!")
    public ResponseEntity<Object> getNotifikacijaById(@PathVariable Long id) {
        Notifikacija result = new Notifikacija();

        try {
            result = notifikacijaService.getNotifikacijaById(id);
        } catch (NotifikacijaException ex) {
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

    @DeleteMapping("/notifikacije/korisnik/{id}")
    @ApiOperation(value = "Brisanje notifikacija od korisnika")
    ResponseEntity<Object> obrisiNotifikacijeOdKorisnika(@PathVariable Long  id) throws Exception {
        CustomUserDetails userDetails = (CustomUserDetails) SecurityContextHolder.getContext().getAuthentication()
                .getPrincipal();
        if (userDetails.getUserId() != id) {
            Exception exception =  new Exception("Unauthorized");
            return new ResponseEntity<>(
                    exception,
                    HttpStatus.UNAUTHORIZED
            );
        }
        JSONObject message = new JSONObject();
        message.put("Poruka", notifikacijaService.obrisiNotifikacijeOdKorisnika(id));
        return new ResponseEntity<>(
                message,
                HttpStatus.OK
        );
    }

    // DELETE metode
    @DeleteMapping("/notifikacije/obrisi_sve")
    @ApiOperation(value = "Brisanje svih notifikacija!")
    HashMap<String, String> obrisiSveNotifikacije() throws Exception {
        return notifikacijaService.deleteAll();
    }

    @DeleteMapping("/notifikacije/{id}")
    @ApiOperation(value = "Brisanje notifikacije sa određenim ID!")
    HashMap<String, String> obrisiNotifikacijuById(@PathVariable Long id) throws Exception {
        return notifikacijaService.deleteById(id);
    }

    // POST metoda
    @PostMapping("/notifikacije")
    @ApiOperation(value = "Kreiranje nove notifikacije!")
    Notifikacija addAkcijaDarivanja( @RequestBody Notifikacija notifikacija) {
        return notifikacijaService.addNotifikacija (notifikacija);
    }

    // PUT metoda
    @PutMapping("/notifikacije")
    @ApiOperation(value = "Ažuriranje notifikacije sa određenim ID!")
    ResponseEntity<Object> editNotifikacija(@RequestBody Notifikacija novaNotifikacija) throws Exception {
        try {
            notifikacijaService.editNotifikacija(novaNotifikacija);
            return new ResponseEntity<>(
                    "Uspjesno azurirana notifikacija sa id " + novaNotifikacija.getID(),
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
