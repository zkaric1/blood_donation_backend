package ba.red_cross.blood_donation.service;

import ba.red_cross.blood_donation.DTO.ResponseMessageDTO;
import ba.red_cross.blood_donation.exception.AkcijeDarivanjaKrviException;
import ba.red_cross.blood_donation.model.AkcijaDarivanjaKrvi;
import ba.red_cross.blood_donation.repository.AkcijeDarivanjaKrviRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class AkcijeDarivanjaKrviService {

    @Autowired
    private AkcijeDarivanjaKrviRepository akcijeDarivanjaKrviRepository;

    public AkcijeDarivanjaKrviService (AkcijeDarivanjaKrviRepository akcijeDarivanjaKrviRepository) {
        this.akcijeDarivanjaKrviRepository = akcijeDarivanjaKrviRepository;
    }


    public List<AkcijaDarivanjaKrvi> getAkcijeDarivanjaKrvi () throws  Exception{
        if (akcijeDarivanjaKrviRepository.count() == 0) {
            throw new Exception("Nema kreiranih akcija darivanja krvi!");
        }
        return akcijeDarivanjaKrviRepository.findAll();
    }

    public AkcijaDarivanjaKrvi getAkcijeDarivanjaKrviById (Long id) throws AkcijeDarivanjaKrviException {
        return akcijeDarivanjaKrviRepository.findById(id).orElseThrow(() -> new AkcijeDarivanjaKrviException("Akcija darivanja krvi sa ID " + id + " ne postoji!"));
    }

    public List<AkcijaDarivanjaKrvi> getAkcijeDarivanjaKrviByGrad (String grad) throws AkcijeDarivanjaKrviException {
        List<AkcijaDarivanjaKrvi> listaAkcijaDarivanja = akcijeDarivanjaKrviRepository.findAllByGrad(grad);
        System.out.print(listaAkcijaDarivanja.size());
        if (listaAkcijaDarivanja.size() == 0) {
            throw new AkcijeDarivanjaKrviException("Akcije darivanja krvi za grad " + grad + " ne postoje!");
        }

        return listaAkcijaDarivanja;
    }

    public HashMap<String,String> deleteAll () throws Exception {
        if (akcijeDarivanjaKrviRepository.count() == 0) return new ResponseMessageDTO("Nema kreiranih akcija darivanja krvi!").getHashMap();
        akcijeDarivanjaKrviRepository.deleteAll();
        if (akcijeDarivanjaKrviRepository.count() == 0) return new ResponseMessageDTO("Uspjesno obrisane sve akcije darivanja krvi!").getHashMap();
        return new ResponseMessageDTO("Greska pri brisanju akcija darivanja krvi!").getHashMap();
    }

    public HashMap<String,String> deleteById (Long id) throws Exception {
        if (akcijeDarivanjaKrviRepository.count() == 0) return new ResponseMessageDTO("Nema kreiranih akcija darivanja krvi!").getHashMap();
        boolean exists = akcijeDarivanjaKrviRepository.existsById(id);
        if (exists) {
            akcijeDarivanjaKrviRepository.deleteById(id);
            return new ResponseMessageDTO("Uspjesno obrisana akcija darivanja krvi sa id " + id).getHashMap();
        }
        return new ResponseMessageDTO("Ne postoji akcija darivanja krvi sa id " + id).getHashMap();
    }

    public AkcijaDarivanjaKrvi addAkcijaDarivanja (AkcijaDarivanjaKrvi akcijaDarivanjaKrvi) {
        return akcijeDarivanjaKrviRepository.save(akcijaDarivanjaKrvi);
    }
}
