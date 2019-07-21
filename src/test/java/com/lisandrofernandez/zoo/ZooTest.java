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

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Set;

import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

/**
 * Unit test for {@code Zoo} class.
 */
public class ZooTest {

    @Test
    public void emptyZoo_NoAnimals() {
        Zoo zoo = new Zoo();
        assertEquals(0, zoo.getAnimals().size());
    }

    @Test
    public void emptyZoo_NoAnimalsAndFriends() {
        Zoo zoo = new Zoo();
        assertEquals(0, zoo.getAnimalsAndFriends().size());
    }

    // at the beginning no animal has friends
    @Test
    public void newZoo_ShouldNotExistFriends() {
        Zoo zoo = new Zoo(
            new Dog("Dog One", "Meat", DogType.HUNTING),
            new Parrot("Parrot One", "Grain", .25f, false),
            new Chicken("Chicken One", "Corn", .75f, true),
            new Dog("Dog Two", "Freash meat", DogType.WORKING),
            new Parrot("Parrot Two", "Corn", .5f, true),
            new Dog("Dog Three", "Pedigree", DogType.SPORT),
            new Chicken("Chicken Two", "Corn", .75f, false)
        );
        for (Pair<Animal, Set<Animal>> af : zoo.getAnimalsAndFriends()) {
            assertEquals(0, af.getValue().size());
        }
    }

    @Test
    public void newZoo_NullArray_ShouldThrowNullPointerException() {
        Animal[] animals = null;
        assertThrows(NullPointerException.class, () -> new Zoo(animals));
    }

    @Test
    public void newZoo_ArrayWithNullElement_ShouldThrowNullPointerException() {
        Animal[] animals = new Animal[2];
        animals[0] = new Animal("Animal One", "Meat");
        animals[1] = null;
        assertThrows(NullPointerException.class, () -> new Zoo(animals));
    }

    @Test
    public void newZoo_NullCollection_ShouldThrowNullPointerException() {
        Collection<Animal> animals = null;
        assertThrows(NullPointerException.class, () -> new Zoo(animals));
    }

    @Test
    public void newZoo_CollectionWithNullElement_ShouldThrowNullPointerException() {
        Collection<Animal> animals = new ArrayList<>(2);
        animals.add(new Animal("Animal One", "Meat"));
        animals.add(null);
        assertThrows(NullPointerException.class, () -> new Zoo(animals));
    }

    @Test
    public void addAnimal_WhenNew_ShouldBeTrue() {
        Zoo zoo = new Zoo();
        assertTrue(zoo.addAnimal(new Animal("Animal One", "Meat")));
    }

    @Test
    public void addAnimal_WhenAlreadyAdded_ShouldBeFalse() {
        Zoo zoo = new Zoo();
        Animal animal = new Animal("Animal One", "Meat");
        zoo.addAnimal(animal);
        assertFalse(zoo.addAnimal(animal));
    }

    @Test
    public void addAnimal_WhenNull_ShouldThrowNullPointerException() {
        Zoo zoo = new Zoo();
        assertThrows(NullPointerException.class, () -> zoo.addAnimal(null));
    }

    @Test
    public void removeAnimal_WhenInTheZoo_ShouldBeTrue() {
        Animal animal = new Animal("Animal One", "Meat");
        Zoo zoo = new Zoo(animal);
        assertTrue(zoo.removeAnimal(animal));
    }

    @Test
    public void removeAnimal_WhenArleadyRemoved_ShouldBeFalse() {
        Animal animal = new Animal("Animal One", "Meat");
        Zoo zoo = new Zoo(animal);
        zoo.removeAnimal(animal);
        assertFalse(zoo.removeAnimal(animal));
    }

    @Test
    public void removeAnimal_WhenNull_ShouldThrowNullPointerException() {
        Zoo zoo = new Zoo();
        assertThrows(NullPointerException.class, () -> zoo.removeAnimal(null));
    }

    @Test
    public void addedAnimal_ShouldBePresent() {
        Zoo zoo = new Zoo();
        Animal animal = new Animal("Animal One", "Meat");
        zoo.addAnimal(animal);
        assertTrue(zoo.isAnimalPresent(animal));
    }

    @Test
    public void removedAnimal_ShouldNotBePresent() {
        Animal animal = new Animal("Animal One", "Meat");
        Zoo zoo = new Zoo(animal);
        zoo.removeAnimal(animal);
        assertFalse(zoo.isAnimalPresent(animal));
    }

    @Test
    public void isAnimalPresent_WhenNullAnimal_ShouldThrowNullPointerException() {
        Zoo zoo = new Zoo();
        assertThrows(NullPointerException.class, () -> zoo.isAnimalPresent(null));
    }

    @Test
    public void friendshipShouldBeSymmetric() {
        Dog dog = new Dog("Dog One", "Meat", DogType.HUNTING);
        Parrot parrot = new Parrot("Parrot One", "Grain", .25f, false);
        Zoo zoo = new Zoo(dog, parrot);
        zoo.makeFriends(dog, parrot);
        assertTrue(zoo.areFriends(dog, parrot));
        assertTrue(zoo.areFriends(parrot, dog));
    }

    // repeat test because of random interactions
    @RepeatedTest(5)
    public void liveDay_WithTwoAnimals_ShouldBeFriends() {
        Dog dog = new Dog("Dog One", "Meat", DogType.HUNTING);
        Parrot parrot = new Parrot("Parrot One", "Grain", .25f, false);
        Zoo zoo = new Zoo(dog, parrot);
        zoo.liveDay();
        assertTrue(zoo.areFriends(dog, parrot));
    }

}
