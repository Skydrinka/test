/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kf5012;

import java.awt.EventQueue;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author w19007581
 */
public class taskAllocation extends javax.swing.JFrame {

    ViewAllocations theMarksHandler;
    /**
     * Creates new form taskAllocation
     */
    public taskAllocation(ViewAllocations handler) {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        techNameTextField = new javax.swing.JTextField();
        sortTechButton = new javax.swing.JButton();
        listTasksButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        overdueTaskButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Technician", "Talent", "Expected Time", "Urgency", "Problem"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(2).setPreferredWidth(100);
            jTable1.getColumnModel().getColumn(4).setPreferredWidth(500);
        }

        techNameTextField.setToolTipText("Type technician's name here.");

        sortTechButton.setText("Sort");
        sortTechButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sortTechButtonActionPerformed(evt);
            }
        });

        listTasksButton.setText("Change technician");
        listTasksButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                listTasksButtonActionPerformed(evt);
            }
        });

        jLabel1.setText("Enter technicians name then click sort to see what tasks have been allocated");

        overdueTaskButton.setText("Overdue Tasks");
        overdueTaskButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                overdueTaskButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 801, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(techNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(sortTechButton, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(listTasksButton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(overdueTaskButton))
                            .addComponent(jLabel1))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(techNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(sortTechButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(listTasksButton)
                    .addComponent(overdueTaskButton))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void sortTechButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sortTechButtonActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_sortTechButtonActionPerformed

    private void listTasksButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_listTasksButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_listTasksButtonActionPerformed

    private void overdueTaskButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_overdueTaskButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_overdueTaskButtonActionPerformed

    /**
     * @param args the command line arguments
     */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					taskAllocation frame = new taskAllocation(null);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
          	void displayTableData(ArrayList<TechnicianInformation> tableData, ArrayList<MotorProblems> tableData2){
		
		// Empty the existing data
		DefaultTableModel tableModel = (DefaultTableModel) jTable1.getModel();
		tableModel.setRowCount(0);
		
		// Some safety code missing here
		for(TechnicianInformation s: tableData) {
                for(MotorProblems p: tableData2)
                {
			tableModel.addRow(new Object[] {s.getName(), s.getTalents(), p.getExpecDuration(), p.getUrgency(), p.getProblem()});
                }   
                }
                    
	}
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JButton listTasksButton;
    private javax.swing.JButton overdueTaskButton;
    private javax.swing.JButton sortTechButton;
    private javax.swing.JTextField techNameTextField;
    // End of variables declaration//GEN-END:variables
}
