package ba.red_cross.blood_donation.repository;

import ba.red_cross.blood_donation.model.TTipKontaktaEntity;
import org.springframework.data.repository.CrudRepository;

public interface TipKontaktaRepository extends CrudRepository<TTipKontaktaEntity, Integer> {
    TTipKontaktaEntity findByTipKontaktaAndVazi(String tipKontakta, boolean vazi);
    TTipKontaktaEntity findByNazivAndVazi(String naziv, boolean vazi);
}
