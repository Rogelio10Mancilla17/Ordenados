/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metodos;

import javax.swing.JOptionPane;

/**
 *
 * @author Christian
 */
public class metodosExternos {

    public int[] LLenar() {
        int v[] = null;
        try {

            String var = JOptionPane.showInputDialog("Ingresa el tamaño del vector");
            int tamaño = Integer.parseInt(var);
            v = new int[tamaño];
            for (int i = 0; i < v.length; i++) {

                v[i] = Integer.parseInt(JOptionPane.showInputDialog("Posicion: " + i));

            }
        } catch (Exception e) {
            System.out.println(e + " Hay un error de usuario ");
        }

        return v;

    }

    public void Imprimir(int[] v) {
        String acarreo = "";
        for (int i = 0; i < v.length; i++) {
            if (i == v.length - 1) {
                acarreo += v[i] + "";
            } else {
                acarreo += v[i] + ",";

            }

        }
        JOptionPane.showMessageDialog(null, acarreo);

    }

    private void merge(int[] fuente1, int[] fuente2, int[] dest) {
// indices de los 3 array
        int srcIndex1 = 0;
        int srcIndex2 = 0;
        int destIndex = 0;

// merge hasta que uno de los arrays fuentes este vacio
        while (srcIndex1 < fuente1.length && srcIndex2 < fuente2.length) {
            if (fuente1[srcIndex1] < fuente2[srcIndex2]) {
                dest[destIndex] = fuente1[srcIndex1];
                srcIndex1++;
            } else {
                dest[destIndex] = fuente2[srcIndex2];
                srcIndex2++;
            }
            destIndex++;
        }

        if (srcIndex1 < fuente1.length) {
            System.arraycopy(fuente1, srcIndex1, dest, destIndex,
                    fuente1.length - srcIndex1);
        } else {
            System.arraycopy(fuente2, srcIndex2, dest, destIndex,
                    fuente2.length - srcIndex2);
        }
    } // fin de merge();

    public int sortMov(int arr[]) {
        int cont = 7;

        int[][] np = new int[arr.length][2];
        int[] q = new int[0x100];
        int i, j, k, l, f = 0;
        for (k = 0; k < 4; k++) {
            for (i = 0; i < (np.length - 1); i++) {
                np[i][1] = i + 1;
            }
            np[i][1] = -1;
            for (i = 0; i < q.length; i++) {
                q[i] = -1;
            }
            for (f = i = 0; i < arr.length; i++) {
                j = ((0xFF << (k << 3)) & arr[i]) >> (k << 3);
                if (q[j] == -1) {
                    l = q[j] = f;
                } else {
                    cont++;
                    l = q[j];
                    while (np[l][1] != -1) {
                        l = np[l][1];
                    }
                    np[l][1] = f;
                    l = np[l][1];
                }
                f = np[f][1];
                np[l][0] = arr[i];
                np[l][1] = -1;
            }
            for (l = q[i = j = 0]; i < 0x100; i++) {
                for (l = q[i]; l != -1; l = np[l][1]) {
                    arr[j++] = np[l][0];
                }
            }
        }
        return cont;

    }

    public int sortITe(int arr[]) {
        int cont = 8;

        int[][] np = new int[arr.length][2];
        int[] q = new int[0x100];
        int i, j, k, l, f = 0;
        for (k = 0; k < 4; k++) {
            for (i = 0; i < (np.length - 1); i++) {
                np[i][1] = i + 1;
            }
            np[i][1] = -1;
            for (i = 0; i < q.length; i++) {
                q[i] = -1;
            }
            for (f = i = 0; i < arr.length; i++) {
                j = ((0xFF << (k << 3)) & arr[i]) >> (k << 3);
                if (q[j] == -1) {
                    l = q[j] = f;
                } else {

                    l = q[j];
                    while (np[l][1] != -1) {
                        l = np[l][1];
                    }
                    np[l][1] = f;
                    l = np[l][1];
                }
                f = np[f][1];
                np[l][0] = arr[i];
                np[l][1] = -1;
            }
            for (l = q[i = j = 0]; i < 0x100; i++) {

                for (l = q[i]; l != -1; l = np[l][1]) {
                    arr[j++] = np[l][0];
                }
            }
        }
        return cont;

    }

    public int sortPasadas(int arr[]) {
        int cont = 4;

        int[][] np = new int[arr.length][2];
        int[] q = new int[0x100];
        int i, j, k, l, f = 0;
        for (k = 0; k < 4; k++) {
            for (i = 0; i < (np.length - 1); i++) {
                np[i][1] = i + 1;
            }
            np[i][1] = -1;
            for (i = 0; i < q.length; i++) {
                q[i] = -1;

            }
            for (f = i = 0; i < arr.length; i++) {
                j = ((0xFF << (k << 3)) & arr[i]) >> (k << 3);
                if (q[j] == -1) {
                    l = q[j] = f;
                } else {

                    l = q[j];
                    while (np[l][1] != -1) {
                        l = np[l][1];
                    }
                    np[l][1] = f;
                    l = np[l][1];
                }
                f = np[f][1];
                np[l][0] = arr[i];
                np[l][1] = -1;
            }
            for (l = q[i = j = 0]; i < 0x100; i++) {
                for (l = q[i]; l != -1; l = np[l][1]) {
                    arr[j++] = np[l][0];
                }
            }
        }
        return cont;

    }

    public int naturalIteracion(int A[], int izq, int der) {

        int pivote = A[izq]; // tomamos primer elemento como pivote
        int i = izq; // i realiza la búsqueda de izquierda a derecha
        int j = der; // j realiza la búsqueda de derecha a izquierda
        int aux;
        int ite = 0;

        while (i < j) {            // mientras no se crucen las búsquedas
            while (A[i] <= pivote && i < j) {
                i++; // busca elemento mayor que pivote
            }

            while (A[j] > pivote) {
                j--;         // busca elemento menor que pivote
            }
            if (i < j) {                      // si no se han cruzado                      
                aux = A[i];                  // los intercambia
                A[i] = A[j];
                A[j] = aux;
            }

        }

        A[izq] = A[j]; // se coloca el pivote en su lugar de forma que tendremos
        A[j] = pivote; // los menores a su izquierda y los mayores a su derecha
        ite++;
        if (izq < j - 1) {
            naturalIteracion(A, izq, j - 1); // ordenamos subarray izquierdo
        }
        if (j + 1 < der) {
            naturalIteracion(A, j + 1, der); // ordenamos subarray derecho
        }
        return ite;
    }

    public int naturalMov(int A[], int izq, int der) {

        int pivote = A[izq]; // tomamos primer elemento como pivote
        int i = izq; // i realiza la búsqueda de izquierda a derecha
        int j = der; // j realiza la búsqueda de derecha a izquierda
        int aux;
        int ite = 6;

        while (i < j) {            // mientras no se crucen las búsquedas
            while (A[i] <= pivote && i < j) {
                i++; // busca elemento mayor que pivote

            }

            while (A[j] > pivote) {
                j--;         // busca elemento menor que pivote
            }
            if (i < j) {                      // si no se han cruzado                      
                aux = A[i];                  // los intercambia
                A[i] = A[j];
                A[j] = aux;
            }

        }

        A[izq] = A[j]; // se coloca el pivote en su lugar de forma que tendremos
        A[j] = pivote; // los menores a su izquierda y los mayores a su derecha

        if (izq < j - 1) {
            naturalIteracion(A, izq, j - 1); // ordenamos subarray izquierdo
        }
        if (j + 1 < der) {
            naturalIteracion(A, j + 1, der); // ordenamos subarray derecho
        }
        return ite;
    }

    public int naturalPasadas(int A[], int izq, int der) {

        int pivote = A[izq]; // tomamos primer elemento como pivote
        int i = izq; // i realiza la búsqueda de izquierda a derecha
        int j = der; // j realiza la búsqueda de derecha a izquierda
        int aux;
        int ite = 3;

        while (i < j) {            // mientras no se crucen las búsquedas
            while (A[i] <= pivote && i < j) {
                i++; // busca elemento mayor que pivote

            }

            while (A[j] > pivote) {
                j--;         // busca elemento menor que pivote
            }
            if (i < j) {                      // si no se han cruzado                      
                ite++;
                aux = A[i];                  // los intercambia
                A[i] = A[j];
                A[j] = aux;
            }

        }

        A[izq] = A[j]; // se coloca el pivote en su lugar de forma que tendremos
        A[j] = pivote; // los menores a su izquierda y los mayores a su derecha

        if (izq < j - 1) {
            naturalIteracion(A, izq, j - 1); // ordenamos subarray izquierdo

        }

        if (j + 1 < der) {
            naturalIteracion(A, j + 1, der); // ordenamos subarray derecho
        }
        return ite;

    }

}
