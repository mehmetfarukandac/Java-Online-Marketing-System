package store.electronic;

public abstract class PhoneDecorater implements IPhone {
    private IPhone newPhone;

    public PhoneDecorater(IPhone phone){
        this.newPhone=phone;
    }

    public PhoneDecorater() {

    }

    @Override
    public double getBattery() {
        return this.newPhone.getBattery();
    }

    @Override
    public int getPixel() {
        return this.newPhone.getPixel();
    }

    @Override
    public double getInch() {
        return this.newPhone.getInch();
    }

    @Override
    public int getRam() {
        return this.newPhone.getRam();
    }

    @Override
    public int getMemory() {
        return this.newPhone.getMemory();
    }
}
