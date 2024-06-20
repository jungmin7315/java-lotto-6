package view;

import camp.nextstep.edu.missionutils.Console;
import controller.Controller;
import model.Lotto;
import model.Money;

import java.util.ArrayList;
import java.util.List;

public class Input {
    private static final int MIN_MONEY = 1000;
    private static final int UNIT_MONEY = 1000;
    private static final int MIN_LOTTO_NUMBER = 1;
    private static final int MAX_LOTTO_NUMBER = 45;
    private Controller controller;

    public Input(Controller controller) {
        this.controller = controller;
    }

    public void Money(){
        try{
            System.out.println("구입금액을 입력해 주세요.");
            int money = sumthing();
            if(moneyVaildate(money) && checkUnit(money)){
                controller.setMoney(money);
                controller.addLotto(money/UNIT_MONEY);
                return;
            }
            Money();
        } catch (IllegalArgumentException e){
            System.out.println("[ERROR] 숫자를 입력해주세요.");
            Money();
        }
    }

    public int sumthing(){
        int number = 0;
        try{
            number = Integer.parseInt(Console.readLine());
        } catch (NumberFormatException e){
            throw new IllegalArgumentException();
        }
        return number;
    }

    private boolean moneyVaildate(int money){
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

    private boolean checkUnit(int money){
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

    private int winnigSumthing(String number){
        int winningNum = 0;
        try{
            winningNum = Integer.parseInt(number);
        } catch (NumberFormatException e){
            System.out.println("[ERROR] 숫자를 입력해주세요");
            throw new IllegalArgumentException();
        }
        return winningNum;
    }

    public void winnigLotto(){
        try{
            winnigInput();
            System.out.println();
        } catch (IllegalArgumentException e) {
            winnigLotto();
        }
    }

    private void winnigInput(){
        System.out.println("당첨 번호를 입력해 주세요.");

        String lotto = Console.readLine();
        String[] number = lotto.split(",");
        List<Integer> numbers = new ArrayList<>();

        for(int i = 0 ; i < number.length ; i++){
            numbers.add(winnigSumthing(number[i]));
        }
        if(winnigVaildate(numbers)){
            controller.addWinnigLotto(numbers);
            return;
        }
        winnigInput();
    }

    private boolean winnigVaildate(List<Integer> numbers){
        try {
            for(int number:numbers){
                minMax(number);
            }
            return true;
        } catch (IllegalArgumentException e){
            System.out.println("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
            return false;
        }
    }
    private void minMax(int number){
        if(!(number >= MIN_LOTTO_NUMBER && number <= MAX_LOTTO_NUMBER)){
            throw new IllegalArgumentException();
        }
    }

    public void bonusNumber(){
        try{
            System.out.println("보너스 번호를 입력해 주세요.");
            int bonusNumber = Integer.parseInt(Console.readLine());
            if(bounsDuplication(bonusNumber) && bounsVaildate(bonusNumber)){
                controller.addBonus(bonusNumber);
                System.out.println();
                return;
            }
            bonusNumber();
        } catch (NumberFormatException e){
            System.out.println("[ERROR] 숫자 한개를 입력해주세요");
            bonusNumber();
        }
    }

    private boolean bounsDuplication(int bonusNumber){
        try {
            Lotto winnig = controller.getWinning();
            for(int number: winnig.getNumbers()){
                numberDuplication(number,bonusNumber);
            }
            return true;
        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR] 중복된 숫자는 입력하실 수 없습니다.");
            return false;
        }
    }

    private void numberDuplication(int number,int bonusNumber){
        if(number == bonusNumber){
            throw new IllegalArgumentException();
        }
    }

    private boolean bounsVaildate(int bonusNumber){
        try {
            minMax(bonusNumber);
            return true;
        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR] 보너스 번호는 1부터 45 사이의 숫자여야 합니다.");
            return false;
        }
    }
}