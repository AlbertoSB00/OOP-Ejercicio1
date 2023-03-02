# OOP-Ejercicio1
Desarrollar un programa en Java que gestiona la información de una entidad docente imparte actividades formativas tanto a los socios registrados como a personas que no son ocios y se inscriben en las actividades de formación.           
1. El objeto ActividadFormación consiste en:            
a) Propiedades: código, título, descripción, n.º de horas presenciales (máximo 200), .º horas online (máximo 100), n.º horas no presenciales, fecha inicio, fecha fin, ivel (A,B,C), precio, horario).            
b) Métodos:              
• Constructor: Parámetros con el código, el título, la descripción y los tres tipos e horas formativas.            
• Constructor: Parámetros con el código, la descripción, los tres tipos de horas ormativas, fechas de inicio, fin, nivel.          
• Establecer el valor de sus propiedades.           
• Obtener el valor de alguna propiedad.             
• Copia de objetos          
• Representación del objeto en cadena de caracteres.            
2. El objeto Socio consiste en:             
a) Propiedades: login, clave, nombre, apellidos, teléfono, email, fecha alta, isponibilidad (mañana, tarde), actividadFormacion           
b) Métodos:          
• Constructor: Parámetros con valor inicial de todas sus propiedades excepto irección.           
• Establecer el valor de sus propiedades           
• Calcular la antigüedad.      
• Obtener el valor de sus propiedades.       
• Copia de objetos.       
• Representación del objeto en cadena de caracteres.      
3. El objeto Inscrito consiste en:       
a) Propiedades: número, nombre, apellidos, email, fecha inscripción, ctividadFormacion.         
b) Métodos:       
• Constructor: Parámetros con valor inicial de sus propiedades excepto irección.        
• Establecer el valor de sus propiedades.          
• Obtener el valor de sus propiedades.       
• Copia de objetos.          
• Representación del objeto en cadena de caracteres.         
4. La interfaz DatosFormacion se implementa en los objetos Socio e Inscrito. Consisteen:       
a) Método obtenerPrecio(). Calcula y devuelve el precio de la actividad de formación.         
Para socios es:        
• Si tiene menos de 3 años de antigüedad: 20€ por hora (presencial y online).       
• Más de 3 años y menos de 6: 10€ por hora (presencial y online).      
• Si tiene más de 6 años 5€ por hora presencial. Resto de horas gratis.         
Para inscritos:      
• 50 € por hora presencial y 30 € por hora online.      
b) Método asignarHorario(). Devuelve una cadena de caracteres con el horario de la ctividad de formación. Para socios es:          
• Horas presenciales: Si están entre 100 y 200: De lunes a viernes 9:00 a 13:00 i tiene disponibilidad de mañana. De lunes a viernes 16:00 a 20:00 si tiene isponibilidad de tarde. Si son inferiores a 100, de 9:00 a 11:00 y de 16:00 a 8:00 según disponibilidad.      
• Horas online: Si están entre 50 y 100: sábados y domingos de 9:00 a 12:00. Si on inferiores a 50 sábados de 8:00 a 10:00      
Para inscritos es:         
• Horas presenciales: De lunes a sábado 9:00 a 12:00 si el nivel es A o B. Si el ivel es C de 10:00 a 14:00 y de 16:00 a 20:00.       
• Horas online: Si el nivel es A: domingos de 9:00 a 12:00. Si el nivel es B o C omingos de 16:00 a 19:00.    
