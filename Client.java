import java.io.*;
import java.util.*;
import java.net.*;


public class Client {
    
        public static void main(String[] args) throws Exception {
               
                Socket socket = new Socket("127.0.0.1",8940);
                System.out.println("Connected to Server.");
                Scanner keyboard = new Scanner(System.in);
                System.out.println("Enter the 3 edge lengths in the form: 'a b c'");
                int a,b,c;
                a = keyboard.nextInt();
                b = keyboard.nextInt();
                c = keyboard.nextInt();
                DataOutputStream out = new DataOutputStream(socket.getOutputStream());
                DataInputStream in = new DataInputStream(socket.getInputStream());
                out.writeUTF(a+" "+b+" "+c);
                String ans = in.readUTF();
                System.out.println("Ans: "+ans);
                out.close();
                socket.close();
                keyboard.close();
                in.close();
        }

}