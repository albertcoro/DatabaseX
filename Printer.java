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

    private String fileName; ///< Log file name
    private FileWriter logFile; ///< FileWritte object to write into the log file
    private Boolean existsLogFile; ///< Boolean option that checks if the file has been created successfully
    private DateFormat registerFormat; ///< Format witch the date needs to be represented, in the log files.
    private DateFormat fileFormat; ///< Format witch the file needs to be represented, upon creation.
    private Date now; ///< Date representing, the acutal moment the operation takes place
    private String finStringFile; ///< Final string that will be printed in the log file.

    /**
     @brief Empty constructor for printer, creates log file if it dosent exist.
     @throws IOException
     @return Object Printer.
     */
    Printer(){
        existsLogFile = true;
        registerFormat = new SimpleDateFormat("HH:mm:ss");
        fileFormat = new SimpleDateFormat("dd-MM-yyyy_HH:mm:ss");
        now = new Date();
        fileName = "./log/DBX_"+fileFormat.format(now)+".txt";
        try {
            File aux = new File(fileName);
            if (aux.createNewFile()) {
                System.out.println("Log file: " +fileName+" has been created");
            } else {
                System.out.println("Log file: " + fileName + " has been created");
            }
        } catch (IOException e) {
            System.out.println("<Error> An error has occurred with the log file.");
            existsLogFile = false;
            e.printStackTrace();
        }
    }

    /**
     @brief Given a string s, it will be printed onto the terminal and it will also be wrote in the log file.
     @param s               String that will be printed onto the terminal and log file.
     @return String has been printed and written.
     */
    public void print(String s){
        if(existsLogFile){
            try {
                finStringFile = s;
                logFile = new FileWriter(fileName,true);
                logFile.append(finStringFile);
                logFile.close();
            } catch (IOException e) {
                System.out.print("<System> An error has occurred with the log file.");
                e.printStackTrace();
            }
        }
        System.out.print(s);
    }

    /**
     @brief Given a string s (followed by a end of line character), it will be printed onto the terminal and it will also be wrote in the log file.
     @param s               String that will be printed onto the terminal and log file.
     @return String has been printed and written.
     */
    public void println(String s){
        if(existsLogFile) {
            try {
                now = new Date();
                finStringFile = "<" +registerFormat.format(now)+ "> " + s + "\n";
                logFile = new FileWriter(fileName,true);
                logFile.append(finStringFile);
                logFile.close();
            } catch (IOException e) {
                System.out.println("<System> An error has occurred with the log file.");
                e.printStackTrace();
            }
        }
        System.out.println(s);
    }
}
