package unitconverter;

import java.awt.EventQueue;
/**
 * Run a console ConverterUI.
 * @param args not used
 */
public class Main {
	public static void main(String[]args){
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ConverterUI converterMachine = new ConverterUI(new UnitConverter()); 
					converterMachine.run();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
