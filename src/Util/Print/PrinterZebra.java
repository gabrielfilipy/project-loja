package Util.Print;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.print.DocFlavor;
import javax.print.DocPrintJob;
import javax.print.PrintException;
import javax.print.PrintService;
import javax.print.PrintServiceLookup;
import javax.print.SimpleDoc;
import javax.swing.JOptionPane;

public class PrinterZebra {
    
    public boolean printLabel(PrintService printService, String label) {
        if (label == null) {
            System.err.println("[Print Label] print service or label is invalid.");
            return false;
        }
        String czas = new SimpleDateFormat("d MMMMM yyyy'r.' HH:mm s's.'").format(new Date());
        String command =  
                "N\n"+
                "A50,50,0,2,2,2,N,\""+label+"\"\n"+
                "B50,100,0,1,2,2,170,B,\""+label+"\"\n"+
                "A50,310,0,3,1,1,N,\""+czas+"\"\n"+
                "P1\n"
                ;

        byte[] data;
        data = command.getBytes(StandardCharsets.US_ASCII);
        SimpleDoc doc = new SimpleDoc(data, DocFlavor.BYTE_ARRAY.AUTOSENSE, null);
        System.out.println(">>> command: " + command);
        boolean result = false;
        try {
            printService.createPrintJob().print(doc, null);
            result = true;
        } catch (PrintException e) {
            e.printStackTrace();
        }
        return result;
    }
    
}