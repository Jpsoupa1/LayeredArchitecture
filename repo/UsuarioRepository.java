import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class UsuarioRepository {

    private final List<Usuario> usuarios = new ArrayList<>();
    private int proximoId = 1;

    public Usuario salvar(Usuario usuario) {
        if (usuario.getId() == 0) {
            usuario.setId(proximoId++);
            usuarios.add(usuario);
        } else {
            atualizar(usuario);
        }
        return usuario;
    }

    public Usuario buscarPorId(int id) {
        return usuarios.stream()
                .filter(u -> u.getId() == id)
                .findFirst()
                .orElse(null);
    }

    public Usuario buscarPorCpf(String cpf) {
        return usuarios.stream()
                .filter(u -> u.getCpf().equals(cpf))
                .findFirst()
                .orElse(null);
    }

    public Usuario buscarPorEmail(String email) {
        return usuarios.stream()
                .filter(u -> u.getEmail().equalsIgnoreCase(email))
                .findFirst()
                .orElse(null);
    }

    public List<Usuario> buscarPorNome(String nome) {
        return usuarios.stream()
                .filter(u -> u.getNome().toLowerCase().contains(nome.toLowerCase()))
                .collect(Collectors.toList());
    }

    public List<Usuario> listarTodos() {
        return new ArrayList<>(usuarios);
    }

    public void atualizar(Usuario usuario) {
        for (int i = 0; i < usuarios.size(); i++) {
            if (usuarios.get(i).getId() == usuario.getId()) {
                usuarios.set(i, usuario);
                return;
            }
        }
    }

    
    public void deletar(int id) {
        usuarios.removeIf(u -> u.getId() == id);
    }
}