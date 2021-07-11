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
         ImageBackGround panel1 = new ImageBackGround();   //이미지 패널
         panel1.add(new JLabel());               //이미지 패널에 요소 추가
         
         p1 = new JPanel();                        //이미지를 담을 패널
         p1.setLayout(new BorderLayout());
         p1.add(panel1, BorderLayout.CENTER);         //이미지 담을 패널에 이미지 패널을 추가
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