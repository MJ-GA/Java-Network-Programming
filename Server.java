import java.net.*;
import java.io.*;

public class Server {

        public static void main(String[] args) throws Exception{
                int port=8940;

                ServerSocket server = new ServerSocket(port);
                System.out.println("Server Started Listening on port: "+port);
                System.out.println("Now waiting for a client to connect");
                Socket socket = server.accept();
                System.out.println("Client connection accepted.");
                DataInputStream in = new DataInputStream(new BufferedInputStream(socket.getInputStream()));
                DataOutputStream out = new DataOutputStream(socket.getOutputStream());
                String line = in.readUTF();
                String[] s = line.split(" ");
                int a = Integer.parseInt(s[0]);
                int b = Integer.parseInt(s[1]);
                int c = Integer.parseInt(s[2]);
                
                System.out.println("Client requested for a="+a+" b="+b+" c="+c);
                
                
                boolean ans = isValid(a,b,c);
                
               
                if(ans){
                                out.writeUTF("Wrong password !! ");
                }
                else{
                                out.writeUTF("Welcome ! ");
                }
              
                socket.close();
                in.close();
        }

    
        public static boolean isValid(int a,int b, int c) 
    { 
        if (a + b <= c || a + c <= b || b + c <= a) 
            return false; 
        else
            return true; 
    } 
}