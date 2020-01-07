package br.com.controlefinanceiro.model.consulta;

import java.io.Serializable;
import java.util.Date;

import br.com.controlefinanceiro.model.BaseModel;
import br.com.controlefinanceiro.model.entidade.Cliente;
import br.com.controlefinanceiro.model.entidade.Colaborador;
import br.com.controlefinanceiro.model.entidade.Rota;

public class RelatorioConsulta extends BaseModel implements Serializable {

    public Cliente cliente;
    public Colaborador colaborador;
    public Rota rota;
    public Date dataInicio;
    public Date dataFim;
}
