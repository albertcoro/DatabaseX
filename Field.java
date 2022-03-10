/**
 * @class Field
 * @brief This class represents a field with some variables to represent if fully.
 * @author Albert Corominas Mariscot
 */

public class Field {
    private Object type;
    private int size;
    private String name;

    public Field(Object type, String name) {
        this.type = type;
        this.name = name;
    }

    public Field(Object type, String name, int size) {
        this.type = type;
        this.name = name;
        this.size = size;
    }

    public Object getType(){
        return this.type;
    }

    public void setType(Object type){
        this.type = type;
    }

    public int getSize(){
        return this.size;
    }

    public void setSize(int size){
        this.size = size;
    }

    public String getName(){
        return this.name;
    }

    public void setName(String name){
        this.name = name;
    }
}
