package wavefront;

import java.util.ArrayList;
import java.util.List;

public class Object {

    /**
     * Stores <code>o</code> value.
     */
    public String name;

    /**
     * Stores <code>usemtl</code> value.
     */
    public String material;

    /**
     * Stores all <code>f</code>.
     */
    public List<Face> faces = new ArrayList<>();

    @Override
    public String toString() {
        return "Object{" + "name=" + name + ", material=" + material + ", faces=" + faces + '}';
    }
}
