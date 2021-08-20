package ba.red_cross.blood_donation.security;

import ba.red_cross.blood_donation.model.Korisnik;
import ba.red_cross.blood_donation.repository.KorisnikRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class UserDetailsService implements org.springframework.security.core.userdetails.UserDetailsService {

    private final KorisnikRepository korisniciRepository;

    @Autowired
    public UserDetailsService(KorisnikRepository repository) {
        this.korisniciRepository = repository;
    }

    @Override
    public CustomUserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Korisnik userAccount = korisniciRepository.findByEmailAdresa(email);

        List<SimpleGrantedAuthority> authorities = Arrays.asList(new SimpleGrantedAuthority(userAccount.getRola().getNazivRole()));
        return new CustomUserDetails(userAccount.getEmailAdresa(), userAccount.getLozinka(), authorities, userAccount.getID());
    }
}
