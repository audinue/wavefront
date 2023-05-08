package wavefront;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Mtl {

    public List<Material> materials = new ArrayList<>();

    @Override
    public String toString() {
        return "Mtl{" + "materials=" + materials + '}';
    }

    @SuppressWarnings("null")
    public static Mtl parse(InputStream in) throws IOException {
        Mtl mtl = new Mtl();
        Scanner scanner = new Scanner(in);
        Material material = null;
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            if (line.startsWith("newmtl ")) {
                material = new Material();
                material.name = line.substring("newmtl ".length());
                mtl.materials.add(material);
            } else if (line.startsWith("Ka ")) {
                String[] tokens = line.substring("Ka ".length()).split(" ");
                material.ambient.x = Double.parseDouble(tokens[0]);
                material.ambient.y = Double.parseDouble(tokens[1]);
                material.ambient.z = Double.parseDouble(tokens[2]);
            } else if (line.startsWith("Kd ")) {
                String[] tokens = line.substring("Kd ".length()).split(" ");
                material.diffuse.x = Double.parseDouble(tokens[0]);
                material.diffuse.y = Double.parseDouble(tokens[1]);
                material.diffuse.z = Double.parseDouble(tokens[2]);
            } else if (line.startsWith("Ks ")) {
                String[] tokens = line.substring("Ks ".length()).split(" ");
                material.specular.x = Double.parseDouble(tokens[0]);
                material.specular.y = Double.parseDouble(tokens[1]);
                material.specular.z = Double.parseDouble(tokens[2]);
            } else if (line.startsWith("Ke ")) {
                String[] tokens = line.substring("Ke ".length()).split(" ");
                material.emission.x = Double.parseDouble(tokens[0]);
                material.emission.y = Double.parseDouble(tokens[1]);
                material.emission.z = Double.parseDouble(tokens[2]);
            } else if (line.startsWith("Ns ")) {
                material.shininess = Double.parseDouble(line.substring("Ns ".length()));
            } else if (line.startsWith("map_Kd ")) {
                material.texture = line.substring("map_Kd ".length());
            }
        }
        return mtl;
    }
}
