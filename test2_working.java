
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.FontData;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

public class test2_working {

  public static void main(String[] args) {
	  
    final Display display = new Display();
    final Shell shell = new Shell(display);
	final Label anzeigeLabel = new Label(shell, SWT.BORDER);
	anzeigeLabel.setSize(150,50);	//die Anzeige
	FontData data = display.getSystemFont().getFontData()[0];//Schriftgröße, Schriftart
	final Font font = new Font(display, data.getName(), 25, SWT.BOLD);//Schriftgröße, Schriftart

	anzeigeLabel.setBackground(new Color(display,255,255,255)); //Hintergrundfarbe der Anzeige: weiß
	
    final int time = 500;
    
    AnzeigeFormat anzeige = new AnzeigeFormat();
    
    int x = 5; //testvariable, die ich in die anonyme runnable klasse packen will
    Runnable timer = new Runnable() { 	    
  	  
        int stunden = 0;
        int minuten = 0;
        int sekunden = x;
      
      public void run() {	 
    	  //problem gelöst: die if-bedingungen mussten VOR dem Setzen der Zeit stehen
          if (sekunden == 0  && minuten == 0 && stunden == 0){
          	  anzeige.setTime(0,0,0);
          	  anzeige.toMilitary();
            }
            
            if (sekunden == 0 && minuten != 0){
            	minuten--;
            	sekunden = 59;
            }
            
            if (sekunden == 0 && minuten == 0 && stunden != 0){
            	stunden--;
            	minuten = 59;
            	sekunden = 59;
            }       
          
    	  anzeigeLabel.setFont(font);
    	  anzeige.setTime(stunden, minuten, sekunden);
    	  anzeigeLabel.setText(anzeige.toMilitary());

        display.timerExec(1000, this);
        

        
        sekunden--;

        	
      }
    };
    display.timerExec(time, timer);
    
    shell.setSize(200, 200);
    shell.open();
    while (!shell.isDisposed()) {
      if (!display.readAndDispatch())
        display.sleep();
    }
    
	font.dispose(); //!!!!
    display.dispose();
  }
}
