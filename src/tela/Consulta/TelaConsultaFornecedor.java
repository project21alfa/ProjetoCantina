package tela.Consulta;

import dao.DAOFornecedor;
import entidades.Fornecedor;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import tela.alterar.TelaAlterarFornecedor;

public class TelaConsultaFornecedor extends javax.swing.JInternalFrame {

    private List<Fornecedor> listFornecedor = new ArrayList<>();
    private DAOFornecedor dao = new DAOFornecedor();
    
    public TelaConsultaFornecedor() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        popupMenu = new javax.swing.JPopupMenu();
        miAlterar = new javax.swing.JMenuItem();
        miExcluir = new javax.swing.JMenuItem();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabela = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtNome = new javax.swing.JTextPane();
        btnPesquisar = new javax.swing.JButton();

        miAlterar.setText("jMenuItem1");
        miAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miAlterarActionPerformed(evt);
            }
        });
        popupMenu.add(miAlterar);

        miExcluir.setText("Excluir");
        miExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miExcluirActionPerformed(evt);
            }
        });
        popupMenu.add(miExcluir);

        setClosable(true);

        tabela.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tabela);

        jScrollPane2.setViewportView(txtNome);

        btnPesquisar.setText("Pesquisar");
        btnPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPesquisarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
            .addGroup(layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 321, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(46, 46, 46)
                .addComponent(btnPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(53, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(21, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnPesquisar))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(74, 74, 74))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPesquisarActionPerformed
        listFornecedor = dao.listByNameSearch(txtNome.getText().trim());
        updateTable();
    }//GEN-LAST:event_btnPesquisarActionPerformed

    private void miAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miAlterarActionPerformed
        Fornecedor f = listFornecedor.get(tabela.getSelectedRow());

        TelaAlterarFornecedor telaAC = new TelaAlterarFornecedor(null, true, f);
        telaAC.setVisible(true);
        f = telaAC.getFornecedor();
        dao.alterar(f);
        updateTable();
    }//GEN-LAST:event_miAlterarActionPerformed

    private void miExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miExcluirActionPerformed
        if (tabela.getSelectedRow() != -1) {

            int confirm = JOptionPane.showConfirmDialog(null, "Deseja realmente excluir?",
                "ATENÇÃO!!!", JOptionPane.YES_NO_OPTION);

            if (confirm == JOptionPane.YES_OPTION) {
                Fornecedor f = listFornecedor.get(tabela.getSelectedRow());
                dao.excluir(f.getId());
            }
            updateTable();
        }
    }//GEN-LAST:event_miExcluirActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnPesquisar;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JMenuItem miAlterar;
    private javax.swing.JMenuItem miExcluir;
    private javax.swing.JPopupMenu popupMenu;
    private javax.swing.JTable tabela;
    private javax.swing.JTextPane txtNome;
    // End of variables declaration//GEN-END:variables
    
    private void updateTable(){
        DefaultTableModel modelo = new DefaultTableModel(){
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
            
        };
     
        modelo.addColumn("Nome");
        modelo.addColumn("Cidade");
        modelo.addColumn("Estado");
        modelo.addColumn("Email");
        modelo.addColumn("Telefone");
        modelo.addColumn("CNPJ");
        
        for(Fornecedor f : listFornecedor){
            
            modelo.addRow(new Object[]{
                f.getNome(),
                f.getCidade().getNome(),
                f.getCidade().getEstado().getNome(),
                f.getEmail(),
                f.getTelefone(),
                f.getCnpj()
            
            });
            
        }       
        
        tabela.setModel(modelo);      
      
    }

}
