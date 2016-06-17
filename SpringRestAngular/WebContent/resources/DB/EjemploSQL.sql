/*
	TABLAS
*/
CREATE TABLE TIPOS_IDENTIFICACION (
	codigo 		INTEGER, -- INTEGER(3),
	descripcion VARCHAR(50)
);

CREATE TABLE ALUMNOS (
	identificacion 		BIGINT,--BIGINTEGER(15),
	tipo_identificacion	INTEGER,--INTEGER(3),
	nombre				VARCHAR(200),
	apellido_primero	VARCHAR(100),
	apellido_segundo	VARCHAR(100),
	fecha_nacimiento	DATE
);

CREATE TABLE PROFESORES (
	identificacion 		BIGINT,
	tipo_identificacion	INTEGER,
	nombre				VARCHAR(200),
	apellido_primero	VARCHAR(100),
	apellido_segundo	VARCHAR(100),
	fecha_nacimiento	DATE
);

/*
	REGLAS
*/
-- TIPOS_IDENTIFICACION
ALTER TABLE TIPOS_IDENTIFICACION ADD CONSTRAINT pk_tipos_identificacion PRIMARY KEY (codigo);
ALTER TABLE TIPOS_IDENTIFICACION ADD CONSTRAINT nn_tip_id_descripcion CHECK (descripcion IS NOT NULL);

-- ALUMNOS
ALTER TABLE ALUMNOS ADD CONSTRAINT pk_alumnos PRIMARY KEY (identificacion);
ALTER TABLE ALUMNOS ADD CONSTRAINT fk_tip_ident_alum FOREIGN KEY (tipo_identificacion) REFERENCES TIPOS_IDENTIFICACION(codigo);
ALTER TABLE ALUMNOS ADD CONSTRAINT nn_alum_nombre CHECK (nombre IS NOT NULL);
ALTER TABLE ALUMNOS ADD CONSTRAINT nn_alum_apellido_p CHECK (apellido_primero IS NOT NULL);
ALTER TABLE ALUMNOS ADD CONSTRAINT nn_alum_fecha_nac CHECK (fecha_nacimiento IS NOT NULL);

-- PROFESORES
ALTER TABLE PROFESORES ADD CONSTRAINT pk_profesores PRIMARY KEY (identificacion);
ALTER TABLE PROFESORES ADD CONSTRAINT fk_tip_ident_prof FOREIGN KEY (tipo_identificacion) REFERENCES TIPOS_IDENTIFICACION(codigo);
ALTER TABLE PROFESORES ADD CONSTRAINT nn_prof_nombre CHECK (nombre IS NOT NULL);
ALTER TABLE PROFESORES ADD CONSTRAINT nn_prof_apellido_p CHECK (apellido_primero IS NOT NULL);
ALTER TABLE PROFESORES ADD CONSTRAINT nn_prof_fecha_nac CHECK (fecha_nacimiento IS NOT NULL);