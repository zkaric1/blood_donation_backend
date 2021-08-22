package ba.red_cross.blood_donation.repository;

import ba.red_cross.blood_donation.model.Korisnik;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.*;

@Repository
public interface KorisnikRepository extends JpaRepository<Korisnik, Long> {
    Korisnik findByKorisnickoIme (String korisnickoIme);
    Korisnik findByLozinka (String lozinka);
    List<Korisnik> findByKrvnaGrupa (String krvnaGrupa);
    Korisnik findByEmailAdresa(String email);
    Korisnik findByID(Long id);

    @Query(value = "SELECT * FROM korisnik WHERE ime = :ime AND prezime = :prezime", nativeQuery = true)
    List<Korisnik> findByImePrezime(@Param("ime") String ime, @Param("prezime") String prezime);
}