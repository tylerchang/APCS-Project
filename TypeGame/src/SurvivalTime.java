
public class SurvivalTime {
	
	private int seconds;
	private int minutes;
	private double fullMinutes;
	
	public SurvivalTime(int seconds) {
		this.seconds = seconds;
		fullMinutes = ((double)seconds)/60;
		minutes = this.seconds/60;
		
	}
	
	public int getSeconds() {
		return seconds;
	}
	public int getMinutes() {
		return minutes;
	}
	public double getFullMinutes() {
		return fullMinutes;
	}
	public int getSecondsLeft() {
		return seconds%60;
	}
}
