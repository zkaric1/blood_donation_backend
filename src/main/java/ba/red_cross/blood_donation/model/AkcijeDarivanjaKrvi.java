package ba.red_cross.blood_donation.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.sql.Time;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
public class AkcijeDarivanjaKrvi {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ID;

    @NotBlank(message = "Adresa održavanja akcije darivanja ne može biti prazno!")
    private String adresa;

    @NotBlank(message = "Grad održavanja akcije darivanja ne može biti prazno!")
    private String grad;

    @NotBlank(message = "Datum održavanja akcije darivanja ne može biti prazno!")
    private Date datum;

    @NotBlank(message = "Početak održavanja akcije darivanja ne može biti prazno!")
    private Time pocetak;

    @NotBlank(message = "Početak održavanja akcije darivanja ne može biti prazno!")
    private Time kraj;

    @NotBlank(message = "Naslov akcije darivanja ne može biti prazno!")
    private String naslov;

    // Korisnik n-n
    @ManyToMany(mappedBy = "akcijeDarivanja", cascade = { CascadeType.ALL })
    private Set<Korisnik> korisnici = new HashSet<Korisnik>();

    public AkcijeDarivanjaKrvi() {}

    public AkcijeDarivanjaKrvi(String adresa, String grad, Date datum, Time pocetak, Time kraj, String naslov) {
        this.adresa = adresa;
        this.grad = grad;
        this.datum = datum;
        this.pocetak = pocetak;
        this.kraj = kraj;
        this.naslov = naslov;
    }

    public Long getID() {
        return ID;
    }

    public void setID(Long ID) {
        this.ID = ID;
    }

    public String getAdresa() {
        return adresa;
    }

    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }

    public String getGrad() {
        return grad;
    }

    public void setGrad(String grad) {
        this.grad = grad;
    }

    public Date getDatum() {
        return datum;
    }

    public void setDatum(Date datum) {
        this.datum = datum;
    }

    public Time getPocetak() {
        return pocetak;
    }

    public void setPocetak(Time pocetak) {
        this.pocetak = pocetak;
    }

    public Time getKraj() {
        return kraj;
    }

    public void setKraj(Time kraj) {
        this.kraj = kraj;
    }

    public String getNaslov() {
        return naslov;
    }

    public void setNaslov(String naslov) {
        this.naslov = naslov;
    }

    public Set<Korisnik> getKorisnici() {
        return korisnici;
    }

    public void setKorisnici(Set<Korisnik> korisnici) {
        this.korisnici = korisnici;
    }
}
