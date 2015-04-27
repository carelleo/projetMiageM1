package beans;

public class Adresse {
    private int num;
    private String rue;
    private int cp;
    
    /**
     * 
     */
    public Adresse(){
    }
    
    /**
     * @param n
     * @param r
     * @param c
     */
    public Adresse(int n, String r, int c){
        num = n;
        rue = r;
        cp = c;
    }

    /**
     * @return
     */
    public int getNum() {
        return num;
    }

    /**
     * @param num
     */
    public void setNum( int num ) {
        this.num = num;
    }

    /**
     * @return
     */
    public String getRue() {
        return rue;
    }

    /**
     * @param rue
     */
    public void setRue( String rue ) {
        this.rue = rue;
    }

    /**
     * @return
     */
    public int getCp() {
        return cp;
    }

    /**
     * @param cp
     */
    public void setCp( int cp ) {
        this.cp = cp;
    }
}
