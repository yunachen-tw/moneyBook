- GET     /records        取得所有資料
- GET     /records/{id}   取得 id 的資料
- POST    /records        新增一筆紀錄
    - 資料格式
    ```
    {
        "cost": Integer,
        "title": String,
        "date": String,
        "detail": String
    }
    ```
    - 範例
    ```
    {
        "cost": 101,
        "title": "夜市牛排",
        "date": "2021/10/05",
        "detail": "便宜好吃cp高!"
    }
    ```
- PUT     /records/{id}   修改一筆紀錄
    - 資料格式
    ```
    {
        "cost": Integer,
        "title": String,
        "date": String,
        "detail": String
    }
    ```
    - 範例
    ```
    {
        "cost": 101,
        "title": "夜市牛排",
        "date": "2021/10/05",
        "detail": "便宜好吃cp高!"
    }
    ```
- DELETE  /records/{id}   刪除 id 的資料
