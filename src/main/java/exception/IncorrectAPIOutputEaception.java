package exception;

import java.io.IOException;

public class IncorrectAPIOutputEaception extends IOException {
    public IncorrectAPIOutputEaception(String msg) {
        super(msg);
    }

    public IncorrectAPIOutputEaception() {

    }
}
