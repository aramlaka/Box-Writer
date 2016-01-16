/**
 * Created by akhil on 1/15/2016.
 */

import java.io.IOException;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class Main extends Application {

    private Stage primaryStage;
    private BorderPane rootLayout;
    private BoxWriter boxWriter;

    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("Box Maker");

        primaryStage.setResizable(false);

        initRootLayout();

        showBoxWriter();
    }

    public void initRootLayout() {
        try {
            // Load root layout from fxml file.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("RootLayout.fxml"));
            rootLayout = (BorderPane) loader.load();

            // Show the scene containing the root layout.
            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Shows the person overview inside the root layout.
     */
    public void showBoxWriter() {
        try {
            // Load person overview.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("BoxWriter.fxml"));
            AnchorPane boxWriter = (AnchorPane) loader.load();
            loader.setController(new BoxWriterController());

            // Set person overview into the center of root layout.
            rootLayout.setCenter(boxWriter);

            // Give the controller access to the main app.
            BoxWriterController controller = loader.getController();
            controller.setMain(this);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Stage getPrimaryStage() {
        return primaryStage;
    }

    public String getBox(String word, String label)
    {
        boxWriter = new BoxWriter(word,label);
        boxWriter.boxify();

        return boxWriter.toString();
    }

    public static void main(String[] args) {launch(args);}
}
