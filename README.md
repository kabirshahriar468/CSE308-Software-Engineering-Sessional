# CSE 308 - Software Engineering Sessional

This repository contains coursework for CSE 308 Software Engineering Sessional, focusing on software design patterns, software engineering principles, and practical implementations.

## 📚 Course Overview

CSE 308 Software Engineering Sessional covers fundamental software engineering concepts with emphasis on:
- Design Patterns (Creational, Structural, Behavioral)
- Software Architecture
- Object-Oriented Design Principles
- Load Testing and Performance Analysis

## 📁 Repository Structure

### 📖 Course Materials
- `CSE308_Structural_Design_Pattern (2).pdf` - Structural design patterns documentation
- `CSE308Offline2.docx.pdf` - Offline assignment 2 specifications
- `Behavioural Design Patterns.pdf` - Behavioral patterns reference
- `SWEonlineDesignPatterns.pdf` - Online design patterns materials
- `Load Testing with JMeter Online.pdf` - JMeter testing documentation
- `Offline 1.pdf` - `Offline 4.pdf` - Assignment specifications

### 💻 Online Assignments (`CSE-308(Online)/`)
Implementation of various design patterns:

#### Creational Patterns
- **Builder Pattern** (`builder/`) - Step-by-step object construction
- **Abstract Factory** (`abstract_factory_NO/`) - Family of related objects
- **Factory Method** (`factory_NO/`) - Object creation interface
- **Singleton** (`singleton/`) - Single instance control

#### Structural Patterns
- **Adapter Pattern** (`adapter/`) - Interface compatibility between classes
- **Composite Pattern** (`composite/`) - Tree structures of objects
- **Decorator Pattern** (`decorator/`) - Dynamic behavior addition

#### Behavioral Patterns
- **Chain of Responsibility** (`ChainOfResponsibility/`) - Request handling chain
- **Mediator Pattern** (`mediator/`) - Object communication mediation
- **Observer Pattern** (`observer/`) - Dependency notifications
- **State Pattern** (`state/`) - Object behavior based on state
- **Strategy Pattern** (`strategy/`) - Algorithm family encapsulation

### 🏦 Offline Assignment 1 (`offline1__2005114/`)
**Banking System Implementation**
- Account management system with multiple account types
- Employee management and authentication
- Features:
  - Savings Account, Student Account, Fixed Deposit Account
  - Employee roles and permissions
  - Transaction processing
  - Account balance management

**Key Components:**
- `src/Main.java` - Main application entry point
- `src/account/` - Account type implementations
- `src/bank/` - Banking system logic
- `src/employee/` - Employee management

### 🥤 Offline Assignment 2 (`Offline2_2005114/`)
**Shake Shop Builder Pattern Implementation**
- Custom shake building system using Builder pattern
- Ingredient management and customization
- Order processing system

**Key Components:**
- `src/Shop.java` - Main shop interface
- `src/ShakeBuilder.java` - Builder pattern implementation
- `src/BuildOrder.java` - Order processing
- `src/Ingredients/` - Available ingredients
- `src/Shakes/` - Shake variations

### 📁 Offline Assignment 3 (`offline3_2005114/`)
**Design Pattern Applications**
- Problem-solving using design patterns
- UML diagrams and architectural designs
- Multiple problem scenarios

**Features:**
- `src/Problem1_Main.java` - First problem implementation
- `src/Problem2_Main.java` - Second problem implementation
- `src/Decorators/` - Decorator pattern implementations
- `src/FileSystem/` - File system modeling
- `src/Passengers/` - Passenger management system
- UML diagrams (`.drawio` and `.pdf` formats)

### 🎯 Offline Assignment 4 (`offline4_2005114/`)
**Advanced Design Pattern Implementation**
- Complex software architecture
- Integration of multiple design patterns
- Real-world application scenarios

## 🛠️ Technologies Used

- **Language:** Java
- **Build Tool:** Gradle (for applicable projects)
- **Design:** UML Diagrams (Draw.io)
- **Testing:** JMeter for load testing
- **IDE:** IntelliJ IDEA (`.iml` files present)

## 🚀 Getting Started

### Prerequisites
- Java Development Kit (JDK) 8 or higher
- Gradle (for gradle-based projects)
- IDE (IntelliJ IDEA recommended)

### Running the Projects

#### For Offline Assignments:
```bash
# Navigate to specific offline directory
cd offline1__2005114/src
javac Main.java
java Main

# For Offline 2 (Shake Shop)
cd Offline2_2005114/src
javac Shop.java
java Shop
```

#### For Online Design Pattern Examples:
```bash
# Navigate to specific pattern directory
cd CSE-308\(Online\)/adapter
javac Main.java
java Main

# For Gradle projects
cd CSE-308\(Online\)/builder
./gradlew run
```

## 📋 Assignment Details

### Offline 1: Banking System
- **Objective:** Implement a comprehensive banking system
- **Patterns Used:** Factory Method, Strategy
- **Key Features:** Multiple account types, employee management, transaction processing

### Offline 2: Shake Builder
- **Objective:** Implement Builder pattern for shake customization
- **Patterns Used:** Builder Pattern
- **Key Features:** Custom shake creation, ingredient management

### Offline 3: Multi-Problem Design Patterns
- **Objective:** Apply various design patterns to solve specific problems
- **Patterns Used:** Decorator, Composite, and others
- **Key Features:** File system modeling, passenger management

### Offline 4: Advanced Implementation
- **Objective:** Complex software architecture with multiple patterns
- **Patterns Used:** Multiple integrated patterns
- **Key Features:** Real-world application scenarios

## 📊 Load Testing

The repository includes JMeter-based load testing materials:
- `Load Testing with JMeter Online.pdf` - Testing methodology
- `Load Testing with JMeter Online (1)A1.pdf` - Advanced testing scenarios

## 🎓 Learning Outcomes

Through this coursework, students gain experience in:
- **Design Pattern Implementation** - Practical application of 23 GoF patterns
- **Software Architecture** - Structuring complex applications
- **Object-Oriented Design** - SOLID principles and best practices
- **Testing and Performance** - Load testing with JMeter
- **Documentation** - UML diagrams and technical documentation

## 👨‍💻 Student Information

- **Student ID:** 2005114
- **Course:** CSE 308 - Software Engineering Sessional
- **Institution:** BUET

## 📝 Notes

- All Java projects are configured for IntelliJ IDEA (`.iml` files included)
- Gradle wrapper scripts are included for Gradle-based projects
- UML diagrams are available in both `.drawio` and `.pdf` formats
- Class files are included for quick execution testing

## 🤝 Contributing

This repository is for educational purposes. If you're a fellow student:
- Feel free to learn from the implementations
- Please maintain academic integrity
- Don't directly copy code for your assignments

## 📞 Contact

For questions or clarifications regarding the implementations, please refer to course materials or contact through appropriate academic channels.

---

*This repository demonstrates practical implementation of software engineering principles and design patterns as part of the CSE 308 coursework.*
