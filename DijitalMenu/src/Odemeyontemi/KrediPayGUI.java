package Odemeyontemi;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import dbBaglantisi.MariaDBConnection;

import javax.swing.JTextPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JEditorPane;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JRadioButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.ButtonGroup;
import javax.swing.AbstractAction;
import javax.swing.Action;

public class KrediPayGUI extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private final ButtonGroup buttonGroup_1 = new ButtonGroup();
	MariaDBConnection conn = new  MariaDBConnection();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					KrediPayGUI frame = new KrediPayGUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public KrediPayGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 509, 378);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTextPane txtpnAdSoyad = new JTextPane();
		txtpnAdSoyad.setText("Ad Soyad/Mail ve \u015Eifre:");
		txtpnAdSoyad.setBounds(29, 62, 131, 24);
		contentPane.add(txtpnAdSoyad);
		
		JTextPane txtpnKartNumaras = new JTextPane();
		txtpnKartNumaras.setText("Kart Numaras\u0131:");
		txtpnKartNumaras.setBounds(29, 96, 131, 24);
		contentPane.add(txtpnKartNumaras);
		
		JTextPane txtpnCvv = new JTextPane();
		txtpnCvv.setText("CVV:");
		txtpnCvv.setBounds(29, 130, 131, 24);
		contentPane.add(txtpnCvv);
		
		JTextPane txtpnTarih = new JTextPane();
		txtpnTarih.setText("Tarih:");
		txtpnTarih.setBounds(29, 164, 131, 24);
		contentPane.add(txtpnTarih);
		
		textField = new JTextField();
		textField.setBounds(170, 62, 142, 19);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(170, 96, 282, 19);
		contentPane.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(170, 130, 51, 19);
		contentPane.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(170, 164, 51, 19);
		contentPane.add(textField_3);
		
		
		
		JTextPane txtpnToplamFatura = new JTextPane();
		txtpnToplamFatura.setText("Toplam Fatura:");
		txtpnToplamFatura.setBounds(29, 201, 131, 24);
		contentPane.add(txtpnToplamFatura);
		
		Connection con6 = conn.Connect();
		JEditorPane editorPane = new JEditorPane();
		try {
			Statement st6 = con6.createStatement();
            ResultSet rs = st6.executeQuery("SELECT SUM(sepet_fiyati) AS fiyat FROM sepet");
            while(rs.next()) {
    			String yemekfiyati = rs.getString("fiyat")+"TL";
    			editorPane.setText(yemekfiyati);
    		}
		} catch (Exception e) {	
		}
		editorPane.setBounds(170, 201, 51, 24);
		contentPane.add(editorPane);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(322, 62, 142, 19);
		contentPane.add(textField_4);
		
		JRadioButton radioKredi = new JRadioButton("Kredi Kart\u0131");
		buttonGroup_1.add(radioKredi);
		radioKredi.setBounds(49, 16, 103, 21);
		contentPane.add(radioKredi);
		
		JRadioButton radioPapara = new JRadioButton("Papara");
		buttonGroup_1.add(radioPapara);
		radioPapara.setBounds(170, 16, 103, 21);
		contentPane.add(radioPapara);
		JButton btnNewButton = new JButton("\u00D6de");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				ShoppingCart shoppingCart = new ShoppingCart();
				Connection con6 = conn.Connect();
				try {
					Statement st6 = con6.createStatement();
		            ResultSet rs = st6.executeQuery("SELECT * FROM sepet");
		            while(rs.next()) {
		            	int id = rs.getInt("sepet_id");
		    			int yemekfiyati = rs.getInt("sepet_fiyati");
		    			String yemek = rs.getString("sepet_adi");
						shoppingCart.addItem(new Sepet(yemek, yemekfiyati,id));
		    		}
				} catch (Exception e1) {	
				}

				if(radioPapara.isSelected()) {
					shoppingCart.setPaymentMethod(new Papara(textField.getText(),textField_4.getText()));
				}else {
			        shoppingCart.setPaymentMethod(new KrediKarti(textField.getText(), textField_1.getText(), textField_2.getText(), textField_3.getText()));
				}
				shoppingCart.Pay();
			}
		});
		btnNewButton.setBounds(186, 254, 85, 21);
		contentPane.add(btnNewButton);
	}
	
}
