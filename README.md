# horaEnIngles

Este proyecto consiste en una página web sencilla que permite subir un archivo .txt especificando las horas que el usuario desea traducir a inglés las cuales deben estar en el siguiente formato: ubicando las horas en las lineas impares y los minutos en las lineas pares:

    5
    47
    10
    30
## Frontend

El frontend está desarrollado en Angular 15. Para ponerlo en marcha de forma local se debe garantizar que en el archivo environment.ts la variable baseUrl coincida con el host en donde se levantó el servidor backend, posteriormente acceder a la terminal y ubicarse en el directorio HoraEnInglesFront y ejecutar el comando ng serve a continuación se levantará el servidor local en el puerto 4200 al cual podrás acceder desde el navegador accediendo a la url localhost:4200
![image](https://github.com/user-attachments/assets/cd0064e4-ade3-40ec-a118-951ff54e2cca)
![image](https://github.com/user-attachments/assets/96daa260-071c-44d5-8ab9-9a89b90e90b3)

## Backend 

El backend está desarrollado con Java 17 usando SpringBoot. Para ponerlo en marcha de forma local se recomienda abrir la carpeta HoraEnInglesBack con un IDE como IntelliJ y posteriormente correr la clase HoraEnInglesApplication.java el servidor local se levantará en el puerto 8080 y una vez levantado se puede utilizar la página web

![image](https://github.com/user-attachments/assets/36d803da-bdd3-4517-ae12-97e558caf805)


## Pruebas

En la carpeta DataPruebas encontrarás varios archivos .txt para realizar las pruebas de la herramienta

https://github.com/user-attachments/assets/cce28ab5-62d4-42d5-b698-ad6e62c683a4

