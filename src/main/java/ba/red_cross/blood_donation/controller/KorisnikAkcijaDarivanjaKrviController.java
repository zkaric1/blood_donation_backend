package ba.red_cross.blood_donation.controller;
import ba.red_cross.blood_donation.DTO.KorisnikAkcijaDarivanjaKrviDTO;
import ba.red_cross.blood_donation.exception.GeneralException;
import ba.red_cross.blood_donation.model.AkcijaDarivanjaKrvi;
import ba.red_cross.blood_donation.model.KorisnikAkcijaDarivanjaKrvi;
import ba.red_cross.blood_donation.service.KorisnikAkcijaDarivanjaKrviService;
import ba.red_cross.blood_donation.utils.CheckAuth;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@RestController
@Api( tags = "Korisnik - akcije darivanja krvi")
public class KorisnikAkcijaDarivanjaKrviController {
    private CheckAuth checkAuth = new CheckAuth();

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
        if(!checkAuth.isAuthorized(SecurityContextHolder.getContext().getAuthentication(), id)) {
            Exception exception =  new Exception("Unauthorized");
            return new ResponseEntity<>(
                    exception,
                    HttpStatus.UNAUTHORIZED
            );
        }
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
        if(!checkAuth.isAuthorized(SecurityContextHolder.getContext().getAuthentication(), id)) {
            Exception exception =  new Exception("Unauthorized");
            return new ResponseEntity<>(
                    exception,
                    HttpStatus.UNAUTHORIZED
            );
        }
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

    @GetMapping("/korisnikAkcijeDarivanja/korisnikListaAkcija/{id}")
    @ApiOperation(value = "Dobavljanje lista akcije darivanja krvi za korisnika sa ID!")
    public ResponseEntity<Object> findAkcijeByKorisnikId(@PathVariable Long id) {
        List<AkcijaDarivanjaKrvi> result = new ArrayList<>();
        try {
            result = korisnikAkcijeDarivanjaService.findAkcijeByKorisnikId(id);
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
    KorisnikAkcijaDarivanjaKrvi addKorisnikAkcijaDarivanja( @RequestBody KorisnikAkcijaDarivanjaKrviDTO akcijaDarivanja) throws Exception {
        return korisnikAkcijeDarivanjaService.createNew(akcijaDarivanja);
    }

    @GetMapping("/brojDarivanjaPoAkciji/{id}")
    @ApiOperation(value = "Dobavljanje broja darivanja krvi za određenu akciju!")
    public ResponseEntity<Object> getBrojDarivanja(@PathVariable("id") Long id) throws Exception {
        Integer brojDarivanja = 0;
        try {
            brojDarivanja = korisnikAkcijeDarivanjaService.getBrojDarivanjaZaAkciju(id);
        } catch (Exception ex) {
            GeneralException exception = new GeneralException("NOT_FOUND", ex.getMessage());
            return new ResponseEntity<>(
                    exception,
                    HttpStatus.BAD_REQUEST
            );
        }

        return new ResponseEntity<>(
                brojDarivanja,
                HttpStatus.OK
        );
    }

    @GetMapping("/korisnikAkcijeDarivanja/posljednjeDarivanje/{id}")
    @ApiOperation(value = "Dobavljanje datuma zadnjeg darivanja krvi korisnika sa ID!")
    public LocalDate dobaviPosljednjeDarivanje(@PathVariable Long id) {
        LocalDate result = null;
        result = korisnikAkcijeDarivanjaService.posljednjeDarivanje(id);
        return result;
    }
}

