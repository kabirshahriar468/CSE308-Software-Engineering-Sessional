package Ingredients;

public class Flavor implements Ingredients{
    private String name;

    //    public Flavor(FlavorType flavorType){
    //        if(flavorType == FlavorType.CHOCOLATE){
    //            this.name = "Chocolate Flavor";
    //        }
    //        else if(flavorType == FlavorType.STRAWBERRY){
    //            this.name = "Strawberry Flavor";
    //        }
    //        else if(flavorType == FlavorType.VANILLA){
    //            this.name = "Vanilla Flavor";
    //        }
    //    }
    public Flavor(String flavorType){
        if(flavorType == "CHOCOLATE"){
            this.name = "Chocolate Flavor";
        }
        else if(flavorType == "STRAWBERRY"){
            this.name = "Strawberry Flavor";
        }
        else if(flavorType =="VANILLA"){
            this.name = "Vanilla Flavor";
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
