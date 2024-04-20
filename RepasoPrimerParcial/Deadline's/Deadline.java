import java.util.HashMap;

public class Deadline {

    static HashMap <Integer, Integer> cache = new HashMap<>();

    public static int deadDinamic(int[] pen, int[] d){
        if(pen == null || d == null){
            throw new IllegalArgumentException();
        }
        int[][] mat = new int[pen.length+1][d.length+1];
        for(int i = 0; i <= pen.length; i++){
            mat[i][0] = 0;
        }
        for(int i = 0; i <= d.length; i++){
            mat[0][i] = 0;
        }
        for(int i = 1; i <= pen.length; i++){
            for(int j = 1; j <= d.length; j++){
                if(d.length == j){
                    mat[i][j] = pen[i-1];
                }else if(d[i-1] >= j){
                    mat[i][j] = Math.max(pen[i-1] + mat[i-1][j+1], mat[i-1][j]);
                }else{
                    mat[i][j] = mat[i-1][j];
                }
            }
        }
        return mat[pen.length][d.length];
    }

    public static int deadMemo(int[] pen, int[] d, int ind, int n){
        if(ind >= 0 && ind <= pen.length){
            if(!cache.containsKey(ind)){
                if(n == d.length){
                    cache.put(ind, 0);
                }else{
                    if(d[ind-1] >= ind){
                        int max = Math.max(pen[ind-1] + deadMemo(pen, d, ind+1, n+1), deadMemo(pen, d, ind+1, n));
                        cache.put(ind, max);
                    }else{
                        int aux = deadMemo(pen, d, ind+1, n);
                        cache.put(ind, aux);
                    }
                }
            }
            return cache.get(ind);
        }
        return 0;
    }

}
