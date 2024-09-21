import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;

public class SalesList {

	private JFrame frmSalesList;
	private JTextField SalesList;
	private JTextField itemText;
	private JTextField costText;
	private JTextField quantityText;
	private JTextField totalText;
	private JButton addButton;
	private JTextArea listText;
	private JScrollPane scrollPane;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SalesList window = new SalesList();
					window.frmSalesList.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public SalesList() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmSalesList = new JFrame();
		frmSalesList.setFont(new Font("Comic Sans MS", Font.PLAIN, 12));
		frmSalesList.setTitle("Sales List");
		frmSalesList.getContentPane().setBackground(new Color(204, 204, 255));
		frmSalesList.setBounds(100, 100, 450, 360);
		frmSalesList.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmSalesList.getContentPane().setLayout(null);
		
		SalesList = new JTextField();
		SalesList.setBackground(new Color(153, 153, 255));
		SalesList.setText("SALES LIST");
		SalesList.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 20));
		SalesList.setHorizontalAlignment(SwingConstants.CENTER);
		SalesList.setEditable(false);
		SalesList.setBounds(0, 0, 450, 30);
		frmSalesList.getContentPane().add(SalesList);
		SalesList.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Item:");
		lblNewLabel.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		lblNewLabel.setBounds(35, 45, 60, 20);
		frmSalesList.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Cost: $");
		lblNewLabel_1.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(35, 75, 60, 20);
		frmSalesList.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Quantity: ");
		lblNewLabel_2.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		lblNewLabel_2.setBounds(35, 105, 70, 20);
		frmSalesList.getContentPane().add(lblNewLabel_2);
		
		itemText = new JTextField();
		itemText.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		itemText.setBounds(110, 45, 300, 25);
		frmSalesList.getContentPane().add(itemText);
		itemText.setColumns(10);
		
		costText = new JTextField();
		costText.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		costText.setColumns(10);
		costText.setBounds(110, 75, 150, 25);
		frmSalesList.getContentPane().add(costText);
		
		quantityText = new JTextField();
		quantityText.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		quantityText.setColumns(10);
		quantityText.setBounds(110, 105, 150, 25);
		frmSalesList.getContentPane().add(quantityText);
		
		addButton = new JButton("Click to add item to list.");
		addButton.setBounds(35, 140, 280, 29);
		frmSalesList.getContentPane().add(addButton);
		
		JLabel lblNewLabel_3 = new JLabel("Total Cost: $");
		lblNewLabel_3.setBounds(35, 300, 85, 20);
		frmSalesList.getContentPane().add(lblNewLabel_3);
		
		totalText = new JTextField();
		totalText.setEditable(false);
		totalText.setBounds(135, 295, 130, 30);
		frmSalesList.getContentPane().add(totalText);
		totalText.setColumns(10);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(35, 180, 375, 100);
		frmSalesList.getContentPane().add(scrollPane);
		
		listText = new JTextArea();
		listText.setEditable(false);
		scrollPane.setViewportView(listText);
		
		registerAddButtonEvent();
	}
	
	//button event to add item to the list
	private void registerAddButtonEvent() {
		addButton.addActionListener(new ActionListener() {
			public void actionPerformed (ActionEvent e) {
				
				
				try {
				//grab all variables
				String name = itemText.getText();
				double price = Double.parseDouble(costText.getText());
				int quantity = Integer.parseInt(quantityText.getText());
				
				//store variables into one item
				SalesItem item = new SalesItem(name, price, quantity);
				
				//create list of items
				SalesSlip slip = new SalesSlip();
				//System.out.println(item.toString());
				slip.addItem(item);
				
				
				//update list to have new item and display it
				listText.setText(slip.toString());
				//System.out.println(slip.size());
				totalText.setText(slip.getTotalSales());
				} 
				//error message for incorrect value type entered
				catch (NumberFormatException ex){
					JOptionPane.showMessageDialog(null,
							"Please enter valid numeric values for Price and Quantity.",
							"Input error",
							JOptionPane.ERROR_MESSAGE);
				}
			}
		});
	}
	
	public String addTotal(String price) {
		String total = "";
		
		return total;
	}
}
