package ca.sqlpower.architect.swingui.table;

import java.awt.Component;
import java.text.DecimalFormat;
import java.text.Format;

import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

public class ValueRendererFactory extends DefaultTableCellRenderer {

    DecimalFormat aldf;

    public ValueRendererFactory() {
        aldf = new DecimalFormat("#,##0.0");
        aldf.setMaximumFractionDigits(1);
        aldf.setMinimumFractionDigits(0);
    }

    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
            int row, int column) {

        String formattedValue;

        if (value == null) {
            formattedValue = "";
        } else if (value instanceof Number) {
            formattedValue = aldf.format(value);
        } else {
            formattedValue = value.toString();
        }
         return super.getTableCellRendererComponent(table, formattedValue, isSelected, hasFocus, row, column);
    }

    public Format getFormat() {
        return aldf;
    }
}
