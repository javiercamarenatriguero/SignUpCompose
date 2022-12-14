# Sign Up Compose App
 
Aplicación Android de registro de personas mediante formulario realizada 100% en Jetpack Compose.
Dicha aplicación se ha realizado en el contexto del curso Compose Expert y como participación en el Hackathlon de Diciembre 2021. 
## Características
Sign Up Compose App incluye las siguientes características:

* Arquitectura de vistas MVI 
* Campos de texto para diferentes tipos de datos
  * Nombre y apellidos (campos de textos sencillos)
  * Número de teléfono con prefijo seleccionable (máscara de 9 dígitos)
  * Fecha de nacimiento (formato dd/MM/yyyy)
  * Correo electrónico (formato email)
  * Password (entre 8 y 15 caracteres)
  
* Validación de campos una vez pulsado el botón de Sign Up
* Navegación entre elementos con teclado
* Completado de formulario mediante teclado en campo de Password
* Icono de borrado de texto dentro de los campos de texto
* Icono de visión de password
* Modal Sheet Bottom para la selección de prefijo de teléfono
* Diálogo de formulario completo
 
### Screenshots

![Formulario](https://bitbucket.org/javi_hetfield/signupcompose/raw/master/screenshots/initial_layout.png)
![Gestión Errores](https://bitbucket.org/javi_hetfield/signupcompose/raw/master/screenshots/error_layout.png)
![Modal Bottom](https://bitbucket.org/javi_hetfield/signupcompose/raw/master/screenshots/modal_layout.png)
![Diálogo de finalización](https://bitbucket.org/javi_hetfield/signupcompose/raw/master/screenshots/success_layout.png)


### Librerías externas
 
* [Accompanist](https://github.com/google/accompanist): Librería complementaria para Jetpack Compose
 
### Requirements
* Min. Android SDK: 21
* Target Android SDK: 31
 
### Version
* 1.0
 
### Herramientas de desarrollo

* Android Studio
* Bitbucket Repository

### Test
* Test unitarios para validación
* Emulator (Android SDK 31)
* Xiaomi Note 5 (Android SDK 27)

### TODOs y Mejoras

* Gestión del Scroll al seleccionar cada TextField
* Gestión de Patterns para los teléfonos en función del país seleccionado
* Mejora en el campo de fecha
 
### Development
 
* Author: Javier Camarena
* Contact: javier.camtri@gmail.com