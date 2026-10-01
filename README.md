# 🌐 Personal Portfolio Website

A responsive personal portfolio website showcasing my professional experience, technical skills, projects, and QA automation work.

This project is also used as a hands-on **Software Testing, Automation, CI/CD, and DevOps learning project**, where the website itself acts as the application under test.

**Version:** v2.0  
**Status:** Active Development 🚀

---

## 📌 Overview

This portfolio started as a simple static website and has evolved into a QA automation and CI/CD project.

The project demonstrates:

- Git & GitHub
- Web development fundamentals
- Selenium WebDriver automation
- TestNG test organization
- Maven test execution
- Jenkins CI/CD pipeline
- GitHub Actions
- Automated FTP deployment
- Smoke testing
- Regression testing
- Automated test reporting
- Public test report publishing
- CI/CD quality gates

The long-term goal is to evolve this project into a complete **modern QA engineering demonstration project**, including Playwright automation, code quality checks, performance testing, and improved reporting.

---

## ✨ Website Features

- Responsive design
- Modern UI with Bootstrap 5
- Animated sections
- Resume download
- Contact section
- Smooth scrolling navigation
- Mobile-friendly layout
- Social media links
- Projects and automation documentation
- Public QA automation report

---

## 🧪 QA Automation

The portfolio is tested using **Selenium WebDriver with Java and TestNG**.

### Smoke Tests

Smoke tests validate the critical functionality of the website before deployment.

Current smoke coverage includes:

- Homepage availability
- Navigation
- Email link
- Resume download
- Footer year

### Regression Tests

Regression testing validates the broader functionality of the website after deployment.

Current regression coverage includes:

- Homepage
- Navigation
- Email
- Resume
- Footer year
- GitHub link
- LinkedIn link
- Instagram link
- X/Twitter link

The regression suite currently includes failing scenarios to demonstrate how test failures are captured and reported without preventing the reporting stage from executing.

---

## 🛠️ Tech Stack

### Website

- HTML5
- CSS3
- JavaScript (ES6)
- Bootstrap 5
- Font Awesome

### Automation

- Java
- Selenium WebDriver
- TestNG
- Maven

### CI/CD

- Jenkins
- GitHub Actions
- Git
- GitHub
- FTP Deployment

### Hosting

- InfinityFree

---

## 📂 Project Structure
text
portfolio/
│
├── assets/
│   ├── css/
│   ├── js/
│   ├── images/
│   └── docs/
│
├── src/
│   ├── main/
│   │   └── java/
│   │       ├── driver/
│   │       └── pages/
│   │
│   └── test/
│       ├── java/
│       │   ├── base/
│       │   └── smoke/
│       │
│       └── resources/
│           ├── testng-smoke.xml
│           └── testng-regression.xml
│
├── index.html
├── pom.xml
├── Jenkinsfile
├── README.md
└── .gitignore
🔄 CI/CD Pipeline

The project uses Jenkins as the main pipeline orchestrator.

The current workflow is:

Developer pushes code
        │
        ▼
     GitHub
        │
        ▼
     Jenkins
        │
        ▼
   Smoke Tests
        │
     PASS?
      /   \
    NO     YES
    │       │
    │       ▼
    │   GitHub Actions
    │       │
    │       ▼
    │   FTP Deployment
    │       │
    │       ▼
    │   InfinityFree
    │       │
    │       ▼
    │ Regression Tests
    │       │
    │       ▼
    │  TestNG Report
    │       │
    │       ▼
    │ Public Report
    │
    └── Pipeline stops
Pipeline Stages
1. Smoke Tests

Jenkins executes the TestNG smoke suite.

Deployment proceeds only when the smoke suite passes.

2. Deployment

Jenkins triggers the GitHub Actions deployment workflow.

GitHub Actions deploys the website to InfinityFree using FTP.

3. Regression Tests

After deployment, Jenkins executes the regression suite against the deployed website.

Regression failures are recorded without preventing the reporting stage from running.

4. Test Reporting

TestNG/Surefire generates the test report.

Jenkins publishes the test results and uploads the generated report files to the website.

Latest Public Report

View Latest Test Report

🚀 Deployment

Deployment is handled through GitHub Actions.

The workflow is intentionally configured for manual workflow dispatch rather than automatic deployment on every push.

This allows Jenkins to act as the quality gate before deployment.

Deployment Flow
Jenkins Smoke Tests
        │
        ▼
       PASS
        │
        ▼
GitHub Actions Workflow
        │
        ▼
FTP Deployment
        │
        ▼
InfinityFree

GitHub Actions uses repository secrets for the FTP credentials.

🧪 Running Tests Locally
Prerequisites
Java
Maven
Chrome / supported browser
Git
Clone the Repository
git clone https://github.com/sanskarchandak/portfolio.git

Navigate to the project:

cd portfolio
Run Smoke Tests
mvn test "-Dsurefire.suiteXmlFiles=src/test/resources/testng-smoke.xml"
Run Regression Tests
mvn test "-Dsurefire.suiteXmlFiles=src/test/resources/testng-regression.xml"
📊 Test Reports

TestNG/Surefire generates reports under:

target/surefire-reports/

The generated report can be viewed locally after test execution.

The latest regression report is also published publicly:

View Latest Report

📈 Project Roadmap

This project is being developed incrementally, with each phase adding a new layer to the portfolio and QA engineering workflow.

✅ Completed
Version 1.0 — Portfolio Website
Responsive Portfolio
Resume Download
Contact Section
Responsive UI
Bootstrap integration
Version 1.1 — Source Control & Documentation
Git Repository
GitHub Integration
Project Documentation
Branch Management
.gitignore
Version 1.2 — Selenium Automation
Selenium WebDriver
Java Automation
Page Object Model
DriverFactory
BaseTest
TestNG
Maven
Smoke Test Suite
Regression Test Suite
TestNG XML Suites
Version 1.3 — CI/CD & Deployment
Jenkins Pipeline
Jenkins + GitHub Integration
Automated Smoke Testing
Smoke Test Quality Gate
GitHub Actions
Automated FTP Deployment
Post-Deployment Regression Testing
Version 1.4 — Test Reporting
TestNG/Surefire Reports
Jenkins JUnit Result Publishing
Regression Failure Handling
Public Test Report Publishing
Latest Report Linked from Portfolio
🔮 Planned
Version 2.0 — Playwright Automation
Migrate Selenium tests to Playwright
Compare Selenium vs Playwright
Browser automation improvements
Parallel test execution
CI/CD integration
Version 2.1 — Code Quality & Validation
HTML Validation
CSS Validation
JavaScript Linting
Java Code Quality
Static Analysis
Version 2.2 — Performance Testing
Lighthouse Integration
Performance Testing
Accessibility Checks
Best Practices Checks
SEO Checks
Core Web Vitals
Version 2.3 — Advanced QA Reporting
Screenshots on Failure
Execution Time
Browser Information
Build Information
Test Execution History
Failure Trends
QA Dashboard
Version 2.4 — Advanced CI/CD
Parallel Test Execution
Multi-Browser Testing
Environment Management
Branch-Based Pipelines
Pull Request Quality Gates
Deployment Controls
Rollback Strategy
🎯 Project Goal

The goal of this project is not only to maintain a personal portfolio.

It is being developed as a practical demonstration of how a QA Engineer can work across the complete software delivery lifecycle:

Development
     ↓
Version Control
     ↓
Automation
     ↓
CI/CD
     ↓
Quality Gate
     ↓
Deployment
     ↓
Regression Testing
     ↓
Reporting
     ↓
Continuous Improvement

The project will continue evolving from a simple portfolio website into a complete QA Automation + CI/CD demonstration project.

👨‍💻 Author

Sanskar Chandak

Software Test Engineer | QA | API Testing | Automation | AI Enthusiast

Connect
LinkedIn: https://www.linkedin.com/in/sanskarchandak/
GitHub: https://github.com/sanskarchandak/
📄 License

This project is licensed under the MIT License.
