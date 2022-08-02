package Util;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.TableCellRenderer;

public class TableHeaderStyle implements TableCellRenderer {

    public TableHeaderStyle() { }
    
    public Component getTableCellRendererComponent(JTable jtable, Object value, boolean bln, boolean bln1, int row, int column) {
        JComponent jcomponent = null;
        
        if(value instanceof String ) {
            jcomponent = new JLabel((String) "   " + value);
            ((JLabel)jcomponent).setHorizontalAlignment(SwingConstants.LEFT );
            ((JLabel)jcomponent).setSize( 30, jcomponent.getWidth() );
            ((JLabel)jcomponent).setPreferredSize( new Dimension(3, jcomponent.getWidth())  );
        }  
        
        jcomponent.setEnabled(true);        
        jcomponent.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(255, 255, 255)));
        jcomponent.setOpaque(true);
        jcomponent.setBackground( new Color(255,255,255) );
        jcomponent.setForeground(Color.BLACK);
        jcomponent.setFont(new Font("Calibre", Font.BOLD, 13));
        jcomponent.setToolTipText("Colum No. "+(column+1));
        
        return jcomponent;
    }
    
}
