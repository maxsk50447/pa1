package unitconverter;
/**
 * 
 * Definition of UnitType with other unit
 *
 */
public enum UnitType {
	/**
	 * Define the member of the enumeration
	 * have 2 important attribute
	 * name and value
	 * name = String of unit
	 * unit = unit of unitType
	 */
		LENGTH("Length", Length.values()),
		AREA("Area", Area.values()),
		WEIGHT("Weight", Weight.values()),
		VOLUME("Volume" , Volume.values());
		
		/**
		 * Name of unit
	 	*/
		private final String name ;
		/**
		 * Unit of each unitType
		 */
		private final Unit[] unit ;
		
		/**
		 * Constructor of enumeration
		 * @param name name of unit
		 * @param unit unit that you want to add in JComboBox
		 */
		private UnitType ( String name , Unit[] unit){
			this.name = name ;
			this.unit = unit ;
		}
		
		/**
		 * Gets the unit from unitType that you choose
		 * @return unit of that unitType
		 */
		public Unit[] getUnit(){return unit ;}
		
		/**
		 * Gets the name from unit you choose
		 * @return name of the unit
		 */
		public String toString(){return name ;}
}