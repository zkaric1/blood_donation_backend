package ba.red_cross.blood_donation.model;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "T_DARIVANJA_KRVI", schema = "dbo", catalog = "ck_db")
public class TDarivanjaKrviEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int darivanjeKrviId;
    private int davaocId;
    private int lijecnikId;
    private String transfuziologija;
    private short kolicina;
    private Timestamp datum;

    @Id
    @Column(name = "DARIVANJE_KRVI_ID")
    public int getDarivanjeKrviId() {
        return darivanjeKrviId;
    }

    public void setDarivanjeKrviId(int darivanjeKrviId) {
        this.darivanjeKrviId = darivanjeKrviId;
    }

    @Basic
    @Column(name = "DAVAOC_ID")
    public int getDavaocId() {
        return davaocId;
    }

    public void setDavaocId(int davaocId) {
        this.davaocId = davaocId;
    }

    @Basic
    @Column(name = "LIJECNIK_ID")
    public int getLijecnikId() {
        return lijecnikId;
    }

    public void setLijecnikId(int lijecnikId) {
        this.lijecnikId = lijecnikId;
    }

    @Basic
    @Column(name = "TRANSFUZIOLOGIJA")
    public String getTransfuziologija() {
        return transfuziologija;
    }

    public void setTransfuziologija(String transfuziologija) {
        this.transfuziologija = transfuziologija;
    }

    @Basic
    @Column(name = "KOLICINA")
    public short getKolicina() {
        return kolicina;
    }

    public void setKolicina(short kolicina) {
        this.kolicina = kolicina;
    }

    @Basic
    @Column(name = "DATUM")
    public Timestamp getDatum() {
        return datum;
    }

    public void setDatum(Timestamp datum) {
        this.datum = datum;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TDarivanjaKrviEntity that = (TDarivanjaKrviEntity) o;

        if (darivanjeKrviId != that.darivanjeKrviId) return false;
        if (davaocId != that.davaocId) return false;
        if (lijecnikId != that.lijecnikId) return false;
        if (kolicina != that.kolicina) return false;
        if (transfuziologija != null ? !transfuziologija.equals(that.transfuziologija) : that.transfuziologija != null)
            return false;
        if (datum != null ? !datum.equals(that.datum) : that.datum != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = darivanjeKrviId;
        result = 31 * result + davaocId;
        result = 31 * result + lijecnikId;
        result = 31 * result + (transfuziologija != null ? transfuziologija.hashCode() : 0);
        result = 31 * result + (int) kolicina;
        result = 31 * result + (datum != null ? datum.hashCode() : 0);
        return result;
    }
}
