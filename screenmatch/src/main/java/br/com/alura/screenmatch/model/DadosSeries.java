package br.com.alura.screenmatch.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DadosSeries(@JsonAlias("Title") String titulo,
//                          nve
                          @JsonAlias("imdbRating") String avaliacao,
                          @JsonAlias("totalSeasons") Integer totalTemporada){
}
