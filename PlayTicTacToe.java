// Program to display and play a game of Tic-Tac-Toe
// CSC 161 
// Written by cjk
// Code modified by:  Andrew Sears and Lucas Groesbeck

import java.awt.Insets;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.TilePane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Orientation;


public class PlayTicTacToe extends Application
{

	//create counter variable to count the number of turns taken
	private int count = 0;	
	//create arrays to keep track of who played where, one for player X and one for player O
	private Integer[] arrayX = {0,0,0,0,0,0,0,0,0};
	private Integer[] arrayO = {0,0,0,0,0,0,0,0,0};
	// variable to hold the next player
	public char player;
	
	// Top row buttons (really, just indicators)
	public Button buttonX, buttonO;
	
	// Buttons for the squares in the tic-tac-toe
	// board
	
	public Button button1, button2, button3,
	              button4, button5, button6,
	              button7, button8, button9;
	
	public static void main(String[] args) 
	{	
		// method launch is declared in the 
		// Application class.  It calls 
		// method start, below
		launch(args);
	}  // end main
	
	// Start is called by launch.  Start creates
	// the container for the page (here, it's a
	// vertical box (VBox) named 'root'), puts
	// content into the container, puts the
	// container into a scene, puts the scene
	// into a stage, then makes the page visible.
	public void start(Stage stage)
	{
		// Set up the screen layout.  The first
		// row, at the top, will have the text
		// label "Player", then an indicator button 
		// for X and an indicator button for 0.
		// 
		// The next three rows will have a grid for
		// the TicTacToe board. The buttons will be arranged 
		// in this order
		// 1  2  3
		// 4  5  6
		// 7  8  9
		
		// overall container for the page, with padding
		// of 8 pixels around the 2 elements.
		VBox root = new VBox(8);  

	    root.setPrefWidth(500);  // 500 pixels wide for now
	    
		// set up the top row of the container
	    
		player = 'X';
		
		Label player = new Label("Player: ");
		player.setStyle("-fx-font: 32 Arial;");
		
		buttonX = new Button("X");
		buttonX.setPrefSize(140,140);
		buttonX.setStyle(" -fx-font: 40 arial; -fx-fill: White; -fx-base: Black;");
		
		buttonO = new Button("O");
		buttonO.setPrefSize(140,140);
		buttonO.setStyle(" -fx-font: 40 arial; -fx-fill: Black; -fx-base: White;");
		
		// Put the top row entries in a TilePane
		TilePane tilePane = new TilePane();
		tilePane.setStyle(" -fx-padding: 3 30 3 30;");
		tilePane.setHgap(10);  // horizontal space between entries
		tilePane.getChildren().add(player);
		tilePane.getChildren().add(buttonX);
		tilePane.getChildren().add(buttonO);
	    
		// Add the tilePane object to the root container
		root.getChildren().add(tilePane);
		
		
		// Set up the 9 buttons for the board.  Each
		// button is distinguished by its ID.  The ID 
		// can be examined by the code in the handle
		// method of the SimpleEventHandler object.
		
		// buttons for the first row of the game
		button1 = new Button(" ");
		button1.setPrefSize(150,150);
		button1.setId("1");
		button1.setOnAction(new SimpleEventHandler());
	
		button2 = new Button(" ");
		button2.setPrefSize(150,150);
		button2.setId("2");
		button2.setOnAction(new SimpleEventHandler());
		
		button3 = new Button(" ");
		button3.setPrefSize(150,150);
		button3.setId("3");
		button3.setOnAction(new SimpleEventHandler());
		
		// buttons for the second row of the game
		button4 = new Button(" ");
		button4.setPrefSize(150,150);
		button4.setId("4");
		button4.setOnAction(new SimpleEventHandler());
	
		button5 = new Button(" ");
		button5.setPrefSize(150,150);
		button5.setId("5");
		button5.setOnAction(new SimpleEventHandler());
		
		button6 = new Button(" ");
		button6.setPrefSize(150,150);
		button6.setId("6");
		button6.setOnAction(new SimpleEventHandler());
		
		// buttons for the third row of the game
		button7 = new Button(" ");
		button7.setPrefSize(150,150);
		button7.setId("7");
		button7.setOnAction(new SimpleEventHandler());
	
		button8 = new Button(" ");
		button8.setPrefSize(150,150);
		button8.setId("8");
		button8.setOnAction(new SimpleEventHandler());
		
		button9 = new Button(" ");
		button9.setPrefSize(150,150);
		button9.setId("9");
		button9.setOnAction(new SimpleEventHandler());
		
		// set up the displayable image
		
		GridPane gridPane = new GridPane();
		gridPane.setPrefSize(500, 500); // default size
		gridPane.setHgap(10);
		gridPane.setVgap(10);
		
		String style = "";  // style for the overall grid
        style += " -fx-background-insets: 0,1,2; -fx-background-radius: 3,2,1; ";
        style += " -fx-padding: 3 30 3 30; -fx-text-fill: black; -fx-font: 62 arial;";
		
		gridPane.setStyle(style);
		
		// Add the buttons to the grid.
		// Layout is column first, then row
		gridPane.add(button1, 0, 0);
		gridPane.add(button2, 1, 0);
		gridPane.add(button3, 2, 0);
		gridPane.add(button4, 0, 1);
		gridPane.add(button5, 1, 1);
		gridPane.add(button6, 2, 1);
		gridPane.add(button7, 0, 2);
		gridPane.add(button8, 1, 2);
		gridPane.add(button9, 2, 2);
		
		// Add the grid to the root container
		root.getChildren().add(gridPane);
		
		// Create a scene, add it to the stage,
		// title it, then make it visible
		
		stage.setScene(new Scene(root));
		stage.setTitle("Tic-Tac-Toe");
		stage.show();
		
	}  // end method start
	// Handler class
	class SimpleEventHandler implements EventHandler<ActionEvent>
	{
		public void handle(ActionEvent event)
		{
			
		    // Here is what the EventHandler needs to do:
		    //
		    // 1)  Determine which cell/button was clicked.  Use the object
		    //     that triggered the event to find this.                   IMPLEMENTED
		    //
		    // 2)  If the cell is currently unmarked,                   NOT IMPLEMENTED
		      
		    //    a) Put an 'X' or a 'O' in the cell.                       IMPLEMENTED
		      
		    //    b) Toggle so that the next cell clicked will have the other
		    //       symbol.  Change the highlighting at the top of the screen
		    //       so that the current active symbol is highlighted.      IMPLEMENTED
		      
		    //    c) Determine if the game is finished. Finished means: NOT IMPLEMENTED
		      
		    //       i)  One player has three of the same symbol in a row,
		    //           vertical, horizontal, or on one of the two diagonals.
		    //           This is a winning outcome.  The cells that make up
		    //           the three-in-a-row should be highlighted by
		    //           changing the colors of the letters on those cells 
		    //           to red.
		      
		    //       ii) No player has three in a row, and there are no remaining		IMPLEMENTED
		    //           cells to place a move in.  This is a 'cats game' and 
		    //           indicates that the game ended in a draw.  Hmm- if this
		    //           happens, can you draw a giant 'C' on the screen?
		      
		      
		    // 3)  Else if the cell already has a mark in it,           IMPLEMENTED
		    //     do nothing.
			
			
			// Identify the button that was clicked by examining its ID.
			// First, get the object that caused the event. 
			Object source = event.getSource();
			
			// Only buttons have event handlers, so cast the Object 
			// to a Button.
		    Button clickedBtn = (Button) source; 
		    //create an array of the Buttons that are in the board
		    Button[] arrayB = {button1,button2,button3,button4,button5,button6,button7,button8,button9};
		    // Retrieve the ID (as a String) of the Button who triggered
		    // the event
		    String sid = clickedBtn.getId();
		    if (player == 'X')
		    {
		    	// Put an "X" on the button
		    	clickedBtn.setText("X");
		    	//disable the button from being clicked again
		    	clickedBtn.setDisable(true);
		    	//changes the value in the array of where X has played to 1 at the spot of the id of the button - 1
		    	arrayX[Integer.valueOf(sid)-1] = 1;
		    	// Toggle so that the next player will be "O"
		    	player = 'O';
		    	
		    	// flip the highlighting of the indicators at
		    	// the top of the window
		    	buttonX.setStyle("-fx-font: 40 arial; -fx-fill: Black; -fx-base: White;");
		    	buttonO.setStyle("-fx-font: 40 arial; -fx-fill: White; -fx-base: Black;");
		    	//increase the counter variable
		    	count++;
		    }
		    else
		    {
		    	clickedBtn.setText("O");
		    	//diable the button from being clicked again
		    	clickedBtn.setDisable(true);
		    	//changes the value in the array of where O has played to 1 at the spot of the id of the button - 1
		    	arrayO[Integer.valueOf(sid)-1] = 1;
		    	player = 'X';
		    	
		    	buttonO.setStyle("-fx-font: 40 arial; -fx-fill: Black; -fx-base: White;");
		    	buttonX.setStyle("-fx-font: 40 arial; -fx-fill: White; -fx-base: Black;");
		    	//increase the counter variable
		    	count++;
		    }
		    //create a for loop to run through the Buttons in the array ( X )
		    for (int i = 0; i < 3; i++ ){
		    	//runs through horizontal win possibilities for X
		    	if(arrayX[0+3*i] + arrayX[1+3*i] + arrayX[2+3*i] == 3){
		    		//if a win occurs, set the winning buttons to red
		    		arrayB[0+3*i].setStyle("-fx-base: red;");
		    		arrayB[1+3*i].setStyle("-fx-base: red;");
		    		arrayB[2+3*i].setStyle("-fx-base: red;");
		    		//disable all buttons
		    		for(int p = 8; p!=-1 ; p--){
		    			arrayB[p].setDisable(true);
		    		}
		    		//decrease the count so that the count==9 can never be true with another win
		    		count--;
		    	}
		    	//runs through vertical win possibilities for X
		    	else if(arrayX[0+i] + arrayX[3+i] + arrayX[6+i] == 3){
		    		//if a win occurs, set the winning buttons to red
		    		arrayB[0+i].setStyle("-fx-base: red;");
		    		arrayB[3+i].setStyle("-fx-base: red;");
		    		arrayB[6+i].setStyle("-fx-base: red;");
		    		//disable all buttons
		    		for(int p = 8; p!=-1 ; p--){
		    			arrayB[p].setDisable(true);
		    		}
		    		//decrease the count so that the count==9 can never be true with another win
		    		count--;
		    	}
		   	}
		    //checks the left -> right diagonal for X
		    if(arrayX[0] + arrayX[4] + arrayX[8] == 3){
		    	//if a win occurs, set the winning buttons to red
		    	arrayB[0].setStyle("-fx-base: red;");
    			arrayB[4].setStyle("-fx-base: red;");
    			arrayB[8].setStyle("-fx-base: red;");
    			//disable all buttons
    			for(int p = 8; p!=-1 ; p--){
    				arrayB[p].setDisable(true);
    			}
    			//decrease the count so that the count==9 can never be true with another win
    			count--;
		    }
		 //checks the right -> left diagonal for X
		    if(arrayX[2] + arrayX[4] + arrayX[6] == 3){
		    	//if a win occurs, set the winning buttons to red
		    	arrayB[2].setStyle("-fx-base: red;");
    			arrayB[4].setStyle("-fx-base: red;");
    			arrayB[6].setStyle("-fx-base: red;");
    			//disable all buttons
    			for(int p = 8; p!=-1 ; p--){
    				arrayB[p].setDisable(true);
    			}
    			//decrease the count so that the count==9 can never be true with another win
    			count--;
		    }
		    
		    //create a for loop to run through the Buttons in the array ( O )
		    for (int i = 0; i < 3; i++ ){
		    	//runs through horizontal win possibilities for O
		    	if(arrayO[0+3*i] + arrayO[1+3*i] + arrayO[2+3*i] == 3){
		    			arrayB[0+3*i].setStyle("-fx-base: red;");
		    			arrayB[1+3*i].setStyle("-fx-base: red;");
		    			arrayB[2+3*i].setStyle("-fx-base: red;");
		    			//disable all buttons
		    			for(int p = 8; p!=-1 ; p--){
		    				arrayB[p].setDisable(true);
		    			}
		    			//decrease the count so that the count==9 can never be true with another win
		    			count--;
		    	}
		    	//runs through vertical win possibilities for O
		    	else if(arrayO[0+i] + arrayO[3+i] + arrayO[6+i] == 3){
		    			arrayB[0+i].setStyle("-fx-base: red;");
		    			arrayB[3+i].setStyle("-fx-base: red;");
		    			arrayB[6+i].setStyle("-fx-base: red;");
		    			//disable all buttons
		    			for(int p = 8; p!=-1 ; p--){
		    				arrayB[p].setDisable(true);
		    			}
		    			//decrease the count so that the count==9 can never be true with another win
		    			count--;
		    	}
		   	}
		  //checks the left -> right diagonal for O
		    if(arrayO[0] + arrayO[4] + arrayO[8] == 3){
		    	arrayB[0].setStyle("-fx-base: red;");
    			arrayB[4].setStyle("-fx-base: red;");
    			arrayB[8].setStyle("-fx-base: red;");
    			//disable all buttons
    			for(int p = 8; p!=-1 ; p--){
    				arrayB[p].setDisable(true);
    			}
    			//decrease the count so that the count==9 can never be true with another win
    			count--;
		    }
		  //checks the right -> left diagonal for O
		    if(arrayO[2] + arrayO[4] + arrayO[6] == 3){
		    	arrayB[2].setStyle("-fx-base: red;");
    			arrayB[4].setStyle("-fx-base: red;");
    			arrayB[6].setStyle("-fx-base: red;");
    			//disable all buttons
    			for(int p = 8; p!=-1 ; p--){
    				arrayB[p].setDisable(true);
    			}
    			//decrease the count so that the count==9 can never be true with another win
    			count--;
		    }
		    
		    //if no other win is found and all nine buttons have been pressed, it's a cat's game
		    if (count == 9){
		    	//set buttons to red in pattern of a 'C'
		    	button1.setStyle("-fx-base: red;");
		    	button2.setStyle("-fx-base: red;");
		    	button3.setStyle("-fx-base: red;");
		    	button4.setStyle("-fx-base: red;");
		    	button7.setStyle("-fx-base: red;");
		    	button8.setStyle("-fx-base: red;");
		    	button9.setStyle("-fx-base: red;");
		    }
		    // Uncomment the line below if you want to see the button ID 
		    // printed to the console window.  This might be useful for debugging.
		    // System.out.println(sid); // prints the id of the button
			
		}  // end method handle
	}  // end class SimpleEventHandler

}  // end class GraphicDemo
