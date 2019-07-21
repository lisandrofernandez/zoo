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

/**
 * This class represents an animal.
 *
 * @author Lisandro Fernandez
 */

public class Animal {
    protected String name;
    protected String favoriteFood;

    /**
     * Construct an {@code Animal}.
     */
    public Animal() { }

    /**
     * Construct an {@code Animal} with the given name.
     *
     * @param name the animal name
     */
    public Animal(String name) {
        this.name = name;
    }

    /**
     * Construct an {@code Animal} with the given name and favorite
     * food.
     *
     * @param name the animal name
     * @param favouriteFood the animal favorite food
     */
    public Animal(String name, String favoriteFood) {
        this.name = name;
        this.favoriteFood = favoriteFood;
    }

    /**
     * Returns the animal name.
     *
     * @return the animal name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the animal name.
     *
     * @param the animal name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Returns the animal favorite food.
     *
     * @return the animal favorite food
     */
    public String getFavouriteFood() {
        return favoriteFood;
    }

    /**
     * Sets the animal favorite food.
     *
     * @param favouriteFood the animal favorite food
     */
    public void setFavouriteFood(String favouriteFood) {
        this.favoriteFood = favouriteFood;
    }

    @Override
    public String toString() {
        return "Animal [name = " + name + ", favorite food = " + favoriteFood + "]";
    }
}
