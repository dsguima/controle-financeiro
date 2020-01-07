package br.com.controlefinanceiro.model.entidade;

import androidx.annotation.NonNull;

import java.io.Serializable;

import br.com.controlefinanceiro.model.BaseModel;

public class Despesa extends BaseModel implements Serializable {

    public int mes;
    public int responsavel;
    public int conta;
    public String descricao;
    public Double valor;

    @NonNull
    @Override
    public String toString() {
        return descricao;
    }
}