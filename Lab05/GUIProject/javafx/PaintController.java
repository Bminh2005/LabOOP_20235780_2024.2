package hust.soict.hedspi.javafx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;
import javafx.scene.paint.Paint;
import javafx.scene.paint.Color;

public class PaintController {
    @FXML
    private Pane drawingAreaPane;
    @FXML
    private ToggleGroup PenOn;
    @FXML
    private RadioButton radioPen;

    @FXML
    private RadioButton radioEraser;

    @FXML
    void drawingAreaMouseDragged(MouseEvent event) {
    	Circle newCircle = new Circle(event.getX(), event.getY(), 4);
    	RadioButton selected = (RadioButton) PenOn.getSelectedToggle();
    	if(selected.getText().equals("Pen")) {
    		newCircle.setRadius(4);
    		newCircle.setFill(Color.BLACK);
    	}
    	else if(selected.getText().equals("Eraser")) {
    		newCircle.setFill(Color.WHITE);
    		newCircle.setRadius(10);
    	}
    	
    	drawingAreaPane.getChildren().add(newCircle);
    }

    @FXML
    void clearButtonPressed(ActionEvent event) {
    	drawingAreaPane.getChildren().clear();
    	
    }

}

