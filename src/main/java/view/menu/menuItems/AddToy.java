package view.menu.menuItems;

import view.View;
import view.menu.MenuItem;

public class AddToy extends MenuMethod {

    public AddToy(View view) {
        super(view);
    }

    @Override
    public String description() {
        return "Добавить игрушку";
    }

    @Override
    public void run() {
        getView().addToy();
    }
}
