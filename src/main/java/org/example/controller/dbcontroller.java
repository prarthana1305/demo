package org.example.controller;



import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/db")
public class DatabaseController {
    @Autowired
    DatabaseService databaseService;

    @PostMapping("/connect")
    public Map<String, String> connectToDatabase(@RequestBody DbConnectDTO connectionString) {
        return databaseService.connectAndInitializeDb(connectionString);
    }

    @GetMapping("/fetch-tables")
    public List<String> fetchTables() {
        return databaseService.getTableNames();
    }

    @GetMapping("/fetch-columns/{tableName}")
    public Map<String, Object> getColumnNames(@PathVariable String tableName) {
        return databaseService.getColumnNames(tableName);
    }


}

