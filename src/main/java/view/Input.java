package view;

import camp.nextstep.edu.missionutils.Console;

public class Input {
    private static final int MIN_MONEY = 1000;
    private static final int UNIT_MONEY = 1000;

    public int Money(){
        System.out.println("구입금액을 입력해 주세요.");
        int money = Integer.parseInt(Console.readLine());
        try{
            if(!MoneyVaildate(money)){
                System.out.println("[ERROR] 1000원 이상으로 입력해주세요.");
                throw new IllegalArgumentException();
            }
            if(!CheckUnit(money)){
                System.out.println("[ERROR] 1000원 단위로 입력해주세요.");
                throw new IllegalArgumentException();
            }
        } catch (IllegalArgumentException e){
            Money();
        }

        return money;
    }

    private boolean MoneyVaildate(int money){
        if(MIN_MONEY <= money){
            return true;
        }
        return false;
    }

    private boolean CheckUnit(int money){
        if(money%UNIT_MONEY == 0){
            return true;
        }
        return false;
    }
}
