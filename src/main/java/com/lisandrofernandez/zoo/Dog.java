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
 * This class represents a dog.
 *
 * @author Lisandro Fernandez
 */

public class Dog extends Animal {
    private DogType type;

    /**
     * Construct an {@code Dog}.
     */
    public Dog() { }

    /**
     * Construct an {@code Dog} with the given name.
     *
     * @param name the dog name
     */
    public Dog(String name) {
        super(name);
    }

    /**
     * Construct an {@code Dog} with the given name, favorite food and
     * dog type.
     *
     * @param name the dog name
     * @param favouriteFood the dog favorite food
     * @param type the dog type
     */
    public Dog(String name, String favoriteFood, DogType type) {
        super(name, favoriteFood);
        this.type = type;
    }

    /**
     * Returns the dog type.
     *
     * @return the dog type
     */
    public DogType getType() {
        return type;
    }

    /**
     * Sets the dog type.
     *
     * @param type the dog type
     */
    public void setType(DogType type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Dog [name = " + name + ", favorite food = " + favoriteFood +
                ", dog type = " + type + "]";
    }

}
