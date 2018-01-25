package stqa.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import stqa.addressbook.model.GroupData;

import java.util.Set;

public class GroupModificationTests extends TestBase {

    @BeforeMethod
    public void ensurePreconditions(){
        app.goTo().group();
        if (app.group().all().size() == 0){
            app.group().create(new GroupData().withName("test1"));
        }
    }

    @Test
    public void testGroupModification(){

        Set<GroupData> before = app.group().all();
        GroupData modifiedGroup = before.iterator().next();
        GroupData group = new GroupData()
                .withId(modifiedGroup.getId()).withName("test").withHeader("test2").withFooter("test");
        app.group().modify(group);
        Set<GroupData> after = app.group().all();
        Assert.assertEquals(after.size(),before.size());

        before.remove(modifiedGroup);
        before.add(group);
        Assert.assertEquals(before,after);
    }
}
