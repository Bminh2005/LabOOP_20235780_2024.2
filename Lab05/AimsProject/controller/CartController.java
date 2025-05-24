package hust.soict.hedspi.aims.screen.customer.controller;


import java.io.IOException;

import hust.soict.hedspi.aims.cart.Cart;
import hust.soict.hedspi.aims.media.Media;
import hust.soict.hedspi.aims.media.Playable;
import hust.soict.hedspi.aims.store.Store;
import hust.soict.hedspi.test.screen.customer.store.TestViewStoreScreen;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

public class CartController {
	private Cart cart;
	private Store store;
	private boolean filter;
    @FXML
    private TableColumn<Media, Integer> colMediaID;

    @FXML
    private TableColumn<Media, String> ColMediaCategory;

    @FXML
    private Label costLabel;

    @FXML
    private TextField textField;
    
    @FXML
    private TableView<Media> tblMedia;

    @FXML
    private TableColumn<Media, Float> colMediaCost;

    @FXML
    private ToggleGroup filterCategory;

    @FXML
    private Button btnPlay;

    @FXML
    private Button btnRemove;

    @FXML
    private TableColumn<Media, String> colMediaTitle;

    public CartController() {
        // constructor mặc định bắt buộc cho FXML loader
    	this.cart = TestViewStoreScreen.cart;
    	this.store = TestViewStoreScreen.store;
    }
    
    public CartController(Cart cart, Store store) {
    	this.cart = cart;
    	this.store = store;
    }
    @FXML
    void btnPlayPressed(ActionEvent event) {
    	Media media = tblMedia.getSelectionModel().getSelectedItem();
    	if(media instanceof Playable) {
    		((Playable) media).play();
    	}
    }
    
    @FXML
    void textFieldTyped(KeyEvent event) {
    	String text = textField.getText();
    	System.out.println(text);
    	if(text != null && text != "") {
    		RadioButton sel = (RadioButton)filterCategory.getSelectedToggle();
    		ObservableList<Media> list = FXCollections.observableArrayList();
    		if(sel.getText().equals( "By ID")) {
    			list = cart.searchDVDs(Integer.parseInt(text));
    		}
    		else if(sel.getText().equals( "By Title")) {
    			list = cart.searchDVDs(text);
    		}
    		tblMedia.setItems(list);
    	}
    	else {
    		tblMedia.setItems(cart.getItemsOrdered());
    	}
    }

    @FXML
    void btnRemovePressed(ActionEvent event) {
    	Media media = tblMedia.getSelectionModel().getSelectedItem();
    	cart.removeMedia(media);
    	costLabel.setText(String.format("%4.2f $",cart.totalCost()));
    }

    @FXML
    void btnViewStorePressed(ActionEvent event) {
    	
		try {
			final String STORE_FXML_FILE_PATH = "/hust/soict/hedspi/aims/screen/customer/view/Store.fxml";
			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(STORE_FXML_FILE_PATH));
			ViewStoreController viewStoreController = new ViewStoreController(store, cart);
			fxmlLoader.setController(viewStoreController);
			Parent root;
			root = fxmlLoader.load();
			Stage primaryStage = (Stage)((Node)event.getSource()).getScene().getWindow();
			primaryStage.setTitle("Store");
			primaryStage.setScene(new Scene(root));
			primaryStage.show();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
    }
    
    @FXML
    public void initialize() {
    	colMediaID.setCellValueFactory(new PropertyValueFactory<Media, Integer>("id"));
    	colMediaTitle.setCellValueFactory(new PropertyValueFactory<Media, String>("title"));
    	ColMediaCategory.setCellValueFactory(new PropertyValueFactory<Media, String>("category"));
    	colMediaCost.setCellValueFactory(new PropertyValueFactory<Media, Float>("cost"));
    	if(cart.getItemsOrdered() != null) {
    		tblMedia.setItems(cart.getItemsOrdered());
    	}
    	costLabel.setText(String.format("%4.2f $",cart.totalCost()));
    	btnPlay.setVisible(false);
    	btnRemove.setVisible(false);
    	
    	tblMedia.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Media>() {
    		public void changed(ObservableValue<? extends Media> observable, Media oldValue, Media newValue) {
    			updateButtonBar(newValue);
    		}
    	});

    }
    void updateButtonBar(Media media) {
    	if(media == null) {
    		btnPlay.setVisible(false);
    		btnRemove.setVisible(false);
    	}
    	else {
    		btnRemove.setVisible(true);
    		if(media instanceof Playable) {
    			btnPlay.setVisible(true);
    		}
    		else {
    			btnPlay.setVisible(false);
    		}
    	}
    }
}

