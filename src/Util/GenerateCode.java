package Util;

public class GenerateCode {
    private int dado;
    private int cont=1;
    private String num="";

    public void generate(int dado) {
        this.dado = dado;
          
           if((this.dado>=1000) || (this.dado<10000)) 
           {
               int can=cont+this.dado;
               num = "" + can; 
           }
           if((this.dado>=100) || (this.dado<1000))
           {
               int can=cont+this.dado;
               num = "0" + can; 
           }
           if((this.dado>=9) || (this.dado<100)) 
           {
                int can=cont+this.dado;
               num = "00" + can; 
           }
           if (this.dado<9)
           {
               int can=cont+this.dado;
               num = "000" + can; 
           }
          
    }

    public String serie()
    {
        return this.num;
    }
}
