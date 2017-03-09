/*
 * Server listening on SERVER_PORT for incoming data from Python client.
 * Author: Nikhil Aggarwal, nikhil0929@gmail.com, Jan 28 2017
 * 
 */

import java.net.*;
import java.util.*;
import java.io.*;
import javax.swing.*;
import java.awt.*;

public class SocketServer extends JFrame{
  public static int SERVER_PORT = 5905;
  public static String PASSWORD = "r0b0c0rps";
  public static void main(String[] args){
    new ServerExtra();
  }
  public SocketServer(){
    try{
      ServerSocket sSocket = new ServerSocket(SERVER_PORT);
      System.out.println("Server started at: " + new Date() + " on port 5905. ");
      //Loop that runs server functions
      while(true){
        //Wait for a client to connect
        Socket socket = sSocket.accept();
        System.out.println("recieved new connection on socket " + socket.getPort());
        
        //Create a new custom thread to handle the connection
        ClientThread cT = new ClientThread(socket);
        
        //Start the thread!
        new Thread(cT).start();
      } //end while loop
    }
    catch(IOException exception) {
      System.out.println("Error: " + exception);
    }
  }
  
  class ClientThread implements Runnable {

    int x;
    int y;
    int z;
    String ts;
    Socket threadSocket;
    boolean loginStatus = false;
    
    public ClientThread(Socket socket) {
      //Here we set the socket to a local variable so we can use it later
      threadSocket = socket;
    }
    public void run() {
      try {
        InputStreamReader reader = new InputStreamReader(threadSocket.getInputStream());
        BufferedReader bsReader = new BufferedReader(reader);
        PrintWriter sOutput = new PrintWriter(threadSocket.getOutputStream(), true);
        
        String socketString;
        String[] command;
        sOutput.println("INFO Connected to 5905 socket at " + new Date() + "\r\n");
        
        while (true) {
          socketString = bsReader.readLine();
          if (socketString == null)
            continue;
          command = socketString.split(" ");
          
          
          if(command[0].equalsIgnoreCase("LOGIN")){
            doLogin(sOutput, command);
          }
          
          else if(command[0].equalsIgnoreCase("CURRENT_LOCATION")){
            doGetCurrentLocation(sOutput, command);
          }
          
          else if(command[0].equalsIgnoreCase("LOGOUT")){
            doLogout(sOutput, command);
            break;
          }
          
          else{
            System.out.println("ERROR Command unkown: " + command[0]);
            sOutput.println("ERROR Command unknown: " + command[0]);
          }
        }
      }
      catch(IOException exception) {
        System.out.println("Error: " + exception);
      }
      
      
      System.out.println("INFO: Thread completed, exiting");
      return;
    }
    
    public void doLogin(PrintWriter sOutput, String[] command) {
      System.out.println("INFO Recieved command LOGIN");
      if(command.length < 2){
        sOutput.println("ERROR missing password after command");
        return;
      }
      if(command[1].equals(PASSWORD)){
        System.out.println("INFO Login successful");
        sOutput.println("OK login successful!");
        loginStatus = true;
      }
      else if(!command[1].equals(PASSWORD)){
        System.out.println("INFO Incorrect password");
        sOutput.println("ERROR: Incorrect password");
      }
      
    }
    
    public void doLogout(PrintWriter sOutput, String[] command) {
      loginStatus = false;
      System.out.println("INFO Recieved command LOGOUT");
      sOutput.println("OK logout successful!");
    }
    
    public void doGetCurrentLocation(PrintWriter sOutput, String[] command) {
      if(loginStatus != true){
        sOutput.println("Error: You must login first");
        System.out.println("Error: connection not logged reader");
        return;
      }
      if(command.length < 4){
        System.out.println("INFO Not enough parameters after command < 4");
        sOutput.println("Error: Not enough parameters after command");
        return;
      }
      x = Integer.parseInt(command[1]);
      y = Integer.parseInt(command[2]);
      z = Integer.parseInt(command[3]);
      try{
        ts = command[4];
      }
      catch(Exception e){
        ts = "0" ; 
      }
      sOutput.println("OK!");
      System.out.println("INFO recieved current location " + x + " " + y +" " + z + " " + ts);
      return;
    }
  }
}
