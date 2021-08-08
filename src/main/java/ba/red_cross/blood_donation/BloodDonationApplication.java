package ba.red_cross.blood_donation;

import ba.red_cross.blood_donation.model.*;
import ba.red_cross.blood_donation.repository.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


import java.time.LocalDate;
import java.time.LocalTime;

@SpringBootApplication
public class BloodDonationApplication {

    private static final Logger log =
            LoggerFactory.getLogger(BloodDonationApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(BloodDonationApplication.class, args);
    }


    @Bean
    public CommandLineRunner addDataToDatabase(KorisnikRepository korisnikRepository, TransfuzijskiCentarRepository transCentarRepo, RolaRepository rolaRepo, AkcijeDarivanjaKrviRepository akcijaDarivanjaRepo, NotifikacijaRepository notifikacijaRepo) {
        return (args) -> {

            // Kreiranje rola
            Rola admin = rolaRepo.save(new Rola("administrator"));
            Rola korisnik = rolaRepo.save(new Rola("korisnik"));

            // Kreiranje korisnika
            LocalDate datumKreiranjaRacuna = LocalDate.of(1996, 10, 23);
            LocalDate datumRodenja = LocalDate.of(1996, 10, 23);
            Korisnik user = korisnikRepository.save(new Korisnik("Alma", "Ibrašimović", "alma_96", "Z", datumRodenja, "Zenica","Novi Travnik", "Stjepana Radića 18/15", "SBK", "061718733", "SW dev", "0+", 5, "almaibrasimovic96@gmail.com", "proba123", false, datumKreiranjaRacuna, admin));

            // Kreiranje korisnika
             datumKreiranjaRacuna = LocalDate.of(2021, 5, 10);
            //LocalDate datumRodenja = LocalDate.of(1996, 10, 23);
            Korisnik user1 = korisnikRepository.save(new Korisnik("jasmina", "Ibrašimović", "alma_961", "Z", datumRodenja, "Zenica","Novi Travnik", "Stjepana Radića 18/15", "SBK", "061718733", "SW dev", "0+", 5, "almaibrasimovic96@gmail.com", "proba123", false, datumKreiranjaRacuna, admin));

            // Kreiranje transfuzijskih centara
            transCentarRepo.save (new TransfuzijskiCentar("Novi Travnik", "Stjepana Radića 18/15", "061718733"));


            // Kreiranje akcija darivanja krvi
            AkcijaDarivanjaKrvi akcijaDarivanja = new AkcijaDarivanjaKrvi("Paromlinska 3", "Sarajevo", LocalDate.now(), LocalTime.now(), LocalTime.now(), "Akcija darivanja krvi");
            akcijaDarivanjaRepo.save(akcijaDarivanja);
            akcijaDarivanja = new AkcijaDarivanjaKrvi("Hujići 4", "Zenica", LocalDate.now(), LocalTime.now(), LocalTime.now(), "Akcija darivanja krvi u Zenici");
            akcijaDarivanjaRepo.save(akcijaDarivanja);

            // Kreiranje notifikacija
            notifikacijaRepo.save (new Notifikacija("Hitno potrebna krvna grupa 0+", "Hitno potrebna krvna grupa 0+", "HITNO", "0+"));

            log.info("Podaci uspjesno upisani u db!");
        };

    }
}
