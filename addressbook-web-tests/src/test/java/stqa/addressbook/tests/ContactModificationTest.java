package stqa.addressbook.tests;

import org.testng.annotations.Test;
import stqa.addressbook.model.ContactData;

public class ContactModificationTest extends TestBase {

    @Test
    public void testContactModification (){

        app.getContactHelper().editContact();
        app.getContactHelper().fillUserCreationForm(new ContactData("UpdatedFirstName",
                                                                    "UpdatedMiddleName",
                                                                    "UpdatedLastName",
                                                                    "UpdatedNickName",
                                                                    "UpdatedCompannyName",
                                                                    "UpdatedAddress",
                                                                    "UpdatedMobilePhone",
                                                                    "UpdatedWork",
                                                                    "UpdatedEmployment",
                                                                    "UpdatedEmail",
                                                                    null),
                                                                    false);
        app.getContactHelper().submitUserModification();
        app.getContactHelper().returnToUserCreationForm();

    }
}
