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



