import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
public class JDBCDemo {
    public static void main(String[] args)throws Exception {
        System.out.println("New Feature added from RMS123");
        Class.forName("com.mysql.cj.jdbc.Driver");
        String url="jdbc:mysql://localhost:3306/mydb";
        String uname="root";
        String password ="password";
        ResultSet result=null;
        Connection con=null;
        String query="select * from employee";
        String insertQuery="insert into employee values('4','Minu','Kerala')";
        try{
            con=DriverManager.getConnection(url,uname,password);
            Statement st=con.createStatement();
//            int count=st.executeUpdate(insertQuery);
//            System.out.println("Number of rows affected : "+count);
            boolean execute=st.execute(insertQuery);
            if(execute){
                result=st.getResultSet();
                result.next();
                System.out.println(result.getString(2));
            }else {
                System.out.println("No. of rows updated :"+st.getUpdateCount());
            }
        }finally{
            if (result!=null)
                result.close();
            if(con!=null)
                con.close();
        }
    }
}


