package br.edu.utfpr.pw25s.projetoFinal.enums;

public enum MovementType {

    CREDIT("Credit"),
    DEBIT("Debit"),
    TRANSFER("Transfer");

    public final String label;

    MovementType(String label) {
        this.label = label;
    }
}
