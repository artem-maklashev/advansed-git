package view.menu;

import java.io.IOException;

public interface MenuItem {
    String description();
    void run() throws IOException;
}
