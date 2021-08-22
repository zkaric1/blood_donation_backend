package ba.red_cross.blood_donation.repository;

import ba.red_cross.blood_donation.model.Korisnik;
import ba.red_cross.blood_donation.model.Notifikacija;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public interface NotifikacijaRepository extends JpaRepository<Notifikacija, Long> {

}