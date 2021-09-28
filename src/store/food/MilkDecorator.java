package store.food;

import store.food.IMilk;

public abstract class MilkDecorator implements IMilk {

    private IMilk newIMilk;

    public MilkDecorator(IMilk newIMilk) {
        this.newIMilk = newIMilk;
    }

    public MilkDecorator() {

    }

    @Override
    public double getProtein() {
        return this.newIMilk.getProtein();
    }

    @Override
    public int getMililiter() {
        return this.newIMilk.getMililiter();
    }
}
