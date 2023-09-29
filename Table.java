class Table {
    private boolean isPingTurn = true;

    public synchronized void playPing() {
        try {
            while (!isPingTurn) {
                wait(); // Переходим в режим ожидания, если не наш ход
            }
            System.out.print("PING ");
            isPingTurn = false;
            notify(); // Уведомляем другой поток (Pong)
        } catch (InterruptedException ignored) {}
    }

    public synchronized void playPong() {
        try {
            while (isPingTurn) {
                wait(); // Переходим в режим ожидания, если не наш ход
            }
            System.out.print("PONG ");
            isPingTurn = true;
            notify(); // Уведомляем другой поток (Ping)
        } catch (InterruptedException ignored) {}
    }
}
