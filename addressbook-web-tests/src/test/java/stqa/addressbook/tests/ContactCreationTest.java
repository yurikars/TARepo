package stqa.addressbook.tests;

import org.testng.annotations.Test;
import stqa.addressbook.model.ContactData;

public class ContactCreationTest extends TestBase {

    @Test
    public void testContactCreation () {

        app.getContactHelper().gotoUserPage();

        app.getContactHelper().fillUserCreationForm(new ContactData("Name",
                                          "MiddleName",
                                          "LastName",
                                          "nick",
                                          "guglius",
                                          "Bogota",
                                          "+375297776655",
                                          "noWork",
                                          "freelance",
                                          "some@mail.com"));

        app.getContactHelper().submitUserCreation();
    }

}
