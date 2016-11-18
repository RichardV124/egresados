import org.caferrer.testdata.junit.TestDataUtil;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import co.edu.eam.ingesoft.desarrollo.egresados.persistencia.modelo.entidades.Facultad;
import co.edu.eam.ingesoft.desarrollo.logica.bo.BOFacultad;
import co.edu.eam.ingesoft.desarrollo.logica.excepcion.ExcepcionNegocio;

public class BOFacultadTest {

	private BOFacultad boFacultad;

//	 @BeforeClass
//	 public static void beforeClass(){
//	 TestDataUtil.ejecutarSQL("sqlTest/BOFacultadTest-add.sql");
//	 }
	
	@Before
	public void setUp(){
		boFacultad = new BOFacultad();
	}
	
	@Test
	public void crearFacultadTest() {
	
		try {
			Facultad f = new Facultad();
			f.setCodigo("123");
			f.setNombre("Los diseñadores");
			f.setDescripcion("esta facultad de diseñadores wchos");
			boFacultad.crear(f);
			Facultad fac = boFacultad.buscar("123");
			// Assert.assertEquals(c.getCodigo(), cur.getCodigo());
			Assert.assertNotNull(fac);
		} catch (ExcepcionNegocio e1) {
			System.out.println(e1.getMessage());

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Test
	public void buscarFacultadTest() throws Exception {

		 try {
		Facultad e = boFacultad.buscar("123");
		System.out.println("----");
		Assert.assertEquals("123", e.getCodigo());
		 } catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}

	@Test
	public void editarFacultadTest() {

		try {
			Facultad f = boFacultad.buscar("123");
			f.setNombre("Barros");
			boFacultad.editar(f);
			Facultad fa = boFacultad.buscar("123");
			Assert.assertEquals(fa.getNombre(), f.getNombre());

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@AfterClass
	public static void afterClass(){
		
		TestDataUtil.ejecutarSQL("sqlTest/BOFacultadTest-del.sql");
		
	}

}
