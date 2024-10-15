select upper(m.ESTADO) , m.* from tb_000-municipios_utf8_lo m;

select upper(t.nome) , t.* from tb_estados t;

select estado_upper from (
	select upper(m.ESTADO) as estado_upper from tb_000-municipios_utf8_lo m
	) group by estado_upper; 
	
-- 26 estados
select count(estado_upper) from (
	select estado_upper from (
		select upper(m.ESTADO) as estado_upper from tb_000-municipios_utf8_lo m
		) group by estado_upper
);	

select upper(t.nome) , t.* from tb_estados t;

select tm.* from tb_municipios tm;


Select * from pg_available_extensions();

CREATE EXTENSION unaccent;

--- ok , todos estados vinculados
select nome , id_estado from (
	select nome , id_estado from (
		select m.cidade as nome, t.id as id_estado 
		from tb_000-municipios_utf8_lo m
		left join tb_estados t on (upper(unaccent(m.ESTADO)) = upper(unaccent(t.nome)))
	)
	) aaa where aaa.id_estado is null
	;
	


select nome , id_estado from (
	select nome , id_estado from (
		select m.cidade as nome, t.id as id_estado 
		from tb_000-municipios_utf8_lo m
		left join tb_estados t on (upper(unaccent(m.ESTADO)) = upper(unaccent(t.nome)))
	)
	) aaa where aaa.id_estado is not null
	;	

delete from tb_municipios tm;

ALTER SEQUENCE tb_municipios_id_seq RESTART WITH 1;	