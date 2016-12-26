package de.javafish.apiaddition;

import java.util.*;

@SuppressWarnings("serial")
public class IndexedMap<K, V> extends LinkedHashMap<K, V> {

    private List<K> indices;

    public IndexedMap() {
        indices = new ArrayList<>();
    }
    
    @Override
    public V put(K key, V value) {
        indices.add(key);
        return super.put(key, value);
    }
    
    public V get(int i) {
        return get(indices.get(i));
    }

    @Override
    public V remove(Object key) {
        indices.remove(key);
        return super.remove(key);
    }
}
