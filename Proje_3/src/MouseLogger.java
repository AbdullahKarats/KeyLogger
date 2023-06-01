
import com.github.kwhat.jnativehook.GlobalScreen;
import com.github.kwhat.jnativehook.NativeHookException;
import com.github.kwhat.jnativehook.mouse.NativeMouseEvent;
import com.github.kwhat.jnativehook.mouse.NativeMouseInputListener;
import java.io.IOException;

public class MouseLogger implements NativeMouseInputListener {

    private boolean isListening;
    private GlobalScreen globalScreen;
    private dosyayaz veriyaz;

    public MouseLogger() throws IOException {
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

                GlobalScreen.addNativeMouseListener(this);
                GlobalScreen.addNativeMouseMotionListener(this);

                isListening = true;
                System.out.println("Mouse dinlemesi başlatıldı.");
            } catch (NativeHookException ex) {
                ex.printStackTrace();
            }
        }
    }

    public void stopListening() throws NativeHookException {
        if (isListening) {
            GlobalScreen.removeNativeMouseListener(this);
            GlobalScreen.removeNativeMouseMotionListener(this);
            GlobalScreen.unregisterNativeHook();
            isListening = false;
            System.out.println("Mouse dinlemesi durduruldu.");
        }
    }

    @Override
    public void nativeMouseReleased(NativeMouseEvent e) {
        String button;
        switch (e.getButton()) {
            case NativeMouseEvent.BUTTON1:
                button = "Sol";
                break;
            case NativeMouseEvent.BUTTON2:
                button = "Sag";
                break;
            case NativeMouseEvent.BUTTON3:
                button = "Orta";
                break;
            default:
                button = "Diger";
                break;
        }

        veriyaz.veriYaz(button + " bırakıldı");
    }

    @Override
    public void nativeMouseMoved(NativeMouseEvent e) {

        veriyaz.veriYaz("Fare hareket etti: " + e.getX() + ", " + e.getY());
    }

    @Override
    public void nativeMousePressed(NativeMouseEvent e) {
        String button;
        switch (e.getButton()) {
            case NativeMouseEvent.BUTTON1:
                button = "Sol";
                break;
            case NativeMouseEvent.BUTTON2:
                button = "Sag";
                break;
            case NativeMouseEvent.BUTTON3:
                button = "Orta";
                break;
            default:
                button = "Diger";
                break;
        }
        String Bilgi = button + "basildi";
        veriyaz.veriYaz(button + "basildi");
    }

    @Override
    public void nativeMouseDragged(NativeMouseEvent e) {
        veriyaz.veriYaz("Fare suruklendi: " + e.getX() + ", " + e.getY());
    }

    public static void main(String[] args) throws IOException {
        new MouseLogger();
    }
}
