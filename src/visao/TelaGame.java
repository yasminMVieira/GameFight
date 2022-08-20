package visao;

import controle.*;
import modelo.Inimigo;
import modelo.Personagem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class TelaGame extends JPanel {

    public Inimigo ini;
    public Personagem j1;
    public Controle c;
    public String s;

    public TelaGame(Personagem p1, Inimigo ini1, String sala) { //sera q precisa de parametro?
        KeyListener listener = new MyKeyListener();
        addKeyListener(listener);
        setFocusable(true); //So that the JPanel object receives the keyboard notifications it is necessary to include the instruction setFocusable(true), which allows KeyboardExample to receive the focus.

        ini = ini1;
        j1 = p1;
        s = sala;

        c = new Controle();
        c.setCommand(new MoverEsq(j1),0);
        c.setCommand(new MoverDir(j1),1);
        c.setCommand(new MoverCima(j1),2);
        c.setCommand(new MoverBaixo(j1),3);
        c.setCommand(new Chutar(ini, j1),4);

        Macro m = new Macro();
        m.add(new MoverEsq(j1));
        m.add(new MoverEsq(j1));
        m.add(new MoverEsq(j1));
        m.add(new MoverEsq(j1));
        m.add(new MoverEsq(j1));
        m.add(new MoverEsq(j1));
        m.add(new Chutar(ini, j1));

        c.setCommand(m,5);

        j1.addObserver(ini);

    }

    public class MyKeyListener implements KeyListener {
        @Override
        public void keyTyped(KeyEvent e) {
        }

        @Override
        public void keyPressed(KeyEvent e) {
            //System.out.println("keyPressed="+KeyEvent.getKeyText(e.getKeyCode()));

            if (e.getKeyCode() == KeyEvent.VK_A){
                c.pressionar(0);
            }
            if (e.getKeyCode() == KeyEvent.VK_D)
                c.pressionar(1);

            if (e.getKeyCode() == KeyEvent.VK_W)
                c.pressionar(2);

            if (e.getKeyCode() == KeyEvent.VK_S)
                c.pressionar(3);

            if (e.getKeyCode() == KeyEvent.VK_SPACE)
                c.pressionar(4);

            if (e.getKeyCode() == KeyEvent.VK_ENTER)
                c.pressionar(5);

            if (e.getKeyCode() == KeyEvent.VK_R)
                c.replay();

        }

        @Override
        public void keyReleased(KeyEvent e) {
            //System.out.println("keyReleased="+KeyEvent.getKeyText(e.getKeyCode()));
        }
    }

    public void paint(Graphics g) {
        super.paint(g); //The call to "super.paint(g)", cleans the screen 

        Graphics2D g2d = (Graphics2D) g;
        //The instruction; "g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON)" makes the borders of the figures smoother

        //g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        g2d.setColor(Color.RED);
        paintInimigo(g2d);

        g2d.setColor(new Color(3, 110, 18));
        g2d.setFont(new Font("Arial",Font.BOLD, 18));
        g2d.drawString("Life personagem " + j1.getNome() + ": " + j1.getLife(), 50, 50);
        g2d.drawString("Life inimigo " + ini.getNome() + ": " + ini.getLife(), 50, 70);
        g2d.setColor(new Color(206, 19, 206));
        g2d.drawString("Sala atual: " + s, 300,100);


        //Paint personagem
        g2d.setColor(Color.RED);
        g2d.fillRect(j1.getX() -4, j1.getY() -16, 15,6 );
        g2d.fillRect(j1.getX() -7, j1.getY() -13, 27,3 );
        g2d.setColor(new Color(246, 235, 208));
        g2d.fillRect(j1.getX() -7, j1.getY() -7, 3,6 );
        g2d.fillRect(j1.getX() -1, j1.getY() -7, 9,3 );
        g2d.fillRect(j1.getX() +2, j1.getY() -10, 9,15 );
        g2d.fillRect(j1.getX() +8, j1.getY() -4, 3,3 );
        g2d.fillRect(j1.getX() -4, j1.getY() -1, 6,6 );
        g2d.fillRect(j1.getX() +8, j1.getY() +2, 6,3 );
        g2d.fillRect(j1.getX() +11, j1.getY() -10, 3,6 );
        g2d.fillRect(j1.getX() +14, j1.getY() -4, 3,3 );
        g2d.fillRect(j1.getX() -13, j1.getY() +14, 6,9 );
        g2d.fillRect(j1.getX() -7, j1.getY() +17, 3,3 );
        g2d.fillRect(j1.getX() +17, j1.getY() +14, 6,9 );
        g2d.fillRect(j1.getX() +14, j1.getY() +17, 3,3 );
        g2d.setColor(Color.black);
        g2d.fillRect(j1.getX() +8, j1.getY() -10, 3,6 );
        g2d.fillRect(j1.getX() +11, j1.getY() -4, 3,3 );
        g2d.fillRect(j1.getX() +8, j1.getY() -1, 9,3 );
        g2d.setColor(new Color(99, 54, 25));
        g2d.fillRect(j1.getX() -10, j1.getY() -7, 3,9 );
        g2d.fillRect(j1.getX() -7, j1.getY() -10, 9,3 );
        g2d.fillRect(j1.getX() -4, j1.getY() -7, 3,6 );
        g2d.fillRect(j1.getX() -7, j1.getY() -1, 3,3 );
        g2d.fillRect(j1.getX() -1, j1.getY() -4, 3,3 );
        g2d.setColor(Color.RED);
        g2d.fillRect(j1.getX() -7, j1.getY() +5, 6,9 );
        g2d.fillRect(j1.getX() -10, j1.getY() +8, 3,6 );
        g2d.fillRect(j1.getX() -13, j1.getY() +11, 3,3 );
        g2d.fillRect(j1.getX() -7, j1.getY() +14, 3,3 );
        g2d.fillRect(j1.getX() +2, j1.getY() +5, 6,6 );
        g2d.fillRect(j1.getX() +11, j1.getY() +8, 9,6 );
        g2d.fillRect(j1.getX() +14, j1.getY() +14, 3,3 );
        g2d.fillRect(j1.getX() +20, j1.getY() +11, 3,3 );
        g2d.setColor(Color.black);
        g2d.fillRect(j1.getX() -1, j1.getY() +5, 3,21 );
        g2d.fillRect(j1.getX() +8, j1.getY() +5, 3,21 );
        g2d.fillRect(j1.getX() -4, j1.getY() +14, 18,9 );
        g2d.fillRect(j1.getX() -7, j1.getY() +20, 9,6 );
        g2d.fillRect(j1.getX() +8, j1.getY() +20, 9,6 );
        g2d.fillRect(j1.getX() +2, j1.getY() +11, 6,3 );
        g2d.setColor(Color.blue);
        g2d.fillRect(j1.getX() -10, j1.getY() +26, 12,3 );
        g2d.fillRect(j1.getX() +8, j1.getY() +26, 12,3 );

    }

    private void paintInimigo(Graphics2D g2d) {
        g2d.fillRect(ini.getX() - 16, ini.getY() + 21, 3, 9);
        g2d.fillRect(ini.getX() - 13, ini.getY() + 18, 3, 6);
        g2d.fillRect(ini.getX() - 10, ini.getY() + 9, 3, 3);
        g2d.fillRect(ini.getX() - 10, ini.getY() + 15, 3, 15);
        g2d.fillRect(ini.getX() - 7, ini.getY() + 12, 3, 6);
        g2d.fillRect(ini.getX() - 7, ini.getY() + 21, 3, 6);
        g2d.fillRect(ini.getX() - 7, ini.getY() + 30, 6, 3);
        g2d.fillRect(ini.getX() - 4, ini.getY() + 15, 3, 12);
        g2d.fillRect(ini.getX() - 1, ini.getY() + 15, 3, 12);
        g2d.fillRect(ini.getX() + 2, ini.getY() + 15, 3, 12);
        g2d.fillRect(ini.getX() + 2, ini.getY() + 30, 6, 3);
        g2d.fillRect(ini.getX() + 5, ini.getY() + 12, 3, 6);
        g2d.fillRect(ini.getX() + 5, ini.getY() + 21, 3, 6);
        g2d.fillRect(ini.getX() + 8, ini.getY() + 9, 3, 3);
        g2d.fillRect(ini.getX() + 8, ini.getY() + 15, 3, 15);
        g2d.fillRect(ini.getX() + 11, ini.getY() + 18, 3, 6);
        g2d.fillRect(ini.getX() + 14, ini.getY() + 21, 3, 9);
    }

    public Personagem getJog(){
        return this.j1;
    }


}
