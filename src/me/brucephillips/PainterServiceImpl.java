package me.brucephillips;

import java.util.List;
import java.util.Optional;

public class PainterServiceImpl implements PainterService {

    public Optional<Painter> findCheapest(double sqMeters, List<Painter> painters) {
        return Painter.stream(painters).available().cheapest(sqMeters);
    }

    @Override
    public Optional<Painter> findFastest(double sqMeters, List<Painter> painters) {
        return Painter.stream(painters).available().fastest(sqMeters);
    }

    @Override
    public Optional<Painter> findHighestRated(List<Painter> painters) {
        return Painter.stream(painters).available().highestRated();
    }

    @Override
    public Optional<Painter> findCheapestWithMinimumRating(double sqMeters, double minimumRating, List<Painter> painters) {
        return Painter.stream(painters).available().ratedAbove(minimumRating).cheapest(sqMeters);
    }


}
