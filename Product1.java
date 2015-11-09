package swt1;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.wb.swt.SWTResourceManager;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Button;

public class Product1 {
	private static Table table;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		Display display = Display.getDefault();
		Shell shell = new Shell();
		shell.setMinimumSize(new Point(800, 800));
		shell.setSize(450, 300);
		shell.setText("SWT Application");
		
		Composite composite = new Composite(shell, SWT.NONE);
		composite.setBounds(10, 216, 693, 536);
		composite.setLayout(new FillLayout(SWT.HORIZONTAL));
		
		table = new Table(composite, SWT.BORDER | SWT.FULL_SELECTION);
		table.setLinesVisible(true);
		table.setHeaderVisible(true);
		
		TableColumn tableColumn = new TableColumn(table, SWT.NONE);
		tableColumn.setWidth(54);
		tableColumn.setText("Position");
		
		TableColumn tableColumn_1 = new TableColumn(table, SWT.NONE);
		tableColumn_1.setWidth(100);
		tableColumn_1.setText("Inhalt");
		
		TableColumn tableColumn_2 = new TableColumn(table, SWT.NONE);
		tableColumn_2.setWidth(121);
		tableColumn_2.setText("Typ");
		
		TableColumn tableColumn_3 = new TableColumn(table, SWT.NONE);
		tableColumn_3.setWidth(80);
		tableColumn_3.setText("Dauer");
		
		TableColumn tableColumn_4 = new TableColumn(table, SWT.NONE);
		tableColumn_4.setWidth(70);
		tableColumn_4.setText("Echtzeit");
		
		TableColumn tableColumn_5 = new TableColumn(table, SWT.NONE);
		tableColumn_5.setWidth(260);
		tableColumn_5.setText("Notiz");
		
		Composite composite_1 = new Composite(shell, SWT.NONE);
		composite_1.setBackground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_FOREGROUND));
		composite_1.setBounds(22, 63, 279, 96);
		
		Label label = new Label(composite_1, SWT.NONE);
		label.setText("TIME : 00:00");
		label.setFont(SWTResourceManager.getFont("Segoe UI", 30, SWT.NORMAL));
		label.setBounds(10, 10, 259, 76);
		
		Composite composite_2 = new Composite(shell, SWT.NONE);
		composite_2.setBackground(SWTResourceManager.getColor(SWT.COLOR_INFO_BACKGROUND));
		composite_2.setBounds(344, 63, 341, 96);
		
		Label label_1 = new Label(composite_2, SWT.NONE);
		label_1.setText("Running : 00:00");
		label_1.setFont(SWTResourceManager.getFont("Segoe UI", 30, SWT.NORMAL));
		label_1.setBounds(10, 10, 321, 76);
		
		Button btnNewButton = new Button(shell, SWT.NONE);
		btnNewButton.setBounds(376, 165, 107, 45);
		btnNewButton.setText("Next");
		
		Button btnNewButton_1 = new Button(shell, SWT.NONE);
		btnNewButton_1.setBounds(549, 165, 107, 45);
		btnNewButton_1.setText("Prev");

		shell.open();
		shell.layout();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

}
