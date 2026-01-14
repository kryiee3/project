package proj;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class business {

    JFrame frame;
    JComboBox<String> cbDrink, cbSize, cbDessert;
    JCheckBox cbPearls, cbNata, cbJelly, cbPudding,
              cbCreamCheese, cbWhippedCream;
    JLabel lblTotal;
    JTable table;
    DefaultTableModel model;

    public business() {

        frame = new JFrame("Milk Tea / Coffee Shop with Desserts");
        frame.setSize(820, 520);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);

        // ===== DRINK =====
        JLabel lblDrink = new JLabel("Drink:");
        lblDrink.setBounds(30, 30, 100, 25);
        frame.add(lblDrink);

        cbDrink = new JComboBox<>(new String[]{
                "Select Drink",
                "Milk Tea",
                "Coffee"
        });
        cbDrink.setBounds(140, 30, 180, 25);
        frame.add(cbDrink);

        // ===== SIZE =====
        JLabel lblSize = new JLabel("Size:");
        lblSize.setBounds(30, 70, 100, 25);
        frame.add(lblSize);

        cbSize = new JComboBox<>(new String[]{
                "Select Size",
                "Small",
                "Medium",
                "Large"
        });
        cbSize.setBounds(140, 70, 180, 25);
        frame.add(cbSize);

        // ===== DESSERT =====
        JLabel lblDessert = new JLabel("Dessert:");
        lblDessert.setBounds(30, 110, 100, 25);
        frame.add(lblDessert);

        cbDessert = new JComboBox<>(new String[]{
                "None",
                "Cake (+50)",
                "Donut (+30)",
                "Brownie (+40)",
                "Ice Cream (+35)"
        });
        cbDessert.setBounds(140, 110, 180, 25);
        frame.add(cbDessert);

        // ===== ADD-ONS =====
        JLabel lblAddOns = new JLabel("Add-ons:");
        lblAddOns.setBounds(30, 150, 100, 25);
        frame.add(lblAddOns);

        cbPearls = new JCheckBox("Pearls (+20)");
        cbPearls.setBounds(140, 150, 160, 25);
        frame.add(cbPearls);

        cbNata = new JCheckBox("Nata (+15)");
        cbNata.setBounds(140, 180, 160, 25);
        frame.add(cbNata);

        cbJelly = new JCheckBox("Coffee Jelly (+20)");
        cbJelly.setBounds(140, 210, 160, 25);
        frame.add(cbJelly);

        cbPudding = new JCheckBox("Pudding (+25)");
        cbPudding.setBounds(330, 150, 160, 25);
        frame.add(cbPudding);

        cbCreamCheese = new JCheckBox("Cream Cheese (+30)");
        cbCreamCheese.setBounds(330, 180, 180, 25);
        frame.add(cbCreamCheese);

        cbWhippedCream = new JCheckBox("Whipped Cream (+20)");
        cbWhippedCream.setBounds(330, 210, 200, 25);
        frame.add(cbWhippedCream);

        // ===== TOTAL =====
        lblTotal = new JLabel("Total: ₱0");
        lblTotal.setBounds(30, 250, 300, 25);
        frame.add(lblTotal);

        // ===== TABLE =====
        model = new DefaultTableModel(
                new String[]{"Drink", "Size", "Dessert", "Add-ons", "Total"}, 0
        );
        table = new JTable(model);

        JScrollPane sp = new JScrollPane(table);
        sp.setBounds(550, 30, 240, 360);
        frame.add(sp);

        // ===== BUTTONS =====
        JButton btnAdd = new JButton("Add Order");
        btnAdd.setBounds(30, 290, 150, 30);
        frame.add(btnAdd);

        JButton btnDelete = new JButton("Delete");
        btnDelete.setBounds(190, 290, 150, 30);
        frame.add(btnDelete);

        // ===== ADD LOGIC =====
        btnAdd.addActionListener(e -> {

            if (cbDrink.getSelectedIndex() == 0 ||
                cbSize.getSelectedIndex() == 0) {
                JOptionPane.showMessageDialog(frame, "Select drink and size!");
                return;
            }

            int total = 0;

            // Drink price
            if (cbDrink.getSelectedItem().equals("Milk Tea")) total = 80;
            else total = 90;

            // Size price
            if (cbSize.getSelectedItem().equals("Medium")) total += 20;
            if (cbSize.getSelectedItem().equals("Large")) total += 40;

            // Dessert price
            String dessert = cbDessert.getSelectedItem().toString();
            if (dessert.contains("Cake")) total += 50;
            if (dessert.contains("Donut")) total += 30;
            if (dessert.contains("Brownie")) total += 40;
            if (dessert.contains("Ice Cream")) total += 35;

            // Add-ons
            String addOns = "";

            if (cbPearls.isSelected()) { total += 20; addOns += "Pearls, "; }
            if (cbNata.isSelected()) { total += 15; addOns += "Nata, "; }
            if (cbJelly.isSelected()) { total += 20; addOns += "Jelly, "; }
            if (cbPudding.isSelected()) { total += 25; addOns += "Pudding, "; }
            if (cbCreamCheese.isSelected()) { total += 30; addOns += "Cream Cheese, "; }
            if (cbWhippedCream.isSelected()) { total += 20; addOns += "Whipped Cream, "; }

            if (addOns.endsWith(", ")) {
                addOns = addOns.substring(0, addOns.length() - 2);
            }

            // Update table
            model.addRow(new Object[]{
                    cbDrink.getSelectedItem(),
                    cbSize.getSelectedItem(),
                    dessert,
                    addOns.isEmpty() ? "None" : addOns,
                    "₱" + total
            });

            // Update total label
            lblTotal.setText("Total: ₱" + total);
        });

        // ===== DELETE LOGIC =====
        btnDelete.addActionListener(e -> {
            int selectedRow = table.getSelectedRow();
            if (selectedRow != -1) {
                model.removeRow(selectedRow);
            } else {
                JOptionPane.showMessageDialog(frame, "Select a row to delete!");
            }
        });

        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new business();
    }
}
