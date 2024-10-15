CREATE OR REPLACE VIEW vw_relatorio_clientes AS
SELECT
    c.id AS cliente_id,
    c.nome AS nome_cliente,
    c.telefone AS telefone_cliente,
    c.cpf AS cpf_cliente,
    c.endereco AS endereco_cliente,
    c.numero AS numero_cliente,
    c.complemento AS complemento_cliente,
    c.cep AS cep_cliente,
    c.bairro AS bairro_cliente,
    c.created_at AS data_criacao,
    c.updated_at AS data_atualizacao,
    m.nome AS municipio,
    e.nome AS estado
FROM
    tb_pessoas c
JOIN
    tb_municipios m ON c.id_municipio = m.id
JOIN
    tb_estados e ON m.id_estado = e.id;


CREATE OR REPLACE VIEW vw_auditoria_payload AS
SELECT 
    id, 
    entidade, 
    acao, 
    payload, 
    usuario, 
    ip_origem, 
    data_hora, 
    CASE 
        WHEN status = 1 THEN 'Ativo'
        ELSE 'Inativo'
    END AS status_descricao
FROM 
    tb_auditoria_payload
ORDER BY 
    data_hora DESC;
