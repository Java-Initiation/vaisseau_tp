package com.company;

import com.company.models.Vaisseau;

import java.util.ArrayList;

import static com.company.Constants.*;


public class Main {

    public static void main(String[] args) {

        Utils.display("Bienvenue");
        String name = Utils.ask("Nom du vaisseau ? ");
        String couleur = Utils.ask("Couleur du vaisseau ? ");
        String vitesseMax = Utils.ask("Vitesse max du vaisseau ? ");
        String carburantQuantite = Utils.ask("Carburant du vaisseau ? ");
        String carburantMax = Utils.ask("Carburant max du vaisseau ? ");

        Vaisseau vaisseau = new Vaisseau(
                name,
                couleur,
                DESTINATION_TERRE,
                Integer.parseInt(vitesseMax),
                Integer.parseInt(carburantQuantite),
                Integer.parseInt(carburantMax),
                true
        );

        while (true){

            Utils.display("(F)aire le plein");
            Utils.display("(E) pour ajouter essence");
            Utils.display("(V) pour voyager");
            String choice = Utils.ask("Votre choix ?");

            switch (choice){
                case "F" : vaisseau.faireLePlein();
                    break;
                case "E" :
                    String quantite = Utils.ask("Quantité ?");
                    vaisseau.ajouterEssence(Integer.parseInt(quantite));
                    break;
                case "V" :
                    Utils.display("0 pour Jupiter");
                    Utils.display("1 pour Terre");
                    Utils.display("2 pour Soleil");
                    Utils.display("3 pour Mars");
                    String destination = Utils.ask("Votre choix ?");
                    vaisseau.seDeplacer(Integer.parseInt(destination));
                    break;
            }

        }

    }

}
