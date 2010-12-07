package net.sourceforge.fenixedu.domain.personnelSection.contracts;

import net.sourceforge.fenixedu.domain.RootDomainObject;
import pt.ist.fenixWebFramework.services.Service;
import pt.utl.ist.fenix.tools.util.i18n.MultiLanguageString;

public class ContractSituation extends ContractSituation_Base {

    public ContractSituation(final String giafId, final MultiLanguageString name, final Boolean endSituation,
	    final Boolean serviceExemption, final Boolean medicalSituation) {
	super();
	setRootDomainObject(RootDomainObject.getInstance());
	setGiafId(giafId);
	setName(name);
	setEndSituation(endSituation);
	setServiceExemption(serviceExemption);
	setMedicalSituation(medicalSituation);
    }

    @Service
    public void edit(final MultiLanguageString name, final Boolean endSituation, final Boolean serviceExemption) {
	setName(name);
	setEndSituation(endSituation);
	setServiceExemption(serviceExemption);
    }

}
