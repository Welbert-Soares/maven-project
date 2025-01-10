public class SistemaCadastro {
    public static void main(String[] args) {
        FabricaConexao.conectar();
        CadastroRepositorio repositorio = new CadastroRepositorio();
        Cadastro cadastro = new Cadastro();
        cadastro.setNome("Aurora");
        cadastro.setIdade(3);

        repositorio.salvar(cadastro);
    }
}
