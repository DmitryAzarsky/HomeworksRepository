import java.io.ByteArrayInputStream;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        byte[] bytes = {127, 30, 50, 70, 99};
        ByteArrayInputStream bais = new ByteArrayInputStream(bytes);
        System.out.println(bais.available());
        while (bais.available() > 0) {
            byte currentByte = (byte) bais.read();
            System.out.println(currentByte);
        }

        bais.close();
    }
}

