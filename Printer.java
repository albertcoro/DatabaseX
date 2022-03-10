/**
 * @class Printer
 * @brief This class full funcion is to display on terminal screen and in the log file simultaniously, log
 *     files will be kept int the /log directory as a simple txt file. The messages will contain current date, and for
 *     each run of the program one file will be created.
 * @author Albert Corominas Mariscot
 */

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class Printer {
    String fileName;
    FileWriter logFile;
    boolean existsLogFile;

    Printer(){
        existsLogFile = true;
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy_HH:mm:ss");
        Date now = new Date();
        fileName = "./log/DBX_"+dateFormat.format(now)+".txt";
        try {
            File aux = new File(fileName);
            if (aux.createNewFile()) {
                System.out.println("<System> Log file: " +fileName+" has been created");
            } else {
                System.out.println("<System> Log file: " + fileName + " has been created");
            }
        } catch (IOException e) {
            System.out.println("<System> An error has occurred with the log file.");
            existsLogFile = false;
            e.printStackTrace();
        }
    }

    public void print(String s){
        if(existsLogFile){
            try {
                s = "<System> "+s;
                logFile = new FileWriter(fileName);
                logFile.write(s);
                logFile.close();
            } catch (IOException e) {
                System.out.print("<System> An error has occurred with the log file.");
                e.printStackTrace();
            }
        }
        System.out.print(s);
    }

    public void println(String s){
        if(existsLogFile) {
            try {
                s = "<System> "+s;
                logFile = new FileWriter(fileName);
                logFile.write(s);
                logFile.close();
            } catch (IOException e) {
                System.out.println("<System> An error has occurred with the log file.");
                e.printStackTrace();
            }
        }
        System.out.println(s);
    }
}
