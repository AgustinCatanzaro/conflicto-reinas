# conflicto-reinas

Dado un tablero ajedrez NxN y Reinas ubicadas en algunas casillas, determinar si hay conjuntos de reinas que compartan ya sea fila, columna o diagonal.

---

DESCRIPCION DEL PROBLEMA

---

El problema de las reinas de ajedrez consiste encontrar una distribución de N reinas sobre un tablero de ajedrez de NxN escaques o casillas, de manera tal que éstas no se ataquen entre sí. De esta forma, como las reinas no deben atacarse, no puede encontrarse más de una en la misma fila, columna o diagonal. Este es un problema muy antiguo, ya que fue propuesto para N=8 (tamaño de un tablero de ajedrez) en el año 1848, y aún hoy sigue siendo un problema muy interesante de estudio e investigación.

Para indicar la posición de una reina sobre el tablero simplemente se da un par de números, indicando la fila y la columna donde se encuentra.

---

SE PIDE

---

A partir de un conjunto de reinas ya ubicadas sobre el tablero de tamaño determinado, nos interesa saber en cuantos conflictos interviene cada reina y cuáles son esos conflictos.

Tenga en cuenta que si tres reinas A, B y C están alineadas y en ese orden, entonces sólo hay dos conflictos: (A,B) y (B,C). A y C no constituyen un conflicto porque las reinas no saltan por arriba de otra pieza

---

DATOS DE ENTRADA

---

Se recibe un archivo conflictos.in con el siguiente formato:

-Una línea con dos números N y M ( 1 ≤ N ≤ 10.000, 1 ≤ M ≤ 50.000), que indican las dimensiones del tablero y la cantidad de reinas ubicadas sobre el exittablero. No pueden existir dos reinas sobre una misma casilla.

M líneas con dos números F y C , cada uno indicando la fila y la columna en que se encuentra la reina ( 1 ≤ F, C ≤ N ).

---

DATOS DE SALIDA

---

generar un archivo conteniendo M líneas, una por cada reina respetando el orden de entrada, las cuales a su vez contienen: un numero K ( 0 ≤ K ≤ M ), que indica en cuantos conflictos participa esa reina, seguido de K números, ordenados de menor a mayor, que indicaran los números de reinas con los que existe conflicto. El número de cada reina se determina de acuerdo al orden de aparición correspondiente en el archivo de entrada, empezando la numeración en 1.

---

EJEMPLO

---

para el input:

8 10<br />
2 1<br />
8 2<br />
1 3<br />
3 4<br />
6 5<br />
4 6<br />
7 7<br />
5 8<br />
3 5<br />
3 6<br />

el output esperado es:

1 5<br />
1 6<br />
1 9<br />
1 9<br />
2 1 9<br />
3 2 9 10<br />
0<br />
1 10<br />
5 3 4 5 6 10<br />
3 6 8 9<br />
