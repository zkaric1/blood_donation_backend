package ba.red_cross.blood_donation.model;

import javax.persistence.*;

@Entity
@Table(name = "T_TRANSFUZIOLOGIJA", schema = "dbo", catalog = "ck_db")
public class TTransfuziologijaEntity {
    private String transfuziologija;
    private String naziv;
    private String adresa;
    private String telefon;
    private String fax;
    private String email;
    private Boolean vazi;

    @Id
    @Column(name = "TRANSFUZIOLOGIJA")
    public String getTransfuziologija() {
        return transfuziologija;
    }

    public void setTransfuziologija(String transfuziologija) {
        this.transfuziologija = transfuziologija;
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
    @Column(name = "ADRESA")
    public String getAdresa() {
        return adresa;
    }

    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }

    @Basic
    @Column(name = "TELEFON")
    public String getTelefon() {
        return telefon;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }

    @Basic
    @Column(name = "FAX")
    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    @Basic
    @Column(name = "EMAIL")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Basic
    @Column(name = "VAZI")
    public Boolean getVazi() {
        return vazi;
    }

    public void setVazi(Boolean vazi) {
        this.vazi = vazi;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TTransfuziologijaEntity that = (TTransfuziologijaEntity) o;

        if (transfuziologija != null ? !transfuziologija.equals(that.transfuziologija) : that.transfuziologija != null)
            return false;
        if (naziv != null ? !naziv.equals(that.naziv) : that.naziv != null) return false;
        if (adresa != null ? !adresa.equals(that.adresa) : that.adresa != null) return false;
        if (telefon != null ? !telefon.equals(that.telefon) : that.telefon != null) return false;
        if (fax != null ? !fax.equals(that.fax) : that.fax != null) return false;
        if (email != null ? !email.equals(that.email) : that.email != null) return false;
        if (vazi != null ? !vazi.equals(that.vazi) : that.vazi != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = transfuziologija != null ? transfuziologija.hashCode() : 0;
        result = 31 * result + (naziv != null ? naziv.hashCode() : 0);
        result = 31 * result + (adresa != null ? adresa.hashCode() : 0);
        result = 31 * result + (telefon != null ? telefon.hashCode() : 0);
        result = 31 * result + (fax != null ? fax.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (vazi != null ? vazi.hashCode() : 0);
        return result;
    }
}
