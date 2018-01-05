package stqa.addressbook;

import org.testng.annotations.Test;

public class ContactCreationTest extends TestBase {

    @Test
    public void testContactCreation () {

        gotoUserPage();

        fillUserCreationForm(new ContactData("Name",
                                          "MiddleName",
                                          "LastName",
                                          "nick",
                                          "guglius",
                                          "Bogota",
                                          "+375297776655",
                                          "noWork",
                                          "freelance",
                                          "some@mail.com"));

        submitUserCreation();
    }

}
