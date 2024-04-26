package test;

import java.util.Random;

public class Tile {

    final public int score;
    final public char letter;

    // Constructor
    private Tile(char letter, int score) {
        this.letter = letter;
        this.score = score;
    }

    private char getLetter() {
        return this.letter;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object o) {
        return super.equals(o);
    }

    public static class Bag {

        private static int numOfTile = 98;
        private static Bag bag = null;

        Tile[] tile_arr = { new Tile('A', 1), new Tile('B', 3),
                new Tile('C', 3), new Tile('D', 2), new Tile('E', 1),
                new Tile('F', 4), new Tile('G', 2), new Tile('H', 4),
                new Tile('I', 1), new Tile('J', 8), new Tile('K', 5),
                new Tile('L', 1), new Tile('M', 3), new Tile('N', 1),
                new Tile('O', 1), new Tile('P', 3), new Tile('Q', 10),
                new Tile('R', 1), new Tile('S', 1), new Tile('T', 1),
                new Tile('U', 1), new Tile('V', 4), new Tile('W', 4),
                new Tile('X', 8), new Tile('Y', 4), new Tile('Z', 10) };

        int[] tileQuantity = { 9, 2, 2, 4, 12, 2, 3, 2, 9, 1, 1, 4, 2, 6, 8, 2, 1, 6, 4, 6, 4, 2, 2, 1, 2, 1 };
        static int[] maxTileQuantity = { 9, 2, 2, 4, 12, 2, 3, 2, 9, 1, 1, 4, 2, 6, 8, 2, 1, 6, 4, 6, 4, 2, 2, 1, 2,
                1 };

        int getSize() {
            return numOfTile;
        }

        // Identify the indices of tiles that still have a quantity greater than 0
        // (i.e., they exist) in the collection of tiles
        int[] FindIndex() {
            int size = 0;
            int[] arr1 = getQuantities();
            for (int i : arr1) {
                if (i > 0) {
                    size++;
                }
            }
            int[] arr_exsist = new int[size];
            for (int i = 0, j = 0; i < tileQuantity.length; i++) {
                if (this.tileQuantity[i] > 0) {
                    arr_exsist[j] = this.tileQuantity[i];
                    j++;
                }
            }
            return arr_exsist;
        }

        // Select a random tile from a collection of tiles
        Tile getRand() {
            int i;
            if (this.getSize() == 0) {
                return null;
            }
            Random r = new Random();
            int[] a = FindIndex();
            i = r.nextInt(a.length);
            numOfTile--;
            this.tileQuantity[a[i]]--;
            return this.tile_arr[a[i]];
        }

        // Adds a tile to the collection of tiles
        void put(Tile tile) {
            if (numOfTile == 98)
                return;
            for (int i = 0; i < this.tile_arr.length; i++) {
                if (this.tile_arr[i] == tile) {
                    numOfTile++;
                    this.tileQuantity[i]++;
                }
            }
        }

        // Returns an array containing the quantities of tiles in the collection
        int[] getQuantities() {
            int[] arr = new int[26];
            for (int i = 0; i < this.tileQuantity.length; i++) {
                arr[i] = tileQuantity[i];
            }
            return arr;
        }

        // Retrieves a tile with a specific letter from the collection of tiles
        Tile getTile(char letter) {
            if (letter > 'Z' || letter < 'A') {
                return null;
            }
            for (int i = 0; i < this.tile_arr.length; i++) {
                if (this.tile_arr[i].getLetter() == letter && this.tileQuantity[i] > 0) {
                    this.tileQuantity[i]--;
                    return this.tile_arr[i];
                }
            }
            return null;
        }

        // Provides access to a singleton instance of the Bag class
        public static Bag getBag() {
            if (bag == null) {
                bag = new Bag();
            }
            return bag;
        }
    }
}
