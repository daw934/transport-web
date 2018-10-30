package pl.transport.transportapp.serviceNew;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public class JpaService<T> {
    protected JpaRepository<T,Long> jpaRepository;
    public JpaService(JpaRepository<T,Long> jpaRepository){
        this.jpaRepository = jpaRepository;
    }

    public void add(T t){
        jpaRepository.save(t);
    }

    public void remove(long id){
        jpaRepository.deleteById(id);
    }
    public T get(long id){
        return jpaRepository.getOne(id);
    }

    public List<T> getAll(){
        return jpaRepository.findAll();
    }

    public void update(T t){
        jpaRepository.save(t);
    }

    public void insertOrUpdate(T t){
        jpaRepository.save(t);
    }



}
