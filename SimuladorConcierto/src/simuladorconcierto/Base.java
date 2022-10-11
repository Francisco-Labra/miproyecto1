
package simuladorconcierto;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.ImageIcon;
import javax.swing.JPanel;




public class Base extends JPanel implements Runnable{
    private final Image background;
    private Image cartel;
    private Image puerta;
    private Image persona;

    private int x,y;
    private int z = 1000;
    private Thread hilo;
    
    public Base(){
        setBackground(Color.WHITE);
        setDoubleBuffered(true);
        background = new ImageIcon(this.getClass().getResource("/imagenes/background.jpg")).getImage();
        x = 0;
        y = 0;
        cartel();
        puerta();
        persona();
        hilo = new Thread(this);
        hilo.start();
        
    }
    void cartel(){
        cartel = new ImageIcon(this.getClass().getResource("/imagenes/cartel.jpg")).getImage();
    }
    void puerta(){
        puerta = new ImageIcon(this.getClass().getResource("/imagenes/door.png")).getImage();
    }
    void persona(){
        persona = new ImageIcon(this.getClass().getResource("/imagenes/personas.png")).getImage();
    }
    @Override
    public void paint(Graphics g){
        super.paint(g);
        Graphics2D g2 = (Graphics2D)g;
        g2.drawImage(background, 0,0, null);
        g2.drawImage(cartel, 300, 25, null);
        g2.drawImage(cartel, 300, 425, null);
        g2.drawImage(cartel, 100, 25, null);
        g2.drawImage(cartel, 100, 425, null);
        g2.drawImage(puerta, 500, 75, null);
        g2.drawImage(puerta, 500, 375, null);
        g2.drawImage(persona, x,75, null);
        g2.drawImage(persona, y,375, null);
        
        Toolkit. getDefaultToolkit().sync();
        g.dispose();
    }
    
    public void ciclo(){
        x += 100;
        if ( x > 800 ){
            x = -100;
            z = z -20;
            System.out.println(z);
        }
    }
    public void ciclo2(){
        y += 100;
        if ( y > 800 ){
            y = -100;
            z = z-20;
            System.out.println(z);
        }
    }
    @Override
    public void run() {
        
        while(z > 0){
            repaint();
            ciclo();
            ciclo2();
            try{
                Thread.sleep(100);
            }catch(Exception e){
                System.out.println(e);
            
            }
        }
    }
    
    
}
