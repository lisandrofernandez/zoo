/*
 * Copyright (c) 2019 Lisandro Fernandez
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */
package com.lisandrofernandez.zoo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;

/**
 * This class represents a zoo with animals and the relations between them.
 *
 * @author Lisandro Fernandez
 */

public class Zoo {
    /**
     * The HashMap which backs this Zoo. The keys are the animals in
     * this zoo and the values are the sets of their friends.
     *
     * Given two animals x and y in the zoo which are friends, then
     * map.get(x).contains(y) and map.get(y).contains(x).
     *
     * A HashMap permits null keys so every attempt to put an Animal
     * must prevent null keys. The same applies for the friends as they
     * are stored in HashSets.
     */
    private HashMap<Animal, HashSet<Animal>> map;

    /**
     * Constructs an empty {@code Zoo}.
     */
    public Zoo() {
        map = new HashMap<>();
    }

    /**
     * Constructs a {@code Zoo} with the specified animals.
     *
     * @param  animals the array of animals
     * @throws NullPointerException if the array is null or any animal
     *         in it is null
     */
    public Zoo(Animal... animals) {
        for (Animal a : animals) if (a == null) throw new NullPointerException();
        HashSet<Animal> animalsSet = new HashSet<>(Arrays.asList(animals));
        map = new HashMap<>(animalsSet.size());
        for (Animal animal : animalsSet) {
            map.put(animal, new HashSet<>());
        }
    }

    /**
     * Constructs a {@code Zoo} with the specified animals.
     *
     * @param  animals the collection of animals
     * @throws NullPointerException if the collection is null or any
     *         animal in it is null
     */
    public Zoo(Collection<? extends Animal> animals) {
        for (Animal a : animals) if (a == null) throw new NullPointerException();
        HashSet<Animal> animalsSet = new HashSet<>(animals);
        map = new HashMap<>(animalsSet.size());
        for (Animal animal : animalsSet) {
            map.put(animal, new HashSet<>());
        }
    }

    /**
     * Adds an animal to the zoo if it is not present.
     *
     * @param  animal the animal to add
     * @return {@code true} if the animal was not in the zoo
     * @throws NullPointerException if the animal is null
     */
    public boolean addAnimal(Animal animal) {
        if (animal == null) throw new NullPointerException();
        return map.putIfAbsent(animal, new HashSet<>()) == null;
    }

    /**
     * Removes an animal to the zoo if it is not present.
     *
     * @param  animal the animal to remove
     * @return {@code true} if the animal was in the zoo
     * @throws NullPointerException if the animal is null
     */
    public boolean removeAnimal(Animal animal) {
        if (animal == null) throw new NullPointerException();
        HashSet<Animal> friends = map.remove(animal); 
        if (friends == null) return false;
        for (Animal f : friends) map.get(f).remove(animal);
        return true;
    }

    /**
     * Checks if an animal is in the zoo.
     *
     * @param  animal the whose presence in this zoo is to be tested
     * @return {@code true} if the animal is in the zoo
     * @throws NullPointerException if the animal is null
     */
    public boolean isAnimalPresent(Animal animal) {
        if (animal == null) throw new NullPointerException();
        return map.containsKey(animal);
    }

    /**
     * Returns the set of animals in the zoo. Changes to the set are not
     * reflected in the zoo, and vice-versa.
     *
     * @return the set of animals in the zoo
     */
    public Set<Animal> getAnimals() {
        return new HashSet<>(map.keySet());
    }

    /**
     * Returns the list of animals and their friends in the zoo. Changes
     * to the list are not reflected in the zoo, and vice-versa.
     *
     * @return the list of animals and their friends in the zoo
     */
    public List<Pair<Animal, Set<Animal>>> getAnimalsAndFriends() {
        List<Pair<Animal, Set<Animal>>> list = new ArrayList<>();
        for (Map.Entry<Animal, HashSet<Animal>> kv : map.entrySet()) {
            Animal animal = kv.getKey();
            HashSet<Animal> friends = kv.getValue();
            Pair<Animal, Set<Animal>> pair = new Pair<>(
                animal, new HashSet<>(friends)
            );
            list.add(pair);
        }
        return list;
    }

    /**
     * Returns {@code true} if the given animals are friends. If A is
     * friend of B then B is friend of A.
     *
     * @param a the first animal
     * @param b the second animal
     * @return {@code true} if the animals are friends
     * @throws NullPointerException if any of the given animals is null
     */
    public boolean areFriends(Animal a, Animal b) {
        if (a == null || b == null) throw new NullPointerException();
        return map.get(a).contains(b);
    }

    /**
     * Establishes a friendship between two animals which are not
     * friends. If A is friend of B then B is friend of A.
     *
     * <p>
     * Note: an animal cannot be friend of itself.
     *
     * @param a the first animal to be friend
     * @param b the second animal to be friend
     * @return {@code true} if the animals were not friends and are
     *         not equals
     * @throws NullPointerException if any of the given animals is null
     */
    public boolean makeFriends(Animal a, Animal b) {
        if (a == null || b == null) throw new NullPointerException();
        if (a.equals(b)) return false; // cannot be friend of itself
        return map.get(a).add(b) // false if were already friends
               && map.get(b).add(a); // true if reached
    }

    /**
     * Breaks a friendship between two animals which are friends.
     *
     * @param a the first animal to break the friendship
     * @param b the second animal to break the friendship
     * @return {@code true} if the animals were friends
     * @throws NullPointerException if any of the given animals is null
     */
    public boolean unmakeFriends(Animal a, Animal b) {
        if (a == null || b == null) throw new NullPointerException();
        return map.get(a).remove(b) // false if were not friends
               && map.get(b).remove(a); // true if reached
    }

    /**
     * A day goes by in the zoo in which each animal loses randomly one
     * friend (if there are any) and establishes friendship randomly
     * with another animal.
     *
     * <p>
     * During a day, an animal could lose and establish friendship with
     * the same animal and the latter could even break friendship with
     * the first.
     */
    public void liveDay() {
        if (map.size() < 2) return;
        Set<Animal> as = map.keySet();
        Animal[] animals = as.toArray(new Animal[as.size()]);
        for (Map.Entry<Animal, HashSet<Animal>> kv : map.entrySet()) {
            Animal animal = kv.getKey();
            // lose a friend
            HashSet<Animal> friends = kv.getValue();
            if (!friends.isEmpty()) {
                Animal[] friendsArray = friends.toArray(new Animal[friends.size()]);
                int i = new Random().nextInt(friendsArray.length);
                Animal friendToLose = friendsArray[i];
                unmakeFriends(animal, friendToLose);
                System.out.println(animal.getName() +
                    " has lost friendship with " + friendToLose.getName());
            }
            // make a friend
            Animal[] notFriends = Arrays.stream(animals)
                    .filter(x -> !areFriends(animal, x) && !animal.equals(x))
                    .toArray(Animal[]::new);
            // notFriends.lenght != 0
            int i = new Random().nextInt(notFriends.length);
            Animal newFriend = notFriends[i];
            makeFriends(animal, newFriend);
            System.out.println(animal.getName() +
                " has established friendship with " + newFriend.getName());
        }
    }
}
