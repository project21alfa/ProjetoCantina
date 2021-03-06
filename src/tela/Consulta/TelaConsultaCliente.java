package tela.Consulta;

import dao.DAOCliente;
import entidades.Cliente;
import entidades.Estado;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import tela.alterar.TelaAlterarCliente;

public class TelaConsultaCliente extends javax.swing.JInternalFrame {

    private DAOCliente dao = new DAOCliente();
    private List<Cliente> listCliente = new ArrayList<>();

    public TelaConsultaCliente() {
        initComponents();
        attCBox();
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

        miAlterar.setText("alterar");
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
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "nome", "Title 2", "Title 3", "Title 4", "null", "Título 6"
            }
        ));
        tabela.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                tabelaMouseReleased(evt);
            }
        });
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
            .addGroup(layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 321, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(46, 46, 46)
                .addComponent(btnPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(53, Short.MAX_VALUE))
            .addComponent(jScrollPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(21, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnPesquisar))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 334, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void miAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miAlterarActionPerformed
        Cliente c = listCliente.get(tabela.getSelectedRow());
        
        TelaAlterarCliente telaAC = new TelaAlterarCliente(null, true, c);
        telaAC.setVisible(true);
        attCBox();
    }//GEN-LAST:event_miAlterarActionPerformed

    private void miExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miExcluirActionPerformed
        if (tabela.getSelectedRow() != -1) {

            int confirm = JOptionPane.showConfirmDialog(null, "Deseja realmente excluir?",
                    "ATENÇÃO!!!", JOptionPane.YES_NO_OPTION);

            if (confirm == JOptionPane.YES_OPTION) {
                Cliente c = listCliente.get(tabela.getSelectedRow());
                dao.excluir(c.getId());
            }
           attCBox();
        }
    }//GEN-LAST:event_miExcluirActionPerformed

    private void btnPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPesquisarActionPerformed
 
        updateTable(txtNome.getText());
    }//GEN-LAST:event_btnPesquisarActionPerformed

    private void tabelaMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaMouseReleased
        if(evt.getButton() == evt.BUTTON3 && tabela.getSelectedRow() != -1){
            
             popupMenu.show(tabela, evt.getX(), evt.getY());
        }
    }//GEN-LAST:event_tabelaMouseReleased


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
    private void attCBox() {
          DefaultTableModel modelo = new DefaultTableModel(){
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }

        };

        modelo.addColumn("Nome");
        //modelo.addColumn("Cidade");
        //modelo.addColumn("Estado");
        modelo.addColumn("Email");
        modelo.addColumn("Telefone");
        modelo.addColumn("CPF");
        
        listCliente = dao.listarCliente();
        
        for (Cliente c : listCliente) {
               modelo.addRow(new Object[]{
                c.getNome(),
              // c.getCidade().getNome(),
              //  c.getCidade().getEstado().getNome(),
                c.getEmail(),
                c.getTelefone(),
                c.getCpf()
            });
           tabela.setModel(modelo);
                
        }
    }
    private void updateTable(String nome) {

        DefaultTableModel modelo = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }

        };

        modelo.addColumn("Nome");
        //modelo.addColumn("Cidade");
        //modelo.addColumn("Estado");
        modelo.addColumn("Email");
        modelo.addColumn("Telefone");
        modelo.addColumn("CPF");
        
        listCliente = dao.listByNameSearch(nome);
        
        for (Cliente c : listCliente) {

            modelo.addRow(new Object[]{
                c.getNome(),
                //c.getCidade().getNome(),
                //c.getCidade().getEstado().getNome(),
                c.getEmail(),
                c.getTelefone(),
                c.getCpf()
            });

        }

        tabela.setModel(modelo);
    }    
}
