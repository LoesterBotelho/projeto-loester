package com.loester.entity;

import java.time.LocalDateTime;
import java.util.List;

import com.loester.annotation.ColumnName;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_estados")
public class Estado {
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@ColumnName("id")
	private Integer id;

	@ColumnName("nome")
	private String nome;

	@ColumnName("sigla")
	private String sigla;

    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_pais", nullable = false)
    private Pais pais;
    
    @OneToMany(mappedBy = "estado", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Municipio> municipios;
	public Estado() {
	}

	public Estado(Integer id, String nome, String sigla, Integer idPais, Pais pais, LocalDateTime createdAt, LocalDateTime updatedAt) {
		this.id = id;
		this.nome = nome;
		this.sigla = sigla;
		this.pais = pais;
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

	public Pais getPais() {
		return pais;
	}

	public void setPais(Pais pais) {
		this.pais = pais;
	}

	@Override
	public String toString() {
	    StringBuilder sb = new StringBuilder("Estado{");
	    sb.append("id=").append(id)
	      .append(", nome='").append(nome).append('\'')
	      .append(", sigla='").append(sigla).append('\'')
	      .append(", pais=").append(pais != null ? pais.toString() : "null")
	      .append(", createdAt=").append(createdAt)
	      .append(", updatedAt=").append(updatedAt)
	      .append('}');
	    return sb.toString();
	}

}
