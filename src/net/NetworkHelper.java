package net;

import model.Library;
import model.User;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;

public class NetworkHelper {
    static Socket socket;
    static PrintStream ps;
    static BufferedReader br;
    static ObjectInputStream cois = null;
    static ObjectOutputStream coos = null;
    static FileOutputStream fos=null;

    public static void connect(){
        try {
            socket = new Socket(InetAddress.getLocalHost(), 8071);
            ps = new PrintStream(socket.getOutputStream());
            br = new BufferedReader(new InputStreamReader(System.in));
            coos = new ObjectOutputStream(socket.getOutputStream());
            cois = new ObjectInputStream(socket.getInputStream());

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void passValue(int choise,Library lib){
        try{
            Request request =new Request(lib,choise);
            coos.writeObject(request);
            lib=(Library)cois.readObject();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    public static void passValue(int choise, User user){
        try{
            Request request =new Request(user,choise);
            coos.writeObject(request);
            //lib=(Library)cois.readObject();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void disconnect() {
        try {
            if (ps != null) ps.close();
            if (br != null) br.close();
            if (fos != null) fos.close();
            if (cois != null)cois.close();
            if (coos != null) coos.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            System.exit(0);
        }
    }
}
