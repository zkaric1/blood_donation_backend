package ba.red_cross.blood_donation.repository;

import ba.red_cross.blood_donation.model.TransfuzijskiCentar;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransfuzijskiCentarRepository extends JpaRepository<TransfuzijskiCentar, Long> {
}