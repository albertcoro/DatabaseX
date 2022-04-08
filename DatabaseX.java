/**
 * @class DatabaseX
 * @brief Main Class DatabaseX, its basically the holder for the entire app and where all the other functions are called from.
 * @author Albert Corominas Mariscot
 */

import java.util.Scanner;
import java.util.Vector;

public class DatabaseX {
    public static void main(String[] args){

        Printer p = new Printer();
        Vector<Table> tables = new Vector<>();
        Options o = new Options(p);
        SyntaxChecker s = new SyntaxChecker(p);

        //loadDummyData(tables);
        loadOptions(o);
        loadTablesFromFiles(tables);
        Scanner sc = new Scanner(System.in);
        printWelcome(p);
        printMainMenu(p);
        String option = askForString();
        while(option!=0){
            switch(option) {
                case 1:
                    CreateTable(p,tables);
                    break;
                case 2:
                    SelectTable(p,tables);
                    break;
                case 3:
                    RemoveTable(p,tables);
                    break;
                case 4:
                    CreateRegister(p,tables);
                    break;
                case 5:
                    RemoveRegister(p,tables);
                    break;
                case 6:
                    RollbackLast(p,tables,o);
                    break;
                case 7:
                    OptionsMenu(p,sc,o);
                    break;
                case 8:
                    StatsMenu(p,tables);
                    break;
                case 9:
                    StatsTables(p,tables);
                    break;
            }
            option = askForInt(p,sc,true,true,8,0);
        }
        saveTablesOnFiles(tables);
        p.println("END OF PROGRAM");
        p.println("Made by Albert Corominas Mariscot");
    }

    /**
     @brief Empty constructor for the options of the program
     @param p           Printer that will be used to print info about the options
     @return Returns Options Object.
     */
    public static void CreateTable(Printer p, Vector<Table> tables){

    }

    public static void SelectTable(Printer p, Vector<Table> tables){

    }

    public static void RemoveTable(Printer p, Vector<Table> tables){

    }

    public static void CreateRegister(Printer p, Vector<Table> tables){

    }

    public static void RemoveRegister(Printer p, Vector<Table> tables){

    }

    public static void RollbackLast(Printer p, Vector<Table> tables, Options o){
        if(o.getRollbackFunction()) {

        } else {
            p.println("This option is currently disabled");
        }
    }

    public static void StatsMenu(Printer p, Vector<Table> tables){

    }

    public static void StatsTables(Printer p, Vector<Table> tables){

    }

    public static void printWelcome(Printer p){
        p.println("Welcome user");
    }

    public static void printMainMenu(Printer p){
        p.println("{ 0 }: Exit Application");
        p.println("{ 1 }: Create Table");
        p.println("{ 2 }: Select Table");
        p.println("{ 3 }: Remove Table");
        p.println("{ 4 }: Create Register");
        p.println("{ 5 }: Remove Register");
        p.println("{ 6 }: Rollback Last Action");
        p.println("{ 7 }: Options Menu");
        p.println("{ 8 }: Stats Menu");
        p.println("{ 9 }: Briefing of Tables");
    }

    public static int askForInt(Printer p, Scanner sc, boolean max, boolean min, int valMax, int valMin){
        int aux;
        if(max && min){
            p.println("Enter a Integer number (between "+valMin+" and "+valMax+"):");
            aux = sc.nextInt();
            while(aux<valMin || aux>valMax){
                p.println("Enter a Integer number (between "+valMin+" and "+valMax+"):");
                aux = sc.nextInt();
            }
        } else if(max){
            p.println("Enter a Integer number (maximum "+valMax+"):");
            aux = sc.nextInt();
            while(aux>valMax){
                p.println("Enter a Integer number (maximum "+valMax+"):");
                aux = sc.nextInt();
            }
        } else {
            p.println("Enter a Integer number (minimum "+valMin+"):");
            aux = sc.nextInt();
            while(aux<valMin){
                p.println("Enter a Integer number (minimum "+valMin+"):");
                aux = sc.nextInt();
            }
        }
        return aux;
    }

    public static double askForDouble(Printer p, Scanner sc, boolean max, boolean min, double valMax, double valMin){
        double aux;
        if(max && min){
            p.println("Enter a Double number (between "+valMin+" and "+valMax+"):");
            aux = sc.nextInt();
            while(aux<valMin || aux>valMax){
                p.println("Enter a Double number (between "+valMin+" and "+valMax+"):");
                aux = sc.nextInt();
            }
        } else if(max){
            p.println("Enter a Double number (maximum "+valMax+"):");
            aux = sc.nextInt();
            while(aux>valMax){
                p.println("Enter a Double number (maximum "+valMax+"):");
                aux = sc.nextInt();
            }
        } else {
            p.println("Enter a Double number (minimum "+valMin+"):");
            aux = sc.nextInt();
            while(aux<valMin){
                p.println("Enter a Double number (minimum "+valMin+"):");
                aux = sc.nextInt();
            }
        }
        return aux;
    }

    public static String askForString(Printer p, Scanner sc, boolean limited, Vector<String> s){
        String aux = "";
        if(limited){
            while(!s.contains(aux)){
                System.out.print("Enter a String number from the list (");
                for(int i = 0; i<s.size(); i++){
                    p.print(s.elementAt(i));
                }
                p.println("):");
                aux = sc.nextLine();
            }

        } else {
            p.println("Enter a String:");
            aux = sc.nextLine();
        }
        return aux;
    }

    public static void loadDummyData(Printer p, Vector<Table> tables){
        p.println("Dummy data is being loaded on the system ...");


        p.println("Data load complete!");
    }

    public static void saveTablesOnFiles(Vector<Table> tables){

    }

    public static void loadTablesFromFiles(Vector<Table> tables){

    }

    public static void loadOptions(Options o){

    }

    public static void OptionsMenu(Printer p, Scanner sc, Options o){
        printOptionsMenu(p);
        int option = askForInt(p,sc,true,true,3,0);
        int n;
        while(option!=0) {
            switch (option) {
                case 1:
                    o.displayOptions();
                    break;
                case 2:
                    n = askForInt(p,sc,true,true,o.getSize(),1);
                    o.infoOption(n);
                    break;
                case 3:
                    n = askForInt(p,sc,true,true,o.getSize(),1);
                    o.setOption(n);
                    break;
            }
            printOptionsMenu(p);
            option = askForInt(p,sc,true,true,3,0);
        }
    }

    public static void printOptionsMenu(Printer p) {
        p.println("{ 0 }: Exit Menu");
        p.println("{ 1 }: Display Number Options");
        p.println("{ 2 }: Display Info Options");
        p.println("{ 3 }: Modify Options");
    }
}
