/**
 * @author Akhil Ramlakan
 *
 * Stores text box
 */

public class BoxWriter
{
    private String word;
    private String box;

    //StringBuilder is used by multiple methods
    private StringBuilder boxBuilder;

    //puts a word in the center of the box
    private String label;

    //spacing indicates how many spaces are between letters on horizontal lines
    private int spacing;

    //offset adds x amount of spaces before each line is printed
    //when posting to some online sites, a small amount of offset
    //is needed for the box to display correctly
    private int offset;

    public BoxWriter()
    {
        this(null,null);
    }

    public BoxWriter(String word, String label)
    {
        this.word = word;
        this.label = label;
        boxBuilder = new StringBuilder();
        box = null;
        spacing = 2;
        offset = 10;
    }

    //creates the "text box"
    public void boxify()
    {
        int length = word.length() - 1;

        do
        {
            spaces(offset);
            spaces(length);

            //outputs word in reverse on top of the box
            if((length+1) == word.length())
                spaceWords(1);
            else
            {
                //creates edges for the top half
                boxBuilder.append(word.substring(length,length + 1));
                spaces(word.length() * (spacing + 1) - (spacing + 2));
                boxBuilder.append(word.substring((word.length() - (length+1)),(word.length() - length)));
                spaces(word.length() - length - 2);
                boxBuilder.append(word.substring((word.length() - (length+1)),(word.length() - length)));
            }

            length--;

            if(length == 0)
            {
                //prints word in normal order in the middle
                boxBuilder.append("\n");
                spaces(offset);
                spaceWords(0);
                spaces(word.length() - 2);
                boxBuilder.append(word.substring((word.length() - (length + 1)), (word.length() - length)));
            }

            boxBuilder.append("\n");
        }
        while(length > 0);

        length = word.length() - 1;

        do
        {
            //creates square box of words on the lower half
            spaces(offset);
            boxBuilder.append(word.substring((word.length() - length), (word.length() - length + 1)));

            //label maker
            if((label.length() > 1) && (length - 1 == word.length() / 2))
            {
                spaces((((word.length() * (spacing + 1)) - (spacing + 2))/2) - (label.length()/2));
                boxBuilder.append(label);

                //controls spaces for varying word lengths
                if((word.length() % 2) == 0)
                {
                    if ((label.length() % 2) == 1)
                        spaces((((word.length() * (spacing + 1)) - (spacing + 2)) / 2) - (label.length() / 2) - 1);
                    else
                        spaces((((word.length() * (spacing + 1)) - (spacing + 2))/2) - (label.length()/2));
                }
                else if ((word.length() % 2) == 1)
                {
                    if ((label.length() % 2) == 0)
                        spaces((((word.length() * (spacing + 1)) - (spacing + 2)) / 2) - (label.length() / 2) + 1);
                    else
                        spaces((((word.length() * (spacing + 1)) - (spacing + 2))/2) - (label.length()/2));
                }
            }
            else
                spaces((word.length() * (spacing + 1)) - (spacing + 2));

            boxBuilder.append(word.substring(length - 1,length));
            spaces(word.length() - 2 - (word.length() - length));

            //adds right half edges
            if(length > 1)
                boxBuilder.append(word.substring(length - 1,length));

            length--;

            boxBuilder.append("\n");
        }
        while(length > 1);

        spaces(offset);
        spaceWords(1);

        this.box = boxBuilder.toString();
    }

    //creates n amount of spaces
    public void spaces(int n)
    {
        for(int i = 0 ; i < n ; i++)
            boxBuilder.append(" ");
    }

    //prints a word with spacing value spaces in between
    //k = 0 prints words in normal order
    //k = 1 prints words in reverse
    public void spaceWords(int k)
    {
        if(k == 0)
        {
            for (int i = 0; i < word.length(); i++)
            {
                boxBuilder.append(word.substring(i, i + 1));

                if(i < word.length()-1)
                    spaces(spacing);
            }
        }
        else if(k == 1)
        {
            for (int i = word.length(); i > 0; i--)
            {
                boxBuilder.append(word.substring(i - 1, i));

                if(i > 1)
                    spaces(spacing);
            }
        }
    }



    public void setWord(String word) { this.word = word; }

    public void setSpacing(int n) { spacing = n; }

    public void setOffset(int n) { offset = n; }

    public String toString() { return box; }
}
