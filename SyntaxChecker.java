import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Vector;

/**
 * @class SyntaxChecker
 * @brief This class allows to check for errors or mistakes in the SQL Syntax entered by the user.
 * @author Albert Corominas Mariscot
 */

public class SyntaxChecker {

    private static final String SQL_WORD_FILE = "./utils/sqlWords.txt"; ///< Static file path to sql words file
    private Printer printer; ///< Printer that lets this class print all the info, errors and checks
    private Vector<String> sqlWords; ///< Vectors of reserved SQL words


    SyntaxChecker(Printer p){
        this.printer = p;
        loadWordsSQL();
    }

    public void loadWordsSQL(){
        try(BufferedReader in = new BufferedReader(new FileReader(SQL_WORD_FILE))) {
            String str;
            while ((str = in.readLine()) != null) {
                sqlWords.add(str);
            }
        }
        catch (IOException e) {
            System.out.println("File Read Error");
        }
    }

    public boolean isWordSQLSyntax(String s){

    }

    public boolean isStringSQLSyntax(){

    }

}
