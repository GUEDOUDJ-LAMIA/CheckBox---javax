package application;
	
import javafx.application.Application;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;


public class Main extends Application {
	
	final String [] name =  {"a","b","c","l","m","t","i","z","r"};
	final Image []images = new Image[name.length]; 
	final ImageView[] icons=new ImageView[name.length];
	final CheckBox[] cbx= new CheckBox[name.length];
	
	
	
	@Override
	public void start(Stage primaryStage) {
		try {
			//BorderPane root = new BorderPane();
			Scene scene = new Scene(new Group(),600,400,Color.DARKSEAGREEN);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setTitle("Check Box");
			 
		    /************************************/
			
			Rectangle R= new Rectangle(365,50);
			R.setArcHeight(20);
			R.setArcWidth(20);
			R.setFill(Color.rgb(41,41, 41));
			//R.setFill(Color.DARKKHAKI);

		    /************************************/
			
			for(int i=0; i<name.length;i++) {
				final Image image =images[i]= new Image (getClass().getResourceAsStream(name[i]+".png"));
				final ImageView icon = icons[i]=new ImageView();
				icons[i].setFitHeight(40);
				icons[i].setFitWidth(40);
				/*
            //Setting the position of the image
            icons[i].setX(50);
            icons[i].setY(25);*/
				final CheckBox cb =cbx[i]= new CheckBox(name[i]);
				cb.selectedProperty().addListener((ObservableValue < ? extends Boolean > ov, Boolean old_val , Boolean new_val)->{
					icon.setImage(new_val ? image :null);
				});
				
			}

		    /************************************/
			
			VBox vb= new VBox();
			vb.getChildren().addAll(cbx);
			vb.setSpacing(5);

		    /************************************/
			
			HBox hb= new HBox();
			hb.getChildren().addAll(icons);
			hb.setPadding(new Insets (0,0,0,5));

		    /************************************/
			
			StackPane stack = new StackPane ();
			stack.getChildren().add(R);
			stack.getChildren().add(hb);
			StackPane.setAlignment(R,Pos.TOP_CENTER);
			HBox root= new HBox();
			root.getChildren().add(vb);
            root.getChildren().add(stack);
            root.setSpacing(40);
            root.setPadding(new Insets (20,10,10,20));
           ((Group) scene.getRoot()).getChildren().add(root);
            
			
			

		    /************************************/
			
			
			
			
			
		    
			  
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
