import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Desktop;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

// The Info frame class is a frame
public class InfoFrame extends JFrame implements ActionListener {

    // Initialize the selected laptop
    private Laptop selectedLaptop;

	// Declare the logo
	private ImageIcon logo = new ImageIcon("images/logo.png");

	// Create the components
	private MenuBarPanel menuBar = new MenuBarPanel();
    private JPanel titlePanel = new JPanel();
    private JLabel titleLabel = new JLabel();
    private JPanel headerPanel = new JPanel();
    private JButton toWebsiteButton = new JButton();
    private JPanel infoPanel = new JPanel();
    private GridBagConstraints gbc = new GridBagConstraints();

	// Declare the Info frame
	public InfoFrame(Laptop selectedLaptop) {

        // Set the selected laptop
        this.selectedLaptop = selectedLaptop;

        // Set up the frame
        setupFrame();

        // Create the components
        createHeader();
        createLaptopImage();
        createToWebsiteButton();
        createInfoPanel();

		// Turning the results frame visible
		setVisible(true);

	}

	// GUI Setup
    public void setupFrame(){

		setSize(1366, 768); // Set up frame to be 1366x768
		setIconImage(logo.getImage()); // Add the frame title and logo
		setTitle("Hunter's Laptops - Laptop Information"); // Set the frame's title
		setLayout(null); // Set the layout of the frame
		getContentPane().setBackground(new Color(237, 244, 242)); // Color the background green

    }

    public void createHeader(){

        // Create the components
        createMenuBar();
		createTitleLabel();
		createTitlePanel();
		createHeaderPanel();   

    }

    public void createMenuBar(){
        
        // Menu Bar creation
		menuBar.setBounds(0, 0, 1366, 50);
		add(menuBar);
		
    }

    public void createTitleLabel(){
        
        // Creating the title label
        titleLabel.setText("   LAPTOP INFORMATION: " + selectedLaptop.getModel()); // Setting the text of the label according to the model
        titleLabel.setFont(new Font("ARIAL", Font.BOLD, 34)); // Set font size to 34
        titleLabel.setForeground(Color.WHITE); // Title color white
    }

    public void createTitlePanel(){

        // Add title to a panel with a light green background
        titlePanel.setBackground(new Color(39, 61, 48)); // Dark greenish (#31473A)
        titlePanel.setLayout(new FlowLayout(FlowLayout.LEFT)); // Center title label
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

    // Method to create the laptop image
    public void createLaptopImage(){

        // Add laptop image (changing the size of it, too)
        JLabel laptopImageLabel = new JLabel(new ImageIcon(selectedLaptop.getImage().getImage()
            .getScaledInstance(350, 350, Image.SCALE_SMOOTH)));
        laptopImageLabel.setBounds(100, 200, 350, 350);

        // Creating the image's border
        laptopImageLabel.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(new Color(200, 200, 200)), // Light border
            BorderFactory.createEmptyBorder(10, 10, 10, 10)));

        // Add the image
        add(laptopImageLabel);

    }

    // Create To website button
    public void createToWebsiteButton(){

        // Changing the button's settings
        toWebsiteButton.setText("To Website");
        toWebsiteButton.setFont(new Font("ARIAL", Font.BOLD, 18));
        toWebsiteButton.setBackground(new Color(49, 71, 58));
        toWebsiteButton.setForeground(Color.WHITE);
        toWebsiteButton.addActionListener(this); // This allows the button to send an output

        // Adding the button
        toWebsiteButton.setBounds(170, 570, 200, 50);
        add(toWebsiteButton);

    }

    // Creating the Info panel
    public void createInfoPanel(){

        // Setting the background color to the same as the background
        infoPanel.setBackground(new Color(237, 244, 242));

        // Setting the grid bag layour
        // https://docs.oracle.com/javase/tutorial/uiswing/layout/gridbag.html
        infoPanel.setLayout(new GridBagLayout()); // Use Grid bag layout
        gbc.insets = new Insets(10, 10, 10, 10); // Add padding
        gbc.anchor = GridBagConstraints.WEST; // Align components to the left
        gbc.gridx = 0; // Set default values
        gbc.gridy = 0;

        // Creating rows to display the information
        createRow("Model", selectedLaptop.getModel());
        createRow("Price", "$" + selectedLaptop.getPrice());
        createRow("Brand", selectedLaptop.getBrand());
        createRow("SSD", selectedLaptop.getStorage() + "gb");
        createRow("RAM", selectedLaptop.getRam() + "gb");
        createRow("Resolution", selectedLaptop.getVertRes() + "x" + selectedLaptop.getHorRes());
        createRow("Display Size", selectedLaptop.getDisplaySize()+"″");
        createRow("Weight", selectedLaptop.getWeight() + "lb");
        createRow("RAM", selectedLaptop.getRam() + "gb");
        createRow("CPU", selectedLaptop.getCpuBrand() + " " + selectedLaptop.getCpuModel());
        createRow("GPU", selectedLaptop.getGpuModel());
        createRow("Touchscreen", selectedLaptop.getIsTouchScreen() + "");

        // Setting the panel's size and adding it
        infoPanel.setBounds(400, 150, 500, 500);
        add(infoPanel);
    }

    // Making a function to create rows
    public void createRow(String left, String right){

        // If the right entry is not nothing or false, make the row
        if (!right.equals("N/A") && !right.equals("false")){

            gbc.gridx = 0; // Change the grid to the left

            // Create the label
            JLabel leftLabel = new JLabel(left + ":");
            leftLabel.setFont(new Font("Arial", Font.BOLD, 16));
            infoPanel.add(leftLabel, gbc);
    
            gbc.gridx = 1; // Change the grid to the right

            // Create the label
            JLabel rightLabel = new JLabel(right);
            rightLabel.setFont(new Font("Arial", Font.PLAIN, 16));
            infoPanel.add(rightLabel, gbc);
    
            // Increase the row number
            gbc.gridy++;
        }

    }

	// Method for when an action is performed
	@Override
	public void actionPerformed(ActionEvent e) {
		
        // Checking if the To website button is pressed
        if (e.getSource() == toWebsiteButton) {

            // ! Written by Mr. Fernandes

            // This method is used to open a web browser that shows the web page of a laptop
            // (based on an index) using its hyperlink.
            // This assumes that the laptops are stored in a public static array
            // (laptopArray) declared in the LaptopStoreApplication class.private void
            // openWebBrowser(int index) {

            if (Desktop.isDesktopSupported()) {
                try {
                    Desktop.getDesktop().browse(new URI(selectedLaptop.getLink()));
                } catch (IOException error) {
                    error.printStackTrace();
                } catch (URISyntaxException error) {
                    error.printStackTrace();
                }
            }
        }
		
	}

}
