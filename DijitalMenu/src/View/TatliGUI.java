package View;
import Main.Menu;
import Model.PASTA;
import Model.PastaDecorator;
import Model.VisneliPasta;
import dbBaglantisi.MariaDBConnection;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JToggleButton;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TatliGUI extends JFrame {

    private JPanel xw;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    TatliGUI frame = new TatliGUI();
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
    public TatliGUI() {
    	setUndecorated(true);
        setBackground(Color.LIGHT_GRAY);
        setTitle("TATLILAR");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 720, 420);
        xw = new JPanel();
        xw.setBackground(new Color(165, 42, 42));
        xw.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(xw);
        xw.setLayout(null);

        MariaDBConnection db = new MariaDBConnection();
        Connection c = db.Connect();

        try {
            Statement st = c.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM yemekler where kategori_id = '" + 6 + "'");
            int i = 0;
            JToggleButton[] btnTatlilist = new JToggleButton[50];
            int[] dizi = new int[50];
            String[] dizi2 = new String[50];
            int h1 = 1;
            int h,w=-190;
            while (rs.next()) {
            	btnTatlilist[i] = new JToggleButton(rs.getString("yemekAdi")+"("+rs.getInt("fiyati")+" TL)");
                dizi[i] = rs.getInt("fiyati");
                dizi2[i] = rs.getString("yemekAdi");
                PastaDecorator p ;
           	  	p = new VisneliPasta(new PASTA());
           	  
                if (i % 3 == 0) {
                    System.out.println("ok");
                    h1 = 1;
                    w+=200;
                }
                
               h = h1 * 10;
               btnTatlilist[i].setBackground(new Color(100, 149, 237)); 
               btnTatlilist[i].setBounds(w, h, 190, 88);
               xw.add(btnTatlilist[i]);
               final int p2 = i;
                btnTatlilist[i].addActionListener(new ActionListener() {
                	
                    public void actionPerformed(ActionEvent arg0) {
                    	System.out.println(btnTatlilist[p2].getText());
                       try {
						Statement st2 = c.createStatement();
						st2.executeUpdate("INSERT INTO sepet (sepet_adi,sepet_fiyati) VALUES ('"+dizi2[p2]+"','"+dizi[p2]+"')");
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
                       
                    }
                });
                i++;
                h1+=10;
            }

            PastaDecorator p ;
       	  	p = new VisneliPasta(new PASTA());
            btnTatlilist[i] = new JToggleButton(p.getyemekAdi()+"("+p.getFiyati()+" TL)");
            dizi[i] =  p.getFiyati();
            dizi2[i] = p.getyemekAdi();
            btnTatlilist[i].setBackground(new Color(100, 149, 237)); 
            h = h1 * 10;
            btnTatlilist[i].setBounds(w, h, 190, 88);
            xw.add(btnTatlilist[i]);
        } catch (SQLException ex) {
            Logger.getLogger(TatliGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        JButton btnBackButton = new JButton("Geri");
        btnBackButton.setBackground(new Color(100, 149, 237));
        btnBackButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                new Menu().setVisible(true);
                hide();
            }
        });
        btnBackButton.setBounds(611, 10, 85, 21);
        xw.add(btnBackButton);
    }
}