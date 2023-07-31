package view.menu.menuItems;

import view.View;
import view.menu.MenuItem;

import java.io.IOException;

public class PlayPrizes extends MenuMethod {

    public PlayPrizes(View view) {
        super(view);
    }

    @Override
    public String description() {
        return "Разыграть игрушки";
    }

    @Override
    public void run() throws IOException {
        getView().playPrizes();
    }
}
