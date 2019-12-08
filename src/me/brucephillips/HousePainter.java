package me.brucephillips;

import java.math.BigDecimal;
import java.time.Duration;


public class HousePainter implements Painter {

    private boolean available;

    private String name;

    private double costFactor;

    private double experienceFactor ;

    private double rating;

    public HousePainter(boolean available, String name, double costFactor, double experienceFactor, double rating) {
        this.available = available;
        this.name = name;
        this.costFactor = costFactor;
        this.experienceFactor = experienceFactor;
        this.rating = rating;

    }

    @Override
    public boolean isAvailable() {
        return available;
    }

    @Override
    public Duration estimateTimeToPaint(double sqMeters) {

        return Duration.ofMinutes( Double.valueOf(sqMeters * experienceFactor).longValue() );

    }

    @Override
    public Money estimateCompensation(double sqMeters) {
        return new Money( BigDecimal.valueOf(sqMeters * costFactor));
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public double getRating() {
        return rating;
    }

    @Override
    public String toString() {
        return "HousePainter{" +
                "available=" + available +
                ", name='" + name + '\'' +
                ", costFactor=" + costFactor +
                ", experienceFactor=" + experienceFactor +
                ", rating=" + rating +
                '}';
    }
}
