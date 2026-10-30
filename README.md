# Contador de caracteres con procesos (PSP · RA1 · Actividad 02)

Actividad 02 del módulo **DAM.0490 Programación de Servicios y Procesos**.

## Descripción

- **`ContadorCaracteres` (proceso hijo):** recibe una palabra como parámetro y
  escribe por la salida estándar el número de caracteres que tiene. Si no recibe
  exactamente un parámetro, escribe un mensaje de uso por la salida de error y
  termina con código 1.
- **`LanzadorContador` (proceso padre):** pide palabras por teclado hasta que se
  escribe `fin`. Para cada palabra lanza al hijo con `ProcessBuilder`, lee su
  resultado, espera con `waitFor()` y muestra el mensaje por consola. Si el hijo
  termina con un código distinto de 0, muestra un error con ese código.

## Códigos de salida del proceso hijo

| Código | Significado                               |
|--------|-------------------------------------------|
| 0      | Recuento correcto                         |
| 1      | No se recibió exactamente un parámetro    |

## Cómo ejecutarlo

1. Abrir el proyecto en IntelliJ IDEA (JDK 17 o superior).
2. Ejecutar `contador.LanzadorContador` y escribir palabras en la consola.
3. Escribir `fin` para terminar.

## Pruebas realizadas

| Palabra        | Resultado esperado | Resultado obtenido |
|----------------|--------------------|--------------------|
| `hola`         | 4                  | 4                  |
| `murcielago`   | 10                 | 10                 |
| `a`            | 1                  | 1                  |
| `programacion` | 12                 | 12                 |

## Autor

Álvaro Richelle