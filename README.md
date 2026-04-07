# Agenda de contactos

---

## Resumen

Esta es una interfaz grafica desarrollada en JavaFX sobre una agenda de contactos la cual se conecta a una api .

---

## Instalación 

### Requisitos:
- Java 17 o superior 

### Compilacion o Instalacion 

 ```
 ./mvnw clean install
 ```

### Ejecucion del proyecto:

#### Windows
```
mvnw.cmd javafx:run
```
#### Linux / Mac
```
./mvnw javafx:run
```

---
## [API](https://github.com/GabrielPerezLago/Agenda.git)

Esta es la api que a la que se conecta la app, esta se encargara de guardar tus contactos en dos bases de datos. Una MySql y otra en MongoD.

---

## Uso 

La app al ser ejecutada te mostrara un menu de inicio , al pulsar en iniciar la app te pedira una base de datos a la que desees conectarte , entonces es esta te enviara a la vista principal la cual tiene varias pestañas las cuales son:

- ### Home
    - Aqui veras las instrucciones de la app las cuales seran similares a esta.
- ### Lista
    - Aqui podras ver la **Lista** de los contactos que tienes en esa base de datos.
- ### Crear 
  - Aqui podras **Añadir** contactos a la base de datos que hayas elegido.
- ### Eliminar
    - Aqui puedes **Eliminar** los contactos que tengas en esa base de datos empleando su nombre o numero de telefono.
- ### Buscar
  - Aqui puedes **Buscar** en tiempo real los contactos que tengas en esa base de datos.

---

### Autor : &copy; GabrielPerezLago