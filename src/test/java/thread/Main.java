package thread;

class Super {
    static {
        System.out.println("thread.Super");
    }

    {
        System.out.println("thread.Super inner");
    }
}

class One extends Super {
    static {
        System.out.println("thread.One");
    }

    {
        System.out.println("thread.One inner");
    }

    public One() {
        System.out.println("thread.One constructor");
    }
}

public class Main {

    public static void main(String[] args) {
        One oneFirst = new One();
        One oneSecond = new One();
        System.out.println("\nfinish");
    }

}
