package ba.red_cross.blood_donation.controller;

import ba.red_cross.blood_donation.exception.AkcijeDarivanjaKrviException;
import ba.red_cross.blood_donation.exception.GeneralException;
import ba.red_cross.blood_donation.model.AkcijaDarivanjaKrvi;
import ba.red_cross.blood_donation.service.AkcijeDarivanjaKrviService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import net.minidev.json.JSONObject;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@RestController
@Api(tags = "Akcije darivanja krvi")
public class AkcijaDarivanjaKrviController {

    AkcijeDarivanjaKrviService akcijeDarivanjaService;

    public AkcijaDarivanjaKrviController(AkcijeDarivanjaKrviService akcijeDarivanjaService) {
        this.akcijeDarivanjaService = akcijeDarivanjaService;
    }

    // GET metode
    @GetMapping("/akcija_darivanja_krvi/lista")
    @ApiOperation(value = "Dobavljanje svih kreiranih akcija darivanja krvi ili za određeni grad!")
    ResponseEntity<Object> getAkcijeDarivanjaKrvi(@RequestParam(value = "grad", required = false) String grad) {

        List<AkcijaDarivanjaKrvi> result = new ArrayList<>();
        try {
            if (grad != null) {
                result = akcijeDarivanjaService.getAkcijeDarivanjaKrviByGrad(grad);
            }
            else {
                result = akcijeDarivanjaService.getAkcijeDarivanjaKrvi();
            }
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

    @GetMapping("/akcija_darivanja_krvi/brojDarivanjaPoMjesecu")
    @ApiOperation(value = "Dobavljanje broja darivanja krvi po mjesecu!")
    public List<Integer> getBrojDarivanjaPoMjesecu() {
        return akcijeDarivanjaService.getBrojDarivanjaPoMjesecu();
    }

    @GetMapping("/akcija_darivanja_krvi/{id}")
    @ApiOperation(value = "Dobavljanje akcije darivanja krvi na osnovu ID!")
    public ResponseEntity<Object> getAkcijaDarivanjaKrvi(@PathVariable Long id) {
        AkcijaDarivanjaKrvi result = new AkcijaDarivanjaKrvi();

        try {
            result = akcijeDarivanjaService.getAkcijeDarivanjaKrviById(id);
        } catch (AkcijeDarivanjaKrviException ex) {
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
    @DeleteMapping("/akcija_darivanja_krvi/obrisi_sve")
    @ApiOperation(value = "Brisanje svih akcija darivanja krvi!")
    HashMap<String, String> obrisiSveAkcijeDarivanjaKrvi() {
        return akcijeDarivanjaService.deleteAll();
    }

    @DeleteMapping("/akcija_darivanja_krvi/{id}")
    @ApiOperation(value = "Brisanje akcije darivanja krvi sa određenim ID!")
    public ResponseEntity<Object> obrisiAkcijuDarivanjaKrvi(@PathVariable Long id) {
        try {
            akcijeDarivanjaService.deleteById(id);
        } catch (AkcijeDarivanjaKrviException ex) {
            GeneralException exception = new GeneralException("NOT_FOUND", ex.getMessage());
            return new ResponseEntity<>(
                    exception,
                    HttpStatus.BAD_REQUEST
            );
        }

        return new ResponseEntity<>(
                "Uspjesno obrisana akcija za darivanje krvi sa id " + id,
                HttpStatus.OK
        );
    }

    // POST metoda
    @PostMapping("/akcija_darivanja_krvi")
    @ApiOperation(value = "Kreiranje nove akcije darivanja krvi!")
    AkcijaDarivanjaKrvi addAkcijaDarivanja(@RequestBody AkcijaDarivanjaKrvi akcijaDarivanja) {
        return akcijeDarivanjaService.addAkcijaDarivanja(akcijaDarivanja);
    }

    // PUT metoda
    @PutMapping("/akcija_darivanja_krvi/{id}")
    @ApiOperation(value = "Ažuriranje akcije darivanja krvi sa određenim ID!")
    ResponseEntity<JSONObject> editAkcijeDarivanjaKrvi(@RequestBody AkcijaDarivanjaKrvi novaAkcijaDarivanja, @PathVariable Long id) throws Exception {
        JSONObject message = new JSONObject();
        try {
            akcijeDarivanjaService.editAkcija(novaAkcijaDarivanja, id);
            message.put("Poruka: ", "Uspjesno azurirana akcija darivanja sa id " + id);
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

    // PATCH
    @PatchMapping("/akcija_darivanja_krvi/{id}")
    @ApiOperation(value = "Ažuriranje samo određenih podataka akcije darivanja krvi!")
    public ResponseEntity<JSONObject> partialUpdateAkcija(@RequestBody AkcijaDarivanjaKrvi akcija, @PathVariable("id") Long id) {
        JSONObject message = new JSONObject();
        try {
            akcijeDarivanjaService.partialUpdateAkcija(akcija, id);
            message.put("Poruka: ", "Uspjesno azurirana akcija darivanja krvi sa id " + id);
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

    @GetMapping("/zavrseneAkcijeDarivanja")
    @ApiOperation(value = "Dobavljanje akcija darivanja krvi koje su završene!")
    public List<AkcijaDarivanjaKrvi> zavrseneAkcije() throws Exception {
        List<AkcijaDarivanjaKrvi> zavrseneAkcije = akcijeDarivanjaService.zavrseneAkcije();
        return zavrseneAkcije;
    }
}
