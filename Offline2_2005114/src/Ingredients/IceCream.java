package Ingredients;

public class IceCream implements Ingredients{
    private String name;
//    public IceCream(IceCreamType iceCreamType){
//        if(iceCreamType == IceCreamType.VANILLA){
//            this.name = "Vanilla Ice Cream";
//        }
//        else if(iceCreamType == IceCreamType.CHOCOLATE){
//            this.name = "Chocolate Ice Cream";
//        }
//        else if(iceCreamType == IceCreamType.STRAWBERRY){
//            this.name = "Strawberry Ice Cream";
//        }
//    }
public IceCream(String iceCreamType){
    if(iceCreamType == "VANILLA"){
        this.name = "Vanilla Ice Cream";
    }
    else if(iceCreamType == "CHOCOLATE"){
        this.name = "Chocolate Ice Cream";
    }
    else if(iceCreamType =="STRAWBERRY"){
        this.name = "Strawberry Ice Cream";
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
