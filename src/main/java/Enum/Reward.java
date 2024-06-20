package Enum;

import java.util.LinkedHashMap;

public enum Reward {
    FIRST(6,2000000000,"6개 일치 (2,000,000,000원)"),
    SECOND(5,30000000, "5개 일치, 보너스 볼 일치 (30,000,000원)"),
    THIRD(5,1500000,"5개 일치 (1,500,000원)"),
    FOURTH(4,50000,"4개 일치 (50,000원)"),
    FIFTH(3,5000,"3개 일치 (5,000원)");

    private int number;
    private int amount;
    private String message;

    Reward(int number, int amount, String message) {
        this.number = number;
        this.amount = amount;
        this.message = message;
    }

    public int getNumber() {
        return number;
    }
    public int getAmount() {
        return amount;
    }
    public String getMessage() {
        return message;
    }

//    public Map<Reward, Integer> getReward(List<Integer> numbers, List<Integer> amounts) {
//        Map<Reward,Integer> list = new LinkedHashMap<Enum.Reward, 0>();
//        for(int i = 0; i<numbers.size(); i++ ){
//
//            if(numbers[i] == 5 && amounts[i] ==1 ){
//                list.add(SECOND,++);
//            }
//
//            if(numbers[i] == 6){
//                return FIRST;
//            }
//
//            if(numbers[i] <3){
//                return Miss;
//            }
//
//            if(numbers[i]==amount && amounts[i] == 0){
//                list.add(Reward, ++)
//            }
//        }
//    }
}
