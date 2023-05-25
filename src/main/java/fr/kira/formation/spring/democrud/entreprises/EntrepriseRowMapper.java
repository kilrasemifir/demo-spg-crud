package fr.kira.formation.spring.democrud.entreprises;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class EntrepriseRowMapper implements RowMapper<Entreprise> {
    @Override
    public Entreprise mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new Entreprise(
                rs.getInt("id"),
                rs.getString("nom"),
                rs.getLong("capital")
        );
    }
}
