package stqa.addressbook.tests;

import org.testng.annotations.Test;
import stqa.addressbook.model.ContactData;

import java.util.List;

public class ContactCreationTest extends TestBase {

    @Test
    public void testContactCreation () {

        app.getNavigationHelper().gotoContactPage();
        List<ContactData> before = app.getContactHelper().getContactList();

        app.getContactHelper().fillUserCreationForm(new ContactData(
                                          "Name",
                                          "MiddleName",
                                          "LastName",
                                          "nick",
                                          "guglius",
                                          "Bogota",
                                          "+375297776655",
                                          "noWork",
                                          "freelance",
                                          "some@mail.com",
                                          "test1"),
                                          true);

        app.getContactHelper().submitContactCreation();
    }

}
