package za.co.investec;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.*;
import java.util.stream.Stream;


public class HighestCommonFactor {

    private static final Logger logger = LogManager.getLogger(HighestCommonFactor.class);

    public static void main(String[] args) {

        final List<String> strings = new ArrayList<>();

        if (args.length == 0) {
            Scanner scanner = new Scanner(System.in);
            // Fetch numbers fom System.in
            System.out.println("Enter a list of numbers: ");
            strings.addAll(Arrays.asList(scanner.nextLine().split(" ")));

        } else {
            // Fetch numbers fom args
            strings.addAll(Arrays.asList(args));
        }

        logger.debug(strings);
        greatestCommonFactor(strings);
    }

    public static int greatestCommonFactor(List<String> arguments) {

        final List<Integer> numbers = new ArrayList<>();

        try (Stream<String> stringStream = arguments.stream()) {
            stringStream.forEach(value -> numbers.add(Integer.valueOf(value)));
        }

        Optional<Integer> factor = numbers
                .stream()
                .peek(logger::debug)
                .reduce(HighestCommonFactor::findGreatestCommonFactor);

        factor.ifPresent(highestCommonFactor -> logger.info("Greatest common factor is : " + highestCommonFactor));

        return factor.orElse(0);
    }

    private static int findGreatestCommonFactor(int a, int b) {

        logger.debug("{a : b} = {" + a + " : " + b + "}");

        if (b == 0) {
            return a;
        } else {
            return (findGreatestCommonFactor(b, a % b));
        }
    }
}
