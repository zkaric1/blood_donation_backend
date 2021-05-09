package ba.red_cross.blood_donation;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

public class TKontaktTipoviEntityPK implements Serializable {
    private int kontaktId;
    private String tipKontakta;

    @Column(name = "KONTAKT_ID")
    @Id
    public int getKontaktId() {
        return kontaktId;
    }

    public void setKontaktId(int kontaktId) {
        this.kontaktId = kontaktId;
    }

    @Column(name = "TIP_KONTAKTA")
    @Id
    public String getTipKontakta() {
        return tipKontakta;
    }

    public void setTipKontakta(String tipKontakta) {
        this.tipKontakta = tipKontakta;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TKontaktTipoviEntityPK that = (TKontaktTipoviEntityPK) o;

        if (kontaktId != that.kontaktId) return false;
        if (tipKontakta != null ? !tipKontakta.equals(that.tipKontakta) : that.tipKontakta != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = kontaktId;
        result = 31 * result + (tipKontakta != null ? tipKontakta.hashCode() : 0);
        return result;
    }
}
