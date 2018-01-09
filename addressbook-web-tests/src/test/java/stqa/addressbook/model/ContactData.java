package stqa.addressbook.model;

public class ContactData {
    private final String firstName;
    private final String middleName;
    private final String lastName;
    private final String nickName;
    private final String companyName;
    private final String address;
    private final String mobilePhone;
    private final String work;
    private final String employment;
    private final String email;
    private String group;

    public ContactData(String firstName, String middleName,
                       String lastName, String nickName, String companyName,
                       String address, String mobilePhone, String work,
                       String employment, String email, String group) {
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.nickName = nickName;
        this.companyName = companyName;
        this.address = address;
        this.mobilePhone = mobilePhone;
        this.work = work;
        this.employment = employment;
        this.email = email;
        this.group = group;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getNickName() {
        return nickName;
    }

    public String getCompanyName() {
        return companyName;
    }

    public String getAddress() {
        return address;
    }

    public String getMobilePhone() {
        return mobilePhone;
    }

    public String getWork() {
        return work;
    }

    public String getEmployment() {
        return employment;
    }

    public String getEmail() {
        return email;
    }

    public String getGroup() {
        return group;
    }
}
