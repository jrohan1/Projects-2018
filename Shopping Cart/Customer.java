 

public class Customer {
    private String firstName;
    private String surName;
    private String emailAddress;
    private final long customerId;
    // Customer initialised by three variables 
    public Customer(String firstName, String surName, String emailAddress){
        this.firstName = firstName;
        this.surName = surName;
        this.emailAddress = emailAddress;
        customerId  = makeCustomerId();
    }
    // create setter and getter methods 
    public long getId() {
        return customerId;
    }
    
    public String getFirstName() {
        return firstName;
    }

    public String getSurName() {
        
        return surName;
    }
    
    public String getEmailAddress() {
        return emailAddress;
    }
    // create random number for id
    private long makeCustomerId() {
        return (long)(Math.random() * 99999999999999L);
    }

    public void setFirstName(String first) {
        firstName = first;
    }

    public void setSurName(String sur) {
        surName = sur;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

}
