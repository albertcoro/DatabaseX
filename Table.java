/**
 * @class Table
 * @brief This class represents a table with an identifier key and a table name.
 * @author Albert Corominas Mariscot
 */

import java.nio.charset.Charset;
import java.util.*;

public class Table {
    private String table_name; ///< Name of the table
    private String table_key; ///< Key identifier of the table
    private Vector<Entry> entries_obj; ///< Array of entries of this table
    private Vector<Field> table_fields; ///< Array of fields of this table
    private int table_size; ///< Size of the table

    /**
     @brief Default Constructor Method for a Table
     @pre table_key != null && table_name != null
     @post Create Table Object with table_key identifier and table_name
     */
    public Table(String table_key, String table_name){
        this.table_fields = new Vector<>();
        this.entries_obj = new Vector<>();
        this.table_key = table_key;
        this.table_name = table_name;
        this.table_size = 0;
    }

    /**
     @brief Getter Table Name
     @pre True
     @post Return Table Name
     */
    public String getTable_name(){
        return table_name;
    }

    /**
     @brief Setter Table Name
     @pre name!=null
     @post Table Name has been set
     */
    public void setTable_name(String name){
        table_name = name;
    }

    /**
     @brief Getter Table Key
     @pre True
     @post Return Table Key
     */
    public String getTable_key(){
        return table_key;
    }

    /**
     @brief Setter Table Key
     @pre name!=null
     @post Table Key has been set
     */
    public void setTable_key(String key){
        table_key = key;
    }

    /**
     @brief Add Entry to the Table
     @pre e!=null
     @post The Entry has been added to the Table
     */
    public boolean addEntry(Entry e){

        table_size++;
        return true;
    }

    /**
     @brief Delete Entry to the Table
     @pre e!=null
     @post The Entry has been delete to the Table
     */
    public boolean deleteEntry(Entry e){

        return true;
    }

    /**
     @brief Edit Entry from the Table
     @pre e!=null
     @post The Entry has been edit from the Table
     */
    public boolean editEntry(Entry e){

        return true;
    }

    /**
     @brief Returns if an Entry exists in the Table
     @pre e!=null
     @post True if the entry exists in the table, false otherwise
     */
    public Entry existEntry(Entry e){
        return e;
    }

    /**
     @brief Returns if a key of an Entry exists in the Table
     @pre key!=null
     @post True if the entry exists in the table, false otherwise
     */
    public Entry existEntry(String key){
        return new Entry(new Vector<>(),"test");
    }

    /**
     @brief Add a field to the Table
     @pre field!=null
     @post True if field has been succesfully added to the table, false otherwise
     */
    public boolean addField(String field){
        for(int i=0; i<table_fields.size(); i++){

        }
        return true;
    }

    /**
     @brief Delete a field from the Table
     @pre field!=null
     @post True if field has been succesfully delete from the table, false otherwise
     */
    public boolean deleteField(String field){
        return true;
    }

    /**
     @brief Edit a field from the Table
     @pre field!=null
     @post True if field has been succesfully edited from the table, false otherwise
     */
    public boolean editField(String field){
        return true;
    }

    /**
     @brief Returns if exists a field in the Table
     @pre field!=null
     @post True if field exists in the table, false otherwise
     */
    public boolean existField(String field){
        return true;
    }

    /**
     @brief Returns a random key that identifies an entry.
     @pre --
     @post Return a key.
     */
    private String getRandKey(){
        byte[] array = new byte[10];
        new Random().nextBytes(array);
        String s = new String(array, Charset.forName("UTF-8"));
        while(existEntry(s)==null){
            s = new String(array, Charset.forName("UTF-8"));
        }
        return s;
    }
}
