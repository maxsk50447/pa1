package unitconverter;
/**
 * 
 * Definition of Weight with other unit
 *
 */
public enum Weight implements Unit{
	/**
	 * Define the member of the enumeration
	 * have 2 important attribute
	 * name and value
	 * name = String of unit
	 * value = value to multiplier to meters
	 */
	GRAM("Gram", 1.00),
	KILOGRAM("Kilogram", 1000.0),
	MILLIGRAM("Milligram", 0.001),
	POUND("Pound", 453.592),
	OUNCE("Ounce", 28.3495),
	THANG("Thang", 15000.0);
	/**
	 * Value that is multiplier to convert unit to other unit
	 */
	private final double value;
	/**
	 * Name of unit
	 */
	private final String name;
	/**
	 * Constructor of enumeration
	 * @param name name of unit
	 * @param value value that you want to convert into other unit
	 */
	private Weight(String name, double value){
		this.name = name;
		this.value = value;
	}
	/**
	 * Gets the value from unit you choose
	 * @return value of unit in meter
	 */
	public double getValue() {	return value; }
	/**
	 * Gets the name from unit you choose
	 * @return name of the unit
	 */
	public String toString(){ return name; }
}
