package co.com.jrojas.test.springRestAngular.presentacion.json.interfaces;

public interface InterfaceJsonTransformer {

	public String toJson(Object data);
	public Object fromJson(String json, Class clazz);
}
