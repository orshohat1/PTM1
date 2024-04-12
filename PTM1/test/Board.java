package test;

import java.util.ArrayList;
import static java.lang.Boolean.FALSE;

public class Board {
    static final int BOARD_SIZE = 15; // The size of row
    private static Board board = null; // Singelton
    Tile[][] tilesArr = new Tile[BOARD_SIZE][BOARD_SIZE];
    int score = 0; // Determines the score of the first word on the board
    int tilesOnBoard = 0; // Determines the number of tiles on the board
    final int UP = 5, DOWN = 6, RIGHT = 7, LEFT = 8; // Directions
    final int MULTYLETTER = 1, TRIPLELETTER = 2, MULTYWORD = 3, TRIPLEWORD = 4;
    Boolean STAR = false;

    // Default constructor
    private Board() {
    }

    // Singelton
    static Board getBoard() {
        if (board == null) {
            board = new Board();
        }
        return board;
    }

    // Class that represents a single inlay on the board
    // The options for bonus in inlay: 1 = letter*2, 2 = letter*3, 3 = word*2,
    // 4=word*3
    // Star = word*2
    public static class SingleInlay {
        Boolean isTile;
        final int scoreID;
        Tile tile;

        public SingleInlay(Tile tile, Boolean isTile, int scoreid) {
            this.tile = tile;
            this.isTile = isTile;
            scoreID = scoreid;
        }
    };

    // Array of the board
    SingleInlay[][] full_board = {
            new SingleInlay[] { new SingleInlay(null, FALSE, 4),
                    new SingleInlay(null, FALSE, 0), new SingleInlay(null, FALSE, 0),
                    new SingleInlay(null, FALSE, 1), new SingleInlay(null, FALSE, 0),
                    new SingleInlay(null, FALSE, 0), new SingleInlay(null, FALSE, 0),
                    new SingleInlay(null, FALSE, 4), new SingleInlay(null, FALSE, 0),
                    new SingleInlay(null, FALSE, 0), new SingleInlay(null, FALSE, 0),
                    new SingleInlay(null, FALSE, 1), new SingleInlay(null, FALSE, 0),
                    new SingleInlay(null, FALSE, 0), new SingleInlay(null, FALSE, 1) },

            new SingleInlay[] { new SingleInlay(null, FALSE, 0), new SingleInlay(null, FALSE, 3),
                    new SingleInlay(null, FALSE, 0), new SingleInlay(null, FALSE, 0),
                    new SingleInlay(null, FALSE, 0), new SingleInlay(null, FALSE, 2),
                    new SingleInlay(null, FALSE, 0), new SingleInlay(null, FALSE, 0),
                    new SingleInlay(null, FALSE, 0), new SingleInlay(null, FALSE, 2),
                    new SingleInlay(null, FALSE, 0), new SingleInlay(null, FALSE, 0),
                    new SingleInlay(null, FALSE, 0), new SingleInlay(null, FALSE, 3),
                    new SingleInlay(null, FALSE, 0) },

            new SingleInlay[] { new SingleInlay(null, FALSE, 0), new SingleInlay(null, FALSE, 0),
                    new SingleInlay(null, FALSE, 3), new SingleInlay(null, FALSE, 0),
                    new SingleInlay(null, FALSE, 0), new SingleInlay(null, FALSE, 0),
                    new SingleInlay(null, FALSE, 1), new SingleInlay(null, FALSE, 0),
                    new SingleInlay(null, FALSE, 1), new SingleInlay(null, FALSE, 0),
                    new SingleInlay(null, FALSE, 0), new SingleInlay(null, FALSE, 0),
                    new SingleInlay(null, FALSE, 3), new SingleInlay(null, FALSE, 0),
                    new SingleInlay(null, FALSE, 0) },

            new SingleInlay[] { new SingleInlay(null, FALSE, 1), new SingleInlay(null, FALSE, 0),
                    new SingleInlay(null, FALSE, 0), new SingleInlay(null, FALSE, 3),
                    new SingleInlay(null, FALSE, 0), new SingleInlay(null, FALSE, 0),
                    new SingleInlay(null, FALSE, 0), new SingleInlay(null, FALSE, 1),
                    new SingleInlay(null, FALSE, 0), new SingleInlay(null, FALSE, 0),
                    new SingleInlay(null, FALSE, 0), new SingleInlay(null, FALSE, 3),
                    new SingleInlay(null, FALSE, 0), new SingleInlay(null, FALSE, 0),
                    new SingleInlay(null, FALSE, 1) },

            new SingleInlay[] { new SingleInlay(null, FALSE, 0), new SingleInlay(null, FALSE, 0),
                    new SingleInlay(null, FALSE, 0), new SingleInlay(null, FALSE, 0),
                    new SingleInlay(null, FALSE, 3), new SingleInlay(null, FALSE, 0),
                    new SingleInlay(null, FALSE, 0), new SingleInlay(null, FALSE, 0),
                    new SingleInlay(null, FALSE, 0), new SingleInlay(null, FALSE, 0),
                    new SingleInlay(null, FALSE, 3), new SingleInlay(null, FALSE, 0),
                    new SingleInlay(null, FALSE, 0), new SingleInlay(null, FALSE, 0),
                    new SingleInlay(null, FALSE, 0) },

            new SingleInlay[] { new SingleInlay(null, FALSE, 0), new SingleInlay(null, FALSE, 2),
                    new SingleInlay(null, FALSE, 0), new SingleInlay(null, FALSE, 0),
                    new SingleInlay(null, FALSE, 0), new SingleInlay(null, FALSE, 2),
                    new SingleInlay(null, FALSE, 0), new SingleInlay(null, FALSE, 0),
                    new SingleInlay(null, FALSE, 0), new SingleInlay(null, FALSE, 2),
                    new SingleInlay(null, FALSE, 0), new SingleInlay(null, FALSE, 0),
                    new SingleInlay(null, FALSE, 0), new SingleInlay(null, FALSE, 2),
                    new SingleInlay(null, FALSE, 0) },

            new SingleInlay[] { new SingleInlay(null, FALSE, 0), new SingleInlay(null, FALSE, 0),
                    new SingleInlay(null, FALSE, 1), new SingleInlay(null, FALSE, 0),
                    new SingleInlay(null, FALSE, 0), new SingleInlay(null, FALSE, 0),
                    new SingleInlay(null, FALSE, 1), new SingleInlay(null, FALSE, 0),
                    new SingleInlay(null, FALSE, 1), new SingleInlay(null, FALSE, 0),
                    new SingleInlay(null, FALSE, 0), new SingleInlay(null, FALSE, 0),
                    new SingleInlay(null, FALSE, 1), new SingleInlay(null, FALSE, 0),
                    new SingleInlay(null, FALSE, 0) },

            new SingleInlay[] { new SingleInlay(null, FALSE, 4), new SingleInlay(null, FALSE, 0),
                    new SingleInlay(null, FALSE, 0), new SingleInlay(null, FALSE, 1),
                    new SingleInlay(null, FALSE, 0), new SingleInlay(null, FALSE, 0),
                    new SingleInlay(null, FALSE, 0), new SingleInlay(null, FALSE, 3),
                    new SingleInlay(null, FALSE, 0), new SingleInlay(null, FALSE, 0),
                    new SingleInlay(null, FALSE, 0), new SingleInlay(null, FALSE, 1),
                    new SingleInlay(null, FALSE, 0), new SingleInlay(null, FALSE, 0),
                    new SingleInlay(null, FALSE, 4) },

            new SingleInlay[] { new SingleInlay(null, FALSE, 0), new SingleInlay(null, FALSE, 0),
                    new SingleInlay(null, FALSE, 1), new SingleInlay(null, FALSE, 0),
                    new SingleInlay(null, FALSE, 0), new SingleInlay(null, FALSE, 0),
                    new SingleInlay(null, FALSE, 1), new SingleInlay(null, FALSE, 0),
                    new SingleInlay(null, FALSE, 1), new SingleInlay(null, FALSE, 0),
                    new SingleInlay(null, FALSE, 0), new SingleInlay(null, FALSE, 0),
                    new SingleInlay(null, FALSE, 1), new SingleInlay(null, FALSE, 0),
                    new SingleInlay(null, FALSE, 0) },

            new SingleInlay[] { new SingleInlay(null, FALSE, 0), new SingleInlay(null, FALSE, 2),
                    new SingleInlay(null, FALSE, 0), new SingleInlay(null, FALSE, 0),
                    new SingleInlay(null, FALSE, 0), new SingleInlay(null, FALSE, 2),
                    new SingleInlay(null, FALSE, 0), new SingleInlay(null, FALSE, 0),
                    new SingleInlay(null, FALSE, 0), new SingleInlay(null, FALSE, 2),
                    new SingleInlay(null, FALSE, 0), new SingleInlay(null, FALSE, 0),
                    new SingleInlay(null, FALSE, 0), new SingleInlay(null, FALSE, 2),
                    new SingleInlay(null, FALSE, 0) },

            new SingleInlay[] { new SingleInlay(null, FALSE, 0), new SingleInlay(null, FALSE, 0),
                    new SingleInlay(null, FALSE, 0), new SingleInlay(null, FALSE, 0),
                    new SingleInlay(null, FALSE, 3), new SingleInlay(null, FALSE, 0),
                    new SingleInlay(null, FALSE, 0), new SingleInlay(null, FALSE, 0),
                    new SingleInlay(null, FALSE, 0), new SingleInlay(null, FALSE, 0),
                    new SingleInlay(null, FALSE, 3), new SingleInlay(null, FALSE, 0),
                    new SingleInlay(null, FALSE, 0), new SingleInlay(null, FALSE, 0),
                    new SingleInlay(null, FALSE, 0) },

            new SingleInlay[] { new SingleInlay(null, FALSE, 1), new SingleInlay(null, FALSE, 0),
                    new SingleInlay(null, FALSE, 0), new SingleInlay(null, FALSE, 3),
                    new SingleInlay(null, FALSE, 0), new SingleInlay(null, FALSE, 0),
                    new SingleInlay(null, FALSE, 0), new SingleInlay(null, FALSE, 1),
                    new SingleInlay(null, FALSE, 0), new SingleInlay(null, FALSE, 0),
                    new SingleInlay(null, FALSE, 0), new SingleInlay(null, FALSE, 3),
                    new SingleInlay(null, FALSE, 0), new SingleInlay(null, FALSE, 0),
                    new SingleInlay(null, FALSE, 1) },

            new SingleInlay[] { new SingleInlay(null, FALSE, 0), new SingleInlay(null, FALSE, 0),
                    new SingleInlay(null, FALSE, 3), new SingleInlay(null, FALSE, 0),
                    new SingleInlay(null, FALSE, 0), new SingleInlay(null, FALSE, 0),
                    new SingleInlay(null, FALSE, 1), new SingleInlay(null, FALSE, 0),
                    new SingleInlay(null, FALSE, 1), new SingleInlay(null, FALSE, 0),
                    new SingleInlay(null, FALSE, 0), new SingleInlay(null, FALSE, 0),
                    new SingleInlay(null, FALSE, 3), new SingleInlay(null, FALSE, 0),
                    new SingleInlay(null, FALSE, 0) },

            new SingleInlay[] { new SingleInlay(null, FALSE, 0), new SingleInlay(null, FALSE, 3),
                    new SingleInlay(null, FALSE, 0), new SingleInlay(null, FALSE, 0),
                    new SingleInlay(null, FALSE, 0), new SingleInlay(null, FALSE, 2),
                    new SingleInlay(null, FALSE, 0), new SingleInlay(null, FALSE, 0),
                    new SingleInlay(null, FALSE, 0), new SingleInlay(null, FALSE, 2),
                    new SingleInlay(null, FALSE, 0), new SingleInlay(null, FALSE, 0),
                    new SingleInlay(null, FALSE, 0), new SingleInlay(null, FALSE, 3),
                    new SingleInlay(null, FALSE, 0) },

            new SingleInlay[] { new SingleInlay(null, FALSE, 4),
                    new SingleInlay(null, FALSE, 0), new SingleInlay(null, FALSE, 0),
                    new SingleInlay(null, FALSE, 1), new SingleInlay(null, FALSE, 0),
                    new SingleInlay(null, FALSE, 0), new SingleInlay(null, FALSE, 0),
                    new SingleInlay(null, FALSE, 4), new SingleInlay(null, FALSE, 0),
                    new SingleInlay(null, FALSE, 0), new SingleInlay(null, FALSE, 0),
                    new SingleInlay(null, FALSE, 1), new SingleInlay(null, FALSE, 0),
                    new SingleInlay(null, FALSE, 0), new SingleInlay(null, FALSE, 1) }
    };

    // Returns a copy of tiles array from the board
    Tile[][] getTiles() {
        Tile[][] copyTiles = new Tile[BOARD_SIZE][BOARD_SIZE];
        for (int i = 0; i < BOARD_SIZE; i++) {
            for (int j = 0; j < BOARD_SIZE; j++) {
                if (full_board[i][j].tile != null) {
                    copyTiles[i][j] = full_board[i][j].tile;
                    tilesArr[i][j] = full_board[i][j].tile;
                } else {
                    copyTiles[i][j] = null;
                }
            }
        }
        return copyTiles;
    }

    // Checks whether a word runs over existing tiles on the board
    private Boolean isRunOverTiles(Word word) {

        int row = word.getRow();
        int col = word.getCol();

        for (int i = 0; i < word.wordArr.length; i++) {
            if (getTiles()[row][col] == null) {
                break;
            }
            if (getTiles()[row][col] != null && word.wordArr[i] != null) {
                if (getTiles()[row][col].letter != word.wordArr[i].letter) {
                    return Boolean.TRUE;
                }
            }
            if (word.Vertical()) {
                row++;
            } else {
                col++;
            }
        }
        return Boolean.FALSE;
    }

    // Checks if a certain word out of the board boundries
    private Boolean isWordOnBoard(Word word) {

        int row = word.getRow();
        int col = word.getCol();

        if (row >= BOARD_SIZE || col >= BOARD_SIZE || col < 0 || row < 0) {
            return Boolean.FALSE;
        }
        if (!word.Vertical() && (col + word.wordArr.length > BOARD_SIZE)) {
            return Boolean.FALSE;
        }
        if (word.Vertical() && (row + word.wordArr.length > BOARD_SIZE)) {
            return Boolean.FALSE;
        }
        return Boolean.TRUE;
    }

    // Checks if a word is on star
    private Boolean isWordOnStar(Word word) {

        int col = word.getCol();
        int row = word.getRow();

        if (word.Vertical()) {
            if (row <= BOARD_SIZE / 2 && row + word.wordArr.length - 1 >= BOARD_SIZE / 2
                    && col == BOARD_SIZE / 2)
                return true;
            return false;
        } else {
            if (col <= BOARD_SIZE / 2 && col + word.wordArr.length - 1 >= BOARD_SIZE / 2
                    && row == BOARD_SIZE / 2)
                return true;
            return false;
        }
    }

    // Checks if the board is empty
    private Boolean isBoardEmpty() {
        if (tilesOnBoard != 0) {
            return Boolean.FALSE;
        } else {
            return Boolean.TRUE;
        }
    }

    // Checks if there is a certain word is overlapping
    private Boolean isWordOverLapping(Word w) {
        int row = w.getRow();
        int col = w.getCol();
        for (int i = 0; i < w.wordArr.length; i++) {
            if (getTiles()[row][col] != null && w.wordArr[i] != null &&
                    getTiles()[row][col].letter == w.wordArr[i].letter) {
                return Boolean.TRUE;
            }
            if (getTiles()[row][col] != null && w.wordArr[i] == null) {
                return Boolean.TRUE;
            }
        }
        return Boolean.FALSE;
    }

    // Determines whether a given word is adjacent to any existing tiles on the game
    // board
    private Boolean WordAjacent(Word w) {
        int row = w.getRow();
        int col = w.getCol();
        for (int i = 0; i < w.wordArr.length; i++) {
            if (row + 1 == BOARD_SIZE && col + 1 == BOARD_SIZE) {
                if (getTiles()[row - 1][col] != null || getTiles()[row][col - 1] != null) {
                    return Boolean.TRUE;
                }
            }
            if (row + 1 == BOARD_SIZE && col == 0) {
                if (getTiles()[row - 1][col] != null || getTiles()[row][col + 1] != null) {
                    return Boolean.TRUE;
                }
            }
            if (row == 0 && col + 1 == BOARD_SIZE) {
                if (getTiles()[row + 1][col] != null || getTiles()[row][col - 1] != null) {
                    return Boolean.TRUE;
                }
            }
            if (row == 0 && col == 0) {
                if (getTiles()[row + 1][col] != null || getTiles()[row][col + 1] != null) {
                    return Boolean.TRUE;
                }
            }
            if (row + 1 == BOARD_SIZE) {
                if (getTiles()[row - 1][col] != null || getTiles()[row][col + 1] != null ||
                        getTiles()[row][col - 1] != null) {
                    return Boolean.TRUE;
                }
            }
            if (col == 0) {
                if (getTiles()[row][col + 1] != null || getTiles()[row + 1][col] != null ||
                        getTiles()[row - 1][col] != null) {
                    return Boolean.TRUE;
                }
            }
            if (row == 0) {
                if (getTiles()[row + 1][col] != null || getTiles()[row][col + 1] != null ||
                        getTiles()[row][col - 1] != null) {
                    return Boolean.TRUE;
                }
            }
            if (row > 0 && row < BOARD_SIZE && col > 0 && col < BOARD_SIZE) {
                if (getTiles()[row + 1][col] != null || getTiles()[row - 1][col] != null ||
                        getTiles()[row][col - 1] != null || getTiles()[row][col + 1] != null) {
                    return Boolean.TRUE;
                }
            }
            if (col + 1 == BOARD_SIZE) {
                if (getTiles()[row][col - 1] != null || getTiles()[row - 1][col] != null ||
                        getTiles()[row + 1][col] != null) {
                    return Boolean.TRUE;
                }
            }
            if (w.Vertical()) {
                row++;
            } else {
                col++;
            }
        }
        return Boolean.FALSE;
    }

    // this function returns if the given word if legal
    Boolean isBoardValid(Word word) {
        if (!isWordOnBoard(word)) {
            return Boolean.FALSE;
        }
        if (isBoardEmpty()) {
            if (!isWordOnStar(word)) {
                return Boolean.FALSE;
            } else {
                return Boolean.TRUE;
            }
        }
        if (isRunOverTiles(word)) {
            return Boolean.FALSE;
        }
        if (!WordAjacent(word) && !isWordOverLapping(word)) {
            return Boolean.FALSE;
        }
        return Boolean.TRUE;
    }

    // place the word of the real board
    private void placeWord(Word w) {
        int row = w.getRow();
        int col = w.getCol();
        for (int i = 0; i < w.wordArr.length; i++) {
            if (w.wordArr[i] != null && full_board[row][col].tile == null &&
                    full_board[row][col].tile != w.wordArr[i]) {
                full_board[row][col].tile = w.wordArr[i];
                full_board[row][col].isTile = true;
                tilesOnBoard++;
            }
            if (w.Vertical()) {
                row++;
            } else {
                col++;
            }
        }
    }

    // Generates an ArrayList of new words
    ArrayList<Word> generateWords(Word word) {

        ArrayList<Word> wordList = new ArrayList<Word>();
        Tile[][] tmp = getTiles();

        // Adding the word from the game board to a virtual board
        addOnVirtualBoard(tmp, word);
        int start = 0;
        int end = 0;

        // Col doesn't change
        if (word.Vertical()) {
            // 426-428 Gets a vertical word
            start = searchWordOnBoard(tmp, word.getRow(), word.getCol(), UP);
            end = searchWordOnBoard(tmp, word.getRow() + word.wordArr.length - 1, word.getCol(), DOWN);
            wordList.add(fetchWord(tmp, start, word.getCol(), end - start + 1, word.Vertical()));

            // Gets the horizontal words - Iterates through the vertical word
            for (int i = 0; i < word.wordArr.length; i++) {
                if (word.wordArr[i] == null) {
                    continue;
                }
                start = searchWordOnBoard(tmp, word.getRow() + i, word.getCol(), LEFT);
                end = searchWordOnBoard(tmp, word.getRow() + i, word.getCol(), RIGHT);
                if (start != end)
                    wordList.add(fetchWord(tmp, word.getRow() + i, start, end - start + 1, !word.Vertical()));
            }
        } else // Row doesn't change
        {
            // 445-447 gets horizontal word
            start = searchWordOnBoard(tmp, word.getRow(), word.getCol(), LEFT);
            end = searchWordOnBoard(tmp, word.getRow(), word.getCol() + word.wordArr.length - 1, RIGHT);
            wordList.add(fetchWord(tmp, word.getRow(), start, end - start + 1, word.Vertical()));

            // Gets the vertical words - Iterates through the horizontal word
            for (int i = 0; i < word.wordArr.length; i++) {
                if (word.wordArr[i] == null) {
                    continue;
                }
                start = searchWordOnBoard(tmp, word.getRow(), word.getCol() + i, UP);
                end = searchWordOnBoard(tmp, word.getRow(), word.getCol() + i, DOWN);
                if (start != end) {
                    wordList.add(fetchWord(tmp, start, word.getCol() + i, end - start + 1, !word.Vertical()));
                }
            }
        }
        for (Word w : wordList) {
            placeWord(w);
        }
        return wordList;
    }

    // Place the word on the virtual board
    private void addOnVirtualBoard(Tile[][] arr, Word word) {

        int col = word.getCol();
        int row = word.getRow();

        for (int i = 0; i < word.wordArr.length; i++) {
            if (word.wordArr[i] != null) {
                arr[row][col] = word.wordArr[i];
            }
            if (word.Vertical()) {
                row++;
            } else {
                col++;
            }
        }

        if (arr == tilesArr) {
            tilesOnBoard += word.wordArr.length;
        }
    }

    // Copy the entire word and return the current word excluding null tiles
    private Word fetchWord(Tile[][] arr, int row, int col, int length, boolean vertical) {

        Tile[] wordTilesArr = new Tile[length];
        Word word;

        // Col doesn't change
        if (vertical) {
            for (int i = 0; i < wordTilesArr.length; i++) {
                wordTilesArr[i] = arr[row + i][col];
            }
        } else {
            for (int i = 0; i < wordTilesArr.length; i++) {
                wordTilesArr[i] = arr[row][col + i];
            }
        }
        word = new Word(wordTilesArr, row, col, vertical);
        return word;
    }

    private int searchWordOnBoard(Tile[][] arr, int row, int col, int direction) {
        for (int i = 0; i < BOARD_SIZE; i++) {
            if (row > BOARD_SIZE - 1 || row < 0 || col < 0 || arr[row][col] == null || col > BOARD_SIZE - 1) {
                break;
            }
            switch (direction) {
                case UP:
                    row--;
                    break;
                case DOWN:
                    row++;
                    break;
                case RIGHT:
                    col++;
                    break;
                case LEFT:
                    col--;
                    break;
            }
        }
        // Moving backwards to the first non-null tile
        switch (direction) {
            case UP:
                row++;
                break;
            case DOWN:
                row--;
                break;
            case RIGHT:
                col--;
                break;
            case LEFT:
                col++;
                break;
        }
        if (direction == DOWN || direction == UP)
            return row;
        else
            return col;
    }

    // Calculates the score of a word placed on the game board in game
    int calcScore(Word word) {

        int col = word.getCol();
        int row = word.getRow();
        int length = word.wordArr.length;
        int multiple = 1;
        int score = 0;
        if (word.Vertical()) {
            for (int i = 0; i < length; i++) {
                if (full_board[row + i][col].scoreID == MULTYLETTER) {
                    score += 2 * word.wordArr[i].score;
                } else if (full_board[row + i][col].scoreID == TRIPLELETTER) {
                    score += 3 * word.wordArr[i].score;
                } else if (full_board[row + i][col].scoreID == MULTYWORD) {
                    if (row + i == 7 && col == 7 && STAR == false) {
                        score += word.wordArr[i].score;
                        multiple *= 2;
                        STAR = true;
                    } else if (STAR == true && row + i == 7 && col == 7) {
                        score += word.wordArr[i].score;
                    } else {
                        multiple *= 2;
                        score += word.wordArr[i].score;
                    }

                } else if (full_board[row + i][col].scoreID == TRIPLEWORD) {
                    multiple *= 3;
                    score += word.wordArr[i].score;
                } else // There isn't any bonus tile
                {
                    score += word.wordArr[i].score;
                }
            }
        } else
        {
            for (int i = 0; i < length; i++) {
                if (full_board[row][col + i].scoreID == MULTYLETTER) {
                    score += 2 * word.wordArr[i].score;
                } else if (full_board[row][col + i].scoreID == TRIPLELETTER) {
                    score += 3 * word.wordArr[i].score;
                } else if (full_board[row][col + i].scoreID == MULTYWORD) {
                    if (STAR == false && row == 7 && col + i == 7) {
                        multiple *= 2;
                        score += word.wordArr[i].score;
                        STAR = true;
                    } else if (STAR == true && row == 7 && col + i == 7) {
                        score += word.wordArr[i].score;
                    } else {
                        multiple *= 2;
                        score += word.wordArr[i].score;
                    }
                } else if (full_board[row][col + i].scoreID == TRIPLEWORD) {
                    multiple *= 3;
                    score += word.wordArr[i].score;
                } else// there isnt any bonus tile
                {
                    score += word.wordArr[i].score;
                }
            }
        }
        return score * multiple;
    }

    // Attempts to place a word on the game board and calculates the total score if the word placement is valid
    int attemptPlaceWord(Word w) {

        int score = 0;
        if (isBoardValid(w)) {
            ArrayList<Word> wordList = generateWords(w);
            for (Word word : wordList) {
                placeWord(word);
            }
            for (Word word : wordList) {
                score += calcScore(word);
            }
        }
        return score;
    }
}