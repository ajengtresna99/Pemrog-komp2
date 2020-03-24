/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package satu;
import java.io.File;
import java.io.*;
import javax.swing.DefaultListModel;
import java.util.ArrayList;
import javax.swing.UIManager;

/**
 *
 * @author Asus
 */
public class utama extends javax.swing.JFrame {
playlist pl = new playlist();
  
    ArrayList updateList = new ArrayList();
  
    javazoom.jl.player.Player player;
    File simpan;

    /**
     * Creates new form utama
     */
    public utama() {
        initComponents();
    }
    
    void updateList() {
        updateList = pl.getListSong();
        DefaultListModel model =  new DefaultListModel();
        for (int i = 0; i < updateList.size(); i++) {
            int j = i + 1;
            model.add(i, j + " | " + ((File) updateList.get(i)).getName());
        }
        jplaylist.setModel(model);

    }
    
       //panel kontrol

void add(){
    pl.add(this);
    updateList();
}

void remove(){
    try{
        int akandihapus = jplaylist.getLeadSelectionIndex();
        pl.ls.remove(akandihapus);
        updateList();
    }catch(Exception e){
    }
}

void up(){
    try{
        int s1 = jplaylist.getLeadSelectionIndex();
        simpan = (File) pl.ls.get(s1);
        pl.ls.remove(s1);
        pl.ls.add(s1 - 1, simpan );
        updateList();
        jplaylist.setSelectedIndex(s1-1);
    }catch(Exception e){
    }
}

void down(){
    try{
        int s1 = jplaylist.getLeadSelectionIndex();
        simpan = (File) pl.ls.get(s1);
        pl.ls.remove(s1);
        pl.ls.add(s1 + 1, simpan );
        updateList();
        jplaylist.setSelectedIndex(s1+1);
    }catch(Exception e){
    }
}

void open(){
    pl.openPls(this);
    updateList();
}

void save(){
    pl.saveAsPlaylist(this);
    updateList();
}

File play1;
static int a = 0;

void putar(){
    if(a==0){
        try{
            int p1 = jplaylist.getSelectedIndex();
            play1 = (File) this.updateList.get(p1);
            FileInputStream fis = new FileInputStream(play1);
            BufferedInputStream bis = new BufferedInputStream(fis);
            player = new javazoom.jl.player.Player(bis);
            a =1;
        }catch(Exception e){
            System.out.println("Problem playing file");
            System.out.println(e);
        }
      
        new Thread(){
            @Override
            public void run(){
                try{
                    player.play();
              
            }catch (Exception e){
            }
        }
    }.start();
    }else{
        player.close();
        a=0;
        putar();
    }
}


File sa;
void next(){
    if(a==0){
        try{
            int s1 = jplaylist.getSelectedIndex() +1;
            sa = (File) this.pl.ls.get(s1);
            FileInputStream fis = new FileInputStream(sa);
            BufferedInputStream bis = new BufferedInputStream(fis);
            player = new javazoom.jl.player.Player(bis);
            a =1;
            jplaylist.setSelectedIndex(s1);
        }catch(Exception e){
            System.out.println("Problem playing file");
            System.out.println(e);
        }
      
        new Thread(){
            @Override
            public void run(){
                try{
                    player.play();
              
            }catch (Exception e){
            }
        }
    }.start();
    }else{
        player.close();
        a=0;
        next();
    }

}

    void previous(){
    if(a==0){
        try{
            int s1 = jplaylist.getSelectedIndex() -1;
            sa = (File) this.pl.ls.get(s1);
            FileInputStream fis = new FileInputStream(sa);
            BufferedInputStream bis = new BufferedInputStream(fis);
            player = new javazoom.jl.player.Player(bis);
            a =1;
            jplaylist.setSelectedIndex(s1);
        }catch(Exception e){
            System.out.println("Problem playing file");
            System.out.println(e);
        }
      
        new Thread(){
            @Override
            public void run(){
                try{
                    player.play();
              
            }catch (Exception e){
            }
        }
    }.start();
    }else{
        player.close();
        a=0;
        previous();
    }
}

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jplaylist = new javax.swing.JList<>();
        btnadd = new javax.swing.JButton();
        btnDEL = new javax.swing.JButton();
        btnSave = new javax.swing.JButton();
        btnUP = new javax.swing.JButton();
        btnDown = new javax.swing.JButton();
        btnPlay = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jScrollPane1.setViewportView(jplaylist);

        btnadd.setText("+");
        btnadd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnaddActionPerformed(evt);
            }
        });

        btnDEL.setText("DEL");
        btnDEL.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDELActionPerformed(evt);
            }
        });

        btnSave.setText("SAVE");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        btnUP.setText("UP");
        btnUP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUPActionPerformed(evt);
            }
        });

        btnDown.setText("DOWN");
        btnDown.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDownActionPerformed(evt);
            }
        });

        btnPlay.setText("Play");
        btnPlay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPlayActionPerformed(evt);
            }
        });

        jButton1.setText(">");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("<");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(57, 57, 57)
                        .addComponent(jButton2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnPlay)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 337, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(40, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnadd, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnDEL)
                        .addGap(18, 18, 18)
                        .addComponent(btnSave)
                        .addGap(18, 18, 18)
                        .addComponent(btnDown))
                    .addComponent(btnUP, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(47, Short.MAX_VALUE)
                .addComponent(btnUP)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnadd)
                    .addComponent(btnDEL)
                    .addComponent(btnSave)
                    .addComponent(btnDown))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnPlay)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addGap(51, 51, 51))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnDELActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDELActionPerformed
     remove() ;  // TODO add your handling code here:
    }//GEN-LAST:event_btnDELActionPerformed

    private void btnDownActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDownActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnDownActionPerformed

    private void btnaddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnaddActionPerformed
    add();        // TODO add your handling code here:
    }//GEN-LAST:event_btnaddActionPerformed

    private void btnUPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUPActionPerformed
 up();        // TODO add your handling code here:
    }//GEN-LAST:event_btnUPActionPerformed

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
save();        // TODO add your handling code here:
    }//GEN-LAST:event_btnSaveActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
     next();        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
previous();        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    private void btnPlayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPlayActionPerformed
putar();        // TODO add your handling code here:
    }//GEN-LAST:event_btnPlayActionPerformed

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
            java.util.logging.Logger.getLogger(utama.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(utama.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(utama.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(utama.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new utama().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDEL;
    private javax.swing.JButton btnDown;
    private javax.swing.JButton btnPlay;
    private javax.swing.JButton btnSave;
    private javax.swing.JButton btnUP;
    private javax.swing.JButton btnadd;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JList<String> jplaylist;
    // End of variables declaration//GEN-END:variables
}
