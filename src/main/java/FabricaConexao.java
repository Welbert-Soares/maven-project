import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class FabricaConexao {
    private static Connection conexao;
    public static void conectar(){
        try {
            if (conexao == null) {
                String url = "jdbc:postgresql://localhost:5432/rocket_db";
                Properties props = new Properties();
                props.setProperty("user", "postgres");
                props.setProperty("password", "8770");
                conexao = DriverManager.getConnection(url, props);
                System.out.println("Connected to the PostgreSQL server successfully.");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static Connection getConexao() {
        return conexao;
    }
}
