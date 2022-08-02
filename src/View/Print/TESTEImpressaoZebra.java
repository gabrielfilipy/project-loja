package View.Print;

import javax.print.DocFlavor;
import javax.print.DocPrintJob;
import javax.print.PrintService;
import javax.print.PrintServiceLookup;
import javax.print.attribute.PrintServiceAttribute;
import javax.swing.JOptionPane;
import javax.print.Doc;
import javax.print.PrintException;
import javax.print.SimpleDoc;
import javax.print.attribute.standard.PrinterName;

public class TESTEImpressaoZebra {
    
    public static void printZpl(String zpl, String printerName) {
        try {

            PrintService psZebra = null;
            String sPrinterName = null;
            PrintService[] services = PrintServiceLookup.lookupPrintServices(null, null);

            for (int i = 0; i < services.length; i++) {
                PrintServiceAttribute attr = services[i].getAttribute(PrinterName.class);
                sPrinterName = ((PrinterName) attr).getValue();
               // if (sPrinterName.toLowerCase().indexOf(printerName.toLowerCase()) >= 0) {
                    psZebra = services[i];
                    break;
                //}
            }

            if (psZebra == null) {
                JOptionPane.showMessageDialog(null, "psZebra está nulo!");
//                throw new Excep("Zebra printer not found : " + printerName);
            }
            DocPrintJob job = psZebra.createPrintJob();

            byte[] by = zpl.getBytes();
            DocFlavor flavor = DocFlavor.BYTE_ARRAY.AUTOSENSE;
            Doc doc = new SimpleDoc(by, flavor, null);
            job.print(doc, null);
        } catch (PrintException e) {
            JOptionPane.showMessageDialog(null, "ERROR: " + e);
        }
    }
    
}
