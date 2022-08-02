package Util;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;

public class Format {
    
    public String convertValueTotalForReal (Float value) {
        Locale ptBr = new Locale("pt", "BR");
        String total = NumberFormat.getCurrencyInstance(ptBr).format(value);
        System.out.println(total);
        return total;
    }
    
    public String convertValueTotalForReal (Double value) {
        Locale ptBr = new Locale("pt", "BR");
        String total = NumberFormat.getCurrencyInstance(ptBr).format(value);
        System.out.println(total);
        return total;
    }
                
    public String convertPoints(String pString){
        String valueReturn = new String();
        int tamanhoString = pString.length();
        for (int i = 0; i < tamanhoString; i++) {
            if(pString.charAt(i) == ','){
               valueReturn += '.';
            }else{
               valueReturn+= pString.charAt(i);
            }   
        } 
        return valueReturn;
    }
 
    public float roundValue(float pValor){
         DecimalFormat df = new DecimalFormat("#.00");
         return Float.parseFloat(this.convertPoints(df.format(pValor)));
    }
     
    public String roundValueFloat(float pValor){
         DecimalFormat df = new DecimalFormat("#.00");
         return this.convertPoints(df.format(pValor));
    }
     
    public String roundValueDouble(Double pValor){
         DecimalFormat df = new DecimalFormat("#.00");
         return this.convertPoints(df.format(pValor));
    }
    
}
