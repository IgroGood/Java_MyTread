class MyTread extends Thread {
    private final String name;
    private final Character[] mass;
    private final Character symbol;
    private final int startIndex;
    private final int steep;

    MyTread(String name, Character[] mass, char symbol, int startIndex, int steep){
        System.out.printf(name + " startIndex: %d\n", startIndex);
        this.name = name;
        this.mass = mass;
        this.symbol = symbol;
        this.startIndex = startIndex;
        this.steep = steep;
    }

    @Override
    public void run() {
        super.run();
        int nextId = startIndex;
        System.out.printf("%s - startIndex: %d, nextId: %d\n",name, startIndex, nextId);
        while (nextId >= 0 && nextId < mass.length){
            synchronized (mass) {
                if (mass[nextId] != ' ')
                    return;
                mass[nextId] = symbol;
            }
            nextId += steep;
        }
    }
}