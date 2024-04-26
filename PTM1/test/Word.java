package test;

public class Word {
    
    int col;
    int row;
    Tile[] wordArr;
    boolean vertical;

    public Word(Tile[] wordArr, int row, int col, boolean vertical) {
        this.wordArr = wordArr;
        this.row = row;
        this.col = col;
        this.vertical = vertical;
    }

    public int getRow() {
        return row;
    }

    public Tile[] getWord() {
        return wordArr;
    }

    public int getCol() {
        return col;
    }

    public boolean Vertical() {
        return vertical;
    }

    @Override
    public boolean equals(Object object) {
        return super.equals(object);
    }
}
