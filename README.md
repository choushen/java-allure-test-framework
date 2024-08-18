# Selenium Test Automation Framework

A robust, scalable test automation framework built using Java, Selenium, and TestNG. This framework follows the Page Object Model (POM) pattern with Bill Pugh Singleton design, utilizing `ThreadLocal<WebDriver>` for thread-safe parallel test execution. It includes dynamic waits and reusable helper methods for efficient and reliable web application testing.

## Features

- **Page Object Model (POM):** Implements POM for maintainable and reusable code.
- **Bill Pugh Singleton Design:** Ensures thread-safe, lazy initialization of page objects.
- **ThreadLocal WebDriver:** Manages `WebDriver` instances per thread, enabling safe parallel test execution.
- **Dynamic Waits:** Supports customizable, reusable wait methods for flexible synchronization.
- **Parallel Execution:** Designed for running tests in parallel, reducing overall test execution time.
- **TestNG Integration:** Leveraging TestNG for test configuration, execution, and reporting.

## Planned Enhancements

- **Allure Reporting:** Integration with Allure for rich, visual test reports.
- **Dockerization:** Containerizing the test framework for consistent environment setup and easy scalability.
- **AWS Integration:** Utilizing AWS for cloud-based test execution and storage, ensuring scalability and reliability.
- **GitHub Actions:** Automating test runs and CI/CD pipelines using GitHub Actions.

## Getting Started

### Prerequisites

- **Java 11** or later
- **Maven 3.6.3** or later
- **TestNG**
- **Selenium WebDriver**

### Installation

1. Clone the repository:
    ```bash
    git clone https://github.com/yourusername/selenium-test-framework.git
    ```
2. Navigate to the project directory:
    ```bash
    cd selenium-test-framework
    ```
3. Install dependencies:
    ```bash
    mvn clean install
    ```
