package ba.red_cross.blood_donation.service;

import ba.red_cross.blood_donation.model.TKorisniciEntity;
import ba.red_cross.blood_donation.repository.KorisniciRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class KorisniciService {

    @Autowired
    private KorisniciRepository korisniciRepository;

    private BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public TKorisniciEntity dodajKontakt(TKorisniciEntity noviKorisnik) throws Exception {
        TKorisniciEntity postojeciKorisnik = korisniciRepository.findByKorisnickoImeAndVazi(noviKorisnik.getKorisnickoIme(),true);
        if(postojeciKorisnik != null) {
            throw new Exception("Postoji korisnik sa istim korisnickim imenom");
        }
        noviKorisnik.setSifra(passwordEncoder.encode(noviKorisnik.getSifra()));
        return korisniciRepository.save(noviKorisnik);
    }

    public List<TKorisniciEntity> sviKorisnici() throws Exception {
        if (korisniciRepository.count() == 0) {
            throw new Exception("Nema korisnika u bazi");
        }
        List<TKorisniciEntity> users = new ArrayList<>();
        korisniciRepository.findAll().forEach(users::add);
        return users;
    }
}
