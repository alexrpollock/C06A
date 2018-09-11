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
	 * getter for enum type Temperature
	 */
	public Temperature getTemp() {
		return this.myTemperature;
	}
	
	/**
	 * plusButton increments the setting if possible
	 */
	protected void plusButton(){
		
		this.timer = TIME_DURATION ;
		
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
		
		this.timer = TIME_DURATION ;
		
		switch (this.mySetting) {
			case LOW:
				this.mySetting = Setting.OFF;
				break;
			case MEDIUM:
				this.mySetting = Setting.LOW;
				break;
			case HIGH:
				this.mySetting = Setting.MEDIUM;
			case OFF:
			default:
				break;
		}
	}
	
	/**
	 * updateTemperature checks the timer and if possible
	 * changes the temperature to match the current setting
	 */
	protected void updateTemperature() {
		
		if( timer != 0 ) {
			timer--;
		}
		
		if( timer == 0 ) { // change temp settings
			
			int tempVal = this.tempValue();
			int settingVal = this.settingValue();
			int difference = settingVal - tempVal;
						
			if( difference < 0 ) { // decrease the temp
					this.minusTemp();
					difference++;
			}else if( difference > 0 ) { // increase the temp
					this.plusTemp();
					difference--;
			} // else is 0 do nothing
			
			if( difference !=0 ) {
				timer = TIME_DURATION;
			}
			
		}
	}
	
	/**
	 * settingValue turns the enum type Setting to an int for comparison
	 */
	private int settingValue( ) {
		switch (this.mySetting) {
			case OFF:
				return 0; 
			case LOW:
				return 1;
			case MEDIUM:
				return 2;
			case HIGH:
				return 3;
			default:
				return -1;
		}
	}
	
	/**
	 * tempValue turns the enum type Temperature to an int for comparison
	 */
	private int tempValue( ) {
		switch (this.myTemperature) {
			case COLD:
				return 0; 
			case WARM:
				return 1;
			case HOT:
				return 2;
			case BLAZING:
				return 3;
			default:
				return -1;
		}
	}
	
	/**
	 * plusTemp increments the temp
	 */
	protected void plusTemp(){
				
		switch (this.myTemperature) {
			case COLD:
				this.myTemperature = Temperature.WARM;
				break;
			case WARM:
				this.myTemperature = Temperature.HOT;
				break;
			case HOT:
				this.myTemperature = Temperature.BLAZING;
				break;
			case BLAZING:
			default:
				break;
		}
		
	}
	
	/**
	 * minusTemp decrements the temp
	 */
	protected void minusTemp(){
		
		switch (this.myTemperature) {
			case WARM:
				this.myTemperature = Temperature.COLD;
				break;
			case HOT:
				this.myTemperature = Temperature.WARM;
				break;
			case BLAZING:
				this.myTemperature = Temperature.HOT;
			case COLD:
			default:
				break;
		}
	}
	
	/**
	 * displayBurner prints the setting and the temp to the console
	 */
	protected void displayBurner() {
		System.out.println(this.mySetting + "....." + this.myTemperature);
	}

}
