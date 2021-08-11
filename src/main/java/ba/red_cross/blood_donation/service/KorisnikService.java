package ba.red_cross.blood_donation.service;

import ba.red_cross.blood_donation.DTO.KorisnikPatchDTO;
import ba.red_cross.blood_donation.DTO.ResponseMessageDTO;
import ba.red_cross.blood_donation.model.Korisnik;
import ba.red_cross.blood_donation.model.Rola;
import ba.red_cross.blood_donation.repository.KorisnikRepository;
import ba.red_cross.blood_donation.repository.RolaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class KorisnikService {

    @Autowired
    private KorisnikRepository korisnikRepository;

    @Autowired RolaRepository rolaRepository;

    private BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public Korisnik dodajKontakt(Korisnik noviKorisnik) throws Exception {
        Korisnik postojeciKorisnik = korisnikRepository.findByKorisnickoIme(noviKorisnik.getKorisnickoIme());
        if(postojeciKorisnik != null) {
            throw new Exception("Postoji korisnik sa istim korisnickim imenom");
        }

        noviKorisnik.setLozinka(passwordEncoder.encode(noviKorisnik.getLozinka()));
        Rola korisnik = rolaRepository.findById(Long.valueOf(2)).orElseThrow(() -> new Exception("Rola sa ID " + 2 + " ne postoji!"));
        noviKorisnik.setRola(korisnik);
        System.out.print(noviKorisnik.getRola().getNazivRole());
        return korisnikRepository.save(noviKorisnik);
    }

    public List<Korisnik> sviKorisnici() throws Exception {
        if (korisnikRepository.count() == 0) {
            throw new Exception("Nema korisnika u bazi");
        }
        List<Korisnik> users = new ArrayList<>();
        korisnikRepository.findAll().forEach(users::add);
        return users;
    }

    public Korisnik getKorisnikById (Long id) throws Exception {
        return korisnikRepository.findById(id).orElseThrow(() -> new Exception("Korisnik sa ID " + id + " ne postoji!"));
    }

    public List<Korisnik> getKorisniciByKrvnaGrupa (String krvnaGrupa) throws Exception {

        if (korisnikRepository.count() == 0) throw new Exception("Nema korisnika u bazi");
        return korisnikRepository.findByKrvnaGrupa(krvnaGrupa);
    }

    public List<Korisnik> getNewestKorisnici () throws Exception {
        if (korisnikRepository.count() == 0) throw new Exception("Nema korisnika u bazi");
        List<Korisnik> korisnici = sviKorisnici();
        Collections.sort(korisnici);
        List<Korisnik> tempKorisnici = new ArrayList<>();
        if (korisnici.size() > 5) {
            for (int i = 0; i<5; i++) {
                tempKorisnici.add(korisnici.get(i));
            }
            return tempKorisnici;
        }

        return korisnici;
    }

    public Korisnik editKorisnika (Korisnik noviKorisnik) throws Exception{
        korisnikRepository.findById(noviKorisnik.getID()).orElseThrow(() -> new Exception("Korisnik sa ID " + noviKorisnik.getID() + " ne postoji!"));
        korisnikRepository.findById(noviKorisnik.getID()).map(
                korisnik -> {
                    korisnik.setIme(noviKorisnik.getIme());
                    korisnik.setKorisnickoIme(noviKorisnik.getKorisnickoIme());
                    korisnik.setPrezime(noviKorisnik.getPrezime());
                    korisnik.setSpol(noviKorisnik.getSpol());
                    korisnik.setDatumRodenja(noviKorisnik.getDatumRodenja());
                    korisnik.setDatumKreiranjaRacuna(noviKorisnik.getDatumKreiranjaRacuna());
                    korisnik.setMjestoRodenja(noviKorisnik.getMjestoRodenja());
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
                    return korisnikRepository.save(korisnik);
                }
        );

        return korisnikRepository.findById(noviKorisnik.getID()).get();
    }

    public HashMap<String,String> deleteAll () throws Exception {
        if (korisnikRepository.count() == 0) return new ResponseMessageDTO("Nema kreiranih korisnika!").getHashMap();
        korisnikRepository.deleteAll();
        if (korisnikRepository.count() == 0) return new ResponseMessageDTO("Uspjesno obrisani svi korisnici!").getHashMap();
        return new ResponseMessageDTO("Greska pri brisanju korisnika!").getHashMap();
    }

    public HashMap<String,String> deleteById (Long id) throws Exception {
        if (korisnikRepository.count() == 0) return new ResponseMessageDTO("Nema kreiranih korisnika").getHashMap();
        boolean exists = korisnikRepository.existsById(id);
        if (exists) {
            korisnikRepository.deleteById(id);
            return new ResponseMessageDTO("Uspjesno obrisan korisnik sa id " + id).getHashMap();
        }
        return new ResponseMessageDTO("Ne postoji korisnik sa id " + id).getHashMap();
    }

    public Korisnik partialUpdateUser (KorisnikPatchDTO noviKorisnik, Long id) throws Exception{
        Korisnik korisnik = korisnikRepository.findById(id).orElseThrow(() -> new Exception("Korisnik sa ID " + id + " ne postoji!"));
        korisnik.setMjestoPrebivalista(noviKorisnik.getMjestoPrebivalista());
        korisnik.setAdresaPrebivalista(noviKorisnik.getAdresaPrebivalista());
        korisnik.setKantonPrebivalista(noviKorisnik.getKantonPrebivalista());
        korisnik.setKontaktTelefon(noviKorisnik.getKontaktTelefon());
        korisnik.setZanimanje(noviKorisnik.getZanimanje());
        korisnik.setEmailAdresa(noviKorisnik.getEmailAdresa());
        korisnik.setKorisnickoIme(noviKorisnik.getKorisnickoIme());
        korisnikRepository.save(korisnik);
        return korisnik;
    }
}
