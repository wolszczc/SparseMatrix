/**
 * Created by HP on 08.11.2015.
 */
public class TestMatrix {
    public static void main(String[] args) {

        Matrix matrixA = new Matrix("C:\\Users\\Cezary\\IdeaProjects\\SparseMatrix\\src/A.txt");
        Matrix matrixB = new Matrix("C:\\Users\\Cezary\\IdeaProjects\\SparseMatrix\\src/B.txt");
        Matrix matrixC = null;

        System.out.println(matrixA.getElement(5, 6));
        matrixA.setElement(5, 6, 9.9);
        System.out.println(matrixA.getElement(5, 6));
//
//        System.out.println("A");
////        matrixA.readMatrix("C:\\Users\\Cezary\\IdeaProjects\\SparseMatrix\\src/A.txt");
//        matrixC = matrixA.add(matrixB);
//
//        System.err.println(matrixC.getElement(5,5));
    }

}
