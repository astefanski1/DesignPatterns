import java.io.Serializable;
import java.time.LocalDateTime;

public class Singleton implements Serializable {

    private static Singleton instance;
    private String text;
    private LocalDateTime localDateTime = LocalDateTime.now();

    private Singleton() {
    }

    public static Singleton getInstance() {
        if (instance == null) {
            synchronized (Singleton.class) {
                if (instance == null) {
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }

    protected Object readResolve() {
        if (localDateTime.isBefore(getInstance().getLocalDateTime())) {
            if (!localDateTime.isEqual(getInstance().getLocalDateTime())){
                Singleton singleton = getInstance();
                singleton.text = text;
                singleton.localDateTime = localDateTime;
                return singleton;
            }
        }
        return Singleton.getInstance();
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public LocalDateTime getLocalDateTime() {
        return localDateTime;
    }

    public void setLocalDateTime(LocalDateTime localDateTime) {
        this.localDateTime = localDateTime;
    }
}
