package me.brucephillips;

import java.util.Comparator;
import java.util.Optional;
import java.util.stream.Stream;

public class PaintersStream implements ForwardingStream<Painter> {
    private Stream<Painter> stream;

    public PaintersStream(Stream<Painter> stream) {
        this.stream = stream;
    }

    @Override
    public Stream<Painter> getStream() { return this.stream; }

    public PaintersStream available() {
        return new PaintersStream(this.getStream().filter(Painter::isAvailable));
    }

    public Optional<Painter> cheapest(double sqMeters) {
        return this.getStream()
            .min(Comparator.comparing(painter -> painter.estimateCompensation(sqMeters)));
    }

    public Optional<Painter> fastest(double sqMeters) {
        return this.getStream()
                .min(Comparator.comparing(painter -> painter.estimateTimeToPaint(sqMeters)));
    }

    public Optional<Painter> highestRated() {

        return this.getStream()
                .max(Comparator.comparing(painter -> painter.getRating()));
    }

    public PaintersStream ratedAbove(double rating) {

        return new PaintersStream( this.getStream().filter(painter -> painter.getRating() > rating));

    }
}
