import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Rashed
 */
public class Client_1 {

    // all the client using the same code so i didnt write the comment in outher client 
    
    public static void main(String[] args) {
        //make socket to client to make req to server 
        Socket s=null;
        DataOutputStream DOS=null;
        DataInputStream DIS=null;
        try 
        {
            // create  s withe the server port to contact with server 
            s = new Socket("localhost", 1234);
            // data input and output to read and write to and from server 
            DOS = new DataOutputStream(s.getOutputStream());
            DIS = new DataInputStream(s.getInputStream());
            //to send msg to server using DOS.writeUTF
            DOS.writeUTF("1");
            //to receved msg from server 
            //System.out.println(DIS.readUTF());
            System.out.println("------------------------------------");
            System.out.println("");
        } 
        catch (IOException ex) 
        {
            Logger.getLogger(Client_1.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }

}
