package model;

public class Commande {
    private int id;
    private int ref_fourniture;

    public Commande(int ref_fourniture) {
        this.ref_fourniture = ref_fourniture;
    }


    public int getRef_fourniture() {
        return ref_fourniture;
    }

    public void setRef_fourniture(int ref_fourniture) {
        this.ref_fourniture = ref_fourniture;
    }
}
