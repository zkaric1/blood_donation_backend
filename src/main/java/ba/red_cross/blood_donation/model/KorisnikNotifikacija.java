package ba.red_cross.blood_donation.model;

import javax.persistence.*;

@Entity
public class KorisnikNotifikacija {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "korisnik_id", referencedColumnName = "id")
    Korisnik korisnik;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "notifikacija_id", referencedColumnName = "id")
    Notifikacija notifikacija;
}
