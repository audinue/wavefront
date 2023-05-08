import java.io.FileInputStream;
import java.io.IOException;
import wavefront.Mtl;
import wavefront.Obj;

public class Main {

    public static void main(String[] args) throws IOException {
        try (FileInputStream in = new FileInputStream("C:\\Users\\giorg\\OneDrive\\Documents\\baking_bake_test.obj")) {
            System.out.println(Obj.parse(in));
        }
        try (FileInputStream in = new FileInputStream("C:\\Users\\giorg\\OneDrive\\Documents\\baking_bake_test.mtl")) {
            System.out.println(Mtl.parse(in));
        }
    }
}
