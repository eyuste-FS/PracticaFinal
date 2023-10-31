
USE PRACTICA;

insert into PRACTICA.EM_EMPLEADOS values
	(NULL, "nif", "nombre", "apellido1", "apellido2", "2000-01-01", "tele1", "tele2", "email", "2020-10-20", NULL, 'C', 'N'),
	(NULL, "nif2", "nombre2", "apellido12", "apellido22", "2000-01-02", "tele12", "tele22", "email2", "2020-10-22", NULL, 'C', 'N');

insert into PRACTICA.PR_PROYECTOS values
	(NULL, "descripcion", "2021-02-15", NULL, NULL, "lugar", "observaciones"),
	(NULL, "descripcion2", "2021-02-16", NULL, NULL, "lugar2", "observaciones2"),
	(NULL, "descripcion3", "2021-02-17", NULL, NULL, "lugar3", "observaciones3");

insert into PRACTICA.PR_EMPLEADOS_PROYECTO values
	(1, 1, "2022-10-01"),
    (1, 2, "2022-10-02"),
    (2, 2, "2022-10-04"),
    (2, 3, "2022-10-04");

insert into PRACTICA.PR_EMPLEADOS_PROYECTO values
	(2, 2, NULL);  # DEBE FALLAR por colision de PK


select * from PRACTICA.EM_EMPLEADOS;
select * from PRACTICA.PR_PROYECTOS;
select * from PRACTICA.PR_EMPLEADOS_PROYECTO;

