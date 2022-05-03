
--Primero se deben borrar todas las tablas (de detalle a maestro) y lugo anyadirlas (de maestro a detalle)
--(en este caso en cada una de las aplicaciones (tkrun y descuento) se usa solo una tabla, por lo que no hace falta)

--Para giis.demo.tkrun:
--drop table Carreras;
--create table Carreras (id int primary key not null, inicio 
--date not null, fin date not null, fecha date not null, descr 
--varchar(32), check(inicio<=fin), --check(fin<fecha));

BEGIN TRANSACTION;


DROP TABLE IF EXISTS "socios";
CREATE TABLE IF NOT EXISTS "socios" (
	"idSocio"	INTEGER NOT NULL,
	"dni"	TEXT NOT NULL,
	"nombre"	INTEGER,
	"apellido1"	INTEGER,
	"apellido2"	INTEGER,
	"corrientePago"	INTEGER,
	"cuota"	NUMERIC,
	"telefono" TEXT,
	PRIMARY KEY("idSocio" AUTOINCREMENT)
);



DROP TABLE IF EXISTS "noSocios";
CREATE TABLE IF NOT EXISTS "noSocios" (
	"idNoSocio"	INTEGER NOT NULL,
	"dni"	INTEGER NOT NULL,
	"nombre"	TEXT,
	"apellido1"	TEXT,
	"apellido2"	TEXT,
	PRIMARY KEY("idNoSocio")
);




DROP TABLE IF EXISTS "instalaciones";
CREATE TABLE IF NOT EXISTS "instalaciones" (
	"idInstalacion"	INTEGER NOT NULL,
	"nombre"	TEXT NOT NULL UNIQUE,
	"precioHora"	NUMERIC,
	PRIMARY KEY("idInstalacion" AUTOINCREMENT)
);



DROP TABLE IF EXISTS "reservas";
CREATE TABLE IF NOT EXISTS "reservas" (
	"idReserva"	INTEGER NOT NULL,
	"fecha"	TEXT,
	"horaInicio"	INTEGER,
	"horaFin"	INTEGER,
	"idInstalacion"	INTEGER NOT NULL,
	"idActividad"	INTEGER,
	"idSocio"	INTEGER,
	"estado"	TEXT,
	PRIMARY KEY("idReserva" AUTOINCREMENT),
	FOREIGN KEY("idSocio") REFERENCES "socios"("idSocio"),
	FOREIGN KEY("idInstalacion") REFERENCES "instalaciones"("idInstalacion"),
	FOREIGN KEY("idActividad") REFERENCES "actividades"("idActividad")
);



DROP TABLE IF EXISTS "inscripciones";
CREATE TABLE IF NOT EXISTS "inscripciones" (
	"idActividad"	INTEGER,
	"idSocio"	INTEGER,
	"idNoSocio"	INTEGER,
	FOREIGN KEY("idNoSocio") REFERENCES "noSocios"("idNoSocio"),
	FOREIGN KEY("idActividad") REFERENCES "actividades"("idActividad"),
	FOREIGN KEY("idSocio") REFERENCES "socios"("idSocio")
);



DROP TABLE IF EXISTS "pagos";
CREATE TABLE IF NOT EXISTS "pagos" (
	"idPago"	INTEGER,
	"importe"	NUMERIC,
	"fecha"	DATE,
	"estado"	TEXT,
	"idSocio"	INTEGER,
	"idNoSocio"	INTEGER,
	"idActividad"	INTEGER,
	"idReserva"	INTEGER,
	PRIMARY KEY("idPago" AUTOINCREMENT),
	FOREIGN KEY("idNoSocio") REFERENCES "noSocios"("idNoSocio"),
	FOREIGN KEY("idActividad") REFERENCES "actividades"("idActividad"),
	FOREIGN KEY("idReserva") REFERENCES "reservas"("idReserva"),
	FOREIGN KEY("idSocio") REFERENCES "socios"("idSocio")
);



DROP TABLE IF EXISTS "periodos";
CREATE TABLE IF NOT EXISTS "periodos" (
	"idPeriodoInscripcion"	INTEGER NOT NULL,
	"nombre"	TEXT NOT NULL,
	"inicioInscrSocios"	DATE,
	"finInscrSocios" 	DATE,
	"finInscrNoSocios"	DATE,
	PRIMARY KEY("idPeriodoInscripcion" AUTOINCREMENT)
);




DROP TABLE IF EXISTS "actividades";
CREATE TABLE IF NOT EXISTS "actividades" (
	"idActividad"	INTEGER NOT NULL,
	"nombre"	TEXT NOT NULL,
	"tipo"	TEXT NOT NULL,
	"precioSocio"	NUMERIC NOT NULL,
	"precioNoSocio"	NUMERIC NOT NULL,
	"fechaInicio"	TEXT NOT NULL,
	"fechaFin"	TEXT NOT NULL,
	"idPeriodoInscripcion"	INTEGER NOT NULL,
	"estado"	TEXT NOT NULL,
	"plazas"	INTEGER,
	"idInstalacion"	INTEGER,
	PRIMARY KEY("idActividad" AUTOINCREMENT),
	FOREIGN KEY("idInstalacion") REFERENCES "instalaciones"("idInstalacion"),
	FOREIGN KEY("idPeriodoInscripcion") REFERENCES "periodos"("idPeriodoInscripcion")
);



DROP TABLE IF EXISTS "horarioActividad";
CREATE TABLE IF NOT EXISTS "horarioActividad" (
	"idHorario"	INTEGER NOT NULL,
	"idActividad"	INTEGER NOT NULL,
	"idHorarios"	INTEGER NOT NULL,
	PRIMARY KEY("idHorario" AUTOINCREMENT),
	FOREIGN KEY("idActividad") REFERENCES "actividades"("idActividad"),
	FOREIGN KEY("idHorarios") REFERENCES "horarios"("idHorarios")
);


DROP TABLE IF EXISTS "horarios";
CREATE TABLE IF NOT EXISTS "horarios" (
	"idHorarios"	INTEGER NOT NULL,
	"dia"	TEXT NOT NULL,
	"horaInicio"	INTEGER NOT NULL,
	"horaFin" INTEGER NOT NULL,
	PRIMARY KEY("idHorarios" AUTOINCREMENT)
	
);



DROP TABLE IF EXISTS "listaEsperaSocios";
CREATE TABLE IF NOT EXISTS "listaEsperaSocios" (
	"idActividad"	INTEGER NOT NULL,
	"idSocio"	INTEGER NOT NULL,
	"posicion"	INTEGER NOT NULL,
	FOREIGN KEY("idActividad") REFERENCES "actividades"("idActividad"),
	FOREIGN KEY("idSocio") REFERENCES "socios"("idSocio")
);





DROP TABLE IF EXISTS "listaEsperaNoSocios";
CREATE TABLE IF NOT EXISTS "listaEsperaNoSocios" (
	"idActividad"	INTEGER NOT NULL,
	"idNoSocio"	INTEGER NOT NULL,
	"posicion"	INTEGER NOT NULL,
	FOREIGN KEY("idNoSocio") REFERENCES "noSocios"("idNoSocio"),
	FOREIGN KEY("idActividad") REFERENCES "actividades"("idActividad")
);
COMMIT;
