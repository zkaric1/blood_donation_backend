package ba.red_cross.blood_donation.service;

import ba.red_cross.blood_donation.repository.KorisnikNotifikacijaRepository;
import ba.red_cross.blood_donation.repository.KorisnikRepository;
import ba.red_cross.blood_donation.repository.NotifikacijaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class KorisnikNotifikacijaService {

    @Autowired
    KorisnikNotifikacijaRepository korisnikNotifikacijaRepository;

    @Autowired
    KorisnikRepository korisnikRepository;

    @Autowired
    NotifikacijaRepository notifikacijaRepository;

    public void obrisiNotifikacijeZaKorisnika(Long korisnikId) throws Exception {
        korisnikRepository.findById(korisnikId).orElseThrow(() -> new Exception("Korisnik sa ID " + korisnikId + " ne postoji!"));
        korisnikNotifikacijaRepository.deleteKorisnikNotifikacijaByKorisnik_ID(korisnikId);
    }

    public void obrisiNotifikacijuZaKorisnika(Long korisnikId, Long notifikacijaId) throws Exception {
        boolean korisnikPostoji = korisnikRepository.existsById(korisnikId);
        if (!korisnikPostoji) {
            throw new Exception("Korisnik ne postoji");
        }
        boolean notifikacijaPostoji = notifikacijaRepository.existsById(notifikacijaId);
        if (!notifikacijaPostoji) {
            throw new Exception("Notifikacija ne postoji");
        }
        korisnikNotifikacijaRepository.deleteKorisnikNotifikacijaByKorisnik_IDAndNotifikacija_ID(korisnikId,notifikacijaId);
    }
}
