import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.custom.StackLayout;
import org.eclipse.wb.swt.SWTResourceManager;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.FontData;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.ImageData;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.layout.GridData;
import swing2swt.layout.FlowLayout;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.swt.widgets.TableItem;
import java.io.File;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

public class Editor extends Shell {
	private Table editor_table;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String args[]) {
		try {
			Display display = Display.getDefault();
			Editor shell = new Editor(display);
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
	public Editor(Display display) {
		super(display, SWT.SHELL_TRIM);
		setMinimumSize(new Point(730, 560));
		FormLayout formLayout = new FormLayout();
		formLayout.marginBottom = 1;
		formLayout.marginHeight = 1;
		formLayout.marginLeft = 1;
		formLayout.marginRight = 1;
		formLayout.marginTop = 1;
		formLayout.spacing = 1;
		setLayout(formLayout);
		
	//	ButtonImageScale scale = new ButtonImageScale();			// Buttonscale Klasse 
		
		
		Image Editor_back = new Image(display, 										//<- .....
			    Login.class.getResourceAsStream(
			      "Editor_Backdrop.jpg"));	
		Image IKS = new Image(display, 										//<- .....
			    Login.class.getResourceAsStream(
			      "IKS.jpg"));	
		Image Running_btn = new Image(display, 										//<- .....
			    Login.class.getResourceAsStream(
			      "Running_btn.jpg"));	
		Image Time_btn = new Image(display, 										//<- .....
			    Login.class.getResourceAsStream(
			      "Time_btn.jpg"));	
		
		
		//Imagesize();
		
		this.setBackgroundMode(SWT.INHERIT_FORCE);
		this.setBackgroundImage(Editor_back);
		this.setImage(IKS);
		
		
		
		Menu menu = new Menu(this, SWT.BAR);
		setMenuBar(menu);
		
		MenuItem mntmExit = new MenuItem(menu, SWT.NONE);
		mntmExit.setText("Exit");
		
		MenuItem mntmswitch = new MenuItem(menu, SWT.CASCADE);
		mntmswitch.setText("Switch View");
		
		Menu menu_1 = new Menu(mntmswitch);
		mntmswitch.setMenu(menu_1);
		
		MenuItem mntmModerator = new MenuItem(menu_1, SWT.NONE);
		mntmModerator.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				
				Moderator1 mod = new Moderator1(display);
				mod.open();
				
			}
		});
		mntmModerator.setText("Moderator");
		
		MenuItem mntmStaff = new MenuItem(menu_1, SWT.NONE);
		mntmStaff.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
			Staff staff = new Staff(display);
		//	close();
		//	dispose();
			staff.main(null);

		
				
			}
		});
		mntmStaff.setText("Staff");
		
		Composite Time_comp = new Composite(this, SWT.NONE);
		Time_comp.setLayout(new FillLayout(SWT.HORIZONTAL));
		FormData fd_Time_comp = new FormData();
		fd_Time_comp.right = new FormAttachment(0, 231);
		fd_Time_comp.bottom = new FormAttachment(0, 145);
		fd_Time_comp.top = new FormAttachment(0, 14);
		fd_Time_comp.left = new FormAttachment(0, 11);
		Time_comp.setLayoutData(fd_Time_comp);
		
		Composite Running_comp = new Composite(this, SWT.NONE);
		Running_comp.setLayout(new FillLayout(SWT.HORIZONTAL));
		FormData fd_Running_comp = new FormData();
		fd_Running_comp.top = new FormAttachment(Time_comp, 0, SWT.TOP);
		fd_Running_comp.left = new FormAttachment(Time_comp, 26);
		fd_Running_comp.right = new FormAttachment(0, 506);
		fd_Running_comp.bottom = new FormAttachment(0, 144);
		Running_comp.setLayoutData(fd_Running_comp);
		
		Button Runningstamp_button = new Button(Running_comp, SWT.NONE);
		Runningstamp_button.setText("40:20");
		
		Runningstamp_button.setBackgroundImage(Running_btn); 							// RUNNING BACKDROP
	
		
		Composite Buttons_comp = new Composite(this, SWT.NONE);
		FillLayout fl_Buttons_comp = new FillLayout(SWT.HORIZONTAL);
		fl_Buttons_comp.marginHeight = 20;
		fl_Buttons_comp.spacing = 20;
		fl_Buttons_comp.marginWidth = 10;
		Buttons_comp.setLayout(fl_Buttons_comp);
		FormData fd_Buttons_comp = new FormData();
		fd_Buttons_comp.top = new FormAttachment(Time_comp, 21);
		fd_Buttons_comp.right = new FormAttachment(0, 508);
		fd_Buttons_comp.left = new FormAttachment(0, 13);
		Buttons_comp.setLayoutData(fd_Buttons_comp);
		
		Composite Tabel_comp = new Composite(this, SWT.NONE);
		Tabel_comp.setBackgroundMode(SWT.INHERIT_DEFAULT);
		fd_Buttons_comp.bottom = new FormAttachment(Tabel_comp, -23);
		
		Button Manualstart_button = new Button(Buttons_comp, SWT.NONE);
		Manualstart_button.setText("MANUAL START");
		
		Button Save_button = new Button(Buttons_comp, SWT.NONE);
		Save_button.setText("SAVE");
		
		Button Manualstop_button = new Button(Buttons_comp, SWT.NONE);
		Manualstop_button.setText("MANUAL STOP");
		Tabel_comp.setLayout(new FillLayout(SWT.HORIZONTAL));
		FormData fd_Tabel_comp = new FormData();
		fd_Tabel_comp.left = new FormAttachment(Time_comp, 0, SWT.LEFT);
		
		Button Timestamp_button = new Button(Time_comp, SWT.NONE);
		Timestamp_button.setAlignment(SWT.CENTER);
		Timestamp_button.setText("13:37");

		Timestamp_button.setBackgroundImage(Time_btn);						//  &ASEFASDASDAS
		
		FontData[] fD1 = Timestamp_button.getFont().getFontData();
		fD1[0].setHeight(30);
		fD1[0].setStyle(SWT.BOLD);												//<---
		Runningstamp_button.setFont( new Font(display,fD1[0]));
		Timestamp_button.setFont( new Font(display,fD1[0]));
		
		fd_Tabel_comp.right = new FormAttachment(100, -79);
		fd_Tabel_comp.bottom = new FormAttachment(100);
		fd_Tabel_comp.top = new FormAttachment(0, 290);
		Tabel_comp.setLayoutData(fd_Tabel_comp);
		
		editor_table = new Table(Tabel_comp, SWT.BORDER | SWT.FULL_SELECTION);
		editor_table.setHeaderVisible(true);
		editor_table.setLinesVisible(true);
		
		TableColumn Column_position = new TableColumn(editor_table, SWT.CENTER);
		Column_position.setWidth(100);
		Column_position.setText("Position");
		
		TableColumn Column_inhalt = new TableColumn(editor_table, SWT.NONE);
		Column_inhalt.setWidth(100);
		Column_inhalt.setText("Inhalt");
		
		TableColumn Column_typ = new TableColumn(editor_table, SWT.CENTER);
		Column_typ.setWidth(100);
		Column_typ.setText("Typ");
		
		TableColumn Column_dauer = new TableColumn(editor_table, SWT.CENTER);
		Column_dauer.setWidth(100);
		Column_dauer.setText("Dauer");
		
		TableColumn Column_echtzeit = new TableColumn(editor_table, SWT.CENTER);
		Column_echtzeit.setWidth(100);
		Column_echtzeit.setText("Echtzeit");
		
		TableColumn Column_notes = new TableColumn(editor_table, SWT.CENTER);
		Column_notes.setMoveable(true);
		Column_notes.setWidth(100);
		Column_notes.setText("Notes");
		createContents();
	}

	/**
	 * Create contents of the shell.
	 */
	protected void createContents() {
		setText("Editor Modus");
		setSize(733, 569);

	}

	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}
}
