package Panels;
import javax.swing.JPanel;

import PersonManagement.Person;
import PersonManagement.UserManager;
import WorkoutFB.AbstractWorkoutFactory;
import WorkoutFB.Day;
import WorkoutFB.Factory_IF;
import WorkoutFB.Week;
import WorkoutFB.Workout_IF;

import java.awt.*;
import java.awt.event.ActionEvent;

import javax.swing.JButton;
import javax.swing.*;
import java.io.File;
import java.io.IOException;
import java.util.List;



public class WPpanel extends JPanel {
    private boolean init = false;
    private JButton backButton;
    private Person activePerson;
    private Factory_IF workoutFactory;
    private Workout_IF activeWorkout;
    private Font customFont;

    public WPpanel() {
        setBackground(Color.WHITE);
        setLayout(null);


        // sets up Back Button
        backButton = new JButton("<-");
        backButton.setLocation(27, 590);
        backButton.setSize(60, 50);
        backButton.setBackground(new Color(211, 96, 90));
        backButton.setForeground(Color.WHITE);
        backButton.setOpaque(true);
        backButton.setBorderPainted(false);
        
    }
    
    public void initialize(UserManager uManager) {
        init = true;
        try{
            customFont = Font.createFont(Font.TRUETYPE_FONT, new File("assets/Objective-ExtraBoldSlanted.otf"))
            .deriveFont(18f);

            backButton.setFont(customFont);
            this.add(backButton);

            activePerson = changePerson(uManager, 0);
            workoutFactory = new AbstractWorkoutFactory(activePerson);
            activeWorkout = workoutFactory.createWorkout(activePerson.getActivityLevel());

            JComboBox<String> peopleBox = new JComboBox<>(uManager.getPeopleNames());
            peopleBox.setLocation(50, 50);
            peopleBox.setSize(150, 45);
            peopleBox.setFont(customFont);
            this.add(peopleBox);

            
            createMonthLabels();

            JButton changeButton = new JButton("<html><span color=\"white\">Change</span></html>");
            changeButton.setLocation(235, 50);
            changeButton.setSize(150, 45);
            changeButton.setFont(customFont);
            changeButton.setBackground(new Color(211, 96, 90));
            changeButton.setOpaque(true);
            changeButton.setBorderPainted(false);
            changeButton.addActionListener((ActionEvent e) -> {
                    activePerson = changePerson(uManager, peopleBox.getSelectedIndex());
                    activeWorkout = workoutFactory.createWorkout(activePerson.getActivityLevel());
                    createMonthLabels();
            });
            this.add(changeButton);

        } catch (IOException e) {
            e.printStackTrace();
        } catch (FontFormatException e){
            e.printStackTrace();
        }
    }

    public JButton getBackButton() {
        return backButton;
    }

    public boolean getInit() {
        return init;
    }

    public Person changePerson(UserManager um, int index) {
        return um.getPerson(index);
}

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        ImageIcon background = new ImageIcon("assets/milo_blank.jpg");
        Image backgroundImage = background.getImage(); // transform it
        Image backgroundResizeImage = backgroundImage.getScaledInstance(500, 700, java.awt.Image.SCALE_SMOOTH);
        ImageIcon backgroundFinal = new ImageIcon(backgroundResizeImage);
        backgroundFinal.paintIcon(this, g, 0, 0);
    }


    public void createMonthLabels(){

        
        activeWorkout.calculateWorkouts();
        List<Week> workoutWeeks = activeWorkout.getMonth();
        int startX = 50;
        int startY = 100;

        for(Week week : workoutWeeks){
            JLabel weekNumberLabel = new JLabel("Week " + week.getWeekNum().toString());
            weekNumberLabel.setLocation(startX, startY);
            weekNumberLabel.setSize(150, 50);
            weekNumberLabel.setFont(customFont);
            startY+=20;
            this.add(weekNumberLabel);

            List<Day> days = week.generateWorkoutWeek();
            for(Day day: days){
                System.out.println(day.getDay());
                day.createWorkouts();
                JLabel dayOfWeek = new JLabel(day.getDay());
                dayOfWeek.setLocation(startX, startY);
                dayOfWeek.setSize(150,50);
                dayOfWeek.setFont(customFont);
                this.add(dayOfWeek);
                startY+=20;

                String[] workouts = day.getWorkOuts();
                for(String workout: workouts){
                    JLabel activity = new JLabel(workout);
                    activity.setLocation(startX, startY);
                    activity.setSize(300, 50);
                    activity.setFont(customFont);
                    this.add(activity);
                    startY+=20;
                }
                
            }
            

            
        }
        
    }
}
