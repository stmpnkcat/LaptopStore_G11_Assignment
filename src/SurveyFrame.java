import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SurveyFrame {
	
	
    public SurveyFrame () {
        // Create the main frame
        JFrame frame = new JFrame("Hunter Laptops");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1366, 768); // Landscape resolution
        frame.setLayout(new BorderLayout());

        // Menu Bar
        MenuBarPanel menuBar = new MenuBarPanel();

        // Title (Separate from the menu bar)
        JLabel titleLabel = new JLabel("THE LAPTOP CHOOSING SURVEY");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 34)); // Set font size to 34
        titleLabel.setForeground(Color.WHITE); // Title color white
        titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        // Add title to a panel with a light green background
        JPanel titlePanel = new JPanel();
        titlePanel.setBackground(new Color(49, 71, 58)); // Dark greenish (#31473A)
        titlePanel.setLayout(new FlowLayout(FlowLayout.CENTER)); // Center title label
        titlePanel.add(titleLabel);
        titlePanel.setBorder(BorderFactory.createEmptyBorder(20, 0, 20, 0));

        // Create a header panel to hold the menu bar and title
        JPanel headerPanel = new JPanel();
        headerPanel.setLayout(new BorderLayout());
        headerPanel.add(menuBar, BorderLayout.NORTH);
        headerPanel.add(titlePanel, BorderLayout.CENTER);

        // Main Content Panel (will be wrapped in JScrollPane)
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS)); // Stack components vertically
        mainPanel.setBackground(new Color(237, 244, 242)); // Soft greenish-white (#EDF4F2)
        mainPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        // Add Survey Questions
        addQuestion(mainPanel, "What is your budget?",
            "$2000-$1500", "$1499-$1000", "$999-$500", "$499-$0");

        addQuestion(mainPanel, "What are you planning to use your laptop for?",
            "Gaming", "Professional Work", "School Work", "Other");

        addQuestion(mainPanel, "What screen size do you prefer?",
            "13 inches or smaller", "14-15 inches", "16 inches or larger");

        addQuestion(mainPanel, "What operating system do you prefer?",
            "Windows", "MacOS", "Linux", "Other");

        addQuestion(mainPanel, "How important is battery life to you?",
            "Very Important", "Somewhat Important", "Not Important");

        addQuestion(mainPanel, "What is your preferred laptop brand?",
            "Apple", "Dell", "HP", "Other");

        addQuestion(mainPanel, "Would you prefer a touch screen?",
            "Yes", "No", "Indifferent");

        addQuestion(mainPanel, "Do you need a high-performance GPU?",
            "Yes", "No", "Maybe");

        addQuestion(mainPanel, "What is your preferred screen resolution?",
            "1080p", "1440p", "4K", "Other");

        addQuestion(mainPanel, "Do you plan to upgrade your laptop in the future?",
            "Yes", "No", "Maybe");

        // Add Submit Button at the bottom of the main panel
        JPanel submitPanel = new JPanel();
        submitPanel.setBackground(new Color(237, 244, 242)); // Same background as the survey
        JButton submitButton = new JButton("Submit");
        submitButton.setFont(new Font("Arial", Font.BOLD, 18));
        submitButton.setBackground(new Color(49, 71, 58)); // Dark greenish
        submitButton.setForeground(Color.WHITE);
        submitButton.setPreferredSize(new Dimension(200, 50));
        submitButton.setFocusPainted(false);
        submitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.out.println("Submit button clicked.");
            }
        });
        submitPanel.add(submitButton);
        mainPanel.add(submitPanel);

        // Scroll Pane
        JScrollPane scrollPane = new JScrollPane(mainPanel);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPane.getVerticalScrollBar().setUnitIncrement(10);
        scrollPane.setPreferredSize(new Dimension(1366, 600)); // Make the scroll pane large enough to show content

        // Add header panel and scroll pane to frame
        frame.add(headerPanel, BorderLayout.NORTH);
        frame.add(scrollPane, BorderLayout.CENTER);

        // Display the frame
        frame.setVisible(true);
    }

    // Helper method to add a question to the survey
    private static void addQuestion(JPanel panel, String question, String... options) {
        // Create a question panel
        JPanel questionPanel = new JPanel();
        questionPanel.setLayout(new GridLayout(0, 1, 5, 5)); // Grid layout to keep options aligned
        questionPanel.setBackground(Color.WHITE); // White background
        questionPanel.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(200, 200, 200)), // Light border
                BorderFactory.createEmptyBorder(10, 10, 10, 10))); // Padding
        questionPanel.setPreferredSize(new Dimension(1200, 120)); // Ensure uniform height for all panels
        questionPanel.setMaximumSize(new Dimension(Short.MAX_VALUE, 120));

        // Add the question label with bigger font
        JLabel questionLabel = new JLabel(question);
        questionLabel.setFont(new Font("Arial", Font.BOLD, 18)); // Larger and bold font for questions
        questionLabel.setForeground(new Color(49, 71, 58)); // Dark greenish
        questionPanel.add(questionLabel);

        // Add options as radio buttons with bigger font
        ButtonGroup group = new ButtonGroup(); // Ensure only one option can be selected
        for (String option : options) {
            JRadioButton radioButton = new JRadioButton(option);
            radioButton.setFont(new Font("Arial", Font.PLAIN, 16)); // Bigger font for options
            radioButton.setBackground(Color.WHITE); // Match question panel background
            radioButton.setForeground(new Color(49, 71, 58)); // Dark greenish
            radioButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    System.out.println(radioButton.getText() + " selected.");
                }
            });
            group.add(radioButton); // Add radio button to the button group
            questionPanel.add(radioButton);
        }

        // Add the question panel to the main panel
        panel.add(questionPanel);
        panel.add(Box.createRigidArea(new Dimension(0, 20))); // Add spacing between questions
    }
}