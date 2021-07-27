package ba.red_cross.blood_donation.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
public class Rola {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ID;
    @NotBlank(message = "Naziv role ne može biti prazno!")
    private String nazivRole;

    public Rola() {
    }

    public Rola(String nazivRole) {
        this.nazivRole = nazivRole;
    }

    public String getNazivRole() {
        return nazivRole;
    }

    public void setNazivRole(String nazivRole) {
        this.nazivRole = nazivRole;
    }

    public Long getID() {
        return ID;
    }

    public void setID(Long ID) {
        this.ID = ID;
    }
}
