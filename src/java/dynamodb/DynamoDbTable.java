package dynamodb;

import java.util.HashMap;
import java.util.Map;

public class DynamoDbTable {
    private String TableName;
    private Map<String, Map<String, String>> Item;

    public DynamoDbTable(String tableName) {
        this.TableName = tableName;
        this.Item = new HashMap<>();
    }

    public String getTableName() {
        return TableName;
    }

    public void setTableName(String tableName) {
        this.TableName = tableName;
    }

    public Map<String, Map<String, String>> getItem() {
        return Item;
    }

    public void setItem(Map<String, Map<String, String>> item) {
        this.Item = item;
    }

    public void addAttribute(String attributeName, String type, String value) {
        Map<String, String> attribute = new HashMap<>();
        attribute.put(type, value);
        this.Item.put(attributeName, attribute);
    }
}
