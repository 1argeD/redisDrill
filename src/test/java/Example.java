import org.example.Entity.Entity;
import org.example.Repository.Repository;
import org.junit.jupiter.api.Test;

public class Example {

    private Repository repo;

    @Test
    void test(){
        Entity gel = new Entity(500,"thailand");

        repo.save()

        repo.findById(gel.getId());
        /*Entity에 @RedisHash 에 정의되어 있는 keyspace (Physiogel)에 속한 키의 갯수를 구함*/
        repo.count();

        repo.delete(gel);
    }
}