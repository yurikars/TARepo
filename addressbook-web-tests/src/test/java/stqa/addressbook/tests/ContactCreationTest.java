package stqa.addressbook.tests;

import org.testng.annotations.Test;
import stqa.addressbook.model.ContactData;
import stqa.addressbook.model.Contacts;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactCreationTest extends TestBase {

    @Test
    public void testContactCreation() {
        app.goTo().contactsListPage();
        Contacts before = app.contact().all();
        ContactData contact = new ContactData().
                withFirstName("test1").
                withLastName("test2").
                withMiddleName("test3").
                withMobilePhone("+375297770000").
                withAddress("SomeAddress").
                withCompanyName("Company Name").
                withEmail("SomeMail").
                withEmployment("SomeEmployment").
                withGroup("SomeGroup");
        app.contact().createContact(contact);
        Contacts after = app.contact().all();
        assertThat(after.size(), equalTo(before.size() + 1));
        assertThat(after, equalTo(before.withAdded(contact.
                withId(after.stream().mapToInt((c) -> c.getId()).max().getAsInt()))));
    }

}
