package unitconverter;

import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
/**
 * Graphics User Interface of Unit Conventer
 * @author Patipol Wangjaitham
 *
 */
public class ConverterUI extends JFrame{
	private JButton convertButton;
	private JButton clearButton;
	private UnitConverter unitConverter;
	private JComboBox unit1ComboBox;
	private JTextField inputField1;
	private JTextField inputField2;
	private JComboBox unit2ComboBox;
	private JRadioButton leftButton;
	private JRadioButton rightButton;
	private ButtonGroup radioButtonGroup = new ButtonGroup();
	private Boolean isLeftToRight = true;
	private JMenu menu;
	private JMenuBar menuBar;
	private JMenuItem menuItem;
	private JPanel topPanel;
	private JPanel bottomPanel;
	/**
	 * Create the application.
	 */
	public ConverterUI(UnitConverter uc){
		this.unitConverter = uc;
		this.setTitle("Distance Converter");
		initComponents();
	}
	/**
	 * Initialize the contents of the frame.
	 */
	private void initComponents(){
		

		
		
		unit1ComboBox = new JComboBox(Length.values());
		unit2ComboBox = new JComboBox(Length.values());
		inputField1 = new JTextField(10);
		inputField2 = new JTextField(10);
		inputField2.setEditable(false);
		convertButton = new JButton("Convert!");
		rightButton = new JRadioButton("Right->Left", false);
		menu = new JMenu("Unit Type");
		menuBar = new JMenuBar(); 
		topPanel = new JPanel();
		bottomPanel = new JPanel();
		radioButtonGroup.add(rightButton);
		
		UnitType []  unitType= UnitFactory.getInstance().getUnitTypes();
		for(UnitType type: unitType){
			menuItem = new JMenuItem(type.toString());
			menuItem.addActionListener(new MenuAction(type));
			menu.add(menuItem);
		}
		
		setJMenuBar(menuBar);
		leftButton = new JRadioButton("Left->Right", true);
		
		radioButtonGroup.add(leftButton);
		leftButton.addActionListener(new LeftListener());
		getContentPane().add(rightButton);
		getContentPane().setLayout(new GridLayout(2,1));
		topPanel.setLayout(new FlowLayout());
		bottomPanel.setLayout(new FlowLayout());
		getContentPane().add(topPanel);
		getContentPane().add(bottomPanel);
		topPanel.add(inputField1);
		topPanel.add(unit1ComboBox);
		topPanel.add(new JLabel("="));
		topPanel.add(inputField2);
		topPanel.add(unit2ComboBox);
		topPanel.add(convertButton);
		bottomPanel.add(leftButton);
		bottomPanel.add(rightButton);
		
		
		menu.add(new ExitAction());
		menuBar.add(menu);
		

		
		getRootPane().setDefaultButton(convertButton);
		clearButton = new JButton("Clear");
		topPanel.add(clearButton);
		
		clearButton.addActionListener(new ClearButtonListener());
		
		inputField1.addKeyListener(new AutoDetectedListener());
		inputField2.addKeyListener(new AutoDetectedListener());
		rightButton.addActionListener(new RightListener());
		convertButton.addActionListener(new ConvertButtonListener());
		
		
		
	}
	/**
	 * 
	 * menuAction is an ActionListener of JMenuItem
	 * when choose unit in the JMenuItem it will remove all items in two JComboBox
	 * and add new UnitType that it receive to two JComboBox
	 *
	 */
	class MenuAction extends AbstractAction{
		private Unit[] unit;
		private MenuAction(UnitType type) {
			unit = type.getUnit();
		}
		@Override
		public void actionPerformed(ActionEvent e) {
			unit1ComboBox.removeAllItems();
			unit2ComboBox.removeAllItems();
			for(int i = 0; i < unit.length;i++){
				unit1ComboBox.addItem(unit[i].toString());
				unit2ComboBox.addItem(unit[i].toString());
			}
			pack();
		}
		
	}
	/**
	 * 
	 * ExitAction is an ActionListener of exit menu to close the program
	 *
	 */
	class ExitAction extends AbstractAction {
		
		public ExitAction(){
			super("Exit");
		}
		
		public void actionPerformed( ActionEvent e){
			dispose();
		}
	}
	/*
	 * AutoDetectedListener is a KeyListener when you released the key from keyboard 
	 * it will call method convert
	 */
	class AutoDetectedListener implements KeyListener{
		public void keyPressed(KeyEvent e) {}
		public void keyReleased(KeyEvent e) {
			if(e.getKeyCode() == KeyEvent.VK_BACK_SPACE){
				convert();
			}
			convert();
		}
		public void keyTyped(KeyEvent e) {}
	}
	/*
	 * ClearButtonListener is an ActionListener that use to reset two JTextfield to
	 * empty string and reset two JComboBox to the first one
	 */
	class ClearButtonListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			inputField1.setText("");
			inputField2.setText("");
			unit1ComboBox.setSelectedIndex(0);
			unit2ComboBox.setSelectedIndex(0);
			leftButton.setSelected(true);
			inputField1.setEditable(true);
			inputField2.setEditable(false);
		}
	}
	/*
	 * ConverButtonListener is an ActionListener that call convert
	 */
	class ConvertButtonListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			convert();
		}
	}
	/*
	 * LeftListtener is an ActionListener that operate when press leftButton
	 * It will set Left JTextfield editable to true and Right JTextfield editable to false
	 */
	class LeftListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			convert();
			isLeftToRight = true;
			inputField1.setEditable(true);
			inputField2.setEditable(false);
		}
	}
	/*
	 * RightListtener is an ActionListener that operate when press rightButton
	 * It will set Right JTextfield editable to true and Left JTextfield editable to false
	 */
	class RightListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			convert();
			isLeftToRight = false;
			inputField1.setEditable(false);
			inputField2.setEditable(true);
		}
	}
	/**
	 * Convert is use to convert what you want 
	 * It will get Text from JTextfield convert the value call convert from unitConverter to convert
	 * the value and set it in other JTextfield
	 */
	private void convert(){
		String s;
		inputField1.setForeground(Color.BLACK);
		inputField2.setForeground(Color.BLACK);
		if(isLeftToRight) s = inputField1.getText().trim();
		else s = inputField2.getText().trim();
		if(s.length() > 0){
			try{
				if(isLeftToRight){
					double value = Double.valueOf(s);
					double result = unitConverter.convert(value, (Unit)unit1ComboBox.getSelectedItem(), (Unit)unit2ComboBox.getSelectedItem());	
					inputField2.setText(result + "");	
				}else{
					double value = Double.valueOf(s);
					double result = unitConverter.convert(value, (Unit)unit2ComboBox.getSelectedItem(), (Unit)unit1ComboBox.getSelectedItem());	
					inputField1.setText(result + "");
				}
			}catch(NumberFormatException exception){
				inputField1.setForeground(Color.RED);
				inputField2.setForeground(Color.RED);
			}
		}
		else{
			inputField1.setText("");
			inputField2.setText("");
		}
	}
	/**
	 * Launch the application.
	 */
	public void run() {
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
		setResizable(false);
		setBounds(0,0,670,100);
		pack();
	}
	
}
