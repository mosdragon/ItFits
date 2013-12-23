import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class ItFits extends JFrame
{
private ImageIcon image;
private JTextField textfield;
private String who;
private String what;
private String done;

// these buttons will change the pics
//private JLabel bodyLabel;
private JButton toBody;
//private JLabel shirtLabel;
private JButton toShirt;
//private JLabel finalLabel;
private JButton toFinal;

private JLabel label;

ItFits(String model, String shirt) {
  //creates images w/ proper names 
  done = "img/" + model+shirt+".png";
  who = "img/" +model+".jpg";
  what = "img/" +shirt+".jpg";
  
  //creates buttons w/ proper names
  toBody = new JButton("Model");
  toShirt = new JButton("Shirt");
  toFinal = new JButton("Try it on!");
  add(toBody);
  add(toShirt);
  add(toFinal);
  //makes the pic show first
  setLayout(new FlowLayout());
  image = new ImageIcon(getClass().getResource(who));
  label = new JLabel(image);
  add(label);
  
  //the following will instantiate classes that will be defined later
  ToBody tb = new ToBody();
  toBody.addActionListener(tb);
  ToShirt ts = new ToShirt();
  toShirt.addActionListener(ts);
  ToFinal tf = new ToFinal();
  toFinal.addActionListener(tf); 
}
public class ToBody implements ActionListener
{
  public void actionPerformed(ActionEvent ev1)
  {
    //deteles current pic
      Container parent = label.getParent();
  parent.remove(label);
  parent.validate();
  parent.repaint();
  
   setLayout(new FlowLayout());
  image = new ImageIcon(getClass().getResource(who));
  label = new JLabel(image);
  add(label);
  parent.validate();
  parent.repaint();
  }
}
public class ToShirt implements ActionListener
{
  public void actionPerformed(ActionEvent ev1)
  {
      Container parent = label.getParent();
  parent.remove(label);
  parent.validate();
  parent.repaint();
  
   setLayout(new FlowLayout());
  image = new ImageIcon(getClass().getResource(what));
  label = new JLabel(image);
  add(label);
  parent.validate();
  parent.repaint();
  }
}
public class ToFinal implements ActionListener
{
  public void actionPerformed(ActionEvent ev1)
  {
      Container parent = label.getParent();
  parent.remove(label);
  parent.validate();
  parent.repaint();
    
  setLayout(new FlowLayout());
  image = new ImageIcon(getClass().getResource(done));
  label = new JLabel(image);
  add(label);
  parent.validate();
  parent.repaint();
  }
}

public static void main(String args[])
    {
  String model = JOptionPane.showInputDialog("Who will you be shopping for?");
  String shirt = JOptionPane.showInputDialog("Excellent! And which shirt would you like to try on?");
  JOptionPane.showMessageDialog(null, "Coming right up!");
 
 ItFits gui = new ItFits(model, shirt);
 gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 gui.setVisible(true);
 gui.setTitle("Expecience the Magic at Zara's");
 gui.setSize(500,700);
    }
}