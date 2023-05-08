package wavefront;

public class Material {

    /**
     * Stores <code>newmtl</code> value.
     */
    public String name;
    
    /**
     * Stores <code>Ka</code> value.
     */
    public Vector3 ambient = new Vector3();
    
    /**
     * Stores <code>Kd</code> value.
     */
    public Vector3 diffuse = new Vector3();
    
    /**
     * Stores <code>Ks</code> value.
     */
    public Vector3 specular = new Vector3();
    
    /**
     * Stores <code>Ke</code> value.
     */
    public Vector3 emission = new Vector3();
    
    /**
     * Stores <code>Ns</code> value.
     */
    public double shininess;
    
    /**
     * Stores <code>map_Kd</code> value.
     */
    public String texture;

    @Override
    public String toString() {
        return "Material{" + "name=" + name + ", ambient=" + ambient + ", diffuse=" + diffuse + ", specular=" + specular + ", emission=" + emission + ", shininess=" + shininess + ", texture=" + texture + '}';
    }
}
