import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class Printer {
    String fileName;
    FileWriter logFile;
    Printer(){
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy_HH:mm:ss");
        Date now = new Date();
        fileName = "DBX_"+dateFormat.format(now)+".txt";
        try {
            File aux = new File(fileName);
            if (aux.createNewFile()) {
                System.out.println("<System> Log file: " +fileName+" has been created");
            } else {
                System.out.println("<System> Log file: " +fileName+" has been created");
            }
        } catch (IOException e) {
            System.out.println("<System> An error has occurred with the log file.");
            e.printStackTrace();
        }
    }

    public void print(String s){
        try {
            logFile = new FileWriter(fileName);
            logFile.write(s);
            logFile.close();
        } catch (IOException e) {
            System.out.println("<System> An error has occurred with the log file.");
            e.printStackTrace();
        }
        System.out.println(s);
    }
}
