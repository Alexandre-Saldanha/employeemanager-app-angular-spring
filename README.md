# Employee Manager App - Angular | Spring
[![License: MIT](https://img.shields.io/badge/License-MIT-yellow.svg)](https://opensource.org/licenses/MIT)

This is a web application that allows you to manage employees. It is built with Angular for the frontend and Spring Boot for the backend.

## Table of Contents

- About the Fork
- What I Learned
- How to Use
- How to Contribute
- Contact
- References

## About the Fork

This project is a fork of the Employee Manager App by Get Arrays, a code repository that teaches web development with Java and Angular. The original project is licensed under the MIT License.

A fork is a copy of a repository that allows you to freely experiment with changes without affecting the original project. You can make your own changes, add new features, fix bugs, or improve the code. You can also sync your fork with the original repository to keep it up to date.

This fork is not synced with the original repository, as I made some changes and additions to the code. You can see the difference between the commits of this fork and the original repository here.

## What I Learned

I learned a lot from the content of the code of the original repository. Some of the things I learned are:

- How to set up an Angular project with the Angular CLI and VS Code.
- How to use Angular components, services, modules, directives, pipes, and routing.
- How to use Bootstrap and Font Awesome for styling and icons.
- How to use HttpClient and RxJS for making HTTP requests and handling asynchronous data.
- How to use Spring Boot, Hibernate, JPA, and MySQL for creating a REST API and connecting to a database.
- How to use Postman and Httpie for testing the API endpoints.
- How to use Lombok annotations.
- How to use Git and GitHub for version control and collaboration.

The biggest challenges I faced were:

- Returning the values stored in the database to the user interface. I had to fix some errors in the methods of the employee.service.ts file, such as using the correct URL.

- Material to display the error messages.

## API Code Improvements

- Added default serial version for Employee and UserNotFoundException classes in the backend rest api.
- Added Lombok annotations for Employee Class in the backend rest api.
- Added @Repository annotation for EmployeeRepo class in the backend rest api.

## How to Use

To use this project, you need to have the following requirements:

- Node.js and npm
- Angular CLI
- Java 11+
- Spring Boot
- MySQL
- Postman or Httpie (optional)

To run this project, follow these steps:

1. Clone or download this repository to your local machine.
2. Open the project folder in VS Code or your preferred code editor.
3. Open a terminal and navigate to the frontend folder.
4. Run `npm install` to install the dependencies.
5. Run `ng serve` to start the development server.
6. Open another terminal and navigate to the backend folder.
7. Put your database configuration in properties.yml file using an IDE or a code editor.
8. Run `mvn spring-boot:run` to start the Spring Boot application.
9. Open your browser and go to http://localhost:4200 to see the Angular web application in action.
10. You can also use Postman to test the rest API endpoints at http://localhost:8080/employee

## How to Contribute

If you want to contribute to this project, you can follow these steps:

1. Fork this repository to your own GitHub account.
2. Clone or download your fork to your local machine.
3. Create a new branch for your feature or bug fix.
4. Make your changes and commit them with a descriptive message.
5. Push your branch to your fork.
6. Create a pull request from your branch to this repository.
7. Wait for your pull request to be reviewed and merged.

Please follow the code style and conventions of this project, and write clear and concise commit messages. You can also open an issue if you find a bug or have a suggestion.

## Contact

If you have any questions or feedback, you can contact me at:

- Email: contatoalexandresaldanha@gmail.com
- LinkedIn: https://www.linkedin.com/in/alexandre-saldanha

## References

These are some of the sources that I used to make this project:

- Employee Manager App - Full Stack Angular/Spring Boot Tutorial - YouTube
- Angular - Documentation
- Spring Boot - Documentation
- MySQL - Documentation
- Postman - Documentation

