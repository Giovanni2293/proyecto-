import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
 
@Path("/p10")
public class Ruta {
	private String ruta;
	@GET
	@Produces("application/xml")
	public String r() {
 
		String stop1,stop2,coordenadas;
		stop1="N102S030 ";
		stop2="N20S2000 ";
		coordenadas=stop1+stop2;
		Double fahrenheit;
		Double celsius = 36.8;
		fahrenheit = ((celsius * 9) / 5) + 32;
        ruta=coordenadas;
		String result = "@Produces(\"application/xml\") Output: \n\nCoordenadas de la ruta Output: \n\n" + coordenadas;
		return "<p10>" + "<p10output>" + result + "</p10output>" + "</p10>";
	}
 
	@Path("{c}")
	@GET
	@Produces("application/xml")
	public String añadir(@PathParam("c") String c) {
        String stop1;
		stop1="N102S030 ";
        ruta=c+" "+ stop1;
		String result = "@Produces(\"application/xml\") Output: \n\n Coordenada añadida Output: \n\n" + c + "Ruta actualizada: "+ ruta;
		return "<añadirS>"+ "<añadirSoutput>" + result + "</añadirSoutput>" + "</añadirS>";
	}
}
