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

    public Matrix(int rowSize){
        vector = new Vector[rowSize];
    }

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

    public Vector[] getVector() {
        return vector;
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

    /*
    public void setElement(int row, int col, double value){

        try {
            vector[row].getTree().getRoot();
        }catch (NullPointerException npe){
            vector[row].addToTree(col,value);
//            vector[row].getTree().insert(vector[row].getTree().getRoot(),col,value);
//            wyjście z metody
        }
        catch (ArrayIndexOutOfBoundsException aiaobe){
            System.err.println("Element spoza zakresu: "+rowMax+" < "+ row  );
            System.exit(0);
        }
        try{
            vector[row].getTree().getRoot().getItem().getValue();
        }catch (NullPointerException npe) {
            vector[row].getTree().insert(vector[row].getTree().getRoot(), col, value);
        }
        if(vector[row].getTree().getRoot().getItem().getValue() !=0)
            vector[row].getTree().getRoot().getItem().setValue(value);
    }
    */

    public void setElement(int row, int col, double value) {

        if(vector[row].getTree().getRoot() == null){
            vector[row].getTree().insert(vector[row].getTree().getRoot(),col,value);
        }
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

    public Matrix add(Matrix matrix){
        Matrix matrix3 = new Matrix(rowMax);
        for (int i = 0; i < rowMax; i++){
            for (int j = 0; j<colMax;j++){
                try{
                    matrix.getVector()[j].getTree().getRoot();
                }catch(NullPointerException npe) {
                    try{
                        this.getVector()[j].getTree().getRoot();
                    }catch (NullPointerException npe2){
                        System.out.print("bbbb");
                        continue;
                    }
                    matrix3.setElement(i,j,this.getElement(i,j));
                    System.out.print("aaaa");
                }
                try{
                    this.getVector()[j].getTree().getRoot();
                }catch(NullPointerException npe) {
                    try{
                        matrix.getVector()[j].getTree().getRoot();
                    }catch (NullPointerException npe2){
                        System.out.print("bbbb");
                        continue;
                    }
                    matrix3.setElement(i,j,matrix.getElement(i, j));
                    System.out.print("aaaa");
                }
                System.err.println("to to");
                double tmp = this.getElement(i,j)+matrix.getElement(i,j);
                System.err.println(this.getElement(i, j));

                matrix3.setElement(i,j,tmp);
            }
        }
        return matrix;
    }
}
