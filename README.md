# Math Operator Project

This project implements a simple Math Operator service with a RESTful API to perform basic mathematical operations such as addition, subtraction, multiplication, and division.

## Table of Contents

- [Overview](#overview)
- [Getting Started](#getting-started)
  - [Prerequisites](#prerequisites)
  - [Installation](#installation)
- [Usage](#usage)
  - [API Endpoints](#api-endpoints)
- [Running Tests](#running-tests)
- [Contributing](#contributing)
- [License](#license)

## Overview

The Math Operator service provides endpoints to perform mathematical operations on two operands. The project includes unit tests and integration tests to ensure the correctness of the implemented functionality.

## Getting Started

### Prerequisites

- Java 8 or higher
- Maven

### Installation

1. Clone the repository:

   ```bash
   git clone https://github.com/your-username/ndungutse-term1-a.git
   ```

2. Navigate to the project directory:

   ```bash
   cd ndungutse-term1-a
   ```

3. Build the project using Maven:

   ```bash
   mvn clean install
   ```

## Usage

### API Endpoints

The Math Operator service exposes the following API endpoints:

- **Addition:**

  ```http
  POST /math/add
  ```

  Request Body:

  ```json
  {
    "operand1": 3.0,
    "operand2": 4.0,
    "operator": "+"
  }
  ```

- **Subtraction:**

  ```http
  POST /math/subtract
  ```

  Request Body:

  ```json
  {
    "operand1": 7.0,
    "operand2": 3.0,
    "operator": "-"
  }
  ```

- **Multiplication:**

  ```http
  POST /math/multiply
  ```

  Request Body:

  ```json
  {
    "operand1": 2.0,
    "operand2": 5.0,
    "operator": "*"
  }
  ```

- **Division:**

  ```http
  POST /math/divide
  ```

  Request Body:

  ```json
  {
    "operand1": 20.0,
    "operand2": 4.0,
    "operator": "/"
  }
  ```

## Running Tests

To run the tests, use the following Maven command:

```bash
mvn test
```

This will execute both unit tests and integration tests to ensure the correctness of the implemented functionality.

## Contributing

If you would like to contribute to this project, please follow the [Contribution Guidelines](CONTRIBUTING.md).

## License

This project is licensed under no license.