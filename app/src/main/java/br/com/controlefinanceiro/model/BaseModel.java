package br.com.controlefinanceiro.model;

import com.google.firebase.firestore.ServerTimestamp;

import java.io.Serializable;
import java.util.Date;

public class BaseModel implements Serializable {

    public String key;

    @ServerTimestamp
    public Date dataUltimaAtualizacao;

}
