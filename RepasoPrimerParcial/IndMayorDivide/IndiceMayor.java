public class IndiceMayor {

    public static int indice(int[] arreglo){
        if(arreglo == null){
            throw new IllegalArgumentException();
        }
        if(arreglo.length == 0){
            return -1;
        }
        if(arreglo.length == 1){
            return 0;
        }else{
            return indiceMayor(arreglo, 0, arreglo.length-1);
        }

    }

    public static int indiceMayor(int[] a, int ini, int fin){
        if(ini == fin){
            return ini;
        }
        if(ini + 1 == fin){
            if(a[ini] >= a[fin]){
                return ini;
            }else{
                return fin;
            }
        }else{
            int mid = fin/2;
            int left = indiceMayor(a, ini, mid);
            int rigth = indiceMayor(a, mid+1, fin);
            
            if(a[left] >= a[rigth]){
                return left;
            }else{
                return rigth;
            }
        }
    }
}

//{20,1,3,4,2,10}
//