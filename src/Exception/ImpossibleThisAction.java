package Exception;

public class ImpossibleThisAction extends RuntimeException{
    
    private static final long serialVersionUID = 4928599035264976611L;
 
    public ImpossibleThisAction(String message) {
        super(message);
    }
 
    public ImpossibleThisAction(Throwable t) {
        super(t);
    }
    
}
