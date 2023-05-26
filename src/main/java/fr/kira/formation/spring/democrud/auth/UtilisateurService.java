package fr.kira.formation.spring.democrud.auth;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.annotation.PostConstruct;

public class UtilisateurService implements UserDetailsService {

    private final UtilisateurRepository repository;
    private final PasswordEncoder passwordEncoder;

    public UtilisateurService(UtilisateurRepository repository, PasswordEncoder passwordEncoder) {
        this.repository = repository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return this.repository.findByUsername(username).orElseThrow(
                ()->new UsernameNotFoundException("Aucune utilisateur ne possede l'username "+username)
        );
    }

    public Utilisateur save(Utilisateur utilisateur){
        utilisateur.setPassword(passwordEncoder.encode(utilisateur.getPassword()));
        return this.repository.save(utilisateur);
    }

    @PostConstruct
    public void init(){
        this.save(new Utilisateur("admin", "admin"));
    }

}
