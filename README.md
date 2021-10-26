# Vinilos
Este repositorio contiene el código relacionado desarrollado para una aplicación móvil que permite buscar albumes, artistas y coleccionistas.

## Tabla de contenido
1. [Información general](#general-info)
2. [Tecnología](#tecnologies)
3. [Arquitectura](#architecture)
4. [Estrategía de desarrollo](#strategy)
5. [Flujo de trabajo](#flow)
6. [Metodología de proyecto](#methodology)
7. [Instalación del proyecto](#installation)

<a name="general-info"></a> 
### Información general
Este desarrollo móvil estará compuesto por varias historias de usuario épicas:
 - HU00 -01 - SplashScreen
 - HU00 -02 - Configuración inicial
 - HU00 -03 - Dashboard
 - HU01 - Consultar Catálogo de álbumes
 - HU02 - Consultar la información detallada de un álbum
 - HU03 - Consultar el listado de artistas
 - HU04 - Consultar la información detallada de un artista
 - HU05 - Consultar listado de coleccionistas
 - HU06 - Consultar la información detallada de coleccionista
 - HU07 - Crear un álbum
 - HU08 - Asociar tracks con un álbum

<a name="tecnologies"></a> 
### Tecnología
Para el desarrollo de está aplicación móvil se empleará el lenguaje de programación KOTLIN v1.5.31 y su IDE de desarrollo es nativo (Android Studio Arctic Fox | 2020.3.1 Patch 3)

<a name="architecture"></a> 
### Arquitectura
Como arquitectura de software para está aplicación se empleará MVVM con el fin de soportar escalabilidad y mantenimiento del software de forma sencilla, a continuación se mencionana algunas de las ventajas de utilizar esta arquitectura:
 * El código está desacoplado.
 * La estructura del paquete es aún más fácil de navegar.
 * El proyecto es aún más fácil de mantener.
 * Se pueden agregar nuevas funciones rápidamente.

***Nota:** Para mayor información puede visualizar la WIKI del proyecto*


<a name="strategy"></a> 
### Estrategía de desarrollo
Como estrategía de desarrollo emplearemos TDD (Test Driven Development) que consiste en escribir primero las pruebas (generalmente unitarias), después escribir el código fuente que pase la prueba satisfactoriamente y, por último, refactorizar el código escrito. A continuación se describen algunas ventajas de utilizar TDD:
 * Genera confianza gracias a tener pruebas que garantizan el correcto funcionamiento del código.
 * Mejora el diseño y la calidad del código
 * Evita escribir código que no se va a utilizar
 * Desarrollo más rápido y permite la optimización y evolución del código al transcurrir el tiempo.

***Nota:** Para mayor información puede visualizar la WIKI del proyecto*

<a name="flow"></a> 
### Flujo de trabajo
Como flujo de trabajo se empleara GITFLOW, el cual es ideal para proyectos que tienen un ciclo de publicación programado, con este flujo hace que el manejo del repositorio y sus ramas sea much más lógico reduciendo considerablemente los conflictos generados entre el código de los desarrolladores y al ser tanto podrían generar pérdidas de código o que terminen generando desperdicios de tiempo y reprocesos. Además es considerada una buena práctica empleada en metodologías ágiles en desarrollor de software.

***Nota:** Para mayor información puede visualizar la WIKI del proyecto*

<a name="methodology"></a> 
### Metodología del proyecto
Como metodología del proyecto sera utilizada SCRUM, es un conjunto de buenas prácticas que permite el trabajo de los equipos involucrados en proyectos TIC de manera colaborativa, con una fluida relación entre cliente y desarrolladores. A continuación se nombran algunos benificios de trabajar con está metodología ágil:
 * Optimización de los equipos de trabajo.
 * Mayor conocimiento por parte del cliente de cada etapa de trabajo del producto.
 * Fomento de la innovación.
 * Reducción del margen de error y riesgos.


<a name="#installation"></a> 
### Instalación del proyecto
A continuación se describen los pasos necesarios para instalar el proyecto y contribuir en su desarrollo:
 * Abrir el IDE Android Studio
 * Dar clic en File - New - Project from version Control
 * Iniciar sesión con GitHub con el correo autorizado para acceder a este repositorio.
 * Seleccionar el proyecto denominado "MISW-4203-MobileApps-MJMJ"
 * Dar clic en Clone
 * Esperar que compile correctamente todos los implementos, en caso de requerir actualizaciones el IDE las solicitará automáticamente.
 * Ya puedes iniciar a contribuir en el desarrollo de este proyecto


