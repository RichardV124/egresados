import org.caferrer.testdata.junit.TestDataUtil;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import co.edu.eam.ingesoft.desarrollo.egresados.persistencia.modelo.entidades.Facultad;
import co.edu.eam.ingesoft.desarrollo.egresados.persistencia.modelo.entidades.Programa;
import co.edu.eam.ingesoft.desarrollo.logica.bo.BOFacultad;
import co.edu.eam.ingesoft.desarrollo.logica.bo.BOPrograma;
import co.edu.eam.ingesoft.desarrollo.logica.excepcion.ExcepcionNegocio;

public class BOProgramaTest {

	private BOPrograma boPrograma;
	private BOFacultad boFacultad;

	@BeforeClass
	public static void setUp() {
		TestDataUtil.ejecutarSQL("sqlTest/BOProgramaTest-add.sql");
	}

	@Test
	public void crearFacultadTest() {
		boPrograma = new BOPrograma();
		boFacultad = new BOFacultad();
		try {
			Programa p = new Programa();
			p.setCodigo("123");
			p.setNombre("Diseño grafico ");
			p.setDescripcion("este programa de diseñadores");
			Facultad fac = boFacultad.buscar("123");
			p.setFacultad(fac);
			boPrograma.crear(p);
			Programa pro = boPrograma.buscar("123");
			// Assert.assertEquals(c.getCodigo(), cur.getCodigo());
			Assert.assertNotNull(pro);
		} catch (ExcepcionNegocio e1) {
			System.out.println(e1.getMessage());

		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail();
		}

	}

	 @Test
	 public void buscarProgramaTest() throws Exception {
	 boPrograma = new BOPrograma();
	 Programa p = boPrograma.buscar("123");
	 System.out.println("----");
	 Assert.assertEquals("123", p.getCodigo());
	
	 }
	//
	@Test
	public void editarProgramaTest() {

		boPrograma = new BOPrograma();
		try {
			Programa p = boPrograma.buscar("123");
			p.setNombre("Barros");
			boPrograma.editar(p);
			Programa pro = boPrograma.buscar("123");
			Assert.assertEquals(pro.getNombre(), p.getNombre());

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@AfterClass
	public static void afterClass() {

		TestDataUtil.ejecutarSQL("sqlTest/BOProgramaTest-del.sql");

	}

}
