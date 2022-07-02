import model.Cachorro;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<Cachorro> cachorros = new ArrayList<>();

        Cachorro cachorro1 = new Cachorro();
        cachorro1.setNome("Rex");
        cachorro1.setIdade(3);

        Cachorro cachorro2 = new Cachorro();
        cachorro2.setNome("Lady");
        cachorro2.setIdade(1);

        // add no array:
        cachorros.add(cachorro1);
        cachorros.add(cachorro2);

        // armazenamento da lista
        FileOutputStream fo = null;

        try{
            fo = new FileOutputStream("OutputFile.txt");
            ObjectOutputStream object = new ObjectOutputStream(fo);

            object.writeObject(cachorros); //sobreescrever com a lista

        } catch(FileNotFoundException e){
            System.out.println("ERROR: Erro de arquivo não encontrado!");
        } catch (Exception e){
            System.out.println("ERROR: " + e.getMessage());
        }

        // recuperar o arquivo
        List<Cachorro> cachorros2 = null;
        FileInputStream fi = null;

        try{
            fi = new FileInputStream("OutputFile.txt");
            ObjectInputStream oi = new ObjectInputStream(fi);

            cachorros2 = (ArrayList) oi.readObject();
        } catch(FileNotFoundException e){
            System.out.println("ERROR: Erro de arquivo não encontrado!");
        } catch (Exception e){
            System.out.println("ERROR: " + e.getMessage());
        }

        //
        for(Cachorro cachorro : cachorros2)
            System.out.println(cachorro.getNome() + ": " + cachorro.getIdade());
        /*
        cachorros2.forEach(cachorro -> {
            System.out.println(cachorro.getNome() + ": " + cachorro.getIdade());
        });

        ou

        for(int i = 0; i<cachorros2.size();i++{
            cachorros2.get(i).setNome();
        */
    }

}
