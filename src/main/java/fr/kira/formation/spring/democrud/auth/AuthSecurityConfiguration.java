package fr.kira.formation.spring.democrud.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import javax.annotation.PostConstruct;

@Configuration
@EnableWebMvc
public class AuthSecurityConfiguration {

    @Bean
    @Profile("dev")
    public SecurityFilterChain securityFilterChainDev(
            HttpSecurity http) throws Exception {
        return http
                .authorizeHttpRequests(requests->{
                    requests.mvcMatchers("/personnes/**").authenticated();
                    requests.anyRequest().permitAll();
                })
                .httpBasic()
                    .authenticationEntryPoint(new DemoBasicAuthenticationEntryPoint())

                .and().build();
    }

    @Bean
    @Profile("!dev")
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http
                .authorizeHttpRequests(requests->{
                    requests.anyRequest().permitAll();
                }).build();
        /* Autre syntaxe
        return http
                .authorizeHttpRequests()
                .anyRequest()
                    .permitAll()
                .and().build();
         */
    }

    @Bean
    public UtilisateurService utilisateurService(UtilisateurRepository repository, PasswordEncoder passwordEncoder){
        return new UtilisateurService(repository, passwordEncoder);
    }

    @Bean
    public DaoAuthenticationProvider daoAuthenticationProvider
            (UtilisateurService service, PasswordEncoder passwordEncoder){
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setPasswordEncoder(passwordEncoder);
        provider.setUserDetailsService(service);
        return provider;
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
}
