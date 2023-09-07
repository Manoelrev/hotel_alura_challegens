package com.br.hotel.alura.grafico;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Date;

import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.br.hotel.alura.bancoDados.GenericAluraDAO;
import com.br.hotel.alura.bancoDados.Hospede;
import com.br.hotel.alura.bancoDados.Reserva;
import com.toedter.calendar.JDateChooser;

public class TelaRegistroHospede extends BaseScreen {
  
    private static int screenWidth = 900;
    private static int screenHeight = 600;


    private Font font = new Font("Arial", Font.BOLD, 15);
    private Color blue = new Color(12,138,199,255);

    private Reserva reserva;
    private GenericAluraDAO entity = new GenericAluraDAO();
    private JPanel salvarbutton = JChallegensKeys.createButton("SALVAR",70, 510, 100, 30);
    private JTextField[] input = {JChallegensKeys.createInput(null, 70, 110,300,30), JChallegensKeys.createInput(null, 70, 170, 300,30), JChallegensKeys.createInput(null, 70, 390, 300,30), JChallegensKeys.createInput(null, 70, 465, 300,30)};
    private JDateChooser dateInput = JChallegensKeys.inputReservas(70, 240, 300, 40);
    private JComboBox<String> nacionalidadeInput = JChallegensKeys.createComboBox(70, 320, 300, 40,new String[] {"alemão", "andorrano", "angolano", "antiguano", "saudita", "argelino", "argentino", "armênio", "australiano", "austríaco", "azerbaijano", "bahamense", "bangladês, bangladense", "barbadiano", "bahreinita", "belga", "belizenho", "beninês", "belarusso", "boliviano", "bósnio", "botsuanês", "brasileiro", "bruneíno", "búlgaro", "burkineonse, burkinabé", "burundês", "butanês", "cabo-verdiano", "camerounês", "cambojano", "catariano", "canadense", "cazaque", "chadiano", "chileno", "chinês", "cipriota", "colombiano", "comoriano", "congolês", "congolês", "sul-coreano", "norte-coreano", "costa-marfinense, marfinense", "costa-ricense", "croata", "cubano", "dinamarquês", "djiboutiano", "dominiquense", "egípcio", "salvadorenho", "emiradense, emirático", "equatoriano", "eritreu", "eslovaco", "esloveno", "espanhol", "estadunidense, (norte-)americano", "estoniano", "etíope", "fijiano", "filipino", "finlandês", "francês", "gabonês", "gambiano", "ganês ou ganense", "georgiano", "granadino", "grego", "guatemalteco", "guianês", "guineense", "guineense, bissau-guineense", "equato-guineense", "haitiano", "hondurenho", "húngaro", "iemenita", "cookiano", "marshallês", "salomonense", "indiano", "indonésio", "iraniano", "iraquiano", "irlandês", "islandês", "34", "jamaicano", "japonês", "jordaniano", "kiribatiano", "kuwaitiano", "laosiano", "lesotiano", "letão", "libanês", "liberiano", "líbio", "liechtensteiniano", "lituano", "luxemburguês", "macedônio", "madagascarense", "malásio37", "malawiano", "maldivo", "maliano", "maltês", "marroquino", "mauriciano", "mauritano", "mexicano", "myanmarense", "micronésio", "moçambicano", "moldovo", "monegasco", "mongol", "montenegrino", "namibiano", "nauruano", "nepalês", "nicaraguense", "nigerino", "nigeriano", "niuiano", "norueguês", "neozelandês", "omani", "neerlandês", "palauano", "palestino", "panamenho", "papua, papuásio", "paquistanês", "paraguaio", "peruano", "polonês, polaco", "português", "queniano", "quirguiz", "britânico", "centro-africano", "tcheco", "dominicano", "romeno", "ruandês", "russo", "samoano", "santa-lucense", "são-cristovense", "samarinês", "santomense", "são-vicentino", "seichelense", "senegalês", "sérvio", "singapurense", "sírio", "somaliano, somali", "sri-lankês", "suázi", "sudanês", "sul-sudanês", "sueco", "suíço", "surinamês", "tajique", "tailandês", "tanzaniano", "timorense", "togolês", "tonganês", "trinitário", "tunisiano", "turcomeno", "turco", "tuvaluano", "ucraniano", "ugandês", "uruguaio", "uzbeque", "vanuatuense", "vaticano", "venezuelano", "vietnamita", "zambiano", "zimbabueano"});

    public TelaRegistroHospede(Reserva reserva){
        super("Hotel Alura - registro hóspede", screenWidth, screenHeight);
        add(exitButton());
        this.reserva = reserva;
    }

    public void start(){
        entity.create(reserva);
        setPanel(screenElements());
        setVisible(true);
    }

    private JPanel screenElements(){
        JPanel jpanel = new JPanel();
        jpanel.setBounds(0, 0, screenWidth, screenHeight);
        jpanel.setBorder(null);
		jpanel.setLayout(null);

        JPanel back = JChallegensKeys.backButton(screenWidth, new TelaReserva(), this);
        back.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
                entity.delete(reserva);
                dispose();
			}
		});

        add(back);
        jpanel.add(panelWhite());
        jpanel.add(panelblue());

        return jpanel;
    }
    
    private JPanel panelWhite(){
        JPanel panel = new JPanel();
        panel.setBounds((int) (screenWidth * 0.5), 0, (int) (screenWidth * 0.5), screenHeight);
        panel.setBackground(new Color(255, 255, 255, 255));
        panel.setLayout(null);

        salvarbutton.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent var1){
                if(input[0].getText().isBlank() || input[1].getText().isBlank() || input[2].getText().isBlank())
                {
                new TelaAviso("Ocorreu um erro na criação da reserva", null).start();
                return;
                }
                new TelaAviso("Reserva criada com sucesso", new TelaMenuUsuario()).start();

                entity.create(new Hospede(
                    input[0].getText(), 
                    input[1].getText(), 
                    dateInput.getDate(), 
                    nacionalidadeInput.getSelectedItem().toString(), 
                    input[2].getText(),
                    reserva));
                dispose();
            }
			}
		);

        panel.add(JChallegensKeys.createText("REGISTRO HÓSPEDE", panel.getWidth()/2 - 105, 30, new Font("Arial", Font.BOLD, 20), blue));

        panel.add(JChallegensKeys.createText("NOME", 70, 90,font,Color.darkGray));
        panel.add(input[0]);

        panel.add(JChallegensKeys.createText("SOBRENOME", 70, 150,font,Color.darkGray));
        panel.add(input[1]);

        panel.add(JChallegensKeys.createText("DATA DE NASCIMENTO", 70, 210,font,Color.darkGray));
        dateInput.setMaxSelectableDate(new Date());
        panel.add(dateInput);

        panel.add(JChallegensKeys.createText("NACIONALIDADE", 70, 290,font,Color.darkGray));
        panel.add(nacionalidadeInput);
        
        panel.add(JChallegensKeys.createText("TELEFONE", 70, 370,font,Color.darkGray));
        panel.add(input[2]);

        panel.add(JChallegensKeys.createText("NUMERO DE RESERVA", 70, 440,font,Color.darkGray));
        input[3].setText(reserva.getId().toString());
        input[3].setBackground(Color.white);
        input[3].setEditable(false);
        panel.add(input[3]);

        panel.add(salvarbutton);

        return panel;
    }

    private JPanel panelblue(){
        JPanel panel = new JPanel();
        panel.setBounds(0, 0, (int) (screenWidth * 0.5), screenHeight);
        panel.setBackground(new Color(12, 138, 199, 255));
        panel.setLayout(null);
        panel.add(
        JChallegensKeys.criarImagem(this.getClass().getClassLoader().getResource("imagens/Ha-100px.png"), panel.getWidth()/2-50, 50, 100, 100));
         panel.add(
        JChallegensKeys.criarImagem(this.getClass().getClassLoader().getResource("imagens/registro.png"), 35, 140,  panel.getWidth()-70,  panel.getHeight()-200));
        
        return panel;
    }

}
