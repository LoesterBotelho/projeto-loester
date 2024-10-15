CREATE TRIGGER trigger_tb_paises
BEFORE UPDATE ON tb_paises
FOR EACH ROW
EXECUTE FUNCTION update_updated_at();

CREATE TRIGGER trigger_tb_estados
BEFORE UPDATE ON tb_estados
FOR EACH ROW
EXECUTE FUNCTION update_updated_at();

CREATE TRIGGER trigger_tb_municipios
BEFORE UPDATE ON tb_municipios
FOR EACH ROW
EXECUTE FUNCTION update_updated_at();

CREATE TRIGGER trigger_tb_pessoas
BEFORE UPDATE ON tb_pessoas
FOR EACH ROW
EXECUTE FUNCTION update_updated_at();