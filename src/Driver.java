/**
 * @author Akhil Ramlakan
 *
 */

import java.util.*;

public class Driver
{
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        BoxWriter box;

        System.out.print("\nEnter in some meme text (min 3 characters):\n");
        box = new BoxWriter(input.nextLine());

        box.boxify();

        System.out.print(box);
    }
}