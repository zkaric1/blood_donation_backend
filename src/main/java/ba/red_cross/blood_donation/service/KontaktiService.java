/*package ba.red_cross.blood_donation.service;

import ba.red_cross.blood_donation.model.TKontaktiEntity;
import ba.red_cross.blood_donation.repository.KontaktiRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class KontaktiService {

    @Autowired
    private KontaktiRepository kontaktiRepository;

    public TKontaktiEntity dodajKontakt(TKontaktiEntity noviKontakt) throws Exception {
        TKontaktiEntity postojeciKontakt = kontaktiRepository.findByEmailAndVazi(noviKontakt.getEmail(),true);
        if(postojeciKontakt != null) {
            throw new Exception("Postoji korisnik sa istim emailom");
        }
        return kontaktiRepository.save(noviKontakt);
    }
}

*/