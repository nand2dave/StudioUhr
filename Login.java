import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.FontData;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.events.TraverseEvent;
import org.eclipse.swt.events.TraverseListener;

public class Login {
	private static Text Adminpass_text;
	private static Text Userpass_text;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		Display display = Display.getDefault();
		Shell loginshell = new Shell(display, SWT.CLOSE | SWT.TITLE | SWT.MIN );   // <- ....
		loginshell.setMinimumSize(new Point(450, 300));
		loginshell.setSize(450, 300);
		loginshell.setText("Login Studiouhr");
		loginshell.setLayout(new FillLayout(SWT.VERTICAL));
		
		Image IKS = new Image(display, 										//<- .....
			    Login.class.getResourceAsStream(
			      "IKS.jpg"));	
		Image image = new Image(display, 										//<- .....
			    Login.class.getResourceAsStream(
			      "Login_Backdrop.jpg"));
		Image WhiteImg = new Image(display, 										//<- .....
			    Login.class.getResourceAsStream(
			      "WhiteDrop.jpg"));
		
		loginshell.setBackgroundMode(SWT.INHERIT_FORCE);
		loginshell.setBackgroundImage(image);
		loginshell.setImage(IKS);

		
	
		
		Composite adminlog_comp =  new Composite(loginshell, SWT.NONE);
		
		
		/***ADMIN-TEXTFELD***/
		Adminpass_text = new Text(adminlog_comp, SWT.BORDER);
		Adminpass_text.setBounds(52, 61, 153, 21);
		Adminpass_text.setEchoChar('*'); //Passwort-Eingabe mittels '*' verschleiern
		//Passwort eingabe im Textfeld mit Enter-Taste bestätigen
		  Adminpass_text.addTraverseListener(new TraverseListener() {
				public void keyTraversed(TraverseEvent e) {
					if (e.detail == SWT.TRAVERSE_RETURN) {
						e.doit = true;
						System.out.println("Enter gedrückt!");
						if(Adminpass_text.getText().equals("123")){
							System.out.println("Passwort korrekt!");
							Editor Editor = new Editor(display);
							loginshell.close();
							loginshell.dispose();
							Editor.main(args);	
						}	
						else{
							System.out.println("Passwort lautet: 123");
							Shell shell = new Shell (display);							
							int style = SWT.APPLICATION_MODAL  | SWT.OK;
							//int style = SWT.APPLICATION_MODAL | SWT.YES | SWT.NO;
							MessageBox messageBox = new MessageBox (shell, style);
							messageBox.setMessage ("Passwort falsch!");
							//event.doit = messageBox.open () == SWT.YES;
							e.doit = messageBox.open () == SWT.OK;
						}
					}
				}
			});
		  
		/***LABEL "EDITOR"***/  
		Label label1 = new Label(adminlog_comp, SWT.BORDER);
		label1.setAlignment(SWT.CENTER);
		label1.setBounds(128, 10, 183, 21);
		label1.setText("Editor ");	
		
		
		/***ADMIN-BUTTON***/
		Button Adminpass_button = new Button(adminlog_comp, SWT.NONE);
		/*
		Adminpass_button.addSelectionListener(new SelectionAdapter() {	
    	  public void widgetSelected(SelectionEvent e) {			
	    	if (Adminpass_text.getText() == "Venetian"){
		      Editor Editor = new Editor(display);
		      loginshell.close();
		      loginshell.dispose();
		      Editor.main(args);
	     	  loginshell.setVisible(false);
			};				
		  }
		});
		*/
		Adminpass_button.setBounds(211, 51, 100, 40);
		Adminpass_button.setText("Login");
		
		
		//Button Adminpass_button = new Button(adminlog_comp, SWT.NONE);
		Adminpass_button.setBounds(211, 51, 100, 40);
		Adminpass_button.setText("Login");
		
		//listener für oberen button
		Adminpass_button.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				//Wenn Passwort für das Admin-Fenster (Editor.java) korrekt...
				if(Adminpass_text.getText().equals("123")){
					System.out.println("Passwort korrekt!");
					Editor editor = new Editor(display);
					loginshell.close();
					loginshell.dispose();
					editor.main(args);	
				}	
				else{
					System.out.println("Passwort lautet: 123");
					Shell shell = new Shell (display);							
					int style = SWT.APPLICATION_MODAL  | SWT.OK;
					//int style = SWT.APPLICATION_MODAL | SWT.YES | SWT.NO;
					MessageBox messageBox = new MessageBox (shell, style);
					messageBox.setMessage ("Passwort falsch!");
					//event.doit = messageBox.open () == SWT.YES;
					e.doit = messageBox.open () == SWT.OK;
				}	
			}
		});

		
		/***BELLETRISTIK***/
		Composite userlog_comp = new Composite(loginshell, SWT.NONE);
		
		Label label2 = new Label(userlog_comp, SWT.BORDER);
		label2.setText("Crew / Moderator");
		label2.setAlignment(SWT.CENTER);
		label2.setBounds(125, 10, 183, 21);
		
		
		FontData[] fD1 = label1.getFont().getFontData();
		fD1[0].setHeight(10);
		fD1[0].setStyle(SWT.BOLD);
		label1.setFont( new Font(display,fD1[0]));					// <-- ...
		label2.setFont( new Font(display,fD1[0]));
		
		

		
		
		
		  
		  
		/***BUTTON2***/  
		Button Userpass_button = new Button(userlog_comp, SWT.NONE);
		
		Userpass_button.setText("Login");
		Userpass_button.setBounds(208, 56, 100, 40);
		//Button Userpass_button = new Button(userlog_comp, SWT.NONE);
		Userpass_button.setText("Login");
		Userpass_button.setBounds(208, 56, 100, 40);
		Userpass_button.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				if(Userpass_text.getText().equals("234")){
					System.out.println("Passwort korrekt!");
					Editor editor = new Editor(display);
					loginshell.close();
					loginshell.dispose();
					editor.main(args);	
				}	
				else{
					System.out.println("Passwort lautet: 234");
					Shell shell = new Shell (display);							
					int style = SWT.APPLICATION_MODAL  | SWT.OK;
					//int style = SWT.APPLICATION_MODAL | SWT.YES | SWT.NO;
					MessageBox messageBox = new MessageBox (shell, style);
					messageBox.setText ("Passwort erneut eingeben!");
					messageBox.setMessage ("Passwort falsch!");
					//event.doit = messageBox.open () == SWT.YES;
					e.doit = messageBox.open () == SWT.OK;
				}
					
			}
		});

		
		/***CREW-RADIOBUTTON***/
	    SelectionListener selectionListener = new SelectionAdapter () {
	      public void widgetSelected(SelectionEvent event) {
	        Button button = ((Button) event.widget);
	        System.out.print(button.getText());
	        System.out.println(" selected = " + button.getSelection());
	             //Login.crewButtonSelected = true;
	        button.setSelection(true);
	        };
	    };
	      
		Button Crew_RadioButton = new Button(userlog_comp, SWT.RADIO);
		Crew_RadioButton.setBounds(334, 38, 90, 16);
		Crew_RadioButton.setText("Crew");
		Crew_RadioButton.addSelectionListener(selectionListener);
		  
		
		/***MODERATOREN-RADIOBUTTON***/
		Button Moderator_RadioButton_1 = new Button(userlog_comp, SWT.RADIO);
		Moderator_RadioButton_1.setBounds(334, 67, 90, 16);
		Moderator_RadioButton_1.setText("Moderator");
		Moderator_RadioButton_1.addSelectionListener(selectionListener);

		
		/***TEXTFELD2***/
		//muss unterhalb Crew_RadioButton und Moderator_Radiobutton_1 liegen, da dieser sonst nicht erkannt wird
		Userpass_text = new Text(userlog_comp, SWT.BORDER);
		Userpass_text.setBounds(49, 67, 153, 21);
		Userpass_text.setEchoChar('*'); //Passwort-Eingabe mittels '*' verschleiern
		//Passwort eingabe im Textfeld mit Enter-Taste bestätigen
		  Userpass_text.addTraverseListener(new TraverseListener() {
				public void keyTraversed(TraverseEvent e) {
					if (e.detail == SWT.TRAVERSE_RETURN) {
						e.doit = true;
						System.out.println("Enter gedrückt!"); //Test
						//Wenn Passwort für Crew-Fenster (Staff.java) korrekt
						if(Userpass_text.getText().equals("234") 
						   && Crew_RadioButton.getSelection() == true){
							System.out.println("Passwort korrekt!");
							Staff staff = new Staff(display);
							loginshell.close();
							loginshell.dispose();
							staff.main(args);	
						}	
						//Wenn Passwort für Moderatoren-Fenster korrekt
						else if (Userpass_text.getText().equals("234")
								 && Moderator_RadioButton_1.getSelection() == true){
							System.out.println("Passwort korrekt!");
							Moderator1 moderator1 = new Moderator1(display);
							loginshell.close();
							loginshell.dispose();
							moderator1.main(args);	
						}						
						//wenn passwort korrekt, aber Moderator- oder Crew-Radiobutton nicht ausgewählt
						else if (Userpass_text.getText().equals("234") 
							     && Crew_RadioButton.getSelection() == false
							     && Moderator_RadioButton_1.getSelection() == false){
							System.out.println("Passwort lautet: 234");
							Shell shell = new Shell (display);							
							int style = SWT.ICON_ERROR | SWT.OK;
							//int style = SWT.APPLICATION_MODAL  | SWT.OK;
						//	FillLayout fillLayout = new FillLayout (SWT.HORIZONTAL);
						//	shell.setLayout(fillLayout);
							//int style = SWT.APPLICATION_MODAL | SWT.YES | SWT.NO;
							MessageBox messageBox = new MessageBox (shell, style);
							messageBox.setMessage ("Crew- oder -Moderator-Button nicht ausgewählt!");
							//event.doit = messageBox.open () == SWT.YES;
							e.doit = messageBox.open () == SWT.OK;
						}
						//Wenn Passwort für Crew- oder Moderatoren-Fenster nicht korrekt
						else if (!(Userpass_text.getText().equals("234"))){
							System.out.println("Passwort lautet: 234");
							Shell shell = new Shell (display);							
							int style = SWT.ICON_ERROR | SWT.OK;
							//int style = SWT.APPLICATION_MODAL | SWT.YES | SWT.NO;
							MessageBox messageBox = new MessageBox (shell, style);
							messageBox.setMessage ("Crew- oder -Moderator-Button nicht ausgewählt!");
							//event.doit = messageBox.open () == SWT.YES;
							e.doit = messageBox.open () == SWT.OK;
						}
					}
				}
			});
		  
		  
		/***BELLETRISTIK***/
		Adminpass_text.setBackgroundImage(WhiteImg);				//<---
		Userpass_text.setBackgroundImage(WhiteImg);
		label1.setBackgroundImage(WhiteImg);
		label2.setBackgroundImage(WhiteImg);
		
		
		loginshell.open();
		loginshell.layout();
		while (!loginshell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
				IKS.dispose();
				image.dispose();
				WhiteImg.dispose();
				// <---- ... 
			}
		}
	}
}
