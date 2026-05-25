/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.login;
import java.util.Scanner;
// Name Rakhumo Junior Kemorwe 
// ST 10520371
/**
 *
 * @author Student
 */
public class LogIN {

    public static void main(String[] args) {
        Registration Regi = new Registration(); 
       
        Scanner input = new Scanner(System.in);
       
         
        Message recent = new Message () ; 
        String message;
        
        // Creating a menu
        int choices;
        
        do{
           System.out.println("\n===== MENU =====");
            System.out.println("1. Register");
            System.out.println("2. LOGIN");
            System.out.println("3. Exit");
            System.out.print("Choose option: ");  
            
            System.out.println("Enter Menu option");
            choices = input.nextInt();
            
            switch (choices){
                case 1:
                     System.out.println("\n=====Registration======"); 
       
        
        if (Regi.RegisterUser(input)){
        System.out.println("\nWelcome to the Messaging Application!");
        
        //Number of messages
        System.out.print("How many messages would you like to send? ");
          int totalMessages = input.nextInt();
         input.nextLine();
        
        int sentMessages = 0;
        Message recentMessage = null;
         
        int choice;
        
        do {
            System.out.println("\n===== MESSAGE =====");
            System.out.println("1. Send Message");
            System.out.println("2. Show Recently Sent Message");
            System.out.println("3. Quit");
            System.out.print("Choose option: ");
            
            choice = input.nextInt();
            input.nextLine();
            
            switch (choice) {
                 
                case 1:
                    if (sentMessages < totalMessages){
                         //Check Message ID
                         System.out.println("Enter Message ID: ");
                         String messageID = input.nextLine();
                         if (recent.checkMeesageID(messageID)){
                    
                           System.out.println("Message ID Accepted. ");
                         }else{ 
                          System.out.println("Message ID exceeds 10 Characters. ");    
                         }
                        //Check Recipient cell
                        System.out.println("Enter Recipent Cell Number: ");
                         String recipientCell = input.nextLine();
                         if(recent.checkRecipentCell(recipientCell)){
                        System.out.println("Recipent Cell Valid. ");
                         }else{
                          System.out.println("Recipent Cell does not contain 10 digits ");   
                         }
                             
                        //Send Message
                        System.out.println("Enter message: ");
                        message = input.nextLine();
                        System.out.println(recent.sendMessage(message));
                        if (!recent.checkMessageLength(message)){
                            System.out.println("Message exceeds 250 Characters");
                            return;
                        }
                        
                        // Create Message Hash
                        String hash = recent.createMessageHash(messageID, sentMessages, message);
                        System.out.println("Message Hash:"+hash);
                        
                        
                        System.out.print("Pin message? (true/false:)");
                        boolean pinned = input.nextBoolean();
                        input.nextLine();
                        
                        // Print Messages
                        System.out.println("Sent Messages:");
                        System.out.println(recent.printMessages());
                        recent.displayMessage();
                        recent.storeMessage();
                        sentMessages++;
                        
                        
                        System.out.println("Message sent:"+ sentMessages);
                        
                        //Total Messages
                        System.out.println("Total Messages sent:"+recent.returnTotalMessages());
                         
                        
                    }else {
                        System.out.println("You have reached your message limit.");
                    }
                    break;
                    
                case 2:
                    
                    if (recentMessage != null){
                        recentMessage.displayMessage();
                    }else{
                        System.out.println("No messages sent yet.");
                    }
                    break;
                case 3:
                    System.out.println("Application closed.");
                    break;
                    
                default:
                    System.out.println("Invalid option.");
            }
        } while (choice != 3);
        
       }else{
           System.out.println("Registration Failed.");
       }
                    break;
                case 2:
                    System.out.println("\n=====LOG-IN======="); 
       
       // Login.userLogin(input);
       if (Regi.userLogin(input)){
        System.out.println("\nWelcome to the Messaging Application!");
        
        //Number of messages
        System.out.print("How many messages would you like to send? ");
        int totalMessages = input.nextInt();
        input.nextLine();
        
        int sentMessages = 0;
        Message recentMessage = null;
         
        int choice;
        
        do {
            System.out.println("\n===== MESSAGE =====");
            System.out.println("1. Send Message");
            System.out.println("2. Show Recently Sent Message");
            System.out.println("3. Quit");
            System.out.print("Choose option: ");
            
            choice = input.nextInt();
            input.nextLine();
            
            switch (choice) {
                 
                case 1:
                    if (sentMessages < totalMessages){
                         //Check Message ID
                         System.out.print("Enter Message ID");
                         String messageID = input.nextLine();
                       System.out.println("Message ID Valid: "+recent.checkMeesageID(messageID));
                        
                        //Check Recipient cell
                        System.out.print("Enter Recipent Cell");
                         String recipientCell = input.nextLine();
                        System.out.println("Recipent Cell Valid: "+recent.checkRecipentCell(recipientCell));
                        
                        //Send Message
                        System.out.print("Enter message: ");
                        message = input.nextLine();
                        System.out.println(recent.sendMessage(message));
                        
                        // Create Message Hash
                        String hash = recent.createMessageHash(messageID, sentMessages, message);
                        System.out.println("Message Hash:"+hash);
                        
                        
                        System.out.print("Pin message? (true/false:)");
                        boolean pinned = input.nextBoolean();
                        input.nextLine();
                        
                        // Print Messages
                        System.out.println("Sent Messages:");
                        System.out.println(recent.printMessages());
                        recent.displayMessage();
                        recent.storeMessage();
                        sentMessages++;
                        
                        
                        System.out.println("Message sent:"+ sentMessages);
                        
                        //Total Messages
                        System.out.println("Total Messages sent:"+recent.returnTotalMessages());
                        
                    } else {
                        System.out.println("You have reached your message limit.");
                    }
                    break;
                    
                case 2:
                    
                    if (recentMessage != null){
                        recentMessage.displayMessage();
                    }else{
                        System.out.println("No messages sent yet.");
                    }
                    break;
                case 3:
                    System.out.println("Application closed.");
                    break;
                    
                default:
                    System.out.println("Invalid option.");
            }
        } while (choice != 3);
        
       }else{
           System.out.println("Login Failed.");
       }
                    break;
                case 3:
                    System.out.println("Goodbye");
                    break;
                default:
                    System.out.println("Invaild choice");
                   
            }
        }while (choices!=3);{
        
        
        
          
       
              
    input.close(); 
    }
    }
    
}
