package view.menu.menuItems;

import view.View;

public class ShowToys extends MenuMethod {

    public ShowToys(View view) {
        super(view);
    }

    @Override
    public String description() {
        return "Просмотреть игрушки";
    }

    @Override
    public void run() {
        getView().showToys();
    }
}