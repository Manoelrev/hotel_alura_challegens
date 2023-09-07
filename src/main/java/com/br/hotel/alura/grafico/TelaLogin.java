package com.br.hotel.alura.grafico;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;


public class TelaLogin extends BaseScreen {
    
    private static int screenWidth = 700;
    private static int screenHeight = 500;


    private JTextField usuarioInput = JChallegensKeys.createInput("Insira o nome do usuario", 40, 190,300,30);
    private JPasswordField senhaInput = JChallegensKeys.createInputPassword("********", 40, 310,300,30);
    private JPanel buttonConfirm = JChallegensKeys.createButton("ENTRAR",40, 380, 120, 40);

    public TelaLogin(){
        super("Hotel Alura - login", screenWidth, screenHeight);
        add(exitButton());
    }

    public void start(){
        setPanel(screenElements());
        setVisible(true);
    }

    private JPanel screenElements(){
        JPanel jpanel = new JPanel();
        jpanel.setBounds(0, 0, screenWidth, screenHeight);
        jpanel.setBorder(null);
		jpanel.setLayout(null);

        usuarioInput.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {if (usuarioInput.getText().equals("Insira o nome do usuario")) {usuarioInput.setText("");}}});
        senhaInput.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {if (String.valueOf(senhaInput.getPassword()).equals("********")) {senhaInput.setText("");}}});
        buttonConfirm.addMouseListener(new MouseAdapter() {
            @Override
			public void mouseClicked(MouseEvent var1) {
                if(usuarioInput.getText().equals("admin") && (String.valueOf(senhaInput.getPassword()).equals("admin"))){
                    new TelaAviso("Login Concluido com sucesso", new TelaMenuUsuario()).start();
                    dispose();
                } else { 
                    new TelaAviso("Erro: Usuario ou senha estão incorretos", null).start();
                }
			}});
        
        jpanel.add(panelWhite());
        jpanel.add(panelblue());

        return jpanel;
    }
    
    private JPanel panelWhite(){
        JPanel panel = new JPanel();
        panel.setBounds(0, 0, (int) (screenWidth * 0.6), screenHeight);
        panel.setLayout(null);
        panel.setBackground(Color.WHITE);

        panel.add(JChallegensKeys.criarImagem(this.getClass().getClassLoader().getResource("imagens/Ha-100px.png"), 30, 30, 100,100));
        panel.add(JChallegensKeys.createText("LOGIN", 180, 80,new Font("Roboto", Font.BOLD, 25), new Color(8,136,198,255)));
        panel.add(JChallegensKeys.createText("USUARIO", 40, 130,new Font("Roboto", Font.BOLD, 25), new Color(8,136,198,255)));
        panel.add(usuarioInput);
        panel.add(JChallegensKeys.createText("SENHA", 40, 250,new Font("arial", Font.BOLD, 20), new Color(8,136,198,255)));
        panel.add(senhaInput);

        add(buttonConfirm);

        return panel;
    }

    private JPanel panelblue(){
        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBounds((int) (screenWidth * 0.6), 0, (int) (screenWidth * 0.4), screenHeight);
        panel.setBackground(new Color(12,138,199,255));
        
        panel.add(JChallegensKeys.criarImagem(this.getClass().getClassLoader().getResource("imagens/img-hotel-login-.png"), -20, -50, 300,500));

        return panel;
    }

}