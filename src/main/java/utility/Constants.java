package utility;

public class Constants {
    /**
     * Variables to be a set of predefined constants.
     */
    public enum Temperature {
        STANDART, IMPERIAL, METRIC;

        public static Temperature getTempByDefault() {
            return STANDART;
        }
    }
}
