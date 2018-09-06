/**
 * 
 */

/**
 * @author Alex Pollock
 * @author Jay Harrison
 * @author Cassi VanDeventer
 *
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