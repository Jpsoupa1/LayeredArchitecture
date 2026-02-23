import java.util.List;

public interface ProdutoRepository {
    Produto salvar(Produto produto);
    Produto buscarPorId(int id);
    List<Produto> buscarPorNome(String nome);
    List<Produto> listarTodos();
    void atualizar(Produto produto);
    void deletar(int id);
}
