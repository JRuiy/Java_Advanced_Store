package ua.lvlv.store.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import ua.lvlv.store.domain.Bucket;

public interface BucketRepository extends JpaRepository<Bucket, Integer>{

}
