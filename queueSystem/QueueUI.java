package queueSystem;

	import javax.swing.*;
	import javax.swing.table.DefaultTableModel;
	import java.awt.*;
	import java.awt.event.*;
	import java.util.List;

	public class QueueUI extends JFrame {

	    JTextField nameField, serviceField;
	    JTable table;
	    DefaultTableModel model;
	    QueueDAO dao = new QueueDAO();

	    public QueueUI() {
	        setTitle("Digital Queue Management System");
	        setSize(700, 500);
	        setDefaultCloseOperation(EXIT_ON_CLOSE);
	        setLayout(new BorderLayout());

	        // Top Panel
	        JPanel topPanel = new JPanel();
	        topPanel.setLayout(new GridLayout(3, 2));

	        topPanel.add(new JLabel("Name:"));
	        nameField = new JTextField();
	        topPanel.add(nameField);

	        topPanel.add(new JLabel("Service:"));
	        serviceField = new JTextField();
	        topPanel.add(serviceField);

	        JButton addBtn = new JButton("Add to Queue");
	        topPanel.add(addBtn);

	        JButton serveBtn = new JButton("Serve Next");
	        topPanel.add(serveBtn);

	        add(topPanel, BorderLayout.NORTH);

	        // Table
	        model = new DefaultTableModel(
	            new String[]{"ID", "Name", "Service", "Token", "Status"}, 0
	        );
	        table = new JTable(model);

	        add(new JScrollPane(table), BorderLayout.CENTER);

	        // Button Actions
	        addBtn.addActionListener(e -> addCustomer());
	        serveBtn.addActionListener(e -> serveNext());

	        loadTable();

	        setVisible(true);
	    }

	    void addCustomer() {
	        String name = nameField.getText();
	        String service = serviceField.getText();

	        if (name.isEmpty() || service.isEmpty()) {
	            JOptionPane.showMessageDialog(this, "Enter all fields");
	            return;
	        }

	        int token = dao.getNextToken();
	        dao.addCustomer(name, service, token);

	        JOptionPane.showMessageDialog(this, "Token Number: " + token);

	        nameField.setText("");
	        serviceField.setText("");

	        loadTable();
	    }

	    void serveNext() {
	        dao.serveNext();
	        loadTable();
	    }

	    void loadTable() {
	        model.setRowCount(0);

	        List<String[]> data = dao.getQueue();

	        for (String[] row : data) {
	            model.addRow(row);
	        }
	    }

	    public static void main(String[] args) {
	        new QueueUI();
	    }
	}

