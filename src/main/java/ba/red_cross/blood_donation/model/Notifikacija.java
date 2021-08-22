package ba.red_cross.blood_donation.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,property = "id")
public class Notifikacija {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ID;

    @NotBlank(message = "Naslov notifikacije ne moze biti prazno!")
    private String naslov;
    private String tekst;
    private String adresa;

    @NotBlank(message = "Tip notifikacije ne moze biti prazno!")
    private String tipNotifikacije;
    private String krvnaGrupa;

    @OneToMany(
            mappedBy = "notifikacija",
            fetch = FetchType.LAZY,
            cascade = CascadeType.ALL,
            orphanRemoval = true)
    private List<KorisnikNotifikacija> korisniciNotifikacije = new ArrayList<>();

    public List<KorisnikNotifikacija> getKorisniciNotifikacije() {
        return korisniciNotifikacije;
    }

    public void setKorisniciNotifikacije(List<KorisnikNotifikacija> korisniciNotifikacije) {
        this.korisniciNotifikacije = korisniciNotifikacije;
    }

    //    // Korisnik n-n
/*    @ManyToMany(mappedBy = "notifikacije", cascade = { CascadeType.ALL })
    @JsonBackReference
    private Set<Korisnik> korisnici = new HashSet<Korisnik>();*/

   /* public Set<Korisnik> getKorisnici() {
        return korisnici;
    }*/

    public String getAdresa() {
        return adresa;
    }

    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }

  /*  public void setKorisnici(Set<Korisnik> korisnici) {
        this.korisnici = korisnici;
    }*/

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

}
