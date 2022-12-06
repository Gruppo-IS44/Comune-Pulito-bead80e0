package com.project.comunepulito;

import org.springframework.data.repository.CrudRepository;

public interface RewardRepository extends CrudRepository<Reward,Integer>{

	Reward findBydadefinire(String dadefinire);

}
