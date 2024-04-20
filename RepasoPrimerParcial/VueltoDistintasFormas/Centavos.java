import java.util.HashMap;

import javax.swing.text.html.parser.Element;

public class Centavos {

    static HashMap <Pair<Integer, Integer>, Integer> cache = new HashMap<>();

    public static int centMemo(int[] monedas, int cambio, int ind){
        if(ind >= 0 && ind < monedas.length){
            Pair<Integer,Integer> par = new Pair(ind, cambio);
            if(!cache.containsKey(par)){
                if(monedas[ind] == cambio){
                    cache.put(par, 1);
                }else{
                    if(monedas[ind] < cambio){
                        int c = centMemo(monedas, cambio-monedas[ind], ind) + centMemo(monedas, cambio, ind+1);
                        cache.put(par, c);
                    }else{
                        int x = centMemo(monedas, cambio, ind+1);
                        cache.put(par, x);
                    }
                }
            }
            return cache.get(par);
        }
        return 0;
    }

    public static int centDinamic( int[] centavos, int cambio){
        if (centavos.length == 0 || cambio == 0){
            return 0;
        } else {
            int[][] mat = new int[centavos.length+1][cambio+1];
            for (int i = 0; i <= centavos.length; i++) {
                mat[i][0] = 0;
            }
            for (int i = 0; i <= cambio; i++) {
                mat[0][i] = 0;
            }
            for (int elemAct = 1; elemAct <= centavos.length; elemAct++) {
                for (int camAct = 1; camAct <= cambio; camAct++) {
                    if (camAct > centavos[elemAct-1]) {
                        mat[elemAct][camAct] = mat[elemAct][camAct-centavos[elemAct-1]] + mat[elemAct - 1][camAct];
                    } else if(camAct == centavos[elemAct-1]) {
                        mat[elemAct][camAct] = 1;
                    }else{
                        mat[elemAct][camAct] = mat[elemAct - 1][camAct];
                    }
                }
            }
            return mat[centavos.length][cambio];
        }
    }

}

//[1,3,5,9] 9
//[-, -, -, -]
