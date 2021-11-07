package com.yishan.moneybook.record;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.annotation.PostConstruct;
import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@RequestMapping(value = "/records", produces = MediaType.APPLICATION_JSON_VALUE)
public class RecordController {
    // testing data list
    private final List<Record> recordDB = new ArrayList<>();

    @PostConstruct
    private void initDB() {
        recordDB.add(new Record(0, 90, "牛肉麵", "2021/10/25", "牛肉麵好吃"));
        recordDB.add(new Record(1, 60, "鍋貼", "2021/10/27", "八方雲集"));
        recordDB.add(new Record(2, 120, "小火鍋", "2021/11/01", "牛肉麵好吃"));
        recordDB.add(new Record(3, 65, "蘿蔔糕套餐", "2021/11/03", "cp值很高！"));
        recordDB.add(new Record(4, 150, "大補鐵板燒", "2021/11/04", "炒牛肉+高麗菜+飯"));
    }

    // 取得所有紀錄
    @GetMapping
    public ResponseEntity<List<Record>> getRecordsAll() {
        List<Record> records = recordDB.stream().collect(Collectors.toList());
        if (!records.isEmpty()) {
            return ResponseEntity.ok().body(records);
        } else {
            // if no data, return 404 not found
            return ResponseEntity.notFound().build();
        }
    }

    // 取得{id}的紀錄
    @GetMapping("/{id}")
    public ResponseEntity<Record> getRecordById(@PathVariable("id") int id) {
        Optional<Record> recordOptional = recordDB.stream().filter(record -> record.getId().equals(id)).findFirst();
        if (recordOptional.isPresent()) {
            Record record = recordOptional.get();
            return ResponseEntity.ok().body(record);
        } else {
            // if no data, return 404 not found
            return ResponseEntity.notFound().build();
        }
    }

    // 新增紀錄
    @PostMapping
    public ResponseEntity<Record> addRecord(@Valid @RequestBody Record request) {
        boolean isIdDuplicated = recordDB.stream().anyMatch(record -> record.getId().equals(request.getId()));
        // 相同 id 不能重複新增
        if (isIdDuplicated) {
            return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).build();
        }

        Record record = new Record();
        record.setId(request.getId());
        record.setCost(request.getCost());
        record.setTitle(request.getTitle());
        record.setDate(request.getDate());
        record.setDetail(request.getDetail());
        recordDB.add(record);

        // 建立 URI 指向這次新增的資源
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(record.getId())
                .toUri();

        // 新增完成 return 201 created
        return ResponseEntity.created(location).body(record);
    }

    // 修改{id}的紀錄
    @PutMapping("/{id}")
    public ResponseEntity<Record> editRecord(@Valid @PathVariable("id") int id, @RequestBody Record request) {
        Record record = new Record();
        return ResponseEntity.ok(record);
    }

    // 刪除{id}的紀錄
    @DeleteMapping("/{id}")
    public ResponseEntity<Record> deleteRecord(@RequestBody Record request) {
        Record record = new Record();
        return ResponseEntity.ok(record);
    }

    
}
