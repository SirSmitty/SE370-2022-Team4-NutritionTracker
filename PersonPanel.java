import javax.swing.JPanel;
import java.awt.*;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.*;

public class PersonPanel extends JPanel {

    JButton backButton;

    PersonPanel() {
        setBackground(Color.WHITE);
        setLayout(null);
        // JLabel personLabel = new JLabel("This is the PersonPanel");
        // personLabel.setLocation(230, 120);
        // personLabel.setSize(250, 80);

        JLabel ageLabel = new JLabel("Age:");
        JTextField ageTField = new JTextField();

        // Age Label
        ageLabel.setLocation(105, 120);
        ageLabel.setSize(50, 40);
        add(ageLabel);

        // Age Text Field
        ageTField.setLocation(155, 120);
        ageTField.setSize(100, 40);
        ageTField.setBackground(Color.GRAY);
        add(ageTField);

        // logic for calculating ft/inches
        Integer feet[] = { 4, 5, 6, 7 };
        Integer inches[] = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11 };
        JLabel heightLabel = new JLabel("Height:");
        JLabel feetLabel = new JLabel("ft");
        JLabel inchLabel = new JLabel("in");
        JComboBox<Integer> feetCombo = new JComboBox<>(feet);
        JComboBox<Integer> inchCombo = new JComboBox<>(inches);

        // Height Label
        heightLabel.setLocation(92, 200);
        heightLabel.setSize(50, 40);
        add(heightLabel);

        // Feet drop down
        feetCombo.setLocation(145, 200);
        feetCombo.setSize(60, 40);
        add(feetCombo);
        // Feet Label
        feetLabel.setLocation(205, 200);
        feetLabel.setSize(40, 40);
        add(feetLabel);

        // Inch drop combo
        inchCombo.setLocation(245, 200);
        inchCombo.setSize(70, 40);
        add(inchCombo);
        // Inch
        inchLabel.setLocation(315, 200);
        inchLabel.setSize(40, 40);
        add(inchLabel);

        // Weight label
        JLabel weightLabel = new JLabel("Weight:");
        JTextField weightTFLabel = new JTextField();

        // Weight Label
        weightLabel.setLocation(90, 280);
        weightLabel.setSize(50, 40);
        add(weightLabel);

        // Weight TF Label
        weightTFLabel.setLocation(140, 280);
        weightTFLabel.setSize(100, 40);
        add(weightTFLabel);

        String activityLevelsOptions[] = { "low (1 workout / week)", "medium(2-3 workouts / week)",
                "high (4-5 workouts / week)", "extremely high (6+ workouts / week)" };
        JLabel actLevel = new JLabel("Activity Level:");
        JComboBox actCombo = new JComboBox(activityLevelsOptions);

        // ActivityLabelDrop
        actLevel.setLocation(50, 360);
        actLevel.setSize(100, 40);
        add(actLevel);

        // Activity Level Label
        actCombo.setLocation(150, 360);
        actCombo.setSize(100, 40);
        add(actCombo);

        String goalsOptions[] = { "Gain", "Maintain", "Lose" };
        JLabel goalsLabel = new JLabel("Goals:");
        JComboBox goalsCombo = new JComboBox(goalsOptions);

        // Goals Label
        goalsLabel.setLocation(100, 420);
        goalsLabel.setSize(50, 40);
        add(goalsLabel);

        // Goals Combo
        goalsCombo.setLocation(150, 420);
        goalsCombo.setSize(100, 40);
        add(goalsCombo);

        backButton = new JButton("<-");
        backButton.setLocation(50, 600);
        backButton.setSize(50, 50);

        // add(personLabel);
        add(backButton);
        setVisible(true);
    }

    public JButton getBackButton() {
        return backButton;
    }
}
