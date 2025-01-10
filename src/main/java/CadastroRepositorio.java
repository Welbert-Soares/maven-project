import java.sql.Connection;
import java.util.List;

public class CadastroRepositorio {
    private Connection conexao;
    public CadastroRepositorio(){
        conexao = FabricaConexao.getConexao();
    }

    public void salvar(Cadastro cadastro){}
    public void alterar(Cadastro cadastro){}
    public void excluir(Integer id){}
    public List<Cadastro> listar(){
        return null;
    }
    public Cadastro buscar(){
        return null;
    }
}
