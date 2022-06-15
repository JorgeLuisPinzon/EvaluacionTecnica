# EvaluacionTecnica
Evaluacion Tecnica Intercam
#Especificaciones de proyecto
Aplicación con spring boot 
a)      Publicará servicios REST para hacer el CRUD, (Create, Read, Update y Delete) de la siguientes tablas(imagen al final); el Read deberá poderse consultar todos los registros o uno en específico por el ID.
b)      La tabla deberá estar en base de datos H2
c)   El acceso a la base de datos deberá ser mediante JPA y spring orm
d) Validaciones:
    1.-Formato de fechaNacimiento “dd/mm/yyyy”
    2.-Campo Ingresos debe de ser sólo flotantes mayores a 0
    3.-Campo numeroCuenta debe ser 10 digitos
    4.-Campo codigoPostal debe ser 6 caracteres
d) Especificaciones Complementarias:
        1.-Un usuario puede tener una cuenta
        2.-Un usuario puede tener una dirección
        3.-Id se maneja con números consecutivos
