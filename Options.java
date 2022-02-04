public class Options {

    boolean enableDynamicSave; //True by default or not set
    //True: Tables will be saved in a dynamic manner during execution (Caution: times might get effected depending on data size)
    //False: Tables will be saved at the end of execution (Caution: Closing the program incorrectly will not save the changes)

    boolean enableRollbackFunction; //False by default or not set
    //True: Tables will have dynamically set a levels and sizes of caches, determined by data size and structure.
    //False: Caches will need to be set manually in the program (Slower user experience at Table Creation)

    boolean enableDynamicLoad; //True by default or not set
    //True: Tables will be loaded in memory as they are needed by user (Caution: times might get effected depending on data size)
    //False: All tables will be loaded at start of execution (Caution: If not possible, this option will be reverted to true)

    boolean enableSuperTableCaches; //True by default or not set
    //True: Tables will be assisted by caches that will help iterate through them (If True, consider setting tableCacheLevels and tableHasCache)
    //False: Tables will not be assisted by caches (Caution: times might get effected depending on data size)

    boolean enableTableCaches; //True by default or not set
    //True: Tables will have dynamically set a levels and sizes of caches, determined by data size and structure.
    //False: Caches will need to be set manually in the program (Slower user experience at Table Creation)

    boolean enableLogFile; //True by default or not set
    //True: Tables will have dynamically set a levels and sizes of caches, determined by data size and structure.
    //False: Caches will need to be set manually in the program (Slower user experience at Table Creation)

    Options(){
        enableDynamicLoad = true;
        enableTableCaches = true;
        enableDynamicSave = true;
        enableSuperTableCaches = true;
        enableRollbackFunction = false;
        enableLogFile = true;
    }

    public void setDynamicLoad(){
        enableDynamicLoad = !enableDynamicLoad;
        if(enableDynamicLoad){
            System.out.print("<System> Dynamic Load has been: Enabled ");
        } else {
            System.out.print("<System> Dynamic Load has been: Disabled ");
        }
    }

    public boolean getDynamicLoad(){
        return enableDynamicLoad;
    }

    public void setDynamicSave(){
        enableDynamicSave = !enableDynamicSave;
        if(enableDynamicSave){
            System.out.print("<System> Dynamic Save has been: Enabled ");
        } else {
            System.out.print("<System> Dynamic Save has been: Disabled ");
        }
    }

    public boolean getDynamicSave(){
        return enableDynamicSave;
    }

    public void setSuperTableCaches(){
        enableSuperTableCaches = !enableSuperTableCaches;
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

    public void displayOptions(){
        System.out.println("<System> Systems Options");
        System.out.print("<System> { 1 } Dynamic Load: ");
        if(enableDynamicLoad){
            System.out.println("Enabled");
        } else {
            System.out.println("Disabled");
        }
        System.out.print("<System> { 2 } Dynamic Save: ");
        if(enableDynamicSave){
            System.out.println("Enabled");
        } else {
            System.out.println("Disabled");
        }
        System.out.print("<System> { 3 } Super Table Caches: ");
        if(enableSuperTableCaches){
            System.out.println("Enabled");
        } else {
            System.out.println("Disabled");
        }
        System.out.print("<System> { 4 } Table Caches: ");
        if(enableTableCaches){
            System.out.println("Enabled");
        } else {
            System.out.println("Disabled");
        }
        System.out.print("<System> { 5 } Log File: ");
        if(enableLogFile){
            System.out.println("Enabled");
        } else {
            System.out.println("Disabled");
        }
        System.out.print("<System> { 6 } Rollback function: ");
        if(enableLogFile){
            System.out.println("Enabled");
        } else {
            System.out.println("Disabled");
        }
    }
}
