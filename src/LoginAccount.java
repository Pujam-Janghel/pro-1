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

public class LoginAccount extends Application{

	String userName = "pujam";
	String password = "1234";
	String chkuser,chkpwd;

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
		hb.setPadding(new Insets(20,20,30,30));

		GridPane gridPane = new GridPane();
		gridPane.setPadding(new Insets(20,20,20,20));
		gridPane.setHgap(5);
		gridPane.setVgap(5);

		Label uName = new Label("Username");
		TextField tfuName = new TextField();
		Label pw = new Label("Password");
		PasswordField tfpw = new PasswordField();
		Button login = new Button("Login");
		Label message = new Label();
		Button newUser = new Button("Create new Account");
		Button fuName = new Button("Forgot username or password ?");

		gridPane.add(uName,0,0);
		gridPane.add(tfuName,1,0);
		gridPane.add(pw,0,1);
		gridPane.add(tfpw,1,1);
		gridPane.add(login,2,1);
		gridPane.add(newUser,1,2);
		gridPane.add(fuName,1,3);
		gridPane.add(message,1,4);

		gridPane.setMinSize(400,200);

		InnerShadow dropShadow = new InnerShadow();
	    dropShadow.setOffsetX(3);
	    dropShadow.setOffsetY(3);

	    Reflection r = new Reflection();
		r.setFraction(0.7f);
		gridPane.setEffect(r);


		Text text = new Text ("Welcome to Javafx Tutotial ");
        text.setFont(Font.font("Book Antqua", FontWeight.BOLD, 28));
        text.setFill(Color.RED);
        text.setEffect(dropShadow);

		hb.getChildren().add(text);

		bp.setTop(hb);
	    bp.setCenter(gridPane);

	        login.setOnAction(new EventHandler<ActionEvent>(){
	        public void handle(ActionEvent event)
	        {
	        	chkuser = tfuName.getText().toString();
	        	chkpwd = tfpw.getText().toString();

	        	if(chkuser.equals(userName) && chkpwd.equals(password))
	        	{
	        		message.setText("Congratulations! ");
	        		message.setTextFill(Color.GREEN);
	        	}

	        	else
	        	{
	        		message.setText("Wrong Id or Password :-( ");
	        		message.setTextFill(Color.RED);
	        	}

	        	uName.setText("");
	        	tfpw.setText(" ");

	        }
	        });

	        newUser.setOnAction(event-> {

				NewUser user = new NewUser();
				user.start(primaryStage);
				//primaryStage.getScene().setRoot(user.getRootPane());
			});

			fuName.setOnAction(event-> {

							ForgotNameOrPassword user1 = new ForgotNameOrPassword();
							user1.start(primaryStage);
			});


		Scene scene = new Scene(bp);
		primaryStage.setScene(scene);
		primaryStage.show();
	}
}
