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
import org.eclipse.swt.widgets.Button;

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
		
		Adminpass_text = new Text(adminlog_comp, SWT.BORDER);
		Adminpass_text.setBounds(52, 61, 153, 21);
		
		Label label1 = new Label(adminlog_comp, SWT.BORDER);
		label1.setAlignment(SWT.CENTER);
		label1.setBounds(128, 10, 183, 21);
		label1.setText("Editor ");	
		
		Button Adminpass_button = new Button(adminlog_comp, SWT.NONE);
		Adminpass_button.setBounds(211, 51, 100, 40);
		Adminpass_button.setText("Login");
		
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
		
		
		
		Userpass_text = new Text(userlog_comp, SWT.BORDER);
		Userpass_text.setBounds(49, 67, 153, 21);
		
		Button Userpass_button = new Button(userlog_comp, SWT.NONE);
		Userpass_button.setText("Login");
		Userpass_button.setBounds(208, 56, 100, 40);
		
		Button Crew_RadioButton = new Button(userlog_comp, SWT.RADIO);
		Crew_RadioButton.setBounds(334, 38, 90, 16);
		Crew_RadioButton.setText("Crew");
		
		Button Moderator_RadioButton_1 = new Button(userlog_comp, SWT.RADIO);
		Moderator_RadioButton_1.setBounds(334, 67, 90, 16);
		Moderator_RadioButton_1.setText("Moderator");

		Adminpass_text.setBackgroundImage(WhiteImg);				//<---
		Userpass_text.setBackgroundImage(WhiteImg);
		label1.setBackgroundImage(WhiteImg);
		label2.setBackgroundImage(WhiteImg);
		

		
		loginshell.open();
		loginshell.layout();
		while (!loginshell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			//	WhiteImg.dispose();				// <---- ... 
			//	image.dispose();
			//	IKS.dispose();
			}
		}
	}
}
