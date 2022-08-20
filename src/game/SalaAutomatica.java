package game;

import modelo.Inimigo;
import modelo.Personagem;
import visao.TelaGame;

import javax.swing.*;
import java.net.URL;
import java.util.Random;

public class SalaAutomatica extends Sala{

    public SalaAutomatica(Component c1, Component c2, String nome, Inimigo ini) {
        super(c1, c2, nome, ini);
    }


    @Override
    public void selecionarCaminho(Personagem p){
        System.out.println("Personagem " + p.getNome() + " entrou na sala " + getNome() + " com life " + p.getLife() + ", e encontrou o inimigo " + getInimigo().getNome());

        int x = 800;
        int y = 800;

        JFrame frame = new JFrame("Labirinto+");

        TelaGame tela = new TelaGame(p, getInimigo(), getNome());
        URL imageUrl = ClassLoader.getSystemResource("campoOFCAu.jpg");
        JLabel label = new JLabel(new ImageIcon(imageUrl));

        label.setBounds(0, 0, x, y);

        tela.setLayout(null);
        tela.add(label);

        frame.add(tela);
        frame.setSize(x, y);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        p = tela.getJog();

        lutar(p);

        while ((getInimigo().getLife()>0) && (p.getLife()>0)) { // enquanto está ocorrendo a luta
            p.show();
            tela.repaint();
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            if(p.getLife() <= 0){
                frame.dispose();
                frame = new JFrame("Labirinto+");

                imageUrl = ClassLoader.getSystemResource("Lose.png");
                label = new JLabel(new ImageIcon(imageUrl));

                frame.add(label);
                frame.setLocationRelativeTo(null);
                frame.setSize(400,300);
                frame.setVisible(true);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            }
            if(getInimigo().getLife() <= 0){
                JOptionPane.showMessageDialog(null, "Parabéns, você matou o inimigo!");
                // Isso aqui só acontece apos a luta terminar
                double valor = Math.random();

                if (valor < 0.5) {
                    System.out.println("Personagem " + p.getNome() + " pegou caminho 1");
                    frame.dispose();
                    getCaminho1().selecionarCaminho(p);
                }
                else {
                    System.out.println("Personagem " + p.getNome() + " pegou caminho 2");
                    frame.dispose();
                    getCaminho2().selecionarCaminho(p);
                }
            }
        }

    }
    @Override
    public void lutar(Personagem p) {

        Random n = new Random();
        int dano = n.nextInt((10 - 1) + 1) + 1;

        getInimigo().getA().setDano(dano);

    }



}

