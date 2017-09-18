# TECHNICAL TEST

### HOW TO RUN THE TESTS 
In order to run the tests, Google Chrome and Gradle need to be installed. 

Then, either import the project into an IDE and run the tests using testng or `cd` onto the folder and run:

`gradle test`

The report for the results of the tests can be seen at 

`/build/reports/tests/packages/tests.html`


### REQUESTED TESTS

Upload a screencast and the code of your automatic tests in the suite you want to a site that is accessible from the internet, from where we will see the result of your test and comment the code with you.
 
Your automated test must
 
1. Log in to the application (https://app.es.sageone.com/login) with the following credentials: [User:automatic.test@yopmail.com / Pass: automatic.test]
2. Navigate to the list of bank accounts in the top menu.
3. Try to register a bank account with the following data (“Configurar cuentas bancarias” > “Añadir nueva cuenta”):
- Name: (empty string)
- Type: Current Account
- Number: 1111 1111 40 1111111111
4. Check that data validation fails when saving. There is one validation on client and one on server.
5. Add the name "Bank Account Test" and change the account number to 1111 1111 30 1111111111
6. Save, and check that the new account with all data entered is shown in the Bank Accounts grid.

### SCREEN CAST

https://github.com/jpita/interview/blob/master/sageScreenCast.mov?raw=true
