import java.sql.SQLException;
import java.text.SimpleDateFormat;

import org.eclipse.swt.SWT;

import org.eclipse.swt.graphics.Font;

import org.eclipse.swt.graphics.FontData;

import org.eclipse.swt.graphics.GC;

import org.eclipse.swt.graphics.Image;

import org.eclipse.swt.graphics.Point;

import org.eclipse.swt.graphics.Rectangle;

import org.eclipse.swt.widgets.Display;

import org.eclipse.swt.widgets.Event;

import org.eclipse.swt.widgets.Shell;

import org.eclipse.swt.widgets.Composite;

import org.eclipse.swt.layout.FillLayout;

import org.eclipse.swt.layout.FormLayout;

import org.eclipse.swt.layout.FormData;

import org.eclipse.swt.layout.FormAttachment;

import org.eclipse.swt.widgets.Label;

import org.eclipse.swt.widgets.Listener;

//import org.eclipse.wb.swt.SWTResourceManager;

import org.eclipse.swt.widgets.Slider;

import java.util.*;

public class Moderator1 extends Shell {
  private long DatabaseTime; //!!!
  public static DBConnection dbconnection = new DBConnection();

 /* public void setConnection(DBConnection con){
    dbconnection = con;
  }*/
  /**
   * 
   * Launch the application.
   * 
   * 
   * 
   * @param args
   * 
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
      
      // Close database connection, when shell is disposed
      dbconnection.closeConnection();

      //Clean up database, when shell is disposed
      dbconnection.restartDatabase();

    } catch (Exception e) {

      e.printStackTrace();

    }

  }

  private Image resize(Image image, int width, int height) {

    Image scaled = new Image(Display.getDefault(), width, height);

    GC gc = new GC(scaled);

    gc.setAntialias(SWT.ON);

    gc.setInterpolation(SWT.HIGH);

    gc.drawImage(image, 0, 0, image.getBounds().width, image.getBounds().height, 0, 0, width, height);

    gc.dispose();

    // image.dispose(); // don't forget about me!

    return scaled;

  }

  /**
   * 
   * Create the shell.
   * 
   * 
   * 
   * @param display
   * 
   */

  public Moderator1(Display display) {

    super(display, SWT.SHELL_TRIM);

    // setLayout(new FormLayout());

    setMinimumSize(new Point(740, 550));

    setSize(741, 554);

    // this.drawBackground(SWT.COLOR_BLACK);

    FillLayout fl_shell = new FillLayout(SWT.VERTICAL);

    fl_shell.marginWidth = 10;

    fl_shell.marginHeight = 10;

    setLayout(fl_shell);

    this.setBackgroundMode(SWT.INHERIT_FORCE);

    Image back = new Image(display, // <- .....

        Login.class.getResourceAsStream("WhiteDrop.jpg"));

    // this.setBackground(SWT.COLOR_BLACK);

    Image back_scale = new Image(display, Login.class.getResourceAsStream("Slider_back.jpg"));

    Composite Background_comp = new Composite(this, SWT.NONE);

    Background_comp.setLayout(new FillLayout(SWT.VERTICAL));

    Composite Top_comp = new Composite(Background_comp, SWT.NONE);

    Top_comp.setLayout(new FillLayout(SWT.HORIZONTAL));

    Composite Position_comp = new Composite(Top_comp, SWT.NONE);

    Label TOP_Position_Label = new Label(Position_comp, SWT.NONE);

    TOP_Position_Label.setBounds(10, 10, 85, 15);

    TOP_Position_Label.setText("Position");

    FontData[] fD1 = TOP_Position_Label.getFont().getFontData();

    fD1[0].setHeight(18);

    fD1[0].setStyle(SWT.BOLD);

    // label1.setFont( new Font(display,fD1[0])); // <-- ...

    FontData[] fD2 = TOP_Position_Label.getFont().getFontData();

    fD2[0].setHeight(16);

    // TOP_Position_Label.setFont( SWTResourceManager.getFont("Segoe UI", 9,

    // SWT.NORMAL));

    Label Position_1_label = new Label(Position_comp, SWT.NONE);

    // Position_1_label.setFont(SWTResourceManager.getFont("Segoe UI", 16,

    // SWT.BOLD));

    Position_1_label.setFont(new Font(display, fD1[0]));

    Position_1_label.setBounds(10, 58, 35, 36);
    
    try {
      dbconnection.openConnection();
    } catch (ClassNotFoundException e4) {
      // TODO Auto-generated catch block
      e4.printStackTrace();
    } catch (SQLException e4) {
      // TODO Auto-generated catch block
      e4.printStackTrace();
    }
    try {
      dbconnection.db_query("SELECT * FROM daten", dbconnection.getRowCount());
    } catch (SQLException e1) {
      // TODO Auto-generated catch block
      e1.printStackTrace();
    } 

    if(!(dbconnection.dbinhalt[0][0] == null))
      Position_1_label.setText(dbconnection.dbinhalt[0][0]);

    Label Position_2_label = new Label(Position_comp, SWT.NONE);

    //Position_2_label.setFont(SWTResourceManager.getFont("Segoe UI", 20, SWT.NORMAL));

    Position_2_label.setFont(new Font(display, fD2[0]));

    if(!(dbconnection.dbinhalt[1][0] == null))
      Position_2_label.setText(dbconnection.dbinhalt[1][0]);

    Position_2_label.setBounds(10, 123, 85, 36);

    Label Position_3_label = new Label(Position_comp, SWT.NONE);

    if(!(dbconnection.dbinhalt[2][0] == null))
      Position_3_label.setText(dbconnection.dbinhalt[2][0]);

    //Position_3_label.setFont(SWTResourceManager.getFont("Segoe UI", 20, SWT.NORMAL));

    Position_3_label.setFont(new Font(display, fD2[0]));

    Position_3_label.setBounds(10, 192, 85, 36);

    Label label_9 = new Label(Position_comp, SWT.SEPARATOR | SWT.HORIZONTAL);

    label_9.setBounds(0, 100, 105, 2);

    Composite Inhalt_comp = new Composite(Top_comp, SWT.NONE);

    Label TOP_Inhalt_label = new Label(Inhalt_comp, SWT.NONE);

    TOP_Inhalt_label.setText("Inhalt");

    TOP_Inhalt_label.setBounds(10, 10, 85, 15);

    Label Inhalt_1_label = new Label(Inhalt_comp, SWT.NONE);

    if(!(dbconnection.dbinhalt[0][1] == null))
      Inhalt_1_label.setText(dbconnection.dbinhalt[0][1]);

    // Inhalt_1_label.setFont(SWTResourceManager.getFont("Segoe UI", 16,

    // SWT.BOLD));

    Inhalt_1_label.setBounds(0, 57, 162, 36);

    Inhalt_1_label.setFont(new Font(display, fD1[0]));

    Label Inhalt_2_label = new Label(Inhalt_comp, SWT.NONE);

    if(!(dbconnection.dbinhalt[1][1] == null))
      Inhalt_2_label.setText(dbconnection.dbinhalt[1][1]);

    // Inhalt_2_label.setFont(SWTResourceManager.getFont("Segoe UI", 20,

    // SWT.NORMAL));

    Inhalt_2_label.setFont(new Font(display, fD2[0]));

    Inhalt_2_label.setBounds(0, 121, 162, 36);

    Label Inhalt_3_label = new Label(Inhalt_comp, SWT.NONE);

    if(!(dbconnection.dbinhalt[2][1] == null))
      Inhalt_3_label.setText(dbconnection.dbinhalt[2][1]);

    // Inhalt_3_label.setFont(SWTResourceManager.getFont("Segoe UI", 20,

    // SWT.NORMAL));

    Inhalt_3_label.setFont(new Font(display, fD2[0]));

    Inhalt_3_label.setBounds(0, 193, 162, 36);

    Label label_10 = new Label(Inhalt_comp, SWT.SEPARATOR | SWT.HORIZONTAL);

    label_10.setBounds(0, 99, 162, 2);

    Composite Typ_comp = new Composite(Top_comp, SWT.NONE);

    Label TOP_Typ_label = new Label(Typ_comp, SWT.NONE);

    TOP_Typ_label.setText("Typ");

    TOP_Typ_label.setBounds(10, 10, 85, 15);

    Label Typ_1_label = new Label(Typ_comp, SWT.NONE);

    if(!(dbconnection.dbinhalt[0][2] == null))
      Typ_1_label.setText(dbconnection.dbinhalt[0][2]);

    // Typ_1_label.setFont(SWTResourceManager.getFont("Segoe UI", 16,

    // SWT.BOLD));

    Typ_1_label.setBounds(0, 57, 148, 36);

    Position_1_label.setFont(new Font(display, fD1[0]));

    Typ_1_label.setFont(new Font(display, fD1[0]));

    Label Typ_2_label = new Label(Typ_comp, SWT.NONE);

    if(!(dbconnection.dbinhalt[1][2] == null))
      Typ_2_label.setText(dbconnection.dbinhalt[1][2]);

    // Typ_2_label.setFont(SWTResourceManager.getFont("Segoe UI", 20,

    // SWT.NORMAL));

    Typ_2_label.setFont(new Font(display, fD2[0]));

    Typ_2_label.setBounds(0, 121, 148, 36);

    Label Typ_3_label = new Label(Typ_comp, SWT.NONE);
    if(!(dbconnection.dbinhalt[2][2] == null))
      Typ_3_label.setText(dbconnection.dbinhalt[2][2]);

    // Typ_3_label.setFont(SWTResourceManager.getFont("Segoe UI", 20,

    // SWT.NORMAL));

    Typ_3_label.setFont(new Font(display, fD2[0]));

    Typ_3_label.setBounds(0, 195, 148, 36);

    Label label_11 = new Label(Typ_comp, SWT.SEPARATOR | SWT.HORIZONTAL);

    label_11.setBounds(0, 99, 148, 2);

    Composite Dauer_comp = new Composite(Top_comp, SWT.NONE);
    Dauer_comp.setLayout(null);

    Label TOP_Dauer_label = new Label(Dauer_comp, SWT.NONE);
    TOP_Dauer_label.setBounds(0, 10, 85, 21);

    TOP_Dauer_label.setText("Dauer");

    //TOP_Dauer_label.setBounds(10, 10, 85, 15);

    Label Dauer_1_label = new Label(Dauer_comp, SWT.CENTER);
    Dauer_1_label.setBounds(0, 34, 181, 70);

    fD1[0].setHeight(30); //HOEHE DES ZAEHLER-LABELS 

    fD1[0].setStyle(SWT.BOLD);

    Dauer_1_label.setFont(new Font(display, fD1[0]));
  //  DBConnection dbconnection = new DBConnection();
    dbconnection.timerConnection();
    DatabaseTime = dbconnection.serverTime.getTime();

    SimpleDateFormat hms = new SimpleDateFormat("HH:mm:ss");

    display.timerExec(0, new Runnable() {
      public void run() {
        //dbconnection.timerConnection();
        // dbconnection.getCurtime();
        Date now = new Date();
        long timeDifference = System.currentTimeMillis()-DatabaseTime;
        Date anzeigeDate = new Date(timeDifference);
        anzeigeDate.setHours(anzeigeDate.getHours() - 1);
        Dauer_1_label.setText(hms.format(anzeigeDate));
        display.timerExec(1000, this);
      }
    });

    /*** ZAEHLER-LABEL ENDE ***/

    Label Dauer_2_label = new Label(Dauer_comp, SWT.NONE);
    Dauer_2_label.setBounds(0, 125, 85, 36);
    
    if(!(dbconnection.dbinhalt[1][3] == null))
      Dauer_2_label.setText(dbconnection.dbinhalt[1][3]);

    // Dauer_2_label.setFont(SWTResourceManager.getFont("Segoe UI", 20,

    // SWT.NORMAL));

    Dauer_2_label.setFont(new Font(display, fD2[0]));

    Label Dauer_3_label = new Label(Dauer_comp, SWT.NONE);
    Dauer_3_label.setBounds(0, 197, 85, 36);
    if(!(dbconnection.dbinhalt[2][3] == null))
      Dauer_3_label.setText(dbconnection.dbinhalt[2][3]);

    // Dauer_3_label.setFont(SWTResourceManager.getFont("Segoe UI", 20,

    // SWT.NORMAL));

    Dauer_3_label.setFont(new Font(display, fD2[0]));

    Label label_12 = new Label(Dauer_comp, SWT.SEPARATOR | SWT.HORIZONTAL);
    label_12.setBounds(0, 103, 181, 6);

    Composite Slider_comp = new Composite(Background_comp, SWT.NONE);

    FillLayout fl_Slider_comp = new FillLayout(SWT.HORIZONTAL);

    fl_Slider_comp.marginWidth = 20;

    fl_Slider_comp.marginHeight = 50;

    Slider_comp.setLayout(fl_Slider_comp);

    Slider slider = new Slider(Slider_comp, SWT.NONE);

    this.addListener(SWT.Resize, new Listener() {

      public void handleEvent(Event e) {

        Rectangle rect = getClientArea();

        slider.setBackgroundImage(resize(back_scale, rect.width, rect.height));

      }

    });

    createContents();

  }

  /**
   * 
   * Create contents of the shell.
   * 
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
