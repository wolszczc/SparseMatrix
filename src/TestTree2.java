import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Created by HP on 22.10.2015.
 */
public class TestTree2 {
    public static void main(String[] args){
        Tree tree = new Tree();

        File file = new File("C:\\Users\\HP\\Desktop\\Programowanie\\Inteljji\\ASTRUK_3_rekurencja\\src/123.txt");
        try {
            Scanner scanner = new Scanner(file);
            while (scanner.hasNext()) {
                tree.insert(tree.getRoot(),Double.parseDouble(scanner.next()), Integer.parseInt(scanner.next()));
            }

        }catch (FileNotFoundException fnfe){
            System.out.println("Nie znaleziono pliku");
        }
        tree.get(tree.getRoot());

    }
}
