/**
 * 
 */

/**
 * Burner class
 * Used as part of the Stove assignment
 * 
 * @author Alex Pollock
 * @author Jay Harrison
 * @author Cassi VanDeventer
 * 
 */
public class Burner {
	
	public enum Temperature {
		
		BLAZING("VERY HOT! DON'T TOUCH"), HOT("CAREFUL"), WARM("warm"), COLD("cooool");
		
		private String value;
		
		Temperature( String aValue ){
			value = aValue ; 
		}
		
		public String toString(){
			return value;
		}
		
	}
	

	
	private Setting mySetting;
	private Temperature myTemperature;
	private int timer;
	
	public final static int TIME_DURATION = 2; 
	
	/**
	 * Default constructor
	 */
	Burner(){
		this.mySetting = Setting.OFF;
		this.myTemperature = Temperature.COLD;
		this.timer = 0;
	}
	
	/**
	 * plusButton increments the setting if possible
	 */
	protected void plusButton(){
		switch (this.mySetting) {
		case OFF:
			this.mySetting = Setting.LOW;
			break;
		case LOW:
			this.mySetting = Setting.MEDIUM;
			break;
		case MEDIUM:
			this.mySetting = Setting.HIGH;
			break;
		case HIGH:
		default:
			break;
		}
	}
	
	/**
	 * minusButton decrements the setting if possible
	 */
	protected void minusButton(){
		switch (this.mySetting) {
		case OFF:
			break;
		case LOW:
			this.mySetting = Setting.OFF;
			break;
		case MEDIUM:
			this.mySetting = Setting.LOW;
			break;
		case HIGH:
			this.mySetting = Setting.MEDIUM;
		default:
			break;
		}
	}
	
	protected void updateTemperature() {
		
	}
	
	protected void displayBurner() {
		System.out.println(this.mySetting + "....." + this.myTemperature);
	}

}
