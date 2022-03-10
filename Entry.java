/**
 * @class Entry
 * @brief This class represents an Entry of a Table.
 * @author Albert Corominas Mariscot
 */

import java.util.Vector;

public class Entry {
    private Vector<Object> entry_vals;
    private String entry_key;

    public Entry(Vector<Object> vals, String key) {
        this.entry_vals = vals;
        this.entry_key = key;
    }

    public void setKey(String key){
        entry_key = key;
    }

    public String getKey(){
        return entry_key;
    }

    public void addVal(Object o){
        entry_vals.add(o);
    }

    public void delVal(Object o){
        entry_vals.remove(o);
    }

    public void resetVal(Object o){

        entry_vals.add(o);
    }

    public void editVal(Object o){
        entry_vals.add(o);
    }

}
