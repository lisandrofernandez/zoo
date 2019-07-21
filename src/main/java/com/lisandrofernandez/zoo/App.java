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

import java.util.Arrays;
import java.util.List;
import java.util.Set;

/**
 * Starts the zoo application.
 *
 * @author Lisandro Fernandez
 */
public class App {
    public static void main(String[] args) {
        System.out.println("*** Starting application ***");
        Zoo zoo = new Zoo(generateAnimals());
        printAnimals(zoo);
        zoo.liveDay();
        printAnimals(zoo);
        System.out.println("*** Finishing application ***");
    }

    /**
     * Generates a list with some animals.
     *
     * @return a list with some animals
     */
    private static List<Animal> generateAnimals() {
        return Arrays.asList(
            new Dog("Dog One", "Meat", DogType.HUNTING),
            new Parrot("Parrot One", "Grain", .25f, false),
            new Chicken("Chicken One", "Corn", .75f, true),
            new Dog("Dog Two", "Freash meat", DogType.WORKING),
            new Parrot("Parrot Two", "Corn", .5f, true),
            new Dog("Dog Three", "Pedigree", DogType.SPORT),
            new Chicken("Chicken Two", "Corn", .75f, false)
        );
    }

    /**
     * Prints the animals in the given zoo with their friends.
     *
     * @param zoo the zoo
     */
    private static void printAnimals(Zoo zoo) {
        for (Pair<Animal, Set<Animal>> af : zoo.getAnimalsAndFriends()) {
            Animal animal = af.getKey();
            Set<Animal> friends = af.getValue();
            StringBuilder sb = new StringBuilder();
            sb.append(animal);
            for (Animal f : friends) {
                sb.append(System.lineSeparator()).append("  - ").append(f.getName());
            }
            System.out.println(sb);
        }
    }
}
