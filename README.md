# Java Text Cleaner

A lightweight, real-time desktop application built with Java Swing that formats and cleans text. It is particularly useful for stripping out repetitive metadata (like Kindle-style highlights and page numbers) and fixing messy spacing from copied text.

## Features

* **Real-Time Processing:** Text is cleaned instantly as you type or paste it into the application—no "Process" button required.
* **Kindle/E-Book Cleanup:** Automatically detects and removes lines matching metadata patterns like `Highlight ... Page X`.
* **Smart Spacing:** Consolidates excessive consecutive line breaks (3 or more) down to a clean double line break (`\n\n`) and trims trailing whitespace.
* **Dual-Pane UI:** A split-screen window allows you to view your raw input and cleaned output side-by-side.
* **Convenience Actions:** Quick-action buttons to clear all input text or copy the cleaned output directly to your system clipboard.

---

## Project Structure

The project follows a clean separation of concerns, decoupling the user interface from the text-processing logic.

```text
src/
├── Main.java                 # Application entry point
├── logic/
│   ├── TextCleaner.java       # Interface defining the text cleaning contract
│   └── DefaultTextCleaner.java# Implementation containing Regex cleaning logic
└── ui/
    └── MainWindow.java        # Java Swing GUI layout and event listeners
