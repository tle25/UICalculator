import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EvaluatorUI extends JFrame implements ActionListener {
  private TextField txField = new TextField();
  private Panel buttonPanel = new Panel();
  private String display = "";  

  // total of 20 buttons on the calculator,
  // numbered from left to right, top to bottom
  // bText[] array contains the text for corresponding buttons
  private static final String[] bText = {
    "7", "8", "9", "+", "4", "5", "6", "- ", "1", "2", "3",
    "*", "0", "^", "=", "/", "(", ")", "C", "CE"
  };
  private Button[] buttons = new Button[ bText.length ];

  public static void main(String argv[]) {
    EvaluatorUI calc = new EvaluatorUI();
  }

  public EvaluatorUI() {
    setLayout( new BorderLayout() );

    add( txField, BorderLayout.NORTH );
    txField.setEditable( false );

    add( buttonPanel, BorderLayout.CENTER );
    buttonPanel.setLayout( new GridLayout( 5, 4 ));

    //create 20 buttons with corresponding text in bText[] array
    for ( int i = 0; i < 20; i++ ) {
      buttons[ i ] = new Button( bText[ i ]);
    }

    //add buttons to button panel
    for (int i=0; i<20; i++) {
      buttonPanel.add( buttons[ i ]);
    }

    //set up buttons to listen for mouse input
    for ( int i = 0; i < 20; i++ ) {
      buttons[ i ].addActionListener( this );
    }

    setTitle( "Calculator" );
    setSize( 400, 400 );
    setLocationByPlatform( true  );
    setDefaultCloseOperation( WindowConstants.EXIT_ON_CLOSE );
    setVisible( true );
  }

  public void actionPerformed( ActionEvent arg0 ) {
      // You need to fill in this fuction
      // the display takes user's expression until a button, "=",  is pressed.
      // It will create an object named exResult and send arg to Evalator.
      // Eval method in Evaluator class will solve the problem, then return the answer.
      // The dispay String will hold the answer and put it to the txField.
      switch (arg0.getActionCommand()) {
          case "=":
              if(!display.isEmpty())
              {
                  Evaluator txResult = new Evaluator();
                  display = Integer.toString(txResult.eval(display));
              }     break;
          case "C":
              display = "";
              break;
          case "CE":
              if(!display.isEmpty())
                  display = display.substring(0, display.length()-1);
              break;
          default:
              display += arg0.getActionCommand();
              break;
      }
        
        txField.setText(display);    
 
  } 
}
