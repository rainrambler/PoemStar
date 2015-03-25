package poemstar;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import javax.swing.DefaultListModel;
import javax.swing.JFileChooser;
import javax.swing.ListModel;
import javax.swing.filechooser.FileFilter;
import org.apache.commons.io.FileUtils;
import org.pmw.tinylog.Logger;
import poemstar.beans.ISearchResults;
import poemstar.beans.Poems;
import poemstar.beans.QueryCondition;
import poemstar.beans.SearchResult;
import poemstar.fileio.PoemsDBManager;
import poemstar.util.DateTimeUtils;

/**
 * Main UI
 *
 * @author Xinway
 */
public class MainJDialog extends javax.swing.JDialog {

    /**
     * Creates new form MainJDialog
     * @param parent
     * @param modal
     */
    public MainJDialog(java.awt.Frame parent, boolean modal) {
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

        buttonGroupDynasty = new javax.swing.ButtonGroup();
        jScrollPaneLog = new javax.swing.JScrollPane();
        jListResult = new javax.swing.JList();
        jLabelDynasty = new javax.swing.JLabel();
        jRadioButtonPrevTang = new javax.swing.JRadioButton();
        jRadioButtonTang = new javax.swing.JRadioButton();
        jRadioButtonPrevSong = new javax.swing.JRadioButton();
        jRadioButtonSong = new javax.swing.JRadioButton();
        jRadioButtonYuan = new javax.swing.JRadioButton();
        jRadioButtonMingQing = new javax.swing.JRadioButton();
        jRadioButtonJinXiandai = new javax.swing.JRadioButton();
        jLabelAuthor = new javax.swing.JLabel();
        jComboBoxAuthor = new javax.swing.JComboBox();
        jButtonClearAuthor = new javax.swing.JButton();
        jLabelKeyword = new javax.swing.JLabel();
        jTextFieldKeyword = new javax.swing.JTextField();
        jButtonQuery = new javax.swing.JButton();
        jLabelStatus = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextAreaContent = new javax.swing.JTextArea();
        jButtonSplitWord = new javax.swing.JButton();
        jButtonModify = new javax.swing.JButton();
        jButtonExport = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("PoemStar");
        setLocationByPlatform(true);
        setModal(true);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jListResult.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jListResultMouseClicked(evt);
            }
        });
        jScrollPaneLog.setViewportView(jListResult);

        jLabelDynasty.setText("朝代：");

        buttonGroupDynasty.add(jRadioButtonPrevTang);
        jRadioButtonPrevTang.setText("唐以前");

        buttonGroupDynasty.add(jRadioButtonTang);
        jRadioButtonTang.setText("唐");

        buttonGroupDynasty.add(jRadioButtonPrevSong);
        jRadioButtonPrevSong.setText("宋以前");

        buttonGroupDynasty.add(jRadioButtonSong);
        jRadioButtonSong.setText("宋");

        buttonGroupDynasty.add(jRadioButtonYuan);
        jRadioButtonYuan.setText("元");

        buttonGroupDynasty.add(jRadioButtonMingQing);
        jRadioButtonMingQing.setText("明清");

        buttonGroupDynasty.add(jRadioButtonJinXiandai);
        jRadioButtonJinXiandai.setText("近现代");

        jLabelAuthor.setText("作者：");

        jButtonClearAuthor.setText("清空");
        jButtonClearAuthor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonClearAuthorActionPerformed(evt);
            }
        });

        jLabelKeyword.setText("关键字：");

        jButtonQuery.setText("查询");
        jButtonQuery.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonQueryActionPerformed(evt);
            }
        });

        jTextAreaContent.setColumns(20);
        jTextAreaContent.setFont(new java.awt.Font("Microsoft YaHei UI", 0, 16)); // NOI18N
        jTextAreaContent.setRows(5);
        jScrollPane1.setViewportView(jTextAreaContent);

        jButtonSplitWord.setText("分词");
        jButtonSplitWord.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSplitWordActionPerformed(evt);
            }
        });

        jButtonModify.setText("修改");
        jButtonModify.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonModifyActionPerformed(evt);
            }
        });

        jButtonExport.setText("导出");
        jButtonExport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonExportActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1)
                    .addComponent(jScrollPaneLog, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelStatus, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(jLabelKeyword)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jTextFieldKeyword, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButtonQuery))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabelDynasty)
                                    .addComponent(jLabelAuthor))
                                .addGap(28, 28, 28)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jRadioButtonPrevTang)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jRadioButtonTang)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jRadioButtonPrevSong)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jRadioButtonSong)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jRadioButtonYuan)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jRadioButtonMingQing)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jRadioButtonJinXiandai))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jComboBoxAuthor, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jButtonClearAuthor)))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonExport)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 179, Short.MAX_VALUE)
                        .addComponent(jButtonModify)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButtonSplitWord)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelDynasty)
                    .addComponent(jRadioButtonPrevTang)
                    .addComponent(jRadioButtonTang)
                    .addComponent(jRadioButtonPrevSong)
                    .addComponent(jRadioButtonSong)
                    .addComponent(jRadioButtonYuan)
                    .addComponent(jRadioButtonMingQing)
                    .addComponent(jRadioButtonJinXiandai))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelAuthor)
                    .addComponent(jComboBoxAuthor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonClearAuthor))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelKeyword)
                    .addComponent(jTextFieldKeyword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonQuery)
                    .addComponent(jButtonSplitWord)
                    .addComponent(jButtonModify)
                    .addComponent(jButtonExport))
                .addGap(18, 18, 18)
                .addComponent(jScrollPaneLog, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabelStatus)
                .addGap(43, 43, 43))
        );

        jLabelDynasty.getAccessibleContext().setAccessibleName("Dynasty");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    ISearchResults results_;

    private void jButtonQueryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonQueryActionPerformed
        QueryCondition qc = QueryCondition.createQueryCondition(jTextFieldKeyword.getText());

        Poems pms = PoemsDBManager.INSTANCE.getPoems();
        results_ = pms.findPoems(qc);

        DefaultListModel resultList = new DefaultListModel();
        jListResult.setModel(resultList);
        //jListResult

        int curPos = 0; // for the relationship between UI list position and the poem

        for (String keyword : results_.getKeywords()) {
            Collection<SearchResult> srs = results_.getResults(keyword);
            resultList.addElement(keyword + " founded: " + srs.size());
            curPos++;
        }

        for (String keyword : results_.getKeywords()) {
            resultList.addElement("--------------------");
            curPos++;
            Collection<SearchResult> srs = results_.getResults(keyword);
            for (SearchResult sr : srs) {
                resultList.addElement(sr.getDescription());
                results_.addIndextoResult(curPos, sr);
                curPos++;
            }
        }

        // TODO: Save UI result to a txt file
    }//GEN-LAST:event_jButtonQueryActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        setLocationRelativeTo(null);
        //ChineseWords.INSTANCE.loadFromFile("D:\\chinesewords.txt");
        Logger.info("{}: PoemStart started.", DateTimeUtils.getTimeDesc());
        PoemsDBManager.INSTANCE.init();
        jLabelStatus.setText("Read from DB complete! Count: " + PoemsDBManager.INSTANCE.getPoems().getCount());
        Logger.info("{}: Read from DB complete!", DateTimeUtils.getTimeDesc());
    }//GEN-LAST:event_formWindowOpened

    private void jListResultMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jListResultMouseClicked
        final int curIndex = jListResult.getSelectedIndex();

        if (curIndex == -1) {
            jTextAreaContent.setText("");
        } else {
            SearchResult sr = results_.FindResult(curIndex);

            if (sr != null) {
                String result = sr.getDesc() + "\r\n";
                result += sr.getAllSentences();
                jTextAreaContent.setText(result);
            }
        }
    }//GEN-LAST:event_jListResultMouseClicked

    private void jButtonSplitWordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSplitWordActionPerformed
        SplitWordDialog dlg = new SplitWordDialog(null, true);

        dlg.parseAllPoems(PoemsDBManager.INSTANCE.getPoems());
        dlg.setVisible(true);
    }//GEN-LAST:event_jButtonSplitWordActionPerformed

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        //ChineseWords.INSTANCE.saveToFile("D:\\chinesewords.txt");
        PoemsDBManager.INSTANCE.close();
    }//GEN-LAST:event_formWindowClosed

    private void jButtonClearAuthorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonClearAuthorActionPerformed

    }//GEN-LAST:event_jButtonClearAuthorActionPerformed

    private void jButtonModifyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonModifyActionPerformed
        ModifyPoemJDialog dlg = new ModifyPoemJDialog(null, true);
        dlg.setVisible(true);
    }//GEN-LAST:event_jButtonModifyActionPerformed

    private void jButtonExportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonExportActionPerformed

        fc.addChoosableFileFilter(new FileFilter() {

            @Override
            public boolean accept(File f) {
                if (f.isDirectory()) {
                    return true;
                }
                return f.getName().endsWith(".txt");
            }

            @Override
            public String getDescription() {
                return "*.txt";
            }

        });

        int returnVal = fc.showSaveDialog(this);

        if (returnVal != JFileChooser.APPROVE_OPTION) {
            return;
        }
        File f = fc.getSelectedFile();

            //jListResult
        //FileUtils.writeLines(f, allSentences_);
        ArrayList<String> allSentences = new ArrayList<>();

        ListModel listModel = jListResult.getModel();
        for (int i = 0; i < listModel.getSize(); i++) {
            allSentences.add(listModel.getElementAt(i).toString());
        }

        try {
            FileUtils.writeLines(f, allSentences);
        } catch (IOException ex) {
            Logger.error(ex);
        }
    }//GEN-LAST:event_jButtonExportActionPerformed

    //Create a file chooser
    final JFileChooser fc = new JFileChooser();

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroupDynasty;
    private javax.swing.JButton jButtonClearAuthor;
    private javax.swing.JButton jButtonExport;
    private javax.swing.JButton jButtonModify;
    private javax.swing.JButton jButtonQuery;
    private javax.swing.JButton jButtonSplitWord;
    private javax.swing.JComboBox jComboBoxAuthor;
    private javax.swing.JLabel jLabelAuthor;
    private javax.swing.JLabel jLabelDynasty;
    private javax.swing.JLabel jLabelKeyword;
    private javax.swing.JLabel jLabelStatus;
    private javax.swing.JList jListResult;
    private javax.swing.JRadioButton jRadioButtonJinXiandai;
    private javax.swing.JRadioButton jRadioButtonMingQing;
    private javax.swing.JRadioButton jRadioButtonPrevSong;
    private javax.swing.JRadioButton jRadioButtonPrevTang;
    private javax.swing.JRadioButton jRadioButtonSong;
    private javax.swing.JRadioButton jRadioButtonTang;
    private javax.swing.JRadioButton jRadioButtonYuan;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPaneLog;
    private javax.swing.JTextArea jTextAreaContent;
    private javax.swing.JTextField jTextFieldKeyword;
    // End of variables declaration//GEN-END:variables
}
