import java.util.Scanner;
import java.util.Vector;

public class DatabaseX {
    public static void main(String[] args){
        Vector<Table> tables = new Vector<>();
        Options o = new Options();
        Printer p = new Printer();
        //loadDummyData(tables);
        loadOptions(o);
        loadTablesFromFiles(tables);
        Scanner sc = new Scanner(System.in);
        printMainMenu();
        int option = askForInt(sc,true,true,8,0);
        while(option!=0){
            switch(option) {
                case 1:
                    CreateTable(tables);
                    break;
                case 2:
                    SelectTable(tables);
                    break;
                case 3:
                    SelectTable(tables);
                    break;
                case 4:
                    SelectTable(tables);
                    break;
                case 5:
                    SelectTable(tables);
                    break;
                case 6:
                    if(o.getRollbackActions()) {
                        RollbackLast(tables);
                    } else {
                        System.out.println("<System> This option is currently disabled");
                    }
                    break;
                case 7:
                    OptionsMenu(sc,o);
                    break;
                case 8:
                    StatsMenu(tables);
                    break;
                case 9:
                    BriefingTables(tables);
                    break;
            }
            option = askForInt(sc,true,true,8,0);
        }
        saveTablesOnFiles(tables);
        System.out.println("<Misc> END OF PROGRAM");
        System.out.println("<System> Made by Albert Corominas Mariscot");
    }

    public static void printMainMenu(){
        System.out.println("{ 0 }: Exit Application");
        System.out.println("{ 1 }: Create Table");
        System.out.println("{ 2 }: Select Table");
        System.out.println("{ 3 }: Remove Table");
        System.out.println("{ 4 }: Create Registry");
        System.out.println("{ 5 }: Remove Registry");
        System.out.println("{ 6 }: Rollback Last Action");
        System.out.println("{ 7 }: Options Menu");
        System.out.println("{ 8 }: Stats Menu");
        System.out.println("{ 9 }: Briefing of Tables");
    }

    public static int askForInt(Scanner sc, boolean max, boolean min, int valMax, int valMin){
        int aux;
        if(max && min){
            System.out.println("<System> Enter a Integer number (between "+valMin+" and "+valMax+"):");
            aux = sc.nextInt();
            while(aux<valMin || aux>valMax){
                System.out.println("<System> Enter a Integer number (between "+valMin+" and "+valMax+"):");
                aux = sc.nextInt();
            }
        } else if(max){
            System.out.println("<System> Enter a Integer number (maximum "+valMax+"):");
            aux = sc.nextInt();
            while(aux>valMax){
                System.out.println("<System> Enter a Integer number (maximum "+valMax+"):");
                aux = sc.nextInt();
            }
        } else {
            System.out.println("<System> Enter a Integer number (minimum "+valMin+"):");
            aux = sc.nextInt();
            while(aux<valMin){
                System.out.println("<System> Enter a Integer number (minimum "+valMin+"):");
                aux = sc.nextInt();
            }
        }
        return aux;
    }

    public static double askForDouble(Scanner sc, boolean max, boolean min, double valMax, double valMin){
        double aux;
        if(max && min){
            System.out.println("<System> Enter a Double number (between "+valMin+" and "+valMax+"):");
            aux = sc.nextInt();
            while(aux<valMin || aux>valMax){
                System.out.println("<System> Enter a Double number (between "+valMin+" and "+valMax+"):");
                aux = sc.nextInt();
            }
        } else if(max){
            System.out.println("<System> Enter a Double number (maximum "+valMax+"):");
            aux = sc.nextInt();
            while(aux>valMax){
                System.out.println("<System> Enter a Double number (maximum "+valMax+"):");
                aux = sc.nextInt();
            }
        } else {
            System.out.println("<System> Enter a Double number (minimum "+valMin+"):");
            aux = sc.nextInt();
            while(aux<valMin){
                System.out.println("<System> Enter a Double number (minimum "+valMin+"):");
                aux = sc.nextInt();
            }
        }
        return aux;
    }

    public static String askForString(Scanner sc, boolean limited, Vector<String> s){
        String aux = "";
        if(limited){
            while(!s.contains(aux)){
                System.out.print("<System> Enter a String number from the list (");
                for(int i = 0; i<s.size(); i++){
                    System.out.print(s);
                }
                System.out.println("):");
                aux = sc.nextLine();
            }

        } else {
            System.out.print("<System> Enter a String number from the list (");
            for(int i = 0; i<s.size(); i++){
                System.out.print(s);
            }
            System.out.println("):");
        }
        return aux;
    }

    public static void loadDummyData(Vector<Table> tables){
        System.out.print("<System> Dummy data is being loaded on the system ...");

        System.out.print("<System> Data load complete!");
    }

    public static void saveTablesOnFiles(Vector<Table> tables){

    }

    public static void loadTablesFromFiles(Vector<Table> tables){

    }

    public static void loadOptions(Options o){

    }

    public static void OptionsMenu(Scanner sc, Options o){
        o.displayOptions();
        System.out.println("<System> Would you like to change any option? (0 none) (1-6 options)");
        int option = askForInt(sc,true,true,6,0);
        while(option != 0) {
            switch (option) {
                case 1:
                    o.setDynamicLoad();
                    break;
                case 2:
                    o.setDynamicSave();
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    break;
                case 6:
                    break;
            }
            System.out.println("<System> Would you like to change any option? (0 none) (1-6 options)");
            option = askForInt(sc, true, true, 6, 0);
        }
    }
}
