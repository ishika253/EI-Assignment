Exercise 1: Problem Statement on Design patterns

1. Two use cases to demonstrate two behavioural design pattern
1.1 What are behavioral deign patterns?
Behavioral Patterns are concerned with algorithms and the assignment of responsibilities between objects. Behavioral patterns describe not just patterns of objects or classes but also the patterns of communication between them. 
These patterns characterize complex control flow that’s difficult to follow at run-time.

1.2 Usecase 1: Mediator Pattern
UseCase: Design a chatroom application where users can send messages to each other, and the chatroom handles message delivery.

How to demonstrate: Use the Mediator pattern where a central chatroom object handles communication between users. Users don’t communicate directly with each other but send their messages to the chatroom, which then forwards them to the intended recipient. This reduces the complexity of managing direct interactions between users.

Project Directories:
1)Chatroom
1.1 ChatRoomClient.java
1.2 ChatRoomClient1.java
1.3 ChatRoomServer.java

How it Works?
Server:The server listens for client connections on a specific port (12345).
When a client connects, the server handles the client in a separate thread.
Messages from clients are broadcasted to all connected clients with a timestamp.

Client:Each client connects to the server by specifying the IP address (localhost in this case) and port.
The client can send messages to the server, and these are broadcasted to all connected clients.
The client receives and displays messages from other clients with a timestamp.

Files Structure
ChatRoomServer.java: The server-side code that handles client connections and broadcasts messages.
ChatRoomClient.java: The client-side code that connects to the server, sends messages, and receives messages from others.
ChatRoomClient1.java: The other client-side that connects with other client to get a interaction

OUTPUT:
[Alice]: Hello Bob!
[Bob]: Hi Alice! How are you?
[Alice]: I'm good, thanks!

Features
Real-time message broadcasting.
Messages are formatted with timestamps and sender names.
Multiple clients can join and chat simultaneously.

1.3 Usecase 2: Template Pattern
1.3.1: Usecase:The system models the order processing workflow for different types of orders, such as Store Pickup Orders and Online Orders. The process includes steps like selecting items, making payments, and handling delivery. The core structure of the process is shared, but the individual steps can be customized for different order types.

Key Components:
Template Method: The main process is defined in the base class and remains unchanged.
Abstract Methods: These methods must be implemented by subclasses to provide specific behavior.
Optional Methods: The base class can define optional methods that can be overridden by subclasses if necessary.

Structure
Base Class (OrderProcessTemplate): Contains the main process logic, including an optional step for gift-wrapping.
Subclasses (StorePickupOrder, OnlineOrder): Implement specific steps of the order process such as selecting items, making payments, and delivering or picking up the order.

Project Directories
├── Main.java
├── OrderProcessTemplate.java
├── StorePickupOrder.java
├── OnlineOrder.java
└── README.md

How It Works
The base class OrderProcessTemplate defines the order flow in the processOrder() method:

doSelect(): Abstract method for item selection.
doPayment(): Abstract method for making the payment.
doDelivery(): Abstract method for handling delivery or pickup.
wrapGift(): Optional step for wrapping the order if it is a gift.
The subclasses StorePickupOrder and OnlineOrder provide concrete implementations of these methods, specifying the behavior for store pickup and online orders, respectively.

Output

Customer selects items from store.
Customer pays at the counter during store pickup.
Customer collects the items from the pickup counter.
------
Customer selects items from the website.
Online payment through net banking or card.
Gift wrapped.
Items are delivered to the customer's address.

Conclusion
This implementation of the Template Method Design Pattern helps in structuring a flexible order processing system that can handle various order types like store pickups and online orders while keeping the common workflow intact. The pattern ensures that the structure is reusable and scalable for future order types.

2. Two use cases to demonstrate two creational design pattern.
2.1 What are Creational Design Patterns?
Creational design patterns abstract the instantiation process. They help make a system independent of how its objects are created, composed, and represented. A class creational pattern uses inheritance to vary the class that’s instantiated, whereas an object creational pattern will delegate instantiation to another object.

2.1.1: UseCase 1: ConnectionDatabasePool
Component Descriptions

ConnectionPool.java:
Manages a pool of reusable database connections.
Implements methods to acquire and release connections.
Ensures connections are available in the pool, creating new ones if necessary.

DatabasePool.java:
Acts as an abstract base class or interface defining pool management operations.
Provides basic functionality to create, manage, and terminate database connections.

MySQLConnection.java:
Specific implementation of database connections for MySQL.
Manages the connection details, including driver setup, connection string, and login credentials.

Main.java:
Entry point for the application.
Demonstrates how to initialize and use the ConnectioDatabasePool.

2.1.2 : Usecase2 : Prototype Pattern
UseCase:Document Cloning System
The Document Cloning System demonstrates the Prototype Pattern in Java, allowing users to clone existing documents with slight modifications instead of creating new instances from scratch. This application provides a simple user interface for uploading text documents, cloning them, and viewing or downloading the modified versions.

Features
Upload Document: Users can upload a text document to the application.
Clone Document: After uploading, users can clone the document, making modifications to the cloned content.
Display Document: The original and cloned documents are displayed in the user interface.

Technology Used
Java
Java Swing (for the GUI)
Prototype Design Pattern

Project Structure
src/
│
├── Document.java                  # Interface for cloning and printing details
├── TextDocument.java               # Class implementing Document interface
├── PrototypePatternDemo.java       # Main class to test the prototype pattern

Example
Original Document:

Title: Original Document
Content: This is the original content.
Cloned Document:

Title: Cloned Document
Content: This is the modified content of the cloned document.

3.  Two use cases to demonstrate two structural design pattern
3.1 What are structural design patterns?
Structural Design Patterns are concerned with how classes and objects are composed to form larger structures. Structural class patterns use inheritance to compose interfaces or implementations.

3.1.1: Usecase1: Document builder
 Features

Flexible Document Structure: Users can add multiple sections to the report.
Simple API: The Builder pattern provides a fluent interface for building documents.
Readable Output: The generated reports are well-structured and easy to read

The application consists of the following main classes:

Report: Represents the complex document with attributes like title, author, and sections.
Main: Demonstrates the usage of the Builder pattern to create and display a report.


Prerequisites

- Java Development Kit (JDK) installed (version 8 or higher recommended).
- A text editor or an Integrated Development Environment (IDE) for Java.

OUTPUT: 
Title: Annual Financial Report
Author: John Doe

Sections:
Executive Summary
Financial Overview
Future Projections
Conclusion

3.1.2 : UseCase2: notificationfactory
This project implements a Notification System in Java using the Factory Method Design Pattern. It allows users to send notifications via Email, SMS, and Push notifications based on their preferences.

Directory Structure
Make sure your files are organized like this:
notificationfactory/
    ├── Notification.java
    ├── EmailNotification.java
    ├── SMSNotification.java
    ├── PushNotification.java
    ├── NotificationFactory.java
    └── Main.java

How It Works
Notification Interface: Defines a method for sending notifications.
Concrete Classes: Implement the interface for Email, SMS, and Push notifications.
Factory Class: Contains a method to create the right notification type based on user input.
Main Class: Uses the factory to send different types of notifications.

OUTPUT: 
Sending Email: Hello via Email!
Sending SMS: Hello via SMS!
Sending Push: Hello via Push!

Exercise 2: Rocket Launch Simulator Programming Exercise

Problem Statement: You are to build a terminal-based Rocket Launch Simulator. The goal is to simulate a rocket launch that places a satellite into orbit, while providing real-time updates to the user. The simulator will operate in discrete time steps, each representing one second of the mission.

Features

-Pre-Launch Checks: Verify system readiness before launch.
-Launch: Start the rocket launch simulation.
-Fast Forward: Advance the simulation by a specified number of seconds.
-Real-Time Updates: Display the rocket's fuel, altitude, and speed every second.
-Stage Separation: Handle multiple stages of the rocket.
-Mission Success/Failure Messages: Indicate when the mission is successful or if it fails due to insufficient fuel.

# Commands

-start_checks: Initiate pre-launch system checks.
-launch: Begin the rocket launch after successful checks.
-fast_forward X: Advance the simulation by X seconds.
-exit: Exit the simulator.

## Installation

Example Usage
After starting the simulator, you will see a prompt to enter commands. Here’s an example of how to interact with the simulator:

Start Checks:
Enter command (start_checks, launch, fast_forward X, or exit):
start_checks
Performing pre-launch checks...
All systems are 'Go' for launch.

Launch:
launch
Launching the rocket!
Stage: 1, Fuel: 100%, Altitude: 0 km, Speed: 0 km/h

Fast Forward:
fast_forward 10
Fast forwarding by 10 seconds.
Stage: 1, Fuel: 90%, Altitude: 100 km, Speed: 10000 km/h

Exit:
exit
Exiting simulator.

Error Handling
The simulator includes logging and exception handling to manage potential issues during operation, such as invalid commands and transient errors during flight.

Directory Structure
RocketLaunchSimulator/
├── Main.java
├── FlightSimulator.java
├── utils/
│   └── LoggerUtil.java
└── stages/
    └── StageHandler.java

Console Output
Pre-Launch Checks: "All systems are 'Go' for launch."
Each Second of Flight: "Stage: 1, Fuel: 90%, Altitude: 10 km, Speed: 1000 km/h"
Stage Separation: "Stage 1 complete. Separating stage. Entering Stage 2."
Orbit Placement: "Orbit achieved! Mission Successful."
Mission Failure: "Mission Failed due to insufficient fuel."






