/*
 * ProcurarServico.java
 * 
 * Copyright � 2014 Rog�rio Eduardo Pereira <rogeriopereira.info@gmail.com>. 
 * 
 * This file is part of AssistenciaTecnica.
 * 
 * AssistenciaTecnica is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * 
 * AssistenciaTecnica is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with AssistenciaTecnica.  If not, see <http ://www.gnu.org/licenses/>.
 */

package assistenciatecnica.view;

import assistenciatecnica.control.ControladorPeca;
import assistenciatecnica.control.ControladorServico;
import assistenciatecnica.control.util.ControladorTabelas;
import assistenciatecnica.model.Pecas;
import assistenciatecnica.model.Servicos;
import java.awt.Component;
import java.awt.Container;
import java.awt.event.ContainerEvent;
import java.awt.event.ContainerListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.text.DecimalFormat;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Rog�rio Eduardo Pereira
 * Data Cria��o: Jun 18, 2014
 */
public class ProcurarPecas extends javax.swing.JFrame implements KeyListener, ContainerListener
{

    /** Creates new form ProcurarServico */
    public ProcurarPecas() {
        initComponents();

        //Adiciona Listeners de Bot�es
        addKeyAndContainerListenerRecursively(this);

	this.setLocationRelativeTo(null);
	
	this.configuraTabelas();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents()
    {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        textoNome = new javax.swing.JTextField();
        botaoPesquisar = new javax.swing.JButton();
        botaoSelecionar = new javax.swing.JButton();
        btoaoCancelar = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelaPecas = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Procurar Pe�as");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(95, 133, 169), null), "Filtros", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP));

        jLabel1.setText("Nome");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(textoNome)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(0, 177, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(textoNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(60, Short.MAX_VALUE))
        );

        botaoPesquisar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assistenciatecnica/view/img/magnifier.png"))); // NOI18N
        botaoPesquisar.setText("Pesquisar");
        botaoPesquisar.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                botaoPesquisarActionPerformed(evt);
            }
        });

        botaoSelecionar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assistenciatecnica/view/img/accept.png"))); // NOI18N
        botaoSelecionar.setText("Selecionar");
        botaoSelecionar.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                botaoSelecionarActionPerformed(evt);
            }
        });

        btoaoCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assistenciatecnica/view/img/edit-delete-4.png"))); // NOI18N
        btoaoCancelar.setText("Cancelar");
        btoaoCancelar.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btoaoCancelarActionPerformed(evt);
            }
        });

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(95, 133, 169), null), "Resultado", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP));

        tabelaPecas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][]
            {

            },
            new String []
            {
                "Codigo", "Pe�a", "Valor"
            }
        )
        {
            boolean[] canEdit = new boolean []
            {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex)
            {
                return canEdit [columnIndex];
            }
        });
        tabelaPecas.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        jScrollPane1.setViewportView(tabelaPecas);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 193, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(botaoSelecionar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btoaoCancelar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(botaoPesquisar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(botaoPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(botaoSelecionar, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btoaoCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btoaoCancelarActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_btoaoCancelarActionPerformed
    {//GEN-HEADEREND:event_btoaoCancelarActionPerformed
		this.dispose();
    }//GEN-LAST:event_btoaoCancelarActionPerformed

    private void botaoPesquisarActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_botaoPesquisarActionPerformed
    {//GEN-HEADEREND:event_botaoPesquisarActionPerformed
		this.apagaTabela();
		
		this.control	=  new ControladorPeca();
		this.pecas	= this.control.buscaPecas(this.textoNome.getText());
		
		this.insereDados(this.pecas);
    }//GEN-LAST:event_botaoPesquisarActionPerformed

    private void botaoSelecionarActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_botaoSelecionarActionPerformed
    {//GEN-HEADEREND:event_botaoSelecionarActionPerformed
		if(tabelaPecas.getSelectedRow() != -1)
		{
			if(janela.getTitle() == "Cadastro de Pe�as")
			{
				janelaCadastroPecas = (CadastroPecas) janela;
				janelaCadastroPecas.limpaTela();
				janelaCadastroPecas.getPecaByCodigo(Long.parseLong(tabelaPecas.getValueAt(tabelaPecas.getSelectedRow(), 0).toString()));
			}
            else if(janela.getTitle() == "Ordem de Servi�o")
			{
				janelaOrdemDeServico = (OrdemDeServico) janela;
				janelaOrdemDeServico.insertProduto(Long.parseLong(tabelaPecas.getValueAt(tabelaPecas.getSelectedRow(), 0).toString()));
			}

			this.dispose();
		}
    }//GEN-LAST:event_botaoSelecionarActionPerformed


    /*
     * M�todos da Classe
     */
    
    //METODOS KEYLISTENER
    //KEYLISTENER RECURSIVO (COLOCA EM TODOS OS COMPONENTES)
    private void addKeyAndContainerListenerRecursively(Component c) 
    {  
        try 
        {  
            c.addKeyListener(this);  
            if (c instanceof Container) 
            {  
                Container cont = (Container) c;  
                cont.addContainerListener(this);  
                Component[] children = cont.getComponents();  
                for (int i = 0; i < children.length; i++) 
                {  
                    addKeyAndContainerListenerRecursively(children[i]);  
                }  
            }  
        } catch (Exception e) {  
            //Anuncie Aqui  
        }  
    }  

    //EVENTOS KEYLISTENER
    public void keyTyped(KeyEvent e) {}  
    public void keyReleased(KeyEvent e) {}  
    public void componentAdded(ContainerEvent e) {}  
    public void componentRemoved(ContainerEvent e) {}  
    public void keyPressed(KeyEvent e) 
    {
        //TECLA ENTER
        if(e.getKeyCode() == KeyEvent.VK_ENTER)
        {
		botaoPesquisar.doClick();
        }

        //TECLA ESC
        if(e.getKeyCode() == KeyEvent.VK_ESCAPE)
        {
            this.Fechar();
        }
    }
    
    /*
     * M�todo Fechar()
     * Fecha Janela
     */
    private void Fechar()
    {
        this.dispose();
    }
	
	/*
	 * M�todo
	 */
	private void configuraTabelas()
	{
		DefaultTableCellRenderer alinhamento = new DefaultTableCellRenderer();
		alinhamento.setHorizontalAlignment(SwingConstants.LEFT);
		this.tabelaPecas.getColumnModel().getColumn(0).setCellRenderer(alinhamento);
		
		this.tabelaPecas.getColumnModel().getColumn(0).setPreferredWidth(80); 
		this.tabelaPecas.getColumnModel().getColumn(1).setPreferredWidth(165); 
		this.tabelaPecas.getColumnModel().getColumn(2).setPreferredWidth(70); 
	}
	
	/*
	 * M�todo apaga tabela
	 * Apaga a tabela
	 */
	private void apagaTabela()
	{
		ControladorTabelas.apagaTabela(this.tabelaPecas);
	}
	
	/*
	 * M�todo insereDados
	 * insere os dados da busca na tabela
	 */
	public void insereDados(List<Pecas> lista)
	{
		DecimalFormat fmt = new DecimalFormat("#,##0.00");   //limita o n�mero de casas decimais
		
		for(Pecas peca: lista)
		{
			DefaultTableModel modelo = (DefaultTableModel) this.tabelaPecas.getModel();
			modelo.addRow(new String[]	{
										peca.getCodigo().toString(),
										peca.getPeca(),
										"R$ "+fmt.format(peca.getValor())
									});
		}
	}


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
            java.util.logging.Logger.getLogger(ProcurarPecas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ProcurarPecas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ProcurarPecas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ProcurarPecas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ProcurarPecas().setVisible(true);
            }
        });
    }


	public void setJanela (JFrame janela)
	{
		this.janela = janela;
	}

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botaoPesquisar;
    private javax.swing.JButton botaoSelecionar;
    private javax.swing.JButton btoaoCancelar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabelaPecas;
    private javax.swing.JTextField textoNome;
    // End of variables declaration//GEN-END:variables
	private ControladorPeca		control;
	private List<Pecas>		pecas;
	private JFrame				janela;
	private CadastroPecas		janelaCadastroPecas;
    private OrdemDeServico		janelaOrdemDeServico;
}
