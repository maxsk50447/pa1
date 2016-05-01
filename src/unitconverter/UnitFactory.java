package unitconverter;

public class UnitFactory {
	private static UnitFactory instance = null;
	private static UnitFactory unitTypes = null;
	private static UnitFactory units = null;
	private UnitFactory(){}
	public static UnitFactory getInstance(){
		if(instance == null){ instance = new UnitFactory(); }
		return instance;
	}
	public static UnitFactory getUnitTypes() {
		if(unitTypes == null){ unitTypes = new UnitFactory();}
		return unitTypes;
	}
	public static UnitFactory getUnits() {
		if(units == null){units = new UnitFactory();}
		return units;
	}
}
