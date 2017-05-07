package lastMantisProject.helper;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.spbstu.pageObjectsFactory.entities.Issues;
import com.spbstu.pageObjectsFactory.entities.Users;
import lombok.SneakyThrows;
import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.lang.reflect.Type;
import java.net.URL;
import java.util.Map;

/**
 * Created by luck on 16.04.17.
 */
public class LoadFromResources {
    public static final String DATA_USERS_JSON = "users.json";
    public static final String DATA_ISSUES_JSON = "issue.json";
    private static Map<String, Users> users;
    private static Map<String, Issues> issues;

    static {
        try {
            loadUsers();
            loadIssues();
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    @SneakyThrows
    private static void loadUsers() throws IOException {
        String rawData = getRawDataFromUsers(DATA_USERS_JSON);
        Type type = new TypeToken<Map<String, Users>>(){}.getType();
        users = new Gson().fromJson(rawData, type);
    }

    private static String getRawDataFromUsers(String dataUsersJson) throws IOException {
        URL resource = LoadFromResources.
                class.
                getClassLoader().
                getResource(DATA_USERS_JSON);
        return IOUtils.toString(resource, "utf-8");
    }

    public static Users getUser(String key) {
        return users.get(key);
    }

    private static void loadIssues() throws IOException {
        String rawData = getRawDataFromIssues(DATA_ISSUES_JSON);
        Type type = new TypeToken<Map<String, Issues>>(){}.getType();
        issues = new Gson().fromJson(rawData, type);
    }

    private static String getRawDataFromIssues(String dataIssueJson) throws IOException {
        URL resource = LoadFromResources.class.getClassLoader().getResource(DATA_ISSUES_JSON);
        return IOUtils.toString(resource, "utf-8");
    }

    public static Issues getIssue(String key) {
        return issues.get(key);
    }

}
