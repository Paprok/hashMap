package com.codecool.krk.hashMap;

import java.util.LinkedList;

public class HashMap<K, V> {
    private LinkedList<KeyValue<K, V>>[] map;
    private int size;

    public HashMap(int size){
        this.size = size;
        this.map = new LinkedList[size];
    }

    public void put(K key, V value){
        // TODO
    }
}
