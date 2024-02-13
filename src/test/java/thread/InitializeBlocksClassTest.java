package thread;

import org.junit.Test;

class Super {
    static {
        System.out.println("Super");
    }

    {
        System.out.println("Super inner");
    }
}

class One extends Super {
    static {
        System.out.println("One");
    }

    {
        System.out.println("One inner");
    }

    public One() {
        System.out.println("One constructor");
    }
}

public class InitializeBlocksClassTest {

    @Test
    public void call() {
        One oneFirst = new One();
        One oneSecond = new One();
        System.out.println("\nfinish");
    }

}
