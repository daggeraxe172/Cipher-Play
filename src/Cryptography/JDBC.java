package Cryptography;

import java.sql.*;

public class JDBC {

    public static long insert(String n, String e, char[] p){
        long result = 0;
        try{
            Class.forName("oracle.jdbc.driver.OracleDriver");

            Connection con= DriverManager.getConnection(
                    "jdbc:oracle:thin:@localhost:1521:xe","system","oracle");

            if (con != null)
                System.out.println("YES");
            else
                System.out.println("NO");

            Statement st=con.createStatement();

            /*
            TEST CODE :
            ResultSet rs=st.executeQuery("select * from emp");
            while(rs.next())
                System.out.println(rs.getString(1));
             */

            String sql = "insert into signup(name,email,password) values(?,?,?)";

            PreparedStatement statement = con.prepareStatement(sql);
            statement.setString(1, n);
            statement.setString(2, e);
            statement.setString(3, String.valueOf(p));
            int count = statement.executeUpdate();

            //int count=st.executeUpdate("insert into signup(id,name,email,password) values(signup_id.nextval,'"+ n +"','"+ e +"','"+ p +"')");
            System.out.println("Rows inserted: " + count);

            ResultSet rs=st.executeQuery("select * from signup");
            while(rs.next())
            result = Long.parseLong(rs.getString(1));

            con.close();

        }catch(Exception ex){
            System.out.println(ex);
        }
        return (result);
    }
    public static boolean check(String i, char[] p){
        Boolean result = false;
        try{
            Class.forName("oracle.jdbc.driver.OracleDriver");

            Connection con= DriverManager.getConnection(
                    "jdbc:oracle:thin:@localhost:1521:xe","system","oracle");

            if (con != null)
                System.out.println("YES");
            else
                System.out.println("NO");

            Statement st=con.createStatement();

            String sql = "select id,name,email,password from signup where id = ? and password = ?";

            PreparedStatement statement = con.prepareStatement(sql);
            statement.setString(1, i);
            statement.setString(2, String.valueOf(p));
            ResultSet rs = statement.executeQuery();

            if(rs.next())
                result = true;

            con.close();

        }catch(Exception ex){
            System.out.println(ex);
        }
        return result;
    }


}
