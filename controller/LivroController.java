import java.util.List;

public class LivroController {
    private final LivroService livroService;

    public LivroController(LivroService livroService) {
        this.livroService = livroService;
    }
    
    public void cadastrar(Livro livro) {
        livroService.cadastrar(livro);
    }

    public Livro buscarPorId(int id) {
        return livroService.buscarPorId(id);
    }

    public List<Livro> listarTodos() {
        return livroService.listarTodos();
    }

    public void alterar(Livro livro) {
        livroService.alterar(livro);
    }

    public void remover(int id) {
        livroService.remover(id);
    }
}