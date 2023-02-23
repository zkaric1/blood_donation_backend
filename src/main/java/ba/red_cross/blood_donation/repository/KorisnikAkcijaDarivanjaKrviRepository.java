package ba.red_cross.blood_donation.repository;

import ba.red_cross.blood_donation.model.KorisnikAkcijaDarivanjaKrvi;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface KorisnikAkcijaDarivanjaKrviRepository extends JpaRepository<KorisnikAkcijaDarivanjaKrvi, Long> {

    @Query(value = "SELECT * FROM korisnik_akcija_darivanja_krvi WHERE korisnik_id = :id", nativeQuery = true)
    List<KorisnikAkcijaDarivanjaKrvi> findAllByKorisnikId(@Param("id") Long id);

    @Query(value = "SELECT * FROM korisnik_akcija_darivanja_krvi WHERE akcija_darivanja_krvi_id = :id", nativeQuery = true)
    List<KorisnikAkcijaDarivanjaKrvi> findAllByKorisnikAkcijaId(@Param("id") Long id);

    @Query(value = "SELECT akcija_darivanja_krvi_id FROM korisnik_akcija_darivanja_krvi WHERE korisnik_id = :id", nativeQuery = true)
    List<Long> findAkcijeByKorisnikID(@Param("id") Long id);

    @Query (value = "SELECT COUNT (korisnik_id) FROM korisnik_akcija_darivanja_krvi WHERE akcija_darivanja_krvi_id = :id", nativeQuery = true)
    Integer getBrojDarivanjaZaAkciju (@Param("id") Long id);
}
