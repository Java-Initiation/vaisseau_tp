package com.company.models;

import com.company.Utils;

import static com.company.Constants.*;

public class Vaisseau {

    // ATTRIBUTS
    private String name, color;
    private int localisation, vitesseMax, carburantQuantite, carburantMax;
    private boolean teleportation;

    public Vaisseau(){

    }


    // CONSTRUCTEUR
    public Vaisseau(String name, String color, int localisation, int vitesseMax, int carburantQuantite, int carburantMax, boolean teleportation) {
        this.name = name;
        this.color = color;
        this.localisation = localisation;
        this.vitesseMax = vitesseMax;
        this.carburantQuantite = carburantQuantite;
        this.carburantMax = carburantMax;
        this.teleportation = teleportation;
    }

    public void ajouterEssence(int quantite){
        int carburantQuantiteNouvelle = this.carburantQuantite + quantite;
        if (carburantQuantiteNouvelle > this.carburantMax)
            this.carburantQuantite = this.carburantMax;
        else
            this.carburantQuantite = carburantQuantiteNouvelle;
    }


    public void faireLePlein(){
        if (this.carburantQuantite < this.carburantMax)
            this.carburantQuantite = this.carburantMax;
        else
            Utils.display("Vous avez déjà fait le plein");
    }

    // METHODES
    public void seDeplacer(int destination){
        if (destination != this.localisation){
            int voyageCarburant = getVoyageCarburant(destination);
            if (this.carburantQuantite >= voyageCarburant){
                Utils.display("Voyage effectué");
                this.carburantQuantite -= voyageCarburant;
                this.localisation = destination;
            }
            else
                Utils.display("Pas assez de carburant");
        }
        else
            System.out.println("Impossible nous sommes déjà ici!");
    }

    private int getVoyageCarburant(int destination) {
        int voyageCarburant;
        switch (destination){
            case DESTINATION_JUPITER:
                voyageCarburant = 100;
                break;
            case DESTINATION_MARS:
                voyageCarburant = 500;
                break;
            case DESTINATION_SOLEIL:
                voyageCarburant = 2000;
                break;
            case DESTINATION_TERRE:
                voyageCarburant = 4000;
                break;
            default:
                voyageCarburant = 0;
        }
        return voyageCarburant;
    }

    // GETTERS (assesseurs) et SETTERS (mutateurs)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getVitesseMax() {
        return vitesseMax;
    }

    public void setVitesseMax(int vitesseMax) {
        this.vitesseMax = vitesseMax;
    }

    public boolean isTeleportation() {
        return teleportation;
    }

    public void setTeleportation(boolean teleportation) {
        this.teleportation = teleportation;
    }

    public int getLocalisation() {
        return localisation;
    }

    public void setLocalisation(int localisation) {
        this.localisation = localisation;
    }
}
