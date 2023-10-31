
# Especificación de requisitos funcionales

Especificación de requisistos funcionales de la práctica final del programa de formación de becarios.

Erik Yuste

## 1 Gestión de empleados

- 1.1 Consulta de empleados (página)
    - 1.1.1 No se verán los empleados dados de baja (F_BAJA is null)
    - 1.1.2 Se verán los campos:
        - NIF
        - Nombre
        - Primer apellido
        - Segundo apellido
        - Fecha de nacimiento
        - Primer teléfono de contacto
        - Email
        - Estado civil:
            - Soltero (S en la BBDD)
            - Casado (C en la BBDD)
        - Servicio Militar:
            - Si (S en la BBDD)
            - No (N en la BBDD)
    - 1.1.3 Tendrá un botón para ir a la pantalla de alta de empleado (RF-1.2)


- 1.2 Alta de empleados (página)
    - 1.2.1 Consiste en un formulario que permite insertar un nuevo empleado con los campos:
        - NIF
        - Nombre
        - Primer apellido
        - Segundo apellido
        - Fecha de nacimiento
        - Fecha de alta
        - Primer teléfono de contacto
        - Segundo teléfono de contacto
        - Email
        - Estado civil.  Lista desplegable con los valores:
            - Soltero (S en la BBDD)
            - Casado (C en la BBDD)
        - Servicio Militar. Lista desplegable con los valores:
            - Si (S en la BBDD)
            - No (N en la BBDD)

    - 1.2.2 Tendrá un botón Aceptar y al pulsarlo, se validará que se haya introducido un valor para todos los campos
        - 1.2.2.1 Si falta al menos un campo por ingresar:
            - Se muestra el mensaje: ‘Es obligatorio introducir todos los datos para dar de alta un nuevo empleado’
            - No se graba el registro en BBDD.
        - 1.2.2.2 Si están todos:
            - Se graba el registro en BBDD
            - Se vuelve a la pantalla de consulta (RF-1.1) (para que aparezca el nuevo registro).
        - 1.2.2.3 En la base de datos, el campo ID_EMPLEADO es autoincremental

    - 1.2.3 Tendrá un botón Cancelar:
        - No se graba el registro en BBDD
        - Se vuelve a la pantalla anterior

- 1.3 Baja de empleados. En la página de consulta (RF-1.1)
    - 1.3.1 Cada registro de empleado tiene un botón con un aspa (X), al pulsarlo:

        - 1.3.1.1 Validar si el empleado está asignado a uno o varios proyectos de la compañía:
            - Si lo está, no se puede dar de baja. Se informa con el mensaje:
                - ‘No se puede dar de baja al empleado NOMBRE Y APELLIDOS DEL EMPLEADO porque está asignado a el/los proyecto/s DESCRIPCIÓN DE LOS PROYECTOS (CONCATENADOS POR COMA SI SON VARIOS)’
        - 1.3.1.2 Si no está asignado a ningún proyecto:
            - Actualizar la fecha de baja (F_BAJA en BBDD) del empleado con la fecha del sistema
            - Refrescar el formulario (para que ya no aparezca)


## 2 Gestión de proyectos

- 2.1 Consulta de proyectos (página)
    - 2.1.1 En el formulario de consulta se muestran los campos:
        - De la tabla proyectos (PR_PROYECTOS) en modo multiregistro
        - Los que no estén dados de baja (F_BAJA is null).
            - Descripción
            - Fecha de inicio
            - Fecha de finalización
            - Lugar
    - 2.1.2 Tendrá un botón para ir a la página de Alta de proyecto (RF-2.2)


- 2.2 Alta de proyectos (página)
    - 2.2.1 Consiste en un formulario mono registro, para insertar un nuevo proyecto con los campos:
        - Descripción
        - Fecha de inicio
        - Fecha de finalización
        - Lugar
        - Observaciones

    - 2.2.2 Tendrá un botón Aceptar
        - 2.2.2.1 Al pulsarlo se validará que se haya introducido un valor para todos los campos:
            - Se graba el registro en BBDD
            - Se vuelve a la pantalla de consulta (RF-2.1) (para que aparezca el nuevo registro)

        - 2.2.2.2 Si falta uno o varios campos por informar:
            - Se muestra el mensaje: ‘Es obligatorio introducir todos los datos para dar de alta un nuevo proyecto’
            - Y no se graba el registro en BBDD.

        - 2.2.2.3 En la base de datos, el campo ID_PROYECTO es autoincremental

    - 2.2.3 Tendrá un botón Cancelar
        - Al pulsarlo:
            - No se graba el registro en BBDD
            - Se vuelve a la pantalla anterior


- 2.3 Baja de proyecto. En la página de consulta (RF-2.1)
    - 2.3.1 Cada registro de proyecto tiene un botón con un aspa (X), al pulsarlo se validará que no tenga ningún empleado asignado:
        - 2.3.1.1 Si no lo tiene:
            - Actualizar la fecha de baja (F_BAJA) del proyecto con la fecha del sistema
            - Refrescar el formulario para que ya no aparezca
        - 2.3.1.2 Si tiene alguno:
            - No se dará de baja el proyecto
            - Se informará al usuario con el mensaje:
                - ‘No se puede dar de baja el proyecto DESCRIPCIÓN DEL PROYECTO porque tiene asignado al menos un recurso’

- 2.4 Asignar empleados a proyectos. En la página de consulta (RF-2.1) hay un botón Asignar Empleados. Al pulsarlo se accede a la ventana:
    - 2.4.1 Contiene:
        - 2.4.1.1 Lista desplegable con la descripción de los proyectos que no estén dados de baja.
        - 2.4.1.2 Bloque multiregistro con nombre y apellidos de empleados que no estén dados de baja.

    - 2.4.2 Al seleccionar un proyecto de la lista:
        - 2.4.2.1 Aparecen los empleados no dados de baja.
        - 2.4.2.2 Los empleados que estén asociados al proyecto seleccionado (existe un registro empleado/proyecto) tendrán un check.
        - 2.4.2.3 Al deschequear el registro, se elimina el registro empleado/proyecto de la BBDD.
        - 2.4.2.4 Al chequear el registro, se inserta en la BBDD el regstro empleado/proyecto con la fecha de alta.
    
    - 2.4.3 Al seleccionar otro proyecto, se refresca el bloque de empleados con la información asociada a este.

## 3 Análisis de datos
- Se deberán leer las tablas de Empleados y Proyectos en dos dataframes con la librería Pandas. 
- A continuación se deberán mostrar los siguientes indicadores mediante la representación gráfica que mejor describan la información:

- 3.1 Empleados
    - 3.1.1 Top 5 empleados que más años llevan en la compañía
    - 3.1.2 Top 5 empleados más recientes
    - 3.1.3 Distribución del número de años de los empleados en la empresa
    - 3.1.4 Evolución temporal de altas por años
    - 3.1.5 Evolución temporal de bajas por años (se puede combinar con la anterior si se desea)
    - 3.1.6 ¿Cuáles han sido los dos años de mayor crecimiento/decrecimiento de empleados?
    - 3.1.7 Distribución de empleados solteros vs casados
    - 3.1.8 Distribución de la edad de los empleados
    - 3.1.9 Edad media y desviación típica de los empleados

- 3.2 Proyectos
    - 3.2.1 Número de proyectos activos, finalizados y total
    - 3.2.2 Distribución de la duración de los proyectos (histograma)
    - 3.2.3 Distribución de proyectos por lugar
    - 3.2.4 Proyectos y Empleados
    - 3.2.5 Distribución del número de proyectos a los que están asignados los empleados en activo. 
        - Ejemplo: 
            - Personas asignadas a 1 proyecto: 54 
            - Personas asignadas a 2 proyectos: 12
            - Personas asignadas a 3 proyectos: 2
    - 3.2.6 Top 5 proyectos con más personas asignadas
    - 3.2.7 Lista de proyectos sin personas asignadas (detección de anomalía) 
