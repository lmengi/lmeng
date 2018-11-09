package com.lmeng.utils;


import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.JavaType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Map;

public class JsonUtils {
    private static Logger logger = LoggerFactory.getLogger(JsonUtils.class);
    private static ObjectMapper om = new ObjectMapper();

    public JsonUtils() {

    }

    public static String toJson(Object obj) {
        return toJson(obj,false);
    }


    public static String toJson(Object obj, boolean pretty) {
        if(pretty) {
            try {
                return om.writerWithDefaultPrettyPrinter().writeValueAsString(obj);
            } catch (Exception var4) {
                logger.error(var4.getMessage(),var4);
            }
        }

        try {
            return om.writeValueAsString(obj);
        } catch (Exception var3) {
            logger.error(var3.getMessage(),var3);
            return null;
        }
    }

    public static JsonNode getJsonNode(String jsonString, String key) {
        if(jsonString != null && !"".equals(jsonString.trim())) {
            try {
                return om.readTree(jsonString).get(key);
            } catch (Exception var4) {
                logger.error(var4.getMessage(),var4);
                return null;
            }
        }
        return null;
    }

    public static String getString(String jsonString, String key) {
        return getString(jsonString, key, "");
    }

    public static String getString(String jsonString, String key, String defaultValue) {
        JsonNode node = getJsonNode(jsonString, key);
        return node == null?defaultValue:node.asText();
    }

    public static int getInt(String jsonString, String key) {
        return getInt(jsonString, key, 0);
    }

    public static int getInt(String jsonString, String key, int defaultValue) {
        JsonNode node = getJsonNode(jsonString, key);
        return node == null?defaultValue:node.asInt();
    }

    public static List<Integer> getIntList(String jsonString, String key) {
        JsonNode node = getJsonNode(jsonString,key);
        if(node == null) {
            return null;
        }

        try {
            return (List)om.readValue(node,List.class);
        } catch (Exception var2) {
            logger.error(var2.getMessage(),var2);
            return null;
        }
    }

    public static List<String> getStringList(String jsonString, String key) {
        JsonNode node = getJsonNode(jsonString, key);
        if(node == null) {
            return null;
        }

        try {
            return (List)om.readValue(node, List.class);
        } catch (Exception var4) {
            logger.error(var4.getMessage(), var4);
            return null;
        }
    }

    public static JsonNode getNode(String jsonString, String[] keys) {
        JsonNode node = getJsonNode(jsonString, keys[0]);

        for(int i = 1; keys.length > 1 && i < keys.length; ++i) {
            if(node == null) {
                return null;
            }

            node = node.findPath(keys[i]);
        }
        return node;
    }

    public static Map<?, ?> getMap(String jsonString, String key) {
        JsonNode node = getJsonNode(jsonString, key);
        if(node == null) {
            return null;
        }

        try {
            return (Map)om.readValue(node, Map.class);
        } catch (Exception var4) {
            logger.error(var4.getMessage(), var4);
            return null;
        }
    }

    public static <T> Object copyObject(T object) {
        if(object == null) {
            return null;
        }
        String jsonString = toJson(object);
        Class cls = object.getClass();
        return get(jsonString, cls);
    }

    public static <T> T get(String jsonString, Class<T> cls) {
        try {
            return om.readValue(jsonString, cls);
        } catch (Exception var3) {
            logger.error(var3.getMessage(), var3);
            return null;
        }
    }

    public static <T> T get(Object jsonString, Class<T> cls) {
        try {
            return om.readValue(jsonString.toString(), cls);
        } catch (Exception var3) {
            logger.error(var3.getMessage(), var3);
            return null;
        }
    }

    public static <T> List<T> getList(String jsonString, Class<T> cls) {
        try {
            JavaType e = om.getTypeFactory().constructParametricType(List.class, new Class[]{cls});
            return (List)om.readValue(jsonString, e);
        } catch (Exception var3) {
            logger.error(var3.getMessage(), var3);
            return null;
        }
    }
}

