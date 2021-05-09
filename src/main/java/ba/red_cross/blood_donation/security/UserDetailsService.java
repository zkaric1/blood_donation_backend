package ba.red_cross.blood_donation.security;

import ba.red_cross.blood_donation.model.TKorisniciEntity;
import ba.red_cross.blood_donation.repository.KorisniciRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class UserDetailsService implements org.springframework.security.core.userdetails.UserDetailsService {

    private final KorisniciRepository korisniciRepository;

    @Autowired
    public UserDetailsService(KorisniciRepository repository) {
        this.korisniciRepository = repository;
    }

    @Override
    public CustomUserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        TKorisniciEntity userAccount = korisniciRepository.findByKorisnickoImeAndVazi(username,true);

        List<SimpleGrantedAuthority> authorities = Arrays.asList(new SimpleGrantedAuthority(userAccount.getTipKorisnika()));
        return new CustomUserDetails(userAccount.getKorisnickoIme(), userAccount.getSifra(), authorities, userAccount.getKorisnikId());
    }
}
