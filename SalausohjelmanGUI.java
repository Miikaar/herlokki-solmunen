/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package salausohjelma;


import javax.swing.*;
import java.awt.event.*;


/**
 *
 * @author kaartmi
 */
public class SalausohjelmanGUI extends JFrame {

    private JPanel paneeli;
    private JPanel salauspaneeli;
    private JPanel purkupaneeli;
    private JPanel tulospaneeli;
    private JTextField salauskentta;
    private JTextField purkukentta;
    private JButton salauspainike;
    private JButton purkupainike;
    private JTextArea tekstikentta;
    private BoxLayout asettelu;
    private SalausohjelmanOhjain ohjain;
    
    public SalausohjelmanGUI(){
        alustaKomponentit();
    }
    
    public void rekisteroiOhjain(SalausohjelmanOhjain ohjain){
        this.ohjain = ohjain;
    }
    
    private void alustaKomponentit(){
        setTitle("Herlokki Solmusen salausohjelma");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        paneeli = new JPanel();
        paneeli.setLayout(new BoxLayout(paneeli, BoxLayout.Y_AXIS));
        salauspaneeli = new JPanel();
        salauspaneeli.setBorder(BorderFactory.createTitledBorder("Kirjoita tähän salattava viesti:"));
        salauskentta = new JTextField(50);
        salauspainike = new JButton("Salaa viesti");
        purkupaneeli = new JPanel();
        purkupaneeli.setBorder(BorderFactory.createTitledBorder("Kirjoita tähän purettava viesti:"));
        purkukentta = new JTextField(50);
        purkupainike = new JButton("Pura salaus");
        tulospaneeli = new JPanel();
        tulospaneeli.setBorder(BorderFactory.createTitledBorder("Lopputulos"));
        tekstikentta = new JTextArea();
        tekstikentta.setSize(200, 400);
        paneeli.add(salauspaneeli);
        salauspaneeli.add(salauskentta);
        salauspaneeli.add(salauspainike);
        paneeli.add(purkupaneeli);
        purkupaneeli.add(purkukentta);
        purkupaneeli.add(purkupainike);
        tulospaneeli.add(tekstikentta);
        paneeli.add(tulospaneeli);
        setContentPane(paneeli);
        
        
        salauspainike.addActionListener(new ActionListener() {
    
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                ohjain.salaus();
            } catch(Exception exc) {
                SwingUtilities.invokeLater(new Runnable() {
                    @Override
                    public void run(){
                        tekstikentta.setText("Syöte on virheellinen.");
                    }
                });
            } finally{
                tekstikentta.setText(ohjain.salaus());
            }
        }
        });
        
        purkupainike.addActionListener(new ActionListener() {
    
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                ohjain.purku();
            } catch(Exception exc) {
                SwingUtilities.invokeLater(new Runnable() {
                    @Override
                    public void run(){
                        tekstikentta.setText("Syöte on virheellinen.");
                    }
                });
            } finally{
                tekstikentta.setText(null);
                tekstikentta.setText(ohjain.purku());
            }
        }
        });
        
        pack();
        //setSize(600,400);
        setVisible(true);
        
    }
    
    public String getSalattava(){
        return salauskentta.getText();
    }
    
    public String getPurettava(){
        return purkukentta.getText();
    }


}
