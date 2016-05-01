package unitconverter;
/**
 * 
 * Definition of Area with other unit
 *
 */
public enum Area implements Unit{
	/**
	 * Define the member of the enumeration
	 * have 2 important attribute
	 * name and value
	 * name = String of unit
	 * value = value to multiplier to meters
	 */
	SQUARE_METER("Square Meter", 1.00),
	SQUARE_CENTIMETER("Square Centimeter", Math.pow(0.01,2)),
	SQUARE_KILOMETER("Square Kilometer", Math.pow(1000.0,2)),
	SQUARE_MILE("Square Mile", Math.pow(1609.344,2)),
	SQUARE_FOOT("Square Foot", Math.pow(0.30480,2)),
	SQUARE_WA("Square Wa", Math.pow(2.0,2));
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
	private Area(String name, double value){
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
