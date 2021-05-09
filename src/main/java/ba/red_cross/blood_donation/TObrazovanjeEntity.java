package ba.red_cross.blood_donation;

import javax.persistence.*;

@Entity
@Table(name = "T_OBRAZOVANJE", schema = "dbo", catalog = "ck_db")
public class TObrazovanjeEntity {
    private String obrazovanje;
    private String naziv;
    private boolean vazi;

    @Id
    @Column(name = "OBRAZOVANJE")
    public String getObrazovanje() {
        return obrazovanje;
    }

    public void setObrazovanje(String obrazovanje) {
        this.obrazovanje = obrazovanje;
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

        TObrazovanjeEntity that = (TObrazovanjeEntity) o;

        if (vazi != that.vazi) return false;
        if (obrazovanje != null ? !obrazovanje.equals(that.obrazovanje) : that.obrazovanje != null) return false;
        if (naziv != null ? !naziv.equals(that.naziv) : that.naziv != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = obrazovanje != null ? obrazovanje.hashCode() : 0;
        result = 31 * result + (naziv != null ? naziv.hashCode() : 0);
        result = 31 * result + (vazi ? 1 : 0);
        return result;
    }
}
