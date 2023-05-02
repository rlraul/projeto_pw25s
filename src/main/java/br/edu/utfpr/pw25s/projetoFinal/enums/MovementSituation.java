package br.edu.utfpr.pw25s.projetoFinal.enums;

public enum MovementSituation {

    PENDING("Pending"),
    PAID("Paid");

    public final String label;

    MovementSituation(String label) {
        this.label = label;
    }
}
