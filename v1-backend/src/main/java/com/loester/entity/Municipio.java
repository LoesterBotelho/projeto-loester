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
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_municipios")
public class Municipio {
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@ColumnName("id")
	private Integer id;

	@ColumnName("nome")
	private String nome;

	@ColumnName("created_at")
    private LocalDateTime createdAt;

	@ColumnName("updated_at")
    private LocalDateTime updatedAt;
	
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_estado", nullable = false)
    private Estado estado;

    @OneToMany(mappedBy = "municipio", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Pessoa> pessoas;

    
	public Municipio() {
	}

	public Municipio(Integer id, String nome, int idEstado, Estado estado, LocalDateTime createdAt, LocalDateTime updatedAt) {
		this.id = id;
		this.nome = nome;		
		this.estado = estado;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
	}
	
	public List<Pessoa> getPessoas() {
		return pessoas;
	}

	public void setPessoas(List<Pessoa> pessoas) {
		this.pessoas = pessoas;
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

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}

	@Override
	public String toString() {
	    StringBuilder sb = new StringBuilder("Municipio{");
	    sb.append("id=").append(id)
	      .append(", nome='").append(nome).append('\'')
	      .append(", estado=").append(estado != null ? estado.toString() : "null")
	      .append(", createdAt=").append(createdAt)
	      .append(", updatedAt=").append(updatedAt)
	      .append('}');
	    return sb.toString();
	}

}
