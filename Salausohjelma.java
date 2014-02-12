/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package salausohjelma;

/**
 *
 * @author kaartmi
 */
public class Salausohjelma {

    public Salausohjelma(){
        
    }
    public String salaaViesti(String salattavaTeksti){
        String merkkijono = salattavaTeksti;
        merkkijono = merkkijono.toLowerCase();
        int[] ascii = new int[merkkijono.length()];
        String[] hex = new String[merkkijono.length()];
        char[] kirjaimet = new char[merkkijono.length()];
        StringBuilder teksti = new StringBuilder();
        String salattu;
        
        for(int i = 0; i < merkkijono.length(); i++){
            kirjaimet[i] = merkkijono.charAt(i);
            if(kirjaimet[i] == ' '){
                hex[i] = "00";
                }else if(kirjaimet[i] == ','){
                    hex[i] = "01";
                } else if(kirjaimet[i] == '.'){
                    hex[i] = "05";
                } else if(kirjaimet[i] == '!'){
                    hex[i] = "09";
                } else if(kirjaimet[i] == '?'){
                    hex[i] = "13";
                }
                ascii[i] = (((int) kirjaimet[i]) - 96);

                if(ascii[i] % 2 == 1){
                    ascii[i] = ascii[i]*2;
                    if(hex[i] == "00" || hex[i] == "01" || hex[i] == "05" || hex[i] == "09" || hex[i] == "13"){

                    } else {
                        hex[i] = Integer.toHexString(ascii[i]);
                    }
                    if(hex[i].length() < 2){
                        hex[i] = ("0"+hex[i]);
                    }
                    System.out.println("hex "+i+" "+hex[i]);
                } else if(ascii[i] % 2 == 0){
                    ascii[i] = (((32-ascii[i])*4)-1);
                    if(hex[i] == "00" || hex[i] == "01" || hex[i] == "05" || hex[i] == "09" || hex[i] == "13"){

                    } else {
                        hex[i] = Integer.toHexString(ascii[i]);
                    }
                    if(hex[i].length() < 2){
                        hex[i] = ("0"+hex[i]);
                    }
                }

                teksti.append(hex[i]);
           }
    salattu = teksti.toString();
    return salattu;
    }
    
    public String puraViesti(String purettavaTeksti){
        String merkkijono = purettavaTeksti;
        int[] ascii = new int[merkkijono.length()];
        String[] hex = new String[merkkijono.length()];
        char[] kirjaimet = new char[merkkijono.length()];
        StringBuilder teksti = new StringBuilder();
        String purku;
        
        for(int i = 0; (i < (merkkijono.length()/2)); i++){
            int n = i*2;
            hex[i] = merkkijono.substring(n, n+2);
            switch (hex[i]) {
                case "00":
                    kirjaimet[i] = ' ';
                    continue;
                case "01":
                    kirjaimet[i] = ',';
                    continue;
                case "05":
                    kirjaimet[i] = '.';
                    continue;
                case "09":
                    kirjaimet[i] = '!';
                    continue;
                case "13":
                    kirjaimet[i] = '?';
                    continue;
            }
            ascii[i] = Integer.parseInt(hex[i], 16);
            
            
            if(ascii[i] % 2 == 0){
               ascii[i] = ((ascii[i]/2));
               ascii[i] += 96;
               kirjaimet[i] = (char) ascii[i];
            } else if(ascii[i] % 2 == 1){
               ascii[i] = (32-((ascii[i]/4)+1));
               ascii[i] += 96; 
               kirjaimet[i] = (char) ascii[i];
            }
            
        } 
        for(int i = 0; i < kirjaimet.length; i++){
            teksti.append(kirjaimet[i]);
        }
        purku = teksti.toString();
        return purku;
    }
}
