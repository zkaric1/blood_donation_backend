package ba.red_cross.blood_donation.model;

import javax.persistence.*;

@Entity
public class KorisnikAkcijaDarivanjaKrvi {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "korisnik_id", referencedColumnName = "id")
    Korisnik korisnik;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "akcija_darivanja_krvi_id", referencedColumnName = "id")
    AkcijaDarivanjaKrvi akcijaDarivanjaKrvi;

    String status;
}
