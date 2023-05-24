# qa-testautomationassessment
# Installation and Execution Instructions
Follow the steps below to properly install and run the project. It's important to note that the "core" project needs to be executed first.

1. Install 'Core' project - This is required cause automation  project use it as maven dependency
     1. Navigate to the "core" project directory: cd core/
     2. Install the necessary dependencies: run 'npm install'
     
2. Running the main project
Now that the "core" project is installed on maven local repository, you can proceed with running the main project.
	1. Navigate to the root directory of the automation  project: cd ../automation
	2. Run maven test plugin mvn test
	3. Start the main project: npm start

After following these steps, the main project should be running and ready to use.

# Inconsistencies found in the documentation
TC002 - Login (Negative)
1. O resultado esperado "The application shows the message:
Wrong username or password" não possui "." no final da frase, porém no sistema a mensagem é apresentada com ponto no final da frase.
2. A Iteration 4 Usarname "demouser" e Password "abc123" são valores válidos de login, fazendo com que o teste falhe de forma desnecessária, pois já temos um teste de login com sucesso.

# Inconsistencies found in the project architecture
1. The document lacks language identification or has an invalid lang attribute value, which does not conform to Standards and Guidelines 3.1.1 Language of Page (Level A).
2.A form control is missing its corresponding label, violating Standards and Guidelines 1.1.1 Non-text Content (Level A), 1.3.1 Info and Relationships (Level A), 2.4.6 Headings and Labels (Level AA), and 3.3.2 Labels or Instructions (Level A).
3. The text and background colors have a very low contrast, failing to meet the requirements of Standards and Guidelines 1.4.3 Contrast (Minimum) (Level AA).
4. The Invoice List page lacks a first-level heading, while a second-level heading (h2 element) is present, which goes against Standards and Guidelines 1.3.1 Info and Relationships (Level A), 2.4.1 Bypass Blocks (Level A), and 2.4.6 Headings and Labels (Level AA).
5. The Invoice Details page is missing a first-level heading, but a second-level heading (h2 element) is present. Furthermore, there are disordered fourth-level (h4 element), fifth-level (h5 element), and sixth-level (h6 element) headings, negatively impacting screen reader accessibility. These issues violate Standards and Guidelines 1.3.1 Info and Relationships (Level A), 2.4.1 Bypass Blocks (Level A), and 2.4.6 Headings and Labels (Level AA).
6. There is a layout table present, which contradicts Standards and Guidelines 1.3.1 Info and Relationships (Level A) and 1.3.2 Meaningful Sequence (Level A).

# Singleton Pattern Usage for WebDriver Instance Management
I chose to use the Singleton pattern for the WebDriver class because it allows me to have only a single instance of the WebDriver throughout the project. This is advantageous because initializing the WebDriver can be a resource-intensive process.

By using the Singleton, I can ensure that only one instance of the WebDriver is created and shared among different tests or parts of the system that need to interact with the browser. This simplifies the management of the WebDriver, avoiding the need to create and terminate instances repeatedly.

Additionally, using the Singleton provides a central access point to the WebDriver, allowing me to use it consistently across different parts of the project without the need to pass or explicitly share WebDriver references.

Overall, this approach helps improve project efficiency by reducing the complexity of managing WebDriver instances and promoting the reuse of a single instance throughout the system.

