package com.br.hotel.alura.grafico;

import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;


public abstract class BaseScreen extends JFrame {

    private int xMouse = 0;
    private int yMouse = 0;
	private int width;

    private JPanel panel = new JPanel();
    private JPanel contentPane = new JPanel();

    public BaseScreen(String name, int width, int height){
        super(name);

		this.width = width;
		setIconImage(Toolkit.getDefaultToolkit().getImage(BaseScreen.class.getResource("/imagens/Ha-100px.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, width, height);
		setResizable(false);

		contentPane.setBackground(SystemColor.control);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		setResizable(false);
		setLocationRelativeTo(null);
		setUndecorated(true);

        addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
				headerMouseDragged(e);
			     
			}
		});
		addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				headerMousePressed(e);
			}
		});
    }
    
    public abstract void start();

	protected JPanel exitButton(){
		JPanel jpanel = new JPanel();
		jpanel.setBounds(width - 40, 0, 30, 30);
		jpanel.setOpaque(false);
		JLabel text = new JLabel("X");
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
				System.exit(0);
			}
		});

		return jpanel;
	}

    public void setPanel(JPanel panel) {
        this.panel = panel;
		contentPane.add(this.panel);
    }

    private void headerMousePressed(MouseEvent evt) {
        xMouse = evt.getX();
        yMouse = evt.getY();
    }

    private void headerMouseDragged(MouseEvent evt) {
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();
        this.setLocation(x - xMouse, y - yMouse);
	}
}

