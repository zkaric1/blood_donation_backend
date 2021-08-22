package ba.red_cross.blood_donation.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
public class KorisnikAkcijaDarivanjaKrvi {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ID;

    @ManyToOne(fetch = FetchType.EAGER)
    @JsonIgnoreProperties(value = {"applications", "hibernateLazyInitializer"})
    @JoinColumn(name = "korisnik_id")
    private Korisnik korisnik;

    @ManyToOne(fetch = FetchType.EAGER)
    @JsonIgnoreProperties(value = {"applications", "hibernateLazyInitializer"})
    @JoinColumn(name = "akcija_darivanja_krvi_id")
    private AkcijaDarivanjaKrvi akcijaDarivanjaKrvi;

    private String status;

    public KorisnikAkcijaDarivanjaKrvi() {
    }

    public KorisnikAkcijaDarivanjaKrvi(Korisnik korisnik, AkcijaDarivanjaKrvi akcijaDarivanjaKrvi, String status) {
        this.korisnik = korisnik;
        this.akcijaDarivanjaKrvi = akcijaDarivanjaKrvi;
        this.status = status;
    }

    public Korisnik getKorisnik() {
        return korisnik;
    }

    public Long getID() {
        return ID;
    }

    public void setID(Long ID) {
        this.ID = ID;
    }

    public void setKorisnik(Korisnik korisnik) {
        this.korisnik = korisnik;
    }


    public AkcijaDarivanjaKrvi getAkcijaDarivanjaKrvi() {
        return akcijaDarivanjaKrvi;
    }


    public void setAkcijaDarivanjaKrvi(AkcijaDarivanjaKrvi akcijaDarivanjaKrvi) {
        this.akcijaDarivanjaKrvi = akcijaDarivanjaKrvi;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
