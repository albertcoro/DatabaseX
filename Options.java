/**
 * @class Options
 * @brief This class allows to customize options that change the behaviour of the technical aspect of the app.
 * @author Albert Corominas Mariscot
 */

public class Options {

    private int num_options; ///< Number of options of the app
    Printer printer; ///< Printer Object to print missatges to screen and log files

    private boolean enableDynamicSave; ///< Option to dynamize the saving of tables to local files
    //Enabled (Default): Tables will be saved in a dynamic manner during execution (Caution: times might get effected depending on data size)
    //Disabled: Tables will be saved at the end of execution (Caution: Closing the program incorrectly will not save the changes)

    private boolean enableRollbackFunction; ///< Option to dynamize the saving of tables to local files
    //Enabled: Tables will have dynamically set a levels and sizes of caches, determined by data size and structure.
    //Disabled (Default): Caches will need to be set manually in the program (Slower user experience at Table Creation)

    private boolean enableDynamicLoad;
    //Enabled (Default): Tables will be loaded in memory as they are needed by user (Caution: times might get effected depending on data size)
    //Disabled: All tables will be loaded at start of execution (Caution: If not possible, this option will be reverted to Enabled)

    private boolean enableSuperTableCaches;
    //Enabled (Default): Tables will be assisted by caches that will help iterate through them (If Enabled, consider setting tableCacheLevels and tableHasCache)
    //Disabled: Tables will not be assisted by caches (Caution: times might get effected depending on data size)

    private boolean enableTableCaches;
    //Enabled (Default): Tables will have dynamically set a levels and sizes of caches, determined by data size and structure.
    //Disabled: Caches will need to be set manually in the program (Slower user experience at Table Creation)

    private boolean enableLogFile;
    //Enabled (Default): Tables will have dynamically set a levels and sizes of caches, determined by data size and structure.
    //Disabled: Caches will need to be set manually in the program (Slower user experience at Table Creation)

    Options(){
        enableDynamicLoad = true;
        enableTableCaches = true;
        enableDynamicSave = true;
        enableSuperTableCaches = true;
        enableRollbackFunction = false;
        enableLogFile = true;
        num_options = 6;
    }

    public void setPrinter(Printer p){
        this.printer = p;
    }

    public int getSize(){
        return num_options;
    }

    public void infoDynamicLoad(){
        if(enableDynamicLoad){
            printer.println("Dynamic Load: Set Enabled");
        } else {
            printer.println("Dynamic Load: Set Disabled");
        }
        printer.println("If Enabled: Tables will be loaded in memory as they are needed by user (Caution: times might get effected depending on data size)");
        printer.println("If Disabled: All tables will be loaded at start of execution (Caution: If not possible, this option will be reverted to Enabled)");
    }

    public void setDynamicLoad(){
        enableDynamicLoad = !enableDynamicLoad;
        if(enableDynamicLoad){
            System.out.print("Dynamic Load has been: Enabled ");
        } else {
            System.out.print("Dynamic Load has been: Disabled ");
        }
    }

    public boolean getDynamicLoad(){
        return enableDynamicLoad;
    }

    public void setDynamicSave(){
        enableDynamicSave = !enableDynamicSave;
        if(enableDynamicSave){
            System.out.print("Dynamic Save has been: Enabled ");
        } else {
            System.out.print("Dynamic Save has been: Disabled ");
        }
    }

    public boolean getDynamicSave(){
        return enableDynamicSave;
    }

    public void setSuperTableCaches(){
        enableSuperTableCaches = !enableSuperTableCaches;
        if(enableSuperTableCaches){
            System.out.print("Super Table Caches has been: Enabled ");
        } else {
            System.out.print("Dynamic Save has been: Disabled ");
        }
    }

    public boolean getSuperTableCaches(){
        return enableSuperTableCaches;
    }

    public void setTableCaches(){
        enableTableCaches = !enableTableCaches;
    }

    public boolean getTableCaches(){
        return enableTableCaches;
    }

    public void setLogFile(){
        enableLogFile = !enableLogFile;
    }

    public boolean getLogFile(){
        return enableLogFile;
    }

    public void setRollbackFunction(){
        enableRollbackFunction = !enableRollbackFunction;
    }

    public boolean getRollbackFunction(){
        return enableRollbackFunction;
    }

    public void infoOption(int n){
        switch (n) {
            case 1:
                infoDynamicLoad();
                break;
            case 2:
                infoDynamicSave();
                break;
            case 3:
                infoSuperTableCaches();
                break;
            case 4:
                setTableCaches();
                break;
            case 5:
                setLogFile();
                break;
            case 6:
                setRollbackFunction();
                break;
        }
    }

    public void setOption(int n){
        switch (n) {
            case 1:
                setDynamicLoad();
                break;
            case 2:
                setDynamicSave();
                break;
            case 3:
                setSuperTableCaches();
                break;
            case 4:
                setTableCaches();
                break;
            case 5:
                setLogFile();
                break;
            case 6:
                setRollbackFunction();
                break;
        }
    }

    public void displayOptions(){
        System.out.println("Systems Options");
        if(enableDynamicLoad){
            System.out.println("{ 1 } Dynamic Load: Enabled");
        } else {
            System.out.println("{ 1 } Dynamic Load: Disabled");
        }
        if(enableDynamicSave){
            System.out.println("{ 2 } Dynamic Save: Enabled");
        } else {
            System.out.println("{ 2 } Dynamic Save: Disabled");
        }
        if(enableSuperTableCaches){
            System.out.println("{ 3 } Super Table Caches: Enabled");
        } else {
            System.out.println("{ 3 } Super Table Caches: Disabled");
        }
        if(enableTableCaches){
            System.out.println("{ 4 } Table Caches: Enabled");
        } else {
            System.out.println("{ 4 } Table Caches: Disabled");
        }
        if(enableLogFile){
            System.out.println("{ 5 } Log File: Enabled");
        } else {
            System.out.println("{ 5 } Log File: Disabled");
        }
        if(enableRollbackFunction){
            System.out.println("{ 6 } Rollback function: Enabled");
        } else {
            System.out.println("{ 6 } Rollback function: Disabled");
        }
    }
}
