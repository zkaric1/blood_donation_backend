package ba.red_cross.blood_donation.model;



import javax.persistence.*;

@Entity
@Table(name = "T_KONTAKT_VJESTINE", schema = "dbo", catalog = "ck_db")
@IdClass(TKontaktVjestineEntityPK.class)
public class TKontaktVjestineEntity {
    private int kontaktId;
    private String vjestina;

    @Id
    @Column(name = "KONTAKT_ID")
    public int getKontaktId() {
        return kontaktId;
    }

    public void setKontaktId(int kontaktId) {
        this.kontaktId = kontaktId;
    }

    @Id
    @Column(name = "VJESTINA")
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

        TKontaktVjestineEntity that = (TKontaktVjestineEntity) o;

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
