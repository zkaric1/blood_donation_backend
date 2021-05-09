package ba.red_cross.blood_donation.repository;

import ba.red_cross.blood_donation.model.TKontaktiEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface KontaktiRepository extends CrudRepository<TKontaktiEntity, Integer> {
    List<TKontaktiEntity> findAllByKrvnaGrupaAndVazi(String krvnaGrupa, boolean vazi);
    TKontaktiEntity findByEmailAndVazi(String email, boolean vazi);
}
