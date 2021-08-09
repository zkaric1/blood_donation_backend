package ba.red_cross.blood_donation.repository;
import ba.red_cross.blood_donation.model.AkcijaDarivanjaKrvi;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.*;

@Repository
public interface AkcijeDarivanjaKrviRepository extends JpaRepository<AkcijaDarivanjaKrvi, Long> {

    List<AkcijaDarivanjaKrvi> findAllByGrad (String grad);
    boolean existsById(Long id);

    @Query(value = "SELECT CAST (SUBSTRING (CAST(bc.datum as varchar), 6, 2) as integer) mjesec, CAST (COUNT(b.akcije_darivanja_krvi_id) as integer) broj_darivanja FROM korisnik_akcije_darivanja b LEFT JOIN akcija_darivanja_krvi bc on b.akcije_darivanja_krvi_id = bc.id WHERE b.akcije_darivanja_krvi_id = bc.id AND (SUBSTRING (CAST(bc.datum as varchar), 1, 4) = :godina) GROUP BY b.akcije_darivanja_krvi_id, bc.datum", nativeQuery = true)
    List<Map<Integer,Integer>> getBrojDarivanjaPoMjesecu(@Param("godina") String godina);
}


