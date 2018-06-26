import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class arrayWriter {
    public arrayWriter(String file, ArrayList<String> arr) {

        try ( BufferedWriter bw =
                      new BufferedWriter (new FileWriter (file)) ) {
            for (String line : arr) {
                bw.write (line + "\n");
            }

            bw.close ();

        } catch (IOException e) {
            e.printStackTrace ();
        }


    }
}
