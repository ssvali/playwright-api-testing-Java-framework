## _Playwright API Testing Java Automation Framework_

![Open Source Love](https://badges.frapsoft.com/os/v1/open-source.svg?v=103)

## Don't forget to give a :star: to make the project popular.

This repository contains an advanced test automation framework built using Playwright API Testing for Java.
It supports parallel execution, configurable environments, runtime system variable overrides, and integrates Allure reporting for rich, interactive test results.

## 🚀 Features

### ✔ Parallel Test Execution

Configured via Maven Surefire/Failsafe to run tests in parallel, significantly reducing execution time.

### ✔ Flexible Configuration

The framework loads values from:

    config.properties (default)
    System variables passed via CLI or CI
    Environment variables
    Supported variables include:

    Variable	Description
    base.url	URL of application under test
    username	Login username
    password	Login password

### ✔ Allure Reporting

Integrated with Allure to generate modern, interactive HTML reports.

### 🧪 Running Tests
✔️ Run Smoke Suite

    mvn clean test -Psmoke -Denv=DEV

✔️ Run Regression Suite

    mvn clean test -Pregression -Denv=DEV

✔️ Run Booking Suite (feature-specific)

    mvn clean test -Pbooking -Denv=DEV

### 🧵 Parallel Execution

Parallel execution is configured through Maven.

You can adjust threads based on CPU and CI capacity.

📊 Allure Reporting

Generate and view the Allure report after test execution:

Serve interactive report
allure serve target/allure-results

Generate static HTML report
allure generate target/allure-results -o target/allure-report --clean

### 🧰 Tech Stack
| Component                 | Version | Purpose                        |
| ------------------------- | ------- | ------------------------------ |
| **Java**                  | 17      | Language                       |
| **Maven**                 | —       | Build & dependency management  |
| **Playwright (Java)**     | 1.49.0  | API & browser automation       |
| **TestNG**                | 7.10.2  | Test runner                    |
| **Allure Report**         | 2.27.0  | Test reporting                 |
| **Gson**                  | 2.11.0  | JSON serialization             |
| **Lombok**                | 1.18.30 | Boilerplate reduction          |
| **DataFaker**             | 2.4.0   | Test data generation           |
| **JSON Schema Validator** | 1.0.77  | Response schema validation     |
| **AspectJ**               | 1.9.21  | For Allure listeners / weaving |

### 🧪 TestNG Suite Profiles
| Profile      | Suite File                | Purpose          |
| ------------ | ------------------------- | ---------------- |
| `smoke`      | test-suite/smoke.xml      | Quick checks     |
| `regression` | test-suite/regression.xml | Full coverage    |
| `booking`    | test-suite/booking.xml    | Feature-specific |

