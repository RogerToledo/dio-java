public class FamilyTicket extends Ticket{

    private int numberOfTickets;
    private double familyTicketPrice;
    private boolean isFamilyTicket;

    public FamilyTicket(String movieName, double price, boolean isDubbed) {
        super(movieName, price, isDubbed);
    }

    public FamilyTicket(String movieName, double price, boolean isDubbed, int numberOfTickets) {
        super(movieName, price, isDubbed);
        this.numberOfTickets = numberOfTickets;
        setFamilyTicketPrice();
    }

    public double getFamilyTicketPrice() {
        return familyTicketPrice;
    }

    private void setFamilyTicketPrice() {
        double totalPrice;

        if (numberOfTickets >= 3 ) {
            setFamilyTicket(true);
            var price = getPrice() * numberOfTickets;
            var off = price * 0.05;

            totalPrice = price - off;

        } else {
            setFamilyTicket(false);
            totalPrice = getPrice() * numberOfTickets;
        }

        this.familyTicketPrice = totalPrice;
    }

    public int getNumberOfTickets() {
        return numberOfTickets;
    }

    private void setNumberOfTickets(int numberOfTickets) {
        this.numberOfTickets = numberOfTickets;
    }

    public boolean isFamilyTicket() {
        return isFamilyTicket;
    }

    public void setFamilyTicket(boolean familyTicket) {
        isFamilyTicket = familyTicket;
    }
}
