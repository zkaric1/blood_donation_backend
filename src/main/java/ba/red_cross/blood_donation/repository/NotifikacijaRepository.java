package ba.red_cross.blood_donation.repository;

import ba.red_cross.blood_donation.model.Notifikacija;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NotifikacijaRepository extends JpaRepository<Notifikacija, Long> {
}