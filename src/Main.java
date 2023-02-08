import java.sql.*;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        ArrayList<ArrayList<String>> details = readTableDetails("test_movies");
        ArrayList<ArrayList<String>> rows = readTableRows("test_movies");

        System.out.println("Debug point.");

    }

    public static ArrayList<ArrayList<String>> queryTable(String query) {

        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://192.168.1.128:3306/media","desktop","&a90f#b33Sf0");
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            int columnCount = rs.getMetaData().getColumnCount();
            ArrayList<ArrayList<String>> list = new ArrayList<>();

            while(rs.next()) {

                list.add(readRow(rs, columnCount));

            }
            con.close();

            return list;

        } catch (Exception e) {
            System.out.println(e);
        }

        return null;

    }

    public static ArrayList<ArrayList<String>> readTableRows(String table) {

        String query = "SELECT * FROM " + table;

        return queryTable(query);

    }


    public static ArrayList<ArrayList<String>> readTableDetails(String table) {

        String query = "DESCRIBE " + table;

        return queryTable(query);

    }

    public static ArrayList<String> readRow(ResultSet rs, int columnCount) throws SQLException {

        ArrayList<String> entry = new ArrayList<>();

        for(int i = 1 ; i <= columnCount ; i++) {
            entry.add(rs.getString(i));
        }

        return entry;

    }

}
