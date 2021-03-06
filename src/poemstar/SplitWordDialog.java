package poemstar;

import java.security.SecureRandom;
import java.util.ArrayList;
import org.apache.commons.lang3.time.StopWatch;
import org.pmw.tinylog.Logger;
import poemstar.algorithm.RepeatCalculator;
import poemstar.algorithm.Sentence;
import poemstar.beans.Poem;
import poemstar.beans.PoemWords;
import poemstar.beans.Poems;
import poemstar.fileio.ChromeDictReader;
import poemstar.util.StringUtil;

/**
 * Split words manually
 * @author xinway
 */
public class SplitWordDialog extends javax.swing.JDialog {

    /**
     * Creates new form SplitWordDialog
     */
    public SplitWordDialog(java.awt.Frame parent, boolean modal) {
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

        jButtonClose = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jTextFieldSentence = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jTextFieldRemains = new javax.swing.JTextField();
        jTextFieldResult = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jButtonOne = new javax.swing.JButton();
        jButtonTwo = new javax.swing.JButton();
        jButtonThree = new javax.swing.JButton();
        jButtonFour = new javax.swing.JButton();
        jButtonNext = new javax.swing.JButton();
        jButtonManual = new javax.swing.JButton();
        jButtonGood = new javax.swing.JButton();
        jLabelStatus = new javax.swing.JLabel();
        jButtonAutoDivide = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jButtonClose.setText("Close");
        jButtonClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCloseActionPerformed(evt);
            }
        });

        jLabel1.setText("Sentence:");

        jLabel2.setText("Remains:");

        jLabel3.setText("Result:");

        jButtonOne.setText("单字词");
        jButtonOne.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonOneActionPerformed(evt);
            }
        });

        jButtonTwo.setText("双字词");
        jButtonTwo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonTwoActionPerformed(evt);
            }
        });

        jButtonThree.setText("三字词");
        jButtonThree.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonThreeActionPerformed(evt);
            }
        });

        jButtonFour.setText("四字词");
        jButtonFour.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonFourActionPerformed(evt);
            }
        });

        jButtonNext.setText("Next");
        jButtonNext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonNextActionPerformed(evt);
            }
        });

        jButtonManual.setText("Manual");
        jButtonManual.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonManualActionPerformed(evt);
            }
        });

        jButtonGood.setText("Good");
        jButtonGood.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonGoodActionPerformed(evt);
            }
        });

        jLabelStatus.setText("jLabel4");

        jButtonAutoDivide.setText("自动分词");
        jButtonAutoDivide.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAutoDivideActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabelStatus, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jTextFieldRemains, javax.swing.GroupLayout.PREFERRED_SIZE, 474, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButtonManual))
                    .addComponent(jLabel3)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jTextFieldResult, javax.swing.GroupLayout.PREFERRED_SIZE, 474, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButtonGood, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButtonOne)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonTwo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonThree)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButtonFour)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonAutoDivide))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jTextFieldSentence, javax.swing.GroupLayout.PREFERRED_SIZE, 474, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButtonNext, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 47, Short.MAX_VALUE)
                .addComponent(jButtonClose)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldSentence, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonNext))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldRemains, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonManual))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldResult, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonGood))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonOne)
                    .addComponent(jButtonTwo)
                    .addComponent(jButtonThree)
                    .addComponent(jButtonFour)
                    .addComponent(jButtonAutoDivide))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 210, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonClose)
                    .addComponent(jLabelStatus))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCloseActionPerformed
    }//GEN-LAST:event_jButtonCloseActionPerformed

    private void jButtonOneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonOneActionPerformed
        curSentence_.setChar(1);
        syncDisplay();
    }//GEN-LAST:event_jButtonOneActionPerformed

    private void jButtonTwoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonTwoActionPerformed
        curSentence_.setChar(2);
        syncDisplay();
    }//GEN-LAST:event_jButtonTwoActionPerformed

    private void jButtonThreeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonThreeActionPerformed
        curSentence_.setChar(3);
        syncDisplay();
    }//GEN-LAST:event_jButtonThreeActionPerformed

    private void jButtonFourActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonFourActionPerformed
        curSentence_.setChar(4);
        syncDisplay();
    }//GEN-LAST:event_jButtonFourActionPerformed

    private void jButtonNextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonNextActionPerformed
        curPos_++;
        jLabelStatus.setText("Sentences: " + curPos_ + " of " + allSentences_.size());

        if (curPos_ >= allSentences_.size()) {
            return;
        }

        String s = allSentences_.get(curPos_);
        curSentence_ = new Sentence(s);
        jTextFieldSentence.setText(s);
    }//GEN-LAST:event_jButtonNextActionPerformed

    private void jButtonManualActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonManualActionPerformed
    }//GEN-LAST:event_jButtonManualActionPerformed

    private void jButtonGoodActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonGoodActionPerformed
    }//GEN-LAST:event_jButtonGoodActionPerformed

    private void jButtonAutoDivideActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAutoDivideActionPerformed
        ChromeDictReader reader = new ChromeDictReader();
        PoemWords pw = new PoemWords();
        reader.init(pw);

        for (String s : allSentences_) {
            pw.parseSentence2(s);
        }

        //pw.saveWordstoFile("chinesesplitresult.txt");
        pw.savetoFile("splitcounterresult.txt");
    }//GEN-LAST:event_jButtonAutoDivideActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        setLocationRelativeTo(null);
    }//GEN-LAST:event_formWindowOpened

    private void syncDisplay() {
        if (curSentence_ == null) {
            return;
        }
        jTextFieldRemains.setText(curSentence_.getRemains());
        jTextFieldResult.setText(curSentence_.getResult());

        //ChineseWords.INSTANCE.addWord(curSentence_.getCurrentWord());
    }

    public void parseAllPoems(Poems val) {
        StopWatch sw = new StopWatch();
        sw.start();
        
        ChromeDictReader reader = new ChromeDictReader();
        PoemWords pw = new PoemWords();
        reader.init(pw);
        sw.split();        
        Logger.info(sw.toSplitString());
        
        RepeatCalculator rc = new RepeatCalculator();

        SecureRandom random = new SecureRandom();
        ArrayList<Integer> parsed = new ArrayList<>();
        int i = 0;
        while (i < 8000) {
            int pos = random.nextInt(val.getCount());
            
            if (parsed.contains(pos)) {
                //i++;
            }
            else {
                parsed.add(pos);
                
                Poem p = val.getAt(pos);
                
                initSentences(p);

                for (String s : allSentences_) {
                    pw.parseSentence2(s);
                    rc.addSentence(s);
                }
                
                pw.addPoemDelimeter();
                i++;
            }
        }

        sw.split();
        Logger.info(sw.toSplitString());
                
        pw.savetoFile("splitcounterresult.txt");
        pw.saveVersestoFile("word2verses.txt");
        pw.saveSplitResults();
        rc.saveFile("autospiltresult.txt", pw);
        sw.stop();
        
        Logger.info("Split completete. Time cost: " + sw.toString());
    }

    void initSentences(Poem poem) {
        if (poem == null) {
            return;
        }

        allSentences_.clear();

        for (String s : poem.getAllSubSentences()) {
            if (!StringUtil.isNullOrEmpty(s)) {
                allSentences_.add(s);
            }
        }
    }
    Sentence curSentence_;
    int curPos_ = 0;
    ArrayList<String> allSentences_ = new ArrayList<>();
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAutoDivide;
    private javax.swing.JButton jButtonClose;
    private javax.swing.JButton jButtonFour;
    private javax.swing.JButton jButtonGood;
    private javax.swing.JButton jButtonManual;
    private javax.swing.JButton jButtonNext;
    private javax.swing.JButton jButtonOne;
    private javax.swing.JButton jButtonThree;
    private javax.swing.JButton jButtonTwo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabelStatus;
    private javax.swing.JTextField jTextFieldRemains;
    private javax.swing.JTextField jTextFieldResult;
    private javax.swing.JTextField jTextFieldSentence;
    // End of variables declaration//GEN-END:variables
}
