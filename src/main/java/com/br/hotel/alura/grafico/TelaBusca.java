package com.br.hotel.alura.grafico;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.time.format.DateTimeFormatter;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import com.br.hotel.alura.bancoDados.GenericAluraDAO;
import com.br.hotel.alura.bancoDados.Hospede;
import com.br.hotel.alura.bancoDados.Reserva;
import com.br.hotel.alura.bancoDados.GenericAluraDAO.BandoDados;

public class TelaBusca extends BaseScreen {

    private static int screenWidth = 900;
    private static int screenHeight = 600;

    private JTable reservaJtable = new JTable();
    private JTable HospedeJtable = new JTable();

    JScrollPane scrollReserva = new JScrollPane(reservaJtable);
    JScrollPane scrollhospede = new JScrollPane(HospedeJtable);

    private GenericAluraDAO entity = new GenericAluraDAO();

    private DefaultTableModel hospede = JChallegensKeys.addListTable(HospedeJtable, new String[] {"Numero de Hóspede","Nome","Sobrenome","Data de Nascimento","Nacionalidade","Telefone","Numero de Reserva"});
    private DefaultTableModel reserva = JChallegensKeys.addListTable(reservaJtable, new String[] {"Numero de Reserva","Data de entrada","Data de saida","Valor a ser pago","Forma de pagamento"});
    
    public TelaBusca(){
        super("Hotel Alura - buscas", screenWidth, screenHeight);
        add(exitButton());
    }

    public void start(){
        setPanel(screenElements());
        setVisible(true);
    }

    private JPanel screenElements(){
        JPanel jpanel = new JPanel();
        jpanel.setBounds(0, 0, screenWidth, screenHeight);
        jpanel.setBackground(Color.white);
        jpanel.setBorder(null);
		jpanel.setLayout(null);
        jpanel.add(JChallegensKeys.backButton(screenWidth, new TelaMenuUsuario(), this));

        printReserva();
        printHospede();

        JTabbedPane pane = new JTabbedPane(JTabbedPane.TOP);
        pane.setBounds(25, 125, 825, 400);
        pane.setBackground(new Color(12, 138, 199));
        pane.addTab("Reserva", new ImageIcon(TelaBusca.class.getResource("/imagens/icon-reservas.png")), scrollReserva,null);
        pane.addTab("Hóspede", new ImageIcon(TelaBusca.class.getResource("/imagens/icon-buscar.png")), scrollhospede, null);
        
        jpanel.add(JChallegensKeys.criarImagem(this.getClass().getClassLoader().getResource("imagens/Ha-100px.png"), 50, 20, 100, 100));
        JTextArea textoSistema = JChallegensKeys.createText("SISTEMA DE BUSCA", screenWidth/2-100, 50, new Font("Arial", Font.BOLD, 24), new Color(12,138,199,255));
        jpanel.add(textoSistema);

        JTextField inputBuscar = JChallegensKeys.createInput(null, 570, 110, 150, 30);
        jpanel.add(inputBuscar);
        
        JPanel buttonBuscar = JChallegensKeys.createButton("BUSCAR", 730, 110, 120, 30);
        buttonBuscar.addMouseListener(new MouseAdapter() { 
			@Override
			public void mouseClicked(MouseEvent var1) {
                if (pane.getSelectedIndex() == 0){
                    clearTableReserva();
                    for (Reserva GenericAluraDAO : new GenericAluraDAO().printReserva(inputBuscar.getText())) {
                        reserva.addRow(new Object[]{GenericAluraDAO.getId(),GenericAluraDAO.getDataEntrada(),GenericAluraDAO.getDataSaida(), GenericAluraDAO.getValor(), GenericAluraDAO.getFormaPagamento()});
                    }
                    if(inputBuscar.getText().isEmpty()){
                        clearTableReserva();
                        printReserva();
                    }
                } else {
                    clearTableHospede();
                    for (Hospede GenericAluraDAO : new GenericAluraDAO().printHospede(inputBuscar.getText())) {
                        hospede.addRow(new Object[]{GenericAluraDAO.getId(),GenericAluraDAO.getNome(),GenericAluraDAO.getSobreNome(), GenericAluraDAO.getDataNascimento(), GenericAluraDAO.getNacionalidade(), GenericAluraDAO.getTelefone(), GenericAluraDAO.getReserva().getId()});
                    }
                    if(inputBuscar.getText().isEmpty()){
                        clearTableHospede();
                        printHospede();
                    }
                }
			}});
        
        JPanel buttonEditar = JChallegensKeys.createButton("EDITAR", 595, 550, 120, 30);
        buttonEditar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent var1) {
                try {
                    if (pane.getSelectedIndex() == 0){
                        Reserva r = entity.findReservaById(reserva.getValueAt(reservaJtable.getSelectedRow(), 0).toString());
                        dispose();
                        new TelaEditarReserva(r).start();
                    } else {
                        Hospede h = entity.findHospedeById(hospede.getValueAt(HospedeJtable.getSelectedRow(), 0).toString());
                        dispose();
                        new TelaEditarHospede(h).start();
                    }
                } catch (Exception e) {}
            }});

        JPanel buttonDeletar = JChallegensKeys.createButton("DELETAR", 730, 550, 120, 30);
        buttonDeletar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent var1) {
                try {
                    if (pane.getSelectedIndex() == 0){
                    new GenericAluraDAO().delete(reserva.getValueAt(reservaJtable.getSelectedRow(), 0).toString(), BandoDados.RESERVA);
                } else {
                    entity.delete(( hospede.getValueAt(HospedeJtable.getSelectedRow(), 0).toString()), BandoDados.HOSPEDE);
                }
                } catch (Exception e) {
                    return;
                }
                dispose();
                new TelaAviso("Operação Concluida com sucesso", new TelaBusca()).start();
			}});

        jpanel.add(buttonBuscar);
        jpanel.add(buttonEditar);
        jpanel.add(buttonDeletar);
        jpanel.add(pane);

        return jpanel;
    }

    private void printHospede(){
        for (Hospede GenericAluraDAO : new GenericAluraDAO().printHospede()) {
            hospede.addRow(new Object[]{GenericAluraDAO.getId(),GenericAluraDAO.getNome(),GenericAluraDAO.getSobreNome(), GenericAluraDAO.getDataNascimento().format(DateTimeFormatter.ofPattern("dd / MM / yyyy")), GenericAluraDAO.getNacionalidade(), GenericAluraDAO.getTelefone(), GenericAluraDAO.getReserva().getId()});
        }
    }

    private void printReserva(){
        for (Reserva GenericAluraDAO : new GenericAluraDAO().printReserva()) {
            reserva.addRow(new Object[]{GenericAluraDAO.getId(),GenericAluraDAO.getDataEntrada().format(DateTimeFormatter.ofPattern("dd / MM / yyyy")),GenericAluraDAO.getDataSaida().format(DateTimeFormatter.ofPattern("dd / MM / yyyy")), GenericAluraDAO.getValor(), GenericAluraDAO.getFormaPagamento()});
        }
    }

    private void clearTableReserva(){
        for (int x = reserva.getRowCount() - 1; x >= 0; x--){
            reserva.removeRow(x);
        }
    }
    private void clearTableHospede(){
        for (int x = hospede.getRowCount() - 1; x >= 0; x--){
            hospede.removeRow(x);
        }
    }
}
