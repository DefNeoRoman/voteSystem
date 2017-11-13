package sandbox;

public class PriceComparator {
    private static final PriceComparator INSTANCE = new PriceComparator();

    private  PriceComparator(){

    }
    public static PriceComparator getINSTANCE(){
        return INSTANCE;
    }
}
