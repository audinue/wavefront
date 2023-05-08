package wavefront;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Obj {

    /**
     * Stores <code>mtllib</code> value.
     */
    public String materials;

    /**
     * Stores all <code>v</code>.
     */
    public List<Vector3> positions = new ArrayList<>();

    /**
     * Stores all <code>vt</code>.
     */
    public List<Vector2> texCoords = new ArrayList<>();

    /**
     * Stores all <code>vn</code>.
     */
    public List<Vector3> normals = new ArrayList<>();

    /**
     * Stores all <code>o</code>.
     */
    public List<Object> objects = new ArrayList<>();

    @Override
    public String toString() {
        return "Obj{" + "materials=" + materials + ", positions=" + positions + ", texCoords=" + texCoords + ", normals=" + normals + ", objects=" + objects + '}';
    }

    @SuppressWarnings("null")
    public static Obj parse(InputStream in) throws IOException {
        Obj obj = new Obj();
        Scanner scanner = new Scanner(in);
        Object object = null;
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            if (line.startsWith("mtllib ")) {
                obj.materials = line.substring("mtllib ".length());
            } else if (line.startsWith("o ")) {
                object = new Object();
                object.name = line.substring("o ".length());
                obj.objects.add(object);
            } else if (line.startsWith("v ")) {
                String[] tokens = line.substring("v ".length()).split(" ");
                Vector3 position = new Vector3();
                position.x = Double.parseDouble(tokens[0]);
                position.y = Double.parseDouble(tokens[1]);
                position.z = Double.parseDouble(tokens[2]);
                obj.positions.add(position);
            } else if (line.startsWith("vn ")) {
                String[] tokens = line.substring("vn ".length()).split(" ");
                Vector3 normal = new Vector3();
                normal.x = Double.parseDouble(tokens[0]);
                normal.y = Double.parseDouble(tokens[1]);
                normal.z = Double.parseDouble(tokens[2]);
                obj.normals.add(normal);
            } else if (line.startsWith("vt ")) {
                String[] tokens = line.substring("vt ".length()).split(" ");
                Vector2 texCoord = new Vector2();
                texCoord.x = Double.parseDouble(tokens[0]);
                texCoord.y = 1 - Double.parseDouble(tokens[1]);
                obj.texCoords.add(texCoord);
            } else if (line.startsWith("usemtl ")) {
                object.material = line.substring("usemtl ".length());
            } else if (line.startsWith("f ")) {
                Face face = new Face();
                String[] vertices = line.substring("f ".length()).split(" ");
                for (int i = 0; i < vertices.length; i++) {
                    String[] tokens = vertices[i].split("/");
                    Vertex vertex = new Vertex();
                    vertex.position = Integer.parseInt(tokens[0]);
                    if (!tokens[1].isEmpty()) {
                        vertex.texCoord = Integer.parseInt(tokens[2]);
                    }
                    vertex.normal = Integer.parseInt(tokens[2]);
                    face.vertices.add(vertex);
                }
                object.faces.add(face);
            }
        }
        return obj;
    }
}
