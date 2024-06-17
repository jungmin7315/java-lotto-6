package view;

import camp.nextstep.edu.missionutils.Console;
import controller.Controller;

import java.util.ArrayList;
import java.util.List;

public class Input {
    private static final int MIN_MONEY = 1000;
    private static final int UNIT_MONEY = 1000;
    Controller controller;

    public Input(Controller controller) {
        this.controller = controller;
    }

    public void Money(){
        try{
            System.out.println("구입금액을 입력해 주세요.");
            int money = Integer.parseInt(Console.readLine());
            if(MoneyVaildate(money) && CheckUnit(money)){
                controller.setMoney(money);
                controller.addLotto(money/UNIT_MONEY);
                System.out.println();
                return;
            }
            Money();
        } catch (NumberFormatException e){
            System.out.println("[ERROR] 숫자를 입력해주세요.");
            Money();
        }
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

    public void winnigLotto(){
        try{
            winnigInput();
        } catch (NumberFormatException e){
            System.out.println("[ERROR] 숫자를 입력해주세요");
            winnigLotto();
        } catch (IllegalArgumentException e){
            System.out.println("[ERROR] 6개의 번호를 입력해주세요.");
            winnigLotto();
        } catch (IllegalStateException e){
            System.out.println("[ERROR] 중복된 숫자는 입력할 수 없습니다.");
            winnigLotto();
        }
    }

    private void winnigInput(){
        System.out.println("당첨 번호를 입력해 주세요.");
        String lotto = Console.readLine();
        String[] number = lotto.split(",");
        List<Integer> numbers = new ArrayList<>();
        for(int i = 0 ; i < number.length ; i++){
            numbers.add(Integer.parseInt(number[i]));
        }
        controller.addWinnigLotto(numbers);
    }




}
