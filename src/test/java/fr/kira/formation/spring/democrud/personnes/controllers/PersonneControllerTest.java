package fr.kira.formation.spring.democrud.personnes.controllers;

import fr.kira.formation.spring.democrud.DemoCrudApplication;
import fr.kira.formation.spring.democrud.personnes.model.Personne;
import fr.kira.formation.spring.democrud.personnes.repositories.PersonneRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.time.LocalDate;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

// Permet de charger un application.yml pour cette suite de tests
@TestPropertySource(
        locations = "classpath:application-tests.yml"
)
// Chage le context spring pour les tests
@SpringBootTest
// Permet l'utilisation de MockMvc
@AutoConfigureMockMvc
class PersonneControllerTest {

    @Autowired
    private MockMvc mvc;
// Vous pouvez faire des configurations pour vos tests
//    @TestConfiguration
//    public static class TestConfig{
//
//        @Bean
//        public String message(){
//            return "Test";
//        }
//    }
//
//    @Autowired
//    private String message;

//    @Test
//    public void test(){
//        assertNotNull(message);
//    }

    @Autowired
    PersonneRepository repository;

    @Test
    @DisplayName("Recuperation d'une personne qui existe en fonction de son id")
    public void findById_exists() throws Exception {
        Personne personne = repository.save(new Personne("Doe","John", LocalDate.now()));
        mvc.perform(get("/personnes/"+personne.getId()))
                .andExpectAll(
                        status().is(200),
                        jsonPath("id").value(personne.getId())
                );
    }

    @Test
    @DisplayName("Lors de la suppression d'un personne qui est sauvegarde, elle n'est plus disponible")
    public void deleteById() throws Exception {
        Personne personne = repository.save(new Personne("Doe","John", LocalDate.now()));
        mvc.perform(delete("/personnes/"+personne.getId()))
                .andExpect(status().is(204));
        assertFalse(repository.existsById(personne.getId()));
        // Ou
        //assertTrue(repository.findById(personne.getId()).isEmpty());
    }

}