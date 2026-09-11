# Sales Report Generator — User Guide & Technical Documentation

**Project:** Sales Report Generator  
**Repository:** https://github.com/Dulan-Vishwajith/Sales-Report-Generator  
**Course:** SENG 21222 – Software Construction  
**Assignment:** Assignment 1 – 2026

> This document is the user/setup guide and technical documentation. It does not contain individual student submission details.

---

## 1. Introduction

The **Sales Report Generator** is a command-line application developed for the SENG 21222 Software Construction Assignment 1. The application reads a CSV file containing daily product sales data, calculates a sales summary, and produces the report either on the console or in a text file.

The required command format is:

```text
java SalesReporter <csv-file-path> <output-method> [output-file-path]
```

Supported output methods:

- `console` — display the generated report in the terminal.
- `file` — save the generated report to a text file.

The assignment also requires unit testing, graceful error handling, and an extensible design using appropriate object-oriented and SOLID principles.

---

## 2. Assignment Requirements Relevant to the Application

The lecturer's instructions require:

1. An object-oriented programming language, with Java preferred.
2. Best coding practices, including clean code and SOLID principles.
3. A GitHub or Bitbucket repository.
4. A command-line sales report generator.
5. CSV input containing product sales data.
6. Revenue calculations and sales statistics.
7. Console or text-file output according to the command-line argument.
8. Unit tests.
9. Graceful handling of invalid input and file errors.
10. An extensible output design, such as an output strategy interface.
11. The CSV header row must be skipped when present.
12. Single Responsibility and Open-Closed principles should be applied where appropriate.

---

## 3. System Overview

### 3.1 Input

The application accepts a CSV file containing product sales records.

Required columns:

| Column | Description |
|---|---|
| `product_id` | Unique product identifier |
| `product_name` | Name of the product |
| `category` | Product category |
| `quantity_sold` | Quantity sold |
| `unit_price` | Price per unit |

Example:

```csv
product_id,product_name,category,quantity_sold,unit_price
P001,Wireless Mouse,Electronics,12,25.50
P002,Notebook,Stationery,35,3.75
P003,USB Hub,Electronics,8,18.00
P004,Ballpoint Pen,Stationery,100,0.50
P005,HDMI Cable,Electronics,20,12.00
```

### 3.2 Processing

For each record:

```text
product revenue = quantity_sold × unit_price
```

The application determines:

- Revenue per product
- Revenue per category
- Best-selling product
- Highest-revenue product
- Grand total revenue

### 3.3 Output

The report is either printed to the console or saved to a text file.

---

## 4. Downloading the Project from GitHub

### 4.1 Prerequisites

Install:

- Git
- Java Development Kit (JDK)

Check Git:

```bash
git --version
```

Check Java:

```bash
java -version
```

Check the Java compiler:

```bash
javac -version
```

---

## 5. Clone the GitHub Repository

Open a terminal or command prompt:

```bash
git clone https://github.com/Dulan-Vishwajith/Sales-Report-Generator.git
```

Then:

```bash
cd Sales-Report-Generator
```

The project contains the main source, test, and data directories together with IntelliJ project configuration.

---

## 6. Opening the Project

### IntelliJ IDEA

1. Open IntelliJ IDEA.
2. Select **Open**.
3. Select the cloned `Sales-Report-Generator` folder.
4. Allow the project to load.
5. Select a suitable JDK.
6. Wait for indexing/building to finish.

The repository contains:

```text
Sales-Report-Generator.iml
```

which is an IntelliJ IDEA module/project file.

### Command Line

The project can also be inspected and compiled from a terminal after confirming the Java version and the project's source structure.

Before running the program, identify the class containing the `main` method and confirm the required Java classpath/build setup.

---

## 7. Project Structure

The repository includes:

```text
Sales-Report-Generator/
├── .idea/
├── data/
├── src/
├── test/
├── .gitignore
└── Sales-Report-Generator.iml
```

### `src/`

Contains the application's source code.

### `data/`

Contains project data files used by the application and/or tests.

### `test/`

Contains automated tests.

The assignment requires, at minimum, tests for revenue calculation and best-seller detection.

### `.idea/`

Contains IntelliJ IDEA project configuration.

### `.gitignore`

Specifies files that Git should not track.

### `Sales-Report-Generator.iml`

IntelliJ IDEA module configuration.

---

## 8. CSV Input File

The CSV must contain:

```text
product_id
product_name
category
quantity_sold
unit_price
```

A header row may be included. If present, it must be skipped by the application.

Example:

```csv
product_id,product_name,category,quantity_sold,unit_price
P001,Wireless Mouse,Electronics,12,25.50
P002,Notebook,Stationery,35,3.75
P003,USB Hub,Electronics,8,18.00
P004,Ballpoint Pen,Stationery,100,0.50
P005,HDMI Cable,Electronics,20,12.00
```

### CSV Rules

- Keep the five required columns.
- Make sure every data row contains all required columns.
- Use valid numeric values for quantity and price.
- Check the CSV path before running the application.

---

## 9. Command-Line Usage

Required format:

```bash
java SalesReporter <csv-file-path> <output-method> [output-file-path]
```

### Input CSV Path

Example:

```text
data/sales.csv
```

### Output Method

Use:

```text
console
```

or:

```text
file
```

### Output File Path

Required only for `file`.

Example:

```text
output/report.txt
```

---

## 10. Console Output

Run:

```bash
java SalesReporter data/sales.csv console
```

The report should contain sections similar to:

```text
============================================
 PRODUCT SALES SUMMARY REPORT
============================================
--- Revenue Per Product ---
P001 Wireless Mouse Electronics $306.00
P002 Notebook Stationery $131.25
P003 USB Hub Electronics $144.00
P004 Ballpoint Pen Stationery $ 50.00
P005 HDMI Cable Electronics $240.00

--- Revenue Per Category ---
Electronics : $690.00
Stationery : $181.25

--- Highlights ---
Best-Selling Product : Ballpoint Pen (100 units)
Highest Revenue : Wireless Mouse ($306.00)
Grand Total Revenue : $871.25
============================================
```

The exact formatting can depend on the application's implementation.

---

## 11. File Output

Run:

```bash
java SalesReporter data/sales.csv file output/report.txt
```

The application should generate the report and save it to the specified output file.

Open the generated `.txt` file to view the report.

---

## 12. Report Calculations

### 12.1 Revenue Per Product

```text
Revenue = quantity_sold × unit_price
```

Example:

```text
12 × 25.50 = 306.00
```

### 12.2 Revenue Per Category

Add the revenue of every product belonging to the same category.

Example:

```text
Electronics:
306.00 + 144.00 + 240.00 = 690.00
```

### 12.3 Best-Selling Product

The best-selling product has the highest `quantity_sold`.

Example:

```text
Ballpoint Pen = 100 units
```

### 12.4 Highest-Revenue Product

The highest-revenue product has the largest calculated product revenue.

Example:

```text
Wireless Mouse = $306.00
```

### 12.5 Grand Total Revenue

The grand total is the sum of every product's revenue.

Example:

```text
306.00 + 131.25 + 144.00 + 50.00 + 240.00 = 871.25
```

---

## 13. Error Handling

The application should handle errors gracefully.

### CSV File Not Found

Example error style:

```text
Error: Input CSV file was not found.
```

### Missing Columns

Example:

```text
Error: CSV row has missing columns.
```

### Invalid Output Method

Use only:

```text
console
```

or:

```text
file
```

An invalid method should produce a clear error message and exit.

### Missing Output File Path

When `file` is selected, an output file path is required.

Correct:

```bash
java SalesReporter data/sales.csv file output/report.txt
```

Incorrect:

```bash
java SalesReporter data/sales.csv file
```

---

## 14. Unit Testing

The assignment requires unit tests.

At minimum, test:

### Revenue Calculation

Verify:

```text
quantity_sold × unit_price
```

Example:

```text
12 × 25.50 = 306.00
```

### Best-Seller Detection

Example:

```text
Wireless Mouse = 12
Notebook       = 35
Ballpoint Pen  = 100
```

Expected:

```text
Ballpoint Pen
```

Additional useful tests:

- category revenue
- grand total revenue
- highest revenue product
- missing input file
- invalid output method
- missing output path
- CSV header handling
- malformed rows

---

## 15. SOLID and Clean Code

### Single Responsibility Principle

Keep separate responsibilities for areas such as:

- CSV reading
- sales calculations
- report generation
- output handling
- command-line processing

### Open-Closed Principle

The application should be designed so a new output method can be added with minimal changes to existing business logic.

For example:

```text
console
file
```

could later be extended with another output strategy.

An interface/strategy-based design is suitable for this requirement.

### Clean Code

Use:

- meaningful names
- focused methods
- appropriate access modifiers
- minimal duplicated logic
- clear error messages
- consistent formatting

---

## 16. Typical User Workflow

```text
1. Install Git and Java
        ↓
2. Clone the GitHub repository
        ↓
3. Open the project
        ↓
4. Prepare the CSV file
        ↓
5. Run the application
        ↓
6. Select console or file output
        ↓
7. Review the generated report
```

Example:

```bash
git clone https://github.com/Dulan-Vishwajith/Sales-Report-Generator.git
cd Sales-Report-Generator
java SalesReporter data/sales.csv console
```

Or:

```bash
java SalesReporter data/sales.csv file output/report.txt
```

---

## 17. Troubleshooting

### Java is not recognized

Run:

```bash
java -version
```

Install/configure a JDK if Java is unavailable.

### CSV file not found

Check:

- file name
- file path
- current working directory
- relative vs absolute path

### Invalid output method

Use:

```text
console
```

or:

```text
file
```

### File output fails

Check:

- `file` is used as the output method
- an output path is supplied
- the destination directory exists or is supported by the implementation
- the application has permission to write there

### Incorrect report values

Check:

- quantity values
- unit prices
- category names
- missing fields
- CSV header
- separators

---

## 18. GitHub Repository

Official repository:

https://github.com/Dulan-Vishwajith/Sales-Report-Generator

The repository includes the project's source, test, and data directories and its Git history.

For the assignment, each group member should commit their own contribution as required by the lecturer.

---

## 19. Quick Reference

### Clone

```bash
git clone https://github.com/Dulan-Vishwajith/Sales-Report-Generator.git
```

### Enter directory

```bash
cd Sales-Report-Generator
```

### Console output

```bash
java SalesReporter <csv-file-path> console
```

### File output

```bash
java SalesReporter <csv-file-path> file <output-file-path>
```

### Example

```bash
java SalesReporter data/sales.csv console
```

```bash
java SalesReporter data/sales.csv file output/report.txt
```

---

## 20. Reference

This documentation is based on the lecturer's **SENG 21222 – Software Construction Assignment 1 – 2026** instructions and the project's GitHub repository.

The assignment specifies the command-line interface, CSV fields, required calculations, expected report information, unit testing, error handling, SOLID principles, and submission requirements.
