import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Scanner;

public class dataIn {

    public void  datain() {

    PasswordGenerator passwordGenerator = new PasswordGenerator.PasswordGeneratorBuilder()
            .useDigits(true)
            .useLower(true)
            .useUpper(true)
            .build();

    Scanner sc = new Scanner(System.in);
    System.out.println("Type number of students: /n");
    int numberOfUseers = sc.nextInt();

    ArrayList<String> htac = new ArrayList<String>();
    ArrayList<String> pass = new ArrayList<String>();

    for (int step = 0; step < numberOfUseers; step++) {
        String password = passwordGenerator.generate(8); // output ex.: lrU12fmM 75iwI90o
        int b = step + 1;
        pass.add("student" + b + " " + password);
        try {
            htac.add("student" + b + ":$apr1$" + MD5Hash.MD5(password) + "/");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }

    try {
        htac.add("admin:$apr1$" + MD5Hash.MD5("pass") + "/");
    } catch (NoSuchAlgorithmException e) {
        e.printStackTrace();
    } catch (UnsupportedEncodingException e) {
        e.printStackTrace();
    }

    String[] rcpttt = {"rcpt"};

    mailSender ser = new mailSender("pwd", "user", rcpttt, "ss", pass.toString());
    arrayWriter writeHtpass = new arrayWriter("htpasswd", htac);
 }
}
