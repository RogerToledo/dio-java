public class Car {
    private boolean isOn;
    private int velocity;
    private int shift;

    public Car() {
        this.isOn = false;
        this.velocity = 0;
        this.shift = 0;
    }

    public boolean isOn() {
        return isOn;
    }

    public void setOn(boolean on) {
        isOn = on;
    }

    public int getVelocity() {
        return velocity;
    }

    public void setVelocity(int velocity) {
        this.velocity = velocity;
    }

    public int getShift() {
        return shift;
    }

    public void setShift(int shift) {
        this.shift = shift;
    }
}
