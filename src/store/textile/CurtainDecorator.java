package store.textile;

public abstract class CurtainDecorator implements ICurtain{
    ICurtain iCurtain;

    public CurtainDecorator(ICurtain iCurtain) {
        this.iCurtain = iCurtain;
    }

    public CurtainDecorator() {

    }

    @Override
    public int getLenght() {
        return this.iCurtain.getLenght();
    }

    @Override
    public String getDescription() {
        return this.iCurtain.getDescription();
    }
}
