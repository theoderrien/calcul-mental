package bo;

import java.io.Serializable;

public class Game implements Serializable {

    private int id;
    private int nbBonneReponse;
    private int userId;

    public Game(int id, int nbBonneReponse, int userId) {
        this.id = id;
        this.nbBonneReponse = nbBonneReponse;
        this.userId = userId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNbBonneReponse() {
        return nbBonneReponse;
    }

    public void setNbBonneReponse(int nbBonneReponse) {
        this.nbBonneReponse = nbBonneReponse;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
}
