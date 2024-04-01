package net.leaguechatchamp.leaguechatchamps2024.adapters.out;

import java.util.List;
import java.util.Optional;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import net.leaguechatchamp.leaguechatchamps2024.domain.model.Champions;
import net.leaguechatchamp.leaguechatchamps2024.domain.ports.ChampionsRepository;

@Repository
public class ChampionsJdbcRepository implements ChampionsRepository {

    private final JdbcTemplate jdbcTemplate;
    private final RowMapper<Champions> rowMapper;

    public ChampionsJdbcRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
        this.rowMapper = (rs, rowNum) -> new Champions(
                rs.getLong("id"),
                rs.getString("name"),
                rs.getString("role"),
                rs.getString("lore"),
                rs.getString("image_url")
        );
    }

    @Override
    public List<Champions> findAll() {
        return jdbcTemplate.query("SELECT * FROM champions", rowMapper);
    }

    @Override
    public Optional<Champions> findById(Long id) {
        String sql = "SELECT * FROM CHAMPIONS WHERE ID =?";
        @SuppressWarnings("deprecation")
        Champions champion = jdbcTemplate.queryForObject(sql, new Object[]{id}, rowMapper);
        return Optional.ofNullable(champion);
    }
}