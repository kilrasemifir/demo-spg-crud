package fr.kira.formation.spring.democrud.entreprises;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.Optional;

@Repository
public class EntrepriseRepository {

    private final JdbcTemplate template;
    private final EntrepriseRowMapper mapper;

    public EntrepriseRepository(JdbcTemplate template, EntrepriseRowMapper mapper) {
        this.template = template;
        this.mapper = mapper;
    }

    @PostConstruct
    public void init(){
        this.template.execute("""
            CREATE TABLE IF NOT EXISTS entreprise (
                id      BIGINT      AUTO_INCREMENT PRIMARY KEY ,
                nom     VARCHAR(32) ,
                capital BIGINT );
            """
        );
    }

    public void save(Entreprise entreprise){
        this.template.update(
                "INSERT INTO entreprise (nom, capital) VALUES (?,?);",
                entreprise.getNom(),
                entreprise.getCapital()
        );
    }

    public Optional<Entreprise> findById(long id){
        try{
            Entreprise result = this.template.queryForObject(
                    "SELECT id, nom, capital FROM entreprise WHERE id=?",
                    mapper,
                    id
            );
            return Optional.of(result);
        } catch(EmptyResultDataAccessException err){
            return Optional.empty();
        }
    }

    public List<Entreprise> findAll(){
        return this.template.query("""
                SELECT id, nom, capital
                FROM entreprise
                """, mapper);
    }
}
