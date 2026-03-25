import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class EmprestimoRepository {

    // Simula a tabela do banco de dados
    private final List<Emprestimo> baseDeDados = new ArrayList<>();
    private int proximoId = 1;

    public Emprestimo salvar(Emprestimo emprestimo) {
        if (emprestimo.getId() == 0) {
            emprestimo.setId(proximoId++);
            baseDeDados.add(emprestimo);
        } else {
            atualizar(emprestimo);
        }
        return emprestimo;
    }

    public Emprestimo buscarPorId(int id) {
        return baseDeDados.stream()
                .filter(e -> e.getId() == id)
                .findFirst()
                .orElse(null);
    }

    public List<Emprestimo> buscarPorUsuario(int usuarioId) {
        return baseDeDados.stream()
                .filter(e -> e.getUsuarioId() == usuarioId)
                .collect(Collectors.toList());
    }

    public List<Emprestimo> buscarEmprestimosAtivos(int usuarioId) {
        return baseDeDados.stream()
                .filter(e -> e.getUsuarioId() == usuarioId && e.isAtivo())
                .collect(Collectors.toList());
    }

    public List<Emprestimo> listarTodos() {
        return new ArrayList<>(baseDeDados);
    }

    public List<Emprestimo> listarEmprestimosAtivos() {
        return baseDeDados.stream()
                .filter(Emprestimo::isAtivo)
                .collect(Collectors.toList());
    }

    public void atualizar(Emprestimo emprestimo) {
        for (int i = 0; i < baseDeDados.size(); i++) {
            if (baseDeDados.get(i).getId() == emprestimo.getId()) {
                baseDeDados.set(i, emprestimo);
                return;
            }
        }
    }

    public void deletar(int id) {
        baseDeDados.removeIf(e -> e.getId() == id);
    }
}