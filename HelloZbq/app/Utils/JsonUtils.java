package Utils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

public class JsonUtils {
private static ObjectMapper objectMapper = new ObjectMapper();
	
	static{
		objectMapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
        objectMapper.disable(SerializationFeature.FAIL_ON_EMPTY_BEANS);
	}
	
	public static String toJsonString(Object object){
		try {
			String json = objectMapper.writeValueAsString(object);
			return json;
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return "";
	}
	
	public static JsonNode toJsonNode(Object object){
		try {
			String json = objectMapper.writeValueAsString(object);
			JsonNode jsonNode = objectMapper.readTree(json);
			return jsonNode;
		} catch (Exception e) {
			e.printStackTrace();
		}		
		return null;
	}
	
	public static JsonNode toJsonNode(String json){
		try {
			JsonNode jsonNode = objectMapper.readTree(json);
			return jsonNode;
		} catch (Exception e) {
			e.printStackTrace();
		}		
		return null;
	}
	
	public static <T> T toObject(String json,Class<T> clazz){
		try {
			T object = objectMapper.readValue(json, clazz);
			return object;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static <T> T toObject(JsonNode jsonNode,Class<T> clazz){
		try {
			T object = objectMapper.readValue(jsonNode.toString(), clazz);
			return object;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static <T> T getNodeToObject(JsonNode json, String nodeName, Class<T> clazz){
		try{
			JsonNode node = json.findPath(nodeName);
			T t = objectMapper.readValue(node.toString(), clazz);
			return t;
		}catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}
	
	public static <T> T getNodeToObject(String json, String nodeName, Class<T> clazz){
		try{
			String nodeJson = getNodeJson(json, nodeName);
			return objectMapper.readValue(nodeJson, clazz);
		}catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}
	
	public static <T> List<T> getNodeToList(JsonNode json, String nodeName, Class<T> clazz){
		try{
			JsonNode jsonNode = json.findPath(nodeName);
			Iterator<JsonNode> ite = jsonNode.elements();
			if(ite==null){
				return Collections.emptyList();
			}
			
			List<T> list = new ArrayList<T>();
			while(ite.hasNext()){
				JsonNode nextNode = ite.next();
				T t = toObject(nextNode, clazz);
				list.add(t);
			}
			return list;
		}catch(Exception e){
			e.printStackTrace();
		}
		return Collections.emptyList();
	}
	
	public static <T> List<T> getNodeToList(String json, String nodeName, Class<T> clazz){
		try{
			return getNodeToList(toJsonNode(json), nodeName, clazz);
		}catch(Exception e){
			e.printStackTrace();
		}
		return Collections.emptyList();
	}
	
	public static String  getNodeJson(JsonNode json, String nodeName){
		try{
			String jsonNode =  json.findPath(nodeName).toString();
			return jsonNode;
		}catch(Exception e){
			e.printStackTrace();
		}
		return "";
	}
	
	public static String  getNodeJson(String json, String nodeName){
		try{
			return getNodeJson(toJsonNode(json), nodeName);
		}catch(Exception e){
			e.printStackTrace();
		}
		return "";
	}
	
	public static <T> List<T> toList(String json,Class<T> clazz){
		try{
			JsonNode node = toJsonNode(json);
			return toList(node, clazz);
		}catch(Exception e){
			e.printStackTrace();
		}
		return Collections.emptyList();
	}
	
	public static <T> List<T> toList(JsonNode json,Class<T> clazz){
		try{
			Iterator<JsonNode> ite = json.elements();
			if(ite==null){
				return Collections.emptyList();
			}
			
			List<T> list = new ArrayList<T>();
			while(ite.hasNext()){
				JsonNode nextNode = ite.next();
				T t = toObject(nextNode, clazz);
				list.add(t);
			}
			
			return list;
		}catch(Exception e){
			e.printStackTrace();
		}
		return Collections.emptyList();
	}
}
