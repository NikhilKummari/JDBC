import java.sql.*;
public class DemoJdbc {
    public static void main(String[] args) throws Exception{
        /*
        load and register
        create connection
        create statement
        execute statement
        process the results
        close
         */
        int sid = 102;
        String sname = "Robin";
        int Marks = 52;

        String url = "jdbc:postgresql://localhost:5432/Student";
        String uname = "postgres";
        String pwd = "Nikhil@021";


//        String sql = "select * from \"Student_data\"";
//        Class.forName("org.postgresql.Driver");
//        Connection con = DriverManager.getConnection(url, uname, pwd);
//        System.out.println("Connected to database successfully");
//        Statement st = con.createStatement();
//        ResultSet rs = st.executeQuery(sql); //Use this when you need to fetch data from the database.
//        System.out.println(rs.next());// will gives true if data present or else false
//        String name = rs.getString("sname");
//        System.out.println("Name of a Student is : " + name);
//        while(rs.next()){
//            System.out.println(rs.getInt(1) + " " + rs.getString(2) + " " + rs.getInt(3));
//        }// to get the all the rows present in the database.


//CRUD
//        String sql = "update \"Student_data\" set sid=4 where sname='Max'";
//        Class.forName("org.postgresql.Driver");
//        Connection con = DriverManager.getConnection(url, uname, pwd);
//        System.out.println("Connected to database successfully");
//
//        Statement st = con.createStatement();
//        boolean status = st.execute(sql);// It tells whether we are able to get the data or not.
////        System.out.println(status); // prints false bcoz expecting resultSet but got count and its fine even it is shows false data get manipulated in the database.
//        con.close();
//        System.out.println("Connection closed successfully");

        //PreparedStatements

        String sql = "insert into \"Student_data\" values(?,?,?)";
        Class.forName("org.postgresql.Driver");
        Connection conn = DriverManager.getConnection(url,uname,pwd);
        PreparedStatement st = conn.prepareStatement(sql);
        st.setInt(1, sid);
        st.setString(2, sname);
        st.setInt(3, Marks);

        st.execute();
        conn.close();
    }
}