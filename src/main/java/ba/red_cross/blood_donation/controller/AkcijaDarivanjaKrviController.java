package ba.red_cross.blood_donation.controller;

import ba.red_cross.blood_donation.exception.AkcijeDarivanjaKrviException;
import ba.red_cross.blood_donation.exception.GeneralException;
import ba.red_cross.blood_donation.model.AkcijaDarivanjaKrvi;
import ba.red_cross.blood_donation.service.AkcijeDarivanjaKrviService;
import io.swagger.annotations.ApiOperation;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.*;

@RestController
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
            if (grad != null) result = akcijeDarivanjaService.getAkcijeDarivanjaKrviByGrad(grad);
            else result = akcijeDarivanjaService.getAkcijeDarivanjaKrvi();
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
    HashMap<String, String> obrisiSveAkcijeDarivanjaKrvi() throws Exception {
        return akcijeDarivanjaService.deleteAll();
    }

    @DeleteMapping("/akcija_darivanja_krvi/{id}")
    @ApiOperation(value = "Brisanje akcij darivanja krvi sa određenim ID!")
    HashMap<String, String> obrisiAkcijuDarivanjaKrvi(@PathVariable Long id) throws Exception {
        return akcijeDarivanjaService.deleteById(id);
    }

    // POST metoda
    @PostMapping("/akcija_darivanja_krvi")
    AkcijaDarivanjaKrvi addAkcijaDarivanja( @RequestBody AkcijaDarivanjaKrvi akcijaDarivanja) {
        return akcijeDarivanjaService.addAkcijaDarivanja (akcijaDarivanja);
    }
}
