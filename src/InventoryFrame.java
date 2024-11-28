
import java.awt.event.ActionListener;
import java.awt.Color;
import java.awt.Font;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
public class InventoryFrame extends JFrame implements ActionListener{
	JLabel inventoryLabel = new JLabel("Inventory");
	JPanel leftPanel = new JPanel();
	JPanel rightTopPanel = new JPanel();
	JPanel rightBottomPanel = new JPanel();
	JButton backButton = new JButton("Coopman jones");
	
	
	public Laptop[] laptopArray = new Laptop[310];
	 
	public InventoryFrame(){
		setSize(1366,768);
		setTitle("Inventory");
		
		leftPanel.setBounds(0,0,350,768);
		leftPanel.add(backButton);
		leftPanel.setBackground(new Color(49, 71, 58));
		leftPanel.setLayout(null);
		add(leftPanel);
		
		rightTopPanel.setBounds(350,0,1015,80);
		rightTopPanel.add(backButton);
		rightTopPanel.setBackground(new Color(149, 171, 158));
		rightTopPanel.setLayout(null);
		
		rightBottomPanel.setBounds(350,80,1200,1000);
		rightBottomPanel.add(backButton);
		rightBottomPanel.setBackground(new Color(149, 171, 158));
		rightBottomPanel.setLayout(null);
		add(rightBottomPanel);
		
		inventoryLabel.setBounds(500,50,500,20);
		rightTopPanel.add(inventoryLabel);
		add(inventoryLabel);
		
		backButton.setBounds(20,20,310,50);
		backButton.setBackground(new Color(149, 171, 158));
		backButton.setFont(new Font("Times New Roman", Font.BOLD,21));
		add(backButton);
		
		setLayout(null);
		setVisible(true);
		
		//agorithm!

		
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}