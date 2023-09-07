package com.br.hotel.alura.grafico;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.math.BigDecimal;
import java.time.Duration;
import java.util.Date;

import javax.swing.BorderFactory;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import com.br.hotel.alura.bancoDados.GenericAluraDAO;
import com.br.hotel.alura.bancoDados.Reserva;
import com.toedter.calendar.JDateChooser;

public class TelaEditarReserva extends BaseScreen {
    private static int screenWidth = 900;
    private static int screenHeight = 600;
    Reserva reserva;

    private Font roboto = new Font("Roboto", Font.BOLD, 20);
        
    private JDateChooser inputIn = JChallegensKeys.inputReservas(70, 155, 280, 40);
    private JDateChooser inputOut = JChallegensKeys.inputReservas(70, 245, 280, 40);
    private JTextArea    textoResultado = JChallegensKeys.createText(null, 70, 340, new Font("Arial", Font.BOLD, 18), Color.BLACK);
    private JPanel       buttonProximo = JChallegensKeys.createButton("PRÓXIMO", 250, 490, 120, 35);
    private JComboBox<String> formapagamento = JChallegensKeys.createComboBox(70, 430, 289, 40, new String[] {"Cartão de Crédito", "Cartão de Débito", "Dinheiro"});
    private Long valorResultado;

    public TelaEditarReserva(Reserva reserva){
        super("Hotel Alura - Editar reservas", screenWidth, screenHeight);
        add(exitButton());
        this.reserva = reserva;
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

        add(JChallegensKeys.backButton(screenWidth, new TelaMenuUsuario(), this));
        add(panelWhite());
        add(panelblue());

        return jpanel;
    }
    
    private JPanel panelWhite() {
        JPanel panel = new JPanel();
        panel.setBounds(0, 0, (int) (screenWidth * 0.5), screenHeight);
        panel.setBackground(new Color(255, 255, 255, 255));
        panel.setLayout(null);

        PropertyChangeListener calculoTeste = new PropertyChangeListener() {
            public void propertyChange(PropertyChangeEvent arg0) {
                valorResultado = Duration.between( JChallegensKeys.converterData(inputIn.getDate()), JChallegensKeys.converterData(inputOut.getDate()) ).toDays() * 20 + 20;
                textoResultado.setText("R$ " + Long.toString(valorResultado) + ",00");
            }
        };

        buttonProximo.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent var1) {
                if (textoResultado.getText().trim().isEmpty() || textoResultado.getText().trim().equals("0")) {
                    new TelaAviso("Ocorreu um erro na criação da reserva", null).start();
                    return;
                }
                new GenericAluraDAO().updateReserva(reserva, inputIn.getDate(), inputOut.getDate(), formapagamento.getSelectedItem().toString(), new BigDecimal(valorResultado));
                new TelaAviso("Alteração realizada com sucesso", new TelaBusca()).start();
                dispose();
            }
        });
        
        panel.add(JChallegensKeys.createText("EDITAR RESERVA", screenWidth / 4 - 90, 50, roboto.deriveFont(20), new Color(12,138,199,255)));
        panel.add(JChallegensKeys.createText("DATA DE CHECK IN", 70, 120, roboto, Color.BLACK));
        
        inputIn.addPropertyChangeListener(calculoTeste);
        inputIn.setMinSelectableDate(new Date());
        inputIn.addPropertyChangeListener(new PropertyChangeListener() {
            @Override
            public void propertyChange(PropertyChangeEvent arg0) {
                if (inputIn.getDate().compareTo(inputOut.getDate()) == 1) {
                    inputOut.setDate(inputIn.getDate());
                } 
                inputOut.setMinSelectableDate(inputIn.getDate());
            }
        });
        
        panel.add(inputIn);
        
        panel.add(JChallegensKeys.createText("DATA DE CHECK OUT", 70, 210, roboto, Color.BLACK));
        panel.add(JChallegensKeys.createText("VALOR DA RESERVA", 70, 300, roboto, Color.BLACK));
        
        inputOut.addPropertyChangeListener(calculoTeste);
        panel.add(inputOut);

        textoResultado.setBounds(70, 340, 289, 40);
        textoResultado.setBackground(null);
        textoResultado.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, new Color(12,138,199,255)));
        panel.add(textoResultado);

        panel.add(JChallegensKeys.createText("FORMA DE PAGAMENTO", 70, 390, roboto, Color.BLACK));
        panel.add(formapagamento);
        panel.add(buttonProximo);
        
        return panel;
    }

    private JPanel panelblue(){
        JPanel panel = new JPanel();
        panel.setBounds( screenWidth / 2, 0, screenWidth / 2, screenHeight);
        panel.setBackground(new Color(12, 138, 199, 255));
        panel.setLayout(null);

        panel.add(JChallegensKeys.criarImagem(this.getClass().getClassLoader().getResource("imagens/Ha-100px.png"), panel.getWidth()/2 - 50, 50, 100, 100));
        panel.add(JChallegensKeys.criarImagem(this.getClass().getClassLoader().getResource("imagens/reservas-img-3.png"), 0, 50,  panel.getWidth(),  panel.getHeight()-50));

        return panel;
    }

}
