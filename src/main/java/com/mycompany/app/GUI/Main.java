/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import DAL.DepartmentDAL;
import DLL.DeparmentDLL;
import DLL.StudentDLL;
import DLL.ClassDLL;
import Entity.Deparment;
import Entity.Student;
import Entity.Class;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author vinh
 */
public class Main extends javax.swing.JFrame {

    /**
     * Creates new form Main
     */
    StudentDLL empDll = new StudentDLL();
    ArrayList<Student> listEMP = new ArrayList<>();

    DeparmentDLL depDLL = new DeparmentDLL();
    ArrayList<Deparment> listDep = new ArrayList<>();

    ClassDLL prDLL = new ClassDLL();
    ArrayList<Class> listPr = new ArrayList<>();

    public Main() {
        initComponents();
        String laf = "";
        laf = "com.sun.java.swing.plaf.windows.WindowsLookAndFeel";
        try {
            UIManager.setLookAndFeel(laf);
            SwingUtilities.updateComponentTreeUI(this);
        } catch (Exception excep) {
        }
        this.setLocation(450, 50);

        Binding();
        bindingDep();
        bindingPr();
    }

    public void bindingDep() {
        listDep = depDLL.getALl();
        for (Deparment d : listDep) {
            cbxDep.addItem(d.getDepName());
        }

    }

    public void bindingPr() {
        listPr = prDLL.getAll();
        for(Class d : listPr){
            cbxPr.addItem(d.getprName());
        }

    }

    public void Binding() {
        listEMP = empDll.getALL();
        Vector clums = new Vector();
        clums.add("User");
        clums.add("Pass");
        clums.add("Họ Tên");
        clums.add("Ngày Sinh");
        clums.add("Địa chỉ");
        clums.add("SDT");
        clums.add("Khoa");
        clums.add("Lớp");

        Vector data = new Vector();

        for (Student emp : listEMP) {
            Vector row = new Vector();

            row.add(emp.getUsername());
            row.add(emp.getPassword());
            row.add(emp.getFullName());
            row.add(emp.getAge());
            row.add(emp.getAddress());
            row.add(emp.getPhone());
            
            listDep = depDLL.getByID(emp.getDepID());
            if (listDep.size() > 0) {
                row.add(listDep.get(0).getDepName());
            } else {
                row.add("isEmpty");
            }
            
            listPr = prDLL.getByID(emp.getPrID());
            if(listPr.size()>0){
                row.add(listPr.get(0).getprName());
            }else{
                row.add("isEmpty");
            }
            
            data.add(row);
        }

        DefaultTableModel dtm = new DefaultTableModel(data, clums);
        tblEmp.setModel(dtm);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblEmp = new javax.swing.JTable();
        txtUser = new javax.swing.JTextField();
        txtPass = new javax.swing.JTextField();
        txtFname = new javax.swing.JTextField();
        txtAge = new javax.swing.JTextField();
        txtAddress = new javax.swing.JTextField();
        txtPhone = new javax.swing.JTextField();
        cbxDep = new javax.swing.JComboBox();
        cbxPr = new javax.swing.JComboBox();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        lblUser = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(204, 0, 0));
        jLabel1.setText("Quản Lý Học Sinh");

        tblEmp.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tblEmp.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblEmpMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblEmp);

        cbxDep.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxDepActionPerformed(evt);
            }
        });

        jLabel2.setText("User:");

        jLabel3.setText("Passs:");

        jLabel4.setText("Họ Tên");

        jLabel5.setText("Ngày Sinh");

        jLabel6.setText("Địa chỉ");

        jLabel7.setText("SDT");

        jLabel8.setText("Khoa");

        jLabel9.setText("Lớp");
        jLabel9.setName(""); // NOI18N

        jButton1.setText("Thêm");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Cập nhật");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Xóa");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        lblUser.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblUser.setForeground(new java.awt.Color(204, 0, 0));

        jLabel10.setText("Tên:");
        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(206, 206, 206)
                        .addComponent(jButton1)
                        .addGap(33, 33, 33)
                        .addComponent(jButton2)
                        .addGap(29, 29, 29)
                        .addComponent(jButton3))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(266, 266, 266)
                        .addComponent(jLabel1)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 711, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblUser)))
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel3)
                                .addComponent(jLabel2)))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtPass, javax.swing.GroupLayout.DEFAULT_SIZE, 169, Short.MAX_VALUE)
                            .addComponent(txtUser)
                            .addComponent(txtFname))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtAge)
                            .addComponent(txtAddress)
                            .addComponent(txtPhone, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(33, 33, 33)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel8)
                            .addComponent(jLabel9))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cbxDep, 0, 133, Short.MAX_VALUE)
                            .addComponent(cbxPr, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(35, 35, 35))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblUser)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel10)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtAge, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbxDep, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel5)
                    .addComponent(jLabel8))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtPass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtAddress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel6)
                    .addComponent(jLabel9)
                    .addComponent(cbxPr, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtFname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtPhone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 51, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2)
                    .addComponent(jButton3))
                .addGap(26, 26, 26))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        listDep = depDLL.getALl();
        listPr = prDLL.getAll();
        String User = txtUser.getText();
        String pass = txtPass.getText();
        String FName = txtFname.getText();
        String Age = txtAge.getText();
        String Addrss = txtAddress.getText();
        String Phone = txtPhone.getText();
        int rowDep = cbxDep.getSelectedIndex();
        int rowPr = cbxPr.getSelectedIndex();

        int idDep = listDep.get(rowDep).getDepID();
        int idPr = listPr.get(rowPr).getPrID();

        Student emp = new Student();
        emp.setUsername(User);
        emp.setPassword(pass);
        emp.setFullName(FName);
        emp.setAge(Age);
        emp.setAddress(Addrss);
        emp.setPhone(Phone);
        emp.setDepID(idDep);
        emp.setPrID(idPr);
        if (empDll.AddData(emp)) {
            JOptionPane.showMessageDialog(this, "Thêm thành công.!");
            Binding();
        } else {
            JOptionPane.showMessageDialog(this, "Không thêm được.!");
        }

    }//GEN-LAST:event_jButton1ActionPerformed

    private void tblEmpMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblEmpMouseClicked
        if (tblEmp.getSelectedRow() != -1) {
            int row = tblEmp.getSelectedRow();
        listDep = depDLL.getALl();
        listPr = prDLL.getAll();
            listEMP = empDll.getALL();
            txtUser.setText(listEMP.get(row).getUsername());
            txtPass.setText(listEMP.get(row).getPassword());
            txtFname.setText(listEMP.get(row).getFullName());
            txtAge.setText(listEMP.get(row).getAge());
            txtAddress.setText(listEMP.get(row).getAddress());
            txtPhone.setText(listEMP.get(row).getPhone());

            listDep = depDLL.getByID(listEMP.get(row).getDepID());
            if (listDep.size() > 0) {
                cbxDep.setSelectedItem(listDep.get(0).getDepName());
            } else {
                cbxDep.setSelectedIndex(0);
            }
            listPr = prDLL.getByID(listEMP.get(row).getPrID());
            
        }
    }//GEN-LAST:event_tblEmpMouseClicked

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
         listDep = depDLL.getALl();
        listPr = prDLL.getAll();
         listEMP = empDll.getALL();
        String User = txtUser.getText();
        String pass = txtPass.getText();
        String FName = txtFname.getText();
        String Age = txtAge.getText();
        String Addrss = txtAddress.getText();
        String Phone = txtPhone.getText();
        int rowDep = cbxDep.getSelectedIndex();
        int rowPr = cbxPr.getSelectedIndex();
        int row = tblEmp.getSelectedRow();
        
        int idDep = listDep.get(rowDep).getDepID();
        int idPr = listPr.get(rowPr).getPrID();

        Student emp = new Student();
            emp.setUsername(listEMP.get(row).getUsername());
            emp.setPassword(pass);
            emp.setFullName(FName);
            emp.setAge(Age);
            emp.setAddress(Addrss);
            emp.setPhone(Phone);
            emp.setDepID(idDep);
            emp.setPrID(idPr);
        if(empDll.update(emp)){
             JOptionPane.showMessageDialog(this, "Cập nhật thành công.!");
            Binding();
        }else{
            JOptionPane.showMessageDialog(this, "Cập nhật lỗi.!");
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        if (tblEmp.getSelectedRow() != -1) {
            int row = tblEmp.getSelectedRow();
            listEMP = empDll.getALL();

            if (empDll.delete(listEMP.get(row).getUsername())) {
                JOptionPane.showMessageDialog(this, "Xóa thành công.!");
                Binding();
            } else {
                JOptionPane.showMessageDialog(this, "Xóa không thành công.!");
            }
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void cbxDepActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxDepActionPerformed

    }//GEN-LAST:event_cbxDepActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;

                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Main.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Main.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Main.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Main.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Main().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox cbxDep;
    private javax.swing.JComboBox cbxPr;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane1;
    protected static javax.swing.JLabel lblUser;
    private javax.swing.JTable tblEmp;
    private javax.swing.JTextField txtAddress;
    private javax.swing.JTextField txtAge;
    private javax.swing.JTextField txtFname;
    private javax.swing.JTextField txtPass;
    private javax.swing.JTextField txtPhone;
    private javax.swing.JTextField txtUser;
    // End of variables declaration//GEN-END:variables
}