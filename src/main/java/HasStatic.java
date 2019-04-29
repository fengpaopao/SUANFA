import java.nio.ByteBuffer;
import java.nio.ByteOrder;

class HasStatic {// 1
    int a[] = {2, 4, 8};

    int sum() {
        int s = 0;
        for (int i = 0; i < 3; i++)
            s = s + a[i];
            return s;
    }
}


