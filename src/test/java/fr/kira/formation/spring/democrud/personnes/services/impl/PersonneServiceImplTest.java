package fr.kira.formation.spring.democrud.personnes.services.impl;

import fr.kira.formation.spring.democrud.exceptions.NotFoundException;
import fr.kira.formation.spring.democrud.personnes.dto.mapper.PersonneMapper;
import fr.kira.formation.spring.democrud.personnes.model.Personne;
import fr.kira.formation.spring.democrud.personnes.repositories.PersonneRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

// @RunWith(MockitoExtension.class) pour JUnit4
@ExtendWith(MockitoExtension.class) // JUnit5
class PersonneServiceImplTest {

//    @Mock
    PersonneRepository repository;
    @Mock
    PersonneMapper mapper;
    PersonneServiceImpl service;

    @BeforeEach
    void setUp() {
        this.repository= Mockito.mock(PersonneRepository.class);
        this.service = new PersonneServiceImpl(repository, mapper);
    }

    @Test
    @DisplayName("La sauvegarde d'une nouvelle personne definie un id")
    void save_retourne_personne_avec_id() {
        // Given
        Personne personne = new Personne("Doe","John", LocalDate.now());
        Mockito.when(repository.save(personne)).thenAnswer(invocationOnMock -> {
            Personne p = invocationOnMock.getArgument(0);
            p.setId(1L);
            return p;
        });
        // When
        Personne result = this.service.save(personne);

        // Then
        assertEquals(1L, result.getId());
    }

    @Test
    @DisplayName("Lors de la demande par id, leve NotFound si la personne n'existe pas")
    public void personne_not_found(){
        // Given
        Mockito.when(repository.findById(1L)).thenReturn(Optional.empty());
        // When & Then
        assertThrows(NotFoundException.class, ()->this.service.findById(1L));
    }

    @Test
    @DisplayName("Leve une exception si une personne avec le meme nom et prenom existe lors de la sauvegarde")
    public void unique_nom_prenom(){
        Personne personne2 = new Personne("Doe","John", LocalDate.now());

        Mockito.when(repository.existsByNomAndPrenom("Doe","John")).thenReturn(true);

        // When & Then
        assertThrows(RuntimeException.class, ()->this.service.save(personne2));
    }

}