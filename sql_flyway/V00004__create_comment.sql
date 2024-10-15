COMMENT ON TABLE tb_paises IS 'Tabela que armazena informações sobre países e nações.';
COMMENT ON COLUMN tb_paises.nome IS 'Nome do país.';
COMMENT ON COLUMN tb_paises.sigla IS 'Sigla do país, usada para identificação única.';

COMMENT ON TABLE tb_estados IS 'Tabela que armazena informações sobre estados e províncias de países.';
COMMENT ON COLUMN tb_estados.nome IS 'Nome do estado ou província.';
COMMENT ON COLUMN tb_estados.sigla IS 'Sigla do estado ou província, usada para identificação única.';
COMMENT ON COLUMN tb_estados.id_pais IS 'ID do país ao qual o estado pertence.';

COMMENT ON TABLE tb_municipios IS 'Tabela que armazena informações sobre municípios e cidades.';
COMMENT ON COLUMN tb_municipios.nome IS 'Nome do município ou cidade.';
COMMENT ON COLUMN tb_municipios.id_estado IS 'ID do estado ao qual o município pertence.';

COMMENT ON TABLE tb_pessoas IS 'Tabela que armazena informações sobre pessoas.';
COMMENT ON COLUMN tb_pessoas.nome IS 'Nome da pessoa.';
COMMENT ON COLUMN tb_pessoas.telefone IS 'Número de telefone da pessoa.';
COMMENT ON COLUMN tb_pessoas.cpf IS 'CPF da pessoa, usado como identificador único. Deve conter 11 dígitos.';
COMMENT ON COLUMN tb_pessoas.endereco IS 'Endereço da pessoa.';
COMMENT ON COLUMN tb_pessoas.numero IS 'Número do endereço.';
COMMENT ON COLUMN tb_pessoas.complemento IS 'Complemento do endereço.';
COMMENT ON COLUMN tb_pessoas.cep IS 'Código de Endereçamento Postal (CEP) da pessoa. Deve conter 8 dígitos.';
COMMENT ON COLUMN tb_pessoas.bairro IS 'Bairro onde a pessoa reside.';
COMMENT ON COLUMN tb_pessoas.id_municipio IS 'ID do município onde a pessoa reside.';

COMMENT ON TABLE tb_auditoria_payload IS 'Tabela de auditoria que armazena informações sobre as alterações de entidades do sistema.';
COMMENT ON COLUMN tb_auditoria_payload.id IS 'Identificador único do registro de auditoria.';
COMMENT ON COLUMN tb_auditoria_payload.entidade IS 'Nome da entidade ou tabela que sofreu a ação auditada.';
COMMENT ON COLUMN tb_auditoria_payload.acao IS 'Ação realizada sobre a entidade (INSERT, UPDATE, DELETE, etc.).';
COMMENT ON COLUMN tb_auditoria_payload.payload IS 'Dados do evento auditado, armazenados em formato JSONB.';
COMMENT ON COLUMN tb_auditoria_payload.usuario IS 'Nome do usuário que realizou a ação.';
COMMENT ON COLUMN tb_auditoria_payload.ip_origem IS 'Endereço IP de origem da ação realizada.';
COMMENT ON COLUMN tb_auditoria_payload.data_hora IS 'Data e hora em que o evento de auditoria ocorreu.';
COMMENT ON COLUMN tb_auditoria_payload.status IS 'Status do registro de auditoria, onde 1 representa ativo e 0 representa inativo.';
