package ba.red_cross.blood_donation.service;

import ba.red_cross.blood_donation.DTO.ResponseMessageDTO;
import ba.red_cross.blood_donation.model.Korisnik;
import ba.red_cross.blood_donation.repository.KorisnikRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service
public class KorisnikService {

    @Autowired
    private KorisnikRepository korisnikiRepository;

    private BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public Korisnik dodajKontakt(Korisnik noviKorisnik) throws Exception {
        Korisnik postojeciKorisnik = korisnikiRepository.findByKorisnickoIme(noviKorisnik.getKorisnickoIme());
        if(postojeciKorisnik != null) {
            throw new Exception("Postoji korisnik sa istim korisnickim imenom");
        }
        noviKorisnik.setLozinka(passwordEncoder.encode(noviKorisnik.getLozinka()));
        return korisnikiRepository.save(noviKorisnik);
    }

    public List<Korisnik> sviKorisnici() throws Exception {
        if (korisnikiRepository.count() == 0) {
            throw new Exception("Nema korisnika u bazi");
        }
        List<Korisnik> users = new ArrayList<>();
        korisnikiRepository.findAll().forEach(users::add);
        return users;
    }

    public Korisnik getKorisnikById (Long id) throws Exception {
        return korisnikiRepository.findById(id).orElseThrow(() -> new Exception("Korisnik sa ID " + id + " ne postoji!"));
    }


    public Korisnik editKorisnika (Korisnik noviKorisnik) throws Exception{
        korisnikiRepository.findById(noviKorisnik.getID()).orElseThrow(() -> new Exception("Korisnik sa ID " + noviKorisnik.getID() + " ne postoji!"));
        korisnikiRepository.findById(noviKorisnik.getID()).map(
                korisnik -> {
                    korisnik.setIme(noviKorisnik.getIme());
                    korisnik.setKorisnickoIme(noviKorisnik.getKorisnickoIme());
                    korisnik.setPrezime(noviKorisnik.getPrezime());
                    korisnik.setSpol(noviKorisnik.getSpol());
                    korisnik.setDatumRodenja(noviKorisnik.getDatumRodenja());
                    korisnik.setDatumKreiranjaRacuna(noviKorisnik.getDatumKreiranjaRacuna());
                    korisnik.setMjestoRodena(noviKorisnik.getMjestoRodena());
                    korisnik.setMjestoPrebivalista(noviKorisnik.getMjestoPrebivalista());
                    korisnik.setAdresaPrebivalista(noviKorisnik.getAdresaPrebivalista());
                    korisnik.setKantonPrebivalista(noviKorisnik.getKantonPrebivalista());
                    korisnik.setKontaktTelefon(noviKorisnik.getKontaktTelefon());
                    korisnik.setZanimanje(noviKorisnik.getZanimanje());
                    korisnik.setKrvnaGrupa(noviKorisnik.getKrvnaGrupa());
                    korisnik.setBrojDarivanjaKrvi(noviKorisnik.getBrojDarivanjaKrvi());
                    korisnik.setEmailAdresa(noviKorisnik.getEmailAdresa());
                    korisnik.setLozinka(noviKorisnik.getLozinka());
                    korisnik.setSlatiNotifikacije(noviKorisnik.getSlatiNotifikacije());
                    korisnik.setRola(noviKorisnik.getRola());
                    return korisnikiRepository.save(korisnik);
                }
        );

        return korisnikiRepository.findById(noviKorisnik.getID()).get();
    }

    public HashMap<String,String> deleteAll () throws Exception {
        if (korisnikiRepository.count() == 0) return new ResponseMessageDTO("Nema kreiranih korisnika!").getHashMap();
        korisnikiRepository.deleteAll();
        if (korisnikiRepository.count() == 0) return new ResponseMessageDTO("Uspjesno obrisani svi korisnici!").getHashMap();
        return new ResponseMessageDTO("Greska pri brisanju korisnika!").getHashMap();
    }

    public HashMap<String,String> deleteById (Long id) throws Exception {
        if (korisnikiRepository.count() == 0) return new ResponseMessageDTO("Nema kreiranih korisnika").getHashMap();
        boolean exists = korisnikiRepository.existsById(id);
        if (exists) {
            korisnikiRepository.deleteById(id);
            return new ResponseMessageDTO("Uspjesno obrisan korisnik sa id " + id).getHashMap();
        }
        return new ResponseMessageDTO("Ne postoji korisnik sa id " + id).getHashMap();
    }
}
