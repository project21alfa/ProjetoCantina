package tela;

import dao.DAOEstado;
import dao.DAOGenerico;
import entidades.Cidade;
import entidades.Cliente;
import entidades.Estado;
import entidades.Fornecedor;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.MaskFormatter;

public class TelaCadastroFornecedor extends javax.swing.JInternalFrame {

    private List<Fornecedor> listFornecedor = new ArrayList<>();
    private Cidade cidade = new Cidade();
    private Estado estado = new Estado();
    private List<Estado> listE = new ArrayList<>();
    DAOEstado daoE = new DAOEstado();
    DAOGenerico<Fornecedor> daoP = new DAOGenerico<Fornecedor>();
    Fornecedor fornecedor = new Fornecedor();
    
    
    public TelaCadastroFornecedor() {
        initComponents();
        updateTable();
        setMask();
       
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        popupMenu = new javax.swing.JPopupMenu();
        editar = new javax.swing.JMenuItem();
        deletar = new javax.swing.JMenuItem();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtNome = new javax.swing.JTextField();
        txtCidade = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabela = new javax.swing.JTable();
        cbEstado = new javax.swing.JComboBox<>();
        btnPesquisar = new javax.swing.JButton();
        txtEmail = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        btnLimpar = new javax.swing.JButton();
        btnAdicionar = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        ftxtTelefone = new javax.swing.JFormattedTextField();
        btnCadastrarTodos = new javax.swing.JButton();
        ftxtCnpj = new javax.swing.JFormattedTextField();

        editar.setText("Editar");
        editar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editarActionPerformed(evt);
            }
        });
        popupMenu.add(editar);

        deletar.setText("Deletar");
        deletar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deletarActionPerformed(evt);
            }
        });
        popupMenu.add(deletar);

        setClosable(true);
        setTitle("Cadastro Fornecedor");

        jLabel1.setText("Nome");

        jLabel2.setText("CNPJ");

        jLabel3.setText("Email");

        jLabel5.setText("Estado");

        jLabel6.setText("Cidade");

        txtNome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNomeActionPerformed(evt);
            }
        });

        txtCidade.setEditable(false);

        tabela.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Nome ", "Email", "Cnpj", "Telefone"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tabela.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                tabelaMouseReleased(evt);
            }
        });
        jScrollPane1.setViewportView(tabela);

        cbEstado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione o Estado" }));

        btnPesquisar.setText("Pesquisar");
        btnPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPesquisarActionPerformed(evt);
            }
        });

        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);

        btnLimpar.setText("Limpar");
        btnLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimparActionPerformed(evt);
            }
        });

        btnAdicionar.setText("Adicionar");
        btnAdicionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdicionarActionPerformed(evt);
            }
        });

        jLabel4.setText("Telefone");

        btnCadastrarTodos.setText("Cadastrar Todos");
        btnCadastrarTodos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCadastrarTodosActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(txtEmail, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtNome, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cbEstado, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(txtCidade, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnPesquisar))
                            .addComponent(ftxtTelefone)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnLimpar)
                        .addGap(102, 102, 102)
                        .addComponent(btnAdicionar)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(35, 35, 35)
                        .addComponent(ftxtCnpj)))
                .addGap(18, 18, 18)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 453, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCadastrarTodos))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1)
            .addGroup(layout.createSequentialGroup()
                .addGap(66, 66, 66)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(cbEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(btnPesquisar)
                    .addComponent(txtCidade, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(ftxtCnpj, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(ftxtTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnLimpar)
                    .addComponent(btnAdicionar))
                .addGap(27, 27, 27))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
                .addComponent(btnCadastrarTodos)
                .addGap(26, 26, 26))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAdicionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdicionarActionPerformed
        if(!txtCidade.getText().trim().isEmpty() && 
                !getTelefone().isEmpty() && 
                !txtEmail.getText().trim().isEmpty() &&
                !txtNome.getText().trim().isEmpty() && 
                !getCnpj().isEmpty() &&
                cbEstado.getSelectedIndex() != 1){
            
            Fornecedor fornecedor = new Fornecedor();
                      
            fornecedor.setNome(txtNome.getText().trim().toUpperCase());
            fornecedor.setEmail(txtEmail.getText().trim().toUpperCase());
            fornecedor.setCnpj(getCnpj());
            fornecedor.setTelefone(getTelefone());
            fornecedor.setCidade(cidade);
            
            
            listFornecedor.add(fornecedor);
            limparCampos();
            updateTable();
        }
    }//GEN-LAST:event_btnAdicionarActionPerformed

    private void btnLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimparActionPerformed
        limparCampos();
    }//GEN-LAST:event_btnLimparActionPerformed

    private void btnCadastrarTodosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCadastrarTodosActionPerformed
        DAOGenerico daoG = new DAOGenerico();
        
        for(Fornecedor f : listFornecedor){
            
            daoG.salvar(f);
            
        }
        
        listFornecedor = new ArrayList<>();
        updateTable();
        limparCampos();
        
    }//GEN-LAST:event_btnCadastrarTodosActionPerformed

    private void deletarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deletarActionPerformed
        int confirm = JOptionPane.showConfirmDialog(null, "Realmente deseja excluir?", "Atenção", 
                JOptionPane.YES_NO_OPTION);
        
        if(confirm == JOptionPane.YES_OPTION) listFornecedor.remove(tabela.getSelectedRow());
        
        updateTable();
                
    }//GEN-LAST:event_deletarActionPerformed

    private void tabelaMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaMouseReleased
        if(evt.getButton() == evt.BUTTON3 && tabela.getSelectedRow() != -1){
            
            popupMenu.show(tabela, evt.getX(), evt.getY());
            
        }
    }//GEN-LAST:event_tabelaMouseReleased

    private void btnPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPesquisarActionPerformed
        TelaEscolhaCidade telaEC = new TelaEscolhaCidade(null, true, estado);
        cidade = telaEC.getCidade();
    }//GEN-LAST:event_btnPesquisarActionPerformed

    private void editarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editarActionPerformed
        TelaAlterarFornecedor telaAF = new TelaAlterarFornecedor(null, true, listFornecedor.get(tabela.getSelectedRow()));
        telaAF.setVisible(true);
        listFornecedor.set(tabela.getSelectedRow(), telaAF.getFornecedor());
        updateTable();       
    }//GEN-LAST:event_editarActionPerformed

    private void txtNomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNomeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNomeActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdicionar;
    private javax.swing.JButton btnCadastrarTodos;
    private javax.swing.JButton btnLimpar;
    private javax.swing.JButton btnPesquisar;
    private javax.swing.JComboBox<String> cbEstado;
    private javax.swing.JMenuItem deletar;
    private javax.swing.JMenuItem editar;
    private javax.swing.JFormattedTextField ftxtCnpj;
    private javax.swing.JFormattedTextField ftxtTelefone;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JPopupMenu popupMenu;
    private javax.swing.JTable tabela;
    private javax.swing.JTextField txtCidade;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtNome;
    // End of variables declaration//GEN-END:variables
  
     private void attCBox() {
        
        listE = daoE.listarEstado();
        for (Estado est : listE) {
            cbEstado.addItem(est.getNome());
        }
    }
     private void pesquisar(){
         DefaultTableModel val = (DefaultTableModel) tabela.getModel();
         fornecedor = daoP.findByNomeF(txtNome.getText());
				
         val.addRow(new String[]{fornecedor.getNome(),fornecedor.getEmail(),fornecedor.getCnpj()});
     }
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
  
    private void limparCampos(){
        txtCidade.setText("");
        ftxtCnpj.setText("");
        txtEmail.setText("");
        txtNome.setText("");
        ftxtTelefone.setText("");
        cbEstado.setSelectedIndex(0);
    }
    
    private void setMask(){
        
        try{
            ftxtTelefone.setFormatterFactory(new DefaultFormatterFactory (
                    new MaskFormatter("(##) #####-####")));
            ftxtCnpj.setFormatterFactory(new DefaultFormatterFactory (
                    new MaskFormatter("##.###.###/####-##")));
        }
        catch(ParseException pe){
            pe.printStackTrace();
        }
        
    }
    
    private String getTelefone(){
        
        String telefone = ftxtTelefone.getText().replace("(", "");
        telefone = telefone.replace(")", "");
        telefone = telefone.replace(" ", "");
        telefone = telefone.replace("-", "");
        
        return telefone;
        
    }

    private String getCnpj(){
        
        String cnpj = ftxtCnpj.getText().replace(".", "");
        cnpj = cnpj.replace("/", "");
        cnpj = cnpj.replace("-", "");
        
        return cnpj;
        
    }
    
    
}
