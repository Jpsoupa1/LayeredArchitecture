import java.util.List;

public class UsuarioController {
    private final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    public void cadastrar(Usuario usuario) {
        usuarioService.cadastrar(usuario);
    }

    public Usuario buscarPorId(int id) {
        return usuarioService.buscarPorId(id);
    }

    public List<Usuario> listarTodos() {
        return usuarioService.listarTodos();
    }

    public void alterar(Usuario usuario) {
        usuarioService.alterar(usuario);
    }

    public void remover(int id) {
        usuarioService.remover(id);
    }
}