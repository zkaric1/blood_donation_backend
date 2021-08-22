package ba.red_cross.blood_donation.repository;

import ba.red_cross.blood_donation.model.Korisnik;
import ba.red_cross.blood_donation.model.KorisnikNotifikacija;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KorisnikNotifikacijaRepository  extends JpaRepository<KorisnikNotifikacija, Long> {
    void deleteKorisnikNotifikacijaByKorisnik_ID(Long id);
    void deleteKorisnikNotifikacijaByKorisnik_IDAndNotifikacija_ID(Long korisnikID, Long notifikacijaID);
}
