import java.util.Scanner;

public class Email{
    private String firstName;
    private String lastName;
    private String password;
    private String department;
    private String email;
    private int mailCapacity = 500;
    private String altEmail;
    private int defaultPassLen = 10;
    private String companySuffix = "coolguywebsite.com";


    //Constructor to make set name 

    public Email(String firstName, String lastName){
        this.firstName = firstName;
        this.lastName = lastName;
       // System.out.println("Email created: " + this.firstName + " " + this.lastName);

        //call the setDept method 
        this.department = setDept();
        //System.out.println("Department: " + this.department);

        //generate a random password method

        this.password = genPass(defaultPassLen);
        //System.out.println("Password is: " + this.password);

        //Generate email
        email = firstName.toLowerCase() + "." + lastName.toLowerCase() + "@" + department + "." +  companySuffix;
        System.out.println("Your email is: " + email);


    }

    //ask for dept

    private String setDept(){
        System.out.println("New Worker: " + firstName + ". Department Codes\n1 for Sales\n2 for Development\n3 for Accounting\n0 for None\nEnter department code: ");
        Scanner in = new Scanner(System.in);
        int deptChoise =  in.nextInt();
        if(deptChoise == 1){return "Sales";}
        else if(deptChoise == 2){return "Development";}
        else if(deptChoise == 3){return "Accounting";}
        else{return "";}
    }

    //generate random password
    private String genPass(int length){
        String passwordSet ="ABCDEFGHIJKLMNOPQRSTUVWXYZ!@$%" ;
        char[] password = new char[length];
        for(int i = 0; i < password.length; i++){
            int rand = (int) (Math.random() * passwordSet.length());
            password[i] = passwordSet.charAt(rand);
        }
        return new String(password);



    }

    //set mailbox cap

    public void setMailCap(int capacity){
        this.mailCapacity = capacity;
    }

    //set alternate email
    public void setAlternateEmail(String alternate){
        this.altEmail = alternate;
    }

    //change password
    public void changePass(String pass){
        this.password = pass;
    }


    //Getters

    public int getMailBoxCap(){return mailCapacity;}
    public String getAltEmail(){return altEmail;}
    public String getPass(){return password;}

    public String showInfo(){
        return "DISPLAY NAME: " + firstName + " " + lastName + " " +
                "\nCOMPANY EMAIL: " + email + " " +
                "\nMAILBOX CAPACITY: " + mailCapacity + "mb";

    }

}