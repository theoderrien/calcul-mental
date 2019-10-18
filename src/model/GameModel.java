package model;

import bo.Chrono;

import java.util.Scanner;

public class GameModel {


    public void affichage() {
        int score = 0, question = 0;

        double reponse = 0.0, resultat = 0.0;
        int nbA1 = (int) (Math.random() * 100);
        int nbA2 = (int) (Math.random() * 100);

        Scanner sc = new Scanner(System.in);

        Object[] op = {'+', '-', '*', '/'};

        Chrono chrono = new Chrono();


        chrono.start();
        do {

            question++;
            int rdop = (int) (Math.random() * 4);
            Object operateur = op[rdop];
            System.out.print("Qestion n°" + question + ":  " + nbA1 + " " + operateur + " " + nbA2 + " = : ");
            reponse = sc.nextInt();

            switch (rdop) {
                case 0:
                    resultat = nbA1 + nbA2;
                    break;
                case 1:
                    resultat = nbA1 - nbA2;
                    break;
                case 2:
                    resultat = nbA1 * nbA2;
                    break;
                case 3:
                    resultat = (float) nbA1 / nbA2;
                    break;
                default:
                    // code block
            }

            if (reponse == resultat) {
                System.out.println("la bonne reponse est bien " + resultat + " !");
                score++;
                nbA1 = (int) (Math.random() * 100);
                nbA2 = (int) (Math.random() * 100);
            } else {
                System.out.println("mauvaise reponse la réponse etait : " + resultat);
                nbA1 = (int) (Math.random() * 100);
                nbA2 = (int) (Math.random() * 100);
            }
        } while (question != 10);
        chrono.stop();
        System.out.println("\nVotre score est de " + score + "/10 !");
        System.out.println("Votre temps est de : " + chrono.getDureeTxt()); // affichage au format "1 h 26 min 32 s"

    }
}