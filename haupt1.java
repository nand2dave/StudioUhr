package swt1;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.Label;
import org.eclipse.wb.swt.SWTResourceManager;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.swt.widgets.Button;

public class haupt1 {
	private static Table table;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		Display display = Display.getDefault();
		Shell shlEditorMode = new Shell();
		shlEditorMode.setMinimumSize(new Point(800, 800));
		shlEditorMode.setSize(669, 566);
		shlEditorMode.setText("Editor Mode");
		
		Composite composite = new Composite(shlEditorMode, SWT.NONE);
		composite.setBounds(10, 216, 693, 536);
		composite.setLayout(new FillLayout(SWT.HORIZONTAL));
		
		table = new Table(composite, SWT.BORDER | SWT.FULL_SELECTION);
		table.setHeaderVisible(true);
		table.setLinesVisible(true);
		
		TableColumn tblclmnNewColumn = new TableColumn(table, SWT.NONE);
		tblclmnNewColumn.setWidth(54);
		tblclmnNewColumn.setText("Position");
		
		TableColumn tblclmnNewColumn_1 = new TableColumn(table, SWT.NONE);
		tblclmnNewColumn_1.setWidth(100);
		tblclmnNewColumn_1.setText("Inhalt");
		
		TableColumn tblclmnNewColumn_2 = new TableColumn(table, SWT.NONE);
		tblclmnNewColumn_2.setWidth(121);
		tblclmnNewColumn_2.setText("Typ");
		
		TableColumn tblclmnNewColumn_3 = new TableColumn(table, SWT.NONE);
		tblclmnNewColumn_3.setWidth(80);
		tblclmnNewColumn_3.setText("Dauer");
		
		TableColumn tblclmnNewColumn_4 = new TableColumn(table, SWT.NONE);
		tblclmnNewColumn_4.setWidth(70);
		tblclmnNewColumn_4.setText("Echtzeit");
		
		TableColumn tblclmnNewColumn_5 = new TableColumn(table, SWT.NONE);
		tblclmnNewColumn_5.setWidth(260);
		tblclmnNewColumn_5.setText("Notiz");
		
		Composite composite_1 = new Composite(shlEditorMode, SWT.NONE);
		composite_1.setBackground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_FOREGROUND));
		composite_1.setBounds(10, 40, 279, 96);
		
		Label lblTime = new Label(composite_1, SWT.NONE);
		lblTime.setFont(SWTResourceManager.getFont("Segoe UI", 30, SWT.NORMAL));
		lblTime.setBounds(10, 10, 259, 76);
		lblTime.setText("TIME : 00:00");
		
		Menu menu = new Menu(shlEditorMode, SWT.BAR);
		shlEditorMode.setMenuBar(menu);
		
		MenuItem mntmExit = new MenuItem(menu, SWT.NONE);
		mntmExit.setText("Exit");
		
		MenuItem mntmEditor = new MenuItem(menu, SWT.CASCADE);
		mntmEditor.setText("Editor");
		
		Menu menu_1 = new Menu(mntmEditor);
		mntmEditor.setMenu(menu_1);
		
		MenuItem mntmModeratorEdit = new MenuItem(menu_1, SWT.NONE);
		mntmModeratorEdit.setText("Moderator Edit");
		
		MenuItem mntmProductionEdit = new MenuItem(menu_1, SWT.NONE);
		mntmProductionEdit.setText("Production Edit");
		
		MenuItem mntmSave = new MenuItem(menu, SWT.NONE);
		mntmSave.setText("Save");
		
		new MenuItem(menu, SWT.SEPARATOR);
		
		MenuItem mntmModeratorMode = new MenuItem(menu, SWT.NONE);
		mntmModeratorMode.setText("Moderator Mode");
		
		MenuItem mntmProductionMode = new MenuItem(menu, SWT.NONE);
		mntmProductionMode.setText("Production Mode");
		
		Composite composite_2 = new Composite(shlEditorMode, SWT.NONE);
		composite_2.setBackground(SWTResourceManager.getColor(SWT.COLOR_INFO_BACKGROUND));
		composite_2.setBounds(332, 40, 341, 96);
		
		Label lblRunning = new Label(composite_2, SWT.NONE);
		lblRunning.setText("Running : 00:00");
		lblRunning.setFont(SWTResourceManager.getFont("Segoe UI", 30, SWT.NORMAL));
		lblRunning.setBounds(10, 10, 321, 76);
		
		Button btnNewButton = new Button(shlEditorMode, SWT.NONE);
		btnNewButton.setBounds(342, 142, 122, 68);
		btnNewButton.setText("ACCEPT");
		
		Button btnNewButton_1 = new Button(shlEditorMode, SWT.NONE);
		btnNewButton_1.setBounds(477, 142, 105, 68);
		btnNewButton_1.setText("END");
		
		Button btnNewButton_2 = new Button(shlEditorMode, SWT.NONE);
		btnNewButton_2.setText("MANUAL START");
		btnNewButton_2.setBounds(10, 142, 134, 68);

		shlEditorMode.open();
		shlEditorMode.layout();
		while (!shlEditorMode.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}
}
