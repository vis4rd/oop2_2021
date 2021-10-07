public class Main {

    public static void main(String[] args) {

        // tworzenie zmiennej"
        int i = 555;

        // tworzenie tablicy:
        int[] t = new int[10];

        // tworzenie obiektu:
        Liczba x = new Liczba();

        // wywoływanie metod klasy:
        x.setN(7);
        i = x.getN();

        // iteracja:
        for (int k = 0; k < t.length; k++) {
            t[k] = k * k / 2;
            System.out.println("t[" + k + "] = " + t[k]);
        }

        System.out.println("Liczba i = " + i);
        System.out.println("Obiekt x = " + x);
        System.out.println("Wartość liczby n obiektu x = " + x.getN());

        System.out.println(2 + 4);
        System.out.println("2 + 4 = " +  2 + 4);
        System.out.println("2 + 4 = " +  (2 + 4));

        //float f = 3.3;
        float f = 3.3f;
        System.out.println(f);
    }
}

class Liczba {

    // Dane:
    private int n;

    // Konstruktory:
    public Liczba() {
        this.n = 0;
    }

    public Liczba(int n) {
        this.n = n;
    }

    public int getN() {
        return n;
    }

    public void setN(int n) {
        this.n = n;
    }
}
