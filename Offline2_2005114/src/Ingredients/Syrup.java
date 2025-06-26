package Ingredients;

public class Syrup implements Ingredients{
    private String name;

//    public Syrup(SyrupType syrupType) {
//        if (syrupType == SyrupType.CHOCOLATE) {
//            this.name = "Chocolate Syrup";
//        } else if(syrupType == SyrupType.STRAWBERRY) {
//            this.name = "Strawberry Syrup";
//        } else if (syrupType == SyrupType.VANILLA) {
//            this.name = "Vanilla Syrup";
//        }
//    }
    public Syrup(String syrupType) {
        if (syrupType =="CHOCOLATE") {
            this.name = "Chocolate Syrup";
        } else if(syrupType =="STRAWBERRY") {
            this.name = "Strawberry Syrup";
        } else if (syrupType == "VANILLA") {
            this.name = "Vanilla Syrup";
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
