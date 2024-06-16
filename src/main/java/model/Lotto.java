package model;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        duplication(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    // TODO: 추가 기능 구현
    private void duplication(List<Integer> numbers) {
        for(int i = 0; i < numbers.size(); i++){
            for(int j = i + 1; j < numbers.size(); j++){
                duplicationCheck(numbers.get(i), numbers.get(j));
            }
        }
    }

    private void duplicationCheck(int a, int b) {
        if(a==b){
            throw new IllegalStateException();
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
