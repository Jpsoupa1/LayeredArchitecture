import java.util.List;

public class LivroService {
    private LivroRepository livroRepository;

    public LivroService(LivroRepository livroRepository) {
        this.livroRepository = livroRepository;
    }

    
    public Livro cadastrar(Livro livro) {
        if (livro.getNome() == null || livro.getNome().isEmpty()) {
            throw new RuntimeException("Nome do livro é obrigatório.");
        }
        if (livro.getQuantidade() < 0) {
            throw new RuntimeException("Quantidade não pode ser negativa.");
        }
        return livroRepository.salvar(livro);
    }

    public Livro buscarPorId(int id) {
        Livro livro = livroRepository.buscarPorId(id);
        if (livro == null) throw new RuntimeException("Livro não encontrado.");
        return livro;
    }

    public List<Livro> listarTodos() {
        return livroRepository.listarTodos();
    }

    public void alterar(Livro livro) {
        if (livroRepository.buscarPorId(livro.getId()) == null) {
            throw new RuntimeException("Livro inexistente para alteração.");
        }
        livroRepository.atualizar(livro);
    }

    public void remover(int id) {
        livroRepository.deletar(id);
    }
}