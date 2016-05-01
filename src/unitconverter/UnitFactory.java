package unitconverter;
/**
 * Singleton Class Everything is contains by this class
 * It contains UnitType unit of each UnitType and unit of each type is contains value and name
 * 
 * @author Patipol Wangjaitham
 *
 */
public class UnitFactory {
	private static UnitFactory INSTANCE = null;
	/**
	 * Constructor of UnitFactory
	 */
	private UnitFactory(){}
	public static UnitFactory getInstance(){
		if(INSTANCE == null) INSTANCE = new UnitFactory();
		return INSTANCE;
	}
	/**
	 * 
	 * @return all of unitType that this program have
	 */
	public UnitType[] getUnitTypes(){
			return UnitType.values();
	}
	/**
	 * 
	 * @param unitType is type that you receive from JMenuItem
	 * @return unit of unitType that you receive
	 */
	public Unit[] getUnits(UnitType unitType){
		return unitType.getUnit();
	}
}
