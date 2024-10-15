package com.loester.entity;

import java.time.LocalDateTime;

import com.loester.annotation.ColumnName;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_pessoas")
public class Pessoa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@ColumnName("id")
	private Integer id;

	@ColumnName("nome")
	private String nome;

	@ColumnName("telefone")
	private String telefone;

	@ColumnName("cpf")
	private String cpf;

	@ColumnName("endereco")
	private String endereco;

	@ColumnName("numero")
	private String numero;

	@ColumnName("complemento")
	private String complemento = "";

	@ColumnName("cep")
	private String cep;

	@ColumnName("bairro")
	private String bairro;
		
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_municipio", nullable = false)
    private Municipio municipio;
    
    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

	public Pessoa() {
		this.complemento = "";
	}

	
	public Pessoa(Integer id, String nome, String telefone, String cpf, String endereco, String numero,
			String complemento, String cep, String bairro, Municipio municipio, LocalDateTime createdAt,
			LocalDateTime updatedAt) {
		this.id = id;
		this.nome = nome;
		this.telefone = telefone;
		this.cpf = cpf;
		this.endereco = endereco;
		this.numero = numero;
		this.complemento = complemento;
		this.cep = cep;
		this.bairro = bairro;
		this.municipio = municipio;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
	}
	
	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}

	public LocalDateTime getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(LocalDateTime updatedAt) {
		this.updatedAt = updatedAt;
	}

	public Municipio getMunicipio() {
		return municipio;
	}

	public void setMunicipio(Municipio municipio) {
		this.municipio = municipio;
	}

	public int getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		if (cpf != null && cpf.matches("\\d{11}")) {
			this.cpf = cpf;
		} else {
			throw new IllegalArgumentException("CPF deve ter 11 dígitos e conter apenas números.");
		}
	}

	public String getComplemento() {

	    return complemento != null ? complemento : "";		
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento != null ? complemento : "";
	}

	@Override
	public String toString() {
		return String.format(
				"Pessoa{id=%d, nome='%s', telefone='%s', cpf='%s', endereco='%s', numero='%s', complemento='%s', cep='%s', bairro='%s', municipio=%s}",
				id, nome, telefone, cpf, endereco, numero, getComplemento(), cep, bairro, municipio.getNome());
	}
}
