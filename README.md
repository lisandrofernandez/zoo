# Zoo

A zoo application.


## Problem description

We want to build a zoo with the following animals living in it:

* Dog
    - Name: "Killian"
    - Dog type: Hunting dog
    - Favorite food: "Meat"
* Parrot
    - Can not speak.
    - Name: "Parrot one"
    - Favorite food: "Grain"
    - Length of wings: 0.25
* Chicken
    - Length of wings: 0.75
    - Broiler
    - Favorite food: "Corn"
    - Name: "Chicken one"
* Dog
    - Favorite food: "Fresh meat"
    - Dog type: Working dog
    - Name: "Rocky"
* Parrot
    - Length of wings: 0.5
    - Name: "Parrot two"
    - Favorite food: "Corn"
    - Can speak
* Dog
    - Dog type: Sport dog
    - Favorite food: "Pedigree"
    - Name: "Peter"
* Chicken
    - Favorite food: "Corn"
    - Name: "Rocky"
    - Not a broiler
    - Length of wings: 0.75

Each animal can have several friends among other animals from the zoo. Every day
each animal loses randomly one friend (if there is any) and establishes
friendship randomly with another animal. If A is friend with B then B is friend
of A. At the beginning no animal has friends, such is life.


## Task Description

Write an application providing the following features:

1. List all animals with their properties and friends' names.
2. Live one day (when this option is chosen, each animal attempts to
   break/establish friendship as described above. Print all changes to console.
   For example: "Dog one has lost friendship with Chicken one"; "Dog one has
   established friendship with Parrot two").
3. List all animals with their properties and friends' names.
4. Exit.


## Requirements

* JDK 1.8 or superior.
* Maven.

## Compile and run

Package:

```
$ mvn clean package
```

Run:

```
$ java -jar target/zoo*.jar
```


## Copyright

Copyright &copy; 2019 [Lisandro Fernandez](https://github.com/lisandrofernandez).
