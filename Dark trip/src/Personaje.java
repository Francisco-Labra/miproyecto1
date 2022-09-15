
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.geom.Area;
import java.awt.geom.Ellipse2D;
import javax.swing.ImageIcon;


public class Personaje {
    //objeto de la clase juego
    Juego jueguito;
    //variables que nos ayudan a saber si el personaje salta o no
    static boolean saltando=false;
    boolean sube=false;
    boolean baja=false;
    //variables que delimitan el area del objeto
    Area llantaDelantera,llantaTrasera,carroceria,carro;
    //variables de tamaño del personaje
    int anchoPersonaje=112;
    int altoPersonaje=78;
    //coordenadas iniciales de personaje
    static int x_inicial=50;
    static int y_inicial=270;
    //coordenadoas para manipular el personaje
    int x_auxiliar=0;
    int y_auxiliar=0;
    
    public Personaje(Juego jueguito){
        this.jueguito=jueguito;
    }
    
    public void mover(){
        if(x_inicial+x_auxiliar>0 && x_inicial+x_auxiliar<jueguito.getWidth()-anchoPersonaje){
            x_inicial+=x_auxiliar;
        }
        if(saltando){
            if(y_inicial==270){
                sube=true;
                y_auxiliar=-2;
                baja=false;
            }
            if(y_inicial==150){
                baja=true;
                y_auxiliar=2;
                sube=false;
            }
            if(sube){
                y_inicial+=y_auxiliar;
            }
            if(baja){
                y_inicial+=y_auxiliar;
                if(y_inicial==270){
                    saltando=false;
                }
            }
        }
    }
    
    public void paint(Graphics2D g){
        ImageIcon auto=new ImageIcon(getClass().getResource("/multimedia/personaje1.gif"));
        g.drawImage(auto.getImage(), x_inicial,y_inicial,anchoPersonaje,altoPersonaje, null);
    }
    
    public void keyPressed(KeyEvent e){
        if(e.getKeyCode()==KeyEvent.VK_SPACE){
            saltando=true;
        }
    }
    
    public Area getBounds(){
        Rectangle forma1=new Rectangle(x_inicial,y_inicial,95,62);
        carroceria=new Area(forma1);
        
        Ellipse2D forma2=new Ellipse2D.Double(x_inicial,y_inicial+28,48,48);
        llantaTrasera=new Area(forma2);
        
        Ellipse2D forma3=new Ellipse2D.Double(x_inicial,y_inicial+28,48,48);
        llantaDelantera=new Area(forma3);
        
        carro=carroceria;
        carro.add(carroceria);
        carro.add(llantaTrasera);
        carro.add(llantaDelantera);
        
        return carro;
    }
}
