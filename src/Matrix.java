import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Created by HP on 07.11.2015.
 */
public class Matrix {
    private Vector[] vector;
    private int rowMax;
    private int colMax;

    public Matrix(String vectorName){
        vector = Vector.readMatrix(vectorName);
        readColAndRow(vectorName);
    }

    public int getColMax() {
        return colMax;
    }

    public int getRowMax() {
        return rowMax;
    }

    void readColAndRow(String fileName){
        File file = new File(fileName);

        try {
            Scanner scanner = new Scanner(file);
            rowMax = scanner.nextInt();
            colMax = scanner.nextInt();
        }catch (FileNotFoundException fnfe){
            System.err.println("Nie znaleziono pliku");
            System.exit(0);
        }
    }

    public double getElement(int row, int col){
        double tmp = 0;
        try {
            tmp = this.vector[row].getTree().serach(vector[row].getTree().getRoot(), col);
        }catch (NullPointerException npe){
            System.out.print("");
        }catch (ArrayIndexOutOfBoundsException aiaobe){
            System.err.println("Podano element ("+row+","+col+") z poza macierzy ("+rowMax+","+colMax+")");
        }
        return tmp;
    }

    public void setElement(int row, int col, double value){

        try {
            vector[row].getTree().getRoot();
        }catch (NullPointerException npe){
            vector[row] = new Vector();
        }
        catch (ArrayIndexOutOfBoundsException aiaobe){
            System.err.println("Element spoza zakresu: "+rowMax+" < "+ row  );
            System.exit(0);
        }
        vector[row].getTree().insert(vector[row].getTree().getRoot(), col, value);
    }

    public void readMatrix(String fileName){
        File file = new File(fileName);
        try {
            Scanner scanner = new Scanner(file);
            System.out.println(Integer.parseInt(scanner.next())+" "+ Integer.parseInt(scanner.next()));
            while (scanner.hasNext()){
                System.out.println(Integer.parseInt(scanner.next())+" "+ Integer.parseInt(scanner.next())+ " "+ Double.parseDouble(scanner.next()));
            }
        }catch (FileNotFoundException fnfe){
            System.err.println("Nie znaleziono pliku");
        }
    }
}
