package poemstar;

import poemstar.beans.Poem;
import poemstar.fileio.PoemsDBManager;

/**
 *
 * @author xinway
 */
public class ModifyPoemJDialog extends javax.swing.JDialog {

    /**
     * Creates new form ModifyPoemJDialog
     * @param parent
     * @param modal
     */
    public ModifyPoemJDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
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

        jLabelDynasty = new javax.swing.JLabel();
        jTextFieldDynasty = new javax.swing.JTextField();
        jTextFieldAuthor = new javax.swing.JTextField();
        jLabelAuthor = new javax.swing.JLabel();
        jTextFieldTitle = new javax.swing.JTextField();
        jLabelTitle = new javax.swing.JLabel();
        jButtonQuery = new javax.swing.JButton();
        jButtonModify = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextAreaContent = new javax.swing.JTextArea();
        jLabelLog = new javax.swing.JLabel();
        jButtonAddPoem = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabelDynasty.setText("年代：");

        jLabelAuthor.setText("作者：");

        jLabelTitle.setText("标题：");

        jButtonQuery.setText("查询");
        jButtonQuery.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonQueryActionPerformed(evt);
            }
        });

        jButtonModify.setText("修改");
        jButtonModify.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonModifyActionPerformed(evt);
            }
        });

        jTextAreaContent.setColumns(20);
        jTextAreaContent.setRows(5);
        jScrollPane1.setViewportView(jTextAreaContent);

        jButtonAddPoem.setText("添加");
        jButtonAddPoem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAddPoemActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jLabelLog, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jScrollPane1)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(jLabelDynasty)
                                .addGap(18, 18, 18)
                                .addComponent(jTextFieldDynasty, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabelAuthor)
                                .addGap(18, 18, 18)
                                .addComponent(jTextFieldAuthor, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(jLabelTitle)
                                .addGap(18, 18, 18)
                                .addComponent(jTextFieldTitle)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButtonQuery, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButtonModify, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButtonAddPoem, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(18, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelDynasty)
                    .addComponent(jTextFieldDynasty, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelAuthor)
                    .addComponent(jTextFieldAuthor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelTitle)
                    .addComponent(jTextFieldTitle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonQuery))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButtonModify)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButtonAddPoem))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 346, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabelLog)
                .addContainerGap(26, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonQueryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonQueryActionPerformed
        String dynasty = jTextFieldDynasty.getText();
        String author = jTextFieldAuthor.getText();
        String title = jTextFieldTitle.getText();
        
        Poem p = PoemsDBManager.INSTANCE.findPoem(dynasty, author, title);
        
        if (p == null) {
            jLabelLog.setText("Can not find poem.");
            return;
        }
        
        jTextAreaContent.setText(p.getContent());
    }//GEN-LAST:event_jButtonQueryActionPerformed

    private void jButtonModifyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonModifyActionPerformed
        String dynasty = jTextFieldDynasty.getText();
        String author = jTextFieldAuthor.getText();
        String title = jTextFieldTitle.getText();
        String content = jTextAreaContent.getText();
        
        boolean result = PoemsDBManager.INSTANCE.modifyPoemContent(dynasty, author, title, content);
        
        if (result) {
            jLabelLog.setText("Modify poem complete.");
        }
        else {
            jLabelLog.setText("Modify poem failure.");
        }
    }//GEN-LAST:event_jButtonModifyActionPerformed

    private void jButtonAddPoemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAddPoemActionPerformed
        String dynasty = jTextFieldDynasty.getText();
        String author = jTextFieldAuthor.getText();
        String title = jTextFieldTitle.getText();
        String content = jTextAreaContent.getText();
        
        String res = PoemsDBManager.INSTANCE.addPoemContent(dynasty, author, title, content);
        jLabelLog.setText(res);
    }//GEN-LAST:event_jButtonAddPoemActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAddPoem;
    private javax.swing.JButton jButtonModify;
    private javax.swing.JButton jButtonQuery;
    private javax.swing.JLabel jLabelAuthor;
    private javax.swing.JLabel jLabelDynasty;
    private javax.swing.JLabel jLabelLog;
    private javax.swing.JLabel jLabelTitle;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextAreaContent;
    private javax.swing.JTextField jTextFieldAuthor;
    private javax.swing.JTextField jTextFieldDynasty;
    private javax.swing.JTextField jTextFieldTitle;
    // End of variables declaration//GEN-END:variables
}
