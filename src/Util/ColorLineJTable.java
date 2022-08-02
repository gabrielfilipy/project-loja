package Util;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JTable;
import sun.swing.table.DefaultTableCellHeaderRenderer;

public class ColorLineJTable {
     
    public void add (JTable table) {
        
        table.setDefaultRenderer(Object.class, new DefaultTableCellHeaderRenderer() {
                @Override
                public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
                    int row, int column) {
                    JLabel jLabel = (JLabel) super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
                    
                    //
                        Object txt = table.getValueAt(row, 4);
                        if (txt.equals("Cancelada")) {
                            jLabel.setBackground(Color.WHITE);
                            jLabel.setForeground(Color.RED);
                            jLabel.setFont(new Font("Calibre", Font.BOLD, 13));
                            jLabel.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(255, 255, 255)));
                        } else {
                            jLabel.setBackground(Color.WHITE);
                            jLabel.setFont(new Font("Calibre", Font.BOLD, 13));
                            jLabel.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(255, 255, 255)));
                        }
                            
                    //
                    
                    return jLabel;
                }
            });
    }
    
}
