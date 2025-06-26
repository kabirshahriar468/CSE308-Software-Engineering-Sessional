package Ingredients;

public class Jello implements Ingredients{
    private String name;

    public Jello(boolean isZero) {
        if(isZero) {
            name = "Sugar-Free Jello";
        }
        else {
            name = "Jello";
        }
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getExtraPrice() {
        return 0;
    }
}
