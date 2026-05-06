[![Open in Codespaces](https://classroom.github.com/assets/launch-codespace-2972f46106e565e64193e422d61a12cf1da4916b45550586e14ef0a7c637dd04.svg)](https://classroom.github.com/open-in-codespaces?assignment_repo_id=23509008)
# AP Computer Science A – Final Project
## Software & Systems Development Capstone

Sleep Tracker App
Project Description

This program helps users track their sleep habits and improve their sleep schedule. The user enters when they go to sleep, when they wake up, and how rested they feel. The program stores this data, analyzes patterns, and provides both instant feedback and long term recommendations based on age and behavior. This project stands out because it combines user input, data tracking, and personalized suggestions in a simple console based app.

Features
Menu driven interface for easy navigation
Input sleep and wake times
Calculate total hours slept
Daily rest rating system
Instant feedback after each entry
Stores up to 7 days of sleep data
View sleep history and averages
Personalized recommendations based on age
Detects inconsistent sleep patterns
Input validation to prevent errors
Code Structure and Design

The program uses three main classes:

App
Handles user interaction, menu system, and program flow
User
Stores personal data such as age, height, and weight
Suggestion
Contains logic for instant feedback and long term recommendations

Objects interact through method calls. The App class collects data and passes it to the Suggestion class for analysis. The User object provides age data for personalized recommendations.

Data is stored using arrays. These arrays track sleep times, wake times, hours slept, and rest ratings over multiple days.

No inheritance or interfaces are used. The design focuses on clear separation of responsibilities between classes.

UML Diagram
The UML diagram should be added here as an image file in your project folder.

How to Run the Program
Make sure all files are in the same folder
App.java
User.java
Suggestion.java
Compile the program
javac App.java
Run the program
java App
Follow the menu options
Enter sleep data
View history
Get recommendations
View user info
Exit
Input rules
Sleep and wake time must be between 0 and 23
Rest rating must be between 1 and 5
Development Process

One challenge was organizing the code as it became more complex. The program started in one class and became harder to manage. This was solved by separating logic into methods and creating new classes for user data and suggestions.

One improvement would be storing more than 7 days of data using dynamic structures like ArrayLists and adding a graphical interface.

Use of AI Tools

ChatGPT was used to help brainstorm features, structure the program, and debug code. It was also used to refactor code into cleaner methods and improve readability. All code was reviewed, tested, and fully understood before being used in the final project.

Author Information

Name: Krishan Avila
Course: AP Computer Science A

This project helped build skills in organizing code, handling user input, and designing programs with multiple classes.
