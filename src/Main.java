import java.sql.*;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {


        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://192.168.1.128:3306/media","desktop","&a90f#b33Sf0");
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM movies");

            int columnCount = rs.getMetaData().getColumnCount();
            ArrayList<ArrayList<String>> list = new ArrayList<>();
            int whileCounter = 0;

            while(rs.next()) {

                ArrayList<String> entry = new ArrayList<>();

                for(int i = 1 ; i <= columnCount ; i++) {
                    entry.add(rs.getString(i));
                }

                list.add(entry);

            }
            con.close();


        } catch (Exception e) {
            System.out.println(e);
        }


    }

}
