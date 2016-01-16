/**
 * @author Akhil Ramlakan
 *
 * Creates 3D text boxes.
 */

import java.awt.datatransfer.*;
import java.awt.Toolkit;
import java.util.*;

public class Driver
{
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        BoxWriter box;
        char yesno;
        String word;

        System.out.print("\nEnter in some meme text (min 3 characters): ");
        word = input.nextLine();

        System.out.print("Add a label (press enter for none): ");
        box = new BoxWriter(word,input.nextLine());

        System.out.print("Copy to clipboard? (Y/N): ");
        yesno = input.next().toUpperCase().charAt(0);

        box.boxify();

        if(yesno == 'Y')
        {
            StringSelection stringSelection = new StringSelection(box.toString());
            Clipboard clpbrd = Toolkit.getDefaultToolkit().getSystemClipboard();
            clpbrd.setContents(stringSelection, null);
        }

        System.out.print(box);
    }
}