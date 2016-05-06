
//Buffers para lectura del contenido de fichero.
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.FileReader;
import java.io.IOException;

//import javax.print.attribute.standard.Media;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import javax.ws.rs.Consumes;
import javax.ws.rs.core.MediaType;

import java.lang.Math;

import org.json.JSONObject;
import org.json.JSONArray;
import org.json.JSONException;

@Path("/")
public class Ruta {
	private String ruta;

	@Path("/distR")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public JSONObject calcularDistancia(InputStream incomingData) {

		String datos = leerArchivo(incomingData);//lee el json que envian y genera un string
		JSONObject j = stringToJson(datos); //convierte el string a json
		calcular(j);//duda??
		return null;
	}

	@Path("/posicion")
	@GET
	@Produces("application/json")
	public String asda() {
		String result = "{" + "nombre:\"Luis\"" + "}";
		return result;
	}

	private double calcular(JSONObject entrada) {
		/*JSONObject ruta1,ruta2;
		JSONArray rutas = new JSONArray();
		rutas=entrada.getJSONArray("distancia");
		ruta1=rutas.getJSONObject(0);
		ruta2=rutas.getJSONObject(1);
		double lat1=ruta1.getDouble("latitud");
		double lng1=ruta1.getDouble("longitud");
		System.out.println(lat1);
		System.out.println(lng1);
		double lat2;
		double lng2;
		double radioTierra = 6371;// en kilómetros
		double dLat = Math.toRadians(lat2 - lat1);
		double dLng = Math.toRadians(lng2 - lng1);
		double sindLat = Math.sin(dLat / 2);
		double sindLng = Math.sin(dLng / 2);
		double va1 = Math.pow(sindLat, 2)
				+ Math.pow(sindLng, 2) * Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2));
		double va2 = 2 * Math.atan2(Math.sqrt(va1), Math.sqrt(1 - va1));
		double distancia = radioTierra * va2;*/
		return 0;
	}

	private String leerArchivo(InputStream incomingData) {
		StringBuilder constructor = new StringBuilder();
		try {
			BufferedReader in = new BufferedReader(new InputStreamReader(incomingData));
			String line = null;
			while ((line = in.readLine()) != null) {
				constructor.append(line);
				constructor.append("\n");
			}
		} catch (Exception e) {
			System.out.println("Error Parsing: - ");
		}
		return constructor.toString();
	}
    private JSONObject stringToJson(String entrada)
    {
    	JSONObject objeto = new JSONObject(entrada);
    	return objeto;
    }
}
