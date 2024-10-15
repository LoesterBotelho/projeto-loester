CREATE TABLE IF NOT EXISTS tb_paises (
    id SERIAL PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    sigla VARCHAR(3) UNIQUE NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE IF NOT EXISTS tb_estados (
    id SERIAL PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    sigla VARCHAR(2) NOT NULL UNIQUE,
    id_pais INT NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (id_pais) REFERENCES tb_paises(id) ON DELETE CASCADE
);

CREATE TABLE IF NOT EXISTS tb_municipios (
    id SERIAL PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    id_estado INT NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (id_estado) REFERENCES tb_estados(id) ON DELETE CASCADE
);

CREATE TABLE IF NOT EXISTS tb_pessoas (
    id SERIAL PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    telefone VARCHAR(20),
    cpf VARCHAR(11) UNIQUE NOT NULL CHECK (cpf ~ '^\d{11}$'),
    email VARCHAR(100) UNIQUE NOT NULL,
    endereco VARCHAR(255),
    numero VARCHAR(10),
    complemento VARCHAR(50),
    cep VARCHAR(10),
    bairro VARCHAR(100),
    id_municipio INT NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (id_municipio) REFERENCES tb_municipios(id) ON DELETE CASCADE
);

CREATE TABLE tb_auditoria_payload (
    id SERIAL PRIMARY KEY,                      
    entidade VARCHAR(100) NOT NULL,             
    acao VARCHAR(50) NOT NULL,                  
    payload JSONB NOT NULL,                     
    usuario VARCHAR(100),                       
    ip_origem VARCHAR(50),                      
    data_hora TIMESTAMP NOT NULL DEFAULT NOW(), 
    status SMALLINT DEFAULT 1                   
);
