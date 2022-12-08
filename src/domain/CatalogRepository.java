package domain;

public interface CatalogRepository {
    public void addCatalog(Catalog catalog);
    public Catalog findCatalogById(ID id);
}
