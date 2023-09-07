package com.br.hotel.alura.grafico;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.time.LocalDate;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;


public class TelaMenuUsuario extends BaseScreen {
    
    private static int screenWidth = 900;
    private static int screenHeight = 600;

    private JLabel logo = JChallegensKeys.criarImagem(this.getClass().getClassLoader().getResource("imagens/Ha-100px.png"), (int) (screenWidth * 0.15 - 85) , 70, 170, 170);

    public TelaMenuUsuario(){
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

        jpanel.add(panelwhiteblue());
        jpanel.add(panelWhite());
        jpanel.add(panelblue());

        return jpanel;
    }
    
    private JPanel panelWhite(){
        JPanel panel = new JPanel();
        panel.setBounds((int) (screenWidth * 0.3), 0, (int) (screenWidth * 0.7), screenHeight);
        panel.setBackground(new Color(255, 255, 255, 255));
        panel.setLayout(null);

        JTextArea hotelText = JChallegensKeys.createText("Bem-vindo",  30, 180, new Font("Roboto", Font.BOLD, 25), Color.black);

        String descricao = """
            <html><body>
            <p>
            Sistema de reservas de hotéis. Controle e gerencie de foram otimizada e fácil o fluxo de reservas e hóspedes do hotel<br><br>
            
            Esta ferramenta permitirá que você mantenha um controle completo e detalhado de suas reservas e hóspedes, você terá acesso a ferramentas especiasi para tarefas específicas como:
            <br><br></p>
            <ul>
              <li>Registro de reservas e Hóspedes</li><br>
              <li>Edição de Reservas e Hóspedes existentes</li><br>
              <li>Excluir todos os tipos de registros</li>
            </ul>
            </body></html>
                """;

        JLabel descricaoText = JChallegensKeys.createTextJLabel(descricao,  30, 240, (int) (screenWidth * 0.6), 260, new Font("Roboto", Font.PLAIN, 15), Color.gray);

        panel.add(hotelText);
        panel.add(descricaoText);
        return panel;
    }

    private JPanel panelblue(){
        JPanel panel = new JPanel();
        panel.setBounds(0, 0, (int) (screenWidth * 0.3), screenHeight);
        panel.setBackground(new Color(12, 138, 199, 255));
        panel.setLayout(null);

        logo.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.white));

        panel.add(logo);

        JButton reservas = JChallegensKeys.createImageButton(this.getClass().getClassLoader().getResource("imagens/icon-reservas.png"), 0, 280, 30, 30);
        reservas.setText("Registro de reservas");
        reservas.setBounds(reservas.getX(), reservas.getY(), 220, reservas.getHeight());
        reservas.addMouseListener((MouseListener) new MouseAdapter() {
            public void mouseClicked(MouseEvent var1){
                new TelaReserva().start(); 
                dispose();
            }
        });

        JButton busca = JChallegensKeys.createImageButton(this.getClass().getClassLoader().getResource("imagens/icon-buscar.png"), -45, 340, 30, 30);
        busca.setText("Buscar");
        busca.setBounds(busca.getX(), busca.getY(), 220, busca.getHeight());
        busca.addMouseListener((MouseListener) new MouseAdapter(){
            public void mouseClicked(MouseEvent var1){
                new TelaBusca().start();
                dispose();
            }
        });

        panel.add(reservas);
        panel.add(busca);

        return panel;
    }

    private JPanel panelwhiteblue(){
        JPanel panel = new JPanel();
        panel.setBounds((int) (screenWidth * 0.3), 50, (int) (screenWidth * 0.7), 120);
        panel.setBackground(new Color(118, 186, 222, 255));
        panel.setLayout(null);

        panel.add(JChallegensKeys.createText("Sistema de reserva do Hotel Alura",  (int) (screenWidth * 0.35 - 170), 5, new Font("Roboto", Font.BOLD, 20), Color.white));
        panel.add(JChallegensKeys.createText("Hoje é " + LocalDate.now(),  30, 50, new Font("Roboto", Font.PLAIN, 30), Color.white));
        
        return panel;
    }

}