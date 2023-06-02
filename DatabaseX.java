/**
 * @class DatabaseX
 * @brief Main Class DatabaseX, its basically the holder for the entire app and where all the other functions are called from.
 * @author Albert Corominas Mariscot
 */

import java.util.Scanner;
import java.util.Vector;

public class DatabaseX {

    private Printer p;

    private Vector<Table> tables;

    private Options o;

    private Scanner sc;

    private static DatabaseX db = new DatabaseX();

    /**
     @brief Main function of the program
     @param args        Arguments of the program
     @return Returns nothing.
     */
    public static void main(String[] args){

        db.p = new Printer();
        db.tables = new Vector<>();
        db.o = new Options(db.p);
        db.sc = new Scanner(System.in);

        //loadDummyData(tables);
        loadOptions();
        loadTablesFromFiles();
        printWelcome();
        printMainMenu();
        int option = askForInt(true,true,8,0);
        while(option!=0){
            switch(option) {
                case 1:
                    CreateTable();
                    break;
                case 2:
                    SelectTable();
                    break;
                case 3:
                    RemoveTable();
                    break;
                case 4:
                    CreateRegister();
                    break;
                case 5:
                    RemoveRegister();
                    break;
                case 6:
                    RollbackLast();
                    break;
                case 7:
                    OptionsMenu();
                    break;
                case 8:
                    StatsMenu();
                    break;
                case 9:
                    StatsTables();
                    break;
            }
            option = askForInt(true,true,8,0);
        }
        saveTablesOnFiles();
        db.p.println("END OF PROGRAM");
        db.p.println("Made by Albert Corominas Mariscot");
    }

    /**
     @brief Creates a new Table
     @return Returns nothing.
     */
    public static void CreateTable(){

    }

    /**
     @brief Select Table
     @return Returns nothing.
     */
    public static void SelectTable(){

    }

    /**
     @brief Remove a Table
     @return Returns nothing.
     */
    public static void RemoveTable(){

    }

    public static void CreateRegister(){

    }


    public static void RemoveRegister(){

    }

    /**
     @brief Rollbacks the last action
     @return Returns nothing.
     */
    public static void RollbackLast(){
        if(db.o.getRollbackFunction()) {

        } else {
            db.p.println("This option is currently disabled");
        }
    }

    public static void StatsMenu(){

    }

    public static void StatsTables(){

    }

    /**
     @brief Prints the welcome message
     @return Returns nothing.
     */
    public static void printWelcome(){
        db.p.println("Welcome user");
    }

    /**
     @brief Prints the main menu options
     @return Returns nothing.
     */
    public static void printMainMenu(){
        db.p.println("{ 0 }: Exit Application");
        db.p.println("{ 1 }: Create Table");
        db.p.println("{ 2 }: Select Table");
        db.p.println("{ 3 }: Remove Table");
        db.p.println("{ 4 }: Create Register");
        db.p.println("{ 5 }: Remove Register");
        db.p.println("{ 6 }: Rollback Last Action");
        db.p.println("{ 7 }: Options Menu");
        db.p.println("{ 8 }: Stats Menu");
        db.p.println("{ 9 }: Briefing of Tables");
    }

    /**
     @brief Asks for a Integer
     @param max         Boolean that indicates if the Integer has a maximum value or not
     @param min         Boolean that indicates if the Integer has a minimum value or not
     @param valMax      Maximum value of the Integer
     @param valMin      Minimum value of the Integer
     @return Returns the Integer asked.
     */
    public static int askForInt(boolean max, boolean min, int valMax, int valMin){
        int aux;
        if(max && min){
            db.p.println("Enter a Integer number (between "+valMin+" and "+valMax+"):");
            aux = db.sc.nextInt();
            while(aux<valMin || aux>valMax){
                db.p.println("Enter a Integer number (between "+valMin+" and "+valMax+"):");
                aux = db.sc.nextInt();
            }
        } else if(max){
            db.p.println("Enter a Integer number (maximum "+valMax+"):");
            aux = db.sc.nextInt();
            while(aux>valMax){
                db.p.println("Enter a Integer number (maximum "+valMax+"):");
                aux = db.sc.nextInt();
            }
        } else {
            db.p.println("Enter a Integer number (minimum "+valMin+"):");
            aux = db.sc.nextInt();
            while(aux<valMin){
                db.p.println("Enter a Integer number (minimum "+valMin+"):");
                aux = db.sc.nextInt();
            }
        }
        return aux;
    }

    /**
     @brief Asks for a Double
     @param max         Boolean that indicates if the Double has a maximum value or not
     @param min         Boolean that indicates if the Double has a minimum value or not
     @param valMax      Maximum value of the Double
     @param valMin      Minimum value of the Double
     @return Returns the Double entered by the user.
     */
    public static double askForDouble(boolean max, boolean min, double valMax, double valMin){
        double aux;
        if(max && min){
            db.p.println("Enter a Double number (between "+valMin+" and "+valMax+"):");
            aux = db.sc.nextInt();
            while(aux<valMin || aux>valMax){
                db.p.println("Enter a Double number (between "+valMin+" and "+valMax+"):");
                aux = db.sc.nextInt();
            }
        } else if(max){
            db.p.println("Enter a Double number (maximum "+valMax+"):");
            aux = db.sc.nextInt();
            while(aux>valMax){
                db.p.println("Enter a Double number (maximum "+valMax+"):");
                aux = db.sc.nextInt();
            }
        } else {
            db.p.println("Enter a Double number (minimum "+valMin+"):");
            aux = db.sc.nextInt();
            while(aux<valMin){
                db.p.println("Enter a Double number (minimum "+valMin+"):");
                aux = db.sc.nextInt();
            }
        }
        return aux;
    }

    /**
     @brief Asks for a String
     @param limited     Boolean that indicates if the String options are limited or not
     @param s           Vector of Strings that contains the possible Strings to enter
     @return Returns the String entered by the user.
     */
    public static String askForString(boolean limited, Vector<String> s){
        String aux = "";
        if(limited){
            while(!s.contains(aux)){
                System.out.print("Enter a String number from the list (");
                for(int i = 0; i<s.size(); i++){
                    db.p.print(s.elementAt(i));
                }
                db.p.println("):");
                aux = db.sc.nextLine();
            }

        } else {
            db.p.println("Enter a String:");
            aux = db.sc.nextLine();
        }
        return aux;
    }

    /**
     @brief Loads the dummy data on the system
     @return Returns nothing.
     */
    public static void loadDummyData(){
        db.p.println("Dummy data is being loaded on the system ...");


        db.p.println("Data load complete!");
    }

    /**
     @brief Saves the database tables on files
     @return Returns nothing.
     */
    public static void saveTablesOnFiles(){

    }

    /**
     @brief Loads the database tables from files
     @return Returns nothing.
     */
    public static void loadTablesFromFiles(){

    }

    public static void loadOptions(){

    }

    /**
     @brief Prints the options menu and asks for an option
     @return Returns nothing.
     */
    public static void OptionsMenu(){
        printOptionsMenu();
        int option = askForInt(true,true,3,0);
        int n;
        while(option!=0) {
            switch (option) {
                case 1:
                    db.o.displayOptions();
                    break;
                case 2:
                    n = askForInt(true,true,db.o.getSize(),1);
                    db.o.infoOption(n);
                    break;
                case 3:
                    n = askForInt(true,true,db.o.getSize(),1);
                    db.o.setOption(n);
                    break;
            }
            printOptionsMenu();
            option = askForInt(true,true,3,0);
        }
    }

    public static void printOptionsMenu() {
        db.p.println("{ 0 }: Exit Menu");
        db.p.println("{ 1 }: Display Number Options");
        db.p.println("{ 2 }: Display Info Options");
        db.p.println("{ 3 }: Modify Options");
    }
}
