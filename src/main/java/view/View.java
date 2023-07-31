package view;

import presenter.Presenter;

import java.io.IOException;

public interface View {
    void setPresenter(Presenter presenter);
    void showToys();
    void addToy();
    void removeToy();
    void changeWeight();
    void start() throws IOException;
    void exit();
    void message(String str);
    void playPrizes() throws IOException;
}
