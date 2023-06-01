
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.Charset;


public class dosyayaz {
    
    private final String DosyaAdi;
    private Ana_Ekran arayuz;
    
    public dosyayaz() throws IOException {
        DosyaAdi = "log.txt";
      
    }
    
    public void veriYaz(String veri) {
        try (FileWriter writer = new FileWriter(DosyaAdi, Charset.forName("UTF-8"), true)) {
            writer.write(veri + "\n");
            
            if (dosyaboyut_kontrol(DosyaAdi) > Ana_Ekran.max_file) {
                temizle(DosyaAdi);
                System.out.println("Dosya boyut limitine geldi. Dosya Temizleniyor..");
            }
            
        } catch (IOException e) {
            System.out.println("Dosyaya yazma hatası: " + e.getMessage());
        }
    }
    
    public void temizle(String dosyaAdi) {
        try (FileWriter writer = new FileWriter(dosyaAdi)) {
            writer.write("");
            System.out.println("Dosya temizlendi: " + dosyaAdi);
        } catch (IOException e) {
            System.out.println("Dosya temizleme hatası: " + e.getMessage());
        }
    }
    
    public long dosyaboyut_kontrol(String dosyaAdi) {
        File dosya = new File(dosyaAdi);        
        
        if (dosya.exists()) {            
            return dosya.length();            
            
        } else {
            return -1;
        }
    }
}
