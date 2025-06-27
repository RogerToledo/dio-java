public non-sealed class USClock extends Clock {
    private String period;

    public String getPeriod() {
        return period;
    }

    public void setAfterMidDay() {
        this.period = "PM";
    }

    public void setBeforMidDay() {
        this.period = "AM";
    }

    public void setHour(int hour) {
        setBeforMidDay();

        if (hour > 12 && hour <= 23) {
            setAfterMidDay();
            this.hour = hour - 12;
        } else if (hour >= 24) {
            this.hour = 0;
        } else {
            this.hour = hour;
        }
    }

    public String getTime() {
        return super.getTime() + " " + this.getPeriod();
    }

    @Override
    Clock convert(Clock clock) {
        this.second = clock.getSecond();
        this.minute = clock.getMinute();

        switch (clock) {
            case USClock usClock -> {
                this.hour = usClock.getHour();
                this.period = usClock.getPeriod();
            }
            case BRClock brClock -> this.setHour(brClock.getHour());
        }

        return  this;
    }
}
