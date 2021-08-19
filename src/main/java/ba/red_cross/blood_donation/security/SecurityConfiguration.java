package ba.red_cross.blood_donation.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.Arrays;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    private final UserDetailsService myUserDetailService;
    private final JwtRequestFilter jwtRequestFilter;

    @Autowired
    public SecurityConfiguration(UserDetailsService myUserDetailService,
                                 JwtRequestFilter jwtRequestFilter) {
        this.myUserDetailService = myUserDetailService;
        this.jwtRequestFilter = jwtRequestFilter;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(myUserDetailService);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.cors()
                .and()
                .csrf().disable()
                .authorizeRequests()

                // Korisnici
                .antMatchers(HttpMethod.POST, "/login", "/validate-token", "/korisnik", "/register").permitAll()
                .antMatchers(HttpMethod.PUT, "/korisnici").hasAuthority("administrator")
                .antMatchers(HttpMethod.DELETE, "/korisnici/obrisi_sve","/korisnici/{id}").hasAuthority("administrator")
                .antMatchers(HttpMethod.GET, "/korisnici","/korisnici/{id}").hasAnyAuthority()
                .antMatchers(HttpMethod.PATCH, "/korisnici/{id}").hasAnyAuthority()

                // Akcije darivanja krvi
                .antMatchers(HttpMethod.GET, "/akcija_darivanja_krvi/lista","/akcija_darivanja_krvi/{id}").permitAll()
                .antMatchers(HttpMethod.POST, "/akcija_darivanja_krvi").hasAuthority("administrator")
                .antMatchers(HttpMethod.PUT, "/akcija_darivanja_krvi").hasAuthority("administrator")
                .antMatchers(HttpMethod.DELETE, "/akcija_darivanja_krvi/obrisi_sve","/akcija_darivanja_krvi/{id}").hasAuthority("administrator")

                // Notifikacije
                .antMatchers(HttpMethod.GET, "/notifikacije/lista","/notifikacije/{id}").hasAnyAuthority()
                .antMatchers(HttpMethod.POST, "/notifikacije").hasAuthority("administrator")
                .antMatchers(HttpMethod.PUT, "/notifikacije").hasAuthority("administrator")
                .antMatchers(HttpMethod.DELETE, "/notifikacije","/notifikacije/{id}").hasAuthority("administrator")

                //Swagger
                .antMatchers(HttpMethod.GET, "/swagger-resources/**",
                        "/swagger-ui.html",
                        "/v2/api-docs",
                        "/webjars/**",
                        "/csrf",
                        "/")
                .permitAll();

        http.addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class);
    }

    @Bean
    CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration configuration = new CorsConfiguration();
        configuration.setAllowedOrigins(Arrays.asList("*"));
        configuration.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "DELETE", "PATCH"));
        configuration.setAllowedHeaders(Arrays.asList("*"));
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);
        return source;
    }

    @Override
    @Bean
    protected AuthenticationManager authenticationManager() throws Exception {
        return super.authenticationManager();
    }
}
