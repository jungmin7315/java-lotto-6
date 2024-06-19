package controller;

import camp.nextstep.edu.missionutils.Randoms;
import model.Lotto;
import model.Money;
import Enum.Reward;

import java.util.*;

public class Controller {
    private List<Lotto> lottos = new ArrayList<>();
    private Lotto winning;
    private int bonus;
    private Money money = new Money(0);
    private Money totalRewards = new Money(0);

    public void setMoney(int price){
        this.money.setPrice(price);
    }

    public int getMoney(){
        return this.money.getPrice();
    }

    public Lotto getWinning(){
        return this.winning;
    }

    public int getTotalRewards(){
        return this.totalRewards.getPrice();
    }

    public void addLotto(int count){
        try{
            for(int i = 0; i < count; i++){
                List<Integer> lotto = Randoms.pickUniqueNumbersInRange(1, 45, 6);
                Lotto numbers = new Lotto(numberSort(lotto));
                this.lottos.add(numbers);
            }
        } catch (IllegalArgumentException e){
            e.printStackTrace();
        } catch (IllegalStateException e){
            e.printStackTrace();
        }
    }

    public void addWinnigLotto(List<Integer> numbers){
        this.winning = new Lotto(numberSort(numbers));
    }

    public void addBonus(int bonus){
        this.bonus = bonus;
    }

    public int getBonus(){
        return bonus;
    }

    private List<Integer> numberSort(List<Integer> numbers){
        Collections.sort(numbers);

        return numbers;
    }

    public List<Lotto> lottoList(){
        return this.lottos;
    }

    public LinkedHashMap<Reward, Integer> winningStatistics(){
        LinkedHashMap<Reward, Integer> rewardsCounts = rewardsCount(rewards());

        return rewardsCounts;
    }

    private LinkedHashMap<Reward,Integer> rewardsCount(List<Reward> rewards){
        LinkedHashMap<Reward,Integer> rewardCount = new LinkedHashMap<>();
        int price = 0;

        for(Reward reward : Reward.values()){
            rewardCount.put(reward,0);
        }
        for(Reward reward : rewards){
            rewardCount.put(reward,rewardCount.get(reward)+1);
            price += reward.getAmount();
        }

        totalRewards.setPrice(price);

        return rewardCount;
    }

    private List<Reward> rewards(){
        List<Reward> rewards = new ArrayList<>();
        List<Integer> bonusList = bonusConfirmationList();
        List<Integer> lottoList = winningConfirmationList();

        for(int i = 0; i < lottoList.size(); i++){
            if(rewardCheck(lottoList.get(i), bonusList.get(i)) != null){
                rewards.add(rewardCheck(lottoList.get(i), bonusList.get(i)));
            }
        }

        return rewards;
    }

    private Reward rewardCheck(int lotto, int bonus){
        if(lotto == 5){
            if(bonus == 1){
                return Reward.SECOND;
            }
            return Reward.THIRD;
        }

        for(Reward result : Reward.values()){
            if(lotto == result.getNumber()){
                return result;
            }
        }

        return null;
    }

    private List<Integer> bonusConfirmationList(){
        List<Integer> bonusList = new ArrayList<>();

        for(Lotto lotto:lottos){
            for (int number:lotto.getNumbers()){
                bonusList.add(checkNumber(bonus, number));
            }
        }

        return bonusList;
    }

    private List<Integer> winningConfirmationList(){
        List<Integer> checkedList = new ArrayList<>();

        for(Lotto lotto:lottos){
            int count = winnerConfirmation(lotto.getNumbers());
            checkedList.add(count);
        }

        return checkedList;
    }


    private int winnerConfirmation(List<Integer> lotto){
        int count = 0;
        for(int i = 0; i < lotto.size(); i++){
            for(int j = 0; j < lotto.size(); j++){
                count += checkNumber(lotto.get(i), winning.getNumbers().get(j));
            }
        }

        return count;
    }

    private int checkNumber(int i, int j){
        int count = 0;

        if(i == j){
            count = 1;
        }

        return count;
    }

    public double totalReturn(){
        return ((double)totalRewards.getPrice()/money.getPrice()) * 100.0;
    }
//    LinkedHashMap
}
