package Ingredients;

public class Sugar implements Ingredients{
    private String name;

    public Sugar(boolean isZero) {
        if (isZero) {
            this.name = "Sweetener";
        } else {
            this.name = "Sugar";
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
