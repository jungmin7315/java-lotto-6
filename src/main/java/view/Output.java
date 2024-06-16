package view;

import controller.Controller;
import model.Lotto;

import java.util.List;

public class Output {
    private static final int UNIT_MONEY = 1000;
    Controller controller;

    public Output(Controller controller){
        this.controller = controller;
    }

    public void lottoAuantity(){
        int money = controller.getMoney();
        int number = money/UNIT_MONEY;
        System.out.println(number+"개를 구매했습니다.");
    }

    public void lottoNumbers(){
        List<Lotto> lottos = controller.lottoList();
        for(Lotto lotto : lottos){
            System.out.println(lotto.getNumbers());
        }
    }
}
