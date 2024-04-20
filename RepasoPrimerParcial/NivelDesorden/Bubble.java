import java.util.ArrayList;

public class Bubble{
    public static int desorden(int[] array){
        boolean ordenado = false;
        int cant = 0;
        for(int i = array.length; i >= 0 && !ordenado; i--){
            ordenado = true;
            for(int j = 0; j < i-1; j++){
                if(array[j] > array[j+1]){
                    swap(array, j, j+1);
                    cant++;
                    ordenado = false;
                }
            }
        }
        return cant;
    }

    private static void swap(int[] a, int index1, int index2){
        int aux = a[index1];
        a[index1] = a[index2];
        a[index2] = aux;
    }

}