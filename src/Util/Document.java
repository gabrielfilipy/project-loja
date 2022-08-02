package Util;

import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

/*
    validates fields making it impossible to use some characters
*/

public class Document extends PlainDocument{
    @Override
    public void insertString(int offs, String str, AttributeSet a) throws BadLocationException {
        try {
            int tam = (this.getLength() + str.length());
            if(tam <=8){ 
                super.insertString(offs, str.replaceAll("[aA-zZç]", ""), a);     
            }else{
                super.insertString(offs, str.replaceAll("{aA0-zZ9}", ""), a);
            }
        } catch (Exception e) { } 
    }
}
