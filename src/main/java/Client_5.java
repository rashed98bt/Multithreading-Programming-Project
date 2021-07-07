

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;



/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Rashed
 */
public class Client_5 {

    
    public static void main(String[] args) {
        Socket s=null;
        DataOutputStream DOS=null;
        DataInputStream DIS=null;
        try {
            s = new Socket("localhost", 1234);
            DOS = new DataOutputStream(s.getOutputStream());
            DIS = new DataInputStream(s.getInputStream());
            DOS.writeUTF("5");
         
            //System.out.println(DIS.readUTF());
            System.out.println("------------------------------------");
            System.out.println("");
        } catch (IOException ex) {
            System.out.println("ex");
        }
        
        
    }

}
