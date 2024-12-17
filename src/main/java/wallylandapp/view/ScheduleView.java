package wallylandapp.view;

import wallylandapp.controller.PurchaseController;
import wallylandapp.model.Reservation;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableCellRenderer;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 * The ScheduleView class represents the view for the user's schedule of reservations.
 */
public class ScheduleView extends JPanel {
    private ArrayList<Reservation> reservations = new ArrayList<>();
    private JTable reservationTable;
    private ReservationTableModel tableModel;
    private static final int FONT_SIZE = 20; // Set the desired font size

    /**
     * Constructs a new ScheduleView.
     */
    public ScheduleView() {
        initializeComponents();
    }

    /**
     * Sets the reservations to be displayed in the table.
     * @param reservations the reservations to be displayed
     */
    public void setReservations(ArrayList<Reservation> reservations) {
        this.reservations = reservations;
        tableModel.setReservations(reservations);
    }

    /**
     * Initializes the components of the view.
     */
    private void initializeComponents() {
        setLayout(new BorderLayout());

        tableModel = new ReservationTableModel(reservations);
        reservationTable = new JTable(tableModel);
        reservationTable.setFont(new Font("Dialog", Font.PLAIN, FONT_SIZE));
        reservationTable.setRowHeight(50); // Set the desired row height

        // Set custom renderer for each column to adjust font size
        for (int i = 0; i < reservationTable.getColumnCount(); i++) {
            reservationTable.getColumnModel().getColumn(i).setCellRenderer(new CustomTableCellRenderer());
        }

        // Set custom renderer and editor for the cancel button column
        reservationTable.getColumn("Cancel").setCellRenderer(new ButtonRenderer());
        reservationTable.getColumn("Cancel").setCellEditor(new ButtonEditor(new JCheckBox()));

        // Set font size for table header
        reservationTable.getTableHeader().setFont(new Font("Dialog", Font.BOLD, FONT_SIZE));

        JScrollPane scrollPane = new JScrollPane(reservationTable);
        add(scrollPane, BorderLayout.CENTER);
    }

    /**
     * The ReservationTableModel class represents the table model for the reservations table.
     */
    private class ReservationTableModel extends AbstractTableModel {
        private final String[] columnNames = {"Ride Name", "Reserved Time", "Ticket Count", "Total Price", "Cancel"};
        private ArrayList<Reservation> reservations;

        public ReservationTableModel(ArrayList<Reservation> reservations) {
            this.reservations = reservations;
        }

        public void setReservations(ArrayList<Reservation> reservations) {
            this.reservations = reservations;
            fireTableDataChanged();
        }

        @Override
        public int getRowCount() {
            return reservations.size();
        }

        @Override
        public int getColumnCount() {
            return columnNames.length;
        }

        @Override
        public String getColumnName(int column) {
            return columnNames[column];
        }

        @Override
        public Object getValueAt(int rowIndex, int columnIndex) {
            Reservation reservation = reservations.get(rowIndex);
            switch (columnIndex) {
                case 0:
                    return reservation.getItem().getName();
                case 1:
                    return reservation.getTime();
                case 2:
                    return reservation.getTicketCount();
                case 3:
                    return String.format("$%.2f", reservation.getItem().getPriceCents() * reservation.getTicketCount() / 100.0);
                case 4:
                    return "Cancel";
                default:
                    return null;
            }
        }

        @Override
        public boolean isCellEditable(int rowIndex, int columnIndex) {
            return columnIndex == 4; // Only the cancel button column is editable
        }
    }

    /**
     * The CustomTableCellRenderer class represents a custom table cell renderer with a specified font size.
     */
    private class CustomTableCellRenderer extends DefaultTableCellRenderer {
        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
            c.setFont(new Font("Dialog", Font.PLAIN, FONT_SIZE));
            return c;
        }
    }

    /**
     * The ButtonRenderer class represents a custom table cell renderer for buttons.
     */
    private class ButtonRenderer extends JButton implements TableCellRenderer {
        public ButtonRenderer() {
            setOpaque(true);
        }

        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            setText((value == null) ? "" : value.toString());
            setFont(new Font("Dialog", Font.PLAIN, FONT_SIZE));
            return this;
        }
    }

    /**
     * The ButtonEditor class represents a custom table cell editor for buttons.
     */
    private class ButtonEditor extends DefaultCellEditor {
        private JButton button;
        private String label;
        private boolean isPushed;

        public ButtonEditor(JCheckBox checkBox) {
            super(checkBox);
            button = new JButton();
            button.setOpaque(true);
            button.setFont(new Font("Dialog", Font.PLAIN, FONT_SIZE));
            button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    fireEditingStopped();
                }
            });
        }

        @Override
        public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
            label = (value == null) ? "" : value.toString();
            button.setText(label);
            isPushed = true;
            return button;
        }

        /**
         * Cancels the reservation when the cancel button is clicked.
         */
        @Override
        public Object getCellEditorValue() {
            if (isPushed) {
                int response = JOptionPane.showConfirmDialog(null, "Are you sure you want to cancel this reservation?", "Confirm", JOptionPane.YES_NO_OPTION);
                if (response == JOptionPane.YES_OPTION) {
                    int row = reservationTable.getSelectedRow();
                    Reservation reservation = reservations.get(row);
                    reservations.remove(reservation);
                    PurchaseController.cancelReservation(button, reservation);
                    tableModel.fireTableRowsDeleted(row, row);
                }
            }
            isPushed = false;
            return label;
        }

        @Override
        public boolean stopCellEditing() {
            isPushed = false;
            return super.stopCellEditing();
        }

        @Override
        protected void fireEditingStopped() {
            super.fireEditingStopped();
        }
    }
}