package wavefront;

public class Vertex {
    
    /**
     * Stores position index.
     */
    public int position;
    
    /**
     * Stores texCoord index.
     */
    public int texCoord;
    
    /**
     * Stores normal index.
     */
    public int normal;

    @Override
    public String toString() {
        return position + "/" + texCoord + "/" + normal;
    }
}
