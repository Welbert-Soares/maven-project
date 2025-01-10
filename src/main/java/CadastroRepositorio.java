import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class CadastroRepositorio {
    private Connection conexao;
    public CadastroRepositorio(){
        conexao = FabricaConexao.getConexao();
    }

    public void incluir(Cadastro cadastro){
        try{
            String querySQL = "INSERT INTO public.tb_cadastro(nome, idade) VALUES(?,? );";
            PreparedStatement pst = conexao.prepareStatement(querySQL);
            pst.setString(1, cadastro.getNome());
            pst.setInt(2, cadastro.getIdade());

            pst.execute();
            System.out.println("Inserted data successfully");
        } catch (Exception ex){
            ex.printStackTrace();
        }
    }

    public void alterar(Cadastro cadastro){
        try {
            String querySQL = "UPDATE public.tb_cadastro SET nome = ?, idade = ? WHERE id = ?;";
            PreparedStatement pst = conexao.prepareStatement(querySQL);
            pst.setString(1, cadastro.getNome());
            pst.setInt(2, cadastro.getIdade());
            pst.setInt(3, cadastro.getId());

            pst.execute();
            System.out.println("Updated data successfully");
        } catch (Exception ex){
            ex.printStackTrace();
        }
    }

    public void excluir(Integer id){
        try {
            String querySQL = "DELETE FROM public.tb_cadastro WHERE id = ?;";
            PreparedStatement pst = conexao.prepareStatement(querySQL);
            pst.setInt(1, id);

            pst.execute();
            System.out.println("Deleted data successfully");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public List<Cadastro> listar(){
        List<Cadastro> lista = new ArrayList<>();
        try {
            String querySQL = "SELECT id, nome, idade FROM public.tb_cadastro;";
            PreparedStatement statement = conexao.prepareStatement(querySQL);
//            statement.setInt(1, 1);
            ResultSet result = statement.executeQuery();
            while (result.next()){
                Integer id = result.getInt("id");
                String nome = result.getString("nome");
                Integer idade = result.getInt("idade");

                Cadastro cadastro = new Cadastro();
                cadastro.setId(id);
                cadastro.setNome(nome);
                cadastro.setIdade(idade);

                lista.add(cadastro);
            }
        } catch (Exception ex){
            ex.printStackTrace();
        }
        return lista;
    }

    public Cadastro buscar(Integer id){
        Cadastro cadastro = null;
        try {
            String querySQL = "SELECT id, nome, idade FROM public.tb_cadastro WHERE id = ?;";
            PreparedStatement statement = conexao.prepareStatement(querySQL);
            statement.setInt(1, id);
            ResultSet result = statement.executeQuery();
            if (result.next()){
                String nome = result.getString("nome");
                Integer idade = result.getInt("idade");

                cadastro = new Cadastro();
                cadastro.setId(id);
                cadastro.setNome(nome);
                cadastro.setIdade(idade);

            }
        } catch (Exception ex){
            ex.printStackTrace();
        }
        return cadastro;
    }
}
