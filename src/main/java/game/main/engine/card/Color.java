package game.main.engine.card;

enum Color {
    SPADES('\u2660'),// ♠
    HEARTS('\u2665'), // ♥
    CLUBS('\u2663'), // ♣
    DIAMONDS('\u2666'); // ♦

    private char rank;

    Color(char c) {
        this.rank = c;
    }

    @Override
    public String toString() {
        return String.valueOf(this.rank);
    }
}