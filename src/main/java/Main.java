import model.Shop;
import model.data.DataIO;
import model.data.JsonData;
import presenter.Presenter;
import view.ConsoleUI;
import view.View;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        Shop shop = new Shop();
        View view = new ConsoleUI();
        DataIO dataIO = new JsonData();
        Presenter presenter = new Presenter(view, shop, dataIO);
        view.setPresenter(presenter);
        view.start();
    }
}
