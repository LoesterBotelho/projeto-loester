CREATE OR REPLACE PROCEDURE sp_cadastrar_cliente(
    p_nome VARCHAR(100),
    p_telefone VARCHAR(20),
    p_cpf VARCHAR(11),
    p_endereco VARCHAR(255),
    p_numero VARCHAR(10),
    p_complemento VARCHAR(50),
    p_cep VARCHAR(10),
    p_bairro VARCHAR(100),
    p_id_municipio INT
)
LANGUAGE plpgsql AS $$
BEGIN
    INSERT INTO tb_pessoas (nome, telefone, cpf, endereco, numero, complemento, cep, bairro, id_municipio)
    VALUES (p_nome, p_telefone, p_cpf, p_endereco, p_numero, p_complemento, p_cep, p_bairro, p_id_municipio);
END;
$$;



CREATE OR REPLACE PROCEDURE sp_atualizar_cliente(
    p_id INT,
    p_nome VARCHAR(100),
    p_telefone VARCHAR(20),
    p_cpf VARCHAR(11),
    p_endereco VARCHAR(255),
    p_numero VARCHAR(10),
    p_complemento VARCHAR(50),
    p_cep VARCHAR(10),
    p_bairro VARCHAR(100),
    p_id_municipio INT
)
LANGUAGE plpgsql AS $$
BEGIN
    UPDATE tb_pessoas
    SET
        nome = p_nome,
        telefone = p_telefone,
        cpf = p_cpf,
        endereco = p_endereco,
        numero = p_numero,
        complemento = p_complemento,
        cep = p_cep,
        bairro = p_bairro,
        id_municipio = p_id_municipio,
        updated_at = CURRENT_TIMESTAMP  
    WHERE
        id = p_id;
END;
$$;



CREATE OR REPLACE PROCEDURE sp_deletar_cliente(
    p_id INT
)
LANGUAGE plpgsql AS $$
BEGIN
    DELETE FROM tb_pessoas
    WHERE id = p_id;
END;
$$;



CREATE OR REPLACE PROCEDURE sp_consultar_cliente_por_id(
    p_id INT,
    OUT o_nome VARCHAR(100),
    OUT o_telefone VARCHAR(20),
    OUT o_cpf VARCHAR(11),
    OUT o_endereco VARCHAR(255),
    OUT o_numero VARCHAR(10),
    OUT o_complemento VARCHAR(50),
    OUT o_cep VARCHAR(10),
    OUT o_bairro VARCHAR(100),
    OUT o_id_municipio INT,
    OUT o_created_at TIMESTAMP,
    OUT o_updated_at TIMESTAMP
)
LANGUAGE plpgsql AS $$
BEGIN
    SELECT 
        nome, 
        telefone, 
        cpf, 
        endereco, 
        numero, 
        complemento, 
        cep, 
        bairro, 
        id_municipio,
        created_at,
        updated_at
    INTO 
        o_nome, 
        o_telefone, 
        o_cpf, 
        o_endereco, 
        o_numero, 
        o_complemento, 
        o_cep, 
        o_bairro, 
        o_id_municipio,
        o_created_at,
        o_updated_at
    FROM tb_pessoas
    WHERE id = p_id;

    
    IF NOT FOUND THEN
        RAISE EXCEPTION 'Cliente com ID % não encontrado.', p_id;
    END IF;
END;
$$;



CREATE OR REPLACE PROCEDURE sp_consultar_todos_clientes()
LANGUAGE plpgsql AS $$
DECLARE
    r_cliente RECORD;  
BEGIN
    FOR r_cliente IN 
        SELECT 
            id,
            nome,
            telefone,
            cpf,
            endereco,
            numero,
            complemento,
            cep,
            bairro,
            id_municipio,
            created_at,
            updated_at
        FROM tb_pessoas
    LOOP
      
        RAISE NOTICE 'ID: %, Nome: %, Telefone: %, CPF: %, Endereço: %, Número: %, Complemento: %, CEP: %, Bairro: %, ID Município: %, Criado em: %, Atualizado em: %',
            r_cliente.id,
            r_cliente.nome,
            r_cliente.telefone,
            r_cliente.cpf,
            r_cliente.endereco,
            r_cliente.numero,
            r_cliente.complemento,
            r_cliente.cep,
            r_cliente.bairro,
            r_cliente.id_municipio,
            r_cliente.created_at,
            r_cliente.updated_at;
    END LOOP;
END;
$$;