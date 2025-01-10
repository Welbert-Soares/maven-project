
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;
import java.sql.DriverManager;


public class JDBCPostgres {
    public static void main(String[] args) {
        try {
            String url = "jdbc:postgresql://localhost:5432/rocket_db";
            Properties props = new Properties();
            props.setProperty("user", "postgres");
            props.setProperty("password", "8770");
//            props.setProperty("ssl", "true");
            Connection conn = DriverManager.getConnection(url, props);
            System.out.println("Connected to the PostgreSQL server successfully.");

            String querySQL = "INSERT INTO public.tb_cadastro(nome, idade) VALUES(?,? );";
            String nome = "Hanna";
            Integer idade = 24;

            PreparedStatement pst = conn.prepareStatement(querySQL);
            pst.setString(1, nome);
            pst.setInt(2, idade);

            pst.execute();
            System.out.println("Inserted data successfully");


        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }


}
