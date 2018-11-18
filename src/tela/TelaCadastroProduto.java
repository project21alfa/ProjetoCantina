package tela;

import dao.DAOCategoria;
import dao.DAOGenerico;
import dao.DAOProduto;
import entidades.Categoria;
import entidades.Produto;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author aluno
 */
public class TelaCadastroProduto extends javax.swing.JInternalFrame {

    /**
     * Creates new form teste
     */
    private List<Categoria> listC = new ArrayList<>();
    DAOCategoria daoC = new DAOCategoria();
    
    private Produto produto = new Produto();
    private List<Produto> listProd = new ArrayList<>();
    
    public TelaCadastroProduto() {
        initComponents();
        attCBox();
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
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        cbCat = new javax.swing.JComboBox<>();
        precoVen = new javax.swing.JTextField();
        precoComp = new javax.swing.JTextField();
        nome = new javax.swing.JTextField();
        qtdeEst = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabela = new javax.swing.JTable();
        JLimpar = new javax.swing.JToggleButton();
        JAdicionar = new javax.swing.JToggleButton();
        JCadastrar = new javax.swing.JToggleButton();

        setClosable(true);

        jLabel1.setText("Nome");

        jLabel2.setText("Preço da Compra");

        jLabel3.setText("Preço da Venda");

        jLabel4.setText("Qtde em Estoque");

        jLabel5.setText("Categoria");

        cbCat.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione Categoria" }));
        cbCat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbCatActionPerformed(evt);
            }
        });

        precoVen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                precoVenActionPerformed(evt);
            }
        });

        precoComp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                precoCompActionPerformed(evt);
            }
        });

        qtdeEst.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                qtdeEstActionPerformed(evt);
            }
        });

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

        JLimpar.setText("Limpar");
        JLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JLimparActionPerformed(evt);
            }
        });

        JAdicionar.setText("Adicionar");
        JAdicionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JAdicionarActionPerformed(evt);
            }
        });

        JCadastrar.setText("Cadastrar Todos");
        JCadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JCadastrarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(JLimpar)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel4)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(52, 52, 52)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(nome, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(qtdeEst, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(154, 154, 154)
                                .addComponent(JAdicionar)
                                .addGap(26, 26, 26))))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(52, 52, 52)
                                .addComponent(precoVen, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(74, 74, 74)
                                .addComponent(precoComp, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(52, 52, 52)
                        .addComponent(cbCat, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(12, 12, 12)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 352, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JCadastrar))
                .addContainerGap(15, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(70, 70, 70)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(nome, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(qtdeEst, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(cbCat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(precoComp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(precoVen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 61, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JAdicionar)
                    .addComponent(JLimpar)
                    .addComponent(JCadastrar))
                .addGap(25, 25, 25))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 262, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cbCatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbCatActionPerformed

    }//GEN-LAST:event_cbCatActionPerformed

    private void precoVenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_precoVenActionPerformed

    }//GEN-LAST:event_precoVenActionPerformed

    private void precoCompActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_precoCompActionPerformed

    }//GEN-LAST:event_precoCompActionPerformed

    private void qtdeEstActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_qtdeEstActionPerformed

    }//GEN-LAST:event_qtdeEstActionPerformed

    private void JLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JLimparActionPerformed
      limparCampos();

    }//GEN-LAST:event_JLimparActionPerformed

    private void JAdicionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JAdicionarActionPerformed
        if(!nome.getText().trim().isEmpty()&&
           !qtdeEst.getText().trim().isEmpty()&&
           !precoComp.getText().trim().isEmpty()&&
           !precoVen.getText().trim().isEmpty()&&
           cbCat.getSelectedIndex() != 0){
           
            Produto produto = new Produto();
            Categoria ccc = new Categoria();
            DAOProduto dp = new DAOProduto();
            
            produto.setNome(nome.getText().trim().toUpperCase());
            produto.setQuantEstoque(Integer.parseInt(qtdeEst.getText().trim()));
            produto.setPrecoCompra(Integer.parseInt(precoComp.getText().trim()));
            produto.setPrecoVenda(Integer.parseInt(precoVen.getText().trim()));
            ccc =dp.findByNomeC(cbCat.getSelectedItem().toString());
            produto.setCategoria(ccc);
                   
            
            listProd.add(produto);
            limparCampos();
            updateTable();
         }
        
             
         else {
            JOptionPane.showMessageDialog(null,"ERRO: Preencha todos os Campos","ERRO!!",JOptionPane.ERROR_MESSAGE);
                 }

    }//GEN-LAST:event_JAdicionarActionPerformed

    private void JCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JCadastrarActionPerformed
        DAOGenerico daoG = new DAOGenerico();

        for(Produto p : listProd){

            daoG.salvar(p);

        }

        listProd = new ArrayList<>();
        updateTable();
        limparCampos();


        JOptionPane.showMessageDialog(null,"salvo");
    }//GEN-LAST:event_JCadastrarActionPerformed

    
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
    private void limparCampos(){
        nome.setText("");
        qtdeEst.setText("");
        cbCat.setSelectedIndex(0);
        precoComp.setText("");
        precoVen.setText("");
        
        
    }
     private void attCBox() {
        
        listC = daoC.listarCategoria();
        for (Categoria cat : listC) {
            cbCat.addItem(cat.getNome());
        }
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton JAdicionar;
    private javax.swing.JToggleButton JCadastrar;
    private javax.swing.JToggleButton JLimpar;
    private javax.swing.JComboBox<String> cbCat;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField nome;
    private javax.swing.JTextField precoComp;
    private javax.swing.JTextField precoVen;
    private javax.swing.JTextField qtdeEst;
    private javax.swing.JTable tabela;
    // End of variables declaration//GEN-END:variables
    public Produto prod(){
        
        return produto;
    }
}
