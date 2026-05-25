/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.login;
import java.util.ArrayList;
import java.util.Scanner;
// Name Rakhumo Junior Kemorwe 
// ST 10520371

/**
 *
 * @author Student
 */
public class Registration {
   private String Name;
   private String Surname;
   private String password;
   private String newUsername;
   private String newNumber;
    
     public ArrayList<String> usernames = new ArrayList<>(); 
     public ArrayList<String> OldPasswords = new ArrayList<>();
     public ArrayList<String> phoneNumbers = new ArrayList<>();
     public Registration(){
         //Contains ols usernames
        usernames.add("Pass");
         usernames.add("Hello");
          usernames.add("Admin");
          
          // Contains old passwords
          OldPasswords.add("Pass@123");
       OldPasswords.add("Hello&99");
       OldPasswords.add("Admin^01");
       
       // System.out.prContains old Numbers
       phoneNumbers.add("0762749502");
        phoneNumbers.add("0645075884");
        phoneNumbers.add("0726118647");
     }
      public boolean checkUsername(String newUsername){
              if (newUsername.length() >=5){
                  System.out.println("Username should not be less than 5 characters");
                  return false;
              }  
                 
        if (usernames.contains(newUsername)) {// Username has Characters less than 5
           System.out.println("Username already exists.");
           return false;
        }
        return true;
    }
    
    
      // String newPassword = input.nextLine();
     // Method to confirm password 
    public  boolean confirmPassword(String password, String confirmPassword){
       //System.out.println("Enter a new password : ");
            return password.equals(confirmPassword);
        }
      //Method to check if password already exists
   
   // Method to validate password and is following the right format
    public boolean isValidPassword(String password){
        // Variables to check requirements
        boolean hasLowerCase = false;
        boolean hasUppercase = false;
        boolean hasNumber = false;
        boolean hasSpecialCharacter = false;
       
        // Code to make sure the password has 8 charcters
        if (password.length()<8){
            return false;
        }
        // Loop through password characters 
        for (int i=0; i < password.length(); i++ ){
            
            char ch = password.charAt(i);
        // Check Lowercase letter
        if (Character.isLowerCase(ch)){
            hasLowerCase = true;
        }
       // One Capital letter  
       if (Character.isUpperCase(ch)){
            hasUppercase = true;
        }
       //One number
       if (Character.isDigit(ch)){
            hasNumber = true;
        }
       //A special Character
       if (!Character.isLetterOrDigit(ch)){
            hasSpecialCharacter = true;
        }
       if (OldPasswords.contains(password)){
           System.out.println("Password already exists.");
           return false;
       }
        }
       return hasLowerCase && hasUppercase && hasNumber && hasSpecialCharacter;
    }
    //Method to check if phone number already exists
    public boolean isPhoneused(String newNumber){
        
            if (phoneNumbers.contains(newNumber)){ 
                System.out.println("This phone number already exists");
                return true; //Number already exists
            }
    
        return false; // Number does not already exists and is new 
    }
    // Method to validate if the phone number is following the right format
    public boolean isValidPhoneNumbers(String newNumber){
        // Code to make sure number has 10 digits and starts with a 0
        if (newNumber.length()==10 && newNumber.startsWith("0") ){
            // Check if entered characters are all numbers
            for (int i =0; i< newNumber.length();i++){
                if (!Character.isDigit(newNumber.charAt(i))){
                    System.out.print("Invalid phone number.Must be 10 digits and start with 0 ");
                    return false;
                }
            }
            
            return false;
            
        }
       
         return true;
    }
    
    public boolean RegisterUser (Scanner input){
        //Scanner input = new Scanner(System.in);
        while (true){
        System.out.println("===== USER REGISTRATION =====");
         System.out.println("Enter your Name: ");
        String Name = input.nextLine(); 
        
        System.out.println("Enter your Surname: ");
        String Surname = input.nextLine();
       
        // Username
        
         System.out.println("Enter a new Username : ");  
        String newUsername = input.nextLine();
        if (!checkUsername(newUsername)){
            System.out.println("Registration failed.");
           break;
        }
       
    }
        
       
         
         // Password
        while (true){
         System.out.println("Enter your Password: ");
         String password = input.nextLine();
         if (!isValidPassword(password)){
            System.out.println("Password is not correctly formatted.");  
             System.out.println("Password must contain:");
              System.out.println("- A least 8 characters long");
               System.out.println("- A capital Letter");
                System.out.println("- A number");
                 System.out.println("- A special character");
                 System.out.println("Registration failed.");
                 //return;
                 //continue;
         }
         System.out.print("Confirm Password");
         String confirmPassword = input.nextLine();
         
         if (!confirmPassword(password,confirmPassword)){
             System.out.println("Password matcheds");
            //return;
           break;
         }
       }
        
        
          
      
         //Phone number
        while (true){ 
         System.out.println("Enter your phone number: " );
        String newNumber = input.nextLine();
        if (isPhoneused(newNumber)){
            System.out.println("This phone number already exists"); 
           // return;
        }else if (!isValidPhoneNumbers(newNumber)){
            System.out.println("Invalid phone number.Must be 10 digits and start with 0 ");
           // return;
           break;
         }
        }
        usernames.add(newUsername);
         System.out.println("newUsername successfully created");
        OldPasswords.add(password);
         System.out.println("Password successfully created");
        phoneNumbers.add(newNumber);
         System.out.println("Number successfully created");
        
         System.out.println("\nRegistration successful!");
         return true;
            }
    
      
     public boolean userLogin(Scanner input){
         //Scanner input = new Scanner(System.in);
        System.out.println("Enter Username : ");  
        String user = input.nextLine();
        System.out.println("Enter Password : ");        
       String pass = input.nextLine();
            if (usernames.contains(user) && OldPasswords.contains(pass)){ 
                System.out.println("Enter Name: ");
                String Name = input.nextLine();
                System.out.println("Enter surname:" );
                String Surname = input.nextLine();
                System.out.println("Welcome back: "+Name +""+Surname+"It is great to see you");
                //Username already exists
                return false;
            }
       System.out.println("Invalid Log-IN ");
       return true;
         // Username does not already exists and is new 
    }
    
        
    //Getter
 public String getName() {
        return Name;
    }

    public String getSurname() {
        return Surname;
    }

    public String getPassword() {
        return password;
    }

    public String getNewUsername() {
        return newUsername;
    }

    public String getNewNumber() {
        return newNumber;
    }
    
   
}
