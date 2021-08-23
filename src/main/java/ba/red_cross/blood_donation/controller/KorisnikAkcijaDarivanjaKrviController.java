package ba.red_cross.blood_donation.controller;


import ba.red_cross.blood_donation.exception.AkcijeDarivanjaKrviException;
import ba.red_cross.blood_donation.exception.GeneralException;
import ba.red_cross.blood_donation.model.AkcijaDarivanjaKrvi;
import ba.red_cross.blood_donation.model.KorisnikAkcijaDarivanjaKrvi;
import ba.red_cross.blood_donation.service.AkcijeDarivanjaKrviService;
import ba.red_cross.blood_donation.service.KorisnikAkcijaDarivanjaKrviService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@Api( tags = "Korisnik - akcije darivanja krvi")
public class KorisnikAkcijaDarivanjaKrviController {

    KorisnikAkcijaDarivanjaKrviService korisnikAkcijeDarivanjaService;

    public KorisnikAkcijaDarivanjaKrviController(KorisnikAkcijaDarivanjaKrviService korisnikAkcijeDarivanjaService) {
        this.korisnikAkcijeDarivanjaService = korisnikAkcijeDarivanjaService;
    }

    // GET metode
    @GetMapping("/korisnikAkcijeDarivanja/lista")
    @ApiOperation(value = "Dobavljanje svih akcija darivanja i korisnika!")
    ResponseEntity<Object> getKorisnikAkcijeDarivanjaKrvi() {

        List<KorisnikAkcijaDarivanjaKrvi> result = new ArrayList<>();
        try {
            result = korisnikAkcijeDarivanjaService.getAll();
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

    @GetMapping("/korisnikAkcijeDarivanja/{id}")
    @ApiOperation(value = "Dobavljanje korisnik - akcije darivanja krvi na osnovu ID!")
    public ResponseEntity<Object> getKorisnikAkcijeDarivanjaKrviById(@PathVariable Long id) {
        KorisnikAkcijaDarivanjaKrvi result = new KorisnikAkcijaDarivanjaKrvi();

        try {
            result = korisnikAkcijeDarivanjaService.findById(id);
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

    @GetMapping("/korisnikAkcijeDarivanja/korisnik/{id}")
    @ApiOperation(value = "Dobavljanje akcije darivanja krvi korisnika na osnovu ID!")
    public ResponseEntity<Object> getAkcijeZaKorisnika(@PathVariable Long id) {
        List<KorisnikAkcijaDarivanjaKrvi> result = new ArrayList<>();

        try {
            result = korisnikAkcijeDarivanjaService.findAkcijeZaKorisnikaById(id);
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

    @GetMapping("/korisnikAkcijeDarivanja/akcija/{id}")
    @ApiOperation(value = "Dobavljanje podataka za akciju na osnovu ID!")
    public ResponseEntity<Object> findByAkcijaId(@PathVariable Long id) {
        List<KorisnikAkcijaDarivanjaKrvi> result = new ArrayList<>();

        try {
            result = korisnikAkcijeDarivanjaService.findByAkcijaId(id);
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

    // POST metoda
    @PostMapping("/korisnikAkcijeDarivanja")
    @ApiOperation(value = "Kreiranje nove korisnik - akcije darivanja krvi!")
    KorisnikAkcijaDarivanjaKrvi addKorisnikAkcijaDarivanja( @RequestBody KorisnikAkcijaDarivanjaKrvi akcijaDarivanja) {
        return korisnikAkcijeDarivanjaService.createNew(akcijaDarivanja);
    }
    //findByAkcijaId
}
