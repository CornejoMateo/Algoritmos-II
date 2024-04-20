import java.util.HashMap;

public class subsecuencia0 {
    static HashMap <Pair<Integer,Integer>, Boolean> cache = new HashMap<>();

    public static Boolean subMemo(int[] s, int ind, int n){
        Pair<Integer, Integer> par = new Pair(ind, n);
        if(!cache.containsKey(par)){
            if(ind < s.length){
                if(s[ind] + n == 0){
                    cache.put(par, true);
                }else{
                    if(s[ind] == 0 || sub(s, ind+1, n) || sub(s, ind+1, s[ind] + n)){
                        cache.put(par, true);
                    }else{
                        cache.put(par, false);
                    }
                }
            }else{
                return false;
            }
        }
        return cache.get(par);
    }

}
