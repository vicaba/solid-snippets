# Single Responsibility Principle

A class should have one, and only one, reason to change.

It makes your software easier to implement and prevents unexpected side effects of future changes.

Classes have one responsibility and have concrete meaning. Classes are easier to understand and explain.

# Open/Closed Principle

Software entities (classes, modules, functions, etc.) should be open for extension, but closed for modification.

It tells you to write your code so that you will be able to add new functionality without changing the existing code. That prevents situations in which a change to one of your classes also requires you to adapt all depending classes.

Careful if you use inheritance: inheritance (superclasses) introduces tight coupling if the subclasses depend on implementation details of their parent class.

Polymorfic Open/Closed Principle: It uses interfaces instead of superclasses to allow different implementations which you can easily substitute without changing the code that uses them. An interface introduces an additional level of abstraction which enables loose coupling.

Design your interfaces so you do not need to modify them. The Interface Seggregatino Principle is handy here: if you seggregate your interfaces, changes to one interface won't affect the others

You can add new features without focusing too much on existing code.

You can avoid bugs since you are not modifying existing code.

See more [here](https://codeburst.io/introduction-a1ba1f72b13)

# Liskov Substitution Principle

It extends the Open/Closed principle and enables you to replace objects of a parent class with objects of a subclass without breaking the application

Let Φ(x) be a property provable about objects x of type T. Then Φ(y) should be true for objects y of type S where S is a subtype of T.

The principle requires the objects of your subclasses to behave in the same way as the objects of your superclass.

An overridden method of a subclass needs to accept the same input parameter values as the method of the superclass

Similar rules apply to the return value of the method. The return value of a method of the subclass needs to comply with the same rules as the return value of the method of the superclass.

See more [here](https://stackify.com/solid-design-liskov-substitution-principle/#:~:text=The%20Liskov%20Substitution%20Principle%20is%20the%20third%20of%20Robert%20C,way%20as%20the%20parent%20class.)

# Interface Seggregation Principle

No code should be forced to depend on methods it does not use.

Similar to the Single Responsibility Principle, the goal of the Interface Segregation Principle is to reduce the side effects and frequency of required changes by splitting the software into multiple, independent parts.

See the LSP example.
