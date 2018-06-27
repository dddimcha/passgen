import java.io.BufferedInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;

public class downloadFromFTP {

    static void connectToServer(String un, String pw, String ip, String dir, String fn, String fp){

        URLConnection con;
        BufferedInputStream in = null;
        FileOutputStream out = null;

        try{
            URL url = new URL("ftp://"+un+":"+pw+"@"+ip+"/"+dir+"/"+fn+";type=i");
            con = url.openConnection();
            in = new BufferedInputStream(con.getInputStream());
            out = new FileOutputStream(fp+fn);

            int i = 0;
            byte[] bytesIn = new byte[1024];

            while ((i = in.read(bytesIn)) >= 0) {
                out.write(bytesIn, 0, i);
            }

        }catch(Exception e){
            System.out.print(e);
            e.printStackTrace();
            System.out.println("Error while FTP'ing "+fn);
        }finally{
            try{
                out.close();
                in.close();
            }catch(IOException e){
                e.printStackTrace();
                System.out.println("Error while closing FTP connection");
            }
        }
    }
}
