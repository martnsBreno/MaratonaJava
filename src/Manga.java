import java.util.Objects;

public class Manga implements Comparable<Manga> {

    private Long id;
    private String nomeManga;
    private double preco;
    private int quantidade;

    public Manga(Long id, String nomeManga, double preco) {
        Objects.requireNonNull(id, "Campo ID nao pode ser nulo");
        Objects.requireNonNull(nomeManga, "Campo nome nao pode ser nulo");
        Objects.requireNonNull(preco, "Campo preço nao pode ser nulo");
        this.id = id;
        this.nomeManga = nomeManga;
        this.preco = preco;
    }

    public Manga(Long id, String nomeManga, double preco, int quantidade) {
        this(id, nomeManga, preco);
        this.quantidade = quantidade;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomeManga() {
        return nomeManga;
    }

    public void setNomeManga(String nomeManga) {
        this.nomeManga = nomeManga;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public int getQuantidade() {
        return quantidade;
    }

    @Override
    public String toString() {
        return "Manga" +
                "id=" + id +
                ", nomeManga='" + nomeManga + '\'' +
                ", preco=" + preco +
                ", quantidade=" + quantidade ;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Manga manga = (Manga) o;
        return Double.compare(manga.preco, preco) == 0 && id.equals(manga.id) && nomeManga.equals(manga.nomeManga);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nomeManga, preco);
    }

    @Override
    public int compareTo(Manga o) {
        //negativo se o this < manga
        //se o this == manga return 0
        //se o this > manga return positivo
        return this.getNomeManga().compareTo(o.getNomeManga());
    }
}
