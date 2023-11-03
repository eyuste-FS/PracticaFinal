
# Especificación de la API

Interfaz para acceso al backend de la aplicación.

Erik Yuste

## GET

- empleado/
    - Con paginación (?page=N)
    - Exclusivamente aquellos sin fecha de baja

- proyecto/
    - Con paginación (?page=N)
    - Exclusivamente aquellos sin fecha de baja

- proyecto/[proyecto_id]/empleado/
    - Lista de empleados.
    - Incluye una columna booleana "Asignado" si el empleado está asignado al proyecto
    - Retorna una lista de elementos con los atributos:
        - idProyecto
        - fAlta
        - empleado
            - idEmpleado
            - txNif
            - txNombre
            - txApellido1
            - txApellido2
            - txEmail
            - cxEdocivil
            - fbaja
            - fnacimiento
            - falta
            - ntelefono2
            - ntelefono1
            - bservmilitar


## POST

- proyecto/[proyecto_id]/empleado/
    - Actualiza los empleados asignados a un proyecto
    - En el cuerpo (solo se pasan los modificados):
        - empleadosBaja: lista de identificadores de empleado
        - empleadosAlta: lista de identificadores de empleado


## PUT

- empleado/
    - Crea un nuevo empleado (y le da de alta con la fecha del sistema)
    - Cuerpo (todos obligatorios y de tipo string):
        - nif
        - nombre
        - primerApellido
        - segundoApellido
        - fechaNacimiento
        - fechaAlta
        - telefono1
        - telefono2
        - email
        - estadoCivil [Soltero/Casado]
        - servicioMilitar [Si/No]

- proyecto/
    - Crea un nuevo proyecto (y le da de alta con la fecha del sistema)
    - Cuerpo (todos de tipo string):
        - descripcion
        - fecha_inicio
        - fecha_final (opcional)
        - lugar
        - observaciones


## DELETE

- empleado/[empleado_id]
    - Da de baja un empleado

- proyecto/[proyecto_id]
    - Da de baja un proyecto (verificando antes las condiciones)

- proyecto/[proyecto_id]/empleado/[empleado_id]
    - Da de baja un empleado de un proyecto
