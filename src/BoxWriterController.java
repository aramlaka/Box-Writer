import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.scene.input.Clipboard;
import javafx.scene.input.ClipboardContent;

/**
 * Created by akhil on 1/16/2016.
 */
public class BoxWriterController
{
    @FXML private TextField word;
    @FXML private TextField label;
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
        BoxWriter tempBox = new BoxWriter(word.getText(),label.getText());
        tempBox.boxify();

        box.setText(tempBox.toString());
    }

    @FXML
    private void handleNew()
    {
        word.setText("");
        label.setText("");
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
