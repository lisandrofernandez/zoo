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
 * This class represents a bird.
 *
 * @author Lisandro Fernandez
 */

public class Bird extends Animal {
    protected Float wingsLength;

    /**
     * Construct an {@code Bird}.
     */
    public Bird() { }

    /**
     * Construct an {@code Bird} with the given name.
     *
     * @param name the bird name
     */
    public Bird(String name) {
        super(name);
    }

    /**
     * Construct an {@code Bird} with the given name, favourite food and
     * length of the wings.
     *
     * @param name the bird name
     * @param favouriteFood the bird favourite food
     * @param wingsLength the length of the wings of the bird
     */
    public Bird(String name, String favouriteFood, Float wingsLength) {
        super(name, favouriteFood);
        this.wingsLength = wingsLength;
    }

    /**
     * Returns the length of the wings.
     *
     * @return the length of the wings
     */
    public Float getWingsLength() {
        return wingsLength;
    }

    /**
     * Sets the length of the wings.
     * 
     * @param wingsLength the length of the wings
     */
    public void setWingsLength(Float wingsLength) {
        this.wingsLength = wingsLength;
    }

    @Override
    public String toString() {
        return "Bird [name = " + name + ", favourite food = " + favouriteFood +
               ", length of wings = " + wingsLength + "]";
    }

}
