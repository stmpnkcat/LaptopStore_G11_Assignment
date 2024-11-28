import java.awt.Color;
import java.awt.Component;
import java.awt.Desktop;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class ResultsFrame extends JFrame implements ActionListener {

	private ImageIcon logo = new ImageIcon("images/logo.png");
	private JLabel titleLabel = new JLabel("RESULTS");
	private JButton backButton = new JButton("BACK");

	private Laptop[] laptopResultsArray = LaptopStoreApp.laptopResultsArray;

	// array to store the panels
	private JPanel[] panelArray = new JPanel[3];

	public ResultsFrame() {

		// GUI Setup
		// Set up frame to be 1366x768
		setSize(1366, 768);

		// Add the frame title and logo
		setIconImage(logo.getImage());
		setTitle("Hunter's Laptops - Survey Results");
		setLayout(null);

		// Add the menu bar
		backButton.setBounds(50, 25, 150, 50);
		backButton.setFont(new Font("ARIAL", Font.BOLD, 30));
		backButton.addActionListener(this);
		add(backButton);

		// Colour the background green
		getContentPane().setBackground(new Color(237, 244, 242));

		// Label for the title
		titleLabel.setBounds(250, 25, 305, 50);
		titleLabel.setFont(new Font("ARIAL", Font.BOLD, 40));
		add(titleLabel);

		// add 3 panels for displaying the computers
		for (int i = 0; i < 3; i++) {
			// Create a panel with BoxLayout for vertical alignment
			JPanel laptopPanel = new JPanel();

			// setting the panel's location and size according to which one it is
			laptopPanel.setBounds(120 + i * 400, 150, 300, 500);

			// setting the background color
			laptopPanel.setBackground(Color.WHITE);

			// adding a border to the panel
			laptopPanel.setBorder(new EmptyBorder(20, 20, 20, 20));

			// setting layout to box layout
			// https://docs.oracle.com/javase/tutorial/uiswing/layout/box.html
			laptopPanel.setLayout(new BoxLayout(laptopPanel, BoxLayout.Y_AXIS));

			// creating vertical padding
			// https://stackoverflow.com/questions/10744809/boxlayout-misunderstanding-strut
			laptopPanel.add(Box.createVerticalStrut(20));

			// add rank label depending on which label it is
			String rankText = "";
			switch (i) {
			case 0:
				rankText = "1ST";
				break;
			case 1:
				rankText = "2ND";
				break;
			case 2:
				rankText = "3RD";
				break;
			}

			// adding a new label for the rank based on rank text, center it
			JLabel rankLabel = new JLabel(rankText, SwingConstants.CENTER);

			// setting the font of the label
			rankLabel.setFont(new Font("Arial", Font.BOLD, 20));

			// setting the alignment to center
			rankLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

			// adding it to the panel
			laptopPanel.add(rankLabel);
			// similar steps are done for every other component

			// creating vertical padding
			laptopPanel.add(Box.createVerticalStrut(10));

			// Add laptop image
			// getting the laptop image icon
			ImageIcon laptopImageIcon = laptopResultsArray[i].getImage();

			// getting the image
			Image laptopImage = laptopImageIcon.getImage();

			// scaling the image
			Image scaledLaptopImage = laptopImage.getScaledInstance(200, 200, Image.SCALE_SMOOTH);

			// creating the label the image is going to be placed on
			JLabel laptopImageLabel = new JLabel(new ImageIcon(scaledLaptopImage));

			// setting the image's alignment
			laptopImageLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

			// adding the image
			laptopPanel.add(laptopImageLabel);

			// Add model name
			JLabel laptopModel = new JLabel(laptopResultsArray[i].getModel(), SwingConstants.CENTER);
			laptopModel.setFont(new Font("Arial", Font.PLAIN, 16));
			laptopModel.setAlignmentX(Component.CENTER_ALIGNMENT);
			laptopPanel.add(laptopModel);

			laptopPanel.add(Box.createVerticalStrut(5));

			// Add price
			JLabel laptopPrice = new JLabel("$" + laptopResultsArray[i].getPrice(), SwingConstants.CENTER);
			laptopPrice.setFont(new Font("Arial", Font.BOLD, 40));
			laptopPrice.setAlignmentX(Component.CENTER_ALIGNMENT);
			laptopPanel.add(laptopPrice);

			laptopPanel.add(Box.createVerticalStrut(5));

			// Add ratings
			JLabel laptopQualityRating = new JLabel("Quality Rating: " + laptopResultsArray[i].getQualityRating());
			laptopQualityRating.setAlignmentX(Component.CENTER_ALIGNMENT);
			laptopPanel.add(laptopQualityRating);

			laptopPanel.add(Box.createVerticalStrut(5));

			JLabel laptopSpeedRating = new JLabel("Speed Rating: " + laptopResultsArray[i].getSpeedRating());
			laptopSpeedRating.setAlignmentX(Component.CENTER_ALIGNMENT);
			laptopPanel.add(laptopSpeedRating);

			laptopPanel.add(Box.createVerticalStrut(5));

			JLabel laptopMemoryRating = new JLabel("Memory Rating: " + laptopResultsArray[i].getMemoryRating());
			laptopMemoryRating.setAlignmentX(Component.CENTER_ALIGNMENT);
			laptopPanel.add(laptopMemoryRating);

			laptopPanel.add(Box.createVerticalStrut(20));

			// Add "Buy" button
			JButton buyButton = new JButton("Buy");
			buyButton.setFont(new Font("Arial", Font.BOLD, 30));
			buyButton.setBackground(new Color(49, 71, 58));
			buyButton.setForeground(Color.WHITE);
			buyButton.setAlignmentX(Component.CENTER_ALIGNMENT);

			// setting the size of the button
			Dimension buyButtonSize = new Dimension(200, 50);
			buyButton.setMinimumSize(buyButtonSize);
			buyButton.setPreferredSize(buyButtonSize);
			buyButton.setMaximumSize(buyButtonSize);
			buyButton.addActionListener(this);
			laptopPanel.add(buyButton);

			// changing the panel array to this panel
			panelArray[i] = laptopPanel;

			// adding the panel to the frame
			add(laptopPanel);
		}

		// turning the results frame visible
		setVisible(true);

	}

	// function for when an action is performed
	@Override
	public void actionPerformed(ActionEvent e) {

		// GUI Interactions
		// If the user clicks Inventory on the menu
		// Hide the current screen
		// Show the inventory
		// If the user clicks Home on the menu
		// Hide the current screen
		// Show the home screen
		// If the user clicks More Info
		// Show a More Info frame
		// Display the Laptop model, price, specs, and other information
		// Add a back button that closes the frame when it is pressed
		// If the user clicks Copy Link
		// Show a Copy Link frame
		// Add an entry box with the text being the link.
		
		for (int i = 0; i < 3; i++) {
			// checking if the source is the button in the panel, this accesses the last
			// component of the panel
			if (e.getSource() == panelArray[i].getComponent(panelArray[i].getComponentCount() - 1)) {
				// debug
				System.out.println("Button " + i + " clicked");
				// ! Written by Mr. Fernandes

				// This method is used to open a web browser that shows the web page of a laptop
				// (based on an index) using its hyperlink.
				// This assumes that the laptops are stored in a public static array
				// (laptopArray) declared in the LaptopStoreApplication class.private void
				// openWebBrowser(int index) {

				if (Desktop.isDesktopSupported()) {
					try {
						// debug
						System.out.println("Link directed to : " + laptopResultsArray[i].getLink());
						Desktop.getDesktop().browse(new URI(laptopResultsArray[i].getLink()));
					} catch (IOException error) {
						error.printStackTrace();
					} catch (URISyntaxException error) {
						error.printStackTrace();
					}
				}
			}
		}
	}

}
