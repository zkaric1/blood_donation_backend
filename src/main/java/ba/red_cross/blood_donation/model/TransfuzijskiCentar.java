package ba.red_cross.blood_donation.model;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
public class TransfuzijskiCentar {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ID;

    @NotBlank(message = "Grad ne moze biti prazan!")
    private String grad;

    @NotBlank(message = "Adresa ne moze biti prazna!")
    private String adresa;

    @NotBlank(message = "Naziv ustanove ne smije biti prazan")
    private String ustanova;

    @NotBlank(message = "Kontakt telefon ne moze biti prazan!")
    private String kontaktTelefon;

    public TransfuzijskiCentar() {}
    public TransfuzijskiCentar (String adresa, String grad,  String kontaktTelefon, String ustanova) {
        this.grad = grad;
        this.adresa = adresa;
        this.kontaktTelefon = kontaktTelefon;
        this.ustanova = ustanova;
    }

    public String getUstanova() {
        return ustanova;
    }

    public void setUstanova(String ustanova) {
        this.ustanova = ustanova;
    }

    public Long getID() {
        return ID;
    }

    public void setID(Long ID) {
        this.ID = ID;
    }

    public String getGrad() {
        return grad;
    }

    public void setGrad(String grad) {
        this.grad = grad;
    }

    public String getAdresa() {
        return adresa;
    }

    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }

    public String getKontaktTelefon() {
        return kontaktTelefon;
    }

    public void setKontaktTelefon(String kontaktTelefon) {
        this.kontaktTelefon = kontaktTelefon;
    }

}
