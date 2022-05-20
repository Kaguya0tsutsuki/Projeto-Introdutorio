package back;

public class Tarefa {
    private String nome;
    private String descricao;
    private String dataDeTermino;
    private int prioridade;
    private String categoria;
    private String status;

    public Tarefa(String nome, String descricao, String dataDeTermino, int prioridade, String categoria, String status) {
        this.nome = nome;
        this.descricao = descricao;
        this.dataDeTermino = dataDeTermino;
        this.prioridade = prioridade;
        this.categoria = categoria;
        this.status = status;
    }

    public Tarefa(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return this.nome;
    }

    public String getDescricao() {
        return this.descricao;
    }

    public String getDataDeTermino() {
        return this.dataDeTermino;
    }

    public int getPrioridade() {
        return this.prioridade;
    }

    public String getCategoria() {
        return this.categoria;
    }

    public String getStatus() {
        return this.status;
    }

    public String toString() {
        return "TAREFA: \nNome: " + this.nome + "\nDescrição: " + this.descricao + "\nData de Termino: " + this.dataDeTermino + "\nPrioridade: " + this.prioridade + "\nCategoria: " + this.categoria + "\nStatus: " + this.status + "\n";
    }
}
