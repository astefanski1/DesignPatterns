import java.util.Map;
import java.util.TreeMap;

public class SimpleTread implements Runnable {

    public static Map<String, Integer> hashCodes = new TreeMap<String, Integer>();

    @Override
    public void run() {
        int hashcode = Singleton.getInstance().hashCode();
        synchronized (SimpleTread.class) {
            hashCodes.put(Thread.currentThread().getName(), hashcode);
        }
        System.out.println("Thread ended (hash code:" + hashcode + ")");
    }
}
