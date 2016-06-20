/* ************* TABLAS ************* */
CREATE TABLE TIPOS_IDENTIFICACION (
	codigo 		INTEGER,
	descripcion VARCHAR(50)
);

CREATE TABLE ALUMNOS (
	identificacion 		BIGINT,
	tipo_identificacion	INTEGER,
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

CREATE TABLE CONFIG_CURSOS (
	codigo				INTEGER,
	descripcion			VARCHAR(150),
	minutos_de_clase	INTEGER,
	nro_max_alumnos		INTEGER,
	nro_min_alumnos		INTEGER,
	cantidad_clases		INTEGER,
	estado				BOOLEAN
);

CREATE TABLE CURSOS (
	codigo				INTEGER,
	nombre				VARCHAR(150),
	anhio				INTEGER,
	numero_curso		INTEGER,
	fecha_inicio		DATE,
	fecha_fin			DATE,
	config_cursos		INTEGER,
	estado				BOOLEAN
);

CREATE TABLE CLASES (
	codigo				INTEGER,
	curso				INTEGER,
	profesor			BIGINT,
	profesor_aux		BIGINT,
	dia					VARCHAR(30),
	hora_ini			DATE,
	hora_fin			DATE,
	estado				BOOLEAN
);

/* ************* REGLAS ************* */
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

-- CONFIG_CURSOS
ALTER TABLE CONFIG_CURSOS ADD CONSTRAINT pk_conf_clas PRIMARY KEY (codigo);
ALTER TABLE CONFIG_CURSOS ADD CONSTRAINT nn_conf_cla_des CHECK (descripcion IS NOT NULL);
ALTER TABLE CONFIG_CURSOS ADD CONSTRAINT nn_conf_cla_min_clas CHECK (minutos_de_clase IS NOT NULL);
ALTER TABLE CONFIG_CURSOS ADD CONSTRAINT nn_conf_alm_max CHECK (nro_max_alumnos IS NOT NULL);
ALTER TABLE CONFIG_CURSOS ADD CONSTRAINT nn_conf_alm_min CHECK (nro_min_alumnos IS NOT NULL);
ALTER TABLE CONFIG_CURSOS ADD CONSTRAINT nn_conf_can_cla CHECK (cantidad_clases IS NOT NULL);
ALTER TABLE CONFIG_CURSOS ADD CONSTRAINT nn_conf_est CHECK (estado IS NOT NULL);

-- CURSOS
ALTER TABLE CURSOS ADD CONSTRAINT pk_cursos PRIMARY KEY (codigo);
ALTER TABLE CURSOS ADD CONSTRAINT nn_curs_nombre CHECK (nombre IS NOT NULL);
ALTER TABLE CURSOS ADD CONSTRAINT nn_curs_anhio CHECK (anhio IS NOT NULL);
ALTER TABLE CURSOS ADD CONSTRAINT nn_curs_nro_curs CHECK (numero_curso IS NOT NULL);
ALTER TABLE CURSOS ADD CONSTRAINT nn_curs_fec_ini CHECK (fecha_inicio IS NOT NULL);
ALTER TABLE CURSOS ADD CONSTRAINT nn_curs_fec_fin CHECK (fecha_fin IS NOT NULL);
ALTER TABLE CURSOS ADD CONSTRAINT fk_curs_conf_cur FOREIGN KEY (config_cursos) REFERENCES CONFIG_CURSOS(codigo);
ALTER TABLE CURSOS ADD CONSTRAINT nn_curs_est CHECK (estado IS NOT NULL);

-- CLASES
ALTER TABLE CLASES ADD CONSTRAINT pk_clases PRIMARY KEY (codigo);
ALTER TABLE CLASES ADD CONSTRAINT fk_clas_curso FOREIGN KEY (curso) REFERENCES CURSOS(codigo);
ALTER TABLE CLASES ADD CONSTRAINT fk_clas_prof FOREIGN KEY (profesor) REFERENCES PROFESORES(identificacion);
ALTER TABLE CLASES ADD CONSTRAINT nn_clas_prof CHECK (profesor IS NOT NULL);
ALTER TABLE CLASES ADD CONSTRAINT fk_clas_prof_aux FOREIGN KEY (profesor_aux) REFERENCES PROFESORES(identificacion);
ALTER TABLE CLASES ADD CONSTRAINT nn_clas_dia CHECK (dia IS NOT NULL);
ALTER TABLE CLASES ADD CONSTRAINT nn_clas_hor_ini CHECK (hora_ini IS NOT NULL);
ALTER TABLE CLASES ADD CONSTRAINT nn_clas_hor_fin CHECK (hora_fin IS NOT NULL);
ALTER TABLE CLASES ADD CONSTRAINT nn_clas_est CHECK (estado IS NOT NULL);
