public abstract class Ticket {
    private String movieName;
    private double price;
    private boolean isDubbed;

    public Ticket(String movieName, double price, boolean isDubbed) {
        this.movieName = movieName;
        this.price = price;
        this.isDubbed = isDubbed;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public boolean isDubbed() {
        return isDubbed;
    }

    public void setDubbed(boolean dubbed) {
        isDubbed = dubbed;
    }
}
