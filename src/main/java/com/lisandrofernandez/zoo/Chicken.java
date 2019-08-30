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

public class Chicken extends Bird {
    Boolean boiler;

    /**
     * Construct an {@code Chicken}.
     */
    public Chicken() { }

    /**
     * Construct an {@code Chicken} with the given name.
     *
     * @param name the chicken name
     */
    public Chicken(String name) {
        super(name);
    }

    /**
     * Construct an {@code Chicken} with the given name, favourite food,
     * length of the wings, and whether it can speak.
     *
     * @param name the chicken name
     * @param favouriteFood the chicken favourite food
     * @param wingsLength the length of the wings of the chicken
     * @param boiler {@code true} if the chicken is a boiler
     */
    public Chicken(String name, String favouriteFood, Float wingsLength,
                   Boolean boiler) {
        super(name, favouriteFood, wingsLength);
        this.boiler = boiler;
    }

    /**
     * Returns {@code true} if the chicken is a boiler.
     *
     * @return {@code true} if the chicken is a boiler
     */
    public Boolean isBoiler() {
        return boiler;
    }

    /**
     * Sets {@code true} if the parrot can speak.
     *
     * @param canSpeak {@code true} if the chicken can speak
     */
    public void setBolier(Boolean boiler) {
        this.boiler = boiler;
    }

    @Override
    public String toString() {
        return "Chicken [name = " + name + ", favourite food = " +
               favouriteFood + ", length of wings = " + wingsLength +
               ", is boiler = " + boiler + "]";
    }
}
