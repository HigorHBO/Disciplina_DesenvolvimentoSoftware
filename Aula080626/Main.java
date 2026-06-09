package Aula080626;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

class Aluno implements Serializable {
    String nome;
    int idade;

    public Aluno(String nome, int idade) {
        this.nome = nome;
        this.idade = idade;
    }

    @Override
    public String toString() {
        return nome + "-" + idade + "anos";
    }

}

public class Main {
    public static void main(String[] args) {
        try {
            ArrayList<Aluno> alunos = new ArrayList<>();
            alunos.add(new Aluno("Higor", 26));
            alunos.add(new Aluno("Felipe", 26));
            alunos.add(new Aluno("Joao", 16));

            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("alunos.dat"));

            oos.writeObject(alunos);

            ObjectInputStream ois = new ObjectInputStream(new FileInputStream("alunos.dat"));

            ArrayList<Aluno> lista = (ArrayList<Aluno>) ois.readObject();

            for (Aluno a : lista) {
                System.out.println(a);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

}
