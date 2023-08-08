package view;


import model.Toy;
import view.menu.Menu;
import presenter.Presenter;
import view.menu.menuItems.*;

import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class ConsoleUI implements View{
    private Presenter presenter;
    private boolean isRun = true;

    private Scanner s;

    public ConsoleUI(){
        s = new Scanner(System.in);
    }

    @Override
    public void setPresenter(Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void showToys() {
        var toys = this.presenter.getToys();
        message(toys);
    }

    @Override
    public void addToy() {
        String name = scan("Введите наименование игрушки: ");
        message("Введите вес игрушки для розыгрыша:");
        int weight = inputWeight();
        if (weight > 0) this.presenter.addToy(name, weight);
    }

    @Override
    public void removeToy() {
        message("Введите номер игрушки для удаления ");
        int index  = selectIndex();
        if (index >= 0) this.presenter.removeToy(index);
    }

    // метод раскомментирован

    public int selectIndex(){
        int index = -1;
        if (s.hasNextInt()){
           index = s.nextInt();
           int shopSize = presenter.getShopSize();
           if (index > shopSize) {
              message("Игрушки с таким номером нет в магазине");
           } else if (index <=0) {
               return -1;
           } else {
               index -= 1;
           }
       } else {
           message("Номер должен быть целым числом.");
       }
         return index;
    }

    @Override
    public void changeWeight() {
        message("Введите номер игрушки для изменения веса в розыгрыше");
        int index = selectIndex();
        if (index >=0) {
            int oldWeight = this.presenter.getWeight(index);
            message(String.format("Изменить вес игрушки с %s на", oldWeight));
            int newWeight = inputWeight();
            if (newWeight > 0) this.presenter.updateWeight(index, newWeight);
        }
    }

    public int inputWeight() {
        int weight;
        if (s.hasNextFloat()) {
            weight = s.nextInt();
        } else {
            message("Введено не число. Попробуйте еще раз");
            return 0;
        }
        s.skip(".*\n");
        return weight;
    }

    @Override
    public void start() throws IOException {
        Menu menu = new Menu(this);
        menu.addItem(new ShowToys(this));
        menu.addItem(new AddToy(this));
        menu.addItem(new ChangeWeight(this));
        menu.addItem((new RemoveToy(this)));
        menu.addItem(new PlayPrizes(this));
        menu.addItem(new Exit(this));
        while (isRun){
//            System.out.println("Выберите пункт меню:");
            menu.printMenu();
            int selection = Integer.parseInt(scan("Выберите пункт меню: "));
            menu.getItem(selection).run();
        }
    }

    @Override
    public void exit() {
        try {
            this.presenter.saveShop();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        this.isRun = false;
    }

    @Override
    public void message(String str) {
        System.out.println(str);
    }

    @Override
    public void playPrizes() throws IOException {
        message("Введите количество игрушек для розыгрыша");
        int quantity;
        if (s.hasNextInt()) {
            quantity = s.nextInt();
            Queue<Toy> prizes =this.presenter.playPrizes(quantity);
            LinkedList<String> names = new LinkedList<>();
            for (int i = 0; i < quantity; i++) {
                message(String.format("Для розыгрышша %d игрушки нажмите любую клавишу", i+1));
                s.nextLine();
                Toy toy = prizes.poll();
                String name = toy.getName();
                names.add(name);

            }
            this.presenter.savePrizes(names);
        } else {
            message("Введено не целое число. Попробуйте еще раз");
            return;
        }
        s.skip(".*\n");


    }


    public String scan(String message){
        message(message);
//        s.skip(".*\n");
        return s.nextLine();
    }


}
