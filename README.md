# Casper - Task Manager

**Casper** is a task management application designed to help students organize their work efficiently. It includes features such as a task manager, digital diary, audio notebook, wallet for managing expenses, and a week planner for group projects and other activities.

## Table of Contents

1. [Introduction](#introduction)
2. [Features](#features)
3. [Prerequisites](#prerequisites)
4. [Installation](#installation)
5. [Deployment](#deployment)
6. [Usage](#usage)
7. [Contributing](#contributing)
8. [License](#license)

## Introduction

Casper is a productivity tool built for students to manage their academic and personal tasks. It integrates multiple features to keep track of tasks, notes, expenses, and schedules in one place. With Casper, students can efficiently organize their daily activities, manage finances, and maintain an audio-visual record of their thoughts and tasks.

## Features

- **Task Manager**: Organize and prioritize tasks to stay on top of your work.
- **Digital Diary**: Keep a digital record of important events, thoughts, and reflections.
- **Audio Notebook**: Add audio notes alongside written ones for better recall.
- **Expense Manager**: Track income and expenses for better financial management.
- **Week Planner**: Plan your week by scheduling group activities and individual tasks.

## Prerequisites

Before you begin, ensure you have the following installed:

- **Java 8 or higher**
- **XAMPP** (for local database management)
- **MySQL** (installed and running in XAMPP)
- A suitable **IDE** (e.g., IntelliJ IDEA, Eclipse)

## Installation

### 1. Clone the Repository

First, clone the repository to your local machine:

```bash
git clone https://github.com/Sahasvinandith/Casper--Task-manager
```

### 2. Set Up the SQL Database

1. Open your XAMPP control panel.
2. Start the MySQL service to enable the database server.

### 3. Configure the Database Connection

1. Navigate to the `ddashbrd/src/com/raven/main/Main.java` file.
2. Open the `Main.java` file.
3. In the file, find the database connection section and add your root password to the `dbpassword` variable.

### 4. Run the Application

Once the above steps are completed, you can run the application by executing the `Main.java` file in your IDE.

## Usage

Once the application is deployed, you can start using its various features such as:

- Creating and managing tasks in the **Task Manager**.
- Adding entries and organizing notes in the **Digital Diary**.
- Recording audio notes in the **Audio Notebook**.
- Tracking financial activities through the **Expense Manager**.
- Scheduling and planning your week with the **Week Planner**.

## Contributing

We welcome contributions to Casper! To contribute:

1. Fork the repository.
2. Create a new branch for your feature or bug fix.
3. Make your changes.
4. Open a pull request with a description of the changes.