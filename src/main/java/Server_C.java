
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Random;
import java.util.Stack;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Server_C {
    // introduce  amd make zide to 10
    private static int[][] Materx = new int[10][10];

    public Server_C() {
//        the contructer he is in initialize the data to matrix
        for (int i = 0; i < 10; i++) 
        {
            for (int j = 0; j < 10; j++) {
                //make radom number and initialize to index 
                //using random function i made it and i put number between 30 amd 40 
                // becouse the matrex have good appearance 
                this.Materx[i][j] = random(30, 40);
            }
        }
    }

    public int random(int min, int max) 
    {
        //calculate the random number
        return (int) (Math.random() * ((max - min) + 1)) + min;
    }
        
    //methon to print matrix 
      public static void print(int[][] array)
      {
           for (int i=0; i<10 ;i++)
           {
            for (int j=0;j<10;j++)
            {
                System.out.print(array[i][j]+"  ");
            }
               System.out.println();
            }
      }
      

    // method to make   summation for the matrix
      // and return the sum 
      // need 2 foor loop to move in the matrix index index 
      // i know the Complexity is very high but i use the Easy way 
    public static int summation() {
        int sum = 0;

        for (int i = 0; i < 10; i++) 
        {
            for (int j = 0; j < 10; j++) 
            {
                sum = Materx[i][j] + sum;
            }
        }
        System.out.println("sum is " + sum);
        return sum;
    }
    
//    method to sort the array ascendingly and then print the assinding matrix
//    first i make a stake becouse it save data using lifo datastruthers 
//    so i need to put the max number on it so the last index in list it wiil be the min number 
//    so then i need to push to new matrix 
    
    public static int[][] sort() {
        Stack<Integer> sorted_array = new Stack<Integer>();
        int[][] sorted_matrix = new int[10][10];
        int max = 40;
            
        // Process of put the number in stak
        while (max > 29) 
        {
            for (int i = 0; i < 10; i++) 
            {
                for (int j = 0; j < 10; j++) 
                {
                    if (max == Materx[i][j]) 
                    {
                        sorted_array.push(max);
                    }
                }
            }
                // becous i know the max number in matrex every lap in matrex 
                //i Poses from one so the last max it will be the min number
            max = max - 1;
        }
        
        // sorting  the matrix
        // Process of push the number from stak to new matrix
        for (int i = 0; i < 10; i++) 
        {
            for (int j = 0; j < 10; j++) 
            {
                sorted_matrix[i][j] = sorted_array.pop();
                System.out.print(sorted_matrix[i][j] + "  ");
            }
            System.out.println();
        }
        return sorted_matrix;

    }

    // methon find its very easy to write 
    // just i need insted loop and is suppos the max number is the index [0][0]
    //then i need to Comparison with the next index  
    public static int findMax() {
        int max = Materx[0][0];
        for (int i = 1; i < 10; i++) 
        {
            for (int j = 0; j < 10; j++) 
            {
                // the Comparison process
                if (max < Materx[i][j]) 
                {
                    max = Materx[i][j];
                }
            }
        }
        System.out.println("Max is = "+max);
        return max;
    }

    
    // method i need to swap evry elinet in the matrix Except the number in symmetric index 
    // so i just ned to swap the upper tiangle with loower triangle in mahtrix 
    public static int Transpose() {
        
        for (int x = 0; x < 10; x++) 
        {
            for (int y = x + 1; y < 10; y++) 
            {
                int temp = Materx[x][y];
                Materx[x][y] = Materx[y][x];
                Materx[y][x] = temp;
            }
        }
        System.out.println("Transposed Matrix");
        print(Materx);
        return 0;
    }

    
    // in the count numbers i use the hashmape 
    //becous it have key and value so i cane Comparison the key with her value 
    //and add it to counter 
    public static int count() {
        
        HashMap<Integer, Integer> hm = new HashMap<>();
        for (int[] e : Materx) {
            for (int x : e) 
            {
                // i  check the number if it  in hash map or nut if nut add it
                // else add add to the key one to calculate
                // i use this solution becouse i solve hw in python this summer like this
                if (!hm.containsKey(x)) 
                {
                    hm.put(x, 1);
                } else 
                {
                    hm.replace(x, hm.get(x) + 1);
                }
            }
        }
        // print the counter number
        System.out.println("Counting the number");
        for (int item : hm.keySet()) {
            System.out.println("number "+item + " / " + hm.get(item));
        }
        return 0;
    }
    // this is the start method  to run the server 
    //first i print the orginal matrix 
    // then i initialize serverSoket  name it server
   
    public static void start()
    {
        System.out.println("The Orginal Matrix ");
          print(Materx);
        System.out.println("");
        ServerSocket server;
        // we put the all  initialize socket and serverSocket in try 
        // becouse the language need this 
        // becouse it think the serversocket will not be initialize
        try 
        {
            // the server port 
            server = new ServerSocket(1234);
            // i  need to make thread here becouse the gui when i run the server 
            // Always still running and not responce 
            new Thread(() -> 
            {
                // initialize the socket 
                Socket s;
                // this to make Multithreading  the while loop to take many req from clients 
                while (true) {

                    try {
                        // accept the req from server 
                        s = server.accept();
                        // send it with the worker class on the constrectour 
                        Worker wk = new Worker(s);
                        Thread t = new Thread(wk);
                        t.start();
                    } 
                    catch (IOException ex) 
                    {
                        Logger.getLogger(Server_C.class.getName()).log(Level.SEVERE, null, ex);
                    }

                }

            }
            ).start();
            //start the thread
        } 
        catch (IOException ex) 
        {
            Logger.getLogger(NewJFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
            
    }    
    
}
