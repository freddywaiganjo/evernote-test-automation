#  Evernote web-test-automation
## _This is an automation project to test evernote application over the web_


Below technologies have been used to achieve this piece of work.

- Selenium
- Java 11.0.11
- Cucumber
- Junit
## Scenerios Automated:

1. Unsuccessful login using email
2. Successful login using email
3. Login and write a note followed by a logout
4. Login again and make sure you open the note create in step 3


This text you see here is *actually- written in Markdown! To get a feel
for Markdown's syntax, type some text into the left window and
watch the results in the right.

## How to run the project

1. Open the project in an editor e.g intellij.

2. Install pom dependencies by running below command.

```sh
 mvn clean install
```
2. Run the project by running CucumberOptions class in CucumberOptions.java under config folder.
3. Observe the tests. They should all pass
4. Change below value to true in config.properties file to run tests in headless mode

```sh
headless.active=false
```