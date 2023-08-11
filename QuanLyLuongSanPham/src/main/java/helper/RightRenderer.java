/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package helper;

import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.JLabel;

/**
 *
 * @author huylauri
 */
public class RightRenderer extends DefaultTableCellRenderer{
    public RightRenderer() {
        setHorizontalAlignment(JLabel.RIGHT);
    }

    @Override
    public void setValue(Object value) {
        if (value instanceof Double) {
            setText(String.format("%.1f", (Double) value));
        } else {
            setText(value.toString());
        }
    }
}
