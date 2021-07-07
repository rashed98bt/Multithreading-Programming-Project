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
public class Client_2 {
    public static void main(String[] args) {
        Socket s=null;
        DataOutputStream DOS=null;
        DataInputStream DIS=null;
        try {
            s = new Socket("localhost", 1234);
            DOS = new DataOutputStream(s.getOutputStream());
            DIS = new DataInputStream(s.getInputStream());
            DOS.writeUTF("2");
         
            //System.out.println(DIS.read());
            
            System.out.println("------------------------------------");
            System.out.println("Sorted Matrix");
            System.out.println("");
        } catch (IOException ex) {
            Logger.getLogger(Client_1.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
