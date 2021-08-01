package ba.red_cross.blood_donation.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Notifikacija {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ID;

    @NotBlank(message = "Naslov notifikacije ne moze biti prazno!")
    private String naslov;
    private String tekst;

    @NotBlank(message = "Tip notifikacije ne moze biti prazno!")
    private String tipNotifikacije;
    private String krvnaGrupa;

    // Korisnik n-n
    @ManyToMany(mappedBy = "notifikacije", cascade = { CascadeType.ALL })
    private Set<Korisnik> korisnici = new HashSet<Korisnik>();

    public Notifikacija(String naslov, String tekst, String tipNotifikacije, String krvnaGrupa) {
        this.naslov = naslov;
        this.tekst = tekst;
        this.tipNotifikacije = tipNotifikacije;
        this.krvnaGrupa = krvnaGrupa;
    }

    public Notifikacija(String naslov, String tekst, String tipNotifikacije) {
        this.naslov = naslov;
        this.tekst = tekst;
        this.tipNotifikacije = tipNotifikacije;
    }

    public Notifikacija() {
    }

    public Long getID() {
        return ID;
    }

    public void setID(Long ID) {
        this.ID = ID;
    }

    public String getNaslov() {
        return naslov;
    }

    public void setNaslov(String naslov) {
        this.naslov = naslov;
    }

    public String getTekst() {
        return tekst;
    }

    public void setTekst(String tekst) {
        this.tekst = tekst;
    }

    public String getTipNotifikacije() {
        return tipNotifikacije;
    }

    public void setTipNotifikacije(String tipNotifikacije) {
        this.tipNotifikacije = tipNotifikacije;
    }

    public String getKrvnaGrupa() {
        return krvnaGrupa;
    }

    public void setKrvnaGrupa(String krvnaGrupa) {
        this.krvnaGrupa = krvnaGrupa;
    }

    public Set<Korisnik> getKorisnici() {
        return korisnici;
    }

    public void setKorisnici(Set<Korisnik> korisnici) {
        this.korisnici = korisnici;
    }
}
