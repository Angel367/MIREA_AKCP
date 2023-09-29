public class Main {
    public static void main(String[] args) {
        Table game = new Table();
        int hitsAmount = 10;

        Thread pingThread = new Thread(new PingPlayer(game, hitsAmount));
        Thread pongThread = new Thread(new PongPlayer(game, hitsAmount));

        pingThread.start();
        pongThread.start();
    }
}
