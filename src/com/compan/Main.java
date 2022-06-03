package com.compan;

public class Main {

    public static class P extends F {
        private static double a, b, c;

        public P(double a, double b, double c){
            P.a = a;
            P.b = b;
            P.c = c;
        }
        public static void display() {
            double result;
            result = a * Math.pow(b, c);
            System.out.println("Результат: " + result);
        }

    }

    public static class F {
        static double a, b, c;

        public F(double a, double b, double c) {
            F.a = a;
            F.b = b;
            F.c = c;
        }

        public F() {
        }

        static double display2() {
            double s = a * Math.pow (b, c);
            System.out.println ("Result:"+s);
            return s;
        }
    }

    public static void main(String[] args) {


        P p = new P (5, 7, 3);
        Converter<P, F> converter11 = x -> new F(P.a, P.b, P.c);

        F f = converter11.convert(p);
        System.out.println("Result from convert: " + F.display2());

    }

    interface Converter<T, N> {

        N convert(T t);

        static <T> boolean isNotNull(T t) {
            return t != null;
        }
    }
}
