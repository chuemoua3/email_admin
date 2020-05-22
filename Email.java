import java.util.Scanner;

public class Email {

    private String email, firstName, lastName, password, department, alternateEmail,
            companySuffix = "gmail.com";

    private int mailboxCapacity = 500, defaultPassLength = 10;

    // Constructor taking firstname and lastname
    public Email(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        System.out.println("Email created: " + this.firstName + " " + this.lastName);

        //sets the department by calling a method to ask for department
        this.department = setDepartment();
        System.out.println("Department: " + department);

        //call a method to generate a random password
        this.password = randomPassword(defaultPassLength);
        System.out.println("Your password: " + password);

        email = firstName.toLowerCase() + lastName.toLowerCase() + "@" + department + "." + companySuffix;
    }

    public String getFirstName(){
        return firstName;
    }
    public void setFirstName(String firstName){
        this.firstName = firstName;
    }

    public String getLastName(){
        return lastName;
    }
    public void setLastName(String lastName){
        this.lastName = lastName;
    }
    public void changePassword(String password){
        this.password = password;
    }

    //method for generating password
    public String randomPassword(int length){
        String passwordSet = "ABCDEFGH";
        char[] password = new char[length];
        for(int i = 0; i < length; i++){
            int rand = (int)(Math.random()*passwordSet.length());
            password[i] = passwordSet.charAt(rand);
        }
        return new String(password);
    }

    //method to ask for department
    public String setDepartment(){
        System.out.println("New Worker: " + firstName + 
        " Department Codes:  \n1for Sales \n2 for Development \n3 for Accounting \nEnter the department code: ");
        Scanner input = new Scanner(System.in);
        int choice = input.nextInt();
        input.close();
        if(choice == 1){return "sales";}
        else if(choice == 2){return "dev";}
        else if(choice == 3){ return "acct";}
        else{return "";}
    }

    public String getAlternateEmail(){
        return alternateEmail;
    }

    public void setAlternateEmail(String alternateEmail){
        this.alternateEmail = alternateEmail;
    }

    public int getMailboxCapacity(){
        return mailboxCapacity;
    }
    public void setMailboxCapacity(int mailboxCapacity){
        this.mailboxCapacity = mailboxCapacity;
    }
    
    public String showInfo(){
        return String.format("Name: %s %s \nEmail: %s \nMailbox Capacity: %dmb", firstName, lastName, email, mailboxCapacity);
    }

}