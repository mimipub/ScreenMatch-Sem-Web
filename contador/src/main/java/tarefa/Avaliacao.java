package tarefa;

import java.util.ArrayList;
import java.util.List;

public class Avaliacao<T> {
    private T item;
    private Integer nota;
    private String comentario;

    public Avaliacao(T item, Integer nota, String comentario) throws IllegalArgumentException {
        if (nota == null || nota < 0 || nota > 10) {
            throw new IllegalArgumentException("Nota deve ser entre 0 e 10");
        }
        if(comentario == null || comentario.equals("")) {
            throw new IllegalArgumentException("Comentario não pode estar vazio");
        }
        this.comentario = comentario;
        this.item = item;
        this.nota = nota;
    }

    public T getItem() {
        return item;
    }

    public void setItem(T item) {
        this.item = item;
    }

    public Integer getNota() {
        return nota;
    }

    public void setNota(Integer nota) {
        this.nota = nota;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public void calculoMedia() {
        double soma = 0;
        soma += this.nota;
        System.out.println(soma);
    }

    @Override
    public String toString() {
        return "{" + "Produto: " + item + ", "+ "Nota: " + nota + ", " + "Comentário: "  + comentario + "}";
    }
}
