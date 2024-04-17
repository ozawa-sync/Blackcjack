package practice;

public class Player {
    public String name;//名前
    public int[] cards;//手札
    public int total;//合計値

    public Player(String name) {
        this.name = name;
        this.cards = new int[21];
    }

    public String getName() {
        return name;
    }

    public int[] getCards() {
        return cards;
    }

    public int getTotal() {
        return total;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCards(int a, int b) {
        this.cards[a] = b;
    }

    public void setTotal(int total) {
        this.total = total;
    }
}
