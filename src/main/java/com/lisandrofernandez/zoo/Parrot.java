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
 * This class represents a parrot.
 *
 * @author Lisandro Fernandez
 */

public class Parrot extends Bird {
    Boolean speak;

    /**
     * Construct an {@code Parrot}.
     */
    public Parrot() { }

    /**
     * Construct an {@code Parrot} with the given name.
     *
     * @param name the bird name
     */
    public Parrot(String name) {
        super(name);
    }

    /**
     * Construct an {@code Parrot} with the given name, favourite food,
     * length of the wings, and whether it can speak.
     *
     * @param name the parrot name
     * @param favouriteFood the parrot favourite food
     * @param wingsLength the length of the wings of the parrot
     * @param speak {@code true} if the parrot can speak
     */
    public Parrot(String name, String favouriteFood, Float wingsLength,
                  Boolean speak) {
        super(name, favouriteFood, wingsLength);
        this.speak = speak;
    }

    /**
     * Returns {@code true} if the parrot can speak.
     *
     * @return {@code true} if the parrot can speak
     */
    public Boolean canSpeak() {
        return speak;
    }

    /**
     * Sets {@code true} if the parrot can speak.
     *
     * @param speak {@code true} if the parrot can speak
     */
    public void setSpeak(Boolean speak) {
        this.speak = speak;
    }

    @Override
    public String toString() {
        return "Parrot [name = " + name + ", favourite food = " +
               favouriteFood + ", length of wings = " + wingsLength +
               ", can speak = " + speak + "]";
    }
}
