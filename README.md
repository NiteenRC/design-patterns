## Creational Design Patterns

Creational design patterns manage object creation mechanisms, making object creation flexible and reusable while hiding creation logic from client code.

### Singleton Pattern

- **Definition**: Ensures only one instance of a class per JVM, accessible globally.
- **When to Use**: Logging systems, thread pools, cache systems, database settings.
- **Ways Singleton Can Be Broken**:
  - **Reflection**: Accessing the private constructor.
  - **Serialization/Deserialization**: Creating new instances upon deserialization.
  - **Multithreading**: Multiple instances due to improper synchronization.
  - **Classloaders**: Multiple class loaders creating separate instances.
  - **Cloning**: Creating a clone if `Cloneable` is not properly handled.
- **Constraints**: 
  - Private static final instance.
  - Private constructor.
  - Public static method for accessing the instance.
- **Creation Methods**:
  - Lazy/Eager Initialization.
  - Thread Safety.
  - Static Block Initialization.
  - Enum (best practice).

### Factory Design Pattern

- **Definition**: Creates objects without exposing creation logic to clients, referencing a common interface.
- **When to Use**: Plugin systems, configurable component creation.

### Builder Pattern

- **Definition**: Constructs complex objects step by step.
- **When to Use**: 
  - Complex object construction.
  - Flexible object creation.
  - Immutable objects.

### Prototype Pattern

- **Definition**: Creates new objects by copying an existing object.
- **When to Use**: Resource-intensive object creation.

## Behavioral Design Patterns

### Observer
  - **Defination**: One-to-many dependency; observers get updated automatically when the subject changes.
  - **Use Case**: Publish-subscribe systems, monitoring, and logging.

### Strategy
  -**Defination**: Encapsulates algorithms, making them interchangeable.
  - **Use Case**: Sorting strategies, payment methods, authentication mechanisms.

### Template
  --**Defination**: Defines algorithm skeleton in superclass; subclasses override specific steps.
  - **Use Case**: Order processing, framework design, game development.

### Command
  - **Defination**: Encapsulates a request as an object.
  - **Use Case**: Transaction management, macro recording, undo/redo, remote control systems, task scheduling.

###Chain of Responsibility
- **Defination**: Passes a request along a chain of handlers.
  
  - **Use Case**: Support ticket systems, request handling in web applications, logging, input validation.
