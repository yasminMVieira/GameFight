package visao;

import factory.AdvancedGame;
import factory.SimpleGame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;


public class TelaInicio extends JFrame {
    private JButton jButton1;
    private JButton jButton3;
    private JPanel jPanel1;

    public TelaInicio() {
        initComponents();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) throws InterruptedException {//GEN-FIRST:event_jButton1ActionPerformed
        Object[] options = { "Medieval", "Futurista" };
        int resposta = JOptionPane.showOptionDialog(null, "Escolha um modo de jogo", "Modo",
                JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE,
                null, options, options[0]);

        if(resposta == 0){
            System.out.println("medieval selected");
            SimpleGame medieval = SimpleGame.getInstance();
            medieval.jogar();
        }else{
            AdvancedGame futuro = AdvancedGame.getInstance();
            futuro.jogar();
        }
        this.dispose();
    }

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        System.exit(0);
    }

    private void initComponents() {

        jPanel1 = new JPanel();
        jButton1 = new JButton();
        jButton3 = new JButton();

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        //jPanel1.setBackground(new Color(1, 1, 1));
        URL imageUrl = ClassLoader.getSystemResource("ini.png");
        JLabel jPanel1 = new JLabel(new ImageIcon(imageUrl));

        jPanel1.setBorder(BorderFactory.createLineBorder(new Color(254, 254, 254), 3));

        jButton1.setBackground(new Color(0, 0, 0));
        jButton1.setFont(new Font("Ubuntu Mono", 1, 18)); // NOI18N
        jButton1.setForeground(new Color(255, 254, 254));
        jButton1.setText("Jogar");
        jButton1.setAutoscrolls(true);
        jButton1.setBorder(BorderFactory.createLineBorder(new Color(254, 254, 254), 3));
        jButton1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                try {
                    jButton1ActionPerformed(evt);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        jButton3.setBackground(new Color(1, 1, 1));
        jButton3.setFont(new Font("Ubuntu Mono", 1, 18)); // NOI18N
        jButton3.setForeground(new Color(254, 254, 254));
        jButton3.setText("Sair");
        jButton3.setAutoscrolls(true);
        jButton3.setBorder(BorderFactory.createLineBorder(new Color(254, 254, 254), 3));
        jButton3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        GroupLayout jPanel1Layout = new GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setAutoCreateGaps(true);
        jPanel1Layout.setAutoCreateContainerGaps(true);

        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton1)
                        .addComponent(jButton3)
                        .addContainerGap(0,480)
        );

        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup()
                                .addComponent(jButton1)
                                .addComponent(jButton3)
                        )
        );

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createSequentialGroup()
                        .addComponent(jPanel1)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup()
                        .addComponent(jPanel1)
        );

        pack();

    }
}



