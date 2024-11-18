
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;


public class Guess extends JFrame implements ActionListener {

    final private JTextField inputNumber;

    Guess(){
        setDefaultLookAndFeelDecorated(true);
        JLabel introMessage = new JLabel("Enter a Number 10...30 : ");
        introMessage.setFont(Font.getFont(Font.SERIF));
        introMessage.setVisible(true);
        introMessage.setBounds(111,50,250,30);
        add(introMessage);
        Font font = new Font("Arial", Font.ITALIC, 20); // Font name, style, size
        introMessage.setFont(font);
        inputNumber = new JTextField();
        inputNumber.setBounds(205,122,70,30);
        inputNumber.setVisible(true);
        add(inputNumber);

        JButton check = new JButton("Check");
        check.setBounds(188,205,105,50);
        check.setVisible(true);
        add(check);
        check.addActionListener(this);

        ImageIcon icon = new ImageIcon("D:\\surprise-box.png");
        setIconImage(icon.getImage());

        setLayout(null);
        setVisible(true);
        setResizable(false);
        setTitle("Guess Number Game ");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500,340);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        int firstInput = Integer.parseInt(inputNumber.getText());
        int secondInput=0,thirdInput=0;
        int r = new Random().nextInt(21)+10;
        boolean isEven = r % 2 == 0;
        if(r==firstInput){
            JOptionPane.showMessageDialog(null,"You are correct","Excellent",JOptionPane.INFORMATION_MESSAGE);
        }
        else{

            int result1 = JOptionPane.showConfirmDialog(null, "Second Try..?", "Wrong Answer", JOptionPane.YES_NO_CANCEL_OPTION);
            if(result1!=JOptionPane.YES_OPTION) {
                System.out.println("The number is generated is "+r+" ,Numbers you choose is :\n********************************************************" +
                        "\nfirst_choice: "+firstInput+
                        "\nsecond_choice: "+secondInput+
                        "\nthird_choice: "+thirdInput+"\n********************************************************");
                System.exit(0);
            }
            secondInput = Integer.parseInt(JOptionPane.showInputDialog("The number in "+where(r,10,30)+" : "));
            if(secondInput==r)
                JOptionPane.showMessageDialog(null,"You are correct","Very Good",JOptionPane.INFORMATION_MESSAGE);
            else {
                int result2 = JOptionPane.showConfirmDialog(null, "Third Try..?", "Wrong Answer", JOptionPane.YES_NO_CANCEL_OPTION);
                if(result2!=JOptionPane.YES_OPTION){
                    System.out.println("The number is generated is "+r+" ,Numbers you choose is :\n*************************************************" +
                            "\nfirst_choice: "+firstInput+
                            "\nsecond_choice: "+secondInput+
                            "\nthird_choice: "+thirdInput+"\n*************************************************");
                    System.exit(0);
                }
                thirdInput = Integer.parseInt(JOptionPane.showInputDialog("The number is "+((isEven)?"Even":"Odd")));
                if(thirdInput==r)
                    JOptionPane.showMessageDialog(null,"You are Correct","Good",JOptionPane.INFORMATION_MESSAGE);
                else
                    JOptionPane.showMessageDialog(null,"Wrong Answer", "Stupid",JOptionPane.ERROR_MESSAGE);
            }

        }
        dispose();
        System.out.println("The number is generated is "+r+" ,Numbers you choose is :\n*************************************************" +
                "\nfirst_choice: "+firstInput+
                "\nsecond_choice: "+secondInput+
                "\nthird_choice: "+thirdInput+"\n********************************************************");
    }
    public String where(int r,int min,int max){
        int mid = (min+max)/2;
        if(r<=mid)
            return "First_Part";
        else
            return "Second_Part";
    }

    public static void main(String[] args) {
        new Guess();
    }

}