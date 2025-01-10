import java.util.List;

public class SistemaCadastro {
    public static void main(String[] args) {
        FabricaConexao.conectar();
        CadastroRepositorio repositorio = new CadastroRepositorio();

        Cadastro cadastro = repositorio.buscar(4);
        if (cadastro != null) {
            System.out.println("Nome: " + cadastro.getNome() + " Idade: " + cadastro.getIdade());
        } else {
            System.out.println("Cadastro não encontrado");
        }

    }
}
