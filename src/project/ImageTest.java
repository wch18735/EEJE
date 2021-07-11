package project;

import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ImageTest extends JFrame {
   JPanel p1;
   JButton b;
      public ImageTest() {
         ImageBackGround panel1 = new ImageBackGround();   //�̹��� �г�
         panel1.add(new JLabel());               //�̹��� �гο� ��� �߰�
         
         p1 = new JPanel();                        //�̹����� ���� �г�
         p1.setLayout(new BorderLayout());
         p1.add(panel1, BorderLayout.CENTER);         //�̹��� ���� �гο� �̹��� �г��� �߰�
         add(p1);

         setSize(700,700);
         setVisible(true);
      }
      
      class ImageBackGround extends JPanel{
         ImageIcon icon = new ImageIcon("image/background.png");
         Image img = icon.getImage();
           
           public void paintComponent(Graphics g){
               super.paintComponent(g);
               g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), this);
           }
      }
      
       
       public static void main(String[] args) {
          new ImageTest();
       }

}