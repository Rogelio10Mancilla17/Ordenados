/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metodos;

import javax.swing.*;
import java.util.*;

/**
 *
 * @author Christian
 */
public class metodos {

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

    public int[] burbuja(int[] a) {
        for (int i = 0; i < a.length - 1; i++) {
            for (int j = 0; j < a.length - 1; j++) {
                if (a[j] > a[j + 1]) {
                    int tmp = a[j + 1];
                    a[j + 1] = a[j];
                    a[j] = tmp;
                }
            }

        }
        return a;
    }

    public int burbujaMovimiento(int[] a) {
        int mov = 0;
        for (int i = 0; i < a.length - 1; i++) {
            for (int j = 0; j < a.length - 1; j++) {
                if (a[j] > a[j + 1]) {
                    int tmp = a[j + 1];
                    a[j + 1] = a[j];
                    a[j] = tmp;
                    mov++;
                }
            }

        }
        return mov;
    }

    public int burbujaPasada(int[] a) {
        int pas = 0;
        for (int i = 0; i < a.length - 1; i++) {
            for (int j = 0; j < a.length - 1; j++) {
                if (a[j] > a[j + 1]) {
                    int tmp = a[j + 1];
                    a[j + 1] = a[j];
                    a[j] = tmp;
                    pas++;
                }
            }

        }
        return pas;
    }

    public int burbujaIteracion(int[] a) {
        int ite = 0;
        for (int i = 0; i < a.length - 1; i++) {
            for (int j = 0; j < a.length - 1; j++) {
                if (a[j] > a[j + 1]) {
                    int tmp = a[j + 1];
                    a[j + 1] = a[j];
                    a[j] = tmp;
                    ite++;

                }
            }

        }
        return ite;
    }

    public int[] ordenacionShaker(int[] v) {
        final int N = v.length;
        int limInferior = 0;
        int limSuperior = N - 1;
        while (limInferior <= limSuperior) {
            for (int j = limInferior; j < limSuperior; j++) {
                if (v[j] > v[j + 1]) {
                    int tmp = v[j];
                    v[j] = v[j + 1];
                    v[j + 1] = tmp;
                }
            }
            limSuperior--;
            for (int j = limSuperior; j > limInferior; j--) {
                if (v[j] < v[j - 1]) {
                    int tmp = v[j];
                    v[j] = v[j - 1];
                    v[j - 1] = tmp;
                }
            }
            limInferior++;
        }
        return v;
    }

    public int ordenacionShakerMovimiento(int[] v) {
        final int N = v.length;
        int limInferior = 0;
        int limSuperior = N - 1;
        int mov = 0;

        while (limInferior <= limSuperior) {
            for (int j = limInferior; j < limSuperior; j++) {
                if (v[j] > v[j + 1]) {
                    int tmp = v[j];
                    v[j] = v[j + 1];
                    v[j + 1] = tmp;

                }
            }
            limSuperior--;
            mov++;
            for (int j = limSuperior; j > limInferior; j--) {
                if (v[j] < v[j - 1]) {
                    int tmp = v[j];
                    v[j] = v[j - 1];
                    v[j - 1] = tmp;

                }
            }
            limInferior++;
            mov++;
        }
        return mov;
    }

    public int ordenacionShakerPasada(int[] v) {
        final int N = v.length;
        int limInferior = 0;
        int limSuperior = N - 1;
        int pas = 0;
        while (limInferior <= limSuperior) {
            for (int j = limInferior; j < limSuperior; j++) {
                if (v[j] > v[j + 1]) {
                    int tmp = v[j];
                    v[j] = v[j + 1];
                    v[j + 1] = tmp;

                }
            }
            limSuperior--;
            pas++;
            for (int j = limSuperior; j > limInferior; j--) {
                if (v[j] < v[j - 1]) {
                    int tmp = v[j];
                    v[j] = v[j - 1];
                    v[j - 1] = tmp;

                }
            }
            limInferior++;
            pas++;
        }
        return pas;
    }

    public int ordenacionShakerIteracion(int[] v) {
        final int N = v.length;
        int limInferior = 0;
        int limSuperior = N - 1;
        int ite = 0;
        while (limInferior <= limSuperior) {
            for (int j = limInferior; j < limSuperior; j++) {
                if (v[j] > v[j + 1]) {
                    int tmp = v[j];
                    v[j] = v[j + 1];
                    v[j + 1] = tmp;

                }
            }
            limSuperior--;
            ite++;

            for (int j = limSuperior; j > limInferior; j--) {
                if (v[j] < v[j - 1]) {
                    int tmp = v[j];
                    v[j] = v[j - 1];
                    v[j - 1] = tmp;

                }
            }
            limInferior++;
            ite++;

        }
        return ite;
    }

    public int[] shellSort(int a[]) {
        for (int gap = a.length / 2; gap > 0; gap = gap == 2 ? 1 : (int) (gap / 2.2)) {
            for (int i = gap; i < a.length; i++) {
                int tmp = a[i];
                int j;
                for (j = i; j >= gap && tmp < a[j - gap]; j -= gap) {
                    a[j] = a[j - gap];
                }
                a[j] = tmp;
            }
        }
        return a;
    }

    public int shellSortMovimiento(int a[]) {
        int mov = 0;
        for (int gap = a.length / 2; gap > 0; gap = gap == 2 ? 1 : (int) (gap / 2.2)) {
            for (int i = gap; i < a.length; i++) {
                int tmp = a[i];
                int j;
                mov++;

                for (j = i; j >= gap && tmp < a[j - gap]; j -= gap) {
                    a[j] = a[j - gap];

                }

                a[j] = tmp;
            }

        }
        return mov;
    }

    public int shellSortPasada(int a[]) {
        int pas = 0;
        for (int gap = a.length / 2; gap > 0; gap = gap == 2 ? 1 : (int) (gap / 2.2)) {
            for (int i = gap; i < a.length; i++) {
                int tmp = a[i];
                int j;
                pas++;

                for (j = i; j >= gap && tmp < a[j - gap]; j -= gap) {
                    a[j] = a[j - gap];
                }

                a[j] = tmp;
            }

        }
        return pas;
    }

    public int shellSortIteracion(int a[]) {
        int ite = 0;
        for (int gap = a.length / 2; gap > 0; gap = gap == 2 ? 1 : (int) (gap / 2.2)) {
            for (int i = gap; i < a.length; i++) {
                int tmp = a[i];
                int j;
                ite++;
                for (j = i; j >= gap && tmp < a[j - gap]; j -= gap) {
                    a[j] = a[j - gap];
                }

                a[j] = tmp;
            }

        }
        return ite;
    }

    public int[] ordenarInsercion(int[] array) {
        int aux;
        for (int i = 1; i < array.length; i++) {
            aux = array[i];
            for (int j = i - 1; j >= 0 && array[j] > aux; j--) {
                array[j + 1] = array[j];
                array[j] = aux;
            }
        }
        return array;
    }

    public int ordenarInsercionMovimiento(int[] array) {
        int aux;
        int mov = 0;
        for (int i = 1; i < array.length; i++) {
            aux = array[i];
            mov++;
            for (int j = i - 1; j >= 0 && array[j] > aux; j--) {
                array[j + 1] = array[j];
                array[j] = aux;

            }
        }

        return mov;
    }

    public int ordenarInsercionPasada(int[] array) {
        int aux;
        int pas = 0;
        for (int i = 1; i < array.length; i++) {
            aux = array[i];
            pas++;
            for (int j = i - 1; j >= 0 && array[j] > aux; j--) {
                array[j + 1] = array[j];
                array[j] = aux;

            }
        }
        return pas;
    }

    public int ordenarInsercionIteracion(int[] array) {
        int aux;
        int ite = 0;
        for (int i = 1; i < array.length; i++) {
            aux = array[i];
            ite++;
            for (int j = i - 1; j >= 0 && array[j] > aux; j--) {
                array[j + 1] = array[j];
                array[j] = aux;

            }

        }
        return ite;
    }

    public int[] quicksort(int A[], int izq, int der) {

        int pivote = A[izq]; // tomamos primer elemento como pivote
        int i = izq; // i realiza la búsqueda de izquierda a derecha
        int j = der; // j realiza la búsqueda de derecha a izquierda
        int aux;

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
            quicksort(A, izq, j - 1); // ordenamos subarray izquierdo
        }
        if (j + 1 < der) {
            quicksort(A, j + 1, der); // ordenamos subarray derecho
        }
        return A;
    }

    public int quicksortMovimiento(int A[], int izq, int der) {

        int pivote = A[izq]; // tomamos primer elemento como pivote
        int i = izq; // i realiza la búsqueda de izquierda a derecha
        int j = der; // j realiza la búsqueda de derecha a izquierda
        int aux;
        int mov = 0;

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
        mov++;

        if (izq < j - 1) {
            quicksort(A, izq, j - 1); // ordenamos subarray izquierdo
        }
        if (j + 1 < der) {
            quicksort(A, j + 1, der); // ordenamos subarray derecho
        }
        return mov;
    }

    public int quicksortPasada(int A[], int izq, int der) {

        int pivote = A[izq]; // tomamos primer elemento como pivote
        int i = izq; // i realiza la búsqueda de izquierda a derecha
        int j = der; // j realiza la búsqueda de derecha a izquierda
        int aux;
        int pas = 0;

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
        pas++;
        if (izq < j - 1) {
            quicksort(A, izq, j - 1); // ordenamos subarray izquierdo
        }
        if (j + 1 < der) {
            quicksort(A, j + 1, der); // ordenamos subarray derecho
        }
        return pas;
    }

    public int quicksortIteracion(int A[], int izq, int der) {

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
            quicksort(A, izq, j - 1); // ordenamos subarray izquierdo
        }
        if (j + 1 < der) {
            quicksort(A, j + 1, der); // ordenamos subarray derecho
        }
        return ite;
    }

    public int[] radixSort(int[] arr) {
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
        return arr;
    }

    public int radixSortMovimiento(int[] arr) {
        int[][] np = new int[arr.length][2];
        int[] q = new int[0x100];
        int i, j, k, l, f = 0;
        int mov = 0;
        for (k = 0; k < 4; k++) {
            for (i = 0; i < (np.length - 1); i++) {
                np[i][1] = i + 1;
            }

            np[i][1] = -1;
            for (i = 0; i < q.length; i++) {
                q[i] = -1;
            }
            mov++;
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
        return mov;
    }

    public int radixSortPasada(int[] arr) {
        int[][] np = new int[arr.length][2];
        int[] q = new int[0x100];
        int i, j, k, l, f = 0;
        int pas = 0;
        for (k = 0; k < 4; k++) {
            for (i = 0; i < (np.length - 1); i++) {
                np[i][1] = i + 1;
            }
            np[i][1] = -1;
            for (i = 0; i < q.length; i++) {
                q[i] = -1;
            }
            pas++;
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
        return pas;
    }

    public int radixSortIteracion(int[] arr) {
        int[][] np = new int[arr.length][2];
        int[] q = new int[0x100];
        int i, j, k, l, f = 0;
        int ite = 0;
        for (k = 0; k < 4; k++) {
            for (i = 0; i < (np.length - 1); i++) {
                np[i][1] = i + 1;
            }
            np[i][1] = -1;
            for (i = 0; i < q.length; i++) {
                q[i] = -1;
            }
            ite++;
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
        return ite;
    }

}
