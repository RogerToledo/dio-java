public class HalfPrice extends Ticket {
    private double halfPriceTicket;

    public HalfPrice(String movieName, double price, boolean isDubbed) {
        super(movieName, price, isDubbed);
        setHalfPriceTicket();
    }

    public double getHalfPriceTicket() {
        return halfPriceTicket;
    }

    public void setHalfPriceTicket() {
        this.halfPriceTicket = getPrice() * 0.5;
    }
}
