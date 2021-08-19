package ba.red_cross.blood_donation.controller;

import ba.red_cross.blood_donation.exception.AkcijeDarivanjaKrviException;
import ba.red_cross.blood_donation.exception.GeneralException;
import ba.red_cross.blood_donation.exception.NotifikacijaException;
import ba.red_cross.blood_donation.model.AkcijaDarivanjaKrvi;
import ba.red_cross.blood_donation.model.Notifikacija;
import ba.red_cross.blood_donation.service.NotifikacijaService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import net.minidev.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Api( tags = "Notifikacije")
@RestController
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
    ResponseEntity<JSONObject> editNotifikacija(@RequestBody Notifikacija novaNotifikacija) throws Exception {
        JSONObject message = new JSONObject();
        try {
            notifikacijaService.editNotifikacija(novaNotifikacija);
            message.put("Poruka: ", "Uspjesno azurirana notifikacija sa id " + novaNotifikacija.getID());
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
