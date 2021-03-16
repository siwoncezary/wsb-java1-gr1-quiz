package pl.wsb.quiz.exercises.functional;

public class BonusApp {
    public static void main(String[] args) {
        Bonus birthBonus = new BirthBonus();
        System.out.println(birthBonus.calculate(100));
        //Klasa anonimowa
        Bonus anonymousBonus = new Bonus() {
            @Override
            public int calculate(int price) {
                return (price * 90) / 100;
            }
        };
        //Wyrażenie lambda do implementacji interfejsu funkcyjnego
        Bonus lambdaBonus = price -> (price * 90) / 100;
        Bonus nextLambda = price -> {
            System.out.println("LAMBDA");
            return (price * 90) / 100;
        };

    }
}
