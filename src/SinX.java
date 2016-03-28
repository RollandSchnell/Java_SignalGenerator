

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;


import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


import javax.swing.JFrame;

import javax.swing.JOptionPane;





import static java.lang.Math.*;
 
public class SinX extends Component {
    
	

	int k = 1;
	double[] sin;
	int Yfinal = 0;
	
	public int addY(int k ,int[] Y) {
		
		if( k > 1) {
		return Y[k-1] + addY(k - 1,Y);
		} else {
			return Y[0];
		}
		
	}
    public void paint(Graphics g)
    {
    	
        g.drawLine(0,350,900,350); // x-axis
        g.drawLine(450,0,450,900); // y-axis
        
        g.setColor(Color.red);
        int[] Y = new int[k];
        
        sin = new double[k];
        for(double x=-450;x<=450;x=x+0.005)
        {
        	
        	for(int i = 0;i < k;i++) {
        		
        		sin[i] = (((100/(2*(i+1)-1))*4)/3.14) * sin(x*(2*(i+1)-1)*3.1415926/180);
        		
        	}
             
        	for(int i = 0;i < k;i++) {
        		Y[i] = (int)sin[i];
        		
        	}
        	
        	if(k == 1) {
        		
        		Yfinal = Y[0];
        	}
        	if(k > 1) {
        		
        		Yfinal = addY(k, Y);
        	}
        	
            
            int X = (int)x;
           // g.drawLine(450+X,350-Y,450+X,350-Y);
           
            g.fillOval(450+X,350-Yfinal,3,3);
            
            
        }
    }
    
    public void setK() {
    	
    	String tempk = JOptionPane.showInputDialog(null,"Number of sin waves:");
    	
    	k = Integer.parseInt(tempk);
    	repaint();
    }
    
    
    
    
    public static void main(String[] args)
    {
    	
    	SinX sin = new SinX();
        JFrame frame = new JFrame();
  
        frame.addKeyListener(new KeyListener(){

			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == e.VK_ENTER) {
					sin.setK();
				}
				
			}

			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
        	
        });
        frame.setSize(900, 700);
        frame.setTitle("Sin(x) Graph");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.getContentPane().add(sin);
        
        frame.setVisible(true);
        
        
        
    }




	
}