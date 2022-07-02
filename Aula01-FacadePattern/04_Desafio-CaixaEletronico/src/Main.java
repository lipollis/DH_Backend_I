public class Main {

    public static void main(String[] args) {
        iFacadeSaque fachada = new FacadeSaque();

        Usuario usuario = new Usuario("aline","0000",1000);
        fachada.sacar(usuario,200);

        Usuario usuario2 = new Usuario("aline","0000",1000);
        fachada.sacar(usuario2,1500);

        Usuario usuario3 = new Usuario("aline","1111",1000);
        fachada.sacar(usuario3,200);
    }
}
