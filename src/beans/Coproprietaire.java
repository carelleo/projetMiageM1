package beans;


public class Coproprietaire {
    
    private String type;
    private String nom;
    private String prenom;
    private String mail;
    private String mdp;
    private String mdpc;
    private boolean condition;
    private String teleF;
    private String teleP;
    
    public Coproprietaire(){
    }
    
    public Coproprietaire(String t, String n, String p, String ma, String md){
        type = t;
        nom = n;
        prenom = p;
        mail = ma;
        mdp = md;
        mdpc = md;
        condition = true;
        teleF=null;
        teleP=null;
    }
    
    public Coproprietaire(String t, String n, String p, String ma, String md, String tf, String tp){
        type = t;
        nom = n;
        prenom = p;
        mail = ma;
        mdp = md;
        mdpc = md;
        condition = true;
        teleF=tf;
        teleP=tp;
    }

    public String getType() {
        return type;
    }

    public void setType( String type ) {
        this.type = type;
    }

    public String getNom() {
        return nom;
    }

    public void setNom( String nom ) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom( String prenom ) {
        this.prenom = prenom;
    }

    public String getMail() {
        return mail;
    }

    public void setMail( String mail ) {
        this.mail = mail;
    }

    public String getMdp() {
        return mdp;
    }

    public void setMdp( String mdp ) {
        this.mdp = mdp;
    }

    public boolean isCondition() {
        return condition;
    }

    public void setCondition( boolean condition ) {
        this.condition = condition;
    }

    public String getMdpc() {
        return mdpc;
    }

    public void setMdpc( String mdpc ) {
        this.mdpc = mdpc;
    }

    public String getTeleF() {
        return teleF;
    }

    public void setTeleF( String teleF ) {
        this.teleF = teleF;
    }

    public String getTeleP() {
        return teleP;
    }

    public void setTeleP( String teleP ) {
        this.teleP = teleP;
    }
}
