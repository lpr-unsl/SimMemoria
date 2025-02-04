## Para ejecutar el simulador usando netOSLab corra el siguiente comando
```
cd /root/Documents/SimMemoria
jexec dist/MemApplication.jar
```
## Proyecto para el curso Sistemas Operativos de la Escuela de Ingenieria Sistemas de la Universidad Metropolitana de Caracas

![Java](https://usemoslinux.net/wp-content/uploads/2016/01/Java-Netbeans.png)

![Java2](https://club28blog.files.wordpress.com/2018/01/imagen2.png)

## Enunciado del Proyecto

Usted ha sido contratado para, haciendo uso de Java, llevar a cabo una simulación de la memoria de un sistema, en donde se hace uso de paginación y memoria virtual. El cliente pide que sea capaz de indicar en cuantos marcos de páginas está dividida la memoria principal al empezar la ejecución del programa. Una vez iniciado el programa, se debe poder:	

 -	Crear procesos, de números de páginas variables, ubicando sus páginas en memoria, tanto principal como virtual.
 -	Decidir qué proceso pasa a ejecución. Para simplicidad del proyecto asuma que:
 •	Cuando un proceso entra en ejecución, logra ejecutar toda una página antes de ser interrumpido.
 •	Un proceso, a menos que se indique lo contrario, ejecuta sus páginas en orden secuencial
 •	El sistema siempre dispondrá de espacio por medio de la memoria virtual
 •	Cuando un proceso ejecuta su última página, finaliza y se vacían todos los marcos de página ocupados por sus páginas
 -	Establecer el orden de ejecución del proceso, en cuanto al número de página, en caso de que este no sea secuencial (Ej. Pág. 1, Pág.2, Pág. 1, Pág. 3). En caso contrario, si no se introduce algún dato, el programa asumirá que el orden es secuencial. Esto debe ocurrir  al momento de la creación del proceso

 Para verificar el buen funcionamiento de la simulación se debe poder conocer en todo momento, por medio de una interfaz gráfica:
 -	Las páginas que ocupan los marcos de la memoria principal, indicando número de proceso y de página.
 -	Listado de todos los procesos, con número de páginas totales, páginas en memoria principal y en virtual, y su estado.
 -	Qué procesos tienen páginas en memoria virtual, y cuales son.
 -	Cuando ocurre un cambio de páginas de memoria principal a virtual y viceversa

 Es importante mencionar que el cliente no informó como desea que se planifique el decidir que páginas son sacadas de memoria principal,  en caso de ser necesario para incluir un nuevo proceso, por lo que deberá investigar cual sería una forma óptima de aplicarlo. Aquel  proyecto que logre realizar con el menor número de movimientos de páginas entre memoria principal y virtual obtendrá un bono de 2 puntos sobre la nota del proyecto

Aspectos importantes para la entrega:
 -	Se debe de poder compilar el proyecto entregado
 -	Debe hacer uso de interfaz gráfica para cualquier entrada solicitada y para mostrar la información requerida
 
 # Implementacion en java
![Java2](https://club28blog.files.wordpress.com/2018/01/imagen2.png)
