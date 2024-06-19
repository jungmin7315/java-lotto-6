package view;

import controller.Controller;
import model.Lotto;
import Enum.Reward;

import java.util.LinkedHashMap;
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
        System.out.println();
    }

    public void winningStatistics(){

        System.out.println("당첨 통계");
        System.out.println("---");
        LinkedHashMap<Reward,Integer> rewardsCounts = controller.winningStatistics();
        for(int i = Reward.values().length-1; i >=0; i--){
            System.out.println(Reward.values()[i].getMessage()+" - "+rewardsCounts.get(Reward.values()[i])+"개");
        }
    }

    public void totalReturn(){
        double totalReturn = controller.totalReturn();
        System.out.printf("총 수익률은 %.1f%% 입니다", totalReturn);
    }
}
