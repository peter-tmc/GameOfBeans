import java.util.List;

/**
 * @author 54939_55937
 *
 */
public class Game {

    private int depth;
    private List<Integer> piles;
    private String player;

    public Game(int nDepth, List<Integer> piles, String player){
        this.depth=nDepth;
        this.piles=piles;
        this.player=player;
    }

    public int compute(){
        return recursive(0,piles.size()-1, player);
    }

    private int recursive(int i, int j, String p){
        if(j<i){
            return 0;
        }
        if(j==i && p.equals("Jaba")){ 
            return score(i,i);
        }
        
        if(p.equals("Pieton")) {
            int max=Integer.MIN_VALUE;
            int k=i;
            int n=i;
            int current=0;
            for(int m=i; m<i+depth; m++) {
                current+=piles.get(m);
                if(current>max){
                    max=current;
                    n=m;
                }
            }
            current=0;
            for(int c=j; c>j-depth; c--){
                current+=piles.get(c);
                if(current>max){
                    k=c;
                    n=j;
                    max=current;
                }
            }
            if(k==i) //TODO : ver se da para fazer de forma diferente sem este if e so com uma expressao
                return recursive(n+1,j,"Jaba");
            else
                return recursive(i,k-1,"Jaba");
        }
        int max=Integer.MIN_VALUE;
        int current=0;
        for(int m=i; m<i+depth; m++) {
            current=recursive(m+1, j, "Pieton") + score(i,m);
            if(current>max){
                max=current;
            }
        }
        for(int c=j; c>j-depth; c--){
            current=recursive(i,c-1,"Pieton") + score(c,j);
            if(current>max){
                max=current;
            }
        }
        return max;
    }

    private int score(int i, int j) {
        int sum=0;
        for(int k=i; k<=j; k++){
            sum+=piles.get(k);
        }
        return sum;
    }
}


