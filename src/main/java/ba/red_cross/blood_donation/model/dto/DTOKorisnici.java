package ba.red_cross.blood_donation.model.dto;

import ba.red_cross.blood_donation.model.TKontaktiEntity;
import ba.red_cross.blood_donation.model.TKorisniciEntity;

public class DTOKorisnici {

    private TKontaktiEntity kontakt;
    private TKorisniciEntity korisnik;

    public DTOKorisnici(TKontaktiEntity kontakt, TKorisniciEntity korisnik) {
        this.kontakt = kontakt;
        this.korisnik = korisnik;
    }

    public TKontaktiEntity getKontakt() {
        return kontakt;
    }

    public void setKontakt(TKontaktiEntity kontakt) {
        this.kontakt = kontakt;
    }

    public TKorisniciEntity getKorisnik() {
        return korisnik;
    }

    public void setKorisnik(TKorisniciEntity korisnik) {
        this.korisnik = korisnik;
    }
}
