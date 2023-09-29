class PingPlayer implements Runnable {
    private final Table table;
    private final int hitsAmount;

    public PingPlayer(Table table, int hitsAmount) {
        this.table = table;
        this.hitsAmount = hitsAmount;
    }

    @Override
    public void run() {
        for (int i = 0; i < hitsAmount; i++) {
            table.playPing();
        }
    }
}
