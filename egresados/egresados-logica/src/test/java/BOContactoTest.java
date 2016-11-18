import org.caferrer.testdata.junit.TestDataUtil;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import co.edu.eam.ingesoft.desarrollo.egresados.persistencia.modelo.entidades.Contacto;
import co.edu.eam.ingesoft.desarrollo.egresados.persistencia.modelo.entidades.Empresa;
import co.edu.eam.ingesoft.desarrollo.logica.bo.BOContacto;
import co.edu.eam.ingesoft.desarrollo.logica.bo.BOEmpresa;
import co.edu.eam.ingesoft.desarrollo.logica.excepcion.ExcepcionNegocio;

public class BOContactoTest {

	private BOEmpresa boEmpresa;
	private BOContacto boContacto;

	@BeforeClass
	public static void setUp() {
		TestDataUtil.ejecutarSQL("sqlTest/BOContactoTest-add.sql");
	}

	@Test
	public void crearEmpresaTest() {
		boContacto = new BOContacto();
		boEmpresa = new BOEmpresa();
		// boContacto = new BOContacto();

		try {
			Empresa e = boEmpresa.buscar("1111");
			Contacto c = new Contacto();
			c.setNitEmpresa("1111");
			c.setNombreCompleto("Eliana Rodriguez");
			c.setCorreo("elcorreo@hotmail.com");
			c.setCargoEmpresa("Rector");
			c.setTelefono("123123441");
			c.setEmpresa(e);
			

			boContacto.crear(c);
			// boEmpresa.crear(e);
			Contacto conta = boContacto.buscar("1111");
			// Assert.assertEquals(c.getCodigo(), cur.getCodigo());
			Assert.assertNotNull(conta);
		} catch (ExcepcionNegocio e1) {
			System.out.println(e1.getMessage());

		} catch (Exception e) {
			e.printStackTrace();
			// Assert.fail();
		}

	}

	@Test
	public void buscarContactoTest() throws Exception {

		boContacto = new BOContacto();
		try {
			Contacto c = boContacto.buscar("1111");
			System.out.println("----");
			Assert.assertNotNull(c);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}

	}

	@Test
	public void editarContactoTest() {

		boContacto = new BOContacto();

		try {
			Contacto c = boContacto.buscar("1111");
			c.setNombreCompleto("Nombre editado");
			boContacto.editar(c);
			Contacto con = boContacto.buscar("1111");
			Assert.assertEquals(con.getNombreCompleto(), c.getNombreCompleto());

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@AfterClass
	public static void afterClass() {

		TestDataUtil.ejecutarSQL("sqlTest/BOContactoTest-del.sql");

	}

}
