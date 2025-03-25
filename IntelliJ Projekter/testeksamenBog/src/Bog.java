
class Bog {
    private String title;
    private String forfatter;
    private int antalSider;

    public Bog(String title, String forfatter, int antalSider) {
        this.title = title;
        this.forfatter = forfatter;
        this.antalSider = antalSider;
    }

    public String getTitel() {
        return title;
    }

    public String getForfatter() {
        return forfatter;
    }

    public int getAntalSider() {
        return antalSider;
    }

    @Override
    public String toString() {
        return "Bog [title=" + title + ", forfatter=" + forfatter + ", antalSider=" + antalSider + "]";
    }
}