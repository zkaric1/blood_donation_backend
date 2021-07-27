package ba.red_cross.blood_donation.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Priznanje {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ID;

    @NotBlank(message = "Naziv priznanja ne moze biti prazno!")
    private String nazivPriznanja;

    // Veze između tabela

    // Korisnik n-n
    @ManyToMany(mappedBy = "priznanja", cascade = { CascadeType.ALL })
    private Set<Korisnik> korisnici = new HashSet<Korisnik>();

    public Priznanje(String nazivPriznanja) {
        this.nazivPriznanja = nazivPriznanja;
    }

    public Priznanje() {
    }

    public Long getID() {
        return ID;
    }

    public void setID(Long ID) {
        this.ID = ID;
    }

    public String getNazivPriznanja() {
        return nazivPriznanja;
    }

    public void setNazivPriznanja(String nazivPriznanja) {
        this.nazivPriznanja = nazivPriznanja;
    }

    public Set<Korisnik> getKorisnici() {
        return korisnici;
    }

    public void setKorisnici(Set<Korisnik> korisnici) {
        this.korisnici = korisnici;
    }
}
