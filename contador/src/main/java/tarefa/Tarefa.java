package tarefa;

public class Tarefa {
    private  String descricao;
    private boolean concluida;
    private String pesossaResponsavel;

    public Tarefa() {
    }

    public Tarefa(String descricao, boolean concluida, String pesossaResponsavel) {
        this.descricao = descricao;
        this.concluida = concluida;
        this.pesossaResponsavel = pesossaResponsavel;
    }

    public boolean isConcluida() {
        return concluida;
    }

    public void setConcluida(boolean concluida) {
        this.concluida = concluida;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getPesossaResponsavel() {
        return pesossaResponsavel;
    }

    public void setPesossaResponsavel(String pesossaResponsavel) {
        this.pesossaResponsavel = pesossaResponsavel;
    }

    @Override
    public String toString() {
        return "Tarefa: {" +
                "concluida=" + concluida +
                ", descricao='" + descricao + '\'' +
                ", pesossaResponsavel='" + pesossaResponsavel + '\'' +
                '}';
    }
}
