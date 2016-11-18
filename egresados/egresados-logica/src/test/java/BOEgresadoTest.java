
import org.caferrer.testdata.junit.TestDataUtil;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import co.edu.eam.ingesoft.desarrollo.egresados.persistencia.modelo.entidades.Egresado;
import co.edu.eam.ingesoft.desarrollo.egresados.persistencia.modelo.entidades.Facultad;
import co.edu.eam.ingesoft.desarrollo.egresados.persistencia.modelo.entidades.InformacionAcademica;
import co.edu.eam.ingesoft.desarrollo.egresados.persistencia.modelo.entidades.InformacionLaboral;
import co.edu.eam.ingesoft.desarrollo.egresados.persistencia.modelo.entidades.Programa;
import co.edu.eam.ingesoft.desarrollo.egresados.persistencia.modelo.entidades.SectorLaboral;
import co.edu.eam.ingesoft.desarrollo.egresados.persistencia.modelo.enumeraciones.GeneroEnum;
import co.edu.eam.ingesoft.desarrollo.egresados.persistencia.modelo.enumeraciones.MaximoNivelEduEnum;
import co.edu.eam.ingesoft.desarrollo.egresados.persistencia.modelo.enumeraciones.MesEnum;
import co.edu.eam.ingesoft.desarrollo.egresados.persistencia.modelo.enumeraciones.SituacionLaboralEnum;
import co.edu.eam.ingesoft.desarrollo.egresados.persistencia.modelo.enumeraciones.TipoCorreoEnum;
import co.edu.eam.ingesoft.desarrollo.egresados.persistencia.modelo.enumeraciones.TipoDocumentoEnum;
import co.edu.eam.ingesoft.desarrollo.egresados.persistencia.modelo.enumeraciones.TipoEmpresaEnum;
import co.edu.eam.ingesoft.desarrollo.egresados.persistencia.modelo.enumeraciones.TipoTelefonoEnum;
import co.edu.eam.ingesoft.desarrollo.logica.bo.BOEgresado;
import co.edu.eam.ingesoft.desarrollo.logica.bo.BOFacultad;
import co.edu.eam.ingesoft.desarrollo.logica.bo.BOPrograma;

public class BOEgresadoTest {

	private BOEgresado boEgresado;
	private BOFacultad boFacultad;
	private BOPrograma boPrograma;

	@BeforeClass
	public static void setUp() {
		TestDataUtil.ejecutarSQL("sqlTest/BOEgresadoTest-add.sql");
	}

	@Test
	public void crearEgresadoTest() {

		boEgresado = new BOEgresado();
		boFacultad = new BOFacultad();
		boPrograma = new BOPrograma();

		try {
			//Egresado e = boEgresado.buscar("123");
			 
			
			Egresado e = new Egresado();
			 e.setNombre("Andres");
			 e.setPrimerApellido("Lugo");
			 e.setSegundoApellido("Bolivar");
			 e.setTelefono("7491515");
			 e.setTipoTelefono(TipoTelefonoEnum.PERSONAL);
			 e.setTipoDocumento(TipoDocumentoEnum.CEDULA);
			 e.setCedula("1");
			 e.setGenero(GeneroEnum.MASCULINO);
			 e.setEmail("correoegresado@gmail.com");
			 e.setTipoEmail(TipoCorreoEnum.CORPORATIVO);
			
			 InformacionAcademica infoAcademi = new InformacionAcademica();
			 
			 Facultad fac = boFacultad.buscar("123");
			 infoAcademi.setFacultad(fac);
			 
			 Programa pro = boPrograma.buscar("123");
			 infoAcademi.setPrograma(pro);
			 e.setPrograma(pro);
			
			 infoAcademi.setNivelAcademico("4 semestre");
			 infoAcademi.setFechaGrado(1);
			 infoAcademi.setNumeroDiploma("56454");
			 infoAcademi.setMaximoNivelEducativo(MaximoNivelEduEnum.TECNICO);
			 infoAcademi.setCedEgresado("1");
			 infoAcademi.setMesGrado(MesEnum.ENERO);
			 e.setInfoAcademica(infoAcademi);
			
			 InformacionLaboral infoLaboral = new InformacionLaboral();
			 infoLaboral.setSituacionAct(SituacionLaboralEnum.EMPRESARIO);
			 infoLaboral.setTipoEmpresa(TipoEmpresaEnum.PUBLICA);
			 
			 SectorLaboral sl = new SectorLaboral();
			 sl.setId(1);
			 sl.setNombre("Legal");
			 infoLaboral.setSectLaboral(sl);
			 infoLaboral.setCedEgresado("1");
			 e.setInfoLaboral(infoLaboral);
			 infoAcademi.setEgresado(e);
			 infoLaboral.setEgresado(e);
			
			boEgresado.crear(e);
			Egresado egre = boEgresado.buscar("1");

			Assert.assertNotNull(egre);

		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail();
		}

	}

	@Test
	public void buscarEgresadoTest() throws Exception {
		boEgresado = new BOEgresado();
		try {
			Egresado e = boEgresado.buscar("1");
			System.out.println("----");
			Assert.assertNotNull(e);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	public void editarEgresadoTest() {

		boEgresado = new BOEgresado();
		try {
			 Egresado e = boEgresado.buscar("1");
			 e.setNombre("Nombre editado");
			 boEgresado.editar(e);
			 Egresado egre = boEgresado.buscar("1");
			 Assert.assertEquals(egre.getNombre(), e.getNombre());

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@AfterClass
	public static void afterClass() {

		TestDataUtil.ejecutarSQL("sqlTest/BOEgresadoTest-del.sql");

	}
}
