package ConnectToMySQLDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class DatabaseConnectDirectly {

    public static void main(String[] args) throws SQLException {

        // Direct Approach to Connect with Database/DB


        // protocol//[hosts:][port][/database][?properties]
        String url = "jdbc:mysql://127.0.0.1:3306/test_schema_1?serverTimezone=UTC";

        //Username for MYSQLDB
        String user = "root";

        //Password for MYSQLDB
        String password = "Pizzabuns123";

        Connection connection = null; //Creates a Statement object for sending SQL statements to the database.
        Statement statement = null; //Executes the given SQL statement, which returns a single ResultSet object,throws exception if fail

        //Made an Object of Movie Class -> reference name is movieName -> Constructor we set value
        Movie titanic = new Movie(5, "Titanic", 1997, "Romance", "PG-14");

        //Made an Object of Movie Class -> reference name is movieName -> Constructor we set value
        Movie catchMeIfYouCan = new Movie(7, "catchMeIfYouCan", 2018, "Action", "PG-10");

        //Made an Object of Movie Class -> reference name is movieName -> Constructor we set value
        Movie fastAndFurious = new Movie(8, "fastAndFurious", 2015, "Action", "PG-12");

        //Made an Object of Movie Class -> reference name is movieName -> Constructor we set value
        Movie kabhiKhusiKabiGum = new Movie(6, "kabhiKhusiKabiGum", 2003, "Family", "PG-5");

        //Made an Object of Movie Class -> reference name is movieName -> Constructor we set value
        Movie fugitive = new Movie(4, "fugitive", 2000, "Action", "PG-8");

        //Made an Object of Movie Class -> reference name is movieName -> Constructor we set value
        Movie example = new Movie(3, "Mickey Mouse", 1980, "Comedy", "PG");


        //Created an ArrayList -> referenceName of movie
        ArrayList<Movie> movie = new ArrayList<>(); //<- created an arrayList
        movie.add(titanic);             //<-added referenceName from above
        movie.add(catchMeIfYouCan);     //<-added referenceName from above
        movie.add(fastAndFurious);      //<-added referenceName from above
        movie.add(kabhiKhusiKabiGum);   //<-added referenceName from above
        movie.add(fugitive);            //<-added referenceName from above
        movie.add(example);             //<-added referenceName from above


        try {
            //Connect to MYSQLDB by using Url,UserName and Password
            connection = DriverManager.getConnection(url, user, password);

            //If the Connection then Create a Statement and Send that Statement to MYSQLDB
            statement = connection.createStatement();

            //Converting ArrayList to a String
            for (Movie mv : movie) {

                //Telling SQL to Insert Into The Following Columns
                String query = "insert into movie(id,title,releaseYear,genre,mpaRating)"

                        //Telling SQL to Insert The Following Values into The Columns Assigned Above
                        + "values(" + mv.getId() + ",'" + mv.getTitle() + "'," + mv.getReleaseYear() + " ,'" + mv.getGenre() + "','" + mv.getMpaRating() + "')";

                //Execute The Query
                statement.execute(query);
                System.out.println("\nConnection Successful");
            }

            //If Anything Goes Wrong Than Catch The Exception
        } catch (SQLException e) {

            //Prints this throwable and its backtrace to the standard error stream.
            e.printStackTrace();
            System.out.println("\nConnection Not Found");

            //Java finally block is a block that is used to execute important code such as closing connection,stream etc.
        } finally {  //Java finally block follows try or catch block.
            //Java finally block is always executed whether exception is handled or not.

            statement.close();  //-> Closes Statement
            //-> Executes the given SQL statement, which returns a single object.

            connection.close(); //-> Closes Connection
            //-> Creates a Statement object for sending SQL statements to the database.

        }
        //The finally block always executes when the try block exits.
        //This ensures that the finally block is executed even if an unexpected exception occurs.
        //But finally is useful for more than just exception handling
        //It allows the programmer to avoid having cleanup code accidentally bypassed by a return, continue, or break.
        //Putting cleanup code in a finally block is always a good practice, even when no exceptions are anticipated.
    }
}

