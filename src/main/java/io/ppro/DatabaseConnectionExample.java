package io.ppro;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

/***
 * @author Pawan Maurya
 * @since Aug 15, 2021
 *
 * #PRACTICE
 */

public class DatabaseConnectionExample {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        final String PASSWORD = "triple888";
        final String USERNAME = "root";
        final String URL = "jdbc:mysql://localhost:3306/adhocdb";

        // STEP 1 : LOAD THE DRIVER CLASS
        // STEP 2 : CREATE CONNECTION
        // STEP 3 : CREATE STATEMENT
        // STEP 4 : EXECUTE QUERY

        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);

        // It helps to send("sql query") and receive(response) the request and response
        Statement statement = connection.createStatement();

        // execute         REST (Create database, create table, Drop table)
        // executeQuery    ===> SELECT QUERY WE PERFORM [SELECT , ]  DQL
        // executeUpdate   ===> Non select query  [ Update , delete, insert ]  // DML

        // statement.executeUpdate("insert into user values(1,'PAWAN',2000)");


        PreparedStatement preparedStatement = connection.prepareStatement("insert into " +
                "user(userId,username) " +
                "value(?,?)");
        System.out.println(preparedStatement);
        preparedStatement.setInt(1, 12201);
        preparedStatement.setString(2, "Pawan");
        System.out.println(preparedStatement);
        int i = preparedStatement.executeUpdate();
        System.out.println("Updated Count : " + i);

        connection.close();
    }

    /**
     * 1. If we know the Type of Query at the beginning and it is always
     *      Select Query then we should use "executeQuery() Method".
     * 2. If we know the Type of Query at the beginning and it is always
     *      Non-Select Query then we should use executeUpdate() Method.
     * 3. If we don't know the Type of SQL Query at the beginning and it
     *      is available dynamically at Runtime (May be from Properties File
     *      OR From Command Prompt Etc) then we should go for execute() Method.
     */


    /**
     * PreparedStatement (I)
     * Need of PreparedStatement:
     * In the case of normal Statement, whenever we are executing SQL Query,
     * every time compilation and execution will be happened at database side.
     *
     * PreparedStatement is the query will be compiled only once even though
     * we are executing multiple times, so that overall performance of the
     * application will be improved.
     */
}
