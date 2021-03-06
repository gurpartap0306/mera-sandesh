import java.io.*;
import java.net.*;

public class AppServer{
  String [] adviceList={"take smaller bites"};

  public void go(){
    try{
      ServerSocket serverSock =new ServerSocket(4242);

      while(true){
        Socket sock = serverSock.accept();
        PrintWriter writer = new PrintWriter(sock.getOutputStream());
        String advice = getAdvice();
        writer.close();
        System.out.println(advice);
      }

    }catch(IOException ex){
      ex.printStackTrace();
    }
  }
  private String getAdvice(){
    int random =(int)(Math.random()*adviceList.length);
    return adviceList[random];
  }
  public static void main(String[] args){
    AppServer server = new AppServer();
    server.go();
  }
}