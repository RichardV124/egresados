import org.caferrer.testdata.junit.TestDataUtil;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import co.edu.eam.ingesoft.desarrollo.egresados.persistencia.modelo.entidades.Ciudad;
import co.edu.eam.ingesoft.desarrollo.egresados.persistencia.modelo.entidades.Contacto;
import co.edu.eam.ingesoft.desarrollo.egresados.persistencia.modelo.entidades.Empresa;
import co.edu.eam.ingesoft.desarrollo.egresados.persistencia.modelo.entidades.SectorLaboral;
import co.edu.eam.ingesoft.desarrollo.egresados.persistencia.modelo.enumeraciones.TipoEmpresaEnum;
import co.edu.eam.ingesoft.desarrollo.logica.bo.BOContacto;
import co.edu.eam.ingesoft.desarrollo.logica.bo.BOEmpresa;
import co.edu.eam.ingesoft.desarrollo.logica.excepcion.ExcepcionNegocio;

public class BOEmpresaTest {

	private BOEmpresa boEmpresa;
	private BOContacto boContacto;

//	@BeforeClass
//	public static void setUp() {
//		TestDataUtil.ejecutarSQL("sqlTest/BOEmpresaTest-add.sql");
//	}

	@Test
	public void crearEmpresaTest() {
		boEmpresa = new BOEmpresa();
		boContacto = new BOContacto();

		try {
			 Contacto c = new Contacto();
			 c.setNitEmpresa("123");
			 c.setNombreCompleto("Eliana Rodriguez");
			 c.setCorreo("elcorreo@gmail.com");
			 c.setCargoEmpresa("Rector");
			 c.setTelefono("123123441");
			
			 Empresa e = new Empresa();
			 e.setRazonSocial("EAM");
			 e.setNit("123");
			 SectorLaboral sector = new SectorLaboral();
			 sector.setId(1);
			 sector.setNombre("Construccion");
			 e.setSector(sector);
			 e.setTipoEmpresa(TipoEmpresaEnum.PRIVADA);
			 Ciudad ci = new Ciudad();
			 ci.setId(2);
			 ci.setNombre("Medelliin");
			 e.setCiudad(ci);
			 e.setDireccion("Av Bolivar");
			 e.setTel("123331444");
			 e.setFax("555566");
			 e.setSitioWeb("www.sitioweb.com");
			 c.setEmpresa(e);
			boEmpresa.crear(e);
			Empresa emp = boEmpresa.buscar("123");
			// Assert.assertEquals(c.getCodigo(), cur.getCodigo());
			Assert.assertNotNull(emp);
		} catch (ExcepcionNegocio e1) {
			System.out.println(e1.getMessage());

		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail();
		}

	}

	@Test
	public void buscarEmpresaTest() throws Exception {
		boEmpresa = new BOEmpresa();
		try {
			Empresa e = boEmpresa.buscar("123");
			System.out.println("----");
			// Assert.assertEquals("123", e.getNit());
			Assert.assertNotNull(e);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}
	}

	@Test
	public void editarEmpresaTest() {

		boEmpresa = new BOEmpresa();
		
		try {
			Empresa e = boEmpresa.buscar("123");
			e.setRazonSocial("Razon social editada");
			boEmpresa.editar(e);
			Empresa emp = boEmpresa.buscar("123");
			Assert.assertEquals(emp.getRazonSocial(), e.getRazonSocial());

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@AfterClass
	public static void afterClass() {

		TestDataUtil.ejecutarSQL("sqlTest/BOEmpresaTest-del.sql");

	}

}
