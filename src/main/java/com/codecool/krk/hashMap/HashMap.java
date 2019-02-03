package com.codecool.krk.hashMap;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class HashMap<K, V> {
    private LinkedList<KeyValue<K, V>>[] map;
    private int size;
    private int elements;

    public HashMap() {
        this.elements = 0;
        this.size = 16;
        this.map = new LinkedList[size];
    }

    public HashMap(int size){
        this.elements = 0;
        this.size = size;
        this.map = new LinkedList[size];
    }

    public void put(K key, V value){
        extendMapIfNeeded();
        int index = getIndex(key);
        List<KeyValue<K, V>> list =  map[index];
        boolean exist = updateIfExist(key, value, list);
        addIfNotExist(key, value, list, exist);
    }

    private void extendMapIfNeeded() {
        //TODO multiply size and remap elements <3
    }

    private int getIndex(K key) {
        return key.hashCode() % size;
    }

    private void addIfNotExist(K key, V value, List<KeyValue<K, V>> list, boolean exist) {
        if(!exist){
            KeyValue<K, V> newPair = new KeyValue<>(key, value);
            list.add(newPair);
            ++elements;
        }
    }

    private boolean updateIfExist(K key, V value, List<KeyValue<K, V>> list) {
        boolean exist = false;
        for (KeyValue<K, V> pair: list) {
            if(pair.key.equals(key)){
                pair.key = key;
                pair.value = value;
                exist = true;
            }
        }
        return exist;
    }

    public V get(K key){
        int index = getIndex(key);
        V value = null;
        Iterator<KeyValue<K, V>> iterator = map[index].iterator();
        while(iterator.hasNext() && value == null){
            KeyValue<K, V> pair = iterator.next();
            if(pair.key.equals(key)){
                value = pair.value;
            }
        }
        return value;
    }

    public void remove(K key) {
        int index = getIndex(key);
        Iterator<KeyValue<K, V>> iterator = map[index].iterator();
        boolean run = true;
        while (iterator.hasNext() && run) {
            KeyValue<K, V> pair = iterator.next();
            if (pair.key.equals(key)) {
                iterator.remove();
                --elements;
                run = false;
            }
        }
    }
}
