import java.util.List;

public interface ProdutoService {
    Produto cadastrar(Produto produto);
    Produto buscarPorId(int id);
    List<Produto> buscarPorNome(String nome);
    List<Produto> listarTodos();
    void alterar(Produto produto);
    void remover(int id);
}
