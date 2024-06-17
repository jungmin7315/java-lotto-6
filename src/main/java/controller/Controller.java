package controller;

import camp.nextstep.edu.missionutils.Randoms;
import model.Lotto;
import model.Money;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Controller {
    private List<Lotto> lottos = new ArrayList<>();
    private Lotto winning;
    private int bonus;
    private Money money = new Money(0);

    public void setMoney(int price){
        this.money.setPrice(price);
    }

    public int getMoney(){
        return this.money.getPrice();
    }

    public Lotto getLotto(){
        return this.winning;
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

    private List<Integer> numberSort(List<Integer> numbers){
        numbers.sort(Comparator.naturalOrder());

        return numbers;
    }

    public List<Lotto> lottoList(){
        return this.lottos;
    }
}
