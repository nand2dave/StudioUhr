import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.custom.StackLayout;
import org.eclipse.swt.custom.TableEditor;
import org.eclipse.wb.swt.SWTResourceManager;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.FontData;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.ImageData;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.layout.GridData;
import swing2swt.layout.FlowLayout;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.Text;

import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;




public class Editor extends Shell {
	private Table table;

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
		
		SimpleDateFormat hms = new SimpleDateFormat("HH:mm:ss");

		
	//	ButtonImageScale scale = new ButtonImageScale();			// Buttonscale Klasse 
		
		/*** DATENBANK-ANBINDUNG ***/
		DBConnection dbconnection = new DBConnection();
		dbconnection.setTime(); // setzt die Zeit nochmal neu!!
		
		/***DESIGN***/
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
		
		mntmExit.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				
				close();
				dispose();
				
			}
		});
		
		
		MenuItem mntmswitch = new MenuItem(menu, SWT.CASCADE);
		mntmswitch.setText("Switch View");
		
		Menu menu_1 = new Menu(mntmswitch);
		mntmswitch.setMenu(menu_1);
		
		MenuItem mntmModerator = new MenuItem(menu_1, SWT.NONE);
		mntmModerator.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				
				Moderator1 mod = new Moderator1(display);
				mod.main(null);
				
			}
		});
		mntmModerator.setText("Moderator");
		
		MenuItem menuItem = new MenuItem(menu_1, SWT.NONE);
		menuItem.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
			Staff staff = new Staff(display);
		//	close();
		//	dispose();
			staff.main(null);

		
				
			}
		});
		menuItem.setText("Staff");
		
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
		
		
		/*** ZAEHLER-BUTTON ***/
		Button Runningstamp_button = new Button(Running_comp, SWT.NONE);
		Runningstamp_button.setText("00:00");
		
		display.timerExec(0, new Runnable() {

			public void run() {
				dbconnection.timerConnection();
				dbconnection.getCurtime(); //Holt die aktuelle Zeit
				long timeDifference = dbconnection.curTime.getTime()-dbconnection.serverTime.getTime();
				Date anzeigeDate = new Date(timeDifference);
				anzeigeDate.setHours(anzeigeDate.getHours()-1); //Eine Stunde abziehen, die aus mir unbekannten Gründen automatisch gesetzt ist
				Runningstamp_button.setText(hms.format(anzeigeDate)); //Ausgabe auf Label
				display.timerExec(1000, this);
			}
		});

	    
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
		
		/*** START-BUTTON ***/
		Button Manualstart_button = new Button(Buttons_comp, SWT.NONE);
		Manualstart_button.setText("START");
		Manualstart_button.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				// dbconnection.setTime();
				dbconnection.setTime();
			}
		});
		
		/*** SAVE-BUTTON ***/
		Button Save_button = new Button(Buttons_comp, SWT.NONE);
		Save_button.setText("SPEICHERN");
		Save_button.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				dbconnection.setTime();
			}
		});
		
		
		Button Manualstop_button = new Button(Buttons_comp, SWT.NONE);
		Manualstop_button.setText("STOP");
		Tabel_comp.setLayout(new FillLayout(SWT.HORIZONTAL));
		FormData fd_Tabel_comp = new FormData();
		fd_Tabel_comp.left = new FormAttachment(Time_comp, 0, SWT.LEFT);

		
		/*** ECHTZEIT-BUTTON ***/
		Button Timestamp_button = new Button(Time_comp, SWT.NONE);
		Timestamp_button.setAlignment(SWT.CENTER);
		Timestamp_button.setText("13:37");
		Timestamp_button.setBackgroundImage(Time_btn);

		display.timerExec(0, new Runnable() {
			boolean bool = true;

			public void run() {
				// anzeigeFormat.setTime(stunden, minuten, sekunden);
				// Date time = new Date();

				// Die Zeit vom Server nehmen, einmalig (für den Start)
				if (bool) {
					Timestamp_button.setText(hms.format(dbconnection.serverTime));
					bool = false;
				}

				// Ab jetzt die Rechnerinterne Zeit nehmen
				Date time = new Date();
				Timestamp_button.setText(hms.format(time));
				display.timerExec(1000, this);
			}
		});
	    
		FontData[] fD1 = Timestamp_button.getFont().getFontData();
		fD1[0].setHeight(30);
		fD1[0].setStyle(SWT.BOLD);												//<---
		Runningstamp_button.setFont( new Font(display,fD1[0]));
		Timestamp_button.setFont( new Font(display,fD1[0]));
		
		fd_Tabel_comp.right = new FormAttachment(100, -79);
		fd_Tabel_comp.bottom = new FormAttachment(100);
		fd_Tabel_comp.top = new FormAttachment(0, 290);
		Tabel_comp.setLayoutData(fd_Tabel_comp);
		
		
		/***TABLE***/
		table = new Table(Tabel_comp, SWT.BORDER | SWT.FULL_SELECTION | SWT.MULTI); //!!!
		table.setHeaderVisible(true);
		table.setLinesVisible(true);
		
		/***COLUMNS***/
		TableColumn Column_position = new TableColumn(table, SWT.LEFT);
		Column_position.setWidth(100);
		Column_position.setText("Position");
		
		TableColumn Column_inhalt = new TableColumn(table, SWT.LEFT);
		Column_inhalt.setWidth(100);
		Column_inhalt.setText("Inhalt");
		
		TableColumn Column_typ = new TableColumn(table, SWT.LEFT);
		Column_typ.setWidth(100);
		Column_typ.setText("Typ");
		
		TableColumn Column_dauer = new TableColumn(table, SWT.LEFT);
		Column_dauer.setWidth(100);
		Column_dauer.setText("Dauer");
		
		/*
		TableColumn Column_echtzeit = new TableColumn(table, SWT.CENTER);
		Column_echtzeit.setWidth(100);
		Column_echtzeit.setText("Echtzeit");
		*/
		
		TableColumn Column_notes = new TableColumn(table, SWT.LEFT);
		Column_notes.setMoveable(true);
		Column_notes.setWidth(100);
		Column_notes.setText("Notes");
		createContents();
		
		
		/*** TABLE-ITEMS + TABLE-EDITOR ***/
		for (int i = 0; i < 3; i++) {
			TableItem item = new TableItem(table, SWT.NONE);
			item.setText(new String[] { "" + 1, "" + 2, "" + 3, "" + 4, "" + 5 });
		}
		final TableEditor editor = new TableEditor(table);
		editor.horizontalAlignment = SWT.LEFT;
		editor.grabHorizontal = true;

		/*** TABLE-LISTENER ***/
		table.addListener(SWT.MouseDown, new Listener() {
			@Override
			public void handleEvent(Event event) {
				Rectangle clientArea = table.getClientArea();
				Point pt = new Point(event.x, event.y);
				int index = table.getTopIndex();
				while (index < table.getItemCount()) {
					boolean visible = false;
					final TableItem item = table.getItem(index);
					for (int i = 0; i < table.getColumnCount(); i++) {
						Rectangle rect = item.getBounds(i);
						if (rect.contains(pt)) {
							final int column = i;
							final Text text = new Text(table, SWT.NONE);
							Listener textListener = new Listener() {
								@Override
								public void handleEvent(final Event e) {
									switch (e.type) {
									case SWT.FocusOut:
										item.setText(column, text.getText());
										text.dispose();
										break;
									case SWT.Traverse:
										switch (e.detail) {
										case SWT.TRAVERSE_RETURN:
											item.setText(column, text.getText());
											// FALL THROUGH
										case SWT.TRAVERSE_ESCAPE:
											text.dispose();
											e.doit = false;
										}
										break;
									}
								}
							};
							text.addListener(SWT.FocusOut, textListener);
							text.addListener(SWT.Traverse, textListener);
							editor.setEditor(text, item, i);
							text.setText(item.getText(i));
							text.selectAll();
							text.setFocus();
							return;
						}
						if (!visible && rect.intersects(clientArea)) {
							visible = true;
						}
					}
					if (!visible)
						return;
					index++;
				}
			}
		});
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