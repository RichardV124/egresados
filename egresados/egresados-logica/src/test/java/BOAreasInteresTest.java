import org.caferrer.testdata.junit.TestDataUtil;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Test;

import co.edu.eam.ingesoft.desarrollo.egresados.persistencia.modelo.entidades.AreaInteres;
import co.edu.eam.ingesoft.desarrollo.logica.bo.BOAreaInteres;
import co.edu.eam.ingesoft.desarrollo.logica.excepcion.ExcepcionNegocio;

public class BOAreasInteresTest {

	private BOAreaInteres boArea;

//	@BeforeClass
//	public static void setUp() {
//		TestDataUtil.ejecutarSQL("sqlTest/BOAreasInteresTest-add.sql");
//	}

	@Test
	public void crearAreaInteresTest() {
		boArea = new BOAreaInteres();

		try {
			AreaInteres area = new AreaInteres();
			area.setCodigo("123");
			area.setNombre("El area de interes ");
			area.setDescripcion("esta area de interes para los interesados");
			boArea.crear(area);
			AreaInteres ar = boArea.buscar("123");
			// Assert.assertEquals(c.getCodigo(), cur.getCodigo());
			Assert.assertNotNull(ar);
		} catch (ExcepcionNegocio e1) {
			System.out.println(e1.getMessage());

		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail();
		}

	}

	@Test
	public void buscarAreaInteresTest() {
		boArea = new BOAreaInteres();
		try {
			AreaInteres a = boArea.buscar("123");
			System.out.println("----");
			Assert.assertNotNull(a);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	public void editarAreaInteresTest() {

		boArea = new BOAreaInteres();

		try {
			AreaInteres a = boArea.buscar("123");
			a.setNombre("AreaEditada");
			boArea.editar(a);
			AreaInteres ar = boArea.buscar("123");
			Assert.assertEquals(ar.getNombre(), a.getNombre());

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@AfterClass
	public static void afterClass() {

		TestDataUtil.ejecutarSQL("sqlTest/BOAreasInteresTest-del.sql");

	}
}
