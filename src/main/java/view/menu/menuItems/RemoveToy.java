package view.menu.menuItems;

import view.View;

public class RemoveToy extends MenuMethod{
    public RemoveToy(View view) {
        super(view);
    }

    @Override
    public String description() {
        return "Удалить игрушку";
    }

    @Override
    public void run() {
        getView().removeToy();
    }
}
