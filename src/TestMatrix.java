/**
 * Created by HP on 08.11.2015.
 */
public class TestMatrix {
    public static void main(String[] args) {

        Matrix matrix = new Matrix("C:\\Users\\HP\\Desktop\\Programowanie\\Inteljji\\Matrix\\src/123.txt");

        System.out.println(matrix.getElement(6,5));
        matrix.setElement(6,5,9.9);
        System.out.println(matrix.getElement(6,5));

        System.out.println("A");
        matrix.readMatrix("C:\\Users\\HP\\Desktop\\Programowanie\\Inteljji\\Matrix\\src/123.txt");
    }
}
