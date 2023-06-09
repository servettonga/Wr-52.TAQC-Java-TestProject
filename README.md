# Wr-52.TAQC-Java-TestProject

**Wr-52.TAQC/Java/Python Test Project for EventExpress Web-App**

Link to EventExpress Website:

https://eventsexpress-test.azurewebsites.net/landing

## For contributors

### Git Flow

We are using simpliest github flow to organize our work:
![Git Flow Ilustration](https://github.com/servettonga/Wr-52.TAQC-Java-TestProject/assets/83537967/4a8b1c30-f6b1-402c-a19a-606290763481)

### Note! Contribution rules:

1. All Pull Requests should start from prefix #xxx-yyy where xxx - task number and and yyy - short description e.g. #020-CreateAdminPanel.
2. Pull request should not contain any files that are not required by the task. In case of any violations, the pull request will be rejected.
3. Create a .env file at the project’s root directory for credentials, add the following fields for administrator privileges:<br>
   `EMAIL="anyvalidemail@email.com"`<br>`PASSWORD="validpassword"`

4. The project uses Chrome as default browser. You can run it with a different browser by adding argument to `mvn` command (e.g. `-Ddriver=edge` for Edge browser). See `systemPropertyVariables` in `pom.xml`.
5. Allure report by existing XML files will be generated during Maven build process.

    - `mvn clean test` to run your tests

    You can generate a report using the following command:

    - `mvn allure:serve` report will be generated into temp folder. Web server with results will start.
