import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("===== SISTEMA DE GERENCIAMENTO DE BIBLIOTECA =====\n");

        // 1. Instanciando os Repositórios (Persistência na memória)
        // Nota: Certifique-se de que essas classes existam no seu projeto
        LivroRepository livroRepo = new LivroRepository();
        UsuarioRepository usuarioRepo = new UsuarioRepository();
        EmprestimoRepository emprestimoRepo = new EmprestimoRepository();

        // 2. Instanciando os Services (Regras de Negócio)
        LivroService livroService = new LivroService(livroRepo);
        UsuarioService usuarioService = new UsuarioService(usuarioRepo);
        EmprestimoService emprestimoService = new EmprestimoService(emprestimoRepo, usuarioRepo, livroRepo);

        // 3. Instanciando os Controllers (Interface de Entrada)
        LivroController livroController = new LivroController(livroService);
        UsuarioController usuarioController = new UsuarioController(usuarioService);
        EmprestimoController emprestimoController = new EmprestimoController(emprestimoService);

        // --- TESTES DE FUNCIONALIDADE ---

        // Cadastrando um Usuário
        Usuario joao = new Usuario(1, "Joao", "joao@email.com", "123.456.789-00", "9999-9999");
        usuarioController.cadastrar(joao);
        System.out.println("Usuário cadastrado: " + joao.getNome());

        // Cadastrando um Livro
        // Construtor: autor, edicao, emprestado, id, nome, quantidade
        Livro livro1 = new Livro("J.K. Rowling", 1.0, false, 101, "Harry Potter", 5);
        livroController.cadastrar(livro1);
        System.out.println("Livro cadastrado: " + livro1.getNome());

        // Realizando um Empréstimo (7 dias)
        System.out.println("\nRealizando empréstimo...");
        emprestimoController.realizarEmprestimo(joao.getId(), livro1.getId(), 7);

        // Verificando estado do livro após empréstimo
        Livro livroConsultado = livroController.buscarPorId(101);
        System.out.println("O livro '" + livroConsultado.getNome() + "' está emprestado? " + livroConsultado.isEmprestado());

        // Listando todos os empréstimos ativos
        List<Emprestimo> lista = emprestimoController.listarTodos();
        System.out.println("\nLista de Empréstimos:");
        for (Emprestimo e : lista) {
            System.out.println(e);
        }

        // Devolvendo o livro
        System.out.println("\nDevolvendo livro...");
        emprestimoController.devolverLivro(1); // O ID do primeiro empréstimo é 1 conforme a lógica do Service
        
        System.out.println("O livro está emprestado? " + livroController.buscarPorId(101).isEmprestado());
    }
}