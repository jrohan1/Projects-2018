
/**
 * Simple Test class with a main method.
 * Only role is to test the classes in the food chain
 * @author (conor hayes)
 * @version (october 26th)
 
public class FoodChainTest
{
    /**
     * code to test the first iteration of the food chain classes
     
    public void testv1()
    {
        Seed millet = new Seed("millet");
        Seed sunflower = new Seed("sunflower");
        Seed hayseed = new Seed("hayseed");
        System.out.println(millet.getCalories());//should be 10
        Canary bluey = new Canary("Bluey");
        System.out.println(bluey.getEnergy()); //should be 0
        bluey.eat(millet); // bluey should sing
        bluey.eat(sunflower); // bluey should sing
        bluey.eat(hayseed);// bluey should sing
        System.out.println(bluey.getEnergy()); //should now be 30
        System.out.println(millet.getCalories());//should be 0
        System.out.println(sunflower.getCalories());//should be 0
        System.out.println(hayseed.getCalories());//should be 0
        System.out.println("#####################");
    }
   public void testv2()
    {
        Seed millet = new Seed("millet");
        Seed sunflower = new Seed("sunflower");
        Seed hayseed = new Seed("hayseed");
        Canary bluey = new Canary("Bluey");
        bluey.eat(millet); // bluey should sing
        bluey.eat(sunflower); // bluey should sing
        Cat felix = new Cat("Felix");
        felix.eat(hayseed);
        System.out.println(felix.getEnergy());
        felix.eat(bluey);
        System.out.println(felix.getEnergy());
        System.out.println(bluey.getEnergy());
        System.out.println(hayseed.getCalories());
    }
    public static void main(String[] args){
        FoodChainTest foodchain = new FoodChainTest();
        foodchain.testv1();
        foodchain.testv2();
    }
}*/
