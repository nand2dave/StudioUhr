
public class AnzeigeFormat {

	  private int hour;
	  private int minute;
	  private int second;
	 
	  public void setTime(int stunden, int minuten, int sekunden){
	    hour = ((stunden>=0 && stunden<24) ? stunden : 0);
	    minute = ((minuten>=0 && minuten<60) ? minuten : 0);
	    second = ((sekunden>=0 && sekunden<60) ? sekunden : 0);
	  }

	  public String toMilitary(){
	    return String.format("%02d:%02d:%02d",hour,minute,second);
	  }
}
