package swt1;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.Slider;
import org.eclipse.swt.SWT;
import org.eclipse.wb.swt.SWTResourceManager;
import org.eclipse.swt.widgets.Scale;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;

public class Mod1 {

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		Display display = Display.getDefault();
		Shell shell = new Shell();
		shell.setBackground(SWTResourceManager.getColor(SWT.COLOR_BLACK));
		shell.setMinimumSize(new Point(800, 800));
		shell.setSize(713, 555);
		shell.setText("SWT Application");
		
		Composite composite_4 = new Composite(shell, SWT.NONE);
		composite_4.setBounds(10, 10, 764, 742);
		
		Composite composite_1 = new Composite(composite_4, SWT.NONE);
		composite_1.setLocation(160, 84);
		composite_1.setSize(162, 336);
		
		Label lblInhalt = new Label(composite_1, SWT.NONE);
		lblInhalt.setText("Inhalt");
		lblInhalt.setBounds(10, 10, 85, 15);
		
		Label lblBeitrag = new Label(composite_1, SWT.NONE);
		lblBeitrag.setText("Beitrag");
		lblBeitrag.setFont(SWTResourceManager.getFont("Segoe UI", 16, SWT.BOLD));
		lblBeitrag.setBounds(0, 57, 162, 36);
		
		Label lblTest = new Label(composite_1, SWT.NONE);
		lblTest.setText("test1");
		lblTest.setFont(SWTResourceManager.getFont("Segoe UI", 20, SWT.NORMAL));
		lblTest.setBounds(0, 121, 85, 36);
		
		Label label_6 = new Label(composite_1, SWT.NONE);
		label_6.setText("test1");
		label_6.setFont(SWTResourceManager.getFont("Segoe UI", 20, SWT.NORMAL));
		label_6.setBounds(0, 193, 85, 36);
		
		Label label_10 = new Label(composite_1, SWT.SEPARATOR | SWT.HORIZONTAL);
		label_10.setBounds(0, 99, 162, 2);
		
		Composite composite_2 = new Composite(composite_4, SWT.NONE);
		composite_2.setLocation(355, 84);
		composite_2.setSize(148, 336);
		
		Label lblTyp = new Label(composite_2, SWT.NONE);
		lblTyp.setText("Typ");
		lblTyp.setBounds(10, 10, 85, 15);
		
		Label lblMaz = new Label(composite_2, SWT.NONE);
		lblMaz.setText("MAZ");
		lblMaz.setFont(SWTResourceManager.getFont("Segoe UI", 16, SWT.BOLD));
		lblMaz.setBounds(0, 57, 148, 36);
		
		Label label_2 = new Label(composite_2, SWT.NONE);
		label_2.setText("test1");
		label_2.setFont(SWTResourceManager.getFont("Segoe UI", 20, SWT.NORMAL));
		label_2.setBounds(0, 121, 85, 36);
		
		Label label_7 = new Label(composite_2, SWT.NONE);
		label_7.setText("test1");
		label_7.setFont(SWTResourceManager.getFont("Segoe UI", 20, SWT.NORMAL));
		label_7.setBounds(0, 195, 85, 36);
		
		Label label_11 = new Label(composite_2, SWT.SEPARATOR | SWT.HORIZONTAL);
		label_11.setBounds(0, 99, 148, 2);
		
		Composite composite_3 = new Composite(composite_4, SWT.NONE);
		composite_3.setLocation(527, 84);
		composite_3.setSize(181, 336);
		
		Label lblDauer = new Label(composite_3, SWT.NONE);
		lblDauer.setText("Dauer");
		lblDauer.setBounds(10, 10, 85, 15);
		
		Label label_3 = new Label(composite_3, SWT.NONE);
		label_3.setText("00:03:00");
		label_3.setFont(SWTResourceManager.getFont("Segoe UI", 32, SWT.BOLD));
		label_3.setBounds(0, 31, 181, 66);
		
		Label label_4 = new Label(composite_3, SWT.NONE);
		label_4.setText("test1");
		label_4.setFont(SWTResourceManager.getFont("Segoe UI", 20, SWT.NORMAL));
		label_4.setBounds(0, 125, 85, 36);
		
		Label label_8 = new Label(composite_3, SWT.NONE);
		label_8.setText("test1");
		label_8.setFont(SWTResourceManager.getFont("Segoe UI", 20, SWT.NORMAL));
		label_8.setBounds(0, 197, 85, 36);
		
		Label label_12 = new Label(composite_3, SWT.SEPARATOR | SWT.HORIZONTAL);
		label_12.setBounds(0, 103, 181, 6);
		
		Slider slider = new Slider(composite_4, SWT.NONE);
		slider.setLocation(120, 444);
		slider.setSize(271, 52);
		slider.setBackground(SWTResourceManager.getColor(SWT.COLOR_DARK_RED));
		slider.setSelection(100);
		
		Slider slider_1 = new Slider(composite_4, SWT.NONE);
		slider_1.setLocation(372, 444);
		slider_1.setSize(271, 52);
		slider_1.setBackground(SWTResourceManager.getColor(SWT.COLOR_DARK_GREEN));
		
		Composite composite = new Composite(composite_4, SWT.NONE);
		composite.setBounds(33, 84, 105, 336);
		
		Label lblNewLabel = new Label(composite, SWT.NONE);
		lblNewLabel.setBounds(10, 10, 85, 15);
		lblNewLabel.setText("Position");
		
		Label label = new Label(composite, SWT.NONE);
		label.setFont(SWTResourceManager.getFont("Segoe UI", 16, SWT.BOLD));
		label.setBounds(10, 58, 35, 36);
		label.setText("1");
		
		Label label_1 = new Label(composite, SWT.NONE);
		label_1.setFont(SWTResourceManager.getFont("Segoe UI", 20, SWT.NORMAL));
		label_1.setText("2");
		label_1.setBounds(10, 123, 85, 36);
		
		Label label_5 = new Label(composite, SWT.NONE);
		label_5.setText("2");
		label_5.setFont(SWTResourceManager.getFont("Segoe UI", 20, SWT.NORMAL));
		label_5.setBounds(10, 192, 85, 36);
		
		Label label_9 = new Label(composite, SWT.SEPARATOR | SWT.HORIZONTAL);
		label_9.setBounds(0, 100, 105, 2);

		shell.open();
		shell.layout();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}
}
