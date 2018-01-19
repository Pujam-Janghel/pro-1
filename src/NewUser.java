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

public class NewUser extends Application{

	private BorderPane bp;

	public static void main (String [] args)
	{
		launch(args);
	}
	@Override
	public void start(Stage primaryStage)
	{
		primaryStage.setTitle (" Log In ");

		bp = new BorderPane();
		bp.setPadding(new Insets(10,50,50,50));

		HBox hb = new HBox();
		hb.setPadding(new Insets(20,20,30,30));

		GridPane gridPane = new GridPane();
		gridPane.setPadding(new Insets(20,20,20,20));
		gridPane.setHgap(5);
		gridPane.setVgap(5);

		Label textName = new Label("Username");
		TextField tfName = new TextField();

		Label textpw = new Label("Password");
		PasswordField tfpw = new PasswordField();

		Label textContact = new Label("Phone or Email");
	    TextField tfContact = new TextField();

	    Label textDob = new Label("Date of Birth");
	    TextField tfDob = new TextField();

	    Label textconfirmpw = new Label("Confirm Password");
		PasswordField tfconfirmpw = new PasswordField();
		
		Label textques = new Label("Security Question");


		Button signUp = new Button("SignUp");
		Label message = new Label();

		gridPane.add(textName,0,0);
		gridPane.add(tfName,1,0);
		gridPane.add(textpw,0,3);
		gridPane.add(tfpw,1,3);
		gridPane.add(textconfirmpw,0,4);
		gridPane.add(tfconfirmpw,1,4);
		gridPane.add(textDob,0,1);
		gridPane.add(tfDob,1,1);
		gridPane.add(textContact,0,2);
		gridPane.add(tfContact,1,2);
		gridPane.add(signUp,1,6);
		gridPane.add(message,1,7);

		gridPane.setMinSize(400,300);

		InnerShadow dropShadow = new InnerShadow();
	    dropShadow.setOffsetX(3);
	    dropShadow.setOffsetY(3);

		Text text = new Text ("Register Yourself ");
        text.setFont(Font.font("Book Antqua", FontWeight.BOLD, 28));
        text.setFill(Color.RED);
        text.setEffect(dropShadow);

		hb.getChildren().add(text);

		bp.setTop(hb);
	    bp.setCenter(gridPane);


	    signUp.setOnAction(new EventHandler<ActionEvent>(){
			        public void handle(ActionEvent event)
			        {
			        	String cpwd = tfpw.getText().toString();
			        	String confirmpw = tfconfirmpw.getText().toString();

			        	if(cpwd.equals(confirmpw))
			        	{
			        		message.setText("Congratulations! \nYou have Successfully created your Account ");
			        		message.setTextFill(Color.GREEN);
			        	}

			        	else
			        	{
			        		message.setText("Passwords don't match! \nTry Again :-( ");
			        		message.setTextFill(Color.RED);
			        	}

			        	tfpw.setText("");
			        	tfconfirmpw.setText("");

			        }
	        });


		Scene scene = new Scene(bp);
		primaryStage.setScene(scene);
		primaryStage.show();
	}

}
