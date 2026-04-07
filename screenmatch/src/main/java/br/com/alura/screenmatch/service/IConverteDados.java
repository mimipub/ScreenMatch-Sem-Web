package br.com.alura.screenmatch.service;

public interface IConverteDados<t> {
    <T> t converteDados(String json, Class<T> classe);
}
