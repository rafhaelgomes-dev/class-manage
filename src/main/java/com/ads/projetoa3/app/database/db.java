package com.ads.projetoa3.app.database;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class db {
    private static final String PROPERTIES_PATH = "config.properties";

    public static Connection getConnection() throws SQLException {
        try (FileInputStream input = new FileInputStream(PROPERTIES_PATH)) {
            Properties props = new Properties();
            props.load(input);

            String url = props.getProperty("db.url");
            String user = props.getProperty("db.user");
            String password = props.getProperty("db.password");

            if (url == null || user == null || password == null) {
                throw new SQLException("Configurações do banco de dados faltando no arquivo " + PROPERTIES_PATH);
            }

            return DriverManager.getConnection(url, user, password);
        } catch (Exception e) {
            throw new SQLException("Erro ao carregar configurações do banco de dados", e);
        }
    }
}