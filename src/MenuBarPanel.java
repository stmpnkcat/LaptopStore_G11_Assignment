import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuBarPanel extends JPanel {
    public MenuBarPanel() {
        setBackground(new Color(49, 71, 58)); // Dark greenish (#31473A)
        setLayout(new FlowLayout(FlowLayout.LEFT));

        JButton homeButton = new JButton("Home");
        JButton inventoryButton = new JButton("Inventory");
        JButton surveyButton = new JButton("Survey");
        JButton aboutButton = new JButton("About");

        styleButton(homeButton);
        styleButton(inventoryButton);
        styleButton(surveyButton);
        styleButton(aboutButton);

        add(homeButton);
        add(inventoryButton);
        add(surveyButton);
        add(aboutButton);
    }

    private void styleButton(JButton button) {
        button.setBackground(new Color(49, 71, 58)); // Dark greenish
        button.setForeground(Color.WHITE);          // White text
        button.setFont(new Font("Arial", Font.PLAIN, 14));
        button.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20)); // Padding for buttons
        button.setFocusPainted(false);
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.out.println(button.getText() + " button clicked.");
            }
        });
    }
}