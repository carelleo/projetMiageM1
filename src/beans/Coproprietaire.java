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
    
    /**
     * 
     */
    public Coproprietaire(){
    }
    
    /**
     * @param t
     * @param n
     * @param p
     * @param ma
     * @param md
     */
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
    
    /**
     * @param t
     * @param n
     * @param p
     * @param ma
     * @param md
     * @param tf
     * @param tp
     */
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

    /**
     * @return
     */
    public String getType() {
        return type;
    }

    /**
     * @param type
     */
    public void setType( String type ) {
        this.type = type;
    }

    /**
     * @return
     */
    public String getNom() {
        return nom;
    }

    /**
     * @param nom
     */
    public void setNom( String nom ) {
        this.nom = nom;
    }

    /**
     * @return
     */
    public String getPrenom() {
        return prenom;
    }

    /**
     * @param prenom
     */
    public void setPrenom( String prenom ) {
        this.prenom = prenom;
    }

    /**
     * @return
     */
    public String getMail() {
        return mail;
    }

    /**
     * @param mail
     */
    public void setMail( String mail ) {
        this.mail = mail;
    }

    /**
     * @return
     */
    public String getMdp() {
        return mdp;
    }

    /**
     * @param mdp
     */
    public void setMdp( String mdp ) {
        this.mdp = mdp;
    }

    /**
     * @return
     */
    public boolean isCondition() {
        return condition;
    }

    /**
     * @param condition
     */
    public void setCondition( boolean condition ) {
        this.condition = condition;
    }

    /**
     * @return
     */
    public String getMdpc() {
        return mdpc;
    }

    /**
     * @param mdpc
     */
    public void setMdpc( String mdpc ) {
        this.mdpc = mdpc;
    }

    /**
     * @return
     */
    public String getTeleF() {
        return teleF;
    }

    /**
     * @param teleF
     */
    public void setTeleF( String teleF ) {
        this.teleF = teleF;
    }

    /**
     * @return
     */
    public String getTeleP() {
        return teleP;
    }

    /**
     * @param teleP
     */
    public void setTeleP( String teleP ) {
        this.teleP = teleP;
    }
}
