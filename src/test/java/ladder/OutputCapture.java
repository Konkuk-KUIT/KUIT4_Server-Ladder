package ladder;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class OutputCapture {
    private final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    public void start() {
        System.setOut(new PrintStream(outputStream));
    }

    public String stop() {
        System.setOut(originalOut);
        return outputStream.toString();
    }

    public static String normalizeOutput(String output) {
        return output.replaceAll("\\s+", " ")
                .replaceAll(" +", " ")
                .trim();
    }
}
