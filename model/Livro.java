public class Livro {
    private int id;
    private String nome;
    private String autor;
    private double edicao;
    private int quantidade;
    private boolean emprestado;

    public Livro() {
    }

    public Livro(String autor, double edicao, boolean emprestado, int id, String nome, int quantidade) {
        this.autor = autor;
        this.edicao = edicao;
        this.emprestado = emprestado;
        this.id = id;
        this.nome = nome;
        this.quantidade = quantidade;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public double getEdicao() {
        return edicao;
    }

    public void setEdicao(double edicao) {
        this.edicao = edicao;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    @Override
    public String toString() {
        return "Produto{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", autor='" + edicao + '\'' +
                ", edicao=" + edicao +
                ", quantidade=" + quantidade +
                '}';
    }

    public boolean isEmprestado() {
        return emprestado;
    }

    public void setEmprestado(boolean emprestado) {
        this.emprestado = emprestado;
    }
}
