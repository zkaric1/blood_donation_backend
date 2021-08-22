package ba.red_cross.blood_donation.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
public class KorisnikNotifikacija {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ID;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnoreProperties(value = {"applications", "hibernateLazyInitializer"})
    @JoinColumn(name = "korisnik_id")
    private Korisnik korisnik;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnoreProperties(value = {"applications", "hibernateLazyInitializer"})
    @JoinColumn(name = "notifikacija_id")
    private Notifikacija notifikacija;

    public KorisnikNotifikacija() {
    }

    public KorisnikNotifikacija(Korisnik korisnik, Notifikacija notifikacija) {
        this.korisnik = korisnik;
        this.notifikacija = notifikacija;
    }

    public Long getID() {
        return ID;
    }

    public void setID(Long ID) {
        this.ID = ID;
    }

    public Korisnik getKorisnik() {
        return korisnik;
    }

    public void setKorisnik(Korisnik korisnik) {
        this.korisnik = korisnik;
    }

    public Notifikacija getNotifikacija() {
        return notifikacija;
    }

    public void setNotifikacija(Notifikacija notifikacija) {
        this.notifikacija = notifikacija;
    }
}
