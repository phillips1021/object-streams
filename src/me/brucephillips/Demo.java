package me.brucephillips;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

public class Demo {


    public void run() {

        List<Painter> painters = new ArrayList<>();

        for (int i = 1; i <= 100; i++) {

            int randomInt = new Random().nextInt(3) + 1;
            boolean available = i % randomInt == 0;
            double costFactor = Math.random() + 1;
            double experienceFactor = Math.random() + 1;
            double rating = ThreadLocalRandom.current().nextDouble(1, 5);

            HousePainter housePainter = new HousePainter( available, "painter_" + i,
                    costFactor, experienceFactor, rating);

            painters.add(housePainter);

        }

        PainterService painterService = new PainterServiceImpl();

        Optional<Painter> cheapestPainter = painterService.findCheapest(1000, painters);

        if (cheapestPainter.isPresent()) {
            System.out.println("Cheapest painter is " + cheapestPainter.get() +
                    " at a cost of " + cheapestPainter.get().estimateCompensation(1000) +
                    " and will take " + cheapestPainter.get().estimateTimeToPaint(1000) +
                    " and has a rating of " + cheapestPainter.get().getRating());
        } else {
            System.out.println("Cheapest painter not found.");
        }

        Optional<Painter> fastestPainter = painterService.findFastest(1000, painters);

        if (fastestPainter.isPresent()) {
            System.out.println("Fastest painter is " + fastestPainter.get() +
                    " at a cost of " + fastestPainter.get().estimateCompensation(1000) +
                    " and will take " + fastestPainter.get().estimateTimeToPaint(1000) +
                    " and has a rating of " + cheapestPainter.get().getRating());
        } else {
            System.out.println("Fastest painter not found.");
        }

        Optional<Painter> highestRatedPainter = painterService.findHighestRated( painters );

        if (highestRatedPainter.isPresent()) {
            System.out.println("Highest rated painter is " + highestRatedPainter.get() +
                    " at a cost of " + highestRatedPainter.get().estimateCompensation(1000) +
                    " and will take " + highestRatedPainter.get().estimateTimeToPaint(1000) +
                    " and has a rating of " + highestRatedPainter.get().getRating());
        } else {
            System.out.println("Highest rated painter not found.");
        }

        Optional<Painter> cheapestPainterAboveMinimumRating =
                painterService.findCheapestWithMinimumRating(1000, 4.5, painters);

        if (cheapestPainterAboveMinimumRating.isPresent()) {
            System.out.println("Cheapest painter with minimum of 4.5 rating is " + cheapestPainterAboveMinimumRating.get() +
                    " at a cost of " + cheapestPainterAboveMinimumRating.get().estimateCompensation(1000) +
                    " and will take " + cheapestPainterAboveMinimumRating.get().estimateTimeToPaint(1000) +
                    " and has a rating of " + cheapestPainterAboveMinimumRating.get().getRating());
        } else {
            System.out.println("Cheapest painter with a minimum rating of 4.5 not found.");
        }


    }
}