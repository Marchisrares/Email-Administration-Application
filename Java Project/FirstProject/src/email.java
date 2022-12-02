import java.util.Scanner;

public class email {
    private String firstName;
    private String lastName;
    private String password;
    private String department;
    private String email;
    private int mailBoxCapacity = 500;
    private int defaultPasswordLength = 10;
    private String alternateEmail;
    private String companySuffix = "company.com";


    //constructor to get first name and last name
    public email(String firstName, String lastName){
        this.firstName = firstName;
        this.lastName = lastName;

        //call a method asking for the department return the department
        this.department = setDepartment();

        //call a method that return a random password
        this.password = randomPassword(defaultPasswordLength);
        System.out.println("Your pass word is "+this.password);

        //Combine element to generate email
        email = firstName.toLowerCase() + "." + lastName.toLowerCase() + "@"+ department +"."+ companySuffix;
    }
    // ask for department
    private String setDepartment(){
        System.out.print("Enter the department\n1 for Sales\n2 for Development\n3 for Accounting \n0 for None");
        Scanner in = new Scanner(System.in);
        int depChoice = in.nextInt();
        if (depChoice == 1){ return "sales";}
        else if(depChoice == 2){return "development";}
        else if(depChoice == 3){return "accounting";}
        else{return "";}
    }
    //generate random password
    private String randomPassword(int length){
        String passwordSet = "ABCDEFGIJKLMNOPQRSTUXYZ123456789!@";
        char[] password = new char[length];
        for(int i=0;i<length;i++){
        int rand = (int)(Math.random() * passwordSet.length());
        password[i] =  passwordSet.charAt(rand);
        }
        return new String(password);
    }
    //set mailbox capacity
    public void setMailBoxCapacity(int capacity){
        this.mailBoxCapacity = capacity;
    }
    //Set alternate email
    public void setAlternateEmail(String altEmail){
        this.alternateEmail = altEmail;
    }
    //Change the password
    public void changePassword(String password){
        this.password = password;
    }

    public int getMailBoxCapacity(){return mailBoxCapacity;}
    public String getAlternateEmail(){return alternateEmail;}
    public String getPassword(){return password;}

    public String showInfo(){
        return "Display name: "+ firstName + " "+ lastName +
        " Company email: "+ email +
        " Mailbox capacity:"+ mailBoxCapacity+ "mb";
    }
}
