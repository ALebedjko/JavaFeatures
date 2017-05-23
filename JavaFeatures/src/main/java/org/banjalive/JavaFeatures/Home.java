package main.java.org.banjalive.JavaFeatures;

/**
 * Created by a.lebedjko on 2017.01.28..
 */
public class Home {

    public static void main(String[] args) {
        String s;
        s = "text";
        double d = 1.0;
        int a = 123;

        int $myInt = 1;
        int _myInt = 1;
//        int #myIny = 1;

        System.out.println($myInt);


        String s1 = "text2";

        int x = setInteger2();
        System.out.println("This is x = " + x);

        double pi = pi();
        System.out.println(pi);

    }

    public static double pi() {
        return 3.14;
    }

    public static int setInteger2(){
        return 2;
    }
}
