package my.netology.hw_three.repository;

import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class MyRepository {
    private String myScript = read("templates/getProductName.sql");
    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public MyRepository(DataSource dataSource) {
        this.namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
    }

    private String read(String scriptFileName) {
        try (InputStream is = new ClassPathResource(scriptFileName).getInputStream();
             BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(is))) {
            return bufferedReader.lines().collect(Collectors.joining("\n"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public List<String> getProductName(String name) {
        HashMap<String, String> params = new HashMap<>();
        params.put("firstName", name);
        return namedParameterJdbcTemplate.queryForList(myScript, params, String.class);
    }
}
