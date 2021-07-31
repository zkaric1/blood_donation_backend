package ba.red_cross.blood_donation.repository;

import ba.red_cross.blood_donation.model.Korisnik;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KorisnikRepository extends JpaRepository<Korisnik, Long> {
    Korisnik findByKorisnickoIme (String korisnickoIme);
}