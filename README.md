
# REST Assured API Automation Framework

## Table of Contents
- [Introduction](#introduction)
- [Technology Stack](#technology-stack)
- [Prerequisites](#prerequisites)
- [Project Setup](#project-setup)
- [Framework Architecture](#framework-architecture)
- [How to Run Tests](#how-to-run-tests)
- [Logging and Debugging](#logging-and-debugging)
- [Reporting](#reporting)
- [Data Management](#data-management)
- [Continuous Integration - Jenkins](#continuous-integration---jenkins)
- [Code Quality & Best Practices](#code-quality--best-practices)
- [Branching and Versioning Strategy](#branching-and-versioning-strategy)
- [Contributing](#contributing)
- [Contact](#contact)
- [License](#license)

---

## Introduction
This framework is a robust, scalable, and maintainable API automation solution built with **REST Assured** on **Java**. It employs proven enterprise-grade tools for test orchestration, logging, reporting, and CI/CD integration to ensure end-to-end quality validation of RESTful APIs.

This repository is designed to facilitate:
- Automation of functional, validation, and regression API tests.
- Data-driven testing using Excel.
- Execution in multiple environments with configurable properties.
- Detailed logging and rich test reports.
- Seamless integration with Jenkins for automated pipelines.

---

## Technology Stack

| Technology       | Description                                        |
|------------------|----------------------------------------------------|
| Java 11+          | Core programming language                           |
| REST Assured      | API testing framework                               |
| TestNG           | Test orchestration and suites                        |
| Maven            | Build and dependency management                      |
| Log4j2           | Advanced logging framework                           |
| Allure           | Test execution and customization reporting          |
| Apache POI       | Excel reading/writing for data-driven testing       |
| Jenkins          | Continuous Integration and automated scheduling     |

---

## Prerequisites

- Java JDK 11 or higher installed and configured (`JAVA_HOME`)
- Maven 3.6+ installed and available in the system path
- Git client installed for source control
- Jenkins server (optional, for CI pipelines)
- Internet access for Maven dependency downloads or internal artifact proxy setup (e.g., Nexus)

---

## Project Setup

1. **Clone the repository**
   git clone https://github.com/your-org/your-repo.git
   cd your-repo



2. **Build the project and download dependencies**
   mvn clean install



3. **Configure environment variables**
- Update environment-specific properties in `src/test/resources/config/` (e.g., `dev.properties`, `qa.properties`)
- Set your active environment profile by passing as a Maven parameter or using a `.env` file

---

## Framework Architecture

The framework follows the **Page Object Model (POM)** pattern adapted for APIs to separate requests, test data, and utility code.

src/
├── main/
│ └── java/
│ ├── base/ # Base classes (BaseTest, BaseRequest, etc.)
│ ├── config/ # Config reader & environment setup
│ ├── logger/ # Log4j2 utilities
│ ├── utils/ # Utility classes (API utilities, excel utils)
│ └── models/ # POJO classes for request/response mapping
├── test/
│ └── java/
│ ├── tests/ # TestNG test classes (organized by API modules)
│ └── listeners/ # TestNG listeners for reporting and retries
├── resources/
├── config/ # Environment property files
├── testdata/ # Excel sheets and other external test data
├── log4j2.xml # Log4j2 configuration
└── testng.xml # TestNG suite configuration



---

## How to Run Tests

### Running all tests locally

From project root directory run:

mvn clean test



### Running specific TestNG Suite

Specify the suite XML:

mvn clean test -DsuiteXmlFile=src/test/resources/testng.xml



### Running tests for a specific group/tag

Use TestNG groups to categorize tests:

mvn clean test -Dgroups="smoke"



### Running tests with environment parameter

You can override environment properties like this:

mvn clean test -Denv=qa



The framework will load `qa.properties` for endpoint URLs, credentials, and other configurations.

### Parallel Execution

Configure parallelism in `testng.xml` by setting `parallel` and `thread-count` attributes.

---

## Logging and Debugging

- Built-in **Log4j2** logging captures detailed request and response info.
- Logs are segregated by test execution dates in the `/logs` directory.
- Log levels (`INFO`, `DEBUG`, `ERROR`) can be configured in `log4j2.xml`.
- Enable DEBUG mode for deeper insights into headers, payloads, query params, and test steps.

Example log snippet:

INFO [BaseTest] - Starting API test: getUserDetails
DEBUG [RestClient] - GET https://api.example.com/users/123
DEBUG [RestClient] - Response status: 200 OK
DEBUG [RestClient] - Response body: {...}


---

## Reporting

- The framework integrates **Allure Reports** providing interactive and visual results dashboards.
- Generate and serve Allure report locally post-test:

mvn allure:serve



- Reports include detailed test steps, request/response details, attachments (screenshots/files), and failure analysis.
- Jenkins publishes the same Allure reports post build execution.

---

## Data Management

- Data-driven tests support Excel files via **Apache POI**.
- Test data files are located under `src/test/resources/testdata/`.
- Excel sheets support multiple test scenarios using rows as data sets.
- Data provider classes convert sheets to Java Object arrays for parameterized testing.

---

## Continuous Integration - Jenkins

- Jenkins pipeline fetches the latest code using Git SCM plugin.
- Executes Maven goals: `clean test` with parameters for environment.
- Post build steps:
    - Archive test results (TestNG, Surefire XML)
    - Publish Allure Report plugin result
    - Trigger notifications (Slack/Email) on failures or unstable builds
- Jenkinsfile (declarative pipeline script) is included at the root for reference.

Sample Jenkins pipeline stages:
- **Checkout**
- **Build & Dependency Resolution**
- **Execute Tests**
- **Publish Reports**
- **Notify**

---

## Code Quality & Best Practices

- Follow SOLID principles for modular, reusable code.
- Use descriptive test method names with `@Test(description=...)` in TestNG.
- Keep API endpoints and payloads externalized in config and model files.
- Use assertions with clear failure messages using TestNG and Hamcrest matchers.
- Implement retry logic and listeners to handle flaky tests gracefully.
- Regularly update dependencies and plugin versions via Maven.
- Use proper exception handling with custom error messages.

---

## Branching and Versioning Strategy

- Use **GitFlow** or a similar branching model:
    - `main` branch for stable releases
    - `develop` for integration and ongoing developments
    - Feature branches for new test modules or enhancements
- Version your releases via `pom.xml` and Tagging in Git.

---

## Contributing

We welcome contributions following these steps:

1. Fork the repository
2. Create a local branch with a descriptive name:

git checkout -b feature/your-feature-name


3. Commit your changes with meaningful commit messages.
4. Push your branch to your forked repo:

git push origin feature/your-feature-name


5. Raise a pull request against the `develop` branch.
6. Follow coding standards and update the documentation/tests if applicable.
7. Participate in code reviews constructively.

---

## Contact

For support, questions or suggestions, contact:

**Name:** Your Name  
**Email:** your.email@example.com  
**LinkedIn:** linkedin.com/in/your-profile

---

## License

This project is licensed under the **MIT License** — see the [LICENSE](LICENSE) file for details.

---