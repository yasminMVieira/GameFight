package game;

import modelo.Personagem;

import javax.swing.*;
import java.net.URL;

public class Abismo implements Component{


    @Override
    public void lutar(Personagem p) {

    }

    @Override
    public void selecionarCaminho(Personagem p) {

        JFrame frame = new JFrame("Labirinto+");

        URL imageUrl = ClassLoader.getSystemResource("Lose.png");
        JLabel label = new JLabel(new ImageIcon(imageUrl));

        frame.add(label);
        frame.setLocationRelativeTo(null);
        frame.setSize(400,300);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        p.setLife(0);
        System.out.println("Abismo encontrado. game.Game over. modelo.Personagem " + p.getNome() + " morreu...");


    }


}
