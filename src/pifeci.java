
import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.GradientPaint;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.JPasswordField;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.ImageIcon;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import java.awt.event.KeyListener;

public class pifeci extends JFrame implements ActionListener{
	private ImageIcon icon = new ImageIcon("src/images/pyfeci.png");
	private Random r = new Random();
	private int my_score=0;
	private int c_score=0;
	private int x_score=0;
	private int c_num = r.nextInt(3);
	
	private JButton Pierre = new JButton("Pierre");
	private JButton Feuille = new JButton("Feuille");
	private JButton Ciseau = new JButton("Ciseau");
	private JLabel score = new JLabel("Veuillez faire votre selection");
	private JLabel chx = new JLabel("");
	private JLabel chxo = new JLabel("");
	private JLabel rslt = new JLabel("");
	
	private JLabel label = new JLabel("jeu du morpion");
	
	
	private String myChoice ; 
	private String computerChoice;
	public void ChoiceListener(String choice) {
        this.myChoice = choice;
    }
	
	public pifeci() {
		//propriétés de la fenêtre 
		this.setTitle("JPFC");
		//this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setBounds(1000, 100, 387, 500);
		this.setLayout(null);
		this.getContentPane().setBackground(Color.cyan);
		this.setIconImage(icon.getImage());

		
		this.Pierre.setBounds(10, 200, 355, 25);
		this.add(this.Pierre);
		this.Feuille.setBounds(10, 230, 355, 25);
		this.add(this.Feuille);
		this.Ciseau.setBounds(10, 260, 355, 25);
		this.add(this.Ciseau);
		this.score.setBounds(10, 300, 387, 15);
		this.add(this.score);
		this.chx.setBounds(10, 320, 387, 15);
		this.add(this.chx);
		this.chxo.setBounds(10, 335, 387, 15);
		this.add(this.chxo);
		this.rslt.setBounds(10, 350, 387, 15);
		this.add(this.rslt);
		this.setVisible(true);
		
		this.Pierre.addActionListener(this);
		this.Feuille.addActionListener(this);
		this.Ciseau.addActionListener(this);
		
	}
	public static void main (String args[])
	{
		pifeci pifeci = new pifeci(); 
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		//tableau qui contient les choix de l'utilisateur et de l'ordinateur
		String[] choices = {"Pierre", "Feuille", "Ciseaux"};//choices = {0,1,2};
		
		if (e.getSource() == this.Pierre) {//si j'appuie sur le boutton pierre
			ChoiceListener(choices[0]);//affiche une des contenues du tableau choices qui est pierre
		}
		if (e.getSource() == this.Feuille) {//si j'appuie sur le boutton feuille
			ChoiceListener(choices[1]);//affiche une des contenues du tableau choices qui est feuille
		}
		if (e.getSource() == this.Ciseau) {//si j'appuie sur le boutton ciseau
			ChoiceListener(choices[2]);//affiche une des contenues du tableau choices qui est ciseau
		}
		
		this.chx.setText("Vous avez choisi "+this.myChoice);//modifie ou fait apparaitre le JLabel chx (montre mon choix)
		
		this.computerChoice = choices[new Random().nextInt(choices.length)];//l'odinateur choisi une des contenues du tableau choices
		this.chxo.setText("Ordi a choisi "+this.computerChoice);//modifie ou fait apparaitre le JLabel chxo (le choix de l'ordinateur)
		
/*--------------------------------------------------------------condition--------------------------------------------------------------*/
		if(this.myChoice.equals(this.computerChoice)) {//si j'ai le même choix que l'ordinateur
			this.x_score++;//met 1 point de plus
        	this.rslt.setText("egaliter");//modifie ou fait apparaitre le JLabel chx (marque egaliter)
        	this.score.setText("vous:"+this.my_score+" | ordi:"+this.c_score+" | egaliter:"+this.x_score);//modifie score
		}
		//si j'ai gagné
		else if ((this.myChoice.equals(choices[0]) && this.computerChoice.equals(choices[2])) || 
				 (this.myChoice.equals(choices[1]) && this.computerChoice.equals(choices[0])) || 
				 (this.myChoice.equals(choices[2]) && this.computerChoice.equals(choices[1]))) {
			this.my_score++;//met 1 point de plus
			this.rslt.setText("vous avez gagner 1 points");//modifie ou fait apparaitre le JLabel chx (determine qui a gagner)
			this.score.setText("vous:"+this.my_score+" | ordi:"+this.c_score+" | egaliter:"+this.x_score);//modifie score
		}
		else {//si j'ai perdu
			this.c_score++;//met 1 point de plus
			this.rslt.setText("ordi a gagner 1 points");//modifie ou fait apparaitre le JLabel chx (determine qui a gagner)
			this.score.setText("vous:"+this.my_score+" | ordi:"+this.c_score+" | egaliter:"+this.x_score);//modifie score
		}
/*--------------------------------------------------------------condition--------------------------------------------------------------*/
/*--------------------------------------------------------------design de vainqueur--------------------------------------------------------------*/
		if(this.my_score==3) {//si mon score est de 3
			JOptionPane.showMessageDialog(this, "vous avez gagner");
			this.dispose();//detruit l'application
		}
		else if(this.c_score==3) {//si le score de l'ordi est de 3
			JOptionPane.showMessageDialog(this, "L'ordi a gagner");
			this.dispose();//detruit l'application
		}
/*--------------------------------------------------------------design de vainqueur--------------------------------------------------------------*/
	}
}
