package infra;
import java.util.HashSet;
import java.util.Set;
import domain.ID;
import domain.Travel;
import domain.Catalog;
import domain.CatalogRepository;

public class CatalogRepositoryInMemory implements CatalogRepository{
    private Set<Catalog> memory;

    public CatalogRepositoryInMemory  (){
        this.memory = new HashSet<>();
    }

    @Override
    public void addCatalog(Catalog catalog) {
        this.memory.add(catalog);
    }

    @Override
    public Catalog findCatalogById(ID id) {
        for (Catalog catalog : this.memory){
            System.out.println(catalog.getID());
            if(catalog.getID()==(id)){
                System.out.println("Found"); 
                System.out.println(catalog);
                return catalog;
            }
        }
        System.out.println("Pas trouvé"); // a mettre propre
        return null;
    }

   



    
}
