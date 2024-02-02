package TrainingjavaSpringBoot.people.repository;

import TrainingjavaSpringBoot.people.entity.PeopleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PeopleRepository extends JpaRepository<PeopleEntity, String> {
}
