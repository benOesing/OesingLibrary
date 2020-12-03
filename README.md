# OesingLibrary
This repository contains the implementation of methods, that build the backbone of all of my projects. The Library is split into categories (see Introduction) of algorithms depending on the environment they work in.

This is an attempt at providing fast, tested and readable solutions for problems that arise  often. 

The library is in the refactoring process. Only a few methods are shown from over 200.
## Introduction

Right now the tested and refactored classes and methods are the following:

![image](Done.png?raw=true)
1. LibString:
    
    1.1 <code>asRomanNumber(int): String </code>Calculates the minimal representation of any number between 1 and 4999 in roman numerals.

    1.2 <code> editDistance(String, String,...): int</code> Calculates the edit distance between two strings. The costs for insertion, deletion and substitution can be set.

2. LibArray:

    2.1 <code> linearSearch(Object[], Object): int</code> Calculates the position of the given Object, using the linear search algorithm.

    2.2 <code> noDuplicates(Object[]): boolean</code> Decides if the given array contains any duplicates. As far as Java allows it Objects will get unpacked to follow semantic equality. (Ex. An array of primitives is equal, if every element is equal.)
