--Datos para carga inicial de la base de datos

BEGIN TRANSACTION;
INSERT INTO "instalaciones" VALUES (1,'pista de pádel',10);
INSERT INTO "instalaciones" VALUES (2,'campo de futbito',12);
INSERT INTO "instalaciones" VALUES (3,'cancha de baloncesto',12);
INSERT INTO "instalaciones" VALUES (4,'salon de yoga',9);
INSERT INTO "instalaciones" VALUES (5,'cancha de balonmano',12);
INSERT INTO "instalaciones" VALUES (6,'piscina',20);




INSERT INTO "socios" VALUES (1,'71728103G','Javier','Santos','Menendez','si',60);
INSERT INTO "socios" VALUES (2,'85858585F','Pepe ','Del Arco ','Rosa','si',60);
INSERT INTO "socios" VALUES (3,'74747474T','Maria','Perez','Alarcon','no',55);
INSERT INTO "socios" VALUES (4,'00000000Y','Leonardo','Messi','Cuccittini','si',60);
INSERT INTO "socios" VALUES (5,'00000000A','Agapito','Sanchez','Rios','si',55);



INSERT INTO "noSocios" VALUES (1,'11111111R','Alejandro','Riera','Fernandez');


INSERT INTO "periodos" VALUES (1,'Periodo1','2021-04-28','2021-06-02','2021-06-10');
INSERT INTO "periodos" VALUES (2,'Periodo2','2021-04-29','2021-06-03','2021-06-29');
INSERT INTO "periodos" VALUES (3,'Periodo3','2021-04-27','2021-06-04','2021-07-29');


INSERT INTO "actividades" VALUES (1,'Tenis','Tenis',20,25, '2021-04-02' ,'2021-04-02', 23 ,24,1,1,25,1);
INSERT INTO "actividades" VALUES (2,'Natación','Natación',12,16,'2021-04-02','2021-04-02' , 23 ,24,2,1,0,6);
INSERT INTO "actividades" VALUES (3,'Futbol','Futbol',12,16,'2021-04-02','2021-04-02',23,24,3,1,1,6);
INSERT INTO "actividades" VALUES (4,'Esgrima','Natación',12,16,'2021-04-02','2021-04-02' , 23 ,24,2,1,0,6);


INSERT INTO "horarioActividad" VALUES (1,1,'L',10.0,12.0);
INSERT INTO "horarioActividad" VALUES (2,2,'L',10.0,12.0);
INSERT INTO "horarioActividad" VALUES (3,2,'X',9.0,11.0);
INSERT INTO "horarioActividad" VALUES (4,3,'V',16.0,18.0);



INSERT INTO "reservas" VALUES (1,'2022-03-23',10,11,1,NULL,1,0);
INSERT INTO "reservas" VALUES (2,'2022-03-26',10,11,2,1,NULL,0);
INSERT INTO "reservas" VALUES (3,'2022-03-25',9,10,1,1,1,0);
INSERT INTO "reservas" VALUES (4,'2022-03-25',10,11,2,2,2,1);
INSERT INTO "reservas" VALUES (5,'2022-03-25',12,13,2,1,2,1);
INSERT INTO "reservas" VALUES (6,'2022-03-23',9,10,1,2,1,0);



INSERT INTO inscripciones (idActividad,idSocio) VALUES (1,1);
INSERT INTO inscripciones (idActividad,idSocio) VALUES (1,2);
INSERT INTO inscripciones (idActividad,idSocio) VALUES (1,3);
INSERT INTO inscripciones (idActividad,idSocio) VALUES (1,4);
INSERT INTO inscripciones (idActividad,idSocio) VALUES (2,1);
INSERT INTO inscripciones (idActividad,idSocio) VALUES (2,3);
INSERT INTO inscripciones (idActividad,idSocio) VALUES (3,2);
INSERT INTO inscripciones (idActividad,idSocio) VALUES (3,1);
INSERT INTO inscripciones (idActividad,idNoSocio) VALUES (3,1);




INSERT INTO "pagos" ("idPago","importe","fecha","estado","idSocio","idNoSocio","idActividad","idReserva") VALUES (1,15,'2021-03-01',1,1,NULL,1,1),
 (2,10,'2021-03-01',0,2,NULL,2,2),
 (3,5,'2021-03-01',1,1,NULL,1,3),
 (4,12,'2021-03-01',1,1,NULL,2,4);
COMMIT;
