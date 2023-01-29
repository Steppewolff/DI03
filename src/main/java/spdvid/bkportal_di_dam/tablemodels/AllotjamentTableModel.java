package spdvid.bkportal_di_dam.tablemodels;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;
import spdvid.bkportal_di_dam.dto.Alojamiento;

/**
 *
 * @author Miguel
 */
public class AllotjamentTableModel extends AbstractTableModel {

    private ArrayList<Alojamiento> allotjaments = new ArrayList<>();
    private String[] headers = new String[]{"id", "nom", "adresa", "municipi"};

    public AllotjamentTableModel(ArrayList<Alojamiento> allotjaments) {
        this.allotjaments = allotjaments;
    }

    @Override
    public int getRowCount() {
        return allotjaments.size();
    }

    @Override
    public int getColumnCount() {
        return headers.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0 -> {
                return allotjaments.get(rowIndex).getId();
            }
            case 1 -> {
                return allotjaments.get(rowIndex).getNom();
            }
            case 2 -> {
                return allotjaments.get(rowIndex).getAdresa();
            }
            case 3 -> {
                return allotjaments.get(rowIndex).getId_municipi();
            }
            default ->
                throw new AssertionError();
        }

    }
    
    public Alojamiento getValueAtRow(int rowIndex) {
        return allotjaments.get(rowIndex);
    }

    @Override
    public String getColumnName(int column) {
        return headers[column];
    }

}
