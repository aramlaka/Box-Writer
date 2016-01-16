import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.scene.input.Clipboard;
import javafx.scene.input.ClipboardContent;

import java.util.Random;

/**
 * Created by akhil on 1/16/2016.
 */
public class BoxWriterController
{
    @FXML private TextField word;
    @FXML private TextField label;
    @FXML private TextField spacing;
    @FXML private TextField offset;
    @FXML private Text text;
    @FXML private TextArea box;


    //references main class
    private Main main;

    public BoxWriterController()
    {

    }

    @FXML
    private void initialize()
    {
    }

    public void setMain(Main main)
    {
        this.main = main;
    }

    @FXML
    private void handleBoxify()
    {
        Random r = new Random();
        int i = r.nextInt(4);

        BoxWriter tempBox;

        tempBox = new BoxWriter(word.getText(),label.getText());

        if(spacing.getText().equals("") == false)
            tempBox.setSpacing(Integer.parseInt(spacing.getText()));

        if(offset.getText().equals("") == false)
            tempBox.setOffset(Integer.parseInt(offset.getText()));

        tempBox.boxify();

        box.setText(tempBox.toString());

        if(i == 0)
            text.setText("Boxes are the future.");
        else if(i == 1)
            text.setText("Why are you even using this?");
        else if(i == 2)
            text.setText("ayy lmao");
        else if(i == 3)
            text.setText(word.getText());
    }

    @FXML
    private void handleNew()
    {
        word.setText("");
        label.setText("");
        spacing.setText("");
        offset.setText("");
        box.setText("");
    }

    @FXML
    private void handleCopy()
    {
        Clipboard clpbrd = Clipboard.getSystemClipboard();
        ClipboardContent clpbrdc = new ClipboardContent();
        clpbrdc.putString(box.getText());
        clpbrd.setContent(clpbrdc);
    }
}
