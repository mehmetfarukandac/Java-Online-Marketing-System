package store.furniture;

public abstract class WardrobeDecorator implements IWardrobe{
   IWardrobe iWardrobe;

    public WardrobeDecorator(IWardrobe iWardrobe) {
        this.iWardrobe = iWardrobe;
    }

    public WardrobeDecorator() {

    }

    @Override
    public int getDoor() {
        return this.iWardrobe.getDoor();
    }

    @Override
    public int getDrawer() {
        return this.iWardrobe.getDrawer();
    }

    @Override
    public double getVolume() {
        return this.iWardrobe.getVolume();
    }
}
