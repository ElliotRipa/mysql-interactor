import java.util.ArrayList;

public class Column {

    String name;
    String type;
    boolean nullable;
    String key;
    String extra;

    public Column(ArrayList<String> rs) throws IllegalAccessException {

        if(rs.size() != 6) {
            throw new IllegalAccessException("Invalid input");
        }

        this.name = rs.get(0);
        this.type = rs.get(1);
        this.nullable = rs.get(2).equals("YES");


    }

}
