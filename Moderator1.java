import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.FontData;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.widgets.Label;
import org.eclipse.wb.swt.SWTResourceManager;
import org.eclipse.swt.widgets.Slider;

public class Moderator1 extends Shell {

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String args[]) {
		try {
			Display display = Display.getDefault();
			Moderator1 shell = new Moderator1(display);
			shell.open();
			shell.layout();
			while (!shell.isDisposed()) {
				if (!display.readAndDispatch()) {
					display.sleep();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the shell.
	 * @param display
	 */
	public Moderator1(Display display) {
		super(display, SWT.SHELL_TRIM);
//		setLayout(new FormLayout());
		setMinimumSize(new Point(740, 550));
		setSize(741, 554);
//		this.drawBackground(SWT.COLOR_BLACK);
		FillLayout fl_shell = new FillLayout(SWT.VERTICAL);
		fl_shell.marginWidth = 10;
		fl_shell.marginHeight = 10;
		setLayout(fl_shell);
		
		
		
		
		Composite Background_comp = new Composite(this, SWT.NONE);
		Background_comp.setLayout(new FillLayout(SWT.VERTICAL));

		Composite Top_comp = new Composite(Background_comp, SWT.NONE);
		Top_comp.setLayout(new FillLayout(SWT.HORIZONTAL));
		
		Composite Position_comp = new Composite(Top_comp, SWT.NONE);		
		
		Label TOP_Position_Label = new Label(Position_comp, SWT.NONE);
		TOP_Position_Label.setBounds(10, 10, 85, 15);
		TOP_Position_Label.setText("Position");
		
		FontData[] fD1 = TOP_Position_Label.getFont().getFontData();
		fD1[0].setHeight(20);
		TOP_Position_Label.setFont( SWTResourceManager.getFont("Segoe UI", 9, SWT.NORMAL));
		
		
		Label Position_1_label = new Label(Position_comp, SWT.NONE);
		Position_1_label.setFont(SWTResourceManager.getFont("Segoe UI", 16, SWT.BOLD));
	//	TOP_Position_Label.setFont( new Font(display,fD1[0]));
		Position_1_label.setBounds(10, 58, 35, 36);
		Position_1_label.setText("1");
		
		Label Position_2_label = new Label(Position_comp, SWT.NONE);
		Position_2_label.setFont(SWTResourceManager.getFont("Segoe UI", 20, SWT.NORMAL));
	//	Position_2_label.setFont( new Font(display,fD1[0]));
		Position_2_label.setText("2");
		Position_2_label.setBounds(10, 123, 85, 36);
		
		Label Position_3_label = new Label(Position_comp, SWT.NONE);
		Position_3_label.setText("2");
		Position_3_label.setFont(SWTResourceManager.getFont("Segoe UI", 20, SWT.NORMAL));
	//	Position_3_label.setFont( new Font(display,fD1[0]));
		Position_3_label.setBounds(10, 192, 85, 36);
		
		Label label_9 = new Label(Position_comp, SWT.SEPARATOR | SWT.HORIZONTAL);
		label_9.setBounds(0, 100, 105, 2);
		
		Composite Inhalt_comp = new Composite(Top_comp, SWT.NONE);
		
		Label TOP_Inhalt_label = new Label(Inhalt_comp, SWT.NONE);
		TOP_Inhalt_label.setText("Inhalt");
		TOP_Inhalt_label.setBounds(10, 10, 85, 15);
		
		Label Inhalt_1_label = new Label(Inhalt_comp, SWT.NONE);
		Inhalt_1_label.setText("Beitrag");
		Inhalt_1_label.setFont(SWTResourceManager.getFont("Segoe UI", 16, SWT.BOLD));
		Inhalt_1_label.setBounds(0, 57, 162, 36);
		
		Label Inhalt_2_label = new Label(Inhalt_comp, SWT.NONE);
		Inhalt_2_label.setText("test1");
		Inhalt_2_label.setFont(SWTResourceManager.getFont("Segoe UI", 20, SWT.NORMAL));
		Inhalt_2_label.setBounds(0, 121, 85, 36);
		
		Label Inhalt_3_label = new Label(Inhalt_comp, SWT.NONE);
		Inhalt_3_label.setText("test1");
		Inhalt_3_label.setFont(SWTResourceManager.getFont("Segoe UI", 20, SWT.NORMAL));
		Inhalt_3_label.setBounds(0, 193, 85, 36);
		
		Label label_10 = new Label(Inhalt_comp, SWT.SEPARATOR | SWT.HORIZONTAL);
		label_10.setBounds(0, 99, 162, 2);
		
		Composite Typ_comp = new Composite(Top_comp, SWT.NONE);
		
		Label TOP_Typ_label = new Label(Typ_comp, SWT.NONE);
		TOP_Typ_label.setText("Typ");
		TOP_Typ_label.setBounds(10, 10, 85, 15);
		
		Label Typ_1_label = new Label(Typ_comp, SWT.NONE);
		Typ_1_label.setText("MAZ");
		Typ_1_label.setFont(SWTResourceManager.getFont("Segoe UI", 16, SWT.BOLD));
		Typ_1_label.setBounds(0, 57, 148, 36);
		
		Label Typ_2_label = new Label(Typ_comp, SWT.NONE);
		Typ_2_label.setText("test1");
		Typ_2_label.setFont(SWTResourceManager.getFont("Segoe UI", 20, SWT.NORMAL));
		Typ_2_label.setBounds(0, 121, 85, 36);
		
		Label Typ_3_label = new Label(Typ_comp, SWT.NONE);
		Typ_3_label.setText("test1");
		Typ_3_label.setFont(SWTResourceManager.getFont("Segoe UI", 20, SWT.NORMAL));
		Typ_3_label.setBounds(0, 195, 85, 36);
		
		Label label_11 = new Label(Typ_comp, SWT.SEPARATOR | SWT.HORIZONTAL);
		label_11.setBounds(0, 99, 148, 2);
		
		Composite Dauer_comp = new Composite(Top_comp, SWT.NONE);
		
		Label TOP_Dauer_label = new Label(Dauer_comp, SWT.NONE);
		TOP_Dauer_label.setText("Dauer");
		TOP_Dauer_label.setBounds(10, 10, 85, 15);
		
		Label Dauer_1_label = new Label(Dauer_comp, SWT.NONE);
		Dauer_1_label.setText("00:03:00");
		Dauer_1_label.setFont(SWTResourceManager.getFont("Segoe UI", 32, SWT.BOLD));
		Dauer_1_label.setBounds(0, 31, 181, 66);
		
		Label Dauer_2_label = new Label(Dauer_comp, SWT.NONE);
		Dauer_2_label.setText("test1");
		Dauer_2_label.setFont(SWTResourceManager.getFont("Segoe UI", 20, SWT.NORMAL));
		Dauer_2_label.setBounds(0, 125, 85, 36);
		
		Label Dauer_3_label = new Label(Dauer_comp, SWT.NONE);
		Dauer_3_label.setText("test1");
		Dauer_3_label.setFont(SWTResourceManager.getFont("Segoe UI", 20, SWT.NORMAL));
		Dauer_3_label.setBounds(0, 197, 85, 36);
		
		Label label_12 = new Label(Dauer_comp, SWT.SEPARATOR | SWT.HORIZONTAL);
		label_12.setBounds(0, 103, 181, 6);
		
		Composite Slider_comp = new Composite(Background_comp, SWT.NONE);
		FillLayout fl_Slider_comp = new FillLayout(SWT.HORIZONTAL);
		fl_Slider_comp.marginWidth = 20;
		fl_Slider_comp.marginHeight = 50;
		Slider_comp.setLayout(fl_Slider_comp);
		
		Slider slider = new Slider(Slider_comp, SWT.NONE);
		
		
		createContents();
	}

	/**
	 * Create contents of the shell.
	 */
	protected void createContents() {
		setText("SWT Application");
		setSize(450, 300);

	}

	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}

}
