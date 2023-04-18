package com.ex.springbootpsql.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.Statement;

/*
* PostgreSQL 연동 확인
@Slf4j
@Component
public class PostgreSQLConfig implements ApplicationRunner {

    private final DataSource dataSource;
    private final JdbcTemplate jdbcTemplate;

    PostgreSQLConfig(
            DataSource dataSource
            , JdbcTemplate jdbcTemplate
    ) {
        this.dataSource = dataSource;
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        try (Connection connection = dataSource.getConnection()) {
            log.info("datasource class >> {}", dataSource.getClass());
            log.info("url >> {}", connection.getMetaData().getURL());
            log.info("name >> {}", connection.getMetaData().getUserName());

            Statement statement = connection.createStatement();
            String sql = "CREATE TABLE TBL_TEST(TEST_SEQ INTEGER NOT NULL, TEST_ID VARCHAR(255), PRIMARY KEY(USER_SEQ))";
            statement.executeUpdate(sql);
        }

        jdbcTemplate.execute("INSERT INTO TBL_TEST VALUES (1, 'chacha')");

    }
}
*/
