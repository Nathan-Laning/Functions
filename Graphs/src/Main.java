import java.util.ArrayList;
import functions.*;
//
public class Main {
    public static <E> void main(String[] args) {
        Steiner S = new Steiner();
//        S.STS(7);
        output.display(S.generateAllPossibleCombinations(3,3));
    }
}
