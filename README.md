# Berliner Hochschule fuer Technik - SWT SS2023

This repo hosts assignments which were to be completed in the realm of the module Softwaretechnik.

## LE 9 - REF

### Food For Thought

#### Likes

We did a training at work some years back where we used the gilded rose example with refactoring
techniques. What impressed me was that we were able to make the code more readable by just using
those refactoring techniques and without even fully understanding what the yet to be refactored code
was actually doing. 
I tried to recreate this experience, however it quite couldn't. So after a certain point I just split
the code into specific handlers according to the requirements.
Code splitting or decomposing conditionals is always a good thing as it makes single parts of the code more testable and interchangeable
as well as the whole code more readable and reduces cognitive complexity. It is said, if done well even
non coders like PM's or PO's could do understand the code and detect flaws in logic / requirements.

#### Dislikes

I really like extract method, but I wonder if this could have consequences in execution speed of code because of
jumping to different positions. Although, I don't like to jump too much around in a source file when reading it.
But that's more a problem if inheritance is used in a very abusive way.
I think I haven't fully understood all the refactoring techniques. This - as most abstract concepts in programming - 
will come with experience. It's always a good lesson to work in a shitty company from time to time to understand the 
importance of those concepts and why they could make sense.

### Used Techniques

- Acceptance tests (to test requirements)
- Extract constant
- Extract method
- Replace conditional with polymorphism
- Replace method with method object
- Guard clause
- Decompose conditional
- Extract interface / superclass / subclass
- Use factory method
- Explicit this
- Final modifier if possible
- Static methods if possible
- Enhanced for loop

### Gilded Rose Refactoring

Based on [Gilded Roses Refactoring Kata](https://github.com/emilybache/GildedRose-Refactoring-Kata) and the gilded rose
requirements listed [here](./gilded-rose-requirements.txt).

-> [Refactored gilded rose](./src/main/java/org/gilded_rose/GildedRoseRefactored.java)

-> [Tests for refactored gilded rose](./src/test/java/org/gilded_rose/GildedRoseRefactoredTest.java)

-> [Original gilded rose](./src/main/java/org/gilded_rose/GildedRose.java)
