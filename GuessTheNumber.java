import javax.swing.*;
import java.util.Random;

public class GuessTheNumber {
    public static void main(String[] args) {
        Random random=new Random();
        int ComputerChooseNumber=random.nextInt(100) + 1;
        int limit=15;
        for (int i=1;i<=15;i++) {
            int toChoose = Integer.parseInt(JOptionPane.showInputDialog("Computer has chosen a random number between 0 to 100.\n Can you guess the Number within "+limit+ " attempts???"));
            if (toChoose == ComputerChooseNumber) {
                JOptionPane.showMessageDialog(null, "Wow !!! You guess the number at "+i+" attempts...🎉🎉🎉 \n The number was: "+ComputerChooseNumber);
                break;
            } else if (toChoose > ComputerChooseNumber && toChoose<=100) {
                limit--;
                JOptionPane.showMessageDialog(null, "You guess is high...Try again!! \n Remaining Attempts: "+limit);

            } else if (toChoose < ComputerChooseNumber && toChoose>=0) {
                limit--;
                JOptionPane.showMessageDialog(null, "You guess is low...Try again!! \n Remaining Attempts: "+limit);

            } else if(toChoose>100){
                limit--;
                JOptionPane.showMessageDialog(null,"Please enter the number between 0 to 100 \n Remaining Attempts: "+limit);
            }else {
                break;
            }
        }
    }
}