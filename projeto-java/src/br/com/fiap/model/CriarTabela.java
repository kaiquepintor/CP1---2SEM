package br.com.fiap.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.SQLException;

public class CriarTabela {

    public static void main(String[] args) {
        String url = "jdbc:oracle:thin:@oracle.fiap.com.br:1521:ORCL";
        String user = "rm558124";
        String password = "030505";

        Connection connection = null;
        Statement statement = null;

        try {
            connection = DriverManager.getConnection(url, user, password);

            statement = connection.createStatement();

            String sqlSequence = "CREATE SEQUENCE CLIENTE_SEQ START WITH 1 INCREMENT BY 1";
            statement.executeUpdate(sqlSequence);

            String sqlTabela = "CREATE TABLE T_CP_CLIENTE ("
                    + "id NUMBER PRIMARY KEY, "
                    + "nome VARCHAR2(100), "
                    + "email VARCHAR2(100), "
                    + "telefone VARCHAR2(20)"
                    + ")";
            statement.executeUpdate(sqlTabela);

            System.out.println("Tabela e sequência criadas com sucesso!");

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (statement != null) statement.close();
                if (connection != null) connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}

