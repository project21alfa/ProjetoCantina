package tela.Consulta;

import dao.DAOProduto;
import entidades.Produto;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import tela.alterar.TelaAlterarProduto;

public class TelaConsultaProduto extends javax.swing.JInternalFrame {
    
    private List<Produto> listProd = new ArrayList<>();
    private DAOProduto dao = new DAOProduto();
    
    public TelaConsultaProduto() {
        initComponents();
        attBox();
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
        btnProduto = new javax.swing.JButton();

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
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tabela.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                tabelaMouseReleased(evt);
            }
        });
        jScrollPane1.setViewportView(tabela);

        jScrollPane2.setViewportView(txtNome);

        btnProduto.setText("Pesquisar");
        btnProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProdutoActionPerformed(evt);
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
                .addComponent(btnProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(53, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnProduto))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 334, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProdutoActionPerformed
        listProd = dao.listByNameSearch(txtNome.getText().trim());
        attBox();
    }//GEN-LAST:event_btnProdutoActionPerformed

    private void miAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miAlterarActionPerformed
        Produto p = listProd.get(tabela.getSelectedRow());

        TelaAlterarProduto telaAP = new TelaAlterarProduto(null, true, p);
        telaAP.setVisible(true);
        updateTable();
    }//GEN-LAST:event_miAlterarActionPerformed

    private void miExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miExcluirActionPerformed
        if (tabela.getSelectedRow() != -1) {

            int confirm = JOptionPane.showConfirmDialog(null, "Deseja realmente excluir?",
                "ATENÇÃO!!!", JOptionPane.YES_NO_OPTION);

            if (confirm == JOptionPane.YES_OPTION) {
                Produto p = listProd.get(tabela.getSelectedRow());
                dao.excluir(p.getId());
            }
            attBox();
        }
    }//GEN-LAST:event_miExcluirActionPerformed

    private void tabelaMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaMouseReleased
        if(evt.getButton() == evt.BUTTON3 && tabela.getSelectedRow() != -1){
            
             popupMenu.show(tabela, evt.getX(), evt.getY());
        }
    }//GEN-LAST:event_tabelaMouseReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnProduto;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JMenuItem miAlterar;
    private javax.swing.JMenuItem miExcluir;
    private javax.swing.JPopupMenu popupMenu;
    private javax.swing.JTable tabela;
    private javax.swing.JTextPane txtNome;
    // End of variables declaration//GEN-END:variables
    private void attBox(){
        DefaultTableModel modelo = new DefaultTableModel(){
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
            
        };
     
        modelo.addColumn("Nome");
        modelo.addColumn("Qtde Estoque");
        modelo.addColumn("Categoria");
        modelo.addColumn("Preço Compra");
        modelo.addColumn("Preço Venda");
        listProd = dao.listarPrduto();
        
        for(Produto p : listProd){
            
            modelo.addRow(new Object[]{
                p.getNome(),
                p.getQuantEstoque(),
                p.getCategoria().getNome(),
                p.getPrecoCompra(),
                p.getPrecoVenda()
            
            });
            tabela.setModel(modelo);
        }
    }
    private void updateTable(){
        DefaultTableModel modelo = new DefaultTableModel(){
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
            
        };
     
        modelo.addColumn("Nome");
        modelo.addColumn("Qtde Estoque");
        modelo.addColumn("Categoria");
        modelo.addColumn("Preço Compra");
        modelo.addColumn("Preço Venda");
        
        for(Produto p : listProd){
            
            modelo.addRow(new Object[]{
                p.getNome(),
                p.getQuantEstoque(),
                p.getCategoria().getNome(),
                p.getPrecoCompra(),
                p.getPrecoVenda()
            
            });
            tabela.setModel(modelo);
        }
    }
}
