package ServidorApresentacao.sop;
import java.util.ArrayList;
import java.util.Map;

import junit.framework.Test;
import junit.framework.TestSuite;
import DataBeans.InfoExecutionCourse;
import DataBeans.InfoExecutionPeriod;
import DataBeans.InfoExecutionYear;
import DataBeans.InfoShift;
import ServidorAplicacao.GestorServicos;
import ServidorApresentacao.TestCasePresentationSopPortal;
import ServidorApresentacao.Action.sop.utils.SessionConstants;
import Util.TipoAula;
/**
 *@author tfc130
 */
public class EditarTurnoFormActionTest extends TestCasePresentationSopPortal {
  
  public static void main(java.lang.String[] args) {
    junit.textui.TestRunner.run(suite());
  }
   
  public static Test suite() {
    TestSuite suite = new TestSuite(EditarTurnoFormActionTest.class);
        
    return suite;
  }
  public void setUp() {
    super.setUp();
    // define ficheiro de configuracao Struts a utilizar
    setServletConfigFile("/WEB-INF/tests/web-sop.xml");
  }

  protected String getServletConfigFile() {
		  return "/WEB-INF/tests/web-sop.xml";
	  }
  public EditarTurnoFormActionTest(String testName) {
    super(testName);
  }

    public void testSuccessfulEditarTurno() {
		

    // define mapping de origem
    setRequestPathInfo("", "/editarTurnoForm");
    // Preenche campos do formulario
    addRequestParameter("nome", "NovoTurno1");
    addRequestParameter("lotacao",new Integer(50).toString());
    // coloca credenciais na sessao
	setAuthorizedUser();
    try {
    	GestorServicos gestor = GestorServicos.manager();
		InfoExecutionCourse iDE = new InfoExecutionCourse(
			"Trabalho Final de Curso I",
			"TFCI",
			"programa1",
			new Double(0),
			new Double(0),
			new Double(0),
			new Double(0),
			new InfoExecutionPeriod("2� Semestre",	new InfoExecutionYear("2002/2003")));
				
			getSession().setAttribute("infoDisciplinaExecucao",iDE);

    	Object argsLerTurnos[] = new Object[1];
    	argsLerTurnos[0] = iDE;
    	ArrayList infoTurnos = (ArrayList) gestor.executar(getAuthorizedUser(), "LerTurnosDeDisciplinaExecucao", argsLerTurnos);
    	getSession().setAttribute("infoTurnosDeDisciplinaExecucao", infoTurnos);

		InfoShift infoTurno1 = new InfoShift("turno1",new TipoAula(1),new Integer(100), iDE);
    	InfoShift infoTurno = (InfoShift) infoTurnos.get(infoTurnos.indexOf((InfoShift) infoTurno1));
    	getSession().setAttribute("infoTurno", infoTurno);

    } catch (Exception ex) {
    	System.out.println("Erro na invocacao do servico " + ex);
    }

    // invoca ac��o
    actionPerform();
    
    // verifica reencaminhamento
    verifyForward("Guardar");
    
    //verifica ausencia de erros
    verifyNoActionErrors();
  }
   
   
    public void testUnsuccessfulEditarTurno() {
		getSession().setAttribute(SessionConstants.SESSION_IS_VALID, SessionConstants.SESSION_IS_VALID);
    	
    setRequestPathInfo("", "/editarTurnoForm");

    addRequestParameter("nome", "turno2");
    addRequestParameter("lotacao",new Integer(100).toString());

    // coloca credenciais na sessao
setAuthorizedUser();
    try {
    	GestorServicos gestor = GestorServicos.manager();
		InfoExecutionCourse iDE = new InfoExecutionCourse(
			"Trabalho Final de Curso I",
			"TFCI",
			"programa1",
			new Double(0),
			new Double(0),
			new Double(0),
			new Double(0),
			new InfoExecutionPeriod("2� Semestre",	new InfoExecutionYear("2002/2003")));
				
			getSession().setAttribute("infoDisciplinaExecucao",iDE);

		Object argsLerTurnos[] = new Object[1];
		argsLerTurnos[0] = iDE;
		ArrayList infoTurnos = (ArrayList) gestor.executar(getAuthorizedUser(), "LerTurnosDeDisciplinaExecucao", argsLerTurnos);
		getSession().setAttribute("infoTurnosDeDisciplinaExecucao", infoTurnos);

		InfoShift infoTurno1 = new InfoShift("turno1",new TipoAula(1),new Integer(100), iDE);
		InfoShift infoTurno = (InfoShift) infoTurnos.get(infoTurnos.indexOf((InfoShift) infoTurno1));
		getSession().setAttribute("infoTurno", infoTurno);

    } catch (Exception ex) {
    	System.out.println("Erro na invocacao do servico " + ex);
    }

    actionPerform();
    verifyForwardPath("/editarTurno.jsp");
    
    verifyActionErrors(new String[] {"error.exception.existing"});
  }

	

	/* (non-Javadoc)
	 * @see ServidorApresentacao.TestCaseActionExecution#getRequestPathInfoPathAction()
	 */
	protected String getRequestPathInfoPathAction() {
		// 
		return null;
	}

	/* (non-Javadoc)
	 * @see ServidorApresentacao.TestCaseActionExecution#getRequestPathInfoNameAction()
	 */
	protected String getRequestPathInfoNameAction() {
		// 
		return null;
	}

	/* (non-Javadoc)
	 * @see ServidorApresentacao.TestCaseActionExecution#getItemsToPutInSessionForActionToBeTestedSuccessfuly()
	 */
	protected Map getItemsToPutInSessionForActionToBeTestedSuccessfuly() {
		// 
		return null;
	}

	/* (non-Javadoc)
	 * @see ServidorApresentacao.TestCaseActionExecution#getItemsToPutInSessionForActionToBeTestedUnsuccessfuly()
	 */
	protected Map getItemsToPutInSessionForActionToBeTestedUnsuccessfuly() {
		// 
		return null;
	}

	/* (non-Javadoc)
	 * @see ServidorApresentacao.TestCaseActionExecution#getItemsToPutInRequestForActionToBeTestedSuccessfuly()
	 */
	protected Map getItemsToPutInRequestForActionToBeTestedSuccessfuly() {
		// 
		return null;
	}

	/* (non-Javadoc)
	 * @see ServidorApresentacao.TestCaseActionExecution#getItemsToPutInRequestForActionToBeTestedUnsuccessfuly()
	 */
	protected Map getItemsToPutInRequestForActionToBeTestedUnsuccessfuly() {
		// 
		return null;
	}

	/* (non-Javadoc)
	 * @see ServidorApresentacao.TestCaseActionExecution#getExistingAttributesListToVerifyInSuccessfulExecution()
	 */
	protected Map getExistingAttributesListToVerifyInSuccessfulExecution() {
		// 
		return null;
	}

	/* (non-Javadoc)
	 * @see ServidorApresentacao.TestCaseActionExecution#getNonExistingAttributesListToVerifyInSuccessfulExecution()
	 */
	protected Map getNonExistingAttributesListToVerifyInSuccessfulExecution() {
		// 
		return null;
	}

	/* (non-Javadoc)
	 * @see ServidorApresentacao.TestCaseActionExecution#getExistingAttributesListToVerifyInUnsuccessfulExecution()
	 */
	protected Map getExistingAttributesListToVerifyInUnsuccessfulExecution() {
		// 
		return null;
	}

	/* (non-Javadoc)
	 * @see ServidorApresentacao.TestCaseActionExecution#getNonExistingAttributesListToVerifyInUnsuccessfulExecution()
	 */
	protected Map getNonExistingAttributesListToVerifyInUnsuccessfulExecution() {
		// 
		return null;
	}
  

  
}