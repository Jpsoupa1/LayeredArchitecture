import java.util.List;

public class UsuarioService {
    private UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public Usuario cadastrar(Usuario usuario) {
        if (usuario.getCpf() == null || usuario.getEmail() == null) {
            throw new RuntimeException("CPF e Email são obrigatórios para o cadastro.");
        }
        return usuarioRepository.salvar(usuario);
    }

    public Usuario buscarPorId(int id) {
        Usuario user = usuarioRepository.buscarPorId(id);
        if (user == null) throw new RuntimeException("Usuário não encontrado.");
        return user;
    }

    public List<Usuario> listarTodos() {
        return usuarioRepository.listarTodos();
    }

    public void alterar(Usuario usuario) {
        usuarioRepository.atualizar(usuario);
    }

    public void remover(int id) {
        usuarioRepository.deletar(id);
    }
}