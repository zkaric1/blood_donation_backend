package ba.red_cross.blood_donation.model;

import javax.persistence.*;

@Entity
@Table(name = "T_TIMOVI", schema = "dbo", catalog = "ck_db")
public class TTimoviEntity {
    private String tim;
    private String naziv;
    private boolean vazi;

    @Id
    @Column(name = "TIM")
    public String getTim() {
        return tim;
    }

    public void setTim(String tim) {
        this.tim = tim;
    }

    @Basic
    @Column(name = "NAZIV")
    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    @Basic
    @Column(name = "VAZI")
    public boolean isVazi() {
        return vazi;
    }

    public void setVazi(boolean vazi) {
        this.vazi = vazi;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TTimoviEntity that = (TTimoviEntity) o;

        if (vazi != that.vazi) return false;
        if (tim != null ? !tim.equals(that.tim) : that.tim != null) return false;
        if (naziv != null ? !naziv.equals(that.naziv) : that.naziv != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = tim != null ? tim.hashCode() : 0;
        result = 31 * result + (naziv != null ? naziv.hashCode() : 0);
        result = 31 * result + (vazi ? 1 : 0);
        return result;
    }
}
