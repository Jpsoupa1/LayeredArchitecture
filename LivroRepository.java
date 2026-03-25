import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class LivroRepository {

    private final List<Livro> biblioteca = new ArrayList<>();
    private int proximoId = 1;

    public Livro salvar(Livro livro) {
        if (livro.getId() == 0) {
            livro.setId(proximoId++);
            biblioteca.add(livro);
        } else {
            atualizar(livro);
        }
        return livro;
    }

    public Livro buscarPorId(int id) {
        return biblioteca.stream()
                .filter(l -> l.getId() == id)
                .findFirst()
                .orElse(null);
    }

    public List<Livro> buscarPorNome(String nome) {
        return biblioteca.stream()
                .filter(l -> l.getTitulo().toLowerCase().contains(nome.toLowerCase()))
                .collect(Collectors.toList());
    }

    public List<Livro> listarTodos() {
        return new ArrayList<>(biblioteca);
    }

    public void atualizar(Livro livro) {
        for (int i = 0; i < biblioteca.size(); i++) {
            if (biblioteca.get(i).getId() == livro.getId()) {
                biblioteca.set(i, livro);
                return;
            }
        }
    }

    
    public void deletar(int id) {
        biblioteca.removeIf(l -> l.getId() == id);
    }
}