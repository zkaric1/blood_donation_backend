package ba.red_cross.blood_donation;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

public class TKontaktTimoviEntityPK implements Serializable {
    private int kontaktId;
    private String tim;

    @Column(name = "KONTAKT_ID")
    @Id
    public int getKontaktId() {
        return kontaktId;
    }

    public void setKontaktId(int kontaktId) {
        this.kontaktId = kontaktId;
    }

    @Column(name = "TIM")
    @Id
    public String getTim() {
        return tim;
    }

    public void setTim(String tim) {
        this.tim = tim;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TKontaktTimoviEntityPK that = (TKontaktTimoviEntityPK) o;

        if (kontaktId != that.kontaktId) return false;
        if (tim != null ? !tim.equals(that.tim) : that.tim != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = kontaktId;
        result = 31 * result + (tim != null ? tim.hashCode() : 0);
        return result;
    }
}
