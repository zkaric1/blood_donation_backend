package ba.red_cross.blood_donation.controller;

import ba.red_cross.blood_donation.exception.GeneralException;
import ba.red_cross.blood_donation.model.TransfuzijskiCentar;
import ba.red_cross.blood_donation.service.TransfuzijskiCentriService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Api(tags = "TransfuzijskiCentri")
@RestController
public class TransfuzijskiCentriController {

    @Autowired
    private TransfuzijskiCentriService transfuzijskiCentriService;

    @GetMapping("/transfuzijski-centri/lista")
    @ApiOperation(value = "Dobavljanje svih centara!")
    ResponseEntity<Object> getCentri() {

        List<TransfuzijskiCentar> result;
        try {
            result = transfuzijskiCentriService.getTransfuzijskiCentri();
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
}
