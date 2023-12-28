package com.bipul.datastructures.hashmap.implementation;

import java.util.Arrays;

//not very optimum, for understanding
public class SimpleHashMap<K, V> {

    private static final int DEFAULT_CAPACITY = 10;
    private Entity[] entities;

    public SimpleHashMap(){
        this(DEFAULT_CAPACITY);
    }

    public SimpleHashMap(int capacity){
        entities = new Entity[capacity]; //not writing code on changing this size dynamically here
    }

    public void insert(K key, V value){
        int hash = Math.abs(key.hashCode() % entities.length); //not optimized/ no chaining - simple demo
        entities[hash] = new Entity<>(key, value);
    }

    public V get(K key){
        int hash = Math.abs(key.hashCode() % entities.length);
        if(entities[hash] != null && entities[hash].key.equals(key)){
            return (V) entities[hash].value;
        }
        return null;
    }

    public K remove(K key){
        int hash = Math.abs(key.hashCode() % entities.length);
        if(entities[hash] != null && entities[hash].key.equals(key)){
            entities[hash] = null;
            return key;
        }
        return null; //better to throw an error?
    }

    public void display(){
        System.out.println(Arrays.toString(entities));
    }

    private class Entity<K, V>{
        private K key;
        private V value;

        public Entity(K key, V value){
            this.key = key;
            this.value = value;
        }

        @Override
        public String toString() {
            return "{" + key + "," + value + "}";
        }
    }
}
