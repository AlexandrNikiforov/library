package com.alexnikiforov.library.domain;

public class BookRating {
    private long oneStarVotes;
    private long twoStarVotes;
    private long threeStarVotes;

    private long fourStarVotes;
    private long fiveStarVotes;
    private double averageRating;

    public long getOneStarVotes() {
        return oneStarVotes;
    }

    public void setOneStarVotes(long oneStarVotes) {
        this.oneStarVotes = oneStarVotes;
        this.averageRating = calculateAverageRating();
    }

    public long getTwoStarVotes() {
        return twoStarVotes;
    }

    public void setTwoStarVotes(long twoStarVotes) {
        this.twoStarVotes = twoStarVotes;
        this.averageRating = calculateAverageRating();
    }

    public long getThreeStarVotes() {
        return threeStarVotes;
    }

    public void setThreeStarVotes(long threeStarVotes) {
        this.threeStarVotes = threeStarVotes;
        this.averageRating = calculateAverageRating();
    }

    public long getFourStarVotes() {
        return fourStarVotes;
    }

    public void setFourStarVotes(long fourStarVotes) {
        this.fourStarVotes = fourStarVotes;
        this.averageRating = calculateAverageRating();
    }

    public long getFiveStarVotes() {
        return fiveStarVotes;
    }

    public void setFiveStarVotes(long fiveStarVotes) {
        this.fiveStarVotes = fiveStarVotes;
        this.averageRating = calculateAverageRating();
    }

    long getVotesForGivenStar(RatingStar ratingStar) {
        return switch (ratingStar) {
            case RatingStar.ONE_STAR -> getOneStarVotes();
            case RatingStar.TWO_STARS -> getTwoStarVotes();
            case RatingStar.THREE_STARS -> getThreeStarVotes();
            case RatingStar.FOUR_STARS -> getFourStarVotes();
            case RatingStar.FIVE_STARS -> getFiveStarVotes();
        };
    }

    void incrementVoteForGivenStar(RatingStar ratingStar) {
        switch (ratingStar) {
            case RatingStar.ONE_STAR -> setOneStarVotes(getOneStarVotes() + 1);
            case RatingStar.TWO_STARS -> setTwoStarVotes(getTwoStarVotes() + 1);
            case RatingStar.THREE_STARS -> setThreeStarVotes(getThreeStarVotes() + 1);
            case RatingStar.FOUR_STARS -> setFourStarVotes(getFourStarVotes() + 1);
            case RatingStar.FIVE_STARS -> setFiveStarVotes(getFiveStarVotes() + 1);
        };
    }

    private double calculateAverageRating() {
        long totalVotes = getNumberOfVotes();
        if (totalVotes == 0) {
            return 0.0;
        }
        double sum = (1 * oneStarVotes) + (2 * twoStarVotes) +
                (3 * threeStarVotes)
                + (4 * fourStarVotes) + (5 * fiveStarVotes);
        return sum / totalVotes;
    }

    public long getNumberOfVotes() {
        return oneStarVotes + twoStarVotes +
                threeStarVotes + fourStarVotes + fiveStarVotes;
    }

    public double getAverageRating() {
        return this.averageRating;
    }

}
