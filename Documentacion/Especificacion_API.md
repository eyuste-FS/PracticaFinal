
# Especificación de la API

Interfaz para acceso al backend de la aplicación.

Erik Yuste

## GET

- empleado/
    - Con paginación (?page=N)
    - Ordenado (?sort=atributo)
        - Ver PUT
    - Exclusivamente aquellos sin fecha de baja

- proyecto/
    - Con paginación (?page=N)
    - Ordenado (?sort=atributo)
        - Ver PUT
    - Exclusivamente aquellos sin fecha de baja

- proyecto/[proyecto_id]/empleado/
    - Lista de empleados.
    - Incluye una columna booleana "Asignado" si el empleado está asignado al proyecto


## POST

- proyecto/[proyecto_id]/empleado/[empleado_id]
    - Asigna un empleado a un proyecto


## PUT

- empleado/
    - Crea un nuevo empleado (y le da de alta con la fecha del sistema)
    - Cuerpo (todos strings):
        - nif
        - nombre
        - primer_apellido
        - segundo_apellido
        - fecha_nacimiento
        - fecha_alta
        - telefono_1
        - telefono_2
        - email
        - estado_civil [Soltero/Casado]
        - servicio_militar [Si/No]

- proyecto/
    - Crea un nuevo proyecto (y le da de alta con la fecha del sistema)
    - Cuerpo (todos strings):
        - descripcion
        - fecha_inicio
        - fecha_final
        - lugar
        - observaciones


## DELETE

- empleado/[empleado_id]
    - Da de baja un empleado

- proyecto/[proyecto_id]
    - Da de baja un proyecto (verificando antes las condiciones)

- proyecto/[proyecto_id]/empleado/[empleado_id]
    - Da de baja un empleado de un proyecto
