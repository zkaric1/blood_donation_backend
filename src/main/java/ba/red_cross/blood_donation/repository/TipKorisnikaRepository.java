package ba.red_cross.blood_donation.repository;

import ba.red_cross.blood_donation.model.TTipKorisnikaEntity;
import org.springframework.data.repository.CrudRepository;

public interface TipKorisnikaRepository extends CrudRepository<TTipKorisnikaEntity, Integer> {
    TTipKorisnikaEntity findByTipKorisnikaAndVazi(String tipKorisnika, boolean vazi);
    TTipKorisnikaEntity findByNazivAndVazi(String naziv, boolean vazi);
}
