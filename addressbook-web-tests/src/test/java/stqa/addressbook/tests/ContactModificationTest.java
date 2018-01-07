package stqa.addressbook.tests;

import org.testng.annotations.Test;
import stqa.addressbook.model.ContactData;

public class ContactModificationTest extends TestBase {

    @Test
    public void testContactModification (){

        app.getContactHelper().selectContact();
        app.getContactHelper().fillUserCreationForm(new ContactData("UpdatedFirstName",
                                                                    "UpdatedMiddleName",
                                                                    "UpdatedLastName",
                                                                    "UpdatedNickName",
                                                                    "UpdatedCompannyName",
                                                                    "UpdatedAddress",
                                                                    "UpdatedMobilePhone",
                                                                    "UpdatedWork",
                                                                    "UpdatedEmployment",
                                                                    "UpdatedEmail"));
        app.getContactHelper().submitUserModification();
        app.getContactHelper().returnToUserPage();

    }
}
