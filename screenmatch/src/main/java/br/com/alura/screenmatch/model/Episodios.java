package br.com.alura.screenmatch.model;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.zip.DataFormatException;

public class Episodios {
    private Integer temporada;
    private String title;
    private Integer numero;
    private double avaliacao;
    private LocalDate dataLancameto;

    public Episodios(Integer numeroTemporada, DadosEpisodio dadosEpisodios) {
        this.temporada = numeroTemporada;
        this.title = dadosEpisodios.title();
        this.numero = dadosEpisodios.numero();
        try {
            this.avaliacao = Double.valueOf(dadosEpisodios.avaliacao());
        }catch(NumberFormatException ex){
            this.avaliacao = 0.0;
        }

        try{
            this.dataLancameto = LocalDate.parse(dadosEpisodios.dataLancameto());
        }catch (DateTimeParseException ex){
            this.dataLancameto = null;
        }
    }

    public Integer getTemporada() {
        return temporada;
    }

    public double getAvaliacao() {
        return avaliacao;
    }

    public void setAvaliacao(double avaliacao) {
        this.avaliacao = avaliacao;
    }

    public LocalDate getDataLancameto() {
        return dataLancameto;
    }

    public void setDataLancameto(LocalDate dataLancameto) {
        this.dataLancameto = dataLancameto;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return  "temporada=" + temporada +
                ", titulo='" + title + '\'' +
                ", numeroEpisodio=" + numero +
                ", avaliacao=" + avaliacao +
                ", dataLancamento=" + dataLancameto;
    }
}
