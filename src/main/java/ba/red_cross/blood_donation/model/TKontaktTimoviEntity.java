package ba.red_cross.blood_donation.model;


import javax.persistence.*;

@Entity
@Table(name = "T_KONTAKT_TIMOVI", schema = "dbo", catalog = "ck_db")
@IdClass(TKontaktTimoviEntityPK.class)
public class TKontaktTimoviEntity {
    private int kontaktId;
    private String tim;

    @Id
    @Column(name = "KONTAKT_ID")
    public int getKontaktId() {
        return kontaktId;
    }

    public void setKontaktId(int kontaktId) {
        this.kontaktId = kontaktId;
    }

    @Id
    @Column(name = "TIM")
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

        TKontaktTimoviEntity that = (TKontaktTimoviEntity) o;

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
