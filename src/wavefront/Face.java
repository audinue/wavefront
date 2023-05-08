package wavefront;

import java.util.ArrayList;
import java.util.List;

public class Face {

    /**
     * Stores <code>f</code> value.
     */
    public List<Vertex> vertices = new ArrayList<>();

    @Override
    public String toString() {
        return vertices.toString();
    }
}
