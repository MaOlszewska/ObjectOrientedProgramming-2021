package agh.ics.oop.gui;
import agh.ics.oop.*;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.HPos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.FileNotFoundException;
import java.util.ArrayList;


public class App extends Application {
    private GridPane gridPane ;
    private AbstractWorldMap abstractWorldMap;
    private Stage stage;
    private SimulationEngine engine;


    public void drawMap() {
        Platform.runLater(() -> {
            gridPane.getChildren().clear();
            this.gridPane = new GridPane();
            drawFrame();
            try {
                drawObjects();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            gridPane.setGridLinesVisible(true);
            stage.setScene(new Scene(gridPane,400,400));
            stage.show();
        });

    }



    public void start(Stage primaryStage) throws Exception {
        int moveDelay = 500;
        gridPane = new GridPane();
        stage = primaryStage;
        Object[] args = getParameters().getRaw().toArray();
        MoveDirection[] directions = new OptionsParser().parse(args);
        IWorldMap map = new GrassField(10);
        abstractWorldMap = (AbstractWorldMap) map;
        //IWorldMap map = new RectangularMap(10,10);
        Vector2d[] positions = { new Vector2d(2,2), new Vector2d(3,4) };
        engine = new SimulationEngine(directions, map, positions, this, moveDelay);
        init();
    }

    @Override
    public void init() {
        Thread engineThread = new Thread(engine);
        engineThread.start();
    }

    private void drawFrame(){
        Vector2d upperRight = abstractWorldMap.getMapBoundary().getRightCorner();
        Vector2d lowerLeft = abstractWorldMap.getMapBoundary().getLeftCorner();
        Label label = new Label("y/x");
        gridPane.add(label,0,0);
        gridPane.getColumnConstraints().add(new ColumnConstraints(20));
        gridPane.getRowConstraints().add(new RowConstraints(20));
        GridPane.setHalignment(label, HPos.CENTER);

        int i = lowerLeft.x;
        int position = 1;
        while(i < upperRight.x + 1){
            Label number = new Label(Integer.toString(i));
            gridPane.add(number, position, 0);
            gridPane.getColumnConstraints().add(new ColumnConstraints(35));
            GridPane.setHalignment(number, HPos.CENTER);
            position++;
            i++;
        }

        i = upperRight.y;
        position = 1;
        while(i >= lowerLeft.y){
            Label number = new Label(Integer.toString(i));
            gridPane.add(number, 0,  position);
            gridPane.getRowConstraints().add(new RowConstraints(35));
            GridPane.setHalignment(number, HPos.CENTER);
            position++;
            i--;
        }
    }

    private void drawObjects() throws FileNotFoundException {
        ArrayList<IMapElement> mapElements = abstractWorldMap.getMapElements();
        Vector2d upperRight = abstractWorldMap.getMapBoundary().getRightCorner();
        Vector2d lowerLeft = abstractWorldMap.getMapBoundary().getLeftCorner();
        for(IMapElement element : mapElements) {
            if(element instanceof Animal) {
                VBox animal = new GuiElementBox(element).getvBox();
                gridPane.add(animal, element.getPosition().x - lowerLeft.x + 1 , upperRight.y - element.getPosition().y + 1);
            }
            else {
                VBox grass = new GuiElementBox(element).getvBox();
                gridPane.add(grass, element.getPosition().x - lowerLeft.x + 1, upperRight.y - element.getPosition().y + 1);
            }
        }
    }
}
