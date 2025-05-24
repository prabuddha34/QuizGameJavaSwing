import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class  Quiz extends JFrame implements ActionListener {

    String[] questions = {
            "1. What is the capital of India?",
            "2. Which planet is known as the Dwarf Planet?",
            "3. What is the square root of 49?",
            "4. Which language is used for Android development?",
            "5. Who defeated Napolean ?"
    };
    String[][] options = {
            {"New Delhi", "London", "Berlin", "Madrid"},
            {"Earth", "Pluto", "Jupiter", "Saturn"},
            {"6", "7", "8", "9"},
            {"Python", "Swift", "Java", "C++"},
            {"Van Gogh", "Picasso", "Waterloo", "Rommel"}
    };


int answers[]={0,1,1,2,2};
    ButtonGroup[] buttonGroups = new ButtonGroup[5];
    JRadioButton[][] radioButtons = new JRadioButton[5][4];
    JPanel panel = new JPanel(new GridLayout(2, 4));
    JButton submit;



    Quiz(){
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setTitle("Quiz Game ");
        this.setSize(420,420);
        this.setLayout(new GridLayout(0,1));
        for (int i = 0; i < questions.length; i++) {
            this.add(new Label(questions[i]));

            buttonGroups[i] = new ButtonGroup();

            JPanel questionPanel = new JPanel(new GridLayout(1, 4));

            for (int j = 0; j < 4; j++) {
                radioButtons[i][j] = new JRadioButton(options[i][j]);
                buttonGroups[i].add(radioButtons[i][j]);
                questionPanel.add(radioButtons[i][j]);
            }

            this.add(questionPanel);
        }
        submit= new JButton("Submit");
        submit.addActionListener(this);
        add(submit);
        this.setVisible(true);
    }

    public  static void main(String[]args){
     new Quiz();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
    int score=0;
    for(int i=0;i<5;i++){
        int selected=-1;
        for(int j=0;j<4;j++){
            if(radioButtons[i][j].isSelected()){
                selected=j;
            }
        }
        if(selected==answers[i])
            score++;
    }
    JOptionPane.showMessageDialog(this,"You scored "+score+" /5");
    System.exit(0);
    }
}
