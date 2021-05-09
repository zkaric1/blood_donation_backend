package ba.red_cross.blood_donation.repository;

import ba.red_cross.blood_donation.model.TKorisniciEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface KorisniciRepository extends CrudRepository<TKorisniciEntity, Integer> {
   TKorisniciEntity findByKorisnickoImeAndVazi(String korisnickoIme, boolean vazi);
   List<TKorisniciEntity> findAllByTipKorisnikaAndVazi(String tipKorisnika, boolean vazi);
}
