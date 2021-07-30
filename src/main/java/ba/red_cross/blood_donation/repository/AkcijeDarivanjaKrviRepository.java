package ba.red_cross.blood_donation.repository;
import ba.red_cross.blood_donation.model.AkcijaDarivanjaKrvi;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.*;

@Repository
public interface AkcijeDarivanjaKrviRepository extends JpaRepository<AkcijaDarivanjaKrvi, Long> {

    List<AkcijaDarivanjaKrvi> findAllByGrad (String grad);
    boolean existsById(Long id);
}