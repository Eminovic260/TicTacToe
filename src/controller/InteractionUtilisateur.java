package controller;

import vue.View;

import java.util.Scanner;

public class InteractionUtilisateur {
    private Scanner scanner;
    private View view;

    public InteractionUtilisateur(Scanner scanner, View view) {
        this.scanner = scanner;
        this.view = view;
    }


    public void displayDemandePlacement(String representation) {
        view.displayMessage("Joueur " + representation + " joue ligne et colonne : ");
    }

    public void displayErreurEntree() {
        view.displayMessage("entrez un entier");
    }

    public void displayHorsPlateau() {
        view.displayMessage("vous sortez du terrain !");
    }

    public void displayDejaOccupee() {
        view.displayMessage("deja occupée");
    }



    public int nextInt(){
       return scanner.nextInt();
    }

    public void nextLine(){
        scanner.nextLine();
    }
    public boolean hasNextInt(){
        return scanner.hasNextInt();
    }
}
