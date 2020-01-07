package br.com.controlefinanceiro.model.entidade;

import androidx.annotation.NonNull;

import java.io.Serializable;

import br.com.controlefinanceiro.model.BaseModel;

public class Cliente extends BaseModel implements Serializable {

    public int estoque;
    public String endereco;
    public String nome;
    public String codigo;
    public Double porcentagem;                     //valor de comissão do lugar
    public Rota rota;

    @NonNull
    @Override
    public String toString() {
        return codigo;
    }
}
