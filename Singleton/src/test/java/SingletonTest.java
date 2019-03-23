import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SingletonTest {

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
        Singleton instanceOne = Singleton.getInstance();

        //when
        // Serialize to a file
        ObjectOutput out = new ObjectOutputStream(new FileOutputStream(
                "filename.ser"));
        out.writeObject(instanceOne);
        out.close();

        instanceOne.setText("Singleton One");

        // Deserialize from file to object
        ObjectInput in = new ObjectInputStream(new FileInputStream(
                "filename.ser"));
        Singleton instanceTwo = (Singleton) in.readObject();
        in.close();

        //then
        System.out.println(instanceOne.getText());
        System.out.println(instanceTwo.getText());

        assertEquals(instanceOne.getText(), instanceTwo.getText());
    }
}
