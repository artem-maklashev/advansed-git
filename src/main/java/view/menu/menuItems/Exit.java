package view.menu.menuItems;

import view.View;

public class Exit extends MenuMethod {

    public Exit(View view) {
        super(view);
    }

    @Override
    public String description() {
        return "Выход";
    }

    @Override
    public void run() {
        getView().exit();
    }
}
