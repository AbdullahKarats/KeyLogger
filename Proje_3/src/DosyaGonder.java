
import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Timer;
import java.util.TimerTask;
import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

public class DosyaGonder {

    private String dosyaYolu;
    private String mailAdresi;
    private long periyot;
    //Java Mail APIsı kullanılmıştır. Bir önceki ödevde verdiğiniz otomatik mail gönderen uygulamada kullandığımız
    //kodu modifiye ederek burada tekrar kullandık.
    //activation.jar ve javax.mail.jar ekte verilmiştir. Kütüphaneye eklenmeleri gerekiyor.
    public DosyaGonder(String dosyaYolu, String mailAdresi, long periyot) {
        this.dosyaYolu = dosyaYolu;
        this.mailAdresi = mailAdresi;
        this.periyot = periyot;
    }

    public void baslat() {
        Timer timer = new Timer();
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                try {
                    dosyayiGonder();
                    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
                    LocalDateTime now = LocalDateTime.now();
                    System.out.println("Mail Gönderildi." +dtf.format(now));
                    Ana_Ekran.jLabel5.setText("Mail Gönderildi." +dtf.format(now));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };
        timer.scheduleAtFixedRate(task, 0, periyot);
    }

    private void dosyayiGonder() throws MessagingException, IOException {
        File dosya = new File(dosyaYolu);
        if (!dosya.exists()) {
            System.out.println("Dosya bulunamadı: " + dosyaYolu);
            return;
        }

        // E-posta gönderme işlemi için gerekli bilgileri ayarlayın
        // Google Gmail Less Secure App özelliğini devredışı bıraktığı için aşağıdaki adımları takip etmeniz gerekiyor.
        /*
1-Gmail hesabınızda iki adımlı doğrulamanın açık olduğundan emin olun.

2-Gmail Hesabınızın ayarlarından 'Uygulama Şifreleri' bölümüne giriş yapın.

3-Diğer seçeneğiyle Uygulama şifresi oluşturun. //https://prnt.sc/wbYiL5ooTuYl

4-16 rakamlı uygulama şifrenizi kopyalayın.//https://prnt.sc/ZRKtdBpv49eS

5-Java Mail API kod bloğunda bulunan 'sifre' Stringine tek kullanımlık şifreyi yapıştırın.//https://prnt.sc/Y4hmR2wuP0a8*/
        String host = "smtp.gmail.com";
        String kullaniciAdi = "abdullahkaratas2002@gmail.com";
        String sifre = "ugzv nhdc svbv gbqh\n";//Uyguluma şifresi buraya girilecek.

        // E-posta gönderme işlemi için gerekli özellikleri ayarlayın
        java.util.Properties properties = System.getProperties();
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.host", host);
        properties.put("mail.smtp.user", kullaniciAdi);
        properties.put("mail.smtp.password", sifre);
        properties.put("mail.smtp.port", "587");
        properties.put("mail.smtp.auth", "true");

        // Oturum açın ve e-posta gönderme işlemini gerçekleştirin
        Session session = Session.getDefaultInstance(properties);
        MimeMessage mesaj = new MimeMessage(session);
        mesaj.setFrom(new InternetAddress(kullaniciAdi));
        mesaj.addRecipient(Message.RecipientType.TO, new InternetAddress(mailAdresi));
        mesaj.setSubject("Dosya Gönderimi");
        mesaj.setText("Merhaba,\n\nBu e-posta otomatik olarak gönderilmiştir.");

        // Dosyayı e-posta ekinde gönder
        Multipart multipart = new MimeMultipart();
        String filename = "log.txt";
        BodyPart dosyaEki = new MimeBodyPart();
        DataSource source = new FileDataSource(filename);
        dosyaEki.setDataHandler(new DataHandler(source));
        dosyaEki.setFileName(filename);
        multipart.addBodyPart(dosyaEki);
        mesaj.setContent(multipart);

        // E-postayı gönder
        Transport transport = session.getTransport("smtp");
        transport.connect(host, kullaniciAdi, sifre);
        transport.sendMessage(mesaj, mesaj.getAllRecipients());
        transport.close();

    }

    public static void main(String[] args) {

    }
}
