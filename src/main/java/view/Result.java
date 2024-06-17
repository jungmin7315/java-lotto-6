package view;

import controller.Controller;

public class Result {
    public void All(){
        Controller controller = new Controller();
        Input input = new Input(controller);
        Output output = new Output(controller);

        input.Money();
        output.lottoAuantity();
        output.lottoNumbers();
        input.winnigLotto();
    }
}
