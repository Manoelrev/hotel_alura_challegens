package com.br.hotel.alura.grafico;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.URL;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

import javax.swing.BorderFactory;
import javax.swing.GrayFilter;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import com.toedter.calendar.JDateChooser;

public class JChallegensKeys {
    
    public static JTextArea createText(String text, int x, int y, Font fonte, Color cor){
        JTextArea createText = new JTextArea(text);
        createText.setFont(fonte);
        createText.setBounds(x, y, createText.getText().length() * 20, fonte.getSize() * 2);
        createText.setForeground(cor);

        createText.setBackground(null);
        createText.setEditable(false);

        createText.setLineWrap(true);
        createText.setWrapStyleWord(true);
        createText.setFocusable(false);

        return createText;
    }

    public static JLabel createTextJLabel(String text, int x, int y, int width, int height, Font fonte, Color cor){
        JLabel createText = new JLabel(text);
        createText.setFont(fonte);
        createText.setBounds(x, y, width, height);
        createText.setForeground(cor);

        createText.setBackground(null);

        return createText;
    }

    public static JPanel createButton( String text, int x, int y, int width, int height){
        JPanel createButton = new JPanel();

        createButton.setBackground(new Color(12,138,199,255));
        createButton.setBounds(x, y, width, height);

        JLabel createText = new JLabel(text);
        createText.setFont(new Font("Roboto", Font.PLAIN, 16));
        createText.setForeground(Color.white);
        createText.setBounds(0, 0, width, height);
        createButton.add(createText, BorderLayout.CENTER);

        createButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent var1) {createButton.setBackground(new Color(125 ,125 ,125, 255));}
			@Override
			public void mouseExited(MouseEvent e) {createButton.setBackground(new Color(12,138,199,255));}
			@Override
			public void mouseClicked(MouseEvent var1) {
			}}
		);

        return createButton;
    }

    public static JButton createImageButton(URL url, int x, int y, int width, int height){
        JButton jbutton = new JButton(new ImageIcon(new ImageIcon(url).getImage().getScaledInstance(width, height, java.awt.Image.SCALE_SMOOTH)));
        jbutton.setBorderPainted(false);
        jbutton.setFocusPainted(false);
        jbutton.setContentAreaFilled(false);
        jbutton.setOpaque(false);
        jbutton.setFocusable(false);
        jbutton.setRolloverIcon(new ImageIcon(GrayFilter.createDisabledImage(new ImageIcon(url).getImage().getScaledInstance(width, height, java.awt.Image.SCALE_SMOOTH))));
        jbutton.setHorizontalTextPosition(SwingConstants.RIGHT);
        jbutton.setFont(new Font("Roboto", Font.PLAIN, 15));
        jbutton.setForeground(Color.white);
        jbutton.setBounds(x,y,width,height);
        return jbutton;
    }

    public static JLabel criarImagem(URL url, int x, int y, int width, int height){
        Image dimg = new ImageIcon(url).getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH);
        JLabel imgLabel = new JLabel(new ImageIcon(dimg));
        
        imgLabel.setBounds(x,y,width,height);
        return imgLabel;
    }

    public static JTextField createInput(String text, int x, int y, int width, int height){
        JTextField jTextField = new JTextField(text);
        jTextField.setBounds(x, y, width, height); 
        jTextField.setFont(new Font("Roboto", Font.BOLD, 20));
        jTextField.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, new Color(8,136,198,255)));
        jTextField.setForeground(Color.gray);
        return jTextField;
    }

    public static JPasswordField createInputPassword(String text, int x, int y, int width, int height){
        JPasswordField jPasswordField = new JPasswordField(text);
        jPasswordField.setBounds(x, y, width, height); 
        jPasswordField.setFont(new Font("Roboto", Font.BOLD, 20));
        jPasswordField.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, new Color(8,136,198,255)));
        jPasswordField.setForeground(Color.gray);
        return jPasswordField;
    }

    public static JDateChooser inputReservas(int x, int y, int width, int height){
        JDateChooser test = new JDateChooser();

        test.setBounds(x,y,width,height);
        test.setDate(new Date());
        test.setDateFormatString("dd / MM / yyyy");
        test.getCalendarButton().setFont(new Font("Roboto", Font.BOLD, 20));
        test.getCalendarButton().setBounds(x+width, 0, 60, height + 10);
        test.getCalendarButton().setIcon(new ImageIcon(JChallegensKeys.class.getResource("/imagens/icon-reservas.png")));
        test.getCalendarButton().setBackground(new Color(12,138,199,255));
        test.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, new Color(12,138,199,255)));
        return test;
    }

    public static LocalDateTime converterData(Date data){
        return data.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
    }

    public static JComboBox<String> createComboBox(int x, int y, int width, int height, String[] opcoes){
        JComboBox<String> teste = new JComboBox<>(opcoes);
        teste.setBounds(x, y, width, height);
        teste.setBackground(Color.white);
        teste.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, new Color(12,138,199,255)));

        return teste;
    }

    public static DefaultTableModel addListTable(JTable jtable, String[] colunas){
        
        DefaultTableModel  defaultTableModel = new DefaultTableModel(){
            @Override
            public boolean isCellEditable(int row, int column) {
               //all cells false
               return false;
            }};
		jtable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		jtable.setFont(new Font("Roboto", Font.PLAIN, 16));
		jtable.setModel(defaultTableModel);
        for(int x = 0; x < colunas.length; x++){
            defaultTableModel.addColumn(colunas[x]);
        }

        return defaultTableModel;
    }

    public static JPanel backButton(int width, BaseScreen novaJanela, BaseScreen janelaAtual){
		JPanel jpanel = new JPanel();
		jpanel.setBounds(10, 0, 30, 30);
		jpanel.setOpaque(false);
		JLabel text = new JLabel("<");
		jpanel.setBackground(new Color(0, 0, 0, 0));
		text.setForeground(Color.BLACK);
		text.setFont(new Font("Arial", Font.PLAIN, 25));
		jpanel.add(text);

		jpanel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e){
				text.setForeground(Color.GRAY);
			}
			@Override
			public void mouseExited(MouseEvent e){
				text.setForeground(Color.BLACK);
			}
			@Override
			public void mousePressed(MouseEvent e) {
				novaJanela.start();
                janelaAtual.dispose();
			}
		});

		return jpanel;
	}
}