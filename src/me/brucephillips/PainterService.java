package me.brucephillips;

import java.util.List;
import java.util.Optional;

public interface PainterService {

    /**
     * For the provided list of Painter objects find
     * the cheapest Painter for the provided square meters.
     * @param sqMeters - square meters
     * @param painters - Collection of Painter objects
     * @return Optional Painter
     */
    Optional<Painter> findCheapest(double sqMeters, List<Painter> painters);

    Optional<Painter> findFastest(double sqMeters, List<Painter> painters);

    Optional<Painter> findHighestRated(List<Painter> painters);

    Optional<Painter> findCheapestWithMinimumRating(double sqMeters, double minimumRating, List<Painter> painters);
}
