# web-test-automation
This project comprises automated UI tests for web.

The automation framework is designed by following the principles of behavior-driven development which promotes writing the tests in simple english. Cucumber tool is used to support this.

Page Object model design pattern is incorporated, which represents the pages of the application as objects that helps in improving code maintainability and readability.

## Tools
* Selenium WebDriver
* Cucumber-Java
* TestNG
* Rest Assured
* Maven

## Requirements
In order to utilize the project, you need to have the following installed:

* Java
* Chrome
* Maven

## Formatting code

Before pushing your code, format the code with the following maven command:

```sh
./mvnw formatter:format
```

Once the code has been formatted, do the following:

1. review the changes, `git diff` or your tool of preference.
2. run tests, ensure everything works.
3. commit your code
4. push code.

## Pre-Requisites
1. install java 17 corretto. follow instructions for your platforma [here](https://docs.aws.amazon.com/corretto/latest/corretto-17-ug)
2. create a file call creds.properties with the following data. (might need to more credentials based on the type of test you are running. The following is the sample for Assisted Manual tests)
    ```properties
    test_username=sbx_ci_4nP7jjF1MPJJEQz76iwui5k7HTMbrbW2P6XbcN65CeiD
    test_password=sbx_cs_B8oSq77mBDsSf31HULwC7ZyBX1RtL29z72xEVS5HKJzU
   ```
   *Note:* Never check this file in
## Usage
To run all the tests, navigate to `web-test-automation` directory and run:

```
./mvnw test -DcredsFilePath=creds.properties
```

To run the tests in headless browser:

```
./mvnw test -DcredsFilePath=creds.properties \
        -DbrowserMode=headless
```

To run only the tests with a specific tag:

```
./mvnw test -DcredsFilePath=creds.properties \
        -Dcucumber.filter.tags=<Tag>
```

Example Command:

```
./mvnw test -DcredsFilePath=creds.properties \
        -DbrowserMode=headless \
        -Dcucumber.filter.tags="@SmokeTest"
```

### Parameters

`-DcredsFilePath` - Path to creds file. If relative path, start from repo base directory.

`-DbrowserMode`  - (Optional) If the tests need to be executed in headless mode, provide the value as 'headless'.

`-DDcucumber.filter.tags` - (Optional) Provide the specific scenario tags to be executed here. For example: '@RegressionTest' '@SmokeTest'

`-Denv` - (Optional) Chooses the checkout demo page url based on this. Default is `DEV`

`-DdebugMode` - (Optional) is used to connect to an existing Chrome Window. Used during assisted manual tests.

## Reporting

Cucumber HTML test execution reports can be found in `web-test-automation/target/cucumber/cucumber.html`.


## Running Assisted Manual tests with this tool

### Start Chrome in Debug mode
Starting Chrome in Debug mode will let you reuse the same chrome instance for manual testing and save time on chrome startup for each test <br/>
for windows
```shell
chrome.exe --remote-debugging-port=9222 --user-data-dir="<ChromeProfileDirectory>"
```

for mac
```shell
/Applications/Google\ Chrome.app/Contents/MacOS/Google\ Chrome --remote-debugging-port=9222 --user-data-dir="<ChromeProfileDirectory>"
```

eg.
```shell
chrome.exe --remote-debugging-port=9222 --user-data-dir="C:\selenum\ChromeProfile"
```

*user data directory is where your chrome profile is stored. Having a separate directory will help you not mess up you current chrome profiles** <br/>
**Note:** This directory should be precreated

### Creating your test
1. under [features](src/test/java/scenarios/features) directory create a .feature file (eg. file in AssistedManualTest.feature)
2. Add you scenario as a simple automation (you can omit assertions if verifying them manually)
3. At the end of the `When` section add the following line
```shell
And Wait for test to be complete
```
4. This step waits for you to type `OK` in the country code text field before moving on to the next test. This gives us time to verify if the transaction happened correctly.
**Note** This step waits for 10 mins before it times out.


### Running Assisted Manual tests
Specify a tag starting with `manual` for manual scenarios and use it as below
```shell
./mvnw test -DcredsFilePath=creds.properties \
        -Dcucumber.filter.tags="@manual_sample" \
        -DdebugMode=true
```

### Caveats
* It fails the last test if it's 3DS for no reason. But we are still able to complete the test. It doesn't wait for the OK to be entered
* Make sure to have only 1 chrome tab opened. Otherwise, the test will be stalled.


### Left as Excerise
* Setup your IDE to run specific tests directly from the IDE
* Add wait steps before certain actions to make it easy to follow the tests.