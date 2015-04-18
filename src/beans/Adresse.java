package beans;

public class Adresse {
    private int num;
    private String rue;
    private int cp;
    
    public Adresse(){
    }
    
    public Adresse(int n, String r, int c){
        num = n;
        rue = r;
        cp = c;
    }

    public int getNum() {
        return num;
    }

    public void setNum( int num ) {
        this.num = num;
    }

    public String getRue() {
        return rue;
    }

    public void setRue( String rue ) {
        this.rue = rue;
    }

    public int getCp() {
        return cp;
    }

    public void setCp( int cp ) {
        this.cp = cp;
    }
}
