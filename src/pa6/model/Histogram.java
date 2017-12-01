/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pa6.model;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author Marcos
 */
public class Histogram <T>{
    Map<T,Integer> map = new HashMap<>();
    
    public Integer get(T key) {
    return map.get(key);

}
    public Set<T> keySet(){
            return map.keySet();
    }
    
    public void increment(T key) {
        map.put(key, map.containsKey(key) ? map.get(key) + 1 : 1);
    }
}