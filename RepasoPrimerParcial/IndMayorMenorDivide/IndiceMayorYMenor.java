public class IndiceMayorYMenor{
    public static Pair<Integer, Integer> indice(Integer[] arreglo){
        if(arreglo == null){
            throw new IllegalArgumentException();
        }
        if(arreglo.length == 0){
            return new Pair<>(-1,-1);
        }
        if(arreglo.length == 1){
            return new Pair<>(0,0);
        }else{
            return indiceAux(arreglo, 0, arreglo.length-1);
        }
    }

    public static Pair<Integer,Integer> indiceAux(Integer[] a, int ini, int fin){
        if(ini == fin){
            return new Pair<>(a[ini], a[ini]);
        }else{
            if(ini + 1 == fin){
                return new Pair<>(Math.min(a[ini], a[fin]), Math.max(a[ini], a[fin]));
            }else{
                int mid = (ini+fin)/2;
                Pair<Integer, Integer> t1 = indiceAux(a, ini, mid);
                Pair<Integer, Integer> t2 = indiceAux(a, mid + 1, fin);

                return new Pair<>(Math.min(t1.getFirst(), t2.getFirst()), Math.max(t1.getSecond(), t2.getSecond()));
            }
        }
    }

}