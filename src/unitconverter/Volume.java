package unitconverter;
/**
 * 
 * Definition of Volume with other unit
 *
 */
public enum Volume implements Unit{
	/**
	 * Define the member of the enumeration
	 * have 2 important attribute
	 * name and value
	 * name = String of unit
	 * value = value to multiplier to meters
	 */
	CUBIC_METER("Cubic Meter", 1.00),
	CUBIC_CENTIMETER("Cubic Centimeter", Math.pow(0.01,3)),
	CUBIC_KILOMETER("Cubic Kilometer", Math.pow(1000.0,3)),
	CUBIC_MILE("Cubic Mile", Math.pow(1609.344,3)),
	CUBIC_FOOT("Cubic Foot", Math.pow(0.30480,3)),
	THANG("Thang", 0.02);
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
	private Volume(String name, double value){
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
