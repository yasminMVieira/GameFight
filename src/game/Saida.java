package game;

import modelo.Personagem;

import javax.swing.*;
import java.net.URL;

public class Saida implements Component{


    @Override
    public void lutar(Personagem p) {

    }

    @Override
    public void selecionarCaminho(Personagem p) {
        JFrame frame = new JFrame("Labirinto+");

        URL imageUrl = ClassLoader.getSystemResource("Win.png");
        JLabel label = new JLabel(new ImageIcon(imageUrl));

        frame.add(label);
        frame.setLocationRelativeTo(null);
        frame.setSize(400,300);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        p.setLife(0);

        System.out.println("Saída encontrada personagem " + p.getNome() + " venceu.");
    }

}
