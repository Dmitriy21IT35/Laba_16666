package com.compan;

public class Main {
    public static class P extends F {
        private static double a,b,c;

        public P(double a, double b, double c) {
            super ();
            P.a = a;
            P.b = b;
            P.c = c;
        }

        public static double display1() {
            double s =  a*Math.pow (b, c);
            System.out.println (s);
            return s;
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
             double s = a*Math.pow (b, c);
            System.out.println (s);
             return s;
         }
    }

    public static void main(String[] args) {

        double b;
        double c;
        double a;
        P p = new P(34, 120, -3);

        Converter<P, F> converter11 = new Converter<P, F> () {
            @Override
            public F convert(P x) {
                return new F (P.a, P.b, P.c);
            }

            @Override
            public <T> boolean isNotNull(T t) {
                return false;
            }
        };

        F f = converter11.convert(p);
        System.out.println("объект прошедший конвертацию: " + F.display2());
    }
}
    interface Converter<T, N> {

        N convert(T t);

         <T> boolean isNotNull(T t);
    }

