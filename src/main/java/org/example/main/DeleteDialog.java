package org.example.main;

import org.example.dao.EmployeeDAO;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DeleteDialog extends JDialog {
    private final JPanel contentPanel = new JPanel();
    private JTextField txtId;
    public static void main(String[] args) {
        try {
            DeleteDialog dialog = new DeleteDialog();
            dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
            dialog.setVisible(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public DeleteDialog(){
        setTitle("Delete Contact");
        setBounds(100, 100, 350, 200);
        getContentPane().setLayout(new BorderLayout());
        contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
        getContentPane().add(contentPanel, BorderLayout.CENTER);
        contentPanel.setLayout(null);
        {
            JLabel lblId = new JLabel("ID");
            lblId.setBounds(22, 14, 27, 14);
            contentPanel.add(lblId);
        }
        {
            txtId = new JTextField();
            txtId.setBounds(54, 11, 86, 20);
            txtId.setColumns(10);
            contentPanel.add(txtId);
        }
        {
            JPanel buttonPane = new JPanel();
            buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
            getContentPane().add(buttonPane, BorderLayout.SOUTH);
            {
                JButton okButton = new JButton("OK");
                okButton.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        int id=Integer.parseInt(txtId.getText());
                        EmployeeDAO eDAO=new EmployeeDAO();
                        int count=eDAO.deleteEmployee(id);
                        System.out.println("Result : "+count);
                        if(count>0)
                        {
                            JOptionPane.showMessageDialog(null, "Record Deleted Successfully!!!");
                        }else{
                            JOptionPane.showMessageDialog(null, "Record Can't Deleted !!!");
                        }
                        dispose();
                    }
                });
                okButton.setActionCommand("OK");
                buttonPane.add(okButton);
                getRootPane().setDefaultButton(okButton);
            }
            {
                JButton cancelButton = new JButton("Cancel");
                cancelButton.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent arg0) {
                        dispose();
                    }
                });
                cancelButton.setActionCommand("Cancel");
                buttonPane.add(cancelButton);
            }
        }
    }
}
