import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.lang.reflect.Field;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SingletonTest {

    private static String filename = "filename.ser";

    @BeforeAll
    static void setUpClass() throws IOException {
        System.out.println("Setting all up before tests");
        serializeObject(Singleton.getInstance(), filename);

    }

    @AfterEach
    void tearDown() throws NoSuchFieldException, IllegalAccessException, IOException {
        System.out.println("Tearing down instance");
        Field instance = Singleton.class.getDeclaredField("instance");
        instance.setAccessible(true);
        instance.set(null, null);
        new File(filename).delete();
        serializeObject(Singleton.getInstance(), filename);
    }

    @AfterAll
    static void cleanUp() {
        System.out.println("Deleting files");
        new File(filename).delete();
    }

    @DisplayName("BasicSingletonTest")
    @Test
    void shouldHaveTheSameHashCode() {
        //given
        Singleton instance1 = Singleton.getInstance();
        Singleton instance2 = Singleton.getInstance();

        //when

        //then
        System.out.println("Instance 1 hash: " + instance1.hashCode());
        System.out.println("Instance 2 hash: " + instance2.hashCode());
        assertEquals(instance1.hashCode(), instance2.hashCode());
    }

    @DisplayName("ThreadSafeTest")
    @Test
    void ThreadSafeTest() throws InterruptedException {
        //given
        List<Thread> threads = new ArrayList<>();
        int threadsAmount = 100;

        //when
        for (int i = 0; i < threadsAmount; i++) {
            threads.add(new Thread(new SimpleTread()));
        }

        threads.parallelStream().forEach(thread -> {
            thread.start();
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        //then
        Set<Integer> hashCodes = new HashSet<>(SimpleTread.hashCodes.values());
        System.out.println("All threads ended work");
        assertEquals(SimpleTread.hashCodes.size(), threadsAmount);
        assertEquals(hashCodes.size(), 1);
    }

    @DisplayName("SingletonSerializationTest")
    @Test
    void SingletonSerializationTest() throws IOException, ClassNotFoundException {
        //given
        String instanceOneText = "Singleton One";
        String instanceTwoText = "Singleton Two";
        Singleton instanceOne = Singleton.getInstance();
        instanceOne.setText(instanceOneText);

        //when
        // Serialize to a file
        serializeObject(instanceOne, filename);

        instanceOne.setText(instanceTwoText);
        instanceOne.setLocalDateTime(LocalDateTime.now().plusMinutes(2L));
        System.out.println("Instance: " + instanceOne.getText() + " (hashCode: " + instanceOne.hashCode() + ")" + "timeStamp: " + instanceOne.getLocalDateTime());

        // Deserialize from file to object
        Singleton instanceTwo = deserializeObject(filename);

        //then
        System.out.println("Instance: " + instanceOne.getText() + " (hashCode: " + instanceOne.hashCode() + ")" + "timeStamp: " + instanceOne.getLocalDateTime());
        System.out.println("Instance: " + instanceTwo.getText() + " (hashCode: " + instanceTwo.hashCode() + ")" + "timeStamp: " + instanceTwo.getLocalDateTime());

        System.out.println("Checking text in both objects");
        assertEquals(instanceOne.getText(), instanceTwo.getText());
        System.out.println("Checking both objects have the same hashcode");
        assertEquals(instanceOne.hashCode(), instanceTwo.hashCode());
        System.out.println("Checking that instance has text like serialized text");
        assertEquals(instanceOne.getText(), instanceOneText);
    }

    @DisplayName("shouldNotChangeSingletonInstanceAfterDeserialization")
    @Test
    void shouldNotChangeSingletonInstanceAfterDeserialization() throws IOException, ClassNotFoundException {
        //given
        String text = "Instance One";
        Singleton instanceOne = Singleton.getInstance();
        System.out.println("Instance: " + instanceOne.getText() + " (hashCode: " + instanceOne.hashCode() + ")" + "timeStamp: " + instanceOne.getLocalDateTime());

        //when
        instanceOne.setText(text);
        System.out.println("Instance: " + instanceOne.getText() + " (hashCode: " + instanceOne.hashCode() + ")" + "timeStamp: " + instanceOne.getLocalDateTime());
        Singleton instanceTwo = deserializeObject(filename);

        //then
        System.out.println("Instance: " + instanceOne.getText() + " (hashCode: " + instanceOne.hashCode() + ")" + "timeStamp: " + instanceOne.getLocalDateTime());
        System.out.println("Instance: " + instanceTwo.getText() + " (hashCode: " + instanceTwo.hashCode() + ")" + "timeStamp: " + instanceOne.getLocalDateTime());
        assertEquals(instanceOne.hashCode(), instanceTwo.hashCode());
        assertEquals(instanceOne.getText(), text);

    }

    private static void serializeObject(Singleton instance, String filename) throws IOException {
        ObjectOutput out = new ObjectOutputStream(new FileOutputStream(
                filename));
        out.writeObject(instance);
        out.close();
    }

    private Singleton deserializeObject(String filename) throws IOException, ClassNotFoundException {
        ObjectInput in = new ObjectInputStream(new FileInputStream(
                filename));
        Singleton instance = (Singleton) in.readObject();
        in.close();

        return instance;
    }
}
