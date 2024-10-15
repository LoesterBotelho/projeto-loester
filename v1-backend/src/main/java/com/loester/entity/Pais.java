package com.loester.entity;


import java.time.LocalDateTime;
import java.util.List;

import com.loester.annotation.ColumnName;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_paises")
public class Pais {
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@ColumnName("id")
	private Integer id;

	@ColumnName("nome")
	private String nome;

	@ColumnName("sigla")
	private String sigla;

	@ColumnName("created_at")
	private LocalDateTime createdAt;

	@ColumnName("updated_at")
	private LocalDateTime updatedAt;

    @OneToMany(mappedBy = "pais", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Estado> estados;
    
	public Pais() {
	}

	public Pais(Integer id, String nome, String sigla, LocalDateTime createdAt, LocalDateTime updatedAt) {
		this.id = id;
		this.nome = nome;
		this.sigla = sigla;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
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

	public String getSigla() {
		return sigla;
	}

	public void setSigla(String sigla) {
		this.sigla = sigla;
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

	@Override
	public String toString() {
	    StringBuilder sb = new StringBuilder("Pais{");
	    sb.append("id=").append(id)
	      .append(", nome='").append(nome).append('\'')
	      .append(", sigla='").append(sigla).append('\'')
	      .append(", createdAt=").append(createdAt)
	      .append(", updatedAt=").append(updatedAt)
	      .append('}');
	    return sb.toString();
	}

}