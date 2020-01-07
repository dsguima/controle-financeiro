package br.com.controlefinanceiro.model.entidade;

import androidx.annotation.NonNull;

import java.io.Serializable;

import br.com.controlefinanceiro.model.BaseModel;

public class Rota extends BaseModel implements Serializable {

    public String nome;
    public Colaborador colaborador;

    @NonNull
    @Override
    public String toString() {
        return nome;
    }
}
