package WorkingWithAbstractionExcercise.jediGalaxy;


public class Galaxy {
    private StarsField field;

    public Galaxy(StarsField starsField) {
        this.field = starsField;
    }
    //moveEvil, moveJedi

    public void moveEvil(int currentRowEvil, int currentColEvil) {
        while (currentRowEvil >= 0 && currentColEvil >= 0) {
            if (field.isInBounds(currentRowEvil, currentColEvil)) {
               field.setValue(currentRowEvil,currentColEvil, 0);
            }
            currentRowEvil--;
            currentColEvil--;
        }
    }

    public long moveJedi(int currentRowJedi, int currentColJedi) {
        long starsCollected = 0;
        while (currentRowJedi >= 0 && currentColJedi < this.field.getColLength()) {
            if (field.isInBounds(currentRowJedi, currentColJedi)) {
                starsCollected += field.getValue(currentRowJedi,currentColJedi);
            }

            currentColJedi++;
            currentRowJedi--;
        }
        return starsCollected;
    }
}
