package controller;

import camp.nextstep.edu.missionutils.Randoms;
import model.Lotto;
import model.Money;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Controller {
    private List<Lotto> lottos = new ArrayList<>();
    private Money money = new Money(0);

    public void setMoney(int price){
        money.setPrice(price);
    }

    public int getMoney(){
        return money.getPrice();
    }

    public void addLotto(int count){
        try{
            for(int i = 0; i < count; i++){
                Lotto numbers = new Lotto(numberSort());
                lottos.add(numbers);
            }
        } catch (IllegalArgumentException e){
            e.printStackTrace();
        } catch (IllegalStateException e){
            e.printStackTrace();
        }
    }

    public List<Lotto> lottoList(){
        return lottos;
    }

    private List<Integer> numberSort(){
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        numbers.sort(Comparator.naturalOrder());

        return numbers;
    }
}
