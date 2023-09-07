package com.br.hotel.alura.grafico;

import javax.swing.JButton;
import javax.swing.JPanel;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TelaInicial extends BaseScreen {
    
    private static int screenWidth = 1000;
    private static int screenHeight = 550;

    public TelaInicial(){
        super("Hotel Alura - Challegens", screenWidth, screenHeight);
        add(exitButton());
    }

    public void start(){
        setPanel(screenElements());
        setVisible(true);
    }

    private JPanel screenElements(){
        JPanel jpanel = new JPanel();
        jpanel.setBackground(Color.white);
        jpanel.setBounds(0, 0, screenWidth, screenHeight);
        jpanel.setBorder(null);
		jpanel.setLayout(null);
        
        JButton loginButton = JChallegensKeys.createImageButton(TelaInicial.class.getClassLoader().getResource("imagens/login.png"), 760, 270, 70, 70);
        loginButton.addActionListener( (ActionListener) new ActionListener() {public void actionPerformed(ActionEvent e) 
            {
                new TelaLogin().start(); 
                dispose();
            }
        }); 

        jpanel.add(JChallegensKeys.criarImagem(TelaInicial.class.getClassLoader().getResource("imagens/bar.png"), 0, 520, screenWidth, 30));
        jpanel.add(JChallegensKeys.criarImagem(TelaInicial.class.getClassLoader().getResource("imagens/menu-img.png"), 0, 0, 600, screenHeight));
        jpanel.add(JChallegensKeys.criarImagem(TelaInicial.class.getClassLoader().getResource("imagens/aH-150px.png"), 750, 70, 100, 100));
        
        jpanel.add(JChallegensKeys.createText("Login", 760, 200, new Font("Roboto", Font.BOLD, 30), new Color(8,136,198,255)));
        jpanel.add(loginButton);

        return jpanel;
    }

}