package ba.red_cross.blood_donation.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
public class AkcijaDarivanjaKrvi {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ID;

    @NotBlank(message = "Adresa održavanja akcije darivanja ne može biti prazno!")
    private String adresa;

    @NotBlank(message = "Grad održavanja akcije darivanja ne može biti prazno!")
    private String grad;

    @NotNull(message = "Datum održavanja akcije darivanja ne može biti prazno!")
    private LocalDate datum;

    @NotNull(message = "Početak održavanja akcije darivanja ne može biti prazno!")
    private LocalTime pocetak;

    @NotNull(message = "Početak održavanja akcije darivanja ne može biti prazno!")
    private LocalTime kraj;

    @NotBlank(message = "Naslov akcije darivanja ne može biti prazno!")
    private String naslov;

/*    @ManyToMany(targetEntity = Korisnik.class, mappedBy = "akcije", cascade = CascadeType.ALL)
    private List<Korisnik> korisnici;

    @JsonManagedReference
    public List<Korisnik> getKorisnici() {
        return korisnici;
    }

    public void setKorisnici(List<Korisnik> korisnici) {
        this.korisnici = korisnici;
    }*/

    // Korisnik n-n
    //bilo all
    @ManyToMany(mappedBy = "akcijeDarivanja", cascade = {CascadeType.REFRESH})
    @JsonBackReference
    private Set<Korisnik> korisnici = new HashSet<Korisnik>();

    public AkcijaDarivanjaKrvi() {}

    public AkcijaDarivanjaKrvi(String adresa, String grad, LocalDate datum, LocalTime pocetak, LocalTime kraj, String naslov) {
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

    public LocalDate getDatum() {
        return datum;
    }

    public void setDatum(LocalDate datum) {
        this.datum = datum;
    }

    public LocalTime getPocetak() {
        return pocetak;
    }

    public void setPocetak(LocalTime pocetak) {
        this.pocetak = pocetak;
    }

    public LocalTime getKraj() {
        return kraj;
    }

    public void setKraj(LocalTime kraj) {
        this.kraj = kraj;
    }

    public String getNaslov() {
        return naslov;
    }

    public void setNaslov(String naslov) {
        this.naslov = naslov;
    }

//    public Set<Korisnik> getKorisnici() {
//        return korisnici;
//    }
//
//    public void setKorisnici(Set<Korisnik> korisnici) {
//        this.korisnici = korisnici;
//    }
}
