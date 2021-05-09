package ba.red_cross.blood_donation.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "T_KRVNE_GRUPE", schema = "dbo", catalog = "ck_db")
public class TKrvneGrupeEntity {
    private String krvnaGrupa;

    @Id
    @Column(name = "KRVNA_GRUPA")
    public String getKrvnaGrupa() {
        return krvnaGrupa;
    }

    public void setKrvnaGrupa(String krvnaGrupa) {
        this.krvnaGrupa = krvnaGrupa;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TKrvneGrupeEntity that = (TKrvneGrupeEntity) o;

        if (krvnaGrupa != null ? !krvnaGrupa.equals(that.krvnaGrupa) : that.krvnaGrupa != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return krvnaGrupa != null ? krvnaGrupa.hashCode() : 0;
    }
}
