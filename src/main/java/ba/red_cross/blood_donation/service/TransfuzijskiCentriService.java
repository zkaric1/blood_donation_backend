package ba.red_cross.blood_donation.service;

import ba.red_cross.blood_donation.model.TransfuzijskiCentar;
import ba.red_cross.blood_donation.repository.TransfuzijskiCentarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransfuzijskiCentriService {

    @Autowired
    private TransfuzijskiCentarRepository transfuzijskiCentarRepository;

    public List<TransfuzijskiCentar> getTransfuzijskiCentri () throws Exception {
        if (transfuzijskiCentarRepository.count() == 0) {
            throw new Exception("Nema dodanih centara!");
        }
        return transfuzijskiCentarRepository.findAll();
    }

}
