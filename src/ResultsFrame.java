import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Desktop;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

// Results frame class is a frame
public class ResultsFrame extends JFrame implements ActionListener {

	// Declare the logo
	private ImageIcon logo = new ImageIcon("images/logo.png");


	// Gett the results array from the results array in the application class
	private Laptop[] laptopResultsArray = LaptopStoreApp.laptopResultsArray;

	// Declare the components
	private MenuBarPanel menuBar = new MenuBarPanel();
    private JLabel titleLabel = new JLabel("RESULTS");
	private JPanel[] panelArray = new JPanel[3];
	JPanel titlePanel = new JPanel();
	JPanel headerPanel = new JPanel();
	

	// Declare the results frame
	public ResultsFrame() {

		setupFrame();
		createHeader();

		// Add 3 panels for displaying the computers
		for (int index = 0; index < 3; index++) {

			// Create a panal for each rank (1st, 2nd, 3rd)
			createLaptopPanel(index);

		}

		// Turn the results frame visible
		setVisible(true);

	}

	// GUI Setup
	public void setupFrame(){

		// Set up frame to be 1366x768
		setSize(1366, 768);

		// Add the frame title and logo
		setIconImage(logo.getImage());

		// Set the frame's title
		setTitle("Hunter's Laptops - Survey Results");

		// Set the layout of the frame
		setLayout(null);

		// Colour the background green
		getContentPane().setBackground(new Color(237, 244, 242));

	}

	public void createHeader(){

		// Create the components
		createMenuBar();
		createTitleLabel();
		createTitlePanel();
		createHeaderPanel();        

	}

	public void createMenuBar(){

		// Menu Bar
		menuBar.setBounds(0, 0, 1366, 50);
		add(menuBar);
	}

	public void createTitleLabel(){
		// Title (Separate from the menu bar)
		titleLabel.setFont(new Font("ARIAL", Font.BOLD, 34)); // Set font size to 34
		titleLabel.setForeground(Color.WHITE); // Title color white
		titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
	}

	public void createTitlePanel(){
		
        // Add title to a panel with a light green background
        titlePanel.setBackground(new Color(39, 61, 48)); // Dark greenish (#31473A)
        titlePanel.setLayout(new FlowLayout(FlowLayout.CENTER)); // Center title label
        titlePanel.add(titleLabel);
        titlePanel.setBorder(BorderFactory.createEmptyBorder(20, 0, 20, 0));
	}

	public void createHeaderPanel(){

		// Create a header panel to hold the menu bar and title
        headerPanel.setLayout(new BorderLayout()); // Setting the layout to border layout
        headerPanel.add(menuBar, BorderLayout.NORTH); // Adding the menu bar, at the top
        headerPanel.add(titlePanel, BorderLayout.CENTER); // Adding the title panel, in the center
        
		// Changing the size to fit the frame
		headerPanel.setBounds(0, 0, 1366, 140);
        add(headerPanel);
	}

	// Create the laptop panel based on the ranking (1st, 2nd, 3rd)
	public void createLaptopPanel(int index){

		// Create a panel
		JPanel laptopPanel = new JPanel();

		// Setting up the laptop panel
		setupLaptopPanel(laptopPanel, index);

		// Create vertical padding
		// https://stackoverflow.com/questions/10744809/boxlayout-misunderstanding-strut
		laptopPanel.add(Box.createVerticalStrut(20));

		// Adding all of the components
		createRankLabel(laptopPanel, index);

		laptopPanel.add(Box.createVerticalStrut(10));

		createLaptopLabel(laptopPanel, index);
		
		laptopPanel.add(Box.createVerticalStrut(5));

		createModelLabel(laptopPanel, index);

		laptopPanel.add(Box.createVerticalStrut(5));

		createPriceLabel(laptopPanel, index);

		laptopPanel.add(Box.createVerticalStrut(20));

		createMoreInfoButton(laptopPanel);

		laptopPanel.add(Box.createVerticalStrut(10));

		createToWebsiteButton(laptopPanel);

		// adding the panel to the frame
		add(laptopPanel);
	}

	// Method to setup panel
	public void setupLaptopPanel(JPanel laptopPanel, int index){

		// Change the panel array to this panel
		panelArray[index] = laptopPanel;

		// Set the panel's location and size according to which one it is
		laptopPanel.setBounds(120 + index * 400, 180, 300, 500);

		// Set the background color
		laptopPanel.setBackground(Color.WHITE);

		// Add a border to the panel
		laptopPanel.setBorder(BorderFactory.createCompoundBorder(
				BorderFactory.createLineBorder(new Color(200, 200, 200)), // Light border
				BorderFactory.createEmptyBorder(10, 10, 10, 10)));

		// Set layout to box layout
		// https://docs.oracle.com/javase/tutorial/uiswing/layout/box.html
		laptopPanel.setLayout(new BoxLayout(laptopPanel, BoxLayout.Y_AXIS));

	}

	// Determine the rank text
	public String determineRankText(int index){
		
		// Return a string based on the index
		switch (index) {
		case 0:
			return "1ST";
		case 1:
			return "2ND";

		}

		// If it is not 1st or 2nd, it must be 3rd
		return "3RD";
			
	}

	// Create the rank label
	public void createRankLabel(JPanel laptopPanel, int index){

		// Add a new label for the rank based on rank text, center it
		JLabel rankLabel = new JLabel(determineRankText(index), SwingConstants.CENTER);
		rankLabel.setFont(new Font("ARIAL", Font.BOLD, 20));
		rankLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

		// Addit to the panel
		laptopPanel.add(rankLabel);

	}
	
	// Create the laptop label
	public void createLaptopLabel(JPanel laptopPanel, int index){

		// Create the label the image is going to be placed on
		JLabel laptopImageLabel = new JLabel(new ImageIcon(laptopResultsArray[index].getImage().getImage()
			.getScaledInstance(200, 200, Image.SCALE_SMOOTH)));

		// Add the laptop image (changing the size of it, too)
		laptopImageLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

		// Add the image
		laptopPanel.add(laptopImageLabel);

	}

	// Create model name
	public void createModelLabel(JPanel laptopPanel, int index){

		// Add model name
		JLabel laptopModel = new JLabel(laptopResultsArray[index].getModel(), SwingConstants.CENTER);
		laptopModel.setFont(new Font("ARIAL", Font.PLAIN, 16));
		laptopModel.setAlignmentX(Component.CENTER_ALIGNMENT);
		laptopPanel.add(laptopModel);

	}

	// Create price label
	public void createPriceLabel(JPanel laptopPanel, int index){

		// Add price
		JLabel laptopPrice = new JLabel("$" + laptopResultsArray[index].getPrice(), SwingConstants.CENTER);
		laptopPrice.setFont(new Font("ARIAL", Font.BOLD, 40));
		laptopPrice.setAlignmentX(Component.CENTER_ALIGNMENT);
		laptopPanel.add(laptopPrice);
	}

	// Method to create more info Button
	public void createMoreInfoButton(JPanel laptopPanel){

		// Add more info Button
		JButton toWebsiteButton = new JButton("More Info");
		toWebsiteButton.setFont(new Font("ARIAL", Font.BOLD, 18));
		toWebsiteButton.setBackground(new Color(49, 71, 58));
		toWebsiteButton.setForeground(Color.WHITE);
		toWebsiteButton.setAlignmentX(Component.CENTER_ALIGNMENT);

		// Set the size of the button
		Dimension buyButtonSize = new Dimension(200, 50);
		toWebsiteButton.setMinimumSize(buyButtonSize);
		toWebsiteButton.setPreferredSize(buyButtonSize);
		toWebsiteButton.setMaximumSize(buyButtonSize);
		toWebsiteButton.addActionListener(this);
		laptopPanel.add(toWebsiteButton);

	}

	// Method to create To Website Button
	public void createToWebsiteButton(JPanel laptopPanel){

		// Add to Website Button
		JButton toWebsiteButton = new JButton("To Website");
		toWebsiteButton.setFont(new Font("ARIAL", Font.PLAIN, 14));
		toWebsiteButton.setBackground(new Color(49, 71, 58));
		toWebsiteButton.setForeground(Color.WHITE);
		toWebsiteButton.setAlignmentX(Component.CENTER_ALIGNMENT);

		// Set the size of the button
		Dimension buyButtonSize = new Dimension(150, 30);
		toWebsiteButton.setMinimumSize(buyButtonSize);
		toWebsiteButton.setPreferredSize(buyButtonSize);
		toWebsiteButton.setMaximumSize(buyButtonSize);
		toWebsiteButton.addActionListener(this);
		laptopPanel.add(toWebsiteButton);

	}

	// Method for when an action is performed
	@Override
	public void actionPerformed(ActionEvent e) {

		// Checking each of the rank buttons (1st, 2nd, 3rd)
		for (int i = 0; i < 3; i++) {

			// checking if the source is the button in the panel, this accesses the last component of the panel
			if (e.getSource() == panelArray[i].getComponent(panelArray[i].getComponentCount() - 1)) {

				// ! Written by Mr. Fernandes

				// This method is used to open a web browser that shows the web page of a laptop
				// (based on an index) using its hyperlink.
				// This assumes that the laptops are stored in a public static array
				// (laptopArray) declared in the LaptopStoreApplication class.private void
				// openWebBrowser(int index) {

				if (Desktop.isDesktopSupported()) {

					// Debug
					System.out.println("Link directed to : " + laptopResultsArray[i].getLink());
					
					try {
						Desktop.getDesktop().browse(new URI(laptopResultsArray[i].getLink()));
					} catch (IOException error) {
						error.printStackTrace();
					} catch (URISyntaxException error) {
						error.printStackTrace();
					}

				}

			} else if (e.getSource() == panelArray[i].getComponent(panelArray[i].getComponentCount() - 3)){
				
				// Remove the current frame
				dispose();
				
				// Create a new info frame with the selected laptop
				new InfoFrame(laptopResultsArray[i]);
			}

		}
	}

}
