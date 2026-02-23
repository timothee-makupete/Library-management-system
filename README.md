# Library Management System

A Java-based desktop application for managing library book inventory with a graphical user interface.

## Overview

This Library Management System provides a comprehensive solution for managing books in a library setting. Built with Java Swing, it offers an intuitive GUI for librarians to add, view, search, and manage book collections efficiently.

## Features

- **Book Management**: Add, remove, and update book information
- **Search Functionality**: Search books by title, author, or ISBN
- **Inventory Tracking**: Monitor available copies and total copies
- **Data Persistence**: Stores book data in text file format
- **User-Friendly GUI**: Modern interface with theme switching capabilities
- **Book Details View**: Comprehensive book information display

## Project Structure

```
Library-management-system/
├── src/
│   ├── Book.java              # Book entity class
│   ├── Library.java           # Library management class
│   └── Library_gui.java       # Main GUI application (1279 lines)
├── resources/                 # UI assets and images
│   ├── *.png                  # Various icons and images
│   └── ch8.ppt               # Presentation file
├── books.txt                  # Book database storage
├── .gitignore                 # Git ignore rules
└── README.md                  # This file
```

## Core Classes

### Book.java
Entity class representing a book with the following attributes:
- Author, Title, ISBN
- Publication Year
- Total Copies and Available Copies
- Methods for managing copy counts

### Library.java
Main library management class that:
- Maintains a collection of books
- Provides add/remove book functionality
- Uses ArrayList for book storage

### Library_gui.java
Comprehensive Swing-based GUI application featuring:
- Main dashboard with navigation
- Add book form with validation
- Book search and display
- Theme switching capability
- Settings panel
- Multiple panels for different operations

## Data Storage

Books are stored in `books.txt` in CSV format:
```
Author,Title,ISBN,PublicationYear,TotalCopies
```

Sample data includes classics like "Beloved" by Toni Morrison, "Harry Potter" by J.K. Rowling, and many others.

## Requirements

- Java Development Kit (JDK) 8 or higher
- Java Swing library (included with JDK)

## How to Run

1. Compile the Java files:
   ```bash
   javac src/*.java
   ```

2. Run the application:
   ```bash
   java -cp src Library_gui
   ```

## Usage

1. **Launch the application** to see the main dashboard
2. **Add Books**: Use the "Add Book" button to add new books to the library
3. **View Books**: Browse the complete book collection
4. **Search**: Use the search functionality to find specific books
5. **Manage**: Remove books or update their information
6. **Settings**: Customize the application theme and preferences

## Technical Details

- **Language**: Java
- **GUI Framework**: Java Swing
- **Data Storage**: Text file (CSV format)
- **Architecture**: Object-oriented design with MVC-like separation
- **IDE Support**: IntelliJ IDEA project file included

## Contributing

Feel free to fork this project and submit pull requests for improvements or new features.

## License

This project is open source and available under the MIT License.

