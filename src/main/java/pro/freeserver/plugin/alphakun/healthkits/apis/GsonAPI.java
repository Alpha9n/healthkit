package pro.freeserver.plugin.alphakun.healthkits.apis;

import com.google.gson.Gson;
import jdk.nashorn.internal.codegen.types.Type;
import pro.freeserver.plugin.alphakun.healthkits.healdata.HealthKitData;

public class GsonAPI {

    private static Gson gson = new Gson();

    public static String dataSerialize(HealthKitData data){
        return gson.toJson(data);
    }

    public static HealthKitData dataDeSerialize(String data){
        return gson.fromJson(data,HealthKitData.class);
    }
}
