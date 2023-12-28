package com.bipul.datastructures.hashmap.implementation;

import java.util.ArrayList;
import java.util.LinkedList;

public class HashMapWithChain<K, V> {
    ArrayList<LinkedList<Entity>> arrList;

    private int size = 0;

    private float lf = 0.5f; //load factor

    public HashMapWithChain(){
        arrList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            arrList.add(new LinkedList<>()); //we need the LLs to be present for chaining
        }
    }

    public void put(K key, V value){
        int hash = Math.abs(key.hashCode() % arrList.size());

        //chained entities at this index of the list
        LinkedList<Entity> entities = arrList.get(hash);

        //checking if a value is already present for this key, if yes -> update it and return
        for(Entity entity: entities){
            if(entity.key.equals(key)){
                entity.value = value;
                return;
            }
        }

        //before adding a new entity - check lf and rehash if needed
        if((float) (size) /arrList.size() > lf){
            reHash(); //increase the size of the original array (double it)
        }

        //new key, add it
        entities.add(new Entity(key, value));
        size++; //maintain this size, imp for calculating the need of rehash
    }

    private void reHash(){
        System.out.println("Oops, Rehashing!");
        //storing the old list to copy entities from
        ArrayList<LinkedList<Entity>> oldList = arrList;
        //resetting variables
        arrList = new ArrayList<>();
        size = 0;

        //populating default values to the new list
        int newSize = oldList.size()*2;
        for (int i = 0; i < newSize; i++) {
            arrList.add(new LinkedList<>());
        }

        //copying existing values
        for(LinkedList<Entity> oldEntities: oldList){
            for(Entity entity: oldEntities){
                put((K) entity.key, (V) entity.value);
            }
        }
        System.out.println("Successfully Rehashed!");
    }

    public V get(K key){
        int hash = Math.abs(key.hashCode() % arrList.size());
        LinkedList<Entity> entities = arrList.get(hash);
        for(Entity entity: entities){
            if(entity.key.equals(key)){
                return (V) entity.value;
            }
        }
        return null;
    }

    public V remove(K key){
        int hash = Math.abs(key.hashCode() % arrList.size());
        LinkedList<Entity> entities = arrList.get(hash);
        Entity removed = null;
        for(Entity entity: entities){
            if(entity.key.equals(key)){
                removed = entity;
                break;
            }
        }
        entities.remove(removed);
        size--;
        return (V) removed.value;
    }

    public boolean containsKey(K key){
        return get(key) != null;
    }

    public String display(){
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        for(LinkedList<Entity> list: arrList){
            for(Entity e: list){
                sb.append(e.key);
                sb.append(": ");
                sb.append(e.value);
                sb.append(", ");
            }
        }
        sb.append("}");
        return sb.toString();
    }

    private class Entity<K, V>{
        private K key;
        private V value;

        public Entity(K key, V value){
            this.key = key;
            this.value = value;
        }
    }
}
