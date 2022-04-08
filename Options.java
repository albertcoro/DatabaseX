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

    private boolean enableRollbackFunction; ///< Option to enable rolling back actions in the program
    //Enabled: Tables will have dynamically set a levels and sizes of caches, determined by data size and structure.
    //Disabled (Default): Caches will need to be set manually in the program (Slower user experience at Table Creation)

    private boolean enableDynamicLoad; ///< Option to dynamize the loading of tables from local files
    //Enabled (Default): Tables will be loaded in memory as they are needed by user (Caution: times might get effected depending on data size)
    //Disabled: All tables will be loaded at start of execution (Caution: If not possible, this option will be reverted to Enabled)

    private boolean enableSuperTableCaches; ///< Option to enable cache management for tables of tables
    //Enabled (Default): Tables will be assisted by caches that will help iterate through them (If Enabled, consider setting tableCacheLevels and tableHasCache)
    //Disabled: Tables will not be assisted by caches (Caution: times might get effected depending on data size)

    private boolean enableTableCaches; ///< Option to enable cache management of the database tables
    //Enabled (Default): Tables will have dynamically set a levels and sizes of caches, determined by data size and structure.
    //Disabled: Caches will need to be set manually in the program (Slower user experience at Table Creation)

    private boolean enableLogFile; ///< Option to enable the saving of logs from the program onto a file
    //Enabled (Default): Tables will have dynamically set a levels and sizes of caches, determined by data size and structure.
    //Disabled: Caches will need to be set manually in the program (Slower user experience at Table Creation)

    private boolean enableDoubleCheck; ///< Option to enable a "Are you sure?" question on meaningful queries (Delete, Update, etc.)
    //Enabled (Default): A user interaction will appear asking if "Are you sure, you wanna commit this transaction?"
    //Disabled: User will not be warned about meaningful queries (Recommended for experienced user or mad people!)

    /**
     @brief Empty constructor for the options of the program
     @param p           Printer that will be used to print info about the options
     @return Returns Options Object.
     */
    Options(Printer p){
        this.enableDynamicLoad = true;
        this.enableTableCaches = true;
        this.enableDynamicSave = true;
        this.enableSuperTableCaches = true;
        this.enableRollbackFunction = false;
        this.enableLogFile = true;
        this.num_options = 6;
        this.printer = p;
    }

    /**
     @brief Returns the amount of options the program has available.
     @return Returns num of options.
     */
    public int getSize(){
        return num_options;
    }

    /**
     @brief Prints info about dynamic load option.
     @return Prints info about dynamic load option.
     */
    public void infoDynamicLoad(){
        if(enableDynamicLoad){
            printer.println("Dynamic Load: Set Enabled");
        } else {
            printer.println("Dynamic Load: Set Disabled");
        }
        printer.println("If Enabled: Tables will be loaded in memory as they are needed by user (Caution: times might get effected depending on data size)");
        printer.println("If Disabled: All tables will be loaded at start of execution (Caution: If not possible, this option will be reverted to Enabled)");
    }

    /**
     @brief Changes the dynamic load option from on to off or vice versa.
     @return Dyanmic load option has been modified.
     */
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

    /**
     @brief Prints info about dynamic save option.
     @return --
     */
    public void infoDynamicSave(){
        if(enableDynamicLoad){
            printer.println("Dynamic Save: Set Enabled");
        } else {
            printer.println("Dynamic Save: Set Disabled");
        }
        printer.println("If Enabled: Tables will be saved in a dynamic manner during execution (Caution: times might get effected depending on data size)");
        printer.println("If Disabled: Tables will be saved at the end of execution (Caution: Closing the program incorrectly will not save the changes)");
    }

    /**
     @brief Changes the dynamic save option from on to off or vice versa.
     @return Dyanmic save option has been modified.
     */
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

    /**
     @brief Prints info about super table caches option.
     @return --
     */
    public void infoSuperTableCaches(){
        if(enableDynamicLoad){
            printer.println("Dynamic Save: Set Enabled");
        } else {
            printer.println("Dynamic Save: Set Disabled");
        }
        printer.println("If Enabled: Tables will be saved in a dynamic manner during execution (Caution: times might get effected depending on data size)");
        printer.println("If Disabled: Tables will be saved at the end of execution (Caution: Closing the program incorrectly will not save the changes)");
    }

    /**
     @brief Changes the super table caches option from on to off or vice versa.
     @return Super table caches option has been modified.
     */
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

    /**
     @brief Prints info about info table caches option.
     @return --
     */
    public void infoTableCaches(){
        if(enableDynamicLoad){
            printer.println("Dynamic Save: Set Enabled");
        } else {
            printer.println("Dynamic Save: Set Disabled");
        }
        printer.println("If Enabled: Tables will be saved in a dynamic manner during execution (Caution: times might get effected depending on data size)");
        printer.println("If Disabled: Tables will be saved at the end of execution (Caution: Closing the program incorrectly will not save the changes)");
    }

    /**
     @brief Changes the table chaches option from on to off or vice versa.
     @return Table caches option has been modified.
     */
    public void setTableCaches(){
        enableTableCaches = !enableTableCaches;
    }

    public boolean getTableCaches(){
        return enableTableCaches;
    }

    /**
     @brief Prints info about log file option.
     @return --
     */
    public void infoLogFile(){
        if(enableDynamicLoad){
            printer.println("Dynamic Save: Set Enabled");
        } else {
            printer.println("Dynamic Save: Set Disabled");
        }
        printer.println("If Enabled: Tables will be saved in a dynamic manner during execution (Caution: times might get effected depending on data size)");
        printer.println("If Disabled: Tables will be saved at the end of execution (Caution: Closing the program incorrectly will not save the changes)");
    }

    /**
     @brief Changes the log file option from on to off or vice versa.
     @return Log file option has been modified.
     */
    public void setLogFile(){
        enableLogFile = !enableLogFile;
    }

    public boolean getLogFile(){
        return enableLogFile;
    }

    /**
     @brief Prints info about rollback function option.
     @return --
     */
    public void infoRollbackFunction(){
        if(enableDynamicLoad){
            printer.println("Dynamic Save: Set Enabled");
        } else {
            printer.println("Dynamic Save: Set Disabled");
        }
        printer.println("If Enabled: Tables will be saved in a dynamic manner during execution (Caution: times might get effected depending on data size)");
        printer.println("If Disabled: Tables will be saved at the end of execution (Caution: Closing the program incorrectly will not save the changes)");
    }

    /**
     @brief Changes the rollback funciton option from on to off or vice versa.
     @return Rollback function option has been modified.
     */
    public void setRollbackFunction(){
        enableRollbackFunction = !enableRollbackFunction;
    }

    public boolean getRollbackFunction(){
        return enableRollbackFunction;
    }

    /**
     @brief Prints info about a given option of the program.
     @param n               Option witch info will be printed.
     @return Prints info about n option.
     */
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

    /**
     @brief Modifies the option of n, that meaning changing from on to off or vice versa
     @param n               Option witch info will be modified.
     @return Option n has been modified.
     */
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

    /**
     @brief Displays the current state of all the options in the system.
     @return Information has been printed.
     */
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
