/**
 * 
 */

/**
 * @author Alex Pollock
 * @author Jay Harrison
 * @author Cassi VanDeventer
 * enum type Setting for use in a burner
 * used as part of the Burner and Stove classes
 */
public enum Setting {
	
	OFF("---"), LOW("--+"), MEDIUM("-++"), HIGH("+++");
	
	private String value;
	
	Setting( String aValue ){
		value = aValue ; 
	}
	
	public String toString(){
		return value;
	}
	
}