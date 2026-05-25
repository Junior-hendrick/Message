/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.login;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author Student
 */
public class Message {
    // Total messages counter
   private static int messageCount =0; 
   
   // ArrayList to store sent messages while program is running
   private static ArrayList<String> sentMessages = new ArrayList<>();
   
   private String messageID;
   private String messageText;
   private boolean pinned;
   private String hash;

    public static void setMessageCount(int messageCount) {
        Message.messageCount = messageCount;
    }

    public void setMessageID(String messageID) {
        this.messageID = messageID;
    }

    public void setMessageText(String messageText) {
        this.messageText = messageText;
    }

    public void setPinned(boolean pinned) {
        this.pinned = pinned;
    }

    public void setHash(String hash) {
        this.hash = hash;
    }

    public String getMessageID() {
        return messageID;
    }

    public String getMessageText() {
        return messageText;
    }

    public boolean isPinned() {
        return pinned;
    }

    public String getHash() {
        return hash;
    }
   
   //Method to check Message ID Length
   public boolean checkMeesageID(String messageID){
       
       if (messageID.length()<=10){
           return true;
       }else {
   return false;
       }
   }
   //Method to check recipient cell number length
   public boolean checkRecipentCell(String recipientCell){
       if (recipientCell.length() ==10){
           return true;
       } else{
           return false;
       }
   }
   
   //Method to make sure that the length is less than 250 characters
   public boolean checkMessageLength(String message){ 
       return message.length() <= 250;
   }
   // Generate message hash
   public String createMessageHash(String messageID, int messageNumber, String message){
       
       String[] words = message.split(" ");
       
       String firstWord = words[0].toUpperCase();
       String lastWord = words[words.length - 1].toUpperCase();
       
       String hash = messageID.substring(0,2)+":"+messageNumber +":"+firstWord + lastWord; 
       return hash;
   }
   // Method to send/store/disregard message
   public String sendMessage(String message){
       Scanner input = new Scanner(System.in);
       
       System.out.println("Choose an option:");
       System.out.println("1. Send Message");
       System.out.println("2. Store Message");
       System.out.println("3. Disregard message");
       
       int choice = input.nextInt();
       
       switch (choice){
           case 1:
               sentMessages.add(message);
               messageCount++;
               return "Message successfully sent.";
               
           case 2:
               storeMessage();
               return "Message successfully stored.";
               
           case 3:
               return "Message disregarded.";
               
           default:
               return "Invalid option selected.";
                       
                       
       }         
                       
   }
   // Method to print all sent messages
   public String printMessages(){
       String allMessages = "";
       
       for (String msg : sentMessages){
           allMessages += msg + "\n";
       }
       return allMessages;
   }
   // Method to return total number of sent messages
   public int returnTotalMessages(){
       return messageCount;
   }
   
   //Display Message
   public void displayMessage(){
       System.out.println("\n--- Message Details ---");
       System.out.println("Message ID: "+ messageID);
       System.out.println("Message Text: "+ messageText);
       System.out.println("Pinned: "+ pinned);
       System.out.println("Message Hash: "+ hash);
   }
   // Store Message in JSON file
   public void storeMessage(){
       try {
           FileWriter file = new FileWriter("messages.json",true);
           
           file.write("{\n");
           file.write("\"MessageID\":\""+messageID+"\",\n");
           file.write("\"Message\":\""+messageText+"\",\n");
           file.write("\"Pinned\":\""+pinned+"\",\n");
           file.write("\"Hash\":\""+hash+"\"\n");
           file.write("{\n");
           file.close();
           
           System.out.println("Message stored in JSON file");
       } catch (IOException e) {
           System.out.println("Error saving message.");
       }
   }
   //Number of messages saved
   public static int getMessageCount(){
       return messageCount;
   }
   
}
