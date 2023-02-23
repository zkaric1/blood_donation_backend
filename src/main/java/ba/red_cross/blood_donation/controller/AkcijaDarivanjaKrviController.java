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
    @ApiOperation(value = "Dobavljanje svih kreiranih akcija darivanja krvi ili za određeni grad!")
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

    /*
    @GetMapping("/generisi_izvjestaj/{id}")
    @ApiOperation(value = "Generisanje i preuzimanje izvještaja nakon završene akcije darivanja!")
    public String generisiIzvjestaj(@PathVariable("id") Long id) throws Exception {
        String path = "C:\\Users\\belma\\Desktop\\Report";
        AkcijaDarivanjaKrvi akcija = akcijeDarivanjaService.getAkcijeDarivanjaKrviById(id);
        List<AkcijaDarivanjaKrvi> akcije = new ArrayList<>();
        akcije.add(akcija);
        String contents = "";

        File file = ResourceUtils.getFile("classpath:akcijeDarivanjaIzvjestaj.jrxml");
        JasperReport jasperReport = JasperCompileManager.compileReport(file.getAbsolutePath());
        JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(akcije);
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("createdBy", "Alma Ibrasimovic");

        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, dataSource);

        JasperExportManager.exportReportToPdfFile(jasperPrint, path + "\\akcija_darivanja_krvi" + akcija.getDatum() + ".pdf");

        return "Izvjestaj generisan na lokaciji : " + path;
    }

    @GetMapping("/generisi_izvjestaj/godisnji")
    @ApiOperation(value = "Generisanje i preuzimanje izvještaja za akcije darivanja u godini!")
    public ResponseEntity<byte[]> generisiGodisnjiIzvjestaj() throws Exception {
      //  String path = "C:\\Users\\belma\\Desktop\\Report";
        HashMap<String, Object> map = new HashMap<>();
        List<AkcijaDarivanjaKrvi> akcije = akcijeDarivanjaService.getAkcijeDarivanjaKrviTrenutnaGodina();
        //File file = ResourceUtils.getFile("classpath:godisnjiIzvjestaj.jrxml");
        JasperReport jasperReport = JasperCompileManager.compileReport(getClass().getResourceAsStream("/reports/godisnjiIzvjestaj.jrxml"));
        //JasperReport jasperReport = JasperCompileManager.compileReport(file.getAbsolutePath());
        JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(akcije);
        Map<String, Object> parameters = new HashMap<String,Object>();
        JasperPrint jasper = JasperFillManager.fillReport(jasperReport, parameters, dataSource);
        parameters.put("createdBy", "Alma Ibrasimovic");
        byte[] data = JasperExportManager.exportReportToPdf(jasper);
        LocalDate now = LocalDate.now();
     //   JasperExportManager.exportReportToPdfFile(jasperPrint, path + "\\godisnji_izvjestaj_" + now.getYear() + ".pdf");
        HttpHeaders headers = new HttpHeaders();
        headers.set(HttpHeaders.CONTENT_DISPOSITION, "inline;filename=godisnji_izvjestaj.pdf");
        return ResponseEntity.ok().contentType(MediaType.APPLICATION_PDF).body(data);
    }
*/
    @GetMapping("/zavrseneAkcijeDarivanja")
    @ApiOperation(value = "Dobavljanje akcija darivanja krvi koje su završene!")
    public List<AkcijaDarivanjaKrvi> zavrseneAkcije() throws Exception {
        List<AkcijaDarivanjaKrvi> zavrseneAkcije = akcijeDarivanjaService.zavrseneAkcije();
        return zavrseneAkcije;
    }
}
