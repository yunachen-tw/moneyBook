package com.yishan.moneybook.record;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface RecordRepository extends CrudRepository<Record, Integer> {
    public List<Record> findAllByOrderByDateAsc();
}
