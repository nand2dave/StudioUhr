package a01_grundlag;

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

public class StudioUhr2 {

  public static void main(String[] args) {
    final Display display = new Display();
    final Shell shell = new Shell(display);
	final Label label = new Label(shell, SWT.BORDER);
	label.setSize(150,50);	
	FontData data = display.getSystemFont().getFontData()[0];//!!!!
	final Font font = new Font(display, data.getName(), 25, SWT.BOLD);//!!!!

	label.setBackground(new Color(display,255,255,255));
    final int time = 500;

    
    Runnable timer = new Runnable() { 	    int gesetzteZeit = 60; 	
      public void run() {	  
label.setFont(font);
    	  label.setText(String.valueOf(gesetzteZeit--));

        display.timerExec(1000, this);
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