import javafx.scene.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.scene.text.*;
import javafx.scene.effect.*;
import javafx.scene.paint.*;
import javafx.stage.Stage;
import javafx.application.Application;
import javafx.event.*;
import javafx.geometry.Insets;

public class ForgotNameOrPassword extends Application{

	String phoneNo = "123456789",chkphone;

	public static void main (String [] args)
	{
		launch(args);
	}
	@Override
	public void start(Stage primaryStage)
	{
		primaryStage.setTitle (" Log In ");

		BorderPane bp = new BorderPane();
		bp.setPadding(new Insets(10,50,50,50));

		HBox hb = new HBox();
		hb.setPadding(new Insets(20,20,20,20));

		GridPane gridPane = new GridPane();
		gridPane.setPadding(new Insets(10,10,10,10));
		gridPane.setHgap(5);
		gridPane.setVgap(5);

		Label textphoneNo = new Label("Contact number: ");
		TextField tfphoneNo = new TextField();

		Label textpw = new Label("Password");
		PasswordField tfpw = new PasswordField();

		Label textconfirmpw = new Label("Confirm Password");
		PasswordField tfconfirmpw = new PasswordField();

		Button changePw = new Button("Change Password");
		Label message = new Label();

		gridPane.add(textphoneNo,0,0);
		gridPane.add(tfphoneNo,1,0);
		gridPane.add(textpw,0,1);
		gridPane.add(tfpw,1,1);
		gridPane.add(textconfirmpw,0,2);
		gridPane.add(tfconfirmpw,1,2);
		gridPane.add(changePw,1,3);
		gridPane.add(message,0,4);

		gridPane.setMinSize(400,200);

		InnerShadow dropShadow = new InnerShadow();
	    dropShadow.setOffsetX(3);
	    dropShadow.setOffsetY(3);

		Text text = new Text ("Change Password ");
        text.setFont(Font.font("Book Antqua", FontWeight.BOLD, 28));
        text.setFill(Color.RED);
        text.setEffect(dropShadow);

		hb.getChildren().add(text);

		bp.setTop(hb);
	    bp.setCenter(gridPane);

        changePw.setOnAction(new EventHandler<ActionEvent>(){
	        public void handle(ActionEvent event)
	        {
	        	chkphone = tfphoneNo.getText().toString();

	        	if(chkphone.equals(phoneNo))
	        	{
	        		message.setText("Congratulations! Password Changed ");
	        		message.setTextFill(Color.GREEN);
	        	}

	        	else
	        	{
	        		message.setText("Please Enter correct Phone number \nto change your password :-( ");
	        		message.setTextFill(Color.RED);
	        	}

	        	tfphoneNo.setText("");
	        	tfpw.setText("");
	        	tfconfirmpw.setText("");

	        }
	        });


		Scene scene = new Scene(bp);
		primaryStage.setScene(scene);
		primaryStage.titleProperty().bind(
	                 scene.widthProperty().asString().
	                 concat(" : ").
	                 concat(scene.heightProperty().asString()));
		primaryStage.show();
	}
}
