package ba.red_cross.blood_donation.repository;

import ba.red_cross.blood_donation.model.KorisnikAkcijaDarivanjaKrvi;
import ba.red_cross.blood_donation.model.KorisnikNotifikacija;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KorisnikAkcijaDarivanjaKrviRepository extends JpaRepository<KorisnikAkcijaDarivanjaKrvi, Long> {
}
