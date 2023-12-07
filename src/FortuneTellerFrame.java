import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.Random;

public class FortuneTellerFrame extends JFrame
{
    JPanel MainP, TopP, CenterP, BottomP;

    JButton MagicBut, TerminateBut;

    TextArea MagicTA;

    JScrollPane Pan;

    JLabel icon;
    ImageIcon magicIcon;

    String[] destiny = {"There will be a message for a reward.",
            "Someone's misfortune is serendipity for another.",
            "There is mistrust among us.",
            "Did you come here because of 8-ball?",
            "Working hard or hardly working?",
            "There is someone who is rotten to the core.",
            "A donut is nearby....",
            "We all have a fortune to only get disappointed.",
            "Do you want the fish or the fishing pole?",
            "At most, there is gold. You just don't know how to find it.",
            "Random things happen when random solutions come.",
            "Beware the white rabbit."
    };
    int curFortuneDex = -1;
    int newFortuneDex;

    public FortuneTellerFrame() {
        Toolkit kit = Toolkit.getDefaultToolkit();
        Dimension SizeScreen = kit.getScreenSize();
        int screenHeight = SizeScreen.height;
        int screenWidth = SizeScreen.width;

        setSize(screenWidth * 3/4, 650);
        setLocation(screenWidth / 8, (screenHeight - 650) / 2);

        createGUI();
        setTitle("The Magical Fortune Teller");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

    }

    private void createGUI()
    {
        MainP = new JPanel();
        TopP = new JPanel();
        CenterP = new JPanel();
        BottomP = new JPanel();

        MainP.setLayout(new BorderLayout());
        MainP.add(TopP, BorderLayout.NORTH);
        MainP.add(CenterP, BorderLayout.CENTER);
        MainP.add(BottomP, BorderLayout.SOUTH);

        add(MainP);
        createTopP();
        createCenterP();
        createBottomP();
    }

    private void createCenterP()
    {
        MagicTA = new TextArea(15,60);
        Pan = new JScrollPane(MagicTA);
        CenterP.add(Pan);
    }

    private void createTopP() {
        magicIcon =new ImageIcon("/Users/a111/IdeaProjects/FortuneTeller/src/Fortune_Teller.jpeg");

        icon = new JLabel("Magic Awaits! Care to read out your fortune?", magicIcon, JLabel.CENTER);
        icon.setFont(new Font(Font.SERIF, Font.ROMAN_BASELINE, 25));
        icon.setHorizontalTextPosition(JLabel.CENTER);
        icon.setVerticalTextPosition(JLabel.BOTTOM);

        TopP.add(icon);
    }


    private void createBottomP() {
        MagicBut = new JButton("Read the Magic Fortune!");
        MagicBut.setFont(new Font(Font.MONOSPACED, Font.ITALIC, 15));
        MagicBut.addActionListener((ActionEvent ae) -> {
            do {
                Random r = new Random();
                newFortuneDex = r.nextInt(destiny.length);
            }
            while(newFortuneDex == curFortuneDex);
            MagicTA.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 15));
            curFortuneDex = newFortuneDex;
            MagicTA.append(destiny[curFortuneDex] + "\n");});

        TerminateBut = new JButton("Quit");
        TerminateBut.setFont(new Font(Font.MONOSPACED, Font.ITALIC, 15));

        TerminateBut.addActionListener((ActionEvent ae) -> System.exit(0));

        BottomP.setLayout(new GridLayout(1,2));
        BottomP.add(MagicBut);
        BottomP.add(TerminateBut);
    }

}