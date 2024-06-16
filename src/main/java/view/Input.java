package view;

import camp.nextstep.edu.missionutils.Console;
import controller.Controller;

public class Input {
    private static final int MIN_MONEY = 1000;
    private static final int UNIT_MONEY = 1000;
    Controller controller;

    public Input(Controller controller) {
        this.controller = controller;
    }

    public void Money(){
        System.out.println("구입금액을 입력해 주세요.");
        int money = Integer.parseInt(Console.readLine());
        if(MoneyVaildate(money) && CheckUnit(money)){
            controller.setMoney(money);
            controller.addLotto(money/UNIT_MONEY);
            System.out.println();
            return;
        }
        Money();
    }

    private boolean MoneyVaildate(int money){
        try{
            if(money >= MIN_MONEY){
                return true;
            }
            throw new IllegalArgumentException();
        }catch(IllegalArgumentException e){
            System.out.println("[ERROR] 1000원 이상으로 금액을 입력해주세요.");
            return false;
        }
    }

    private boolean CheckUnit(int money){
        try{
            if(money%UNIT_MONEY == 0){
                return true;
            }
            throw new IllegalArgumentException();
        } catch (IllegalArgumentException e){
            System.out.println("[ERROR] 1000원 단위로 금액을 입력해주세요.");
            return false;
        }
    }
}
