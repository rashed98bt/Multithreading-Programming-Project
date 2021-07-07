

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
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
public class Worker implements Runnable{
    
    // worker class  implements Runnable interface to make thrads 
    //initialize sockt to every client make req 
    Socket s ;
    // initialize datainput and dataoutput streams to take data from client adn receved
    DataInputStream dis;
    DataOutputStream dos;
    //worcker class have paramiter Type socket 
    public Worker(Socket sk)
    {
        // we take req from client and add the Socket 
        this.s = sk;
        try {
            dis = new DataInputStream(s.getInputStream());
            dos = new DataOutputStream(s.getOutputStream());
        } catch (IOException ex) {
            Logger.getLogger(Worker.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    // override the run method from runnable interface to run it in thread 
    @Override
    public void run() {
        double start_responstime = System.nanoTime();
        // initialize req msg 
        // then read it in try from dis using read utf 
        String req=null;

            try {
                 req = dis.readUTF();
                
            } catch (IOException ex) {
                Logger.getLogger(Worker.class.getName()).log(Level.SEVERE, null, ex);
            }
            // if the req msg is 1 so the client one need to request 
            if(req.equals("1"))
            {
                try {
                    dos.writeUTF(Server_C.summation()+"");
                } catch (IOException ex) {
                    Logger.getLogger(Worker.class.getName()).log(Level.SEVERE, null, ex);
                }
                
            }
            // if the req msg is 1 so the client one need to request
             if(req.equals("2"))
            {
                try {
                    
                    dos.writeUTF(Server_C.sort()+"");
                } catch (IOException ex) {
                    Logger.getLogger(Worker.class.getName()).log(Level.SEVERE, null, ex);
                }
                
            }
             // if the req msg is 1 so the client one need to request
              if(req.equals("3"))
            {
                try {
                    dos.writeUTF(Server_C.findMax()+"");
                } catch (IOException ex) {
                    Logger.getLogger(Worker.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
              // if the req msg is 1 so the client one need to request
               if(req.equals("4"))
            {
                try {
                    dos.writeUTF(+Server_C.Transpose()+"");
                } catch (IOException ex) {
                    Logger.getLogger(Worker.class.getName()).log(Level.SEVERE, null, ex);
                }
                
            }
               // if the req msg is 1 so the client one need to request
                if(req.equals("5"))
            {
                try {
                    dos.writeUTF(Server_C.count()+"");
                } catch (IOException ex) {
                    Logger.getLogger(Worker.class.getName()).log(Level.SEVERE, null, ex);
                }
                
            }
         
                System.out.println( "Time "+String.format("%.10f",(double)((System.nanoTime()-start_responstime)/1_000_000_000)));
        }
        
}
    
