/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eg.edu.alexu.util;

import java.lang.reflect.Array;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;

/**
 *
 * @author sameh
 * @param <K>
 * @param <V>
 */
public class KeyedSet<K, V> implements Set<V> {
    
    private final Map<K, V> map;
    private final Function<V, K> function;
    
    public KeyedSet(Function<V, K> function) {
        map = new HashMap<>();
        this.function = function;
    }
    
    public KeyedSet(Function<V, K> function, int size) {
        map = new HashMap<>(size);
        this.function = function;
    }

    @Override
    public int size() {
        return map.size();
    }

    @Override
    public boolean isEmpty() {
        return map.isEmpty();
    }

    @Override
    public boolean contains(Object o) {
        return map.containsKey(function.apply((V)o));
    }

    @Override
    public Iterator<V> iterator() {
        return map.values().iterator();
    }

    @Override
    public Object[] toArray() {
        return map.values().toArray();
    }

    @Override
    public <T> T[] toArray(T[] a) {
        Object []array = map.values().toArray();
        T[] ret = a.length >= array.length ? a :
                (T[])Array.newInstance(a.getClass().getComponentType(),
                        array.length);
        int i = 0;
        while (i < array.length) {
            ret[i] = (T)array[i];
            i++;
        }
        
        if (ret.length > array.length) {
            ret[i] = null;
        }
        
        return ret;
    }

    @Override
    public boolean add(V e) {
        try {
            map.put(function.apply(e), e);
        } catch(Exception exc) {
            return false;
        }
        
        return true;
    }

    @Override
    public boolean remove(Object o) {
        try {
            map.remove(function.apply((V) o));
        } catch (Exception e) {
            return false;
        }
        
        return true;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return map.values().containsAll(c);
    }

    @Override
    public boolean addAll(Collection<? extends V> c) {
        boolean changed = false;
        for (V v : c) {
            if (!add(v)) {
                changed = true;
            }
        }
        
        return changed;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        boolean changed = false;

        Set<K> keys = new HashSet<>();
        for (Object v : c) {
            keys.add(function.apply((V) v));
        }

        Set<K> currentKeys = new HashSet<>();
        currentKeys.addAll(map.keySet());
        for (K key : currentKeys) {
            try {
                if (!keys.contains(key)) {
                    map.remove(key);
                    changed = true;
                }
            } catch (Exception e) {
                
            }
        }
        
        return changed;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        boolean changed = false;
        for (Object v : c) {
            try {
                map.remove(function.apply((V) v));
                changed = true;
            } catch (Exception e) {
                
            }
        }

        return changed;
    }

    @Override
    public void clear() {
        map.clear();
    }
    
}
