package ba.red_cross.blood_donation.service;

import ba.red_cross.blood_donation.DTO.ResponseMessageDTO;
import ba.red_cross.blood_donation.exception.AkcijeDarivanjaKrviException;
import ba.red_cross.blood_donation.exception.NotifikacijaException;
import ba.red_cross.blood_donation.model.AkcijaDarivanjaKrvi;
import ba.red_cross.blood_donation.model.Notifikacija;
import ba.red_cross.blood_donation.repository.NotifikacijaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service
@Transactional
public class NotifikacijaService {

    @Autowired
    private NotifikacijaRepository notifikacijaRepository;


    public List<Notifikacija> getNotifikacije () throws Exception {
        if (notifikacijaRepository.count() == 0) {
            throw new Exception("Nema kreiranih notifikacija!");
        }
        return notifikacijaRepository.findAll();
    }

    public Notifikacija getNotifikacijaById (Long id) throws NotifikacijaException {
        return notifikacijaRepository.findById(id).orElseThrow(() -> new NotifikacijaException("Notifikacija sa ID " + id + " ne postoji!"));
    }

    public HashMap<String,String> deleteAll () throws Exception {
        if (notifikacijaRepository.count() == 0) return new ResponseMessageDTO("Nema kreiranih notifikacija!").getHashMap();
        notifikacijaRepository.deleteAll();
        if (notifikacijaRepository.count() == 0) return new ResponseMessageDTO("Uspjesno obrisane sve notifikacije!").getHashMap();
        return new ResponseMessageDTO("Greska pri brisanju notifikacija!").getHashMap();
    }

    public String obrisiNotifikacijeOdKorisnika(Long id) throws Exception {
       //  notifikacijaRepository.deleteAllByKorisnici_ID(id);
        return "Uspjesno obrisane notifikacije za kroisnika sa id " + id;
    }

    public HashMap<String,String> deleteById (Long id) throws Exception {
        if (notifikacijaRepository.count() == 0) return new ResponseMessageDTO("Nema notifikacija!").getHashMap();
        boolean exists = notifikacijaRepository.existsById(id);
        if (exists) {
            notifikacijaRepository.deleteById(id);
            return new ResponseMessageDTO("Uspjesno obrisana notifikacija sa id " + id).getHashMap();
        }
        return new ResponseMessageDTO("Ne postoji notifikacija sa id " + id).getHashMap();
    }

    public Notifikacija addNotifikacija (Notifikacija notifikacija) {
        return notifikacijaRepository.save(notifikacija);
    }

    public Notifikacija editNotifikacija (Notifikacija novaNotifikacija) throws NotifikacijaException {
        notifikacijaRepository.findById(novaNotifikacija.getID()).orElseThrow(() -> new AkcijeDarivanjaKrviException("Notifikacija sa ID " + novaNotifikacija.getID() + " ne postoji!"));
        notifikacijaRepository.findById(novaNotifikacija.getID()).map(

                notifikacija -> {
                    notifikacija.setTipNotifikacije(novaNotifikacija.getTipNotifikacije());
                    notifikacija.setKrvnaGrupa(novaNotifikacija.getKrvnaGrupa());
                    notifikacija.setNaslov(novaNotifikacija.getNaslov());
                    notifikacija.setTekst(novaNotifikacija.getTekst());
                    return notifikacijaRepository.save(notifikacija);
                }
        );

        return notifikacijaRepository.findById(novaNotifikacija.getID()).get();
    }
}
