# Conversor de Monedas

Este es un proyecto de conversor de monedas desarrollado como parte del curso en Alura Latam. El programa permite convertir entre diferentes monedas utilizando datos de una API de tipo cambio.

## Características

- Conversión entre múltiples monedas.
- Validación de entradas de usuario.
- Manejo de excepciones para entradas no válidas.
- Formateo de salida para una presentación clara de los resultados.

## Tecnologías Utilizadas

- Java 11+
- Biblioteca GSON para manejo de JSON
- API de Exchangerate

## Requisitos Previos

Para ejecutar este proyecto, necesitarás tener instalado:

- JDK 11 o superior
- Maven (para gestionar las dependencias)

## Instalación

1. **Clona el repositorio:**
    ```bash
    git clone https://github.com/tu-usuario/conversor-monedas.git
    cd conversor-monedas
    ```

2. **Configura Maven:**
    Asegúrate de tener Maven configurado en tu proyecto. Puedes crear un archivo `pom.xml` con las siguientes dependencias:
    ```xml
    <project xmlns="http://maven.apache.org/POM/4.0.0"
             xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
             xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://www.maven.apache.org/xsd/maven-4.0.0.xsd">
        <modelVersion>4.0.0</modelVersion>
        <groupId>com.example</groupId>
        <artifactId>conversor-monedas</artifactId>
        <version>1.0-SNAPSHOT</version>
        <dependencies>
            <dependency>
                <groupId>com.google.code.gson</groupId>
                <artifactId>gson</artifactId>
                <version>2.8.6</version>
            </dependency>
        </dependencies>
    </project>
    ```

3. **Compila el proyecto:**
    ```bash
    mvn clean install
    ```

## Uso

Para ejecutar el conversor de monedas, sigue estos pasos:

1. **Ejecuta el programa:**
    ```bash
    java -cp target/conversor-monedas-1.0-SNAPSHOT.jar Principal
    ```

2. **Sigue las instrucciones en pantalla:**
    Selecciona la moneda de origen y destino, e ingresa la cantidad a convertir. El programa realizará la conversión y mostrará el resultado.

## Contribuciones

¡Las contribuciones son bienvenidas! Si tienes alguna mejora o sugerencia, no dudes en crear un pull request.

## Licencia

Este proyecto se distribuye bajo la licencia MIT. Ver el archivo `LICENSE` para más detalles.
