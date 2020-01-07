package br.com.controlefinanceiro.model.entidade;

import androidx.annotation.NonNull;

import java.io.Serializable;

import br.com.controlefinanceiro.model.BaseModel;

public class Responsavel extends BaseModel implements Serializable {

    public String nome;

    @NonNull
    @Override
    public String toString() {
        return nome;
    }
}