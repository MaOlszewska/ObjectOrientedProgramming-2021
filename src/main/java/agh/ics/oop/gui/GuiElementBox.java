package agh.ics.oop.gui;

import agh.ics.oop.Animal;
import agh.ics.oop.IMapElement;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.image.Image;
import javafx.scene.layout.VBox;
import java.io.FileInputStream;
import java.io.FileNotFoundException;


public class GuiElementBox{
    private VBox vBox = new VBox();

    public GuiElementBox(IMapElement object) throws FileNotFoundException {
        Image image = new Image(new FileInputStream(object.getPath(object)));
        ImageView imageView = new ImageView(image);
        imageView.setFitWidth(20);
        imageView.setFitHeight(20);

        Label label;
        if(object instanceof Animal){ label = new Label(object.getPosition().toString());}
        else{label = new Label("Trawa");}
        this.vBox.getChildren().add(imageView);
        this.vBox.getChildren().add(label);
        vBox.setAlignment(Pos.CENTER);
    }

    public VBox getvBox()  {return vBox;}

}
