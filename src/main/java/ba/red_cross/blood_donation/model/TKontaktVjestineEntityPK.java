package ba.red_cross.blood_donation.model;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

public class TKontaktVjestineEntityPK implements Serializable {
    private int kontaktId;
    private String vjestina;

    @Column(name = "KONTAKT_ID")
    @Id
    public int getKontaktId() {
        return kontaktId;
    }

    public void setKontaktId(int kontaktId) {
        this.kontaktId = kontaktId;
    }

    @Column(name = "VJESTINA")
    @Id
    public String getVjestina() {
        return vjestina;
    }

    public void setVjestina(String vjestina) {
        this.vjestina = vjestina;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TKontaktVjestineEntityPK that = (TKontaktVjestineEntityPK) o;

        if (kontaktId != that.kontaktId) return false;
        if (vjestina != null ? !vjestina.equals(that.vjestina) : that.vjestina != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = kontaktId;
        result = 31 * result + (vjestina != null ? vjestina.hashCode() : 0);
        return result;
    }
}
