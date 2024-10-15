package com.loester.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_auditoria_payload")
public class AuditoriaPayload {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "acao", nullable = false)
    private String acao;

    @Column(name = "tabela", nullable = false)
    private String tabela;

    @Column(name = "descricao", nullable = false)
    private String descricao;

    @Column(name = "usuario", nullable = false)
    private String usuario;

    @Column(name = "data_hora", nullable = false)
    private LocalDateTime dataHora;

    public AuditoriaPayload() {
    }

    public AuditoriaPayload(Integer id, String acao, String tabela, String descricao, String usuario, LocalDateTime dataHora) {
        this.id = id;
        this.acao = acao;
        this.tabela = tabela;
        this.descricao = descricao;
        this.usuario = usuario;
        this.dataHora = dataHora;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAcao() {
        return acao;
    }

    public void setAcao(String acao) {
        this.acao = acao;
    }

    public String getTabela() {
        return tabela;
    }

    public void setTabela(String tabela) {
        this.tabela = tabela;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public LocalDateTime getDataHora() {
        return dataHora;
    }

    public void setDataHora(LocalDateTime dataHora) {
        this.dataHora = dataHora;
    }

    @Override
    public String toString() {
        return String.format(
                "AuditoriaPayload{id=%d, acao='%s', tabela='%s', descricao='%s', usuario='%s', dataHora=%s}",
                id, acao, tabela, descricao, usuario, dataHora);
    }
}
