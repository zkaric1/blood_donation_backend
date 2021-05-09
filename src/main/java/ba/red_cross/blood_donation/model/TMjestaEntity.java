package ba.red_cross.blood_donation.model;

import javax.persistence.*;

@Entity
@Table(name = "T_MJESTA", schema = "dbo", catalog = "ck_db")
public class TMjestaEntity {
    private String postanskiBroj;
    private String naziv;
    private String nadredjeni;
    private boolean vazi;

    @Id
    @Column(name = "POSTANSKI_BROJ")
    public String getPostanskiBroj() {
        return postanskiBroj;
    }

    public void setPostanskiBroj(String postanskiBroj) {
        this.postanskiBroj = postanskiBroj;
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
    @Column(name = "NADREDJENI")
    public String getNadredjeni() {
        return nadredjeni;
    }

    public void setNadredjeni(String nadredjeni) {
        this.nadredjeni = nadredjeni;
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

        TMjestaEntity that = (TMjestaEntity) o;

        if (vazi != that.vazi) return false;
        if (postanskiBroj != null ? !postanskiBroj.equals(that.postanskiBroj) : that.postanskiBroj != null)
            return false;
        if (naziv != null ? !naziv.equals(that.naziv) : that.naziv != null) return false;
        if (nadredjeni != null ? !nadredjeni.equals(that.nadredjeni) : that.nadredjeni != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = postanskiBroj != null ? postanskiBroj.hashCode() : 0;
        result = 31 * result + (naziv != null ? naziv.hashCode() : 0);
        result = 31 * result + (nadredjeni != null ? nadredjeni.hashCode() : 0);
        result = 31 * result + (vazi ? 1 : 0);
        return result;
    }
}
