package com.bookwise.booklibrary.config;

import lombok.Generated;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.flywaydb.core.Flyway;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import javax.sql.DataSource;
import java.sql.Connection;

@Configuration
@Profile({"test"}) @Slf4j
public class DevConfig {

    @Bean
    @ConditionalOnProperty(name = "db", havingValue = "hsql", matchIfMissing = true)
    public DataSource hsqlDatasource() {
        return dataSource("jdbc:hsqldb:mem:library;sql.syntax_mys=true", "sa", "");
    }

    @Bean @SneakyThrows @Generated
    boolean flywayConfig(final DataSource dataSource) {
        try (Connection connection = dataSource.getConnection()) {
            var dbType = connection.getMetaData().getURL().contains("sqlserver") ? "mssql" : "hsql";
            var flyway = Flyway.configure().cleanDisabled(false).dataSource(dataSource).locations("classpath:db/migration/" + dbType, "classpath:testdata/").load();
            flyway.clean();
            flyway.migrate();
            return true;
        }
    }

    @SneakyThrows  @Generated
    private DataSource dataSource(String url, String username, String password) {
        var ds = DataSourceBuilder.create().url(url).username(username).password(password).build();
        try (var conn = ds.getConnection()) {
            log.info(" \n*** Initializing datasource *** \n url: {} \n username: {} \n schema: {} \n dbName: {} \n driver: {} \n driverVersion: {}",
                    url, username, conn.getSchema(), conn.getMetaData().getDatabaseProductName(), conn.getMetaData().getDriverName(), conn.getMetaData().getDriverVersion());
            return ds;
        }
    }

}
