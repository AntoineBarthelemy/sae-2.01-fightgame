Conventionnage :

variable = int nom_variable;
méthode = public void nomMéthode()
classe = public Class
geteur et seteur = public type getName(), public void setName()

Fichier typique :

public class NameClass extends/implements NameClass {

    // Attribut

    private int attribut1;
    private String attribut2;

    // Redéfinission de méthode héritée
    @Override
    public String log(
        String text, 
        String level, 
        Color color
    ){

        // Code

    }

    // Constructeur de la class
    public NameClass(
        int att, 
        String atb
    ){

        this.attribut1 = att;
        this.attribut2 = atb;

    }

    public NameClass(){

        this(
            1,
            "Bonjour"
        )

    }

    // Getteur et Setteur
    public int getAtt(){

        return attribut1;

    }

    public void setAtt(
        int new_att;
    ){

        this.attribut1 = new_att;

    }

    public String getAtb(){

        return attribut2;

    }

    public void setAtb(
        String new_atb;
    ){

        this.attribut2 = new_atb;

    }

        // Cas particulier seteur et geteur
    public boolean isEmpty(){

        return attribut1 <= 0;

    }

    // Méthode réservé à la class
    private/protected void makeThisSpecification(){

        // code

    }

    // Méthode
    public int calculateSum(){

        // code

    }

}


Cette partie du document traite le mapping utilisé dans le cadre de ce projet comme convenu par les membres du groupe. En effet, il est important 
de savoir quelle touche (jostick) inclus sur le stick arcade sera associé à quelle action. Voici un aperçu du stick arcade pour un joueur "[Lien vers le stick arcade](https://drive.google.com/file/d/1jAYOLWE7LX0QYwKgoFY2URomPZSdYKxE/view?usp=sharing)"