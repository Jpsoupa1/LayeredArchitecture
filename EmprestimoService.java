import java.time.LocalDate;
import java.util.List;

public class EmprestimoService {
    private EmprestimoRepository emprestimoRepository;
    private UsuarioRepository usuarioRepository;
    private LivroRepository livroRepository;
    private static int proximoId = 1;

    
    public EmprestimoService(EmprestimoRepository emprestimoRepository, 
                            UsuarioRepository usuarioRepository, 
                            LivroRepository livroRepository) {
        this.emprestimoRepository = emprestimoRepository;
        this.usuarioRepository = usuarioRepository;
        this.livroRepository = livroRepository;
    }

    public Emprestimo realizarEmprestimo(int usuarioId, int livroId, int diasEmprestimo) {
        // REGRA: Livro precisa existir
        Livro livro = livroRepository.buscarPorId(livroId);
        if (livro == null) {
            throw new RuntimeException("Erro: Livro inexistente.");
        }

        // REGRA: Usuário precisa existir
        Usuario usuario = usuarioRepository.buscarPorId(usuarioId);
        if (usuario == null) {
            throw new RuntimeException("Erro: Usuário inexistente.");
        }

        // REGRA: Não emprestar livro já emprestado
        if (livro.isEmprestado()) {
            throw new RuntimeException("Erro: O livro '" + livro.getNome() + "' já está emprestado.");
        }

        // Criar o objeto de empréstimo
        LocalDate diaHoje = LocalDate.now();
        LocalDate dataPrevista = diaHoje.plusDays(diasEmprestimo);
        
        Emprestimo novoEmprestimo = new Emprestimo(proximoId++, usuarioId, livroId, diaHoje, dataPrevista);
        
        // Atualizar estado do livro
        livro.setEmprestado(true);
        livroRepository.atualizar(livro);

        return emprestimoRepository.salvar(novoEmprestimo);
    }

    public void devolverLivro(int emprestimoId) {
        Emprestimo emprestimo = emprestimoRepository.buscarPorId(emprestimoId);

        // REGRA: Não devolver livro que não está emprestado (ou empréstimo inexistente/já finalizado)
        if (emprestimo == null || !emprestimo.isAtivo()) {
            throw new RuntimeException("Erro: Empréstimo não encontrado ou já finalizado.");
        }

        // Finalizar empréstimo
        emprestimo.setAtivo(false);
        emprestimo.setDataDevoluçaoReal(LocalDate.now());
        emprestimoRepository.atualizar(emprestimo);

        // Tornar livro disponível novamente
        Livro livro = livroRepository.buscarPorId(emprestimo.getLivroId());
        if (livro != null) {
            livro.setEmprestado(false);
            livroRepository.atualizar(livro);
        }
    }

    public Emprestimo buscarPorId(int id) {
        Emprestimo e = emprestimoRepository.buscarPorId(id);
        if (e == null) throw new RuntimeException("Empréstimo não encontrado.");
        return e;
    }

    public List<Emprestimo> listarTodosEmprestimos() {
        return emprestimoRepository.listarTodos();
    }

    public boolean verificarAtraso(int emprestimoId) {
        Emprestimo e = buscarPorId(emprestimoId);
        if (!e.isAtivo()) return false;
        return LocalDate.now().isAfter(e.getDataDevolucaoPrevista());
    }
}