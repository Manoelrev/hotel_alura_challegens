package com.br.hotel.alura.grafico;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class TelaAviso extends BaseScreen {

    private static int screenHeight = 250;
    private static int screenWidth = 350;
    private BaseScreen telaVoltar;
    private String texto;

    public TelaAviso(String texto, BaseScreen telaAtual) {
        super("Alura Hotel - Aviso", screenWidth, screenHeight);
        this.texto = texto;
        this.telaVoltar = telaAtual;
    }

    @Override
    public void start() {
        setPanel(screenElements());
        setVisible(true);
    }
    
    private JPanel screenElements(){
        JPanel jpanel = new JPanel();
        jpanel.setBounds(0, 0, screenWidth, screenHeight);
        jpanel.setBackground(Color.white);
        jpanel.setBorder(null);
		jpanel.setLayout(null);

        JLabel textoOut = new JLabel();
        textoOut.setText(texto);
        textoOut.setFont(new Font("Roboto", Font.BOLD, 15));
        textoOut.setForeground(new Color(12,138,199,255));
        textoOut.setBounds(0, 125, screenWidth, 30);
        textoOut.setHorizontalAlignment(JLabel.CENTER);
        
        JPanel botao = JChallegensKeys.createButton("Continuar", screenWidth/2-50, 175, 100, 30);
        botao.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent var1) {
                dispose();
                if(telaVoltar != null) {
                telaVoltar.start();
                }
			}}
		);

        jpanel.add(JChallegensKeys.criarImagem(TelaAviso.class.getResource("/imagens/Ha-100px.png"), 125, 25, 100, 100));
        jpanel.add(textoOut);
        jpanel.add(botao);
        return jpanel;
    }
    
}
