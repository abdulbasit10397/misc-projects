package dynamodb;

import com.google.gson.Gson;

public class Main {
    public static void main(String[] args) {
        // Create a sample object
        DynamoDbTable pushNotificationToken = createSampleObject();

        // Convert the object to JSON
        Gson gson = new Gson();
        String json = gson.toJson(pushNotificationToken);
        System.out.println(json);

    }

    public static DynamoDbTable createSampleObject() {
        DynamoDbTable pushNotificationToken = new DynamoDbTable("sit_push_notification_token");
        pushNotificationToken.addAttribute("device_id", "S", "TEST-0003");
        pushNotificationToken.addAttribute("device_type", "S", "ios");
        pushNotificationToken.addAttribute("token", "S", "test-token-0000003001");
        return pushNotificationToken;
    }
}
