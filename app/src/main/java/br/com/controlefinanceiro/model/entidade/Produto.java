package br.com.controlefinanceiro.model.entidade;

import androidx.annotation.NonNull;

import java.io.Serializable;

import br.com.controlefinanceiro.model.BaseModel;

public class Produto extends BaseModel implements Serializable {

    public String nome;
    public Double valor;

    public Produto(){}

    @NonNull
    @Override
    public String toString() {
        return nome;
    }

}
