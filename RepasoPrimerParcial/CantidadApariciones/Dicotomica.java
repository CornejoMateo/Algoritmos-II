public class Dicotomica {
    public static int indexMin(int[] a, int ini, int fin, int x){
        if(a == null){
            throw new IllegalArgumentException();
        }
        if(ini == 0){
            if(a[ini] == x){
                return ini;
            }
        }
        int mid = (ini+fin)/2;
        if(a[mid] == x){
            if(a[mid-1] != x){
                return mid;
            }else{
                return indexMin(a, ini, mid, x);
            }
        }else if(a[mid] < x){
            return indexMin(a, mid+1, fin, x);
        }else{
            return indexMin(a, ini, mid, x);
        }
    }

    public static int indexMax(int[] a, int ini, int fin, int x){
        if(a == null){
            throw new IllegalArgumentException();
        }
        if(fin == a.length-1){
            if(a[fin] == x){
                return fin;
            }
        }
        int mid = (ini+fin)/2;
        if(a[mid] == x){
            if(a[mid+1] != x){
                return mid;
            }else{
                return indexMax(a, mid+1, fin, x);
            }
        }else if(a[mid] < x){
            return indexMax(a, mid+1, fin, x);
        }else{
            return indexMax(a, ini, mid, x);
        }
    }
}
