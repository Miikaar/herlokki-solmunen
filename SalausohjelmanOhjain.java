/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package salausohjelma;

import javax.swing.JOptionPane;
/**
 *
 * @author kaartmi
 */
public class SalausohjelmanOhjain {

    
    private Salausohjelma malli;
    private SalausohjelmanGUI nakyma;
    
    static Salausohjelma salausohjelma = new Salausohjelma();
    
    public SalausohjelmanOhjain(Salausohjelma malli, SalausohjelmanGUI nakyma){
        this.malli = malli;
        this.nakyma = nakyma;
    }
    
    public static void main(String[] args) {
        
        String vastaus = SalausohjelmanOhjain.paasyKoodi();
        if("42".equals(vastaus)){
            Salausohjelma malli = new Salausohjelma();
            SalausohjelmanGUI nakyma = new SalausohjelmanGUI();
            SalausohjelmanOhjain ohjain = new SalausohjelmanOhjain(malli, nakyma);
            nakyma.rekisteroiOhjain(ohjain);
        } else {
            SalausohjelmanOhjain.epaonnistui();
        }
        
    }
    
    public String salaus(){
        return malli.salaaViesti(nakyma.getSalattava());
    }
    public String purku(){
        return malli.puraViesti(nakyma.getPurettava());
    }
    public static String paasyKoodi(){
        String vastaus = JOptionPane.showInputDialog(null, "Mikä on vastaus suureen kysymykseen elämästä, maailmankaikkeudesta ja muusta sellaisesta?", "Syötä pääsykoodi", 1);
        return vastaus;
    }
    public static void epaonnistui(){
        JOptionPane.showMessageDialog(null, "Pääsy evätty", "Huomautus!", 1);
    }

    
}
