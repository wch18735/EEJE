package soket;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Scanner;

public class UdpSenderThread extends Thread {

   @Override
   public void run() {
      // TODO Auto-generated method stub
      // super.run();

      Scanner scan = new Scanner(System.in);
      try {
         DatagramSocket socket = new DatagramSocket();
         while (true) {
            String msg = scan.nextLine();
            byte[] buf = msg.getBytes();
            DatagramPacket packet = new DatagramPacket(buf, buf.length, InetAddress.getByName("10.20.15.241"),5000);
            socket.send(packet);
         }
      } catch (SocketException e) {
         // TODO Auto-generated catch block
         e.printStackTrace();
      } catch (UnknownHostException e) {
         // TODO Auto-generated catch block
         e.printStackTrace();
      } catch (IOException e) {
         // TODO Auto-generated catch block
         e.printStackTrace();
      }

   }

}